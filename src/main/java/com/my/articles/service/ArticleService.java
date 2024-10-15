package com.my.articles.service;

import com.my.articles.dao.ArticleDAO;
import com.my.articles.dto.ArticleDto;
import com.my.articles.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleDAO dao;

    public List<ArticleDto> searchAll() {
        List<Article> articles = dao.searchAllArticle();
        if (ObjectUtils.isEmpty(articles)) {
            return Collections.emptyList();
        } else {
            return articles.stream().map(entity->ArticleDto.fromEntity(entity))
                    .toList();
        }
    }

    public ArticleDto getOneArticle(Long id) {
        Article article = dao.searchOneArticle(id);
        if (ObjectUtils.isEmpty(article)) {
            return null;
        } else {
            return ArticleDto.fromEntity(article);
        }
    }
}
