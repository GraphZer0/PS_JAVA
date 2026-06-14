Запуск проекта

1. Поместите файл StudentsPerformance.csv в корневую директорию проекта.
2. Соберите проект:

mvn clean compile

3. Запустите приложение:

mvn exec:java -Dexec.mainClass="org.example.Main"

После запуска программа:

* создаёт таблицу students в базе данных H2;
* читает данные из файла StudentsPerformance.csv;
* импортирует записи в базу данных с использованием PreparedStatement;
* выводит количество импортированных записей.

Пример результата:

Table created
Imported rows: 1000
Students count in database: 1000
