package HW2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

//Реализуйте алгоритм сортировки пузырьком числового массива (введён вами), результат после каждой итерации
//(после перемещения числа) запишите в лог-файл.
public class Task1 {
    public static void main(String[] args) throws IOException {
        int[] arr = {1, 0, 5, 4, 0, 2, 4, 2};
        log(LocalDateTime. now()+"\n"+arrayToString(arr)+"\n");
        FileWriter fw = new FileWriter("Log.txt", true);
        log(LocalDateTime. now()+"\n");
        bubbleSort(arr, arr.length);

    }

    public static int[] swap(int[] array, int i, int j) {
        int temp = 0;
        temp = array[j];
        array[j] = array[i];
        array[i] = temp;
        return array;
    }

    public static String arrayToString(int[] array) {
        String log = "[ ";
        for (int i = 0; i < array.length; i++) {
            log += array[i] + " ";
        }
        log+= "] "+"\n";
        return log;
    }

    public static void bubbleSort(int[] array, int length) throws IOException {
        for (int i = 0; i < length - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
                log(arrayToString(array));
                if (length - 1 > 1) bubbleSort(array, length - 1);
            }
        }
    }

    public static void log(String log) throws IOException {
        FileWriter fw = new FileWriter("Log.txt", true);
        try {
            fw.write(log);
            fw.flush();
        } catch (IOException ex) {
            System.out.println("Exception..");
        }
    }
}

