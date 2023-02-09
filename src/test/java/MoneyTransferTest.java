import data.DataHelp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static data.DataHelp.firstCard;
import static data.DataHelp.secondCard;
import loginData.*;


public class MoneyTransferTest {
    LoginPage login;
    @BeforeEach
    void openChrome() {
        login = open("http://localhost:9999/", LoginPage.class);
    }

    @Test
    void topUpFirstCardBalance() {
        var vasyaLogin = DataHelp.validLogin();

        String number = "2000";

        var verif = login.loginIn(vasyaLogin.getLogin(), vasyaLogin.getPassword());
        var account = verif.setVerificationCodeAndClick(vasyaLogin.getVerificationCode());

        int check = account.getFirstCardBalance();
        int check2 = account.getSecondCardBalance();

        var replenish = account.firstButtonCheckAndClick();
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
        var vasyaLogin = DataHelp.validLogin();

        String number = "2000";

        var verif = login.loginIn(vasyaLogin.getLogin(), vasyaLogin.getPassword());
        var account = verif.setVerificationCodeAndClick(vasyaLogin.getVerificationCode());

        int check = account.getFirstCardBalance();
        int check2 = account.getSecondCardBalance();

        var replenish = account.secondButtonCheckAndClick();
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
