package com.wwapi.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PageController {

    @GetMapping("/")
    public String publicPath() {
        return "Hello, home!";
    }

    @GetMapping("/secured")
    public String authenticatedPath() {
        String str = "https://official-joke-api.appspot.com/jokes/random";

        String output = new RestTemplate().getForObject(str, String.class);
        String a = output.substring(output.indexOf("setup") + 7, output.indexOf("punchline") - 2);
        String b = output.substring(output.indexOf("punchline") + 11, output.indexOf("id") - 2);
        return a + " " + b;
    }
}