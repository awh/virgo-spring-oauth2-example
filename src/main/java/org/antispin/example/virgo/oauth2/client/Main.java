package org.antispin.example.virgo.oauth2.client;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.context.OAuth2ClientContext;
import org.springframework.security.oauth2.client.context.OAuth2ClientContextHolder;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * User: awh
 * Date: 5/3/12
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        final ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setId("treasure");
        resourceDetails.setAccessTokenUri("http://localhost:8080/test/oauth/token");
        resourceDetails.setUsername("test");
        resourceDetails.setPassword("changeme");
        resourceDetails.setClientId("trusted");
        resourceDetails.setClientSecret("secret");

        final ResourceOwnerPasswordAccessTokenProvider accessTokenProvider = new ResourceOwnerPasswordAccessTokenProvider();
        final AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
        final OAuth2AccessToken accessToken = accessTokenProvider.obtainAccessToken(resourceDetails, accessTokenRequest);
        final OAuth2ClientContext clientContext = new OAuth2ClientContext();

        OAuth2ClientContextHolder.setContext(clientContext);

        clientContext.addAccessToken(resourceDetails, accessToken);

        final RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);

        System.out.println(restTemplate.getForObject("http://localhost:8080/test/treasure", String.class));
    }
    
}
