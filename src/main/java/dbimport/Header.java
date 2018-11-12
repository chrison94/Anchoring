package dbimport;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="header")
public class Header {	
	public String uid;
	public List<String> accessions;
	public String createdDate;
	public String seqRevDate;
	public String txtRevDate;
	
    @Override
    public String toString() {
        return "uid: " + uid + " createdDate " + createdDate + " seqRevDate " + seqRevDate;
    }
	
	
}
