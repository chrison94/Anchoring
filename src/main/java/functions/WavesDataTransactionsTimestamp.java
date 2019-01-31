package functions;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.wavesplatform.wavesj.Account;
import com.wavesplatform.wavesj.DataEntry;
import com.wavesplatform.wavesj.Node;
import com.wavesplatform.wavesj.PrivateKeyAccount;

public class WavesDataTransactionsTimestamp implements Runnable {
	
	private List<String> hashList;
	private List<Long> timestampList;
	private List<String> tableName;
	private List<String> entryID;
	
	public WavesDataTransactionsTimestamp(final List<String> hashList, final List<Long> timestampList, final List<String> tableName, final List<String> entryID) {
		this.hashList = hashList;
		System.out.println("huuuhu" + hashList);
		System.out.println(this.hashList);
		this.timestampList = timestampList;
		this.tableName = tableName;
		this.entryID = entryID;
	}
	
	@Override
	public void run() {
		sendHashTimestamp();
	}

	private void sendHashTimestamp()  {
		String seed = "spike mad lonely paper fiber give thrive bind blush wide test nest surge vault misery";
	    PrivateKeyAccount account = PrivateKeyAccount.fromSeed(seed, 0, Account.TESTNET);
		String address = account.getAddress();
		System.out.println(address);
		Node node = new Node();
	    long fee = 1300000;
	    int i = 0;
	    List<DataEntry<?>> data = new LinkedList<DataEntry<?>>();

	    System.out.println(hashList.size());
	  
	    for(Object hash : hashList) {
            String timestamp = Long.toString(timestampList.get(i));
            String tableNameVal = tableName.get(i);
            String entryIdVal = entryID.get(i);           
            try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        	
	    	data.add(new DataEntry.StringEntry(hash.toString(), timestamp + "/*/~/*/" + tableNameVal + "/*/~/*/" + entryIdVal));   
	    	i++;
	    }
	    
	    try {
		node.data(account, data, fee);
		    System.out.println("The DataTransaction was executed for the address: " + address);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
