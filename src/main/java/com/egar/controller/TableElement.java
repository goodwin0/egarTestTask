package com.egar.controller;

import com.egar.model.entity.Article;
import com.egar.model.entity.Order;

import java.util.List;

/**
 * Class stores lists of entities.
 * Refer "order" with its "article" list.
 * Class makes easily representation on xhtml file.
 * Class allows not to mix model classes with not "Basic" type.
 */
public class TableElement {
    private Order order;
    private List<Article> articles;

    TableElement(Order order, List<Article> articles) {
        this.order = order;
        this.articles = articles;
    }

    /**
     * Default constructor
     */
    public TableElement() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
