import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorService {

    private static final int NUM_THREADS = 5;
    private static final int NUM_ASYNC_TASKS = 20;
    private static final int LAST_NUMBER = 10;
    private static final int MIN_SLEEP_TIME = 200;
    private static final int MAX_SLEEP_TIME = 500;

    public static void main(String[] args) {
        int cont = 0;
        java.util.concurrent.ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (cont = 0; cont < NUM_THREADS; cont++) {
            Thread thread = new Thread(new PrintNumber(" Task " + cont, LAST_NUMBER, (int) Math.floor(Math.random() * MAX_SLEEP_TIME + MIN_SLEEP_TIME)));
            executorService.execute(thread);
        }
        for (cont = 0; cont < NUM_ASYNC_TASKS; cont++) {
            Thread thread = new Thread(new PrintNumber(" Task " + cont, LAST_NUMBER, (int) Math.floor(Math.random() * MAX_SLEEP_TIME + MIN_SLEEP_TIME)));
            executorService.execute(thread);
        }
        try {
            executorService.awaitTermination(1, TimeUnit.SECONDS);
            executorService.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\t\t\t\tTerminado ");
    }
}
