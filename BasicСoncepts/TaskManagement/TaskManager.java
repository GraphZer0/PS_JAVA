package BasicСoncepts.TaskManagement;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Project> projects = new ArrayList<>();

    public void addProject(Project project) {
        projects.add(project);
    }

    public void showAllProjects() {
        for (Project project : projects) {
            System.out.println("Project with " +
                    project.getTasks().size() + " tasks");
        }
    }
}