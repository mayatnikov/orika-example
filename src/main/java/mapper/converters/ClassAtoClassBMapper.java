/**
 * класс регистрации конвертера
 *
 * пояснения имя класса не имеет значения
 * допустимо регистрация нескольких конвертеров в одном классе / или для каждого писать отдельный класс
 * класс будет вызван спрингом автоматом дополнительных вызовов не требуется
 */
package mapper.converters;

import ma.glasnost.orika.CustomMapper;
import mapper.datamodel.ClassB;
import mapper.datamodel.ClassA;
import org.springframework.stereotype.Component;

@Component
public class ClassAtoClassBMapper extends AbstractMapper{

    public void  init() {
 // --------------------------------
 // Это настройка и регистрация преобразователя класса A в класс B
        CustomMapper customMapper = new ClassAtoClassBCustomMapper();               // класс - нестандартные правила преобразования полей
        mapperFactory.classMap(ClassA.class, ClassB.class)                     // преобразователь для A --> B
                .field("data['MAIN_USAGE_REGION_KLADR']","carOwnerAddrKladr")      // простейший мапер поля
                .field("data['USER_FULLNAME']","userName")
                .customize(customMapper)                                              // вызов всех нестандартных преобразвоаний
                .register();                                 // правило преобразования зарегистрировано и готово к использовани.
        log.info ("Converter UWEB --> PECO registered succesfuly");
 // Этот блок можно повторять и регистрировать дополнительно любое число конвертеров
 // ---------------------------------

    }
}
