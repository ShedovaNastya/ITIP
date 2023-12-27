import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//указываем уровень сохранения аннотации. В данном случае
//мы указываем, что она будем использоваться во время
//выполнения программы
@Target(ElementType.METHOD)
//Место применение аннотации, в нашем случае она будем
//применять к методам
public @interface DataProcessor {
}
// с помощью @interface создаются пользовательские
//аннотации в java
