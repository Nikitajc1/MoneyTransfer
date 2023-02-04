package loginData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelp;
import static com.codeborne.selenide.Selenide.$;

public class VerificationCodePage {

    private final SelenideElement verificationCode = $("[data-test-id=code] input");
    private final SelenideElement verificationButton = $("[data-test-id=action-verify]");

    public void setVerificationCodeAndClick(String code) {
        verificationCode.should(Condition.appear).setValue(code);
        verificationButton.click();
    }

}
