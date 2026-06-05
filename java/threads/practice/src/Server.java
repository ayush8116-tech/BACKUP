public class Server {
    private boolean isNewDataAvailable;
    private String data;

    public Server() {
        this.data = "";
        this.isNewDataAvailable = false;
    }

    public synchronized String getData() {
        while (!isNewDataAvailable) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        isNewDataAvailable = false;
        return this.data;
    }

    public synchronized void acceptData(String data) {
        this.data = data;
        isNewDataAvailable = true;
        this.notify();
    }
}
