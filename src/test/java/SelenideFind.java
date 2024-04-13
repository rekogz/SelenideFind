import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideFind {

    @Test
    void CookiesReject() {
        open("https://www.kaspersky.com/resource-center/definitions/cookies");
        $(withText("We use cookies")).shouldBe(visible);
        $(byTagAndText("button", "Accept and Close")).click();
        $(withText("We use cookies")).shouldBe(hidden);
        sleep(5000);
    }

    @Test
    void SelenideFindTop() {
        Configuration.holdBrowserOpen = true;
//        Configuration.pageLoadStrategy = "eager";
        open("https://github.com");
        $("span.flex-1").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$("[data-testid='results-list']").first().$("a").click();
        $("[class='flex-auto min-width-0 width-fit mr-3']").shouldHave(text("selenide / selenide"));
    }
}
