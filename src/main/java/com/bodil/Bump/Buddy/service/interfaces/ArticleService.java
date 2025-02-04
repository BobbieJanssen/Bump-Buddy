package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.controller.DTO.ArticleDTO;
import java.util.List;

public interface ArticleService {
    List<ArticleDTO> getAllArticles();
    ArticleDTO getArticleById(Long id);
    List<ArticleDTO> getArticlesByWeek(int week);
    ArticleDTO createArticle(ArticleDTO articleDTO);
    ArticleDTO updateArticle(Long id, ArticleDTO articleDTO);
    void deleteArticle(Long id);
}
