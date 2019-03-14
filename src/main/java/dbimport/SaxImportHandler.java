package dbimport;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import hibernate.HibernateUtils;

public class SaxImportHandler extends DefaultHandler{
	/* COMPONENT OBJ */
	headers 			header 			= new headers();
	organism 		organism 		= new organism();
	reference 		reference 		= new reference();
	refinfos	 		refinfo 		= new refinfos();
	proteinentries 	proteinEntry 	= new proteinentries();
	features 		feature 		= new features(proteinEntry.getId());
	summary 		summary 		= new summary();
	xrefs 			xrefObj 		= new xrefs();
	accinfos 		accInfoObj 		= new accinfos();
	
	/* COMPONENT OBJ LISTS */
	List<reference> 	references 			= new ArrayList<reference>();
	List<features> 		features 			= new ArrayList<features>();
	List<accessions> 	accessionsHeader 	= new ArrayList<accessions>();
	List<accessions> 	accessionsAccInfo 	= new ArrayList<accessions>();
	List<authors> 		authors 			= new ArrayList<authors>();
	List<xrefs> 			xrefs 				= new ArrayList<xrefs>();
	List<classifications> classifications 	= new ArrayList<classifications>();
	List<keywords> 		keywords 			= new ArrayList<keywords>();
	
	/* SESSION */
	public Session session;
	
	/* BOOLEAN VALUES / NODES */
	boolean headerB = false, uid = false,accession = false,createdDate = false,seqRevDate= false,
			txtRevDate= false,protein= false, proteinName = false, organismB= false, source= false,common= false, formal= false,
			referenceB= false, refinfoB= false,authorsB= false,author= false,citation= false,volume= false,
			year= false,pages= false,title= false,xrefsB= false,xref= false,db= false,accinfo= false,molType= false,
			seqSpec= false, genetics= false,introns = false, classification= false, superFamily = false,keywordsB= false,keyword=false, featureB= false,
			featureType= false,description= false,status= false,summaryB= false, lengthB= false, type= false,
			sequence= false;
	
	@Override
	public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException{
		if(qName.equalsIgnoreCase("proteinentry")) {
			session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
		}
		if(qName.equalsIgnoreCase("header"))		headerB 	= true ; 
		if(qName.equalsIgnoreCase("uid"))			uid 		= true ; 
		if(qName.equalsIgnoreCase("accession"))		accession 	= true ; 
		if(qName.equalsIgnoreCase("created_date"))	createdDate = true ; 
		if(qName.equalsIgnoreCase("seq-rev_date"))	seqRevDate 	= true ; 
		if(qName.equalsIgnoreCase("txt-rev_date"))	txtRevDate 	= true ; 
		if(qName.equalsIgnoreCase("protein"))		protein 	= true ; 
		if(qName.equalsIgnoreCase("name"))			proteinName = true ; 
		if(qName.equalsIgnoreCase("organism"))		organismB 	= true ; 
		if(qName.equalsIgnoreCase("source"))		source 		= true ; 
		if(qName.equalsIgnoreCase("common"))		common 		= true ; 
		if(qName.equalsIgnoreCase("formal"))		formal 		= true ; 
		if(qName.equalsIgnoreCase("reference"))		referenceB 	= true ; 
		if(qName.equalsIgnoreCase("refinfo"))		refinfoB 	= true ; 
		if(qName.equalsIgnoreCase("authors"))		authorsB 	= true ; 
		if(qName.equalsIgnoreCase("author"))		author 		= true ; 
		if(qName.equalsIgnoreCase("citation"))		citation 	= true ; 
		if(qName.equalsIgnoreCase("volume"))		volume 		= true ; 
		if(qName.equalsIgnoreCase("year"))			year 		= true ; 
		if(qName.equalsIgnoreCase("pages"))			pages 		= true ; 
		if(qName.equalsIgnoreCase("title"))			title 		= true ; 
		if(qName.equalsIgnoreCase("xrefs"))			xrefsB 		= true ; 
		if(qName.equalsIgnoreCase("xref"))			xref 		= true ; 
		if(qName.equalsIgnoreCase("db"))			db 			= true ; 
		if(qName.equalsIgnoreCase("accinfo"))		accinfo 	= true ; 
		if(qName.equalsIgnoreCase("mol-type"))		molType 	= true ; 
		if(qName.equalsIgnoreCase("seq-spec"))		seqSpec 	= true ; 
		if(qName.equalsIgnoreCase("genetics"))		genetics 	= true ; 
		if(qName.equalsIgnoreCase("introns"))		introns 	= true ; 
		if(qName.equalsIgnoreCase("classification"))classification = true ; 
		if(qName.equalsIgnoreCase("superfamily"))superFamily = true ; 
		if(qName.equalsIgnoreCase("keywords"))		keywordsB 	= true ; 
		if(qName.equalsIgnoreCase("keyword"))		keyword 	= true ; 
		if(qName.equalsIgnoreCase("feature"))		featureB	= true ; 
		if(qName.equalsIgnoreCase("feature-type"))	featureType	= true ; 
		if(qName.equalsIgnoreCase("description"))	description	= true ; 
		if(qName.equalsIgnoreCase("status"))		status 		= true ; 
		if(qName.equalsIgnoreCase("summary"))		summaryB 	= true ; 
		if(qName.equalsIgnoreCase("length"))		lengthB 	= true ; 
		if(qName.equalsIgnoreCase("type"))			type 		= true ; 
		if(qName.equalsIgnoreCase("sequence"))		sequence 	= true ; 
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("header")) {
			header.setAccessions(accessionsHeader);
			headerB = false;
		}
		if(qName.equalsIgnoreCase("protein")) {
			protein 	= false ; 
			proteinName = false;
		}
		if (qName.equalsIgnoreCase("organism")) {
			proteinEntry.setOrganism(organism);
			organismB = false;
		}
		if (qName.equalsIgnoreCase("refinfo")) {
			reference.setRefinfo(refinfo);
			refinfoB = false;
			refinfo = null;
		}
		if (qName.equalsIgnoreCase("accinfo")) {
			accInfoObj.setAccession(accessionsAccInfo);
			reference.setAccinfo(accInfoObj);
			accinfo = false;
			accInfoObj = null;
		}
		if (qName.equalsIgnoreCase("authors")) {
			refinfo.setAuthors(authors);
			authorsB = false;
		}
		
		if (qName.equalsIgnoreCase("reference")) {
			references.add(reference);
			referenceB = false;
		}
		if(qName.equalsIgnoreCase("xrefs") && refinfoB) {
			refinfo.setXrefs(xrefs);
			xrefsB = false;
		}
		if(qName.equalsIgnoreCase("xrefs") && accinfo) {
			accInfoObj.setXrefs(xrefs);
			xrefsB = false;
		}
		if (qName.equalsIgnoreCase("classification")) {
			proteinEntry.setClassification(classifications);
			classification = false;
		}
		if (qName.equalsIgnoreCase("keywords")) {
			proteinEntry.setKeywords(keywords);
			keywordsB = false;
		}
		if (qName.equalsIgnoreCase("feature")) {
			features.add(feature);
			featureB = false;
			feature = null;
		}
		if (qName.equalsIgnoreCase("summary")) {
			proteinEntry.setSummary(summary);
			summaryB = false;
		}
		if (qName.equalsIgnoreCase("proteinentry")) {
	        proteinEntry.setFeatures(features);
	        proteinEntry.setReferences(references);
	        
	    	session.save(proteinEntry);
			session.getTransaction().commit();
			session.close();
			
	    	xrefObj 		= new xrefs();
	    	accInfoObj 		= new accinfos();
	    	proteinEntry = new proteinentries();
	    	header = new headers();
	    	organism = new organism();
	    	reference = new reference();
	    	refinfo = new refinfos();
	    	feature = new features();
	    	summary = new summary();
	    	
	    	references.clear();
	    	features.clear();
	    	accessionsHeader.clear();
	    	authors.clear();
	    	xrefs.clear();
	    	classifications.clear();
	    	keywords.clear();
		}
	}
	
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		String charactersString = new String(ch, start, length);
		
		/******************* HEADER ******************/
		if(headerB && !uid && !accession && !createdDate && !seqRevDate && !txtRevDate) {
			// // system.out.println("headerB: " + charactersString);
		}
		
		/******************* HEADER - uid ******************/
		if(headerB && uid) {
			// system.out.println("uid: " + charactersString);
			header.setUid(charactersString);
			uid = false;
		}
		/******************* HEADER - accession ******************/
		if(headerB && accession) {
			// system.out.println("accession: " + charactersString );
			accessionsHeader.add(new accessions(charactersString));
			accession = false;
		}
		/******************* HEADER - createdDate ******************/
		if(headerB && createdDate) {
			// system.out.println("createdDate: " + charactersString );
			header.setCreatedDate(charactersString);
			createdDate = false;
		}
		/******************* HEADER - seqRevDate ******************/
		if(headerB && seqRevDate) {
			// system.out.println("seqRevDate: " + charactersString );
			header.setSeqRevDate(charactersString);
			seqRevDate = false;
		}
		/******************* HEADER - txtRevDate ******************/
		if(headerB && txtRevDate) {
			// system.out.println("txtRevDate: " + charactersString );
			header.setTxtRevDate(charactersString);
			txtRevDate = false;
		}
		
		/******************* PROTEIN ******************/
		if(protein) {
			// system.out.println("protein: " + charactersString);
			proteinEntry.setHeader(header);
			proteinEntry.setProtein(new proteins(charactersString,proteinEntry.getId()));
		}
		
		if(protein && proteinName) {
			proteinEntry.getProtein().setName(charactersString);
			proteinName = false;
			protein = false;
		}
		
		/******************* ORGANISM ******************/ 
		/******************* ORGANISM - source ******************/
		if(organismB && source) {
			// system.out.println("source: " + charactersString);
			organism.setSource(charactersString);
			source = false;
		}
		/******************* ORGANISM - common ******************/
		if(organismB && common) {
			// system.out.println("common: " + charactersString);
			organism.setCommon(charactersString);
			common = false;
		}
		/******************* ORGANISM - formal ******************/
		if(organismB && formal) {
			// system.out.println("formal: " + charactersString);
			organism.setFormal(charactersString);
			formal = false;
		}
		
		/******************* REFERENCE ******************/ 
		if(referenceB && !refinfoB && !accinfo) {
			reference.setId(proteinEntry.getId());
		}
		
		/******************* REFINFO ******************/ 
		if(referenceB && refinfoB) {
			if(refinfo==null) {
				refinfo = new refinfos(); 
				authors.clear();
			}
		}

		/******************* REFINFO - author ******************/
		if(referenceB && refinfoB && authorsB && author) {
			authors.add(new authors(charactersString));
			author = false;
		}
		/******************* REFINFO - citation ******************/
		if(referenceB && refinfoB && citation) {
			refinfo.setCitation(charactersString);
			citation = false;
		}
		/******************* REFINFO - volume ******************/
		if(referenceB && refinfoB && volume) {
			refinfo.setVolume(charactersString);
			volume = false;
		}
		/******************* REFINFO - year ******************/
		if(referenceB && refinfoB && year) {
			refinfo.setYear(charactersString);
			year = false;
		}
		/******************* REFINFO - pages ******************/
		if(referenceB && refinfoB && pages) {
			refinfo.setPages(charactersString);
			pages = false;
		}
		/******************* REFINFO - title ******************/
		if(referenceB && refinfoB && title) {
			refinfo.setTitle(charactersString);
			title = false;
		}
		/******************* REFINFO -  xrefs ******************/
		if(referenceB && refinfoB && xrefsB) {
			xrefs.clear();
			refinfo.setXrefs(xrefs);
			xrefsB = false;
		}
		/******************* REFINFO - xref ******************/
		if(referenceB && refinfoB  && xref && !db && !uid) {
			xrefObj = new xrefs();
			xrefObj.setFkRefinfoId(refinfo.getId());
		}
		/******************* REFINFO - xref - db ******************/
		if(referenceB && refinfoB  && xref && db) {
			xrefObj.setDb(charactersString);
			db = false;
		}
		/******************* REFINFO - xref - uid ******************/
		if(referenceB && refinfoB  && xref && uid) {
			xrefObj.setUid(charactersString);
			xrefs.add(xrefObj);
			uid = false;
			xref = false;
		}
		
		/******************* ACCINFO ******************/ 
		if(referenceB && accinfo ) {
			if(accInfoObj== null) {
				accInfoObj = new accinfos();
				accessionsAccInfo.clear();
			}
		}
		/******************* ACCINFO - accession ******************/ 
		if(referenceB && accinfo && accession) {
			accessionsAccInfo.add(new accessions(charactersString));
		}
		/******************* ACCINFO - molType ******************/ 
		if(referenceB && accinfo && molType) {
			accInfoObj.setMolType(charactersString);
			molType = false;
		}
		/******************* ACCINFO - seqSpec ******************/ 
		if(referenceB && accinfo && seqSpec) {
			accInfoObj.setSeqSpec(charactersString);
			seqSpec = false;
		}
		/******************* ACCINFO - xrefs ******************/ 
		if(referenceB && accinfo && xrefsB) {
			xrefs.clear();
			xrefsB = false;
		}
		/******************* ACCINFO - xref ******************/ 
		if(referenceB && accinfo  && xref && !db && !uid) {
			xrefObj = new xrefs();
			xrefObj.setFkRefinfoId(accInfoObj.getId());
		}
		/******************* ACCINFO - xref - db ******************/ 
		if(referenceB && accinfo  && xref && db) {
			xrefObj.setDb(charactersString);
			db = false;
		}
		/******************* ACCINFO - xref - uid ******************/ 
		if(referenceB && accinfo  && xref && uid) {
			xrefObj.setUid(charactersString);
			xrefs.add(xrefObj);
			uid = false;
			xref = false;
		}
		
		/******************* GENETICS ******************/
		if(genetics) {
			// system.out.println("genetics: " + charactersString);
			proteinEntry.setGenetics(new genetics("57/1 67/2"));
			genetics = false;
		}
		
		if(genetics && introns) {
			// system.out.println("introns: " + charactersString);
			proteinEntry.setGenetics(new genetics("57/1 67/2"));
			introns = false;
			genetics = false;
		}
		
		/******************* CLASSIFICATION ******************/
		if(classification && superFamily) {
			classifications.add(new classifications(charactersString));
			superFamily = false;
		}
		
		/******************* KEYWORDS ******************/
		if(keyword) {
			keywords.add(new keywords(proteinEntry.getId(),charactersString));
			keyword = false;
		}
		
		/******************* FEATURE ******************/ 
		if(featureB && !featureType && !description && !seqSpec && !status) {
			// system.out.println("featureB: " + charactersString);
			if(feature== null)feature = new features();
			feature.setId(proteinEntry.getId());
		}
		/******************* FEATURE - featureType ******************/ 
		if(featureB && featureType) {
			// system.out.println("featureType: " + charactersString);
			feature.setFeatureType(charactersString);
			featureType = false;
		}
		/******************* FEATURE - description ******************/ 
		if(featureB && description) {
			// system.out.println("description: " + charactersString);
			feature.setDescription(charactersString);
			description = false;
		}
		/******************* FEATURE - seqSpec ******************/ 
		if(featureB && seqSpec) {
			// system.out.println("seqSpec: " + charactersString);
			feature.setSeqSqc(charactersString);
			seqSpec = false;
		}
		/******************* FEATURE - status ******************/ 
		if(featureB && status) {
			// system.out.println("common: " + charactersString);
			feature.setStatus(charactersString);
			status = false;
		}
		
		/******************* SUMMARY ******************/ 
		/******************* SUMMARY - lengthB ******************/ 
		if(summaryB && lengthB) {
			// system.out.println("lengthB: " + charactersString);
			summary.setLength(charactersString);
			lengthB = false;
		}
		/******************* SUMMARY - type ******************/ 
		if(summaryB && type) {
			// system.out.println("type: " + charactersString);
			summary.setType(charactersString);
			type = false;
		}
		/******************* SUMMARY - status ******************/ 
		if(summaryB && status) {
			// system.out.println("status: " + charactersString);
			summary.setStatus(charactersString);
			status = false;
		}
		
		/******************* SEQUENCE ******************/ 
		if(sequence) {
			// system.out.println("sequence: " + charactersString);
			proteinEntry.setSequence(charactersString);
			sequence = false;
		}
		
		/* TESTS */
	//	 Runtime rt2 = Runtime.getRuntime();
	//		// system.out.println(rt2.totalMemory() - rt2.freeMemory());
			
	}
}
