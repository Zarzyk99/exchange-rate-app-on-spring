package pl.kurs.exchangerateapponspring.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.kurs.exchangerateapponspring.exceptions.InvalidInputDataException;


import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

@Service
public class RateService implements IRateService {
    private ObjectMapper mapper;
    private IUrlStringBuilder urlStringBuilder;

    public RateService(ObjectMapper mapper, IUrlStringBuilder urlStringBuilder) {
        this.mapper = mapper;
        this.urlStringBuilder = urlStringBuilder;
    }

    @Override
    public BigDecimal getRate(String fromCurrencyMark, String toCurrencyMark) throws InvalidInputDataException {

        String preparedUrl = urlStringBuilder.buildUrl(fromCurrencyMark);

        JsonNode mainNode = null;

        try {
            mainNode = mapper.readTree(new URL(preparedUrl));
        } catch (UnknownHostException | MalformedURLException e) {
            throw new InvalidInputDataException("Problemy z siecią, spróbuj ponownie!", e);
        } catch (IOException e) {
            throw new InvalidInputDataException("Przekazano błedne dane!", e);
        }


        JsonNode results = mainNode.get("results");
        JsonNode specificRateNode = results.get(toCurrencyMark);
        if (specificRateNode == null) throw new InvalidInputDataException("Przekazano błędne dane");

        return new BigDecimal(specificRateNode.asText());
    }

}
