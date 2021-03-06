public class PrintNumber implements Runnable {
    private String taskName;
    private int lastTime;
    private int MAX_SLEEP_TIME;

    public PrintNumber(String taskName, int lastTime, int MAX_SLEEP_TIME) {
        this.taskName = taskName;
        this.lastTime = lastTime;
        this.MAX_SLEEP_TIME = MAX_SLEEP_TIME;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName() + " " + taskName;
        for (int cont = 0; cont < lastTime; cont++) {
            System.out.println(name + " # " + cont);
            try {
                Thread.sleep(MAX_SLEEP_TIME);
            } catch (InterruptedException e) {

            }
        }
        System.out.println("Terminado " + name);
    }
}
