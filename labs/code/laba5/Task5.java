import java.util.regex.*;

public class Task5 {
    public static void main(String[]args){
        finder("tototo pupupu Ggo neeene gav no gegege+", 'g');
    }
    public static void finder(String text, char letter){
        if (!Character.isLetter(letter)){
            System.out.println("Illegal symbol");
            return;
        }
        String regex = "\\b" + letter + "\\p{L}*\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
