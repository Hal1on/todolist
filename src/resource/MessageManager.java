package resource;

import java.util.ResourceBundle;
/**
 * Class extracts information from messages.properties file.
 */
public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    private MessageManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}