package starter.apis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FruitDto {
    String provider;
    String title;
    String url;
    String brand;
    float price;
    String unit;
    @JsonProperty("isPromo")
    boolean promo;
    String promoDetails;
    String image;
}
