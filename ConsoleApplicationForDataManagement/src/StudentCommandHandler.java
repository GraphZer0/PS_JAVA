import java.util.Map;

public class StudentCommandHandler {

    private StudentStorage studentStorage =  new StudentStorage();

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

            case SEARCH -> {
                processSearchCommand(command);
                break;
            }

            default -> {
                System.out.println("Действие" + action +  "не подерживается");
            }
        }

        System.out.println("Обработка команды. Действие: "
                + command.getAction().name() +
                ", данные: " + command.getData());

    }

    private void processSearchCommand(Command command) {
        String surname = command.getData();
        studentStorage.search(surname);
    }

    private void processStatsByCourseCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCourse();
        studentStorage.printMap(data);
    }

    private void processCreateCommand(Command command) {
        String data = command.getData();
        String[] dataArr = data.split(",");

        Student student = new Student();
        student.setSurname(dataArr[0]); //студент - это все объект
        student.setName(dataArr[1]);
        student.setCourse(dataArr[2]);
        student.setCity(dataArr[3]);
        student.setAge(Integer.valueOf(dataArr[4]));

        studentStorage.createStudent(student);
        studentStorage.printAll();
    }
    private void processUpdateCommand(Command command) {
        String data = command.getData();
        String[] dataArr = data.split(",");
        Long id = Long.valueOf(dataArr[0]);

        Student student = new Student();
        student.setSurname(dataArr[1]); //студент - это все объект
        student.setName(dataArr[2]);
        student.setCourse(dataArr[3]);
        student.setCity(dataArr[4]);
        student.setAge(Integer.valueOf(dataArr[5]));

        studentStorage.updateStudent(id, student);
        studentStorage.printAll();
    }

    private void processDeleteCommand(Command command) {
        String data = command.getData();
        Long id = Long.valueOf(data);
        studentStorage.deleteStudent(id);
        studentStorage.printAll();


    }
}
