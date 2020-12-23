package com.springbootproject.repository;

import com.springbootproject.entity.Sites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class StackExchangeRepository {

    @Value("${service.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    public Sites getSites() {
        try {
            final Sites response = restTemplate.getForObject(new URI(url), Sites.class);
            return response;
        } catch (final URISyntaxException e) {
            throw new RuntimeException();
        }
    }
}
