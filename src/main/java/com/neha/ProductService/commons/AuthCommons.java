package com.neha.ProductService.commons;

import com.neha.ProductService.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommons {
    private RestTemplate restTemplate;

    public AuthCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String token) {
        // Call user Service to validate token
            ResponseEntity<UserDto> responseEntity = restTemplate.postForEntity("http://localhost:4041/users/validate/" + token, null, UserDto.class);
            if(responseEntity.getBody() == null) {
                //Token is invalid
                return null;
            }
            return responseEntity.getBody();
    }
}
