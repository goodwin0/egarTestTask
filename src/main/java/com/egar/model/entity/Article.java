package com.egar.model.entity;

import javax.persistence.*;

/**
 * Class refers to entities of database table "article".
 */
@Entity
@Table(name="ARTICLES")
public class Article implements EntityDB {

    @Id
    @Column(name = "id")
    private int id;                 // ID строки
    @Column(name = "serialNumber")
    private String serialNumber;    // Серийный номер товара
    @Column(name = "name")
    private String name;            // Название товара
    @Column(name = "amount")
    private int amount;          // Количество
//    @Column(name = "order_id")
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;            // Ссылка на заказ

    public int getId() {
        return id;
    }

    public void update(EntityDB parameters) {
        Article article = (Article) parameters;
        this.serialNumber = article.serialNumber;
        this.name = article.name;
        this.amount = article.amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
