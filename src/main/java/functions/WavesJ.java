package functions;
import java.io.IOException;
import java.net.URISyntaxException;

import com.wavesplatform.wavesj.*;

public class WavesJ {

	public WavesJ() {
		
	}
	
	public void transaction(String description) throws IOException, URISyntaxException {
	    final long FEE = 100000;
	    final long AMOUNT = 10000;
	    
	    String seed = "bronze soon smoke armor scene fold metal quiz fiscal flee banner rude limb artwork timber";
	    PrivateKeyAccount account = PrivateKeyAccount.fromSeed(seed, 0, Account.TESTNET);
	    byte[] publicKey = account.getPublicKey();
	    String address = account.getAddress();
	    System.out.println(publicKey);
	    System.out.println(address);
	    
	    Node node = new Node();
	    int height = node.getHeight();
	    System.out.println("Blockchain-height: " +height);
	    System.out.println("Balance of your Account: " +node.getBalance(address));

	    String secondUser = "3MxAwrfLiCDFZPS3NHa6NdEzRgEWnMkApMm";
	    System.out.println("Recipient-address " + secondUser);
	    System.out.println("Amount you've send " + AMOUNT);
	    System.out.println("Transaction FEE: " + FEE);
		System.out.println("Transaction desc: " + description);
    	node.transfer(account, secondUser, AMOUNT, FEE, description);
	}
}
