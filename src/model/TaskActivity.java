package model;

public class TaskActivity extends Activity {
    private boolean completed;

    public TaskActivity(String title, String description) {
        super(title, description);
        this.completed = false;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Completed: " + completed);
    }
}
