import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Этот калькулятор может выполнять вычисления с арабсикими и римскими числами\n" +
                "Калькулятор принимает на вход числа от 1 до 10 включительно\n" +
                "Калькулятор умеет работать только с арабскими или римскими цифрами одновременно\n" +
                "Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами\n" +
                "Примеры выражений: a + b, a - b, a * b, a / b\n" +
                "Введите арифметическую операцию операцию");
        String str = scan.nextLine();

        System.out.println(calc(str));
    }

    public static String calc(String input) throws Exception {
            String[] parts = input.split(" ");

            if (parts.length > 3) throw new Exception();

            boolean isArabic = true;
            if (Number.IsArabic(parts[0]) && Number.IsArabic(parts[2]))
                isArabic = true;
            else if (!Number.IsArabic(parts[0]) && !Number.IsArabic(parts[2])) isArabic = false;
            else throw new Exception();

            Number a = new Number(parts[0]);
            Number b = new Number(parts[2]);
            Number result = new Number();

            if (a.value>10 || b.value>10) throw new Exception();

            switch(parts[1]){
                case "+":
                    result.value = a.value + b.value;
                    break;
                case "-":
                    result.value = a.value - b.value;
                    break;
                case "/":
                    result.value = a.value / b.value;
                    break;
                case "*":
                    result.value = a.value * b.value;
                    break;
                default:
                    System.out.println("Не верный арифметический знак");
                    throw new Exception();
            }

            if (isArabic) return result.value.toString();
            else return result.toRoman();
    }




}

