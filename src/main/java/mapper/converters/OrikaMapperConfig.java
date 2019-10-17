/**
 * Настройка и регистрация конвертеров
 * @autor МВН
 * @version 0.1
 * ( При добавлении конвертера в этом склассе никаких изменений не требуется )
 */
package mapper.converters;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrikaMapperConfig {
    final Logger log = LogManager.getLogger(OrikaMapperConfig.class);

    MapperFactory mapperFactory;
    MapperFacade  mapperFacade;

    public OrikaMapperConfig() {
        log.info("Create mapper context and register beans (MapperFactory and MapperFacade)");
        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Bean
    public MapperFactory mapperFactory() {
        return mapperFactory;
    }

    @Bean
    public MapperFacade mapperFacade() {
        return mapperFacade;
    }
}
