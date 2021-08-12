package ua.com.nix.starter;

import ua.com.nix.spammer.SpammerTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Starter {

    List<Thread> threads = new ArrayList<>();

    public void start() throws InterruptedException {

        System.out.println("----------WELCOME TO THE TASK 1: REVERSE THREADS IN REVERSE ORDER---------");

        for (int i = 0; i < 50; i++) {
            SpammerTask spammerTask = new SpammerTask();
            spammerTask.start();
            Thread.sleep(3);
            threads.add(spammerTask);
        }

        System.out.println();

        System.out.println("In reverse order: \n");
        Collections.reverse(threads);

        for (Thread thread : threads) {
            System.out.println("Hello from thread " + thread.getName());
        }

    }

}
