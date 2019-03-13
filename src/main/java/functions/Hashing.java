package functions;

import org.apache.commons.codec.digest.DigestUtils;
import java.util.Iterator;
import java.util.List;


public class Hashing {

	    public String DatabaseEntryHash(List<Object> dataL) {	    	
	    	String dataString = "DbAnchoring2k18HRWProjektSeed";
	    	Iterator<Object> i = dataL.iterator();
	    	while(i.hasNext()) {
	    		Object obj = i.next();
	    		dataString += obj;
	    	}							    
			String dataTransKey = DigestUtils.sha256Hex(dataString);
			return dataTransKey;		
	    }

	    public String DatabaseEntryHashTimestamp(String hashString, Long timestamp) {	   	    
			String timestampS = Long.toString(timestamp);
			String dataTransKey = hashString + timestampS;
			dataTransKey = DigestUtils.sha256Hex(dataTransKey);
			return dataTransKey;
	    }
	    
	    public String DatabaseValidateHash(String validateString) {	    		    		    	
			String dataTransKey = DigestUtils.sha256Hex(validateString);
			return dataTransKey;
	    }

}
