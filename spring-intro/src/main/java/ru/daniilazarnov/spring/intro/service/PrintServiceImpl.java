package ru.daniilazarnov.spring.intro.service;

import org.springframework.stereotype.Service;
import ru.daniilazarnov.spring.intro.domain.Exam;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PrintServiceImpl implements PrintService {

    private final I18nService ms;

    public PrintServiceImpl(I18nService ms) {
        this.ms = ms;
    }

    @Override
    public void printExamResult(Exam exam) {
        System.out.println(ms.message("your.exam.result", exam.getParticipant().getDisplayName()));

        AtomicInteger countCorrectAnswer = new AtomicInteger();

        exam.getResult().forEach((string, aBoolean) -> {
                    System.out.println(string + " -> " + aBoolean);
                    if (aBoolean) {
                        countCorrectAnswer.getAndIncrement();
                    }
                }
        );

        int score = (int) ((double) countCorrectAnswer.get() / exam.getResult().size() * 100);

        System.out.println(ms.message("final.score", String.valueOf(score)));

    }

}
