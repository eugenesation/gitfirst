package ua.com.nix.numbers;

import java.util.List;

public class NumbersTask implements Runnable {

    private volatile List<Integer> list;
    private int counter = 0;

    public NumbersTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
//        for (int i = 0; i < list.size(); i++) {
//
//            if (list.get(i) > 1 && list.get(i) % 2 != 0 && list.get(i) % 3 ) {
//                counter++;
//            }
//        }
    }

        public synchronized Object get() {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            return counter;
        }
    }
