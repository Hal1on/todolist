package entity;

import java.util.Objects;

public class Task {
    private int id;
    private String textField;
    private boolean completed;
    private int userId;
    private String data;

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

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getId() == task.getId() &&
                isCompleted() == task.isCompleted() &&
                getUserId() == task.getUserId() &&
                Objects.equals(getTextField(), task.getTextField()) &&
                Objects.equals(getData(), task.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTextField(), isCompleted(), getUserId(), getData());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Task{");
        sb.append("id=").append(id);
        sb.append(", textField='").append(textField).append('\'');
        sb.append(", completed=").append(completed);
        sb.append(", userId=").append(userId);
        sb.append(", data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
