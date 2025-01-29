package com.bodil.Bump.Buddy.repository;

import com.bodil.Bump.Buddy.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
