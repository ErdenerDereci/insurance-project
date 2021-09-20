package sbm.insuranceProject.utitilies.helpers.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceProps {
    private int price;
    private int discountRate;
    private int discountedPrice;

}
