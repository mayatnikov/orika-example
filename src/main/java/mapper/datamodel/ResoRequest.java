/**
 * модель данных ( destination class B)
 */
package mapper.datamodel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResoRequest {
    String userName;
    String isCarOwnerInsurant;
    String carOwnewrId;
    String carOwnerAddrKladr;
    String payPeriod;
    String carPurchaseDate;
}

