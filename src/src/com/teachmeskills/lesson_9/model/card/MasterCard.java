package com.teachmeskills.lesson_9.model.card;


import java.util.Date;

public class MasterCard extends BaseCard  {

    public String country;
    public int limit;
    private static final double MAX_MASTERCARD_TRANSFER_LIMIT = 700;

    public MasterCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, double amount, String country, int limit) {
        super(cardNumber, cvv, validDate, cardHolder, currency, amount);
        this.country = country;
        this.limit = limit;
    }


    @Override
    public boolean checkCardLimitTransfer(double sum) {
        return sum <= MAX_MASTERCARD_TRANSFER_LIMIT && this.amount >= sum;
    }
}
