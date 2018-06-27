package ru.daniilazarnov.spring.intro;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.daniilazarnov.spring.intro.domain.Question;
import ru.daniilazarnov.spring.intro.domain.User;
import ru.daniilazarnov.spring.intro.service.question.IQuestionService;
import ru.daniilazarnov.spring.intro.service.user.IUserService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static int countCorrectAnswer = 0;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        IQuestionService questionService = context.getBean(IQuestionService.class);
        IUserService userService = context.getBean(IUserService.class);
        List<Question> questions = questionService.getListQuestion();

        User user = new User();

        System.out.println("Hello! What is your first name?");
        String firstName = in.nextLine();
        user.setFirstName(firstName);

        System.out.println("What is your last name?");
        String lastName = in.nextLine();
        user.setLasttName(lastName);

        userService.saveUser(user);

        System.out.println();
        System.out.println("Test:");

        questions.forEach(Main::checkCorrectAnswer);
        assessKnowledge(userService.getUser().orElse(User.userEmpty()), questions.size());
    }

    private static void checkCorrectAnswer(Question question) {
        System.out.println(question.getTextByQuestion());
        String userAnswer = in.nextLine();
        if (userAnswer.trim().equalsIgnoreCase(question.getCorrectAnswer())) {
            countCorrectAnswer++;
        }
    }

    private static void assessKnowledge(User user, int total) {
        System.out.println(user.getDisplayName() + ", your final score: " + (int) ((double) countCorrectAnswer / total * 100));
    }

}
