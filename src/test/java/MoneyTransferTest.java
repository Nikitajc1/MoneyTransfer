import data.DataHelp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static data.DataHelp.firstCard;
import static data.DataHelp.secondCard;
import static data.DataHelp.validLogin;
import static data.DataHelp.invalidLogin;
import loginData.*;


public class MoneyTransferTest {
    @BeforeEach
    void openChrome() {
        open("http://localhost:9999/");
    }

    @Test
    void topUpFirstCardBalance() {
        var login = new LoginPage();
        var code = new VerificationCodePage();
        var account = new PersonalAccount();
        var replenish = new ReplenishTheBalance();


        String number = "2000";

        login.loginIn(validLogin().getLogin(), validLogin().getPassword());
        code.setVerificationCodeAndClick(validLogin().getVerificationCode());
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
        var login = new LoginPage();
        var code = new VerificationCodePage();
        var account = new PersonalAccount();
        var replenish = new ReplenishTheBalance();


        String number = "2000";

        login.loginIn(validLogin().getLogin(), validLogin().getPassword());
        code.setVerificationCodeAndClick(validLogin().getVerificationCode());
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
