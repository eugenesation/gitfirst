package ua.com.nix;

import ua.com.nix.numbers.NumbersTask;
import ua.com.nix.spammer.SpammerTask;
import ua.com.nix.starter.Starter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(4);
//        numbers.add(5);
//        numbers.add(6);
//
//        List<Integer> firstPartOfNumbers = new ArrayList<>(numbers.subList(0, numbers.size() / 2));
//        NumbersTask firstArray = new NumbersTask(firstPartOfNumbers);
//        Thread thread1 = new Thread(firstArray);
//        thread1.start();
//        thread1.join();
//
//        List<Integer> secondPartOfNumbers = new ArrayList<>(numbers.subList(numbers.size() / 2 - 1, numbers.size() - 1));
//        NumbersTask secondArray = new NumbersTask(secondPartOfNumbers);
//        Thread thread2 = new Thread(secondArray);
//        System.out.println(firstArray);
//        thread2.join();

        new Starter().start();

    }

}
