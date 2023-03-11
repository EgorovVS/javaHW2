package HW2;


public class Task3 {
    public static void main(String[] args) {
        String str = "Онно";
        String str2 = "Гроза";
        System.out.println(isPalindrom(str));
        System.out.println(isPalindrom(str2));
    }

    public static boolean isPalindrom(String str) {
        str = str.toLowerCase();
        for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
}