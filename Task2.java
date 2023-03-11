package HW2;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Дана строка (получение через обычный текстовый файл!!!)
//        "фамилия":"Иванов","оценка":"5","предмет":"Математика"
//        "фамилия":"Петрова","оценка":"4","предмет":"Информатика"
//        Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
//        Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.


public class Task2 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/Виктор Егоров/IdeaProjects/GB/src/main/java/HW2/students.txt");
//        System.out.println(report(noTrash(fileRead(file))).toString());
        fileRead(file);
        System.out.println(report(noTrash(fileRead(file))));
        }

    public static StringBuilder report(ArrayList<String[]> cleanList){
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < cleanList.size(); i++) {
            report.append("Студент ").append(cleanList.get(i)[1]+" ").append("получил ").append(cleanList.get(i)[3]+" ").
                    append("по предмету ").append(cleanList.get(i)[5]+"\n");
        }
        return report;
    }

    public static ArrayList<String[]> noTrash(ArrayList<String> readedFile) throws FileNotFoundException {
        ArrayList<String[]> cleanList = new ArrayList<>();
        for (String str:readedFile
             ) {
            String clean = str.replace(",", " ").replace(":", " ").replace("\"", "");
            String[] array = clean.trim().split(" ");
            cleanList.add(array);
        }
        return cleanList;
    }

    public static ArrayList<String> fileRead(File file) throws FileNotFoundException {
        ArrayList<String> readedFile = new ArrayList<>();
        String line = null;
//        String ls = System.getProperty("line.separator");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        try {

            while ((line = br.readLine()) != null) {
                readedFile.add(line);
//                str+=ls;
            }

        } catch (Exception ex) {
            System.out.println("Exception");
        }
        return readedFile;
    }
}
