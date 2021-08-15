package ua.com.nix.numbers;

import java.util.List;

public class NumbersTask extends Thread {

    private final List<Integer> list;
    private int counter = 0;

    public NumbersTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < list.size() - 1; i++) {
            if (checkSimple(list.get(i)))
                counter++;
        }
    }

    private boolean checkSimple(int i) {
        if (i <= 1)
            return false;
        else if (i <= 3)
            return true;
        else if (i % 2 == 0 || i % 3 == 0)
            return false;
        int n = 5;
        while (n * n <= i) {
            if (i % n == 0 || i % (n + 2) == 0)
                return false;
            n = n + 6;
        }
        return true;
    }

    public int getCounter() {
        return counter;
    }
}
