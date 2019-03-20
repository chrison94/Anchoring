package functions;

import com.wavesplatform.wavesj.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import config.Configuration;

public class WavesDataTransactions implements Runnable {
	private List<Object> hashList;
	private List<Object> timestampList;
	private List<Object> tableNameList;
	private List<Object> entryList;
	Configuration conf = new Configuration();

	public WavesDataTransactions(final List<Object> hashList, final List<Object> timestampList,  final List<Object> tableNameList,  final List<Object> entryList) {
		this.hashList = hashList;
		this.timestampList = timestampList;
		this.tableNameList = tableNameList;
		this.entryList = entryList;
	}

	@Override
	public void run() {
		sendHash();
	}

	private void sendHash() {
		String seed = conf.getSeed();
		PrivateKeyAccount account = PrivateKeyAccount.fromSeed(seed, 0, Account.TESTNET);
		String address = account.getAddress();
		Node node = new Node();
		long fee = conf.getFee();

		int i = 0;
		List<DataEntry<?>> dataT = new LinkedList<DataEntry<?>>();
		for (Object hash : this.hashList) {
			String timestamp = this.timestampList.get(i).toString();
			String tableNameVal = this.tableNameList.get(i).toString();
			String entryIdVal = this.entryList.get(i).toString();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dataT.add(new DataEntry.StringEntry(hash.toString(), timestamp + "/*/~/*/" + tableNameVal + "/*/~/*/" + entryIdVal));
			i++;
		}
		try {

			node.data(account, dataT, fee);
			System.out.println("The DataTransaction was executed for the address: " + address);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (e.getMessage().contains("Reason: negative waves balance")) {
				System.out.println("Sie haben nicht genügend Waves um die Data-Transaction durchzuführen.");
				System.exit(1);
			}
		}
	}
}