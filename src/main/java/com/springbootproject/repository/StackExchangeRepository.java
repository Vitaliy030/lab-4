package com.springbootproject.repository;

import com.springbootproject.entity.Sites;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class StackExchangeRepository {
    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    public Sites getSites() {
        final String url = "https://api.stackexchange.com/2.2/sites?filter=!2--Yion.6iyFFudE8CzDu";
        try {
            final Sites response = restTemplate.getForObject(new URI(url), Sites.class);
            return response;
        } catch (final URISyntaxException e) {
            throw new RuntimeException();
        }
    }
}
