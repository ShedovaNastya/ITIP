import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        // добавляем обработчики данных
        dataManager.registerDataProcessor(new FilterDataProccesor());
        dataManager.registerDataProcessor(new SquareDataProcessor());
        dataManager.registerDataProcessor(new CountDataProccessor());

        // Загружаем данные из файла
        try {
            dataManager.loadData("input.txt");
        } catch (IOException e) {
            e.printStackTrace();
            // Дополнительная обработка исключения по вашему усмотрению
        }

        // Обрабатываем данные 
        dataManager.processData();

        // Сохраняем обработанные данные в новый файл
        dataManager.saveResults("output.txt");
    }
}
