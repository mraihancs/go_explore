package com.example.go_explore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileManager {
    private static final String FILE_NAME = "user_data.txt";

    public static void saveUser(User user) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            String userData = user.getUsername() + "," + user.getPassword();
            bw.write(userData);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> readUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    User user = new User(parts[0], parts[1]);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
