import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class practika6 {
    public static void main(String[] args){
        System.out.println("----Задание 1----");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println("----Задание 2----");
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));
        System.out.println(collect("dsjsf", 7));
        System.out.println("----Задание 3----");
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println("----Задание 4----");
        System.out.println(Arrays.toString(twoProduct(new int[] {1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[] {1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[] {1, 2, -1, 4, 5, 6, 10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[] {1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[] {100, 12, 4, 1, 2}, 15)));
        System.out.println("----Задание 5----");
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));
        System.out.println("----Задание 6----");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println("----Задание 7----");
        System.out.println(pilishString("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        System.out.println(pilishString("FORALOOP"));
        System.out.println(pilishString("CANIMAKEAGUESSNOW"));
        System.out.println(pilishString("33314444"));
        System.out.println(pilishString("TOP"));
        System.out.println(pilishString("X"));
        System.out.println(pilishString(""));
        System.out.println("----Задание 8-----");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)")); //-17
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)")); //0
        System.out.println(generateNonconsecutive("2 + 3 * 4")); //14
        System.out.println(generateNonconsecutive("7 / 2.5")); //2.8
        System.out.println("----Задание 9----");
        System.out.println(isValid("aabbcd")); //no
        System.out.println(isValid("aabbccddeefghi")); //no
        System.out.println(isValid("abccc")); //no
        System.out.println(isValid("abcdefghhgfedecba")); //yes
        System.out.println(isValid("abc")); //yes
        System.out.println(isValid("abcc")); //yes 
        System.out.println(isValid("aaassd")); //NO
        System.out.println("----Задание 10-----");
        System.out.println(findLCS("abcd", "bd")); // "bd"
        System.out.println(findLCS("aggtab", "gxtxamb")); // "gtab"
    }
    public static String hiddenAnagram(String sentence, String anagram){
        //суть решения - проходиться по всей исходной строке и проверять количество каждого символа в
        //окне равном количеству символов в анаграмеме. Проверять на их равенство    

        // удаление мусора из строк
        sentence = removeTrash(sentence);
        anagram = removeTrash(anagram);
        //приведение в нижний регистр

        sentence = sentence.toLowerCase();
        anagram = anagram.toLowerCase();

        //подсчёт количества каждого символа в заданной анаграме, а также такого же количества символов
        //в исходной строке

        int[] symbols1 = new int[26];
        int[] symbols2 = new int[26];

        for (int i=0; i<anagram.length(); i++){
            char sent = sentence.charAt(i);
            char an = anagram.charAt(i);

            symbols1[sent-'a']++;
            symbols2[an-'a']++;
        }

        //случай если первое окно нам подходит
        if (equalArryas(symbols1, symbols2)){
            return sentence.substring(0, anagram.length());
        }

        //проход окнами.
        for (int i=anagram.length(); i<sentence.length(); i++){
            //удаляем из окна число предыдущего элемента
            symbols1[sentence.charAt((i-anagram.length()))-'a']--;

            //добавляем в окно текущий символ
            symbols1[sentence.charAt(i)-'a']++;

            //проверяем
            if (equalArryas(symbols1, symbols2)){
                //мы берём с символа, который шёл сразу после того, который мы удалили с начала окна
                //тк конечное число не включительно, то плюс 1
                return sentence.substring(i-anagram.length()+1, i+1);
            }
        }


        return "notfound";
    }

    // Функция провери равенства массивов
    public static boolean equalArryas(int[] a, int[] b){
        for (int i=0; i<26; i++){
            if (a[i]!=b[i]){
                return false;
            }
        }
        return true;

    }
    // Функция для удаления мусора из строк
    public static String removeTrash(String a){
        String result = "";
        for (char i:a.toCharArray()){
            if (Character.isLetter(i)){
                result+=i;
            }
        }
        return result;
    }



    public static ArrayList<String> collect(String a, int n){
        // функция, которая будет вызывать рекуррентную
        ArrayList<String> result = (recurrentCollect(new ArrayList<>(), a, n));
        //сортировка
        Collections.sort(result);
        return result;
    }
    
    public static ArrayList<String> recurrentCollect(ArrayList<String> result, String a, int n){
        // конечный случаи
        if (a.length()<n){
            // Если массив пустой
            if (result.size()==0){
                result.add("");
            }
            // Если не пустой
            return result;
        }
        //добавление текущего элемента
        result.add(a.substring(0, n));
        //вызов от оставшейся части строки
        recurrentCollect(result, a.substring(n, a.length()), n);
        return result;
    }


    public static String nicoCipher(String message, String key){
        int[] myKey = getKey(key); //получение ключа
        int blockSize = myKey.length; //размер блока, зависит от длины ключа
        int blockCount = message.length() / blockSize; //количество блоков, зависит от длины сообщения
        
        while (message.length()>blockCount*blockSize){ //добавление пробелов до тех пор, пока количество символов не будет кратно размеру ключа
            message+=" ";
            blockCount = message.length() / blockSize;
        }
        //создание результирующего массива
        char[] result = new char[message.length()];

        //проход по всей длине массива (blockCount*blockSize)
        for (int i=0; i<blockCount; i++){
            for (int j=0; j<blockSize; j++){
                int idx = i*blockSize + myKey[j]-1;
                //Получение замещающего индекса
                // Мы работаем в одном блоке.
                // для текущей буквы мы получаем её новое местоположение
                result[idx] = message.charAt(i*blockSize+j);
            }
        }
        return new String(result);
    }

    //Получение ключа
    public static int[] getKey(String key){
        int[] result = new int[key.length()]; //представление ключа в цифрах
        char[] temp = key.toCharArray(); //переменная для поиска минимумов
        for (int i=0; i<temp.length; i++){//количество символов в ключе
            char minm = 'z'+1; //локальный минимум
            int idx = 0; //индекс локального минимуму
            for (int j=0; j<temp.length; j++){ //поиск локального минимума
                if(temp[j]!='!' & temp[j]<minm){
                    minm = temp[j];
                    idx = j;
                }
            }
            result[idx] = i+1;
            temp[idx] = '!';
        }

        return result;
    }

    public static int[] twoProduct(int[] array, int value){
        //Будем проходиться по массиву, рассматривать каждое числое
        //Сначала будем проверять, является ли оно делителем
        //Затем будем искать ему пару
        ArrayList<Integer> dividers = new ArrayList<>();
        for (int i=0; i<array.length; i++){
          int number = array[i];
          if (value%number!=0){continue;}
          int pair_number = value/number;
          if (dividers.contains(pair_number)){
            return new int[] {pair_number, number};
          }
          dividers.add(number);
        }
        return new int[] {};
    }

    public static int[] isExact(int number){
        int[] result = isExact(number, 1); //проход с получением ответа
        if (result.length!=0){ //случай, если не точная факториальная граница
            result[0]=number;
            return result;
        }
        return result;
    }

    public static int[] isExact(int number, int k){
        if (number==1){ //Случай, если мы уже разделили на всё, что только можно. Ну или мы передлаи единицу
            return new int[] {number, k-1};
        }
        if (number%k!=0){ //Случай, если ничего не делится
            return new int[] {};
        }
        return isExact(number/k, k+1); //делим и вызываем функцию от следующего числа
    }



    public static String fractions(String num) {
        //цифры периода
        Matcher matcher = Pattern.compile("\\((\\d+)\\)").matcher(num);
        String period ="";
        if (matcher.find()){
            period = matcher.group(1);
        }
        else{
            return "incorrect number";
        }
        
        //цифры дроби но до периода
        matcher = Pattern.compile("\\.(\\d+)\\(").matcher(num);
        String fracWoutPeriod = "";
        if (matcher.find()){
            fracWoutPeriod = matcher.group(1);
        }

        //целая часть
        matcher = Pattern.compile("(\\d+)\\.").matcher(num);
        String intPart = "";
        if(matcher.find()){
            intPart = matcher.group(1);
        }
        else{
            return "incorrect number";
        }
        
        //Задаём переменные для поиска дроби
        /*
        k - Количество чисел в периоде десятичной дроби
        m - количество числе после запятой, но до периода дроби
        a - все цифры после запятой + период
        b - все цифры после запятой до периода
        y - целая часть бесконечной периодической дроби
        Y + (a-b)/(999..999000..000)
        Девяток столько же, сколько K
        Нулей столько же, сколько m
        */
        int a = Integer.parseInt(fracWoutPeriod + period);
        int b = 0;
        if (fracWoutPeriod.length()!=0){
            b = Integer.parseInt(fracWoutPeriod);
        }

        int y = Integer.parseInt(intPart);

        int nominator = a-b;
        String den = "";
        for (int i=0; i<period.length(); i++){
            den+="9";
        }
        for (int i=0; i<fracWoutPeriod.length(); i++){
            den+="0";
        }
        
        int denominator = Integer.parseInt(den);
        int gcd = findGCD(nominator, denominator);
        denominator/=gcd;
        nominator = (nominator/gcd)+y*denominator;
        return nominator+"/"+denominator;
    }
    //алгоритм Евклида для поиска наибольшего общего делителя
    public static int findGCD(int a, int b){
        while (a!=0 & b!=0){
            if (a>b){
                a = a%b;
            }
            else{
                b = b % a;
            }
        }
        return (a+b);
    }



    public static String pilishString(String seq){
        if (seq.length()==0){
            return "";
        }
        int[] pi = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9};
        int[] idxes = new int[pi.length + 1];
        //индексы элементов. Будем резать строку по индексам таким, чтобы получалось строка
        //с длиной слов равными цифрам числа пи
        for (int i=1; i<idxes.length; i++){
            idxes[i] = idxes[i-1]+pi[i-1];
        }
        String result = "";

        for (int i=1; i<idxes.length; i++){
            if (seq.length()<idxes[i]){ //случай, когда в строке не хватает символов для совпадения
                result +=seq.substring(idxes[i-1], seq.length()-1);//добавление всей часть
                for (int j=0; j<pi[i-1]-seq.substring(idxes[i-1], seq.length()-1).length(); j++){//добавление оставшейся части символов для соответсвия порядку
                    result+=seq.charAt(seq.length()-1);
                }
                break;
            }
            else{
                result+=seq.substring(idxes[i-1], idxes[i])+" ";//обычный случай
            }
            if (seq.length()==idxes[i]){break;}//случай кратного деления на слова

        }

        return result;
    }





    public static String generateNonconsecutive(String expr){
        if (!checkBrackets(expr)){return "ERROR WITH BRACKETS";}
        if (!checker(expr)){return "ERROR INCORRECT SYMBOL";}
        String result = calculateExpression(expr.replaceAll(" ", ""));
        if (!result.equals("ERROR DIVISION BY ZERO") & !result.equals("ERROR SUPERFLUOUS OPERATION") & !result.equals("ERROR INCORRECT OPERANDS")){
            return beatifulOutput(result);
        }
        return result;
    }

    //Функция для проверки на невалидные символы
    public static boolean checker(String s){
        String symbols = "1234567890()+-*/. ";
        for (int i=0; i<s.length(); i++){
            if (!symbols.contains(String.valueOf(s.charAt(i)))){
                return false;
            }
        }
        return true;
    }

    //Функция для красивого вывода интов
    public static String beatifulOutput(String s){
        
        double num = Double.parseDouble(s);
        int first = (int) num;
        if (((double) first)==num){
            return first+"";
        }
        else{
            return s;
        }
    }
    // функция для проверки корретностки расстановок скобок
    public static boolean checkBrackets(String expr){
        int counter = 0;
        for (int i=0; i<expr.length(); i++){
            if (expr.charAt(i)=='('){
                counter++;
            }
            if (expr.charAt(i)==')'){
                counter--;
            }
            if (counter<0){
                return false;
            }
            
        }
        if (counter==0){return true;}
        return false;
    }

    //функция для вычисления выражения 
    public static String calculateExpression(String a){
        if (a.contains("ERROR DIVISION BY ZERO")){
            return "ERROR DIVISION BY ZERO";
        }
        if (a.contains("ERROR SUPERFLUOUS OPERATION")){
            return "ERROR SUPERFLUOUS OPERATION";
        }
        if (a.contains("ERROR INCORRECT OPERANDS")){
            return "ERROR INCORRECT OPERANDS";
        }
        if (a.contains("(")){
            String result = calculateBrackets(a);
            return calculateExpression(result); //находим решение оставшейся части
        }
        else if(a.contains("*") | a.contains("/")){
            if (multOrDiv(a)){ //что первое - деление или умножение
                String result = calculateDivision(a); 
                return calculateExpression(result);
            }
            else{
                String result = calculateMultipication(a);
                return calculateExpression(result);
            }
        }
        else if (a.contains("+") | a.contains("-")){ //сложения и вычитани
            String regex = "\\b(\\d+(\\.\\d+)?)[\\+-]+(\\d+(\\.\\d+)?)\\b";
        
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(a);
            if (matcher.find()){
                if (addOrSub(a)){//случай сложения
                    String result = calculateAddition(a);
                    return calculateExpression(result);
                }
                else{
                    String result = calculateSubtraction(a);
                    return calculateExpression(result);
                }   
            }
            else{
                if (a.matches("\\-?\\d+(\\.\\d+)?")){
                    return Double.parseDouble(a)+"";
                }
                else{
                    return "ERROR INCORRECT OPERANDS";
                }
                
            }
        }
        else{
            return a;
        }
        
    }

    //Расчёт скобок
    public static String calculateBrackets(String a){
        String regex = "\\((.*)\\)"; //находим первое выражение в скобках и вычисляем его, результат вставляем в строку
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);
        StringBuffer result = new StringBuffer();

        matcher.find();
        String expr = matcher.group(1);//внутренность скобок
        expr = calculateExpression(expr);
        matcher.appendReplacement(result, expr);
        matcher.appendTail(result);
        return result.toString();
    }

    //Расчёт умножения
    public static String calculateMultipication(String a){
        String regex = "(\\-?\\d+(\\.\\d+)?)\\*(\\-?\\d+(\\.\\d+)?)"; //находим первое выражение в скобках и вычисляем его, результат вставляем в строку
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);
        StringBuffer result = new StringBuffer();
        String expr;
        if (matcher.find()){ //случаи двух операндов подряд
            expr = matcher.group(0);
        }
        else{
            return "ERROR INCORRECT OPERANDS";
        }
        String[] numbers = expr.split("\\*");
        expr = (Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1])) + "";
        matcher.appendReplacement(result, expr);
        matcher.appendTail(result);
        return result.toString();
    }

    //Расчёт деления

    public static String calculateDivision(String a){
        String regex = "(\\-?\\d+(\\.\\d+)?)/(\\-?\\d+(\\.\\d+)?)"; //находим первое выражение в скобках и вычисляем его, результат вставляем в строку
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);
        StringBuffer result = new StringBuffer();
        String expr;
        if(matcher.find()){//случай двух операндов подряд
            expr = matcher.group(0);
        }
        else{
            return "ERROR INCORRECT OPERANDS";
        }
        String[] numbers = expr.split("/");
        if (numbers[1].equals("0")){
            return "ERROR DIVISION BY ZERO";
        }
        expr = (Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1])) + "";
        matcher.appendReplacement(result, expr);
        matcher.appendTail(result);
        return result.toString();
    }

    //расчёт сложения

    public static String calculateAddition(String a){
        String regex = "(-?\\d+(\\.\\d+)?)\\+(-?\\d+(\\.\\d+)?)";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);
        StringBuffer result = new StringBuffer();
        matcher.find();
        String expr = matcher.group(0);
        String[] numbers = expr.split("\\+");
        if (numbers.length==1){
            return "ERROR SUPERFLUOUS OPERATION";
        }
        Double number1 = Double.parseDouble(numbers[0]);
        Double number2 = Double.parseDouble(numbers[1]);
        expr = (number1+number2) + "";
        matcher.appendReplacement(result, expr);
        matcher.appendTail(result);
        return result.toString();
    }

    //расчёт вычитания

    public static String calculateSubtraction(String a){
        String regex = "(\\-?\\d+(\\.\\d+)?)-+(\\d+(\\.\\d+)?)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);
        StringBuffer result = new StringBuffer();
        matcher.find();

        String expr = matcher.group(0);
        String[] numbers = expr.split("-");
        Double number1;
        Double number2;
        if (a.charAt(0)=='-' & numbers.length==3){
            if (numbers[0].equals("") & numbers[1].equals("")){ //случай --5
                expr = Double.parseDouble(numbers[2])+"";
            }
            
            number1 = Double.parseDouble(numbers[1]);
            number2 = Double.parseDouble(numbers[2]);
            expr = (-number1-number2)+"";
            
            

        }
        else if(a.charAt(0)!='-' & numbers.length==2){
            number1 = Double.parseDouble(numbers[0]);
            number2 = Double.parseDouble(numbers[1]);
            expr = (number1-number2)+"";
        }
        else if (numbers.length==4){//случай -2--3
            number1 = Double.parseDouble(numbers[1]);
            number2 = Double.parseDouble(numbers[3]);
            expr = (-number1+number2)+"";
        }
        else{
            expr = Double.parseDouble(numbers[1])*(-1)+"";
        }
        matcher.appendReplacement(result, expr);
        matcher.appendTail(result);
        return result.toString();
    }
    //что первое умножение или деление
    public static boolean multOrDiv(String a){
        for (char i:a.toCharArray()){
            if (i=='*'){
                return false;
            }
            else if (i=='/'){
                return true;
            }
        }
        return true; //заглушка, куда невозможно попасть
    }
    
    public static boolean addOrSub(String a){
        String regex = "\\b(\\d+(\\.\\d+)?)[\\+-]+(\\d+(\\.\\d+)?)\\b";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);
        matcher.find();
        String expr = matcher.group(0);
        if (expr.contains("+")){
            return true;
        }
        else{
            return false;
        }
    }




    public static String isValid(String s){
        HashMap<String, Integer> countSymbols = new HashMap<>();
        //подсчёт количества символов
        for (char i : s.toCharArray()) {
            String charAsString = Character.toString(i);
            countSymbols.put(charAsString, countSymbols.getOrDefault(charAsString, 0) + 1);
        }
        
        //подсчёт количества частот
        HashMap<Integer, Integer> frequencyCount = new HashMap<>();
        for (int i: countSymbols.values()){
            frequencyCount.put(i, frequencyCount.getOrDefault(i, 0)+1);
        }
        
        //Если только одна частота
        if (frequencyCount.size() == 1) {
            return "YES";
        }
        //Если две частоты
        else if (frequencyCount.size() == 2) {
            int counter = 0;
            int[] numbers = new int[2];
            for (int i : frequencyCount.keySet()){
                numbers[counter] = i;
                counter++;
            }
            //Если разница между частотами не равна одному
            if (Math.abs(numbers[0]-numbers[1])!=1){
                return "NO";
            }
            int fr1 = frequencyCount.get(numbers[0]);
            int fr2 = frequencyCount.get(numbers[1]);
            if (fr1-1==0 | fr2-1==0){
                return "YES";
            }
            else{
                return "NO";
            }
            
        }
    
        return "NO";
    }



    public static String findLCS(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1]; //Матрица для поиска общей подпоследовательности

        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++){
                if (i==0 | j==0){ //длина пустой строки равна нулю
                    dp[i][j] = 0;
                }
                else if (str1.charAt(i-1)==str2.charAt(j-1)){//Если одинаковые символы
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);//Если символы разные, то просто выбираем максимальную из возможных подпоследовательностей
                }
            }
        }

        //получение строки
        int idx = dp[m][n]; //максимальное количество символов в подпоследовательности, а также элемент, из которого мы восстанавливаем нашу подпоследовательнсоть
        char[] result = new char[idx]; 
        int i = m;
        int j = n;
        while (i>0 & j>0){
            if (str1.charAt(i-1)==str2.charAt(j-1)){//Если символы совпали, то идём восстанавливать последовательность дальше
                result[idx-1]=str1.charAt(i-1);
                idx--;
                i--;
                j--;
            }
            else if (dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        return new String(result);

    }


}


