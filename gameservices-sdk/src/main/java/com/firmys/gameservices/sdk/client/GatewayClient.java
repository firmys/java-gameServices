package com.firmys.gameservices.sdk.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class GatewayClient {
    private final WebClient client;

    public GatewayClient(@Value("${gameservices.gateway.host}") String host,
                         @Value("${gameservices.gateway.port}") String port) {
        this.client = WebClient.builder()
                .baseUrl("http://" + host + ":" + port)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://" + host + ":" + port))
                .build();
    }

    public Function<UriBuilder, URI> uriBuilderFunction(String uriPath, Map<String, String> params) {
        return uriBuilder -> {
            Optional.ofNullable(params)
                    .orElse(new HashMap<>()).forEach(uriBuilder::queryParam);
            return uriBuilder.path(uriPath).build();
        };
    }

    public Function<Set<String>, Map<String, String>> paramsFunction(String paramName) {
        return params -> Optional.ofNullable(params)
                .orElse(new HashSet<>()).stream().map(s -> Map.entry(paramName, s))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public WebClient getClient() {
        return client;
    }
}
