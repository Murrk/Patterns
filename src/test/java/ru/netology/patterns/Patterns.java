package ru.netology.patterns;

import com.codeborne.selenide.Condition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Patterns {
        private String serviceUrl = "http://localhost:9999/";
        private String cityInputCss = "[data-test-id='city'] input.input__control";
        private String nameInputCss = "[data-test-id='name'] input.input__control";
        private String dateInputCss = "[data-test-id='date'] input.input__control";
        private String phoneInputCss = "[data-test-id='phone'] input.input__control";
        private String checkBoxCss = "[data-test-id=agreement]";
        private String successNotificationCss = "[data-test-id=success-notification]";
        private String submitButtonTag = ".button";
        private String calendarClickCss = ".icon_name_calendar";
        private String calendarLayoutCss = ".calendar__layout";
        private String calendarDayCss = ".calendar__day";
        private DataGenerator.User user;
        private DataGenerator.User user1;

        @BeforeEach
        void setUp() {

            user = DataGenerator.getUserInfo();
            user1 = DataGenerator.getUserInfo();
        }

        @Test
        @DisplayName("Все поля заполнены верно, первая заявка")
        void shouldTestPositive() {

            open(serviceUrl);
            $(cityInputCss).setValue(DataGenerator.getCity());
            $(dateInputCss).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            $(dateInputCss).setValue(DataGenerator.getNextDate("3", "dd.MM.yyyy"));
            $(nameInputCss).setValue(user.getFullName());
            $(phoneInputCss).setValue(user.getPhone());
            $(checkBoxCss).click();
            $$(submitButtonTag).find(Condition.exactText("Запланировать")).click();
            $(withText("Успешно")).waitUntil(visible, 5000);
        }

        @Test
        @DisplayName("Все поля заполнены верно, успешное перепланирование даты")
        void shouldTestPositiveReplanning() {

            open(serviceUrl);
            $(cityInputCss).setValue(DataGenerator.getCity());
            $(dateInputCss).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            $(dateInputCss).setValue(DataGenerator.getNextDate("3", "dd.MM.yyyy"));
            $(nameInputCss).setValue(user.getFullName());
            $(phoneInputCss).setValue(user.getPhone());
            $(checkBoxCss).click();
            $$(submitButtonTag).find(Condition.exactText("Запланировать")).click();
            $(successNotificationCss).waitUntil(visible, 5000);
            $(calendarClickCss).click();
            $(calendarLayoutCss).waitUntil(visible, 5000);
            $(dateInputCss).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            $$(calendarDayCss).find(exactText(DataGenerator.getNextDate("7","d"))).click();
            $$(submitButtonTag).find(Condition.exactText("Запланировать")).click();
            $(withText("Необходимо подтверждение")).waitUntil(visible, 5000);
            $$(submitButtonTag).find(Condition.exactText("Перепланировать")).click();
            $(withText("Успешно")).waitUntil(visible, 5000);
        }

        @Test
        @DisplayName("Все поля заполнены верно, имя новое, телефон тот же, не предлагает перепланировать ")
        void shouldTestPositiveNoReplanning() {

            open(serviceUrl);
            $(cityInputCss).setValue(DataGenerator.getCity());
            $(dateInputCss).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            $(dateInputCss).setValue(DataGenerator.getNextDate("3", "dd.MM.yyyy"));
            $(nameInputCss).setValue(user.getFullName());
            $(phoneInputCss).setValue(user.getPhone());
            $(checkBoxCss).click();
            $$(submitButtonTag).find(Condition.exactText("Запланировать")).click();
            $(successNotificationCss).waitUntil(visible, 5000);
            $(nameInputCss).setValue(user1.getFullName());
            $(calendarClickCss).click();
            $(calendarLayoutCss).waitUntil(visible, 5000);
            $(dateInputCss).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            $$(calendarDayCss).find(exactText(DataGenerator.getNextDate("7","d"))).click();
            $$(submitButtonTag).find(Condition.exactText("Запланировать")).click();
            $(withText("Успешно")).waitUntil(visible, 5000);
        }
}


