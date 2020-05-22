package sk.fei.stuba.oop.zadanie3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sk.fei.stuba.oop.zadanie3.model.contract.nonlifeinsurance.EstateType;

import java.util.UUID;

@Configuration
@EnableWebMvc
public class UUIDconverterConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, UUID>() {
            @Override
            public UUID convert(String UUIDString) {
                return UUID.fromString(UUIDString);
            }
        });
    }
}
