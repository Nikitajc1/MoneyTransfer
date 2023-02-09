package loginData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class PersonalAccount {
    private final SelenideElement mainPage = $(by("data-test-id", "dashboard"));
    private final SelenideElement yourCards = $x("//h1");
    private final ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    private final ElementsCollection topUpButtons = $$("[data-test-id=action-deposit]");

    public PersonalAccount mainPageCheck() {
        mainPage.should(Condition.appear).shouldHave(Condition.exactText("Личный кабинет"));
        yourCards.should(Condition.appear).shouldHave(Condition.exactText("Ваши карты"));
        return new PersonalAccount();
    }

    public int getFirstCardBalance() {
        var card = cards.first().text();
        return extractBalance(card);
    }

    public int getSecondCardBalance() {
        var card = cards.last().text();
        return extractBalance(card);
    }

    private int extractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public ReplenishTheBalance firstButtonCheckAndClick() {
        topUpButtons.get(0).shouldHave(Condition.exactText("Пополнить")).click();
        return new ReplenishTheBalance();
    }

    public ReplenishTheBalance secondButtonCheckAndClick() {
        topUpButtons.get(1).shouldHave(Condition.exactText("Пополнить")).click();
        return new ReplenishTheBalance();
    }
}
