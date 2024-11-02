package com.teachmeskills.lesson_9.transfer;

import com.teachmeskills.lesson_9.model.account.Account;
import com.teachmeskills.lesson_9.model.card.BaseCard;
import com.teachmeskills.lesson_9.model.document.Check;


public interface CardTransferService {

    // TODO сделать возвращаемое значение Check (класс лежит в пакете document) +
    // TODO добавить входные параметры в метод: карта с..., карта на..., сумма трансфера +

     Check transferFromCardToCard (BaseCard senderCard, BaseCard receiverCard, double sum);

    // TODO сделать возвращаемое значение Check (класс лежит в пакете document) +
    // TODO добавить входные параметры в метод: карта с.., счет на..., сумма трансфера +

    Check transferFromCardToAccount (BaseCard senderCard, Account receiverAccount, double sum);
}
