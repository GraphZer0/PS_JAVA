# Gradle String Reverser

## Описание

Проект создан с использованием Gradle.

Приложение выводит инвертированную строку "Hello, World!" с помощью Apache Commons Lang3, а также демонстрирует использование собственной библиотеки.

Пример вывода:

text !dlroW ,olleH Custom library result: !dlroW ,olleH 

## Используемые технологии

- Java 21
- Gradle
- Apache Commons Lang3

## Внешние зависимости

Используется библиотека Apache Commons Lang3:

groovy implementation 'org.apache.commons:commons-lang3:3.14.0' 

Применяется для вызова:

java StringUtils.reverse(text); 

## Собственная библиотека

В проекте реализован отдельный модуль:

text utilities 

Он содержит класс:

java TextFormatter 

Пример использования:

java TextFormatter.addPrefix(reversed); 

Подключение библиотеки выполняется через:

groovy implementation project(':utilities') 

## Сборка проекта

bash ./gradlew build 

## Запуск проекта

bash ./gradlew run 

## Сборка JAR библиотеки

bash ./gradlew :utilities:jar 

Полученный JAR находится в каталоге:

text utilities/build/libs/ 
