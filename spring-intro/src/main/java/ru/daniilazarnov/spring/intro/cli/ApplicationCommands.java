package ru.daniilazarnov.spring.intro.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.daniilazarnov.spring.intro.domain.Exam;
import ru.daniilazarnov.spring.intro.domain.Question;
import ru.daniilazarnov.spring.intro.domain.User;
import ru.daniilazarnov.spring.intro.service.ExamService;
import ru.daniilazarnov.spring.intro.service.PrintService;
import ru.daniilazarnov.spring.intro.service.QuestionService;
import ru.daniilazarnov.spring.intro.service.UserService;

import java.util.List;

@ShellComponent
public class ApplicationCommands {

    private final QuestionService questionService;
    private final UserService userService;
    private final ExamService examService;
    private final PrintService printService;

    @Autowired
    public ApplicationCommands(QuestionService questionService,
                               UserService userService,
                               ExamService examService,
                               PrintService printService) {
        this.questionService = questionService;
        this.userService = userService;
        this.examService = examService;
        this.printService = printService;
    }

    @ShellMethod("Start test.")
    public void test() {

        List<Question> questions = questionService.getListQuestion();

        User user = userService.createUser();

        Exam exam = examService.startExam(user, questions);

        printService.printExamResult(exam);
    }
}
