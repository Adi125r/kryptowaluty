package pl.wojcieszek.cryptoCurrency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeResponse extends Exchange {
    Double rate;
    Double result;

    public ExchangeResponse(double rate, double result, Double amount, String from, String to) {
        super(from, to, amount);
        this.rate=rate;
        this.result=result;
    }
}
