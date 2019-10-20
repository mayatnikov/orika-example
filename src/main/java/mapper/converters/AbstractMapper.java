/**
 * Abstract класс регистрации конвертера
 *
 * пояснения имя класса не имеет значения
 * допустимо регистрация нескольких конвертеров в одном классе / или для каждого писать отдельный класс
 * класс будет вызван спрингом автоматом дополнительных вызовов не требуется
 * все регисраторы конвертеров должны extends Abstract
 */
package mapper.converters;

import ma.glasnost.orika.MapperFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
abstract public class AbstractMapper {
    static final Logger log = LogManager.getLogger();

    @Autowired
    MapperFactory mapperFactory;

    @PostConstruct
    abstract public void  init();
}
