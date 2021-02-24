package practic4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartThread {
    public StartThread(int k){
        ExecutorService executorService = Executors.newFixedThreadPool(k);
        for (int i = 0; i <k;i++){
            Runnable runnable = new InfoThread("Task"+i);
            executorService.execute(runnable);
        }
    }
}
