/*
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package org.zowe.apiml.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.apache.http.client.utils.URIBuilder;
import org.zowe.apiml.util.config.ConfigReader;
import org.zowe.apiml.util.config.DiscoveryServiceConfiguration;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.zowe.apiml.util.SecurityUtils.getConfiguredSslConfig;

@RequiredArgsConstructor
public class DiscoveryRequests {
    private DiscoveryServiceConfiguration discoveryServiceConfiguration = ConfigReader.environmentConfiguration().getDiscoveryServiceConfiguration();
    private final String scheme = discoveryServiceConfiguration.getScheme();
    private final String host;
    private final int port = discoveryServiceConfiguration.getPort();

    public boolean isApplicationRegistered(String appName) {
        return isApplicationRegistered(appName, Optional.empty());
    }
    public boolean isApplicationRegistered(String appName, Optional<String> instanceId) {
        RestAssured.config = RestAssured.config().sslConfig(getConfiguredSslConfig());

        try {
            JsonPath result = given()
                .accept(ContentType.JSON)
            .when()
                .get(getDiscoveryUriWithPath("/eureka/apps"))
            .then()
                .statusCode(is(HttpStatus.SC_OK))
                .extract()
                .body()
                .jsonPath();

            List<ArrayList> appNames = result.get("applications.application.instance.app");
            AtomicBoolean isRegistered = new AtomicBoolean(false);
            appNames.stream()
                .flatMap(Collection::stream)
                .forEach(application -> {
                    if (application.equals(appName.toUpperCase())) {
                        isRegistered.set(true);
                    }
                });

            if (instanceId.isPresent()) {
                isRegistered.set(false);
                List<ArrayList> instanceIds = result.get("applications.application.instance.instanceId");
                instanceIds.stream()
                    .flatMap(Collection::stream)
                    .forEach(instance -> {
                        if (instance.equals(instanceId)) {
                            isRegistered.set(true);
                        }
                    });
            }

            return isRegistered.get();

        } catch (Exception e) {
            return false;
        }
    }

    private URI getDiscoveryUriWithPath(String path) throws URISyntaxException {
        return new URIBuilder()
            .setScheme(scheme)
            .setHost(host)
            .setPort(port)
            .setPath(path)
            .build();
    }
}
