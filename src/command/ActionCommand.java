package command;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String PAGE_TYPE = "page_type";

    String TASK_ID = "task_id";
    String TEXT_FIELD = "text_field";
    String PREVIOUS_TEXT_FIELD = "previous_text_field";
    String TASKS = "tasks";
    String COMPLETED = "completed";

    String USER_ID = "user_id";
    String LOGIN = "login";
    String PASSWORD = "password";
    String USER_EXIST = "user_exist";


    String FORM = "form";
    String STATUS = "status";


    String execute(HttpServletRequest request);
}