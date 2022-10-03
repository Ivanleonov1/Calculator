package com.iv_leo;

import java.util.Scanner;

public class Main {
    public static String calc(String input) {
        String[] calc_inputString = input.split(" ");
        if (calc_inputString.length != 3) {
            Scanner inputString_a_value_again = new Scanner(System.in);
            input = inputString_a_value_again.nextLine();
            return calc(input);
        } else {
            return input;
        }
    }

        public static void main(String[] args) {
            Converter converter = new Converter();
            String[] actions = {"+", "-", "/", "*"};
            String[] regexActions = {"\\+", "-", "/", "\\*"};
            Scanner scn = new Scanner(System.in);
            System.out.print("Введите выражение выражение в одну строку: ");
            String exp = scn.nextLine();

            int actionIndex=-1;
            for (int i = 0; i < actions.length; i++) {
                if(exp.contains(actions[i])){
                    actionIndex = i;
                    break;
                }

            }

            if(actionIndex==-1){
                System.out.println("Некорректное выражение");
                return;
            }




            String[] data = exp.split(regexActions[actionIndex]);


            if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
                int a,b;

                boolean isRoman = converter.isRoman(data[0]);
                if(isRoman){

                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);

                }else{

                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }

                if ((a > 10 || a < 0) || (b > 10 || b < 0)) {
                    System.out.println("Введите число от 1 до 9 включительно");
                    return;
                }

                int result = 0;
                switch (actions[actionIndex]){
                    case "+":
                        result = a+b;
                        break;
                    case "-":
                        result = a-b;
                        break;
                    case "*":
                        result = a*b;
                        break;
                    case "/":
                        try {
                            result = a/b;
                        }catch (ArithmeticException | IllegalArgumentException e) {
                            System.out.printf("Нельзя делить на ");
                        }

                        break;

                    default:
                        throw new IllegalArgumentException("Введите првильное выражение");

                }



                if(isRoman){

                    System.out.println(converter.intToRoman(result));
                }
                else{

                    System.out.println(result);
                }
            }else{
                System.out.println("Числа должны быть в одном формате");
            }
            calc(scn.nextLine());


        }

    }



