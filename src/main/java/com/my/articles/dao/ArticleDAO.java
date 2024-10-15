package com.my.articles.dao;

import com.my.articles.dto.ArticleDto;
import com.my.articles.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

//@Service
@Component // 서비스,리포지토리의 최상위 디렉토리
@Transactional // 수정,삭제 시 꼭 붙여야 함
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

    public void deleteArticle(Long id) {
        Article article = em.find(Article.class, id);
        em.remove(article);
    }

    public void updateArticle(ArticleDto dto) {
        Article article = em.find(Article.class, dto.getId());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
    }

    public void insertArticle(Article article) {
        em.persist(article);
    }
}
