/**
 * Обработка REST запросов
 */
package mapper;

import ma.glasnost.orika.MapperFacade;
import mapper.converters.OrikaMapperConfig;
import mapper.datamodel.ResoRequest;
import mapper.datamodel.UwCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    static final Logger log = LogManager.getLogger(RestController.class);

    @Autowired
    OrikaMapperConfig orika;
    MapperFacade mapper;

    @PostConstruct
    public void init() {
        mapper = orika.getMapperFactory().getMapperFacade();
    }

    /**
     * REST запрос преобразование КЭШ в запрос РЕСО
     * @param uwCache - JSON с данными кэш
     * @return JSON в формате РЕСО
     */
// TODO добавить swagger нотации
    @RequestMapping(
            value = "/convert",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json" )
    @ResponseBody
    public ResoRequest uw1(@RequestBody UwCache uwCache) {
        if(uwCache == null) {
            return null;
        }
        else {
            log.debug(uwCache);
            return mapper.map(uwCache, ResoRequest.class); // вызов зарегистрированного конвертора
        }
    }
}
