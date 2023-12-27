import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class SalesTracker {
    private List<String> soldProducts;

    public SalesTracker() {
        // Используем CopyOnWriteArrayList для обеспечения безопасности при одновременном чтении и записи
        soldProducts = new CopyOnWriteArrayList<>();
    }

    public void addSale(String product) {
        soldProducts.add(product);
    }

    public void displaySales() {
        System.out.println("Список проданных товаров:");
        for (String product : soldProducts) {
            System.out.println(product);
        }
    }

    public double calculateTotalSales() {
        return soldProducts.size();
    }

    public String getMostPopularProduct() {
        HashMap<String, Integer> sales = new HashMap<>();
        for (int i=0; i<soldProducts.size(); i++){
            String product = soldProducts.get(i);
            sales.put(product, sales.getOrDefault(product, 0)+1);
        }
        //создаём список из элементов Map
        ArrayList<HashMap.Entry<String, Integer>> elementsDict = new ArrayList<>(sales.entrySet());
        // сортируем список по убыванию количества повторенией
        Collections.sort(elementsDict, new Comparator<Map.Entry<String, Integer>>(){ 
            @Override //переопределение его метода для сравнения
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){ //функция сравнения, будет принимать два элемента и сравнивать их значения
                return o2.getValue().compareTo(o1.getValue()); // если o2>o1=>+1 если o2<01=>-1 если o2=o1=>0
            }
        });
        return elementsDict.get(0).getKey();
    }

    public static void main(String[] args) {
        SalesTracker salesTracker = new SalesTracker();

        salesTracker.addSale("Book");
 

        // Список проданных товаров
        salesTracker.displaySales();

        // Общая сумма продаж
        System.out.println("Общая сумма продаж: " + salesTracker.calculateTotalSales());

        // Наиболее популярный товар
        System.out.println("Наиболее популярный товар: " + salesTracker.getMostPopularProduct());
    }
}


