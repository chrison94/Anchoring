package hibernate;

import javax.persistence.PrePersist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.persistence.PostUpdate;

import entities.film;
import functions.Hashing;
import functions.WavesJ;

public class LastUpdateListener {


	@PostUpdate
	@PrePersist
	public void setLastUpdate( film flm ) throws IOException {
		Hashing hs = new Hashing();
		FileWriter writer = new FileWriter("test.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String rtStatement;
        WavesJ wj = new WavesJ();
        
        // Execute Query
        try {              

     	/* bufferedWriter input */
        bufferedWriter.write(flm.getId() + ' ');
        bufferedWriter.write(flm.getTitleId() + ' ');
        bufferedWriter.write(flm.getOrdering() + ' ');
        bufferedWriter.write(flm.getTitle() + ' ');
        bufferedWriter.write(flm.getRegion() + ' ');
        bufferedWriter.write(flm.getLanguage() + ' ');
        bufferedWriter.write(flm.getTypes() + ' ');
        bufferedWriter.write(flm.getAttributes() + ' ');
        bufferedWriter.write(String.valueOf(flm.getIsOriginalTitle()));
        bufferedWriter.close();
        
        rtStatement = hs.inputStreamDigest();
        if(rtStatement != "Fehler") {
     	   wj.transaction(rtStatement);   
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }

	}
}
