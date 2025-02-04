package com.bodil.Bump.Buddy.controller.mapper;

import com.bodil.Bump.Buddy.controller.DTO.ArticleDTO;
import com.bodil.Bump.Buddy.model.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    public ArticleDTO toDTO(Article article) {
        return new ArticleDTO(
                    article.getTitle(),
                    article.getContent(),
                    article.getVisibleAtWeek(),
                    article.getCreatedAt(),
                    article.getUploadedAt()
            );
        }

    public Article toEntity(ArticleDTO articleDTO) {
            Article article = new Article();
            article.setTitle(articleDTO.getTitle());
            article.setContent(articleDTO.getContent());
            article.setVisibleAtWeek(articleDTO.getVisibleAtWeek());
            article.setCreatedAt(articleDTO.getCreatedAt());
            article.setUploadedAt(articleDTO.getUploadedAt());
            return article;
        }
    }
