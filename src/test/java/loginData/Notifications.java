package loginData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelp;

import static com.codeborne.selenide.Selenide.$;


public class Notifications {

    private static final SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");

    public static void wrongLoginNotificationCheck() {
        errorNotification.should(Condition.appear).shouldHave(Condition.exactText(DataHelp.verificationValue().getValue()));
    }
}
