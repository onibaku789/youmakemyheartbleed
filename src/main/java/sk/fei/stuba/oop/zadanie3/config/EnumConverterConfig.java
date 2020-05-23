package sk.fei.stuba.oop.zadanie3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sk.fei.stuba.oop.zadanie3.model.contract.lifeinsurance.accidentinsurance.TerritorialValidity;
import sk.fei.stuba.oop.zadanie3.model.contract.lifeinsurance.travelinsurance.PurposeOfTrip;
import sk.fei.stuba.oop.zadanie3.model.contract.nonlifeinsurance.EstateType;

@Configuration
@EnableWebMvc
public class EnumConverterConfig  implements WebMvcConfigurer {


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, EstateType>() {
            @Override
            public EstateType convert(String EstateTypeString) {
                return EstateType.valueOf(EstateTypeString);
            }
        });
        registry.addConverter(new Converter<String, PurposeOfTrip>() {
            @Override
            public PurposeOfTrip convert(String purposeOfTrip) {
                return PurposeOfTrip.valueOf(purposeOfTrip);
            }
        });
        registry.addConverter(new Converter<String, TerritorialValidity>() {
            @Override
            public TerritorialValidity convert(String territorialValidity) {
                return TerritorialValidity.valueOf(territorialValidity);
            }
        });
    }
}
