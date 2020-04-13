package pl.wojcieszek.cryptoCurrency;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/currencies/")
class CryptoCurrencyApi {

    @GetMapping("{currency}/all")
    public Currency getRateCurrencies(@PathVariable("currency") String value) throws IOException {
        return getObjectFromApi(value);
    }

    @GetMapping("{currency}")
    public Currency getRateCurrenciesWithParameters(@PathVariable("currency") String value, @PathParam("filter") String params[]) throws IOException {
        Currency currency = getObjectFromApi(value);
        List<RateCurrency> rateCurrencies = currency.getRates();
        rateCurrencies = rateCurrencies.stream()
                .filter(rateCurrency -> rateCurrency.checkFilter(params))
                .collect(toList());
        currency.setRates(rateCurrencies);
        return currency;
    }

    @PostMapping("/exchange")
    public Exchange exchange(@RequestBody Exchange exchange) throws IOException {
        Currency currency = getObjectFromApi(exchange.from);
        double rate = currency.getRates()
                .stream()
                .filter(rateCurrency -> rateCurrency.asset_id_quote.equals(exchange.to))
                .findFirst()
                .get()
                .getRate();

        return createExchangeResponse(exchange, rate);
    }

    private ExchangeResponse createExchangeResponse(Exchange exchange, double rate) {
        double result = rate * exchange.amount;
        return new ExchangeResponse(rate,result,exchange.amount,exchange.from,exchange.to);
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private Currency getObjectFromApi(String currency) throws IOException {
        String output = readFromUrl("https://rest.coinapi.io/v1/exchangerate/" + currency + "?apikey=YOUR_API");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(output, Currency.class);
    }

    private String readFromUrl(String url) throws IOException {
        try (InputStream inputStream = new URL(url).openStream()) {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            return readAll(bufferedReader);
        }
    }
}