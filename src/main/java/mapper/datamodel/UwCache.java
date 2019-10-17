/**
 * Модель входных данных
 * не строгая модель
 * все поля сохранены как эелементы поля массива data ( key = value )
 * контроля наличия и формата полей нет
 * как вариант здесь может быть строгий POJO объект
 */
package mapper.datamodel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.HashMap;

@Getter
@Setter
@ToString
public class UwCache {
     HashMap<String,String>  data;
}
