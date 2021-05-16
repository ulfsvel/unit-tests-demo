package com.ulfsvel.demo.unit.tests.blog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BlogTest {

    private TranslationService translationService;

    private Blog blog;

    @BeforeEach
    public void beforeEach() {
        translationService = Mockito.mock(TranslationService.class);
        blog = new Blog(translationService);
    }

    @Test
    void givenNoArticlesWereAdded_whenGetArticleForNonExistingArticle_thenThrowException() {
        Assertions.assertThrows(
                ArticleNotFoundException.class,
                () -> blog.getArticle(1L, Locale.RO)
        );
    }

    @Test
    void givenArticlesWereAdded_whenGetArticleForExistingArticle_thenReturnArticle() {
        Article article = new Article();
        article.setId(1L);
        article.setLocale(Locale.RO);
        blog.addArticle(article);

        Assertions.assertEquals(article, blog.getArticle(1L, Locale.RO));
    }

    @Test
    void givenArticlesWereAdded_whenGetArticleForExistingArticleWithDifferentLocale_thenReturnTranslatedArticle() {
        String originalStringString = "original string";
        String translatedString = "translated string";
        Article article = new Article();
        article.setId(1L);
        article.setLocale(Locale.RO);
        article.setContent(originalStringString);
        blog.addArticle(article);
        Mockito
                .when(translationService.translate(
                        Mockito.any(),
                        Mockito.any(),
                        Mockito.any()
                ))
                .thenReturn(translatedString);

        Article response = blog.getArticle(1L, Locale.EN);
        Assertions.assertEquals(1L, response.getId());
        Assertions.assertEquals(Locale.EN, response.getLocale());
        Assertions.assertEquals(translatedString, response.getContent());
    }

}
