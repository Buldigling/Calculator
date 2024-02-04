package TestTask;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Calculator {
    public static <string> void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("input data");
        String string = input.nextLine();
        String[] array = string.split(" ");
        if (array.length != 3){
            throw new Exception("необходимый формат: два операнда и один оператор (a + b)");
        }
        String inputStringX = array[0];
        String inputStringY = array[2];
        int x1 = 0;
        int y1 = 0;
        int result;
        string romanResult;
        boolean partOfRomanX = false;
        boolean partOfRomanY = false;
        String symbol = array[1];

        //перевод римких чисел в арабские
        String[] romanNumber = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        for (int i = 0; i < romanNumber.length; i++) {
            if (romanNumber[i].equals(inputStringX)) {
                partOfRomanX = true;
                x1 = i+1;
                if (x1>10){
                    throw new Exception("вводимые значения должны быть в пределах 10");
                }
            }
        }
        for (int j = 0; j < romanNumber.length; j++) {
            if (romanNumber[j].equals(inputStringY)) {
                partOfRomanY = true;
                y1 = j+1;
                if (y1>10){
                    throw new Exception("вводимые значения должны быть в пределах 10");
                }
            }
        }

        //римское решение
        if ((partOfRomanX && partOfRomanY) == true) {
            switch (symbol) {
                case "/":
                    result = (x1 / y1) - 1;
                    if (result == -1){
                        System.out.println(0);
                    }
                    else{
                        romanResult = (string) Array.get(romanNumber, result);
                        System.out.println(romanResult);
                    }
                    break;
                case "*":
                    result = (x1 * y1) - 1;
                    romanResult = (string) Array.get(romanNumber, result);
                    System.out.println(romanResult);
                    break;
                case "-":
                    result = (x1 - y1) - 1;
                    if (result == -1){
                        System.out.println(0);
                    }
                    else if (result < -1){
                        throw new Exception("в римской системе нет отрицательных чисел");
                    }
                    else{
                        romanResult = (string) Array.get(romanNumber, result);
                        System.out.println(romanResult);
                    }
                    break;
                case "+":
                    result = (x1 + y1) - 1;
                    romanResult = (string) Array.get(romanNumber, result);
                    System.out.println(romanResult);
                    break;
                default:
                    throw new Exception("неверный оператор");
            }
        }

        //числовое решение
        else if ((partOfRomanX || partOfRomanY) == false) {
            x1 = Integer.parseInt(array[0]);
            y1 = Integer.parseInt(array[2]);
            if ((x1 > 10) || (x1 < 1)){
                throw new Exception("вводимые значения должны быть в пределах 10");
            }
            if ((y1 > 10) || (y1 < 1)){
                throw new Exception("вводимые значения должны быть в пределах 10");
            }
            switch (symbol) {
                case "/":
                    result = x1 / y1;
                    System.out.println(result);
                    break;
                    case "*":
                    result = x1 * y1;
                    System.out.println(result);
                    break;
                case "-":
                    result = x1 - y1;
                    System.out.println(result);
                    break;
                case "+":
                    result = x1 + y1;
                    System.out.println(result);
                    break;
                default:
                    throw new Exception("неверный оператор (+, -, *, /)");
                }
            }

            else throw new Exception("разные системы счисления");
    }
}