import java.util.Scanner;
import java.util.*;

/*
 Take full name from console
 sort it them by lenght and set first char to upperCase
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrectName = false;
        System.out.println("Введите ваше имя (ФИО) полностью!");
        while (!isCorrectName) {
            String name = scanner.nextLine(); //Считывает строку из System.in
            isCorrectName = checkName(name);
            if (!isCorrectName) {
                System.out.println("Введите корректное имя!");
            } else {
                System.out.println(formatName(name));
            }
        }
    }
    //chek for correct input name surname and patronymic
    private static boolean checkName(String name) {
        int wordCount = 0;
        String[] stringFromName = name.split(" ");
        //System.out.println(Arrays.toString(stringFromName));
        if (stringFromName.length >= 3) {
            for (int i = 0; i < stringFromName.length; i++) {
                //chek all strings in array, if stringLen > 2 -> this is correct string
                if (stringFromName[i].length() > 2) {
                    // calculate all correct strings
                    wordCount++;
                }
            }
            // chek to have all 3 correct string on name (FIO)
            if (wordCount == 3) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    // del from input String repeat whitespace
    // set first char to uppercase
    private static String formatName(String name) {
        //Написать код здесь
        String formattingString = new String();
        String testString = new String();
        String[] stringFromName = name.split(" ");
       
        for (int i = 0; i < stringFromName.length; i++) {
            if (stringFromName[i].length() > 2) {
                if(formattingString.length() != 0) {
                    formattingString += " ";
                }
                testString = stringFromName[i].substring(0,1).toUpperCase();
                testString += stringFromName[i].substring(1,stringFromName[i].length());
                formattingString += testString ;
            }
        }
        String[] newStringArray = formattingString.split(" ");
        sortByLength(newStringArray);
        formattingString =  Arrays.toString(newStringArray);
        return formattingString;
    }

    private static void sortByLength(String[] words) {
        //Написать код здесь
        String str = "";
        if (words[0].length() > words[1].length()) {
            if(words[0].length() > words[2].length()) {
                str = words[2];
                words[2] = words[0];
                words[0] = str;
            } else {
                str = words[1];
                words[1] = words[0];
                words[0] = str;
            }
        }
        if (words[0].length() > words[1].length()) {
            str = words[1];
            words[1] = words[0];
            words[0] = str;
        }
        if (words[1].length() > words[2].length()) {
        str = words[1];
        words[1] = words[2];
        words[2] = str;
        }
    }
}
