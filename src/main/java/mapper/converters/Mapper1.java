/**
 * класс регистрации конвертера
 *
 * пояснения имя класса не имеет значения
 * допустимо регистрация нескольких конвертеров в одном классе / или для каждого писать отдельный класс
 * класс будет вызван спрингом автоматом дополнительных вызовов не требуется
 */
package mapper.converters;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import mapper.datamodel.ResoRequest;
import mapper.datamodel.UwCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Mapper1 {
    static final Logger log = LogManager.getLogger(Mapper1.class);

    @Autowired
    MapperFactory mapperFactory;

    @PostConstruct
    public void  init() {
 // --------------------------------
 // Это настройка и регистрация преобразователя класса A в класс B
        CustomMapper customMapper = new Cache2ResoCustomMapper();               // класс - нестандартные правила преобразования полей
        mapperFactory.classMap(UwCache.class, ResoRequest.class)                     // преобразователь для A --> B
                .field("data['MAIN_USAGE_REGION_KLADR']","carOwnerAddrKladr")      // простейший мапер поля
                .field("data['USER_FULLNAME']","userName")
                .customize(customMapper)                                              // вызов всех нестандартных преобразвоаний
                .register();                                 // правило преобразования зарегистрировано и готово к использовани.
        log.info ("Converter UWEB --> PECO registered succesfuly");
 // Этот блок можно повторять и регистрировать дополнительно любое число конвертеров
 // ---------------------------------

    }
}
