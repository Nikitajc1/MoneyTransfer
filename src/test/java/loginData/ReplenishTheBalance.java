package loginData;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ReplenishTheBalance {
    private final SelenideElement amountField = $("[data-test-id=amount] input");
    private final SelenideElement fromField = $("[data-test-id=from] input");
    private final SelenideElement confirmButton = $("[data-test-id=action-transfer]");

    public void amountSet(String number) {
        amountField.setValue(number);
    }

    public void fromSet(String number) {
        fromField.setValue(number);
    }

    public void confirmButtonClick() {
        confirmButton.click();
    }

}
