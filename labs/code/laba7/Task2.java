import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task2 {
    public static void main(String[] args){
        int[] array = new int[500000];
        for(int i=0; i < 500000; i++){
            array[i] = i;
        }
        int numPot = 9;//количество потоков
        //Сам пул потоков
        //возвращаемое значение Future callable возвращает значение
        ExecutorService executorService = Executors.newFixedThreadPool(numPot);

        //будем разбивать массив на количество потоков. Это длина одной части
        int chunkSize = array.length / numPot; 

        //массив для хранения результатов каждого потока
        Future<Integer>[] results = new Future[numPot];

        //запуск потоков для обработки частей массива
        for(int i=0; i < numPot; i++){
            int start = i*chunkSize;
            int end = (i == numPot - 1) ? array.length : (i+1)*chunkSize;
            //создаем задачу для каждого потока и передаем ей нужную часть массива
            ArrayMaxTask task = new ArrayMaxTask(array, start, end);


            //помещаем задачу в пул потоков и сохраняем результат в наш результирующий массив
            results[i] = executorService.submit(task);
        }

        executorService.shutdown();//завершение

        //суммирование наших результатов 
        int ans = 0;
        try{
            for(Future<Integer> i : results){
                if(ans < i.get()){
                    ans = i.get();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(ans);
    }
}    
class ArrayMaxTask implements java.util.concurrent.Callable<Integer>{
    private int[] arr;
    private int startIndex;
    private int endIndex;

    public ArrayMaxTask(int[] arr, int start, int end){
        this.arr = arr;
        this.startIndex = start;
        this.endIndex = end;
    }

    @Override
    public Integer call(){
        int max = 0;
        for (int i=startIndex; i<endIndex; i++){
            max= Math.max(max, arr[i]);
        }
        return max;
    }

}

