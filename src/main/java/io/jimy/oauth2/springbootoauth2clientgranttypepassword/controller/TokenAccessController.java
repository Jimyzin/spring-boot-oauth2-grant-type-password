package io.jimy.oauth2.springbootoauth2clientgranttypepassword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenAccessController {

    @Autowired
    private ResourceOwnerPasswordResourceDetails details;

    @Autowired
    OAuth2RestTemplate restTemplate;

    @GetMapping("/generate-token")
    public OAuth2AccessToken generateToken() {
        details.setUsername("pl_admin");
        details.setPassword("PowerLedger123");
        OAuth2AccessToken result = null;
        try {
            result = restTemplate.getAccessToken();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

}
