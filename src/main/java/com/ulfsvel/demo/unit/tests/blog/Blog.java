package com.ulfsvel.demo.unit.tests.blog;

public class Blog {

    private final TranslationService translationService;

    public Blog(TranslationService translationService) {
        this.translationService = translationService;
    }

    public void addArticle(Article article) {
        // @TODO: Implement me
    }

    public Article getArticle(Long articleId, Locale locale) {
        // @TODO: Implement me
        return null;
    }
}
