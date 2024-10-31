package com.teachmeskills.lesson_9.model.document;

// TODO добавить поля: сумма перевода, дата перевода, номер счета или номер карты +
// TODO создать метод для вывода информации о чеке на экран +
public class Check {
    private double sum;
    private int data;
    private int numberCart;
    private String comment;

    public Check(double sum, int data, int numberCart, String comment) {
        this.sum = sum;
        this.data = data;
        this.numberCart = numberCart;
        this.comment = comment;
    }

    public void infoCheck() {
        System.out.println("Transfer amount: " + sum + ", transfer date: " + data + ", card number: " + numberCart);
        System.out.println("Comment: " + comment);
    }
}
