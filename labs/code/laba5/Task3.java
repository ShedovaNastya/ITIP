import java.util.regex.*;
public class Task3 {
    public static void main(String[] args){
        String text = "some text with common link www.google.com, strange link chat.openai.gov, link with protokol https://vk.com/dir1/dir2/dir3, link with pack";
        System.out.println(text);
        System.out.println(replacer(text));

    }
    public static String replacer(String s){
        String regex = "\\b(?:https?://)?(?:www\\.)?([a-zA-Z0-9-]+\\.[a-z]{2,})\\b";
        // \\b обозначение границы группы 
        // ?: если есть https, мы не берем этот https
        // http последовательность
        // s? может быть а может и не быть
        // :// = чась адреса
        // (?:https?://)? эта часть может быть а может и не быть
        // (?:www\\.)? 

        // [a-zA-Z0-9-]+\\.[a-z]{2,}(?:/[a-zA-Z0-9-]+)*) домен
        // [a-zA-Z0-9-]+ может быть один или более символов
        // \\.[a-z]{2,} точка и значения после точки. После точки должно быть минимум две буквы в нижнем регистре
        // \\b обозначение границы

        Pattern pattern = Pattern.compile(regex);
        //паттерн для поиска по тексту
        Matcher matcher = pattern.matcher(s);
        //метчер для поиска совпадений

        StringBuffer result = new StringBuffer();
        // Объект для построения строки с измененной ссылкой

        while (matcher.find()) {
            String link = matcher.group(1);
            String replacement = "https://"+ link;
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);
        return result.toString();

    }
    
}
