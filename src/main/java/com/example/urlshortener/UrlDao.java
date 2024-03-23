package com.example.urlshortener;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlDao extends JpaRepository<Url, Long> {
    Url findByShortUrl(String shortUrl);

}
