import java.util.LinkedList;

public class HashTable<K, V> {
    private static final int leng = 7;
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    
    public HashTable(){
        this(leng);
    }
    public HashTable(int a){
        table = new LinkedList[a];
        size = 0;
    }
    private int hash(K key){
        return Math.abs(key.hashCode())% (table.length);
    }
    public void put(K key, V value){
        int index = hash(key);
        if (table[index] == null){
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry :table[index]){
            if(entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry <K,V>(key, value));
        size ++;
    }
    public void remove(K key){
        int index = hash(key);
        if(table[index] != null){
            for(Entry<K, V> entry :table[index]){
                if(entry.getKey().equals(key)){
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }
    public V get(K key){
        int index = hash(key);
        if(table[index] != null){
            for(Entry <K,V> entry : table[index]){
                if(entry.getKey().equals(key)){
                    return entry.getValue();
                }
            }
        }
        return null;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    
    public static void main(String[] args){
        HashTable<String, Order> dataOrder = new HashTable<>();
        System.out.println(dataOrder.isEmpty());
        Order order1 = new Order("salad", 430, 7);
        String NumOrder1 = "b34";
        Order order2 = new Order("pasta", 720, 14);
        String NumOrder2 = "b35";
        System.out.println(dataOrder.getSize());
        dataOrder.put(NumOrder1, order1);
        dataOrder.put(NumOrder2, order2);
        Order z1 = dataOrder.get("b34");
        Order z2 = dataOrder.get("b35");
        System.out.println(dataOrder.isEmpty());
        System.out.println(z1.getDish());
        System.out.println(z2.getPrice());
        System.out.println(z1.getTime());
        System.out.println(dataOrder.getSize());
        dataOrder.remove("b34");
        System.out.println(dataOrder.get("b34"));
        System.out.println(dataOrder.isEmpty());
        System.out.println(dataOrder.getSize());


    }

    private static class Entry<K, V>{
        private K key;
        private V value;
        public Entry(K a, V b){
            key = a;
            value = b;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
        public void setValue(V a){
            value = a;
        }
    }

    
    
}

class Order{
    private String dish;
    private int price;
    private int time; 

    public Order(String d, int p, int t){
        dish = d;
        price = p;
        time = t;
    }
    public String getDish(){
        return dish;
    }
    public int getPrice(){
        return price;
    }
    public int getTime(){
        return time;
    }
    public void setDish(String d){
        dish = d;
    }
    public void setPrice(int p){
        price = p;
    }
    public void setTime(int t){
        time = t;
    }
}

