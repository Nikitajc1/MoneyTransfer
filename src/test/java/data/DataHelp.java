package data;

import lombok.Value;

public class DataHelp {
    private DataHelp() {
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
        String verificationCode;
    }

    public static AuthInfo validLogin() {
        return new AuthInfo("vasya", "qwerty123", "12345");
    }

    public static AuthInfo invalidLogin() {
        return new AuthInfo("Kayta", "12345","11111");
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
