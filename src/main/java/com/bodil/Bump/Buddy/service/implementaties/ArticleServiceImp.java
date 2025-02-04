package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.controller.DTO.ArticleDTO;
import com.bodil.Bump.Buddy.controller.mapper.ArticleMapper;
import com.bodil.Bump.Buddy.model.Article;
import com.bodil.Bump.Buddy.repository.interfaces.ArticleRepository;
import com.bodil.Bump.Buddy.service.interfaces.ArticleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImp implements ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public ArticleServiceImp(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    @Override
    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll().stream()
                .map(articleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDTO getArticleById (Long id) {
        return articleRepository.findById(id)
                .map(articleMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Article not found"));
    }

    @Override
    public List<ArticleDTO> getArticlesByWeek(int week) {
        return articleRepository.findByVisibleAtWeek(week).stream()
                .map(articleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        Article article = articleMapper.toEntity(articleDTO);
        Article savedArticle = articleRepository.save(article);
        return articleMapper.toDTO(savedArticle);
    }

    @Override
    public ArticleDTO updateArticle(Long id, ArticleDTO updatedArticleDTO) {
        Article existingArticle = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found"));
        existingArticle.setTitle(updatedArticleDTO.getTitle());
        existingArticle.setContent(updatedArticleDTO.getContent());
        existingArticle.setVisibleAtWeek(updatedArticleDTO.getVisibleAtWeek());
        existingArticle.setUploadedAt(updatedArticleDTO.getUploadedAt());
        Article updatedArticle = articleRepository.save(existingArticle);
        return articleMapper.toDTO(updatedArticle);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
