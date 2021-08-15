package ua.com.nix.spammer;

public class SpammerTask extends Thread {

    private final int number;

    public SpammerTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (number < 50) {
            SpammerTask spammerTask = new SpammerTask(number + 1);
            spammerTask.start();
            try {
                spammerTask.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Hello from thread " + number);
        }
    }

}
