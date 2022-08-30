public class Worker {

    private OnTaskDoneListener callback;
    private OnErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public Worker(OnErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }

    public void getDone(int i) {
        callback.onDone("Task " + i + " is done");
    }


    public void getError(int i) {
        errorCallback.onError("Task " + i + " is wrong");
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
