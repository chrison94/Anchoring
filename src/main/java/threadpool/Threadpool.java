package threadpool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import functions.WavesDataTransactions;
import functions.WavesDataTransactionsTimestamp;

public class Threadpool {

	ExecutorService executor = Executors.newFixedThreadPool(5);
	
	public void threadpoolHandle(final List<String> hashList, final List<Long> timestampList) {
		Runnable worker = new WavesDataTransactions(hashList, timestampList);        
    	executor.execute(worker);     
	}
	
    public void threadpoolHandleTimestamp(final List<String> hashList, final List<Long> timestampList, final List<String> tableName, final List<String> entryID) {    	
        Runnable worker = new WavesDataTransactionsTimestamp(hashList, timestampList, tableName, entryID);        
    	executor.execute(worker);                            
    }    
    
    public void shutdownThread() {
    	executor.shutdown();
    }
}