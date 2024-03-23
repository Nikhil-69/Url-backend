package com.example.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private UrlDao urlDao;
    String MainUrl = "http://provider.apac.spheron.wiki:31259/goto/";
    public String shortenUrl(String originalUrl) {
        originalUrl= originalUrl;
        int hashCode = originalUrl.hashCode();
        String shortUrl = Integer.toString(hashCode, 16);
        Url url= new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortUrl);
        urlDao.save(url);
        return MainUrl+shortUrl;
    }

    public String getOriginalUrl(String shortUrl) {
        Url url = urlDao.findByShortUrl(shortUrl);
        return url.getOriginalUrl();
    }
}
