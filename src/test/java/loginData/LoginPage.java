package loginData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement login = $("[data-test-id=login] input");
    private final SelenideElement password = $("[data-test-id=password] input");
    private final SelenideElement buttonClick = $("[data-test-id=action-login]");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");

    public void loginIn(String name, String pass) {
        login.setValue(name);
        password.setValue(pass);
        buttonClick.click();
    }

    public void wrongLoginNotificationCheck() {
        errorNotification.should(Condition.appear).shouldHave(Condition.exactText("Ошибка! Неверно указан логин или пароль"));
    }

//    public static void validLoginCucumber(String name, String pass) {
//        login.setValue(name);
//        password.setValue(pass);
//        buttonClick.click();
//    }


}
