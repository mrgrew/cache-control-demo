package com.drf.cachecontroldemo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @ApiOperation(value = "demo", notes="This operation sets cache control headers in the response." +
            "Note that those headers are appended to the Spring Security headers when I expected them to " +
            "override/replace the Spring Security headers.")
    @GetMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> duplicatedCacheControl() {
        long maxAge = 3600L;
        return ResponseEntity.noContent()
                .cacheControl(CacheControl.maxAge(maxAge, TimeUnit.SECONDS).noTransform().cachePublic())
                .build();
    }
}
