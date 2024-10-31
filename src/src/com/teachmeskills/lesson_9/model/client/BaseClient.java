package com.teachmeskills.lesson_9.model.client;

import com.teachmeskills.lesson_9.model.account.Account;
import com.teachmeskills.lesson_9.model.card.BaseCard;

public abstract class BaseClient {

    String name;
    Account[] accounts;
    BaseCard[] cards;

    public BaseClient(String name, Account[] accounts, BaseCard[] cards) {
        this.name = name;
        this.accounts = accounts;
        this.cards = cards;
    }
    public Account[] getAccounts() {
        return accounts;
    }

    public BaseCard[] getCards() {
        return cards;
    }
}
