public class ArrayAverage {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        int cnt = 0;

        try{
            for(int i = 0; i < arr.length; i++){
                sum += arr[i];
                cnt ++;
            }
            if(cnt == 0){
                throw new ArithmeticException("Делить на ноль нельзя");
            }
            double average = (double) sum / cnt;
            System.out.println("Среднее арифметическое:" + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за границы массива: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Неверный тип данных: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка при вычислении среднего арифметического: " + e.getMessage());
        }
    }
}
