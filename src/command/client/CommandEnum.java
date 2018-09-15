package command.client;

import command.ActionCommand;
import command.commands.todolist.DeleteTaskCommand;
import command.commands.todolist.EditTaskCommand;
import command.commands.authorization.LoginCommand;
import command.commands.authorization.LogoutCommand;
import command.commands.authorization.RegistrationCommand;
import command.commands.todolist.AddTaskCommand;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    },
    ADDTASK {
        {
            this.command = new AddTaskCommand();
        }
    },
    EDIT {
        {
            this.command = new EditTaskCommand();
        }
    },
    DELETE {
        {
            this.command = new DeleteTaskCommand();
        }
    };



    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}