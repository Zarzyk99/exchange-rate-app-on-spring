package pl.kurs.exchangerateapponspring.services;

import org.springframework.stereotype.Component;
import pl.kurs.exchangerateapponspring.config.AppConfig;

@Component
public class UrlStringBuilder implements IUrlStringBuilder {


    @Override
    public String buildUrl(String currencyParameter) {
        return AppConfig.EXCHANGERATESAPI_PAGE + AppConfig.PAGE_ENDPOINT + currencyParameter + AppConfig.PRIVATE_API_KEY;
    }
}
