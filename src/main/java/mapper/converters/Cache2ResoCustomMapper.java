/**
 * Custom converter
 * класс нестандартных преобразований полей
 *
 */
package mapper.converters;


import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import mapper.datamodel.ResoRequest;
import mapper.datamodel.UwCache;

class Cache2ResoCustomMapper extends CustomMapper<UwCache , ResoRequest> {

    @Override
    public void mapAtoB(UwCache a, ResoRequest b, MappingContext context) {
// здесь на программном уровне возможны любые преобразования A --> B
// TODO добавить проверку на отсутствие или некорректные данные ( перехват exception )
        // РЕСО PayPeriod
       int gpt = Integer.parseInt( a.getData().get("GLOBAL_PAY_TYPE"));
       int contrln = Integer.parseInt( a.getData().get("CONTRACT_LENGTH") );
        if( gpt == 1 ) {
                b.setPayPeriod("6");
            }
        else if( gpt == 2 ) {
            b.setPayPeriod("3");
        }
        else if( contrln <= 18 && gpt == 0 ) {
            b.setPayPeriod("0");
        }
        else {
            b.setPayPeriod("12");
        }
// isCarOwnerInsurant
        b.setIsCarOwnerInsurant( a.getData().get("MAIN_OWNER_IS_INSURER").equals("1") ? "true" : "false" );
// CarOwnerID
        if( a.getData().get("MAIN_OWNER_IS_INSURER").equals("1") ||
                        a.getData().get("FOR_LEASING").equals("1") ) {
            b.setCarOwnewrId ("0");
        }
// carPurchaseDate"
            b.setCarPurchaseDate("Тут будет дата а сейчас просто прверочка");
}

    @Override
    public void mapBtoA(ResoRequest b, UwCache a, MappingContext context) {
        // обратное преобразование не используется
      }
}