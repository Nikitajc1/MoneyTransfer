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

    public static AuthInfo correctLogin() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo incorrectLogin() {
        return new AuthInfo("Katya", "12345678");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    @Value
    public static class MainPage {
        String headline;
    }

    public static MainPage mainPageHeadline() {
        return new MainPage("Личный кабинет");
    }

    @Value
    public static class Verification {
        String value;
    }

    public static Verification verificationValue() {
        return new Verification("Ошибка! Неверно указан логин или пароль");
    }

    @Value
    public static class TopUp {
        String value;
    }

    public static TopUp buttonValue() {
        return new TopUp("Пополнить");
    }

    @Value
    public static class FirstCardNumber {
        String firstCard;
    }

    public static FirstCardNumber firstCard() {
        return new FirstCardNumber("5559 0000 0000 0001");
    }

    @Value
    public static class SecondCardNumber {
        String secondCard;
    }

    public static SecondCardNumber secondCard() {
        return new SecondCardNumber("5559 0000 0000 0002");
    }
}
