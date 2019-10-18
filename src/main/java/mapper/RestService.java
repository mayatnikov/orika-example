/**
 * Обработка REST запросов
 * ( При добавлении конвертера в этом классе
 *   НЕОБХОДИМО СОЗДАТЬ
 *   точку входа в сервис @RequestMapping )
 */
package mapper;

import ma.glasnost.orika.MapperFacade;
import mapper.datamodel.ResoRequest;
import mapper.datamodel.UwCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestService {
    static final Logger log = LogManager.getLogger(RestService.class);

    @Autowired
    MapperFacade mapper;

    /**
     * описание REST запроса преобразование A --> B
     * @param uwCache - JSON с данными кэш
     * @return JSON в формате РЕСО
     * для каждого нового запроса надо создать новый блок @RequestMap
     * возможно и создавать новые классы с блоками @RequestMap
     */
// TODO добавить swagger нотации
    @RequestMapping(
            value = "/convert",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json" )
    @ResponseBody
    public ResoRequest svc1(@RequestBody UwCache uwCache) {
        if(uwCache == null) {
            return null;
        }
        else {
            log.debug(uwCache);
            return mapper.map(uwCache, ResoRequest.class); // вызов зарегистрированного конвертора
        }
    }
}
