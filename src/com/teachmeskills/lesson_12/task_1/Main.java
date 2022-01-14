package com.teachmeskills.lesson_12.task_1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ways to your document and names of this documents (press 0 to exit): ");
        List<String> waysAndNames = new ArrayList<>();
        String input = sc.nextLine();
        waysAndNames.add(input);
        while (!input.equals("0")) {
            input = sc.nextLine();
            waysAndNames.add(input);
        }
        waysAndNames.remove("0");
        System.out.println(waysAndNames);
        sc.close();

        Set<String> commonDoc = new HashSet<>();

        for (String way : waysAndNames) {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(way)));
            commonDoc.addAll(lines);
        }
        System.out.println(commonDoc);

        BufferedWriter validNumbers = new BufferedWriter(new FileWriter("Valid.txt"));
        Map<List, String> finalDoc = new HashMap<>();

        for (String doc : commonDoc) {
            if (doc.length() == 15 && (doc.startsWith("docnum") || doc.startsWith("contract"))) {
                validNumbers.write(waysAndNames + " " + doc + " --> Valid document!" + "\n");
                finalDoc.put(waysAndNames, doc);
            } else if (doc.length() != 15 && (doc.startsWith("docnum") || doc.startsWith("contract"))) {
                validNumbers.write(waysAndNames + " " + doc + " --> Wrong document length!" + "\n");
                finalDoc.put(waysAndNames, doc);
            } else if (!(doc.startsWith("docnum") || doc.startsWith("contract"))) {
                validNumbers.write(waysAndNames + " " + doc + " --> Document don't starts with 'docnum' or 'contract'!" + "\n");
                finalDoc.put(waysAndNames, doc);
            }
        }
        System.out.println(finalDoc);
        validNumbers.close();
    }
}
