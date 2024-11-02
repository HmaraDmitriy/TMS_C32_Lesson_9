package com.teachmeskills.lesson_9.transfer.impl;

import com.teachmeskills.lesson_9.model.account.Account;
import com.teachmeskills.lesson_9.model.card.BaseCard;
import com.teachmeskills.lesson_9.model.document.Check;
import com.teachmeskills.lesson_9.transfer.CardTransferService;
import java.util.Date;

// TODO реализовать имплементацию интерфейса +
public class MasterCardTransferService  implements CardTransferService {

    public Check transferFromCardToCard(BaseCard senderCard, BaseCard receiverCard, double sum) {
        String comment;

        if (sum <= 0) {
            comment = "Transfer failed: amount must be greater than zero.";
            return new Check(sum, new Date(), senderCard.cardNumber, comment);
        }

        if (!senderCard.checkCardLimitTransfer(sum)) {
            comment = "Transfer failed: exceeded transfer limit.";
            return new Check(sum, new Date(), senderCard.cardNumber, comment);
        }

        if (senderCard.amount < sum) {
            comment = "Transfer failed: insufficient funds.";
            return new Check(sum, new Date(), senderCard.cardNumber, comment);
        }

        senderCard.amount -= sum;
        receiverCard.amount += sum;
        comment = "Transfer completed successfully.";

        return new Check(sum, new Date(), senderCard.cardNumber, comment);
    }

    public Check transferFromCardToAccount(BaseCard senderCard, Account receiverAccount, double sum) {
        String comment;

        if (sum <= 0) {
            comment = "Transfer failed: amount must be greater than zero.";
            return new Check(sum, new Date(), senderCard.cardNumber, comment);
        }

        if (!senderCard.checkCardLimitTransfer(sum)) {
            comment = "Transfer failed: exceeded transfer limit.";
            return new Check(sum, new Date(), senderCard.cardNumber, comment);
        }

        if (senderCard.amount < sum) {
            comment = "Transfer failed: insufficient funds.";
            return new Check(sum, new Date(), senderCard.cardNumber, comment);
        }

        senderCard.amount -= sum;
        receiverAccount.setBalance(receiverAccount.getBalance() + sum);
        comment = "Transfer completed successfully.";

        return new Check(sum, new Date(), senderCard.cardNumber, comment);
    }
}