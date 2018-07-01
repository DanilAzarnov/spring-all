package ru.daniilazarnov.spring.intro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.daniilazarnov.spring.intro.domain.Exam;
import ru.daniilazarnov.spring.intro.domain.Question;
import ru.daniilazarnov.spring.intro.domain.User;
import ru.daniilazarnov.spring.intro.service.ExamService;
import ru.daniilazarnov.spring.intro.service.PrintService;
import ru.daniilazarnov.spring.intro.service.QuestionService;
import ru.daniilazarnov.spring.intro.service.UserService;

import java.util.List;

@ComponentScan
@Configuration
@PropertySource("classpath:application.properties")
public class Main {

    @Value("${base.message.path}")
    private String messagePath;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename(messagePath);
        ms.setDefaultEncoding("UTF-8");

        return ms;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        QuestionService questionService = context.getBean(QuestionService.class);
        UserService userService = context.getBean(UserService.class);
        ExamService examService = context.getBean(ExamService.class);
        PrintService printService = context.getBean(PrintService.class);

        List<Question> questions = questionService.getListQuestion();

        User user = userService.createUser();

        Exam exam = examService.startExam(user, questions);

        printService.printExamResult(exam);
    }

}
