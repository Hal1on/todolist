package command;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    // Constants
    String TASK_ID = "task_id";
    String TEXT_FIELD = "text_field";
    String DATA = "data";
    String PREVIOUS_DATA = "previous_data";
    String PREVIOUS_TEXT_FIELD = "previous_text_field";
    String TASKS = "tasks";
    String COMPLETED = "completed";
    String USER_ID = "user_id";
    String LOGIN = "login";
    String PASSWORD = "password";
    String USER_EXIST = "user_exist";

    /**
     * Execute command.
     *
     * @param request request that come from
     * @return
     */
    String execute(HttpServletRequest request);
}