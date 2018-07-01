package ru.daniilazarnov.spring.intro.domain;

public class User {

    private String firstName;
    private String lastName;

    public String getDisplayName() {
        return firstName + " " + lastName;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLasttName() {
        return lastName;
    }

}
