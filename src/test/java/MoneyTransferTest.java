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

        login.loginIn(validName, validPassword);
        code.setVerificationCodeAndClick(validVerificationCode);
        account.mainPageCheck();


        account.firstButtonCheckAndClick();
        replenish.amountSet("2000");
        replenish.fromSet(secondCard().getCardNUmber());
        replenish.confirmButtonClick();
        account.mainPageCheck();

        String expected = "12000";
        String actual = account.getFirstCardBalance();
        Assertions.assertEquals(expected, actual);

        String expected2 = "8000";
        String actual2 = account.getSecondCardBalance();
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void topUpSecondCardBalance() {

        login.loginIn(validName, validPassword);
        code.setVerificationCodeAndClick(validVerificationCode);
        account.mainPageCheck();

        account.secondButtonCheckAndClick();
        replenish.amountSet("2000");
        replenish.fromSet(firstCard().getCardNUmber());
        replenish.confirmButtonClick();
        account.mainPageCheck();

        String expected = "10000";
        String actual = account.getSecondCardBalance();
        Assertions.assertEquals(expected, actual);

        String expected2 = "10000";
        String actual2 = account.getFirstCardBalance();
        Assertions.assertEquals(expected2, actual2);

    }

}
