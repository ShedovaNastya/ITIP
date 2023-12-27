import java.util.Arrays;

/*
 Написать обобщенный класс Stack<T>, который реализует стек на основе
массива. Класс должен иметь методы push для добавления элемента в
стек, pop для удаления элемента из стека и peek для получения верхнего
элемента стека без его удаления
 */

public class Stack<T> {
    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack(){ //конструктор по умолчанию
        data = (T[]) new Object[DEFAULT_CAPACITY];
        //(T[]) приведению к заданному типу того, что написано далее
        // создание новое массива типа Object и с заданным объёмом 
        //В Java массивы обобщённых типов имеют ограничение из-за
        //стираний типов(type erasure). Во время компиляции обобщённые
        //типы заменяются их необобщёнными версиями, и во вермя выполнения
        //информация о типах стирается.
        //Создать напрямую массив обобщённого типа нельзя!
        size = 0;
    }
    public Stack(int capacity){ //конструктор с аргументами
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push(T element){//Добавить элемент
        ensureCapacity();
        data[size] = element;
        size++;
    }
    public T pop(){//удалить и вернуть верхний элемент
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        size--;
        T element = data[size];
        data[size] = null; //убираем элемент из стека
        return element;
    }
    public T peek(){//возврат верхнего элемента
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return data[size-1];
    }
    public boolean isEmpty(){//проверка на пустоту
        return size==0;
    }
    private void ensureCapacity(){//Увеличение размерности
        if (size == data.length){
            int newCapacity = data.length+10;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());
    }
}
