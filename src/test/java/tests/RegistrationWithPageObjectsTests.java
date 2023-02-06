package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationWithPageObjectsTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void successfulRegistrationTest(){
        String userName = "Vasia";
        String lastName = "Vasiliev";
        String email = "vasia@xerov.com";
        String phoneNumber = "1234567890";
        String currentAddress = "Brsteevskja street 23/1/57";
        String gender = "Male";
        String dateOfBirth = "29 January,1986";
        String subject = "Chemistry";
        String hobbies = "Sports";
        String pictureSource = "src/test/resources/img/1.png";
        String stateAndCity = "NCR Delhi";
        String state = "NCR";
        String city = "Delhi";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(userName);
        $("#lastName").setValue("Vasiliev");
        $("#userEmail").setValue("vasia@xerov.com");
        $("#userNumber").setValue("1234567890");
        $("#genterWrapper").$(byText("Male")).click();
        $("#currentAddress").setValue("Brsteevskja street 23/1/57");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1986");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(userName + " " + lastName), (text(email)),
                (text(phoneNumber)), (text(currentAddress)), (text(gender)),
                (text(dateOfBirth)), (text(subject)), (text(hobbies)),
                (text(hobbies)), (text(stateAndCity)));
    }
}


