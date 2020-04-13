package pl.wojcieszek.cryptoCurrency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    private String asset_id_base;
    private List<RateCurrency> rates;
}
