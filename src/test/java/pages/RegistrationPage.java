package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            lastNameInput = $("#lastName"),
            firstNameInput = $("#firstName"),
            dataOfBirthDayInput = $("#dateOfBirthInput"),
            UserPhoneNumber = $("#userNumber"),
             DateOfBirthInput = $("#dateOfBirthInput"),
            SubjectInput = $("#subjectsInput"),
             HobbiesChoose = $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),

            setAddressInput = $("#currentAddress"),
            selectStatePopUp = $("#state"),
            selectState = $("#stateCity-wrapper"),
            selectCityPopUp = $("#city"),
            selectCity = $("#city"),
            SubmitButton = $("#submit");;

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage clearLastName() {
        lastNameInput.click();

        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value);

        return this;

    }
    public RegistrationPage setBirthDay(String day,String month,String year) {
        dataOfBirthDayInput.click();
        calendarComponent.setData(day, month, year);

        return this;

    }
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }
    public RegistrationPage verifyResult(String kay, String value) {
        registrationResultsModal.verifyResualt(kay, value);

        return this;
    }
public RegistrationPage setSubject(String text) {
    SubjectInput.setValue(text).pressEnter();
    return this;
}

    public RegistrationPage setHobbie(String text) {
        HobbiesChoose.$(byText(text)).click();
        return this;
    }

    public RegistrationPage uploadPhoto(String text) {
        uploadPictureButton.uploadFromClasspath(text);
        return this;
    }

    public RegistrationPage setAddress(String text) {
        setAddressInput.setValue(text);
        return this;
    }

    public RegistrationPage selectState(String text) {
        selectStatePopUp.click();
        selectState.$(byText(text)).click();
        return this;
    }

    public RegistrationPage selectCity(String text) {
        selectCityPopUp.click();
        selectCity.$(byText(text)).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        SubmitButton.click();
        return this;
    }
}

