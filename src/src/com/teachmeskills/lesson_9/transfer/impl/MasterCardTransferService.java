package com.teachmeskills.lesson_9.transfer.impl;

import com.teachmeskills.lesson_9.model.account.Account;
import com.teachmeskills.lesson_9.model.card.BaseCard;
import com.teachmeskills.lesson_9.model.document.Check;
import com.teachmeskills.lesson_9.transfer.CardTransferService;


// TODO реализовать имплементацию интерфейса +
public class MasterCardTransferService  implements CardTransferService {

    @Override
    public Check transferFromCardToCard(BaseCard senderCard, BaseCard receiverCard, double sum, int data, int numberCart, String comment) {
        if (sum <= 0) {
            return new Check(sum, data, numberCart, "Transfer failed: amount must be greater than zero.");
        }

        if (!((BaseCard) senderCard).checkCardLimitTransfer(sum)) {
            return new Check(sum, data, numberCart, "Transfer failed: exceeded transfer limit.");
        }

        if (senderCard.amount < sum) {
            return new Check(sum, data, numberCart, "Transfer failed: insufficient funds.");
        }

        senderCard.amount -= sum;
        receiverCard.amount += sum;
        return new Check(sum, data, numberCart, "Transfer completed successfully.");
    }

    @Override
    public Check transferFromCardToAccount(BaseCard senderCard, Account receiverAccount, double sum, int data, int numberCart, String comment) {
        if (sum <= 0) {
            return new Check(sum, data, numberCart, "Transfer failed: amount must be greater than zero.");
        }

        if (!((BaseCard) senderCard).checkCardLimitTransfer(sum)) {
            return new Check(sum, data, numberCart, "Transfer failed: exceeded transfer limit.");
        }

        if (senderCard.amount < sum) {
            return new Check(sum, data, numberCart, "Transfer failed: insufficient funds.");
        }

        senderCard.amount -= sum;
        receiverAccount.setBalance(receiverAccount.getBalance() + sum);
        return new Check(sum, data, numberCart, "Transfer completed successfully.");
    }
}