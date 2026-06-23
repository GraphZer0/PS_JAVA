@login
Feature: Авторизация пользователя

  Background:
    Given пользователь находится на странице авторизации

  @positive
  Scenario Outline: Успешная авторизация
    When пользователь вводит логин "<login>" и пароль "<password>"
    Then система показывает сообщение "Добро пожаловать"

    Examples:
      | login | password |
      | user  | 12345    |
      | admin | admin123 |

  @negative
  Scenario: Ошибка при неверном пароле
    When пользователь вводит логин "user" и пароль "wrong"
    Then система показывает сообщение "Ошибка авторизации"
