package loginData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelp;
import static com.codeborne.selenide.Selenide.$;

public class VerificationCode {

    private static final SelenideElement verificationCode = $("[data-test-id=code] input");
    private static final SelenideElement verificationButton = $("[data-test-id=action-verify]");

    public static void setVerificationCodeAndClick() {
        verificationCode.should(Condition.appear).setValue(DataHelp.getVerificationCode().getCode());
        verificationButton.click();
    }

    public static void setVerificationCodeCucumber(String code) {
        verificationCode.should(Condition.appear).setValue(code);
        verificationButton.click();
    }
}
