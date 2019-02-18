package utils;

public class Waiters {

    public void sleep(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
