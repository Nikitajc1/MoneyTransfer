package loginData;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AmountFrom {
    private static final SelenideElement amountField = $("[data-test-id=amount] input");
    private static final SelenideElement fromField = $("[data-test-id=from] input");

    public static void amountSet(String number) {
        amountField.setValue(number);
    }

    public static void fromSet(String number) {
        fromField.setValue(number);
    }
}
