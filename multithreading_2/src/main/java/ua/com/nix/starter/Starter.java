package ua.com.nix.starter;

import ua.com.nix.hippodrome.Hippodrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {

    public void start() throws IOException, InterruptedException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Hippodrome hippodrome = new Hippodrome();

        System.out.println("Choose a horse from list by entering a number: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ");
        String horseName = "Horse " + bufferedReader.readLine();
        System.out.println("Starting the race...");

        int place = hippodrome.getPlace(horseName);

        System.out.println("Your horse finished on place: ");

        System.out.println(place);

    }
}
