# Bazel String Reverser

## Описание

Проект создан с использованием Bazel.

Приложение выводит инвертированную строку "Hello, World!" с помощью библиотеки Apache Commons Lang3 и демонстрирует использование собственной Java-библиотеки.

Пример вывода:

text !dlroW ,olleH Custom Bazel library result: !dlroW ,olleH 

## Используемые технологии

- Java 21
- Bazel
- Apache Commons Lang3
- rules_jvm_external

## Внешние зависимости

Apache Commons Lang3 подключается через Maven Central в файле:

text MODULE.bazel 

Зависимость:

text org.apache.commons:commons-lang3:3.14.0 

Использование:

java StringUtils.reverse(text); 

## Собственная библиотека

Создана библиотека:

text mylib 

Содержит класс:

java TextFormatter 

Использование:

java TextFormatter.addPrefix(reversed); 

Подключение выполняется через:

python deps = [     "//mylib:mylib" ] 

## Сборка проекта

bash bazel build //app:app 

## Запуск проекта

bash bazel run //app:app 

## Сборка собственной библиотеки

bash bazel build //mylib:mylib 

Собранный JAR находится в каталоге:

text bazel-bin/ 
