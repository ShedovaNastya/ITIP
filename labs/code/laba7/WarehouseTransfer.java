import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
public class WarehouseTransfer {
    public static void main(String[] args) {
        int[] weights = {34,71,56,49,39,61,96};
        int numLoaders = 3;
        AtomicInteger totalWeight = new AtomicInteger(0);

        ExecutorService executorService = Executors.newFixedThreadPool(numLoaders);//управляет потоками
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);//развязка запуска асинхронных задачи получ результата

        int batchSize = weights.length / numLoaders;

        for (int i = 0; i < numLoaders; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i == numLoaders - 1) ? weights.length -1: (i + 1) * batchSize - 1;

            completionService.submit(new Loader(weights, startIndex, endIndex, totalWeight, i+1));
        }

        for (int i = 0; i < numLoaders; i++) {
            try {
                Future<Integer> future = completionService.take();
                totalWeight.set(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("finish");

        executorService.shutdown();
    }
}

class Loader implements Callable<Integer> {
    private int[] weights;
    private int startIndex;
    private int endIndex;
    private AtomicInteger totalWeight;
    private int name;

    public Loader(int[] weights, int startIndex, int endIndex, AtomicInteger totalWeight, int name) {
        //AtomicInteger totalWeight - переменная, чтобы все потоки могли с ней взаимодействовать
        this.weights = weights;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.totalWeight = totalWeight;
        this.name = name;
    }

    @Override
    public Integer call() {
        for (int i = startIndex; i <= endIndex; i++) {
            if (totalWeight.get() + weights[i] < 150) {
                totalWeight.addAndGet(weights[i]);
                System.out.println(name + " " + weights[i]);
            } else {
                System.out.println("Loader " + name + " can't take more items.");
                totalWeight.set(weights[i]);
                System.out.println(name + " " + weights[i]);
            }
            try {
            Thread.sleep(500);//задержка
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        return 1;
    }
}
