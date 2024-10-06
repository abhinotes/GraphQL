package com.abhinotes.graphql.server.graphql.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class RestClient {

    private final RestTemplate restTemplate;

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T get(String url, Class<T> responseType) {
        try {
            return restTemplate.getForObject(url, responseType);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Error making GET request: {} {} " , e.getStatusCode() , e.getMessage());
            return null;
        } catch (Exception e) {
            log.error("Error making GET request: {}" ,e.getMessage());
            return null;
        }
    }

    public <T> T post(String url, Object request, Class<T> responseType) {
        try {
            return restTemplate.postForObject(url, request, responseType);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Error making POST request: {} {}" , e.getStatusCode(), e.getMessage());
            return null;
        } catch (Exception e) {
            log.error("Error making POST request: {}" , e.getMessage());
            return null;
        }
    }

}
