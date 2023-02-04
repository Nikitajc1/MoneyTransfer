package data;

import lombok.Value;

public class DataHelp {
    private DataHelp() {
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Value
    public static class CardNumber {
        String cardNUmber;
    }

    public static CardNumber firstCard() {
        return new CardNumber("5559 0000 0000 0001");
    }

    public static CardNumber secondCard() {
        return new CardNumber("5559 0000 0000 0002");
    }
}
