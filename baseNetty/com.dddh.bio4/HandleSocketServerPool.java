import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandleSocketServerPool {

    private ExecutorService executorService;

    public HandleSocketServerPool(int maxThreadNum,int queueSize){
        this.executorService=new ThreadPoolExecutor(3,maxThreadNum,60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueSize));

    }
    public  void execute(ServerThread4 taget){
        executorService.execute(taget);
    }
}
