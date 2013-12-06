
# OAuth2 Overview

OAuth2 is greatly simplified compared to OAuth1.0a; signing has been removed, and a number of authentication flows have been introduced for different use cases. The following example uses the 'Resource Owner Credential Grant', whereby a client can obtain an access token directly using the resource owner's username and password. The following curl command demonstrates how to obtain an access token from the example WAR bundle included in this example:

    curl -v -d grant_type=password \
            -d username=test \
            -d password=changeme \
            -u trusted:secret \
            http://localhost:8080/test/oauth/token

The `grant_type`, `username` and `password` form parameters are sent using an `application/x-www-form-urlencoded` entity body. The username and password values are those of the resource owner; the client must authenticate itself too, for which we use HTTP Basic authentication using the -u option. The following JSON entity body is returned:

    {"access_token":"229e0090-d77a-4702-8396-eb36b3a5914b","token_type":"bearer","expires_in":41242}

Once we have the access token, accessing a protected resource is as simple as including it in an authorization header in the request:

    curl -v -H 'Authorization: Bearer 229e0090-d77a-4702-8396-eb36b3a5914b' http://localhost:8080/test/treasure

# Spring 3 Security Java Client Example

An example Java client can be found at `src/main/java/org.antispin/example/virgo/oauth2/client/Main.java`

It can be run from the command line using the Maven exec plugin:

    mvn clean install -Dexec.mainClass=org.antispin.example.virgo.oauth2.client.Main exec:java

# Spring 3 Security Java Web Bundle Example

![Spring Security Class Diagram](spring-security-oauth2-class-diagram.png)

The bulk of this example is formed by the material under `src/main/resources/WEB-INF`, in particular the `virgo-oauth2-example-servlet.xml` which configures the `/test/oauth/token` endpoint and the `/test/treasure` protected resource. The XML file is heavily commented, and is accompanied by the above diagram which illustrates the graph of objects instantiated by the `<authorization-server/>` custom namespace handler which is delivered as part of the Spring 3 security OAuth2 package.
