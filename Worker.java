public class Worker {

    private OnTaskDoneListener callback;
    private OnErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " is wrong");
            } else callback.onDone("Task " + i + " is done");
        }
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnErrorListener {
        void onError(String result);
    }
}
