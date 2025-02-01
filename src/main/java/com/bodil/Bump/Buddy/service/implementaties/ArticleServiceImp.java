package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.model.Article;
import com.bodil.Bump.Buddy.repository.interfaces.ArticleRepository;
import com.bodil.Bump.Buddy.service.interfaces.ArticleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImp(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById (Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found"));
    }

    @Override
    public List<Article> getArticlesByWeek(int week) {
        return articleRepository.findByVisibleAtWeek(week);
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Long id, Article updatedArticle) {
        Article existingArticle = getArticleById(id);
        existingArticle.setTitle(updatedArticle.getTitle());
        existingArticle.setContent(updatedArticle.getContent());
        existingArticle.setVisibleAtWeek(updatedArticle.getVisibleAtWeek());
        existingArticle.setUploadedAt(updatedArticle.getUploadedAt());
        return articleRepository.save(existingArticle);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
