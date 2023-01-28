import exception.Error;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static data.DataHelp.firstCard;
import static data.DataHelp.secondCard;

import loginData.*;


public class MoneyTransferTest {

    @BeforeEach
    void openChrome() {
        open("http://localhost:9999/");
    }

    @Test
    void validLogin() {
        Login.validLogin();
        VerificationCode.setVerificationCodeAndClick();
        PersonalAccount.mainPageCheck();
    }

    @Test
    void invalidLogin() {
        Login.invalidLogin();
        Notifications.wrongLoginNotificationCheck();
    }

    @Test
    void topUpFirstCardBalance() {
        String number = "2000";

        Login.validLogin();
        VerificationCode.setVerificationCodeAndClick();
        PersonalAccount.mainPageCheck();

        int initialAmount = PersonalAccount.getFirstCardBalance();

        Buttons.firstButtonCheckAndClick();
        AmountFrom.amountSet(number);
        AmountFrom.fromSet(secondCard().getSecondCard());
        Buttons.confirmButtonClick();
        PersonalAccount.mainPageCheck();

        int balanceNow = PersonalAccount.getFirstCardBalance();
        int check = Integer.parseInt(number) + initialAmount;

        if (balanceNow == check) {
            closeWindow();
        } else {
            throw new Error("Неверное количество");
        }
    }

    @Test
    void topUpSecondCardBalance() {
        String number = "2000";

        Login.validLogin();
        VerificationCode.setVerificationCodeAndClick();
        PersonalAccount.mainPageCheck();

        int initialAmount = PersonalAccount.getSecondCardBalance();

        Buttons.secondButtonCheckAndClick();
        AmountFrom.amountSet(number);
        AmountFrom.fromSet(firstCard().getFirstCard());
        Buttons.confirmButtonClick();
        PersonalAccount.mainPageCheck();

        int balanceNow = PersonalAccount.getSecondCardBalance();
        int check = Integer.parseInt(number) + initialAmount;

        if (balanceNow == check) {
            closeWindow();
        } else {
            throw new Error("Неверное количество");
        }
    }

    @Test
    void cancelButton() {
        Login.validLogin();
        VerificationCode.setVerificationCodeAndClick();
        PersonalAccount.mainPageCheck();

        Buttons.firstButtonCheckAndClick();
        Buttons.cancelButtonClick();
        PersonalAccount.mainPageCheck();

    }

    @Test
    void updateButton() {
        Login.validLogin();
        VerificationCode.setVerificationCodeAndClick();
        PersonalAccount.mainPageCheck();

        Buttons.updateButtonClick();
        PersonalAccount.mainPageCheck();
    }
}
