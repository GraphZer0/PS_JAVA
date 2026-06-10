import java.util.Map;

public class StudentCommandHandler {
    private StudentStorage studentStorage = new StudentStorage();

    public void processCommand(Command command) {
        Action action = command.getAction();
        switch (action) {
            case CREATE -> {
                processCreateCommand(command);
                break;
            }
            case UPDATE -> {
                processUpdateCommand(command);
                break;
            }
            case DELETE -> {
                processDeleteCommand(command);
                break;
            }
            case STATS_BY_COURSE -> {
                processStatsByCourseCommand(command);
                break;
            }
            case STATS_BY_CITY -> {
                processStatsByCityCommand(command);
                break;
            }
            case SEARCH -> {
                processSearchCommand(command);
                break;
            }
            default -> {
                System.out.println("Действие " + action + " не поддерживается");
            }
        }
        System.out.println("Обработка команды. Действие: "
                + command.getAction().name() +
                ", данные: " + command.getData());
    }

    private void processSearchCommand(Command command) {
        try {
            String surname = command.getData();
            Validator.validateSurnameForSearch(surname);
            studentStorage.search(surname.trim());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации при поиске: " + e.getMessage());
        }
    }

    private void processStatsByCourseCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCourse();
        studentStorage.printMap(data);
    }

    private void processStatsByCityCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCity();
        studentStorage.printMap(data);
    }

    /**
     * Формат ввода: Фамилия,Имя,Курс,Город,Возраст
     * Пример: Иванов,Иван,Математика,Москва,20
     */
    private void processCreateCommand(Command command) {
        try {
            String data = command.getData();
            String[] dataArr = data.split(",");

            Validator.validateFieldCount(dataArr, 5, "создания студента (Фамилия,Имя,Курс,Город,Возраст)");

            String surname = dataArr[0];
            String name    = dataArr[1];
            String course  = dataArr[2];
            String city    = dataArr[3];
            String ageStr  = dataArr[4];

            Validator.validateName(surname, "фамилия");
            Validator.validateName(name, "имя");
            Validator.validateCourse(course);
            Validator.validateCity(city);
            Integer age = Validator.validateAge(ageStr);

            Student student = new Student();
            student.setSurname(surname.trim());
            student.setName(name.trim());
            student.setCourse(course.trim());
            student.setCity(city.trim());
            student.setAge(age);

            studentStorage.createStudent(student);
            studentStorage.printAll();

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации при создании студента: " + e.getMessage());
        }
    }

    /**
     * Формат ввода: ID,Фамилия,Имя,Курс,Город,Возраст
     * Пример: 1,Петров,Пётр,Физика,Санкт-Петербург,22
     */
    private void processUpdateCommand(Command command) {
        try {
            String data = command.getData();
            String[] dataArr = data.split(",");

            Validator.validateFieldCount(dataArr, 6, "обновления студента (ID,Фамилия,Имя,Курс,Город,Возраст)");

            String idStr   = dataArr[0];
            String surname = dataArr[1];
            String name    = dataArr[2];
            String course  = dataArr[3];
            String city    = dataArr[4];
            String ageStr  = dataArr[5];

            Long id = Validator.validateId(idStr);
            Validator.validateName(surname, "фамилия");
            Validator.validateName(name, "имя");
            Validator.validateCourse(course);
            Validator.validateCity(city);
            Integer age = Validator.validateAge(ageStr);

            Student student = new Student();
            student.setSurname(surname.trim());
            student.setName(name.trim());
            student.setCourse(course.trim());
            student.setCity(city.trim());
            student.setAge(age);

            boolean updated = studentStorage.updateStudent(id, student);
            if (!updated) {
                System.out.println("Студент с ID=" + id + " не найден.");
            } else {
                studentStorage.printAll();
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации при обновлении студента: " + e.getMessage());
        }
    }

    /**
     * Формат ввода: ID
     * Пример: 1
     */
    private void processDeleteCommand(Command command) {
        try {
            String data = command.getData();

            Long id = Validator.validateId(data);

            boolean deleted = studentStorage.deleteStudent(id);
            if (!deleted) {
                System.out.println("Студент с ID=" + id + " не найден.");
            } else {
                studentStorage.printAll();
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации при удалении студента: " + e.getMessage());
        }
    }
}
