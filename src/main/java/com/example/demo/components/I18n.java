package com.example.demo.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class I18n {

  private static MessageSource messageSource;
  private static Locale locale = LocaleContextHolder.getLocale();

  @Autowired
  public void setMessageSource(MessageSource messageSource) {
    I18n.messageSource = messageSource;
  }

  public static MessageSource getMessageSource() {
    return messageSource;
  }

  public static String t(String code) {
    return messageSource.getMessage(code, null, locale);
  }

  public static String t(String code, Object... args) {
    return messageSource.getMessage(code, args, locale);
  }

}
