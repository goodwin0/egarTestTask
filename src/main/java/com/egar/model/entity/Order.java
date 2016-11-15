package com.egar.model.entity;
import javax.persistence.*;
import java.util.Date;

/**
 * Class refers to entities of database table "order".
 */
@Entity
@Table(name="ORDERS")
public class Order implements EntityDB {
    @Id
    @Column(name = "id")
    private int id;                 // ID заказа
    @Column(name = "customersName")
    private String customersName;   // Имя заказчика
    @Column(name = "customersAddress")
    private String customersAddress; // Адрес заказчика
    @Column(name = "ordersValue")
    private int value;              // Общая сумма заказа
    @Column(name = "ordersDate")
    @Temporal(value= TemporalType.DATE)
    private Date date;            // Дата заказа

    public Order(int id, String customersName, String customersAddress, int value, Date date) {
        this.id = id;
        this.customersName = customersName;
        this.customersAddress = customersAddress;
        this.value = value;
        this.date = date;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void update(EntityDB parameters) {
        Order order = (Order) parameters;
        this.customersName = order.getCustomersName();
        this.customersAddress = order.getCustomersAddress();
        this.value = order.getValue();
        this.date = order.getDate();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomersName() {
        return customersName;
    }

    public void setCustomersName(String customersName) {
        this.customersName = customersName;
    }

    public String getCustomersAddress() {
        return customersAddress;
    }

    public void setCustomersAddress(String customersAddress) {
        this.customersAddress = customersAddress;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public ArrayList<Article> articleList{
//        DataAccess.selectArticlesForOrder(this.id);
//    }

}