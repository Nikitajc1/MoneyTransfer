package loginData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement login = $("[data-test-id=login] input");
    private final SelenideElement password = $("[data-test-id=password] input");
    private final SelenideElement buttonClick = $("[data-test-id=action-login]");

    public VerificationCodePage loginIn(String name, String pass) {
        login.setValue(name);
        password.setValue(pass);
        buttonClick.click();
        return new VerificationCodePage();
    }
}
