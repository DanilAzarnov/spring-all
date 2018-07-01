package ru.daniilazarnov.spring.intro.service;

import org.springframework.stereotype.Service;
import ru.daniilazarnov.spring.intro.dao.ExamDao;
import ru.daniilazarnov.spring.intro.domain.Exam;
import ru.daniilazarnov.spring.intro.domain.Question;
import ru.daniilazarnov.spring.intro.domain.User;

import java.util.List;
import java.util.Scanner;

@Service
public class SpringExamService implements ExamService {

    private final ExamDao dao;

    public SpringExamService(ExamDao dao) {
        this.dao = dao;
    }

    private static final Scanner in = new Scanner(System.in);
    private Exam exam;

    @Override
    public Exam startExam(User user, List<Question> questions) {
        exam = dao.getExam(user);

        questions.forEach(this::examProcedure);

        return exam;
    }

    private void examProcedure(Question question) {
        System.out.println(question.getTextByQuestion());
        String userAnswer = in.nextLine();

        exam.getResult().put(question.getTextByQuestion(), checkCorrectAnswer(question.getCorrectAnswer(), userAnswer));
    }

    private static boolean checkCorrectAnswer(String correctAnswer, String userAnswer) {
        return userAnswer.trim().equalsIgnoreCase(correctAnswer);
    }

}
