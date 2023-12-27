import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataManager {
    private List<Object> dataProcessors = new ArrayList<>();
    //массив для хранения обработчиков данных

    private List<Integer> inputData = new ArrayList<>();
    //Массив для сохранения входных данных

    private List<List<Integer>> processorResults = new ArrayList<>();
    //Массив для сохранения результатов работы различными обработчиками данных

    public void registerDataProcessor(Object processor) {
        //метод для добавления обработчика данных в список
        dataProcessors.add(processor);
    }

    public void loadData(String source) throws IOException {
        // Чтение данных из файла
        //Paths.get(source) создаёт из строки путь к файлу
        //Files.readAllLines чтение всех строк из файла
        //и возвращение их в виде списк строк
        List<String> lines = Files.readAllLines(Paths.get(source));

        // lines.stream() преобразование списка строк в поток строк
        //.flatMap метод используется для объединения всех потоков
        //слов в один общий поток
        //line -> Stream.of(line.split("\\s+")) для каждой строки line
        //метод split разбивает строку, использую пробле как разделитель
        //Stream.of мы передаем массив строк, полученный после разибения и создаём поток слов
        //.map(Integer::parseInt) к каждому элементу потока мы применяем выражение
        //Integer::parseInt сокращённый синтаксис для передачи метода как параметра
        //мы ссылаемся на статический метод
        //в конце преобразуем в список
        inputData = lines.stream()
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .map(Integer::parseInt)
                .toList();
    }

    public void processData() {
        // Определяем количество потоков, в нашем случае оно соответствует количеству обработчиков данных
        int numberOfThreads = 3;

        //создаём сервис для управления потоками
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        List<CompletableFuture<List<Integer>>> futures = new ArrayList<>();
        //список, в котором находяться задачи. Каждая задача представляет собой результат
        // в виде списка интов.

        for (Object processor : dataProcessors) {
            CompletableFuture<List<Integer>> future = CompletableFuture.supplyAsync(() -> processWithProcessor(processor), executorService);
            futures.add(future);
        }
        //Итерируемся по всем обработчикам данных
        //CompletableFuture.supplyAsync создаёт и возвращает CompletableFuture, который будет выполнен в отдельном поток
        //() -> processWithProcessor(processor) лямбда выражение не принимает аргументы
        // в теле лямбда выражения мы вызывает метод, для работы с данными

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        // создаём объект типа CompletableFuture<Void>, когда завершаются все поток.
        //массив futures преобразуется в массив типа CompletableFuture, указано в скобках. [0] пустой массив, в нашем случае используем как шаблон
        //метод AllOf ожидает завершения всех потоков. он создает новые CompletableFuture, передавая ему все остальные после завершения работы CompletableFuture

        try {
            combinedFuture.get();
            //метод блокирует текущий поток, ожидая завершенеия всех асинхронных задач в этой переменно
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
            //сервис больше не принимает новые задачи и завершает предыдщуеи
        }


        // Получаем результаты из CompletableFuture
        processorResults = futures.stream() //преобразует список в поток объектов
                .map(CompletableFuture::join)
                //преобразуем каждый элемент при помощи метода .join, т.е. преобразует в поток результатов каждой задачи
                .collect(Collectors.toList());
                //сбор результатов из поток в список
    }
    private List<Integer> processWithProcessor(Object processor) {
        List<Integer> result = new ArrayList<>();
        //создаём объект, в котором будем хранить результат обработки данных
        for (Method method : processor.getClass().getDeclaredMethods()) {
            //итерируемся по методам в процессоре
            if (method.isAnnotationPresent(DataProcessor.class)) {
                //проверка, явялется ли текущий метод аннотированным согласна DataProccesor
                processWithMethod(processor, method, inputData, result);
                //вызов метода для обработки данных
            }
        }
        return result;
    }

    private void processWithMethod(Object processor, Method method, List<Integer> input, List<Integer> result) {
        try {
            method.invoke(processor, input, result);
            //вызов метода обработчика данных
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveResults(String destination) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < processorResults.size(); i++) {
            //итерация по объектам массива
            List<Integer> result = processorResults.get(i);
            //получаем результат обработки данных для текущего процесса
            temp.addAll(result);
            temp.add(100000000);
        }
        try {
            Files.write(Paths.get(destination + "_result" + ".txt"), temp.stream().map(Object::toString).toList());
                //запись в файл.
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
