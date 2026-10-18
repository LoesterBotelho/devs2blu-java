package exercicios18102026parte0.oo.exercicio2;

public abstract class WorkItem {

    private final String id;
    private final String title;
    private final int estimatedHours;
    private boolean completed;

    protected WorkItem(
            String id,
            String title,
            int estimatedHours) {

        this.id = id;
        this.title = title;
        this.estimatedHours = estimatedHours;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        completed = true;
    }

    public abstract String getWorkType();
}