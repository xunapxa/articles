package com.my.articles.dto;

import com.my.articles.entity.Article;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private Long id;
    private String title;
    private String content;

    // entity-> dto
    public static ArticleDto fromEntity(Article article) {
        return new ArticleDto(
                article.getId(),
                article.getTitle(),
                article.getContent()
        );
    }

    // dto -> entity
    public static Article fromDto(ArticleDto dto) {
        return new Article(
                dto.getId(),
                dto.getTitle(),
                dto.getContent()
        );
    }

}
