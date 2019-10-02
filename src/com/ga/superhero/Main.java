package com.ga.superhero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        ArrayList<Superhero> superheroes = new ArrayList<Superhero>();

        // TODO: run readfile and iterate to

        /*readText*/
//		for( Superhero hero : /* */) {
//			superheroes.add(hero);
//		}

//        startQuiz();
        String test = readFromFile("input.txt");
        System.out.println(test);
        String writeTest = writeToFile(("output.txt"));

    }


    // TODO: Read File using BufferedReader
    public static String readFromFile(String filename) throws IOException {
//        try {
//            List<String> allLines = Files.readAllLines(Paths.get("/input.txt"));
//            for (String line : allLines) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String file = filename;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String currentLine = reader.readLine();
        while (currentLine != null) {
            builder.append(currentLine);
            builder.append("\n");
            currentLine = reader.readLine();
        }
        reader.close();
        return builder.toString();
    }


    // TODO: Write File using BufferedWriter
    public static String writeToFile(String fileName) throws IOException {
        String str = "Hello";

        Path path = Paths.get(fileName);
        byte[] strToBytes = str.getBytes();

        Files.write(path, strToBytes);

        String read = Files.readAllLines(path).get(0);
        return read;
    }



    // TODO: Run game, loop through

    public static String startQuiz(ArrayList<Superhero> superheroes) {
        System.out.println("Welcome to the Superhero quiz");
        int correctCount = 0;
        int incorrectCount = 0;

        for (Superhero hero : superheroes) {
            System.out.println("Is " + hero.getSuperheroName() + " a DC or Marvel hero?");

        }

        return "Hello";
    }

}
