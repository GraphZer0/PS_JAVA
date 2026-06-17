# Требования к выполнению WarehouseServiceTest

В архиве обновлены тесты для `src/test/java/ru/productstar/mockito/service/WarehouseServiceTest.java`.

Выполнено:

1. Заполнено тело тестов `WarehouseServiceTest`.
2. Добавлены тесты для складской логики:
   - добавление товара на склад;
   - проверка доступности товара;
   - выбор ближайшего склада;
   - граничный случай с нулевым запасом;
   - недостаточное количество товара;
   - ошибка при отрицательном количестве.
3. Используется `@Mock` для `WarehouseRepository`.
4. Используются аннотации JUnit и Mockito:
   - `@ExtendWith(MockitoExtension.class)`;
   - `@Mock`;
   - `@BeforeEach`;
   - `@Test`.
5. К каждому тесту добавлен комментарий с описанием цели.
6. В `WarehouseService` добавлена проверка отрицательного количества, чтобы сценарий ошибки был явно обработан:

```java
if (count < 0) {
    throw new IllegalArgumentException("Количество товара не может быть отрицательным");
}
```

Запуск тестов:

```bash
mvn test
```
