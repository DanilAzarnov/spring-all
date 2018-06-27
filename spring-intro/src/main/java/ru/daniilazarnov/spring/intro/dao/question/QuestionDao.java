package ru.daniilazarnov.spring.intro.dao.question;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ru.daniilazarnov.spring.intro.Main;
import ru.daniilazarnov.spring.intro.domain.Question;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class QuestionDao implements IQuestionDao {

    public List<Question> getListQuestion() {

        InputStream is = Main.class.getClassLoader().getResourceAsStream("questions.csv");

        Reader reader = new InputStreamReader(is);

        CsvToBean<Question> csvToBean = new CsvToBeanBuilder<Question>(reader)
                .withType(Question.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return csvToBean.parse();
    }

}
