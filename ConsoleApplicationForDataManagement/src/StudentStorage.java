import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//управляет данными о клиенте
public class StudentStorage {
    private Map<Long,Student> studentStorageMap =  new HashMap<>(); //сделаем некий счетчик который будет генерировать

    private StudentSurnameStorage studentSurnameStorage = new StudentSurnameStorage();
    //уникальный индентификатор

    private Long currentId = 0L;


    /*
    Создание данных о студенте
    @param student данные о студенте
    @return сгенерированный уникальный индентификатор студента
     */
    public Long createStudent(Student student) {
        Long nextId = getNextId();
        studentStorageMap.put(nextId, student);
        studentSurnameStorage.studentCreated(nextId, student.getSurname());
        return nextId;
    }

    /*
    Обновление данных о студенте
    @param id индетификатор студента
    @param student данные студента
    @return true если данные были обновлены, false если студент не был найден
     */
    public boolean updateStudent(Long id, Student student) {
        if(!studentStorageMap.containsKey(id)) { // проверяем   существует ли такой студент с таким индентификатором и если его нет
            return  false;
        } else  {
            String newSurname = student.getSurname();
            String oldSurname = studentStorageMap.get(id).getSurname();
            studentSurnameStorage.studentUpdated(id, oldSurname, newSurname);
            studentStorageMap.put(id, student); //если есть, должны положить
            return true;
        }
    }


    /*
    Удаляет данные о студенте
    @param id получает индентификатор студента
    @return true если студент был удален, false если студент не был найден
    по индентификатору
     */
    public boolean deleteStudent(Long id) {
        Student removed = studentStorageMap.remove(id);
        if (removed != null) {
            String surname = removed.getSurname();
            studentSurnameStorage.studentDeleted(id, surname);
        }
        return removed != null;
    }

    public void search(String surname) {
        Set<Long> students =  studentSurnameStorage
                .getStudentBySurnamesLessOrEqualThan(surname);
        for (Long studentId : students) {
            Student student = studentStorageMap.get(studentId);
            System.out.println(student);
        }
    }

    public Long getNextId() {
        currentId = currentId + 1;
        return currentId;
    }

    public void printAll() {
        System.out.println(studentStorageMap);
    }

    public void printMap(Map<String, Long> data) {
        data.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + " - " + e.getValue());
        });
    }

    public Map<String, Long> getCountByCourse() {
        Map<String, Long> res =  studentStorageMap.values().stream().collect(Collectors.toMap(
                student -> student.getCourse(),
                student -> 1L,
                (count1, count2) -> count1 + count2
        ));
        return res;
    }



}
