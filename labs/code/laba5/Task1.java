import java.util.regex.*;

public class Task1 {
    public static void main(String[] args){
        String text = " I have 100$. The price of the product is $-19.99. Total to death $41.99";
        Pattern pattern = Pattern.compile("[-]?\\d+(\\.\\d+)?");
        // \\b - граница  слова, обозначаем начало ряда цифр
        // \\d+ одна или несколько цифр
        // (\\.\\d+)? десятичная часть числа может быть, а может не быть
        // \\b граница цифрового ряда
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
