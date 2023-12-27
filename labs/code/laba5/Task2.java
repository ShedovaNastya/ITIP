public class Task2 {
    public static void main(String[] args){
        System.out.println(validate("Abcd1234"));
        System.out.println(validate("Abcdghyh"));
        System.out.println(validate("345678978"));
        System.out.println(validate("abСd1234"));
        System.out.println(validate("Abc123"));
        System.out.println(validate("Abctyuiokjnmkd1234"));
        System.out.println(validate("AbcD1234T"));
    }

    public static boolean validate(String pass){
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
        // ^ начало строки 
        // (?=.*[A-Z]) - позитивное ретроспективное условие
        // Если после начала строки хоть где-то есть заглавная, то сопоставление будет успешным
        // (?=.*\\d) - аналогичное позитивное ретроспективное условие
        // [A-Za-z\\d] - набор символов, который может быть использован в пароле
        // {8, 16} - количество символов 
        // $ конец строки
        if(pass.matches(regex)){
            return true;
        }
        else{
            return false;}
    }
}
