import java.util.function.Consumer;

public class Main {
    public static void main(String args[]) {

        Worker.OnTaskDoneListener listener = System.out::println;
        Worker.OnErrorListener listenerError = System.out::println;

        for (int i = 0; i < 100; i++) {
            if (i != 33) {
                Worker worker = new Worker(listener);
                worker.getDone(i);
            } else {
                Worker worker = new Worker(listenerError);
                worker.getError(i);
            }
        }
    }
}