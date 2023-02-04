import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static data.DataHelp.firstCard;
import static data.DataHelp.secondCard;
import loginData.*;


public class MoneyTransferTest {
    String validName = "vasya";
    String validPassword = "qwerty123";
    String validVerificationCode = "12345";
    LoginPage login = new LoginPage();
    VerificationCodePage code = new VerificationCodePage();
    PersonalAccount account = new PersonalAccount();
    ReplenishTheBalance replenish = new ReplenishTheBalance();

    @BeforeEach
    void openChrome() {
        open("http://localhost:9999/");
    }

    @Test
    void topUpFirstCardBalance() {
        String number = "2000";

        login.loginIn(validName, validPassword);
        code.setVerificationCodeAndClick(validVerificationCode);
        account.mainPageCheck();

        int check = account.getFirstCardBalance();
        int check2 = account.getSecondCardBalance();

        account.firstButtonCheckAndClick();
        replenish.amountSet(number);
        replenish.fromSet(secondCard().getCardNUmber());
        replenish.confirmButtonClick();
        account.mainPageCheck();

        int expected = check + Integer.parseInt(number);
        int actual = account.getFirstCardBalance();
        Assertions.assertEquals(expected, actual);

        int expected2 = check2 - Integer.parseInt(number);
        int actual2 = account.getSecondCardBalance();
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void topUpSecondCardBalance() {
        String number = "2000";

        login.loginIn(validName, validPassword);
        code.setVerificationCodeAndClick(validVerificationCode);
        account.mainPageCheck();

        int check = account.getFirstCardBalance();
        int check2 = account.getSecondCardBalance();

        account.secondButtonCheckAndClick();
        replenish.amountSet(number);
        replenish.fromSet(firstCard().getCardNUmber());
        replenish.confirmButtonClick();
        account.mainPageCheck();

        int expected = check2 + Integer.parseInt(number);
        int actual = account.getSecondCardBalance();
        Assertions.assertEquals(expected, actual);

        int expected2 = check - Integer.parseInt(number);
        int actual2 = account.getFirstCardBalance();
        Assertions.assertEquals(expected2, actual2);

    }

}
