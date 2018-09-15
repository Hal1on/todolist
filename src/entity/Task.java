package entity;

public class Task {
    private int id;
    private String textField;
    private boolean completed;
    private int userId;

    public Task() {
    }

    public Task(int id, String textField, boolean completed, int userId) {
        this.id = id;
        this.textField = textField;
        this.completed = completed;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
