# API Mediation Layer Changelog

All notable changes to the Zowe API Mediation Layer package will be documented in this file.

## `1.23.0 (2021-07-26)`

* Feature:  Authentication based server-side load balancing. A service can now configure itself with the Authentication based load balancing scheme whereby a user is directed to the same instance of a service for a given period of time (#1576) ([4ad382e](https://github.com/zowe/api-layer/commit/4ad382e)), closes [#1576](https://github.com/zowe/api-layer/issues/1576).
* Feature:  Catalog: authenticate with client certificate for /apidoc/** endpoints (#1568) ([79dedfd](https://github.com/zowe/api-layer/commit/79dedfd)), closes [#1568](https://github.com/zowe/api-layer/issues/1568)
* Feature:  Gateway: authenticate with client certificate for /gateway/services/** endpoint (#1568) ([d0d7b0af92de20fe606076e90f48604018cdf099](https://github.com/zowe/api-layer/commit/d0d7b0af92de20fe606076e90f48604018cdf099)), closes [#1568](https://github.com/zowe/api-layer/issues/1568)
* Feature:  Make cookie samesite configurable. The configuration parameter `apiml.auth.cookieProperties.cookieSameSite` makes it possible for users to configure the SameSite attribute of the `apimlAuthenticationToken` cookie (#1545) ([135904c](https://github.com/zowe/api-layer/commit/135904c)), closes [#1545](https://github.com/zowe/api-layer/issues/1545)
* Feature:  Services can now configure their desired load balancer behavior (#1536) ([db0c070](https://github.com/zowe/api-layer/commit/db0c070)), closes [#1536](https://github.com/zowe/api-layer/issues/1536)


* Bugfix:  Fix login error handling when auth service is not available (#1579) ([1221573](https://github.com/zowe/api-layer/commit/1221573)), closes [#1579](https://github.com/zowe/api-layer/issues/1579)
* Bugfix:  Handle multiple discovery service instances in static refresh (#1582) ([d7237ce](https://github.com/zowe/api-layer/commit/d7237ce)), closes [#1582](https://github.com/zowe/api-layer/issues/1582)
* Bugfix:  Improve redis configuration for users (#1589) ([b1f7088](https://github.com/zowe/api-layer/commit/b1f7088)), closes [#1589](https://github.com/zowe/api-layer/issues/1589)
* Bugfix:  Properly display API Catalog status on Gateway homepage (#1581) ([b8dd9cd](https://github.com/zowe/api-layer/commit/b8dd9cd)), closes [#1581](https://github.com/zowe/api-layer/issues/1581)
* Bugfix:  Change order of authentication filters on Login endpoint (#1526) ([3b93e9b](https://github.com/zowe/api-layer/commit/3b93e9b)), closes [#1526](https://github.com/zowe/api-layer/issues/1526)
* Bugfix:  Wrong use of certificates in ZAAS client (#1514) ([964c4fa](https://github.com/zowe/api-layer/commit/964c4fa)), closes [#1514](https://github.com/zowe/api-layer/issues/1514)

## `1.22.0 (2021-06-14)`

* Feature: Deterministic routing based on the provided headers is now available. Clients can now specify which instance of a service the user should be routed to. This enables reusability of underlying resources such as LPARs associated with a specific service instance (#1496) ([ed91f25](https://github.com/zowe/api-layer/commit/ed91f25)), closes [#1496](https://github.com/zowe/api-layer/issues/1496).
* Feature: Basic authentication via Websocket is now fully supported (#1482) ([112da99](https://github.com/zowe/api-layer/commit/112da99)), closes [#1482](https://github.com/zowe/api-layer/issues/1482).
* Feature: Passwords can be changed via SAF. An endpoint is exposed allowing users to change passwords using this API ML endpoint (#1471) ([3f3c2af](https://github.com/zowe/api-layer/commit/3f3c2af)), closes [#1471](https://github.com/zowe/api-layer/issues/1471).
* Feature: A self-service application is now available that can run in the infrastructure of the user to verify whether certificates are properly created and configured (#1441) ([e694c0f](https://github.com/zowe/api-layer/commit/e694c0f)), closes [#1441](https://github.com/zowe/api-layer/issues/1441)


* Bugfix: Use the apiml.service.id in the API Catalog as used in other services. (#1475) ([7bc8f99](https://github.com/zowe/api-layer/commit/7bc8f99)), closes [#1475](https://github.com/zowe/api-layer/issues/1475)
* Bugfix: Change the registration to use the correct hostname in `instanceId` (#1473) ([1d6caa8](https://github.com/zowe/api-layer/commit/1d6caa8)), closes [#1473](https://github.com/zowe/api-layer/issues/1473)
* Bugfix: The HTTP client is not closed when generating a passticket. The ZAAS client can now reuse connections and provide correct login with passtickets (#1470) ([ed9f929](https://github.com/zowe/api-layer/commit/ed9f929)), closes [#1470](https://github.com/zowe/api-layer/issues/1470).
* Bugfix: Configurable jwt alias at startup via environment variable (#1442) ([0e3df7a](https://github.com/zowe/api-layer/commit/0e3df7a)), closes [#1442](https://github.com/zowe/api-layer/issues/1442)
* Bugfix: Use the actual hostname instead of the one provided by Spring Cloud (#1434) ([6b8c38a](https://github.com/zowe/api-layer/commit/6b8c38a)), closes [#1434](https://github.com/zowe/api-layer/issues/1434)
* Bugfix: Distinguish lib and fat jars (#1398) ([f771a40](https://github.com/zowe/api-layer/commit/f771a40)), closes [#1398](https://github.com/zowe/api-layer/issues/1398)
* Bugfix: Accept list of Discovery services in the Catalog. If the Catalog fails to contact to the Discovery service, the Catalog tries to contact another service from the list (#1376) ([42ae70d](https://github.com/zowe/api-layer/commit/42ae70d)), closes [#1376](https://github.com/zowe/api-layer/issues/1376)

## `1.21.1 (2021-04-26)`

* Feature: Configuration of the API ML run is now permitted where the hostname in the certificate is not verified in a strict manner. The certificate Common Name or Subject Alternate Name (SAN) are NOT checked. This facilitates deployment to Marist when certificates are valid but do not contain a valid hostname. This is for development purposes only and should not be used for production. (#1334) ([2da761a](https://github.com/zowe/api-layer/commit/2da761a)), closes [#1334](https://github.com/zowe/api-layer/issues/1355) 
* Feature: Caching service: The alphanumeric constraint for keys stored in the service has been removed. (#1317) ([237420](https://github.com/zowe/api-layer/commit/23742017fb37815dc40b5e7c8645acfac5a92ccb))
* Feature: An endpoint has been added to delete all keys for a specific service (#1253) ([0c3e01](https://github.com/zowe/api-layer/commit/0c3e01900ea646bd959472bae3bd9c1fbd7d3e31)), closes [1253](https://github.com/zowe/api-layer/issues/1253)

* Bugfix: Stop leaking X-Certificate headers (#1328) ([b2737a](https://github.com/zowe/api-layer/commit/b2737a921bb543f7b6865739b8a618cca72691e3))
* Bugfix: Remove the wait from start.sh to reduce address spaces (#1335) ([2ba780](https://github.com/zowe/api-layer/commit/2ba7803902d7796518cf1c9a5806b9c81b7360bb))
* Bugfix: Make the version endpoint available at the URL: /application/version (#1312) ([0ac95a4](https://github.com/zowe/api-layer/commit/0ac95a41333e3b13dd7dedfd147a7c24d5d3088f))
* Bugfix: Load the JWT secret properly when concurrently loaded and requested (#1255) ([1644a8c](https://github.com/zowe/api-layer/commit/1644a8c)), closes [#1255](https://github.com/zowe/api-layer/issues/1255) 
* Bugfix: Swagger v2 yaml parsed and rendered (#1269) ([a1f2cc0](https://github.com/zowe/api-layer/commit/a1f2cc0c3580e6d36a878e0fff23b943857b38e4)), closes [1229](https://github.com/zowe/api-layer/issues/1229)


## `1.20.0 (2021-03-11)`
* Bugfix (authentication): Support specific z/OSMF version. This fix allows the user to force the authentication token that is used. (#1241) ([2da761a](https://github.com/zowe/api-layer/commit/2da761a)), closes [#1241](https://github.com/zowe/api-layer/issues/1241)
* Bugfix (authentication): Ignore wrong or non-existing SAF classes when SAF is not used (#1216) ([c5ea311](https://github.com/zowe/api-layer/commit/c5ea311)), closes [#1216](https://github.com/zowe/api-layer/issues/1216)
* Bugfix (enabler): Add unregistration method to the the Node.js enabler. (#1214) ([1ecd5c7](https://github.com/zowe/api-layer/commit/1ecd5c7)), closes [#1214](https://github.com/zowe/api-layer/issues/1214)
* Feature: x509 authentication scheme. This feature supports authentication with a client certificate in southbound services whereby users can decide which part of the certificate to use. (#1208) ([94dbf37](https://github.com/zowe/api-layer/commit/94dbf37)), closes [#1208](https://github.com/zowe/api-layer/issues/1208)
* Feature: Add NodeJS sample service and enabler. This feature makes it possible for a service based on NodeJS to register with API ML in a similar way as with other onboarding enablers. (#1140) ([c86a289](https://github.com/zowe/api-layer/commit/c86a289)), closes [#1140](https://github.com/zowe/api-layer/issues/1140)
* Feature: Allow Zowe to run without a jwtsecret if the jwtsecret is not required. (#1203) ([7dc6dad](https://github.com/zowe/api-layer/commit/7dc6dad)), closes [#1203](https://github.com/zowe/api-layer/issues/1203)
* Bugfix: Enable /api/v1/gateway path format for the `/auth/logout`, `/auth/login`, `/auth/query`, and `/auth/passticket` endpoints (#1126) ([13ac9a5](https://github.com/zowe/api-layer/commit/13ac9a5)), closes [#1126](https://github.com/zowe/api-layer/issues/1126)
* Feature: Introduce token validation providers. This feature provides a future mechanism of token validation whereby custom endpoint can be provided that requires authentication. (#1142) ([80cc790](https://github.com/zowe/api-layer/commit/80cc790)), closes [#1142](https://github.com/zowe/api-layer/issues/1142)
* Feature: Reject eviction strategy has been added to VSAM. If storage is full, and `ZWE_CACHING_EVICTION_STRATEGY` is set to `reject` this feature prevents the Caching Service from removing entries, but returns a status code 507 with the message, “Insufficient storage space limit”. (#1112) ([70c2d71](https://github.com/zowe/api-layer/commit/70c2d71)), closes [#1112](https://github.com/zowe/api-layer/issues/1112) ([80cc790](https://github.com/zowe/api-layer/commit/80cc790)), closes [#1142](https://github.com/zowe/api-layer/issues/1142)
* Feature: Base information (SSO, API ID) about a service is now displayed in the API Catalog. (#1116) ([4b61377](https://github.com/zowe/api-layer/commit/4b61377)), closes [#1116](https://github.com/zowe/api-layer/issues/1116) [#1116](https://github.com/zowe/api-layer/issues/1116)
* Bugfix: Accept `swagger/openapi` in yaml format (#1202) ([0c412b0](https://github.com/zowe/api-layer/commit/0c412b0)), closes [#1202](https://github.com/zowe/api-layer/issues/1202)
* Feature (Caching Service): Production logging for the Caching Service. This feature limits messages sent to Spool to the bare minimum, thereby improving the information returned to the caller. (#1185) ([7adffb1](https://github.com/zowe/api-layer/commit/7adffb1)), closes [#1185](https://github.com/zowe/api-layer/issues/1185)

## `1.19.0`

- Feature: The connection limit of the Gateway has been configured to support multiple long-running requests by service. [#843](https://github.com/zowe/api-layer/issues/843)
- Feature: The size of API Mediation Layer has been reduced to fit within 150MB. [#909](https://github.com/zowe/api-layer/issues/909)
- Feature: You can now remove or configure the Catalog from appearing on the Gateway homepage [#727](https://github.com/zowe/api-layer/issues/727)
- Bugfix: API ID is not sent to Eureka in metadata by the Java enabler [#991](https://github.com/zowe/api-layer/issues/991)
- Feature: Connection limits have been enhanced to improve latency times when making requests through the API ML. This feature also enables concurrent requests. [#987](https://github.com/zowe/api-layer/issues/987)
- Feature: The connection limit log messages hae been enhanced. New messages indicate when too many connections occur. [#987](https://github.com/zowe/api-layer/issues/987)
- Bugfix: Fixed tcp connections that are stuck open. [#1009](https://github.com/zowe/api-layer/issues/1009)
- Feature: The `/api/v1/gateway/services/{serviceId}` endpoint has been added which provides information about a service in API ML for API clients. You can now view information to choose the applicable available API service without having a trusted service certificate. Proper SAF authorization is required. [#873](https://github.com/zowe/api-layer/issues/873)
- Feature: The size limitation in the InMemory cache for proper handling is now supported when size limitations are reached.  [#998](https://github.com/zowe/api-layer/issues/998)
- Feature: The 'Remove Oldest' eviction mechanism for Caching Service has been implemented to limit the volume of data in the cache.[#998](https://github.com/zowe/api-layer/issues/998)
- Feature: Configure CORS origins per service has been configured so that onboarded services can request to delegate CORS behavior for a route to the API Mediation Layer. [#997](https://github.com/zowe/api-layer/issues/997)
- Feature: The 'Reject eviction' strategy to Caching service has been implemented to limit the volume of data in the cache.[#998](https://github.com/zowe/api-layer/issues/998)
- Feature: Debug logging to x509 Client certificate authentication classes has been added. This feature enables users to determine the cause of system problems during client certificate authentication setup.

## `1.18.0`

- Feature: Configure more detailed logging outside of Spool. [#709](https://github.com/zowe/api-layer/issues/709)
- Feature: HA: Componentize the start script per API ML service. Individual API Mediation Layer components can be launched and restarted individually. [#862](https://github.com/zowe/api-layer/issues/862)
- Feature: HA: It is now possible to distinguish between internal and external traffic through port separation, whereby each port uses a unique certificate; one presenting an internal certificate, and the other an external certificate. [#910](https://github.com/zowe/api-layer/issues/910)
- Feature: API version is now automatically set to the version tab selected in the API Catalog so users can easily grab the Base Path. [#943](https://github.com/zowe/api-layer/issues/943)
- Feature: A new enhancement to the API Catalog versioning has been introduced with the addition of the API differences tab. This feature enables users to compare versions of two APIs. [#923](https://github.com/zowe/api-layer/issues/923)
- Bugfix: ZaasJwtService enhancement on JWT parsing and error handling. [#897](https://github.com/zowe/api-layer/issues/897)
- Bugfix: Upgrade dependencies for the Enablers [#933](https://github.com/zowe/api-layer/issues/933)

## `1.17.0`

- Feature: Multiple versions of one API are now presented in the Catalog if configured to do so. Users can now switch between different versions within the Catalog to see differences in API documentation between versions. [#844](https://github.com/zowe/api-layer/issues/844)
- Feature: Setting `APIML_DEBUG_MODE_ENABLED` in `instance.env` is properly passed on to the all API ML services. [#901](https://github.com/zowe/api-layer/issues/901)
- Bugfix: Improved returned information while logging out via logout on Gateway. [#831](https://github.com/zowe/api-layer/issues/831) 
- Bugfix: Updated API paths for the API ML in the API Catalog to use the service id in front. [#853](https://github.com/zowe/api-layer/issues/853) 

## `1.16.0`

- Feature: ZAAS Client can now use HTTP so that the Application Transparent Transport Layer Security (AT-TLS) can be used for communication to ZAAS. [#813](https://github.com/zowe/api-layer/issues/813)
- Feature: Implemented the logout functionality in ZAAS Client. [#808](https://github.com/zowe/api-layer/issues/808)
- Feature: Added a more helpful and actionable description to message ZWEAM511E, which occurs when API ML does not trust the certificate provided by the service. [#818](https://github.com/zowe/api-layer/issues/818)
- Bugfix: Changed the default expiration time value for JWT token to 8h for consistency with the z/OSMF default. [#615](https://github.com/zowe/api-layer/issues/615)
- Bugfix: Reduced excessive and unhelpful log messages. [#672](https://github.com/zowe/api-layer/issues/672)
- Bugfix: Added the Base Path field in the API Catalog if one is available, which can override the Swagger Base Path. This causes the proper Base Path to be displayed in the event that the api doc is not populated properly. [#810](https://github.com/zowe/api-layer/issues/810)
- Bugfix: Removed overwriting of the Swagger Base Path, which resulted in malformed API routes when the base URL is shared among multiple services. [#852](https://github.com/zowe/api-layer/issues/852)
- Bugfix: API ML was previously not reporting SSL certificate errors when servers were unable to communicate. Now, if a SSLException occurs, SSL certificate errors are reported.  [#698](https://github.com/zowe/api-layer/issues/698)
- Bugfix: Fixed language in log messages for consistency. [#830](https://github.com/zowe/api-layer/issues/830)

## `1.15.0`

- Feature: The API Path Pattern now supports serviceId as the first element. This improves the consistency of the URL when processing through the Gateway or outside of the Gateway. [#688](https://github.com/zowe/api-layer/issues/688)
- Feature: The SAF Provider can now be used as a possible authentication provider. This removes the API ML dependency on z/OSMF for authentication enabling SAF to obtain the JWT. [#472](https://github.com/zowe/api-layer/issues/472)
- Feature: The Swagger URL is now provided for z/OSMF. This URL provides full documentation containing the Try It Out functionality if the zOSMF version supports the Swagger endpoint. Alternatively, the URL provides the info endpoint to directly enable access to Zowe endpoints.  [#665](https://github.com/zowe/api-layer/issues/665)
- Feature: The default configuration of API ML now supports character encoding. [#777](https://github.com/zowe/api-layer/issues/777)
- Bugfix: SSL validation when Eureka is running in HTTP mode has been fixed. When the scheme is HTTP, SSL configuration is not verified since it not used. [#792](https://github.com/zowe/api-layer/issues/792)
- Bugfix: A problem in error handling has been fixed when no api-doc is available. Now a specific return code and message is generated when a problem occurs when obtaining or transforming the api-doc. [#571](https://github.com/zowe/api-layer/issues/571)

## `1.14.0`

- Bugfix: Prevent crashing of API ML when null routes are set. [#767](https://github.com/zowe/api-layer/pull/767)
- Feature: Add support to the X-Forwarded-* Headers. [#769](https://github.com/zowe/api-layer/pull/769)
- Feature: Improve the configuration validator for the enablers to improve message specificity when one or more parameters required for setup are missing. [#760](https://github.com/zowe/api-layer/pull/760)

## `1.13.0`

- Feature: Add CORS Headers Support [#384](https://github.com/zowe/api-layer/issues/384)
- Feature: Option to set connection timeout for service [#683](https://github.com/zowe/api-layer/issues/683)
- Bugfix: SAF Keyrings support for ZAAS Client [#656](https://github.com/zowe/api-layer/issues/656)
- Feature: Spring Boot enabler configuration validation [#570](https://github.com/zowe/api-layer/issues/570)

## `1.12.0`

- Feature: Provide Zowe Authentication and Authorization Service (ZAAS) client [#425](https://github.com/zowe/api-layer/issues/425)
- Feature: Refresh the static client definitions from the API Catalog UI [#57](https://github.com/zowe/api-layer/issues/57)
- Feature: Switch to sso-auth instead of apiml-auth [#55](https://github.com/zowe/api-layer/issues/55)
- Bugfix: Added logout endpoint api doc [#632](https://github.com/zowe/api-layer/issues/632)
- Bugfix: Make jjwt only a test dependency [#563](https://github.com/zowe/api-layer/issues/563)
- Bugfix: Fix order of fetching JWT from request [#661](https://github.com/zowe/api-layer/pull/661) 
- Feature: Implement request retrying for service instances [#401](https://github.com/zowe/api-layer/issues/401)

## `1.11.0`

- Feature: Allow users of the API Catalog to test public and private endpoints directly from the UI [#258](https://github.com/zowe/api-layer/issues/258)
- Feature: Provide Endpoints to get public keys for JWT verification (z/OSMF and Zowe) [#566](https://github.com/zowe/api-layer/pull/566) 
- Bugfix: Log errors found while processing static definitions [#579](https://github.com/zowe/api-layer/issues/579)
- Bugfix: Use uppercase parameters for PassTicket service [#592](https://github.com/zowe/api-layer/pull/592)
