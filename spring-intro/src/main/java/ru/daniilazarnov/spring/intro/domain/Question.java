package ru.daniilazarnov.spring.intro.domain;

import com.opencsv.bean.CsvBindByName;

public class Question {

    @CsvBindByName
    private String textByQuestion;

    @CsvBindByName
    private String correctAnswer;

    public String getTextByQuestion() {
        return textByQuestion;
    }

    public void setTextByQuestion(String textByQuestion) {
        this.textByQuestion = textByQuestion;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}
