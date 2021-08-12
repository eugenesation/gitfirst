package ua.com.nix.spammer;

public class SpammerTask extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from thread " + Thread.currentThread().getName());
    }

}
