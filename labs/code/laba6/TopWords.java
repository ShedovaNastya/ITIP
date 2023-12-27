import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class TopWords{
    public static void main(String[] args){
        //Указываем путь к файлу
        String filePath = "C:\\Users\\Настя\\Desktop\\мтуси\\ИТИП\\лабы\\лабы_код\\laba6\\book.txt";
        //создаём объект file
        File file = new File(filePath);
        // Создаём объект scanner для чтения файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(file, "UTF-8");
            //сканнер разбивает текст на токену по разделителю, который по умолчанию это пробел
        }
        catch (FileNotFoundException e){
            //вывод исключения в стандартный поток ошибок, в нашем случае это будет консоль
            e.printStackTrace();
        }
        //Создаём объект Map для хранения слов и их количества
        Map<String, Integer> dict = new HashMap<>();
        while (scanner.hasNext()){
            String word = scanner.next().toLowerCase();//чтение следующее элемента
            int countCurrentWord = dict.getOrDefault(word, 0)+1;//получаем элемент, если он есть, или ноль, если его нет и увеличиваем на единицу
            dict.put(word, countCurrentWord);//Добавляем или обновляем элемент в количестве слов 
        }
        //закрываем сканнер
        scanner.close();
        //создаём список из элементов Map
        ArrayList<HashMap.Entry<String, Integer>> elementsDict = new ArrayList<>(dict.entrySet());
        // сортируем список по убыванию количества повторенией
        Collections.sort(elementsDict, new Comparator<Map.Entry<String, Integer>>(){ // компаратор - умная штука, которая сравнивает элементы. В наешм случае мы создаём такой компаратор
            @Override //переопределение его метода для сравнения
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){ //функция сравнения, будет принимать два элемента и сравнивать их значения
                return o2.getValue().compareTo(o1.getValue()); // если o2>o1=>+1 если o2<01=>-1 если o2=o1=>0
            }
        });
        //выводим 10 слов или меньше, если в исходном тексте их меньше
        for (int i =0; i<Math.min(10, elementsDict.size()); i++){
            Map.Entry<String, Integer> temp = elementsDict.get(i);
            System.out.println((i+1) +" " + temp.getKey() + ":" + temp.getValue());
        }
    }
}
 