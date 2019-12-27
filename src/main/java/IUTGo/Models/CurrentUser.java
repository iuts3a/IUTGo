package IUTGo.Models;

import IUTGo.Models.Users.User;

import java.io.IOException;

public class CurrentUser {
    private static CurrentUser uniqueInstance;
    private User currentUser;

    private CurrentUser(String email) {
        try {
            currentUser = User.read().get(email);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Singleton Pattern
    public static synchronized CurrentUser getInstance() {
        if (uniqueInstance != null) {
            return uniqueInstance;
        }
        return null;
    }

    public static void Init(String email) {
        uniqueInstance = new CurrentUser(email);
    }

    public User getUser() {
        return currentUser;
    }
}
