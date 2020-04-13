package pl.wojcieszek.cryptoCurrency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exchange {
    String from;
    String to;
    Double amount;
}
