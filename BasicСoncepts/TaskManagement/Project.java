package BasicСoncepts.TaskManagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Project implements Manageable {

    private String name;
    private List<Task> tasks = new ArrayList<>();
    private String manager;

    public Project(String name) {
        this.name = name;
        ProjectStats.incrementProjects();
    }

    public void addTask(Task task) {
        tasks.add(task);
        ProjectStats.incrementTasks();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public static class TaskComparator implements Comparator<Task> {

        public enum SortType {
            BY_TITLE,
            BY_DATE,
            BY_STATUS
        }

        private SortType sortType;

        public TaskComparator(SortType sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Task t1, Task t2) {
            switch (sortType) {
                case BY_TITLE:
                    return t1.getTitle().compareTo(t2.getTitle());
                case BY_DATE:
                    return t2.getDueDate().compareTo(t1.getDueDate());
                case BY_STATUS:
                    return t1.getStatus().compareTo(t2.getStatus());
                default:
                    return 0;
            }
        }
    }

    public void sortTasks(TaskComparator.SortType type) {
        tasks.sort(new TaskComparator(type));
    }

    @Override
    public void assign(String assignee) {
        this.manager = assignee;
    }

    @Override
    public void start() {
        for (Task task : tasks) {
            if (task.getStatus() == TaskStatus.TODO) {
                task.start();
            }
        }
    }

    @Override
    public void complete() {
        for (Task task : tasks) {
            task.complete();
        }
    }
}