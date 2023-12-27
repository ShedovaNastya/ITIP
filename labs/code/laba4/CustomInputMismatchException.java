import java.util.InputMismatchException;

public class CustomInputMismatchException extends InputMismatchException {
  public CustomInputMismatchException(String str){
    super("Ошибка при вводе: " + str);
  }
}
