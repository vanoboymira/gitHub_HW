package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

public class RegistrationTests extends TestBase{

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
        String pictureFIleName = "brad_pitt.png";
        String pictureSource = "src/test/resources/img/1.png";
        String stateAndCity = "NCR Delhi";
        String hobbieSport = "Sports";
        String state = "NCR";
        String city = "Delhi";

        registrationPage.openPage()
            .setFirstName(userName)
            .setFirstName(userName)
            .setLastName("Vasiliev")
            .setEmail("vasia@xerov.com")
            .setPhone("1234567890")
            .setBirthDay("29","January", "1986")
            .setSubject(subject)
            .uploadPhoto(pictureSource)
            .setAddress(currentAddress)
            .selectState(state)
            .selectCity(city)
            .clickSubmitButton();

        //$(".custom-control-label").click();
        //$("#currentAddress").setValue("Brsteevskja street 23/1/57");
        //$("#subjectsInput").setValue("Chemistry").pressEnter();
        //$("#hobbiesWrapper").$(byText("Sports")).click();
        //$("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        //$("#state").click();
        //$("#stateCity-wrapper").$(byText("NCR")).click();
        //$("#city").click();
        //$("#stateCity-wrapper").$(byText("Delhi")).click();
        //$("#submit").click();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " Vasiliev")
                .verifyResult("Student Email", "vasia@xerov.com")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "29 January,1986")
                .verifyResult("Address", currentAddress)
                .verifyResult("Subjects", subject)
                .verifyResult("Picture", pictureFIleName)
                .verifyResult("State and City", stateAndCity);



    }
}
