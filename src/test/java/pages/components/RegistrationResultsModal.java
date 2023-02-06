package pages.components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public void verifyModalAppears(){
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg")
                .shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResualt(String kay, String value){
        $(".table-responsive").$(byText(kay)).parent()
                .shouldHave(text(value));

    }

    }
