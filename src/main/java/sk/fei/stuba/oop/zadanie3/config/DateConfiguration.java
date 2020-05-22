package sk.fei.stuba.oop.zadanie3.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@EnableWebMvc
public class DateConfiguration implements WebMvcConfigurer {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //noinspection Convert2Lambda
        registry.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String dateTimeString) {
                return LocalDateTime.parse(dateTimeString, DATE_TIME_FORMATTER);
            }
        });
        //noinspection Convert2Lambda
        registry.addConverter(new Converter<LocalDateTime, String>() {
            @Override
            public String convert(LocalDateTime dateTime) {
                return dateTime.format(DATE_TIME_FORMATTER);
            }
        });
        //noinspection Convert2Lambda
        registry.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String dateString) {
                return LocalDate.parse(dateString, DATE_FORMATTER);
            }
        });
        //noinspection Convert2Lambda
        registry.addConverter(new Converter<LocalDate, String>() {
            @Override
            public String convert(LocalDate dateTime) {
                return dateTime.format(DATE_FORMATTER);
            }
        });
    }
}

