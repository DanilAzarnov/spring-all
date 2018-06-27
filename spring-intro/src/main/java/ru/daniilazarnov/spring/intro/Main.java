package ru.daniilazarnov.spring.intro;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.daniilazarnov.spring.intro.domain.Question;
import ru.daniilazarnov.spring.intro.service.IQuestionService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static int countCorrectAnswer = 0;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        IQuestionService questionService = context.getBean(IQuestionService.class);
        List<Question> questions = questionService.getListQuestion();

        questions.forEach(Main::checkCorrectAnswer);
        assessKnowledge(questions.size());
    }

    private static void checkCorrectAnswer(Question question) {
        System.out.println(question.getTextByQuestion());
        String userAnswer = in.nextLine();
        if (userAnswer.trim().equalsIgnoreCase(question.getCorrectAnswer())) {
            countCorrectAnswer++;
        }
    }

    private static void assessKnowledge(int total) {
        System.out.println("Your final score: " + (int) ((double) countCorrectAnswer / total * 100));
    }

}
