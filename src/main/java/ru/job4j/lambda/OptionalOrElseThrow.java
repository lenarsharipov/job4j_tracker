package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOrElseThrow {

    public static class User {
        private String login;

        public User(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
        }
    }

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public static User orElseThrow(List<User> list, String login) {
        Optional<User> optional = search(list, login);
        return optional.orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    private static Optional<User> search(List<User> list, String login) {
        Optional<User> user = Optional.empty();
        for (User person : list) {
            if (person.getLogin().equals(login)) {
                return Optional.of(person);
            }
        }
        return user;
    }
}