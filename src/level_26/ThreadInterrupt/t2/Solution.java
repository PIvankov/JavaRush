package level_26.ThreadInterrupt.t2;

import java.util.concurrent.*;

/*
Все не так легко, как кажетс
*/
public class Solution extends ThreadPoolExecutor {
    public Solution(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        } else {
            return super.newTaskFor(callable);
        }
    }

    public static void main(String[] args) {
    }
}