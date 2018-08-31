package ru.daniilazarnov.spring.intro.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class I18nServiceImpl implements I18nService {

    private final MessageSource ms;

    public I18nServiceImpl(MessageSource ms) {
        this.ms = ms;
    }

    public String message(String message, String... param) {
        return ms.getMessage(message, param, Locale.getDefault());
    }

}
