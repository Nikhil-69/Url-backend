package com.example.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/")
public class UrlController {

    @Autowired
    private UrlService urlShortenerService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String originalUrl) throws UnsupportedEncodingException {
        String decodedUrl = URLDecoder.decode(originalUrl, StandardCharsets.UTF_8);
        return urlShortenerService.shortenUrl(decodedUrl);
    }

    @GetMapping("/goto/{shortUrl}")
    public RedirectView redirectToOriginalUrl(@PathVariable String shortUrl) {
        String originalUrl = urlShortenerService.getOriginalUrl(shortUrl);
        return new RedirectView(originalUrl);
    }

}
