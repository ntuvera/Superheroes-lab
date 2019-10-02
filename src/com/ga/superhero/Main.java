package com.ga.superhero;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static ArrayList<Superhero> superheroes = new ArrayList<Superhero>();;

    public static void main(String[] args) throws IOException {
        // TODO: run readfile and iterate to
        try {
            readFromFile("input.txt");
//            System.out.println(superheroes);
        }catch(IOException e){
            System.out.println("Something went wrong with ReadFromFile: " + e.getMessage());
            return;
        }
        startQuiz(superheroes);
    }

    // TODO: Read File using BufferedReader
    public static void readFromFile(String filename) throws IOException {
        String file = filename;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        try{
        String currentLine = reader.readLine();

        while (currentLine != null) {
            Superhero superhero = new Superhero();
            String[] data = currentLine.split(",");
            superhero.setSuperheroName(data[0]);
            superhero.setSecretIdentity(data[1]);
            superhero.setHome(data[2]);
            superhero.setDomain(data[3]);
            superheroes.add(superhero);
            currentLine = reader.readLine();
        }
        }finally{
            reader.close();
        }
//        return file;
    }


    // TODO: Write File using BufferedWriter
    public static void writeToFile(String name, String score, String fileName) throws IOException {
//        Path path = Paths.get(fileName);
//        byte[] strToBytes = (name + " " +score).getBytes();
//
//        Files.write(path, strToBytes);
//
//        String read = Files.readAllLines(path).get(0);
//        return read;

        BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(fileName)));
        bufferedWriter.write(name + " "+ score);

        bufferedWriter.close();
        return;
    }



    // TODO: Run game, loop through

    public static void startQuiz(ArrayList<Superhero> superheroes) throws IOException {
//        Superhero[] superheroes = superheroes;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Superhero quiz");
        int correctCount = 0;
        int incorrectCount = 0;

        for (Superhero hero : superheroes) {
            System.out.println("What is " + hero.getSuperheroName() + "'s secret Identity?");
            String ans1 = scanner.nextLine();
            if(ans1.equals(hero.getSecretIdentity())){
                System.out.println("You were correct!");
               correctCount++;
            } else {
                System.out.println("Sorry, that is incorrect");
                incorrectCount++;
            }
            System.out.println("Where is " + hero.getSuperheroName() + " originally from?");
            String ans2 = scanner.nextLine();
            if(ans2.equals(hero.getHome())){
                System.out.println("You were correct!");
                correctCount++;
            } else {
                System.out.println("Sorry, that is incorrect");
                incorrectCount++;
            }
            System.out.println("Is " + hero.getSuperheroName() + " a DC or Marvel hero?");
            String ans3 = scanner.nextLine();
            if(ans3.equals(hero.getDomain())){
                System.out.println("You were correct!");
                correctCount++;
            } else {
                System.out.println("Sorry, that is incorrect");
                incorrectCount++;
            }
        }
        String score = Integer.toString(correctCount) + " of " + (correctCount+incorrectCount);

        if(correctCount>incorrectCount) {
            System.out.println("You are teh winner");
            System.out.println("What's your name? ");
            String name = scanner.nextLine();
            try {
                writeToFile(name, score, "output.txt");
                System.out.println("Thanks for playing your name was recorded in the Hall of Fame");
            }catch(IOException e){
                System.out.println("Something went wrong recording your game: " + e.getMessage());
            }

        } else {
            System.out.println("Sorry you got " + incorrectCount + "answers wrong.  Try again after some studying");
        }

        scanner.close();
        return;
    }

}
