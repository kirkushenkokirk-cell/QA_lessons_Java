// Исключение для некорректного размера массива
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

// Исключение для некорректных данных в ячейке
class MyArrayDataException extends Exception {
    private int row;
    private int col;

    public MyArrayDataException(int row, int col, String value) {
        super(String.format("Не удалось преобразовать значение '%s' в число в ячейке [%d][%d]", value, row, col));
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
}


public class Main {

    // Метод, который обрабатывает двумерный строковый массив 4x4
    public static int processArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (arr.length != 4) {
            throw new MyArraySizeException("Массив должен иметь ровно 4 строки, а у вас " + arr.length);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Строка " + i + " должна иметь 4 элемента, а имеет " + arr[i].length);
            }
        }

        int sum = 0;
        // Проход по всем ячейкам и преобразование в int
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    // Если не число – бросаем MyArrayDataException с координатами
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
       
        // работа с корректным массивом

        System.out.println("=== Корректный массив 4x4 ===");
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int result = processArray(correctArray);
            System.out.println("Сумма всех элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

 
        //  некорректный размер (не 4 строки)

        System.out.println("\n=== Некорректный размер (3 строки) ===");
        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };
        try {
            int result = processArray(wrongSizeArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        
        // некорректные данные (не число)

        System.out.println("\n=== Некорректные данные в ячейке [2][1] ===");
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "abc", "11", "12"},  // "abc" не число
                {"13", "14", "15", "16"}
        };
        try {
            int result = processArray(wrongDataArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        
        // демонстрация перехвата ArrayIndexOutOfBoundsException
  
        System.out.println("\n=== Перехват ArrayIndexOutOfBoundsException ===");
        int[] testArray = {1, 2, 3};
        try {
            // Попытка обратиться к элементу за пределами массива
            int value = testArray[5];
            System.out.println("Значение: " + value); // Эта строка не выполнится
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Индекс выходит за границы массива!");
        }

      
        // демонстрация, что исключение djpможно
       
        System.out.println("\n=== Создание ArrayIndexOutOfBoundsException вручную ===");
        try {
            throw new ArrayIndexOutOfBoundsException("Тестовое сообщение о выходе за границы");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Перехвачено вручную созданное исключение: " + e.getMessage());
        }
    }
}
