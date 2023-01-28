package loginData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelp;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class Buttons {
    private static final ElementsCollection topUpButtons = $$x("//button//span[contains(text(), 'Пополнить')]");
    private static final SelenideElement confirmButton = $("[data-test-id=action-transfer]");
    private static final SelenideElement cancelButton = $("[data-test-id=action-cancel]");
    private static final SelenideElement updateButton = $("[data-test-id=action-reload]");

    public static void firstButtonCheckAndClick() {
        topUpButtons.get(0).shouldHave(Condition.exactText(DataHelp.buttonValue().getValue())).click();
    }

    public static void secondButtonCheckAndClick() {
        topUpButtons.get(1).shouldHave(Condition.exactText(DataHelp.buttonValue().getValue())).click();
    }

    public static void confirmButtonClick() {
        confirmButton.click();
    }

    public static void cancelButtonClick() {cancelButton.click();}

    public static void updateButtonClick() {updateButton.click();}
}
