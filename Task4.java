package HW2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//Реализовать простой калькулятор (+ - / *)
public class Task4 {
    public static void main(String[] args) throws IOException {
        Logger lg = Logger.getLogger(Task1.class.getName());
        String logPath = "log.txt";
        FileHandler fh = new FileHandler(logPath,false);
        lg.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        calculator(lg);
    }

    public static void calculator(Logger lg) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число ");
        int a = sc.nextInt();
        System.out.print("Введите второе число ");
        int b = sc.nextInt();
        System.out.print("Выберите операцию ");
        String operand = sc.next();
        print(calc(a, b, operand));
        lg.log(Level.INFO, a+" "+operand+" "+b+" = "+ calc(a,b,operand));


    }


    public static double calc(int a, int b, String operand) {
        return operand.equals("+") ? a + b : operand.equals("-") ? a - b : operand.equals("*") ? a * b : a / b;
    }

    public static void print(double answer) {
        if (answer % 1 == 0) {
            System.out.println((int) answer);
        } else {
            System.out.println(answer);
        }
//        System.out.println(answer % 1 == 0 ? (int)answer : (answer));
    }
    public static void log(int a, int b, String operand, double answer) throws IOException {
        FileWriter fw = new FileWriter("CalcLog.txt", true);

        try{
            fw.write(String.format(LocalDateTime.now()+"%d %s %d = %s"+"\n", a,operand,b,answer));
            fw.flush();
        }
        catch(Exception ex){
            System.out.println("Ooops");
        }
    }

}
