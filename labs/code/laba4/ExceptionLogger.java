import java.io.*;
public class ExceptionLogger{
    private String logFileName;

    public ExceptionLogger(String logFileName){
        this.logFileName = logFileName;
    }

    public void logException(Exception e){
        try (FileWriter writer = new FileWriter(logFileName, true)){
            writer.write("Вызвано исключение : " + e.toString() +"\n");
        }
        catch(IOException ex){
            System.out.println("Ошибка во время записи логов" + ex.getMessage());
        }
    }
}
