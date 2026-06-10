package BasicСoncepts.TaskManagement;

import java.time.LocalDate;

public class Task implements Manageable {

    private String title;
    private String description;
    private LocalDate dueDate;
    private TaskStatus status;
    private String assignee;

    public Task(String title, String description, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = TaskStatus.TODO;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        this.title = title;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final LocalDate getDueDate() {
        return dueDate;
    }

    public final void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public final TaskStatus getStatus() {
        return status;
    }

    protected void setStatus(TaskStatus status) {
        this.status = status;
    }

    public final String getAssignee() {
        return assignee;
    }

    @Override
    public void assign(String assignee) {
        this.assignee = assignee;
    }

    @Override
    public void start() {
        setStatus(TaskStatus.IN_PROGRESS);
    }

    @Override
    public void complete() {
        setStatus(TaskStatus.DONE);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", status=" + status +
                ", dueDate=" + dueDate +
                ", assignee='" + assignee + '\'' +
                '}';
    }
}