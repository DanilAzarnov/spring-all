package ru.daniilazarnov.spring.intro.domain;

public class User {

    private String firstName;
    private String lastName;

    public String getDisplayName() {
        return firstName + " " + lastName;
    }

    public static User userEmpty() {
        return new User("", "");
    }

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lastName;
    }

    public void setLasttName(String lastName) {
        this.lastName = lastName;
    }

}
