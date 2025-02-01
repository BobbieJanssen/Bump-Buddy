package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.Article;
import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    Article getArticleById(Long id);
    List<Article> getArticlesByWeek(int week);
    Article createArticle(Article article);
    Article updateArticle(Long id, Article article);
    void deleteArticle(Long id);
}
