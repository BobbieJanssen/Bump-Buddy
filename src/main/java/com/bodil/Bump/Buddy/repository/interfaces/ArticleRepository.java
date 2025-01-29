package com.bodil.Bump.Buddy.repository.interfaces;

import com.bodil.Bump.Buddy.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
