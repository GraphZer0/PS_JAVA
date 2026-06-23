package io.cucumber.skeleton;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private String actualMessage;

    @Before
    public void beforeScenario() {
        System.out.println("Начинаем сценарий");
    }

    @After
    public void afterScenario() {
        System.out.println("Сценарий завершен");
    }

    @Given("пользователь находится на странице авторизации")
    public void userIsOnLoginPage() {
        System.out.println("Открыта страница авторизации");
    }

    @When("пользователь вводит логин {string} и пароль {string}")
    public void userEntersLoginAndPassword(String login, String password) {
        if (("user".equals(login) && "12345".equals(password))
                || ("admin".equals(login) && "admin123".equals(password))) {
            actualMessage = "Добро пожаловать";
        } else {
            actualMessage = "Ошибка авторизации";
        }
    }

    @Then("система показывает сообщение {string}")
    public void systemShowsMessage(String expectedMessage) {
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
}