import java.io.*;

public class TaskTwo{
    public static void main(String[] args){
        String sourceFilePath = "inputFile.txt";
        String targetFilePath = "outputFile.txt";
        try(
            FileInputStream in = new FileInputStream(sourceFilePath);//чтение файла
            FileOutputStream out = new FileOutputStream(targetFilePath, false);
            //запись файла
        ){
            int bytesRead; // хранение прочитанных байт
            byte[] buffer = new byte[2048]; // временно храним прочитанные данные
            while ((bytesRead = in.read(buffer)) != -1){
                // присвоили в переменную количество прочитанных байт
                out.write(buffer, 0, bytesRead);
                //buffer - вставляем
                //0 - начинаем с нуля
                //bytesRead - сколько элементов вставить
            }
            in.close();
            out.close();
            
            bytesRead = in.read(buffer);
            System.out.println("Файл скопирован");
        }
        catch(IOException e){
            System.out.println("Ошибка при вводе/выводе: " + e.getMessage());
        }
    }
}