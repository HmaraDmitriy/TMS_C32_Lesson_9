package com.teachmeskills.lesson_9.model.card;


import java.util.Date;

public class VisaCard extends BaseCard {

    int cashback;

    private static final double MAX_VISA_TRANSFER_LIMIT = 500;

    public VisaCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, int cashback) {
        super(cardNumber, cvv, validDate, cardHolder, currency, cashback);
        this.cashback = cashback;
    }


    @Override
    public boolean checkCardLimitTransfer(double sum) {
        return sum <= MAX_VISA_TRANSFER_LIMIT && this.amount >= sum;
    }

}

