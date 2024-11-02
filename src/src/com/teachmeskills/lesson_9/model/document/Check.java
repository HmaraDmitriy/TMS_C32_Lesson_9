package com.teachmeskills.lesson_9.model.document;
import java.util.Date;

// TODO добавить поля: сумма перевода, дата перевода, номер счета или номер карты +
// TODO создать метод для вывода информации о чеке на экран +
public class Check {
    private double sum;
    private Date date;
    private String numberCart;
    private String comment;

    public Check(double sum, Date date, String numberCart, String comment) {
        this.sum = sum;
        this.date = date;
        this.numberCart = numberCart;
        this.comment = comment;
    }

    public void infoCheck() {
        System.out.println("Transfer amount: " + sum + ", transfer date: " + date + ", card number: " + numberCart);
        System.out.println("Comment: " + comment);
    }
}
