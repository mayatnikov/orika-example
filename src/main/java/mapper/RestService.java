/**
 * Обработка REST запросов
 * ( При добавлении конвертера в этом классе
 *   НЕОБХОДИМО СОЗДАТЬ
 *   точку входа в сервис @RequestMapping )
 */
package mapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.glasnost.orika.MapperFacade;
import mapper.datamodel.ClassB;
import mapper.datamodel.ClassA;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(value="Object mapper based on Orika frameowrk", description="Object mapping REST service")
public class RestService  extends AbstractHealthIndicator {
    static final Logger log = LogManager.getLogger();


    @Autowired
    MapperFacade mapper;

    /**
     * описание REST запроса преобразование A --> B
     * @param uwCache - JSON с данными кэш
     * @return JSON в формате РЕСО
     * для каждого нового запроса надо создать новый блок @RequestMap
     * возможно и создавать новые классы с блоками @RequestMap
     */
    @ApiOperation(value = "Convert A --> B", response = ClassB.class)
    @RequestMapping(
            value = "/convert",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json" )
    @ResponseBody
    public ClassB svc1(@RequestBody ClassA uwCache) {
        if(uwCache == null) {
            return null;
        }
        else {
            log.debug(uwCache);
            return mapper.map(uwCache, ClassB.class); // вызов зарегистрированного конвертора
        }
    }

// этот метод обеспечивает мониторинг
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // Use the builder to build the health status details that should be reported.
        // If you throw an exception, the status will be DOWN with the exception message.
        builder.up()
                .withDetail("app", "Я жив и работаю")
                .withDetail("error", "Пока нет, но скоро будут!");
    }
}
