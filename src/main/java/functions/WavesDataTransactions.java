package functions;

import com.wavesplatform.wavesj.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class WavesDataTransactions implements Runnable {
	private List<String> hashList;
	private List<Long> timestampList;
	
	public WavesDataTransactions(final List<String> hashList, final List<Long> timestampList) {
		this.hashList = hashList;
		this.timestampList = timestampList;
	}
	
	@Override
	public void run() {
		sendHash();
		
	} 
	
	private void sendHash()  {
		String seed = "spike mad lonely paper fiber give thrive bind blush wide test nest surge vault misery";
	    PrivateKeyAccount account = PrivateKeyAccount.fromSeed(seed, 0, Account.TESTNET);
		String address = account.getAddress();
		System.out.println(address);
		Node node = new Node();
	    long fee = 1300000;
	    System.out.println("wavvvvvv" + hashList.size());
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    int i = 0;	   
	            	    List<DataEntry<?>> dataT = new LinkedList<DataEntry<?>>(); 	        		
	                    for(Object hash : hashList) {
	                        String timestamp = Long.toString(timestampList.get(i));
	                        try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	                        dataT.add(new DataEntry.StringEntry(hash.toString(), timestamp));                
	                        i++;
	                    }
	             		//data.add(new DataEntry.StringEntry(hash, timestamp));
	    
//	    DataTransaction T = new DataTransaction(account, data, fee, System.currentTimeMillis()); --> Möglichkeit zwei 
//	    T = Transactions.makeDataTx(account, data, fee);
	    try {
		//	node.send(T);
		node.data(account, dataT, fee);
		    System.out.println("The DataTransaction was executed for the address: " + address);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}