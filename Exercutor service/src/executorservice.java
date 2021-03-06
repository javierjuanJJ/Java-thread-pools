import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class executorservice {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(processors);
        for (int cont = 0; cont < processors; cont++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread");
                }
            });

        }

        executorService.shutdown();

    }
}
