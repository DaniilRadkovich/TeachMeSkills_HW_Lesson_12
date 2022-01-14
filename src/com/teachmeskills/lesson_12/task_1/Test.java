package com.teachmeskills.lesson_12.task_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        ArrayList<String> inputList = new ArrayList<String>();

        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        inputList.add(input);

        while (!input.equals("0")) {
            input = reader.nextLine();
            inputList.add(input);
        }

        System.out.println(inputList);

    }
}
