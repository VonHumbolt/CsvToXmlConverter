package com.kaankaplan;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.util.*;

public class CsvFileReader {

    public static Set<User> readCsv(String filename) {

        Set<User> userSet = new LinkedHashSet<>();

        try {
            String inputFilename = Constant.FILE_PATH + filename;

            CsvReader data = new CsvReader(inputFilename);

            data.readHeaders();

            while (data.readRecord()){
                String username = data.get("username");
                String firstname = data.get("firstname");
                String lastname = data.get("lastname");
                String email = data.get("email");
                String role = data.get("role");

                List<String> roleList = new ArrayList<>();
                roleList.add(role);

                User user = new User(username, firstname, lastname, email, roleList);

                boolean isAdded = userSet.add(user);
                if (!isAdded)
                    addNewRoleToUser(userSet, user);
            }

            data.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return userSet;
    }

    private static void addNewRoleToUser(Set<User> userSet, User user) {
        Optional<User> userWithUsername = userSet.stream()
                .filter(u -> u.getUsername().equals(user.getUsername()))
                .findFirst();

        userWithUsername.ifPresent(u -> u
                .getRoles()
                .add(user.getRoles().get(0))
        );
    }
}
