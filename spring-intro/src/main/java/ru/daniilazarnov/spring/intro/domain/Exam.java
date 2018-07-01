package ru.daniilazarnov.spring.intro.domain;

import java.util.HashMap;
import java.util.Map;

public class Exam {

    private final User participant;
    private Map<String, Boolean> result;

    public Exam(User participant) {
        this.participant = participant;
        this.result = new HashMap<>();
    }

    public User getParticipant() {
        return participant;
    }

    public Map<String, Boolean> getResult() {
        return result;
    }

}
