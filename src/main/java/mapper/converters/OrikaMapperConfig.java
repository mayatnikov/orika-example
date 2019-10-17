/**
 * Настройка и регистрация конвертеров
 * @autor МВН
 * @version 0.1
 */
package mapper.converters;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import mapper.datamodel.ResoRequest;
import mapper.datamodel.UwCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class OrikaMapperConfig {
    final Logger log = LogManager.getLogger(OrikaMapperConfig.class);

    MapperFactory mapperFactory;
    CustomMapper customMapper;

    public OrikaMapperConfig() {
        log.info("Construct mapper context");
        mapperFactory = new DefaultMapperFactory.Builder().build();

// Это настройка и регистрация преобразователя класса A в класс B
       customMapper = new Cache2ResoCustomMapper();               // класс - нестандартные правила преобразования полей
       mapperFactory.classMap(UwCache.class, ResoRequest.class)                     // преобразователь для A --> B
       .field("data['MAIN_USAGE_REGION_KLADR']","carOwnerAddrKladr")      // простейший мапер поля
       .field("data['USER_FULLNAME']","userName")
       .customize(customMapper)                                              // вызов всех нестандартных преобразвоаний
       .register();                                 // правило преобразования зарегистрировано и готово к использовани.
// Этот блок можно повторять и регистрировать дополнительно любое число конвертеров
    }

    public MapperFactory getMapperFactory() {
        return mapperFactory;
    }
}
