package com.teachmeskills.lesson_9;

import com.teachmeskills.lesson_9.document_parser.IParser;
import com.teachmeskills.lesson_9.fabric.ParserFabric;
import com.teachmeskills.lesson_9.model.account.Account;
import com.teachmeskills.lesson_9.model.card.BaseCard;
import com.teachmeskills.lesson_9.model.card.MasterCard;
import com.teachmeskills.lesson_9.model.card.VisaCard;
import com.teachmeskills.lesson_9.model.client.BaseClient;
import com.teachmeskills.lesson_9.model.client.IndividualClient;
import com.teachmeskills.lesson_9.model.client.LegalClient;
import com.teachmeskills.lesson_9.model.document.Check;
import com.teachmeskills.lesson_9.transfer.impl.MasterCardTransferService;
import com.teachmeskills.lesson_9.utils.Constants;

import java.util.Date;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        // TODO запросить с консоли путь и имя файла +
        // TODO сделать метод createParser статичным и избавиться от необходимости создания объекта parserFabric +
        // TODO заменить "" на имя файла, полученное со сканера +
        // TODO реализовать тестовый сценарий +
        // создать двух клиентов
        // каждому клиенту создать два счета и две карты
        // перевести с карты одного клиента на карту другого сумму денег
        // перевести с карты одного клинента на счет другого клиента сумму денег

        System.out.println("Specify the path and file name");
        Scanner scanner = new Scanner(System.in);
        String pathway = scanner.nextLine();
        IParser parser = ParserFabric.createParser(pathway);

        BaseClient client1 = new IndividualClient("Client1",
                new Account[]{new Account("67995", 8000), new Account("8674749", 935)},
                new BaseCard[]{new MasterCard("CH98751", 987, new Date(), "Karl", "USD", 358, "USS", Constants.MAX_TRANSFER_LIMIT),
                        new VisaCard("846346", 456, new Date(), "Karl", "EU", 5)}, "ID12345");

        BaseClient client2 = new LegalClient("Client2",
                new Account[]{new Account("26868", 11000), new Account("28468244", 666)},
                new BaseCard[]{new MasterCard("RF32626", 123, new Date(), "Eva", "USD", 220, "USS", Constants.MAX_TRANSFER_LIMIT),
                        new VisaCard("63564", 654, new Date(), "Eva", "EU", 3)}, "LN67890");

        MasterCardTransferService transferService = new MasterCardTransferService();
        Check check1 = transferService.transferFromCardToCard(client1.getCards()[0], client2.getCards()[0], 100, 20241027, 987654, "Transfer to Eva");
        check1.infoCheck();

        Check check2 = transferService.transferFromCardToAccount(client1.getCards()[0], client2.getAccounts()[0], 150, 20241027, 987654, "Transfer to Eva");
        check2.infoCheck();
    }
}
