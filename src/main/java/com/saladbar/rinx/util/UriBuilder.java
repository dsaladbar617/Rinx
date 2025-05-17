package com.saladbar.rinx.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class UriBuilder {
    public static URI build(long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
