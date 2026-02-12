package BasicСoncepts.TaskManagement;

public final class ProjectStats {

    private static int totalProjects = 0;
    private static int totalTasks = 0;

    private ProjectStats() {}

    public static void incrementProjects() {
        totalProjects++;
    }

    public static void incrementTasks() {
        totalTasks++;
    }

    public static int getTotalProjects() {
        return totalProjects;
    }

    public static int getTotalTasks() {
        return totalTasks;
    }
}