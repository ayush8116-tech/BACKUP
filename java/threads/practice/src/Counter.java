import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count;
    private ReentrantLock lock = new ReentrantLock();

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public synchronized void inc() {
        lock.lock();
        this.count++;
        lock.unlock();
    }
}
