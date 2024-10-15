package com.my.articles.dao;

import com.my.articles.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

//@Service
@Component // 서비스,리포지토리의 최상위 디렉토리
public class ArticleDAO {
    @Autowired
    EntityManager em;

    public List<Article> searchAllArticle() {
        String sql = "SELECT a FROM Article a ORDER BY a.id DESC";
        Query query = em.createQuery(sql);
        List<Article> articles = query.getResultList();
        return articles;
    }

    public Article searchOneArticle(Long id) {
        return em.find(Article.class, id);
    }
}
