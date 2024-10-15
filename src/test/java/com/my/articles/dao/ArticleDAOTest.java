package com.my.articles.dao;

import com.my.articles.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ArticleDAOTest {

    @Autowired
    ArticleDAO articleDAO;

    @Test
    void searchAll() {
        List<Article> articles = articleDAO.searchAllArticle();
        articles.forEach(x-> System.out.println(x));
    }
}