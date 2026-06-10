# Maven String Reverser

## Описание

Проект создан с использованием Apache Maven.

Реализован вывод инвертированной строки "Hello, World!" с помощью библиотеки Apache Commons Lang3 и метода StringUtils.reverse().

Пример вывода:

text !dlroW ,olleH 

## Используемые технологии

- Java 21
- Maven
- Apache Commons Lang3

## Внешние зависимости

Используется библиотека:

xml <dependency>     <groupId>org.apache.commons</groupId>     <artifactId>commons-lang3</artifactId>     <version>3.14.0</version> </dependency> 

Библиотека применяется для инвертирования строки:

java StringUtils.reverse("Hello, World!"); 

## Сборка проекта

bash mvn clean compile 

## Запуск проекта

bash mvn exec:java -Dexec.mainClass="com.example.App" 

## Собственная библиотека

В данном проекте собственная библиотека не используется. Она реализована в проектах Gradle и Bazel в соответствии с требованиями задания.
