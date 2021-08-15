package ua.com.nix.starter;

import ua.com.nix.numbers.NumbersTask;
import ua.com.nix.spammer.SpammerTask;

import java.util.ArrayList;
import java.util.List;

public class Starter {

    List<Integer> listOfNumbers = new ArrayList<>();

    public void start() throws Exception {

        System.out.println("----------WELCOME TO THE TASK 1: REVERSE THREADS IN REVERSE ORDER---------");


        SpammerTask spammerTask = new SpammerTask(0);
        spammerTask.start();
        spammerTask.join();

        System.out.println("----------WELCOME TO THE TASK 2: NUMBERS----------");

        for (int i = 0; i < 50; i++) {
            listOfNumbers.add(i);
        }
        NumbersTask numbersTask1 = new NumbersTask(listOfNumbers.subList(0, listOfNumbers.size() / 2));
        NumbersTask numbersTask2 = new NumbersTask(listOfNumbers.subList(listOfNumbers.size() / 2, listOfNumbers.size()));

        numbersTask1.start();
        numbersTask2.start();

        numbersTask1.join();
        numbersTask2.join();
        System.out.println(numbersTask1.getCounter() + numbersTask2.getCounter());
    }

}
