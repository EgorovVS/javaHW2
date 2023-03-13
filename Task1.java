package HW2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//Реализуйте алгоритм сортировки пузырьком числового массива (введён вами), результат после каждой итерации
//(после перемещения числа) запишите в лог-файл.
public class Task1 {
    public static void main(String[] args) throws IOException {
        Logger lg = Logger.getLogger(Task1.class.getName());
        String logPath = "log.txt";
        FileHandler fh = new FileHandler(logPath,false);
        lg.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        int[] arr = {1, 0, 5, 4, 0, 2, 4, 2};
        lg.log(Level.INFO,arrayToString(arr)+"\n");
        bubbleSort(arr, arr.length,lg);

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

    public static void bubbleSort(int[] array, int length, Logger lg) throws IOException {
        for (int i = 0; i < length - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
                lg.log(Level.INFO,arrayToString(array)+"\n");
                if (length - 1 > 1) bubbleSort(array, length - 1, lg);
            }
        }
    }

    public static void log(String log, Logger lg) throws IOException {
        FileWriter fw = new FileWriter("Log.txt", true);
        try {
            fw.write(log);
            fw.flush();
        } catch (IOException ex) {
            System.out.println("Exception..");
        }
    }
}

