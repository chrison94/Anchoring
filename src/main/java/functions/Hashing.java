package functions;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.*;

public class Hashing {

	    public String inputStreamDigest() {
	        System.out.println("SHAHashDemo.inputStreamDigest");
	        String data = System.getProperty("user.dir") + "/test.txt";
	        File file = new File(data);
	        try {
	            InputStream is = new FileInputStream(file);
	            String digest = DigestUtils.sha256Hex(is);	         
	            return digest;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return "Fehler";
	    }
}
