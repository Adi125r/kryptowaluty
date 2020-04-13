package pl.wojcieszek.cryptoCurrency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RateCurrency {
    Date time;
    String asset_id_quote;
    Double rate;

    public boolean checkFilter(String[] filter) {
        for (String s : filter) {
            if (asset_id_quote.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
