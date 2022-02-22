package com.example.demo.controller;

import com.example.demo.model.SearchKey;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(path="/{key}", produces = "application/json")
    public ResponseEntity<String> searchKey(@PathVariable String key) throws URISyntaxException {
        System.out.println("key:"+ key);

        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://akshaysearchservice.search.windows.net/indexes/azureblob-index-2/docs/search?api-version=2021-04-30-Preview");
        SearchKey body = new SearchKey();
        body.setSearch(key);
        HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", "C7D70FF9A439780A4705CCC8B5B82B48");
        HttpEntity<SearchKey> request = new HttpEntity<SearchKey>(body, headers);
        return restTemplate.postForEntity(uri, request, String.class);
    }
}
