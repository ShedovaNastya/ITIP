import java.util.InputMismatchException;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    ExceptionLogger logger = new ExceptionLogger("log.txt");

    Scanner str = new Scanner(System.in);
    System.out.print("Enter an integer: ");  
    try {
      int number = str.nextInt();
      System.out.println("You entered the integer: " + number);
    } 
    catch (InputMismatchException e) {
        logger.logException(new CustomInputMismatchException("cтрока " + str.next() + " не является числом  " ));
    }
  }
}
