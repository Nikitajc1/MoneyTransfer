package loginData;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import data.DataHelp;

public class Login {

    private static final SelenideElement login = $("[data-test-id=login] input");
    private static final SelenideElement password = $("[data-test-id=password] input");
    private static final SelenideElement buttonClick = $("[data-test-id=action-login]");

    public static void validLogin() {
        login.setValue(DataHelp.correctLogin().getLogin());
        password.setValue(DataHelp.correctLogin().getPassword());
        buttonClick.click();
    }

    public static void invalidLogin() {
        login.setValue(DataHelp.incorrectLogin().getLogin());
        password.setValue(DataHelp.incorrectLogin().getPassword());
        buttonClick.click();
    }

    public static void validLoginCucumber(String name, String pass) {
        login.setValue(name);
        password.setValue(pass);
        buttonClick.click();
    }
}
