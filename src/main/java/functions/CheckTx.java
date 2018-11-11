package functions;

import java.io.IOException;
import java.util.Map;

import com.wavesplatform.wavesj.*;

public class CheckTx {
	
	public static void main(String args[]) throws IOException {
		
		Map<String, Object> tx;
		Object attachment;
		String hash;
		byte[] decodedHashByte;
		String decodedHash;
		String rtStatement;
		
	    Node node = new Node();
	    HibernateQueryFilm hq = new HibernateQueryFilm();
	    Hashing hs = new Hashing();
	    
	    /* Preparing Waves Attachment */
	    tx = node.getTransactionData("GA49qXuMVbb4hmbGbS9xBctNymToPo3LTBDFHvUUN5Vj");
	    attachment = tx.get("attachment");
	    hash = String.valueOf(attachment);
	    decodedHashByte = Base58.decode(hash);
	    decodedHash = new String(decodedHashByte, "UTF-8");
	    
	    /* Preparing Hibernate-Database Hash */
	    hq.doNewQuery();
	    rtStatement = hs.inputStreamDigest();
	    
	    /* comparing db-hash with attachment-hash */
	    System.out.println(rtStatement);
	    System.out.println(decodedHash);
	    if(rtStatement.equals(decodedHash)) {
	    	System.out.println("Check");
	    }
	}
}
