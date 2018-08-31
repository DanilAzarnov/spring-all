package ru.daniilazarnov.spring.intro.dao;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Repository;
import ru.daniilazarnov.spring.intro.Application;
import ru.daniilazarnov.spring.intro.domain.Question;
import ru.daniilazarnov.spring.intro.service.I18nService;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Repository
public class CsvQuestionDao implements QuestionDao {

    private String messagePath;

    public CsvQuestionDao(I18nService ms) {
        this.messagePath = ms.message("questions.table.path");
    }

    public List<Question> getListQuestion() {

        try (Reader reader = new InputStreamReader(Application.class.getClassLoader().getResourceAsStream(messagePath))) {

            CsvToBean<Question> csvToBean = new CsvToBeanBuilder<Question>(reader)
                    .withType(Question.class)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();

        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

}
