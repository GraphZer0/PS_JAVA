package BasicСoncepts.TaskManagement;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Task t1 = new Task("Code", "Write Java code",
                LocalDate.of(2026, 2, 20));
        Task t2 = new Task("Test", "Write tests",
                LocalDate.of(2026, 2, 18));

        Project project = new Project("Demo Project");
        project.addTask(t1);
        project.addTask(t2);

        project.sortTasks(Project.TaskComparator.SortType.BY_DATE);

        TaskManager manager = new TaskManager();
        manager.addProject(project);

        manager.showAllProjects();

        System.out.println("Projects: " +
                ProjectStats.getTotalProjects());
        System.out.println("Tasks: " +
                ProjectStats.getTotalTasks());
    }
}