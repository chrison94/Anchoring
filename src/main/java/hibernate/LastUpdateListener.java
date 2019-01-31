/*
 *  OUT OF DATE
 * package hibernate;
 

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

import dbimport.Accession;
import dbimport.Protein;
import functions.Hashing;
import functions.WavesDataTransactions;

public class LastUpdateListener {
	@PostUpdate
	@PostPersist
	public  void LastUpdate( Protein prt ) throws IOException {
		Hashing hs = new Hashing();
		FileWriter writer = new FileWriter("test.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String rtStatement;
        WavesDataTransactions wdt = new WavesDataTransactions();
        // Execute Query
        try {              

     	/* bufferedWriter input 
        bufferedWriter.write(prt.getId() + ' ');
        bufferedWriter.write(prt.getName() + ' ');
        bufferedWriter.close();
        rtStatement = hs.inputStreamDigest();
        if(rtStatement != "Fehler") {
        	wdt.doWork(rtStatement);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }

	}
} */
