package loginData;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelp;
import lombok.val;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class PersonalAccount {
    private static final SelenideElement mainPage = $(by("data-test-id", "dashboard"));
    private static final SelenideElement yourCards = $x("//h1");
    private static final ElementsCollection cards = $$(".list__item div");
    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";

    public static void mainPageCheck() {
        mainPage.should(Condition.appear).shouldHave(Condition.exactText(DataHelp.mainPageHeadline().getHeadline()));
        yourCards.should(Condition.appear).shouldHave(Condition.exactText("Ваши карты"));
    }

    public static int getFirstCardBalance() {
        val card = cards.first().text();
        return extractBalance(card);
    }

    public static int getSecondCardBalance() {
        val card = cards.last().text();
        return extractBalance(card);
    }

    private static int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}
