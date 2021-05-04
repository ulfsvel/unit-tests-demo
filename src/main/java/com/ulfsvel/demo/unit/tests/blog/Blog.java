package com.ulfsvel.demo.unit.tests.blog;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Blog {

    private final TranslationService translationService;

    private final Map<Long, Article> articleMap = new HashMap<>();

    public Blog(TranslationService translationService) {
        this.translationService = translationService;
    }

    public void addArticle(Article article) {
        articleMap.put(article.getId(), article);
    }

    public Article getArticle(Long articleId, Locale locale) {
        // V1
//        Article article = articleMap.get(articleId);
//        if (article == null) {
//            throw new ArticleNotFoundException();
//        }
//        if (!article.getLocale().equals(locale)) {
//            String translatedContent = translationService.translate(
//                    article.getContent(),
//                    article.getLocale(),
//                    locale
//            );
//            article.setLocale(locale);
//            article.setContent(translatedContent);
//        }
//        return article;
        // V2
        return Optional
                .ofNullable(articleMap.get(articleId))
                .map((article) -> {
                    String translatedContent = translationService.translate(
                            article.getContent(),
                            article.getLocale(),
                            locale
                    );
                    article.setLocale(locale);
                    article.setContent(translatedContent);
                    return article;
                })
                .orElseThrow(ArticleNotFoundException::new);
    }
}
