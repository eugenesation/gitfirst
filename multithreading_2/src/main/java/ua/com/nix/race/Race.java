package ua.com.nix.race;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class Race implements Callable<Integer> {

    private static final int RACE_DISTANCE = 1000;
    private static final int MAX_SLEEP = 500;
    private static final int MIN_SLEEP = 400;
    private static final int MAX_DISTANCE = 200;
    private static final int MIN_DISTANCE = 100;

    private int currentDistance;
    private final Map<String, Integer> raceResults;
    private final AtomicInteger placeCounter;
    private final String name;
    private final Random rnd = new Random();

    public Race(String name, Map<String, Integer> raceResults, AtomicInteger place) {
        this.name = name;
        this.raceResults = raceResults;
        this.placeCounter = place;
        this.currentDistance = 0;
    }

    @Override
    public Integer call() {
        System.out.println(name + " started!");
        while (currentDistance < RACE_DISTANCE) {
            currentDistance += rnd.nextInt(MAX_DISTANCE - MIN_DISTANCE) + MIN_DISTANCE;
            System.out.println(name + " achieved " + currentDistance);
            try {
                Thread.sleep(rnd.nextInt(MAX_SLEEP - MIN_SLEEP) + MIN_SLEEP);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " finished!");
        int place = placeCounter.incrementAndGet();
        raceResults.put(name, place);
        return place;
    }

}
