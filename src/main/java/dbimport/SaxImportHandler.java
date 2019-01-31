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
	Header 			header 			= new Header();
	Organism 		organism 		= new Organism();
	Reference 		reference 		= new Reference();
	RefInfo	 		refinfo 		= new RefInfo();
	ProteinEntry 	proteinEntry 	= new ProteinEntry();
	Feature 		feature 		= new Feature(proteinEntry.getId());
	Summary 		summary 		= new Summary();
	Xref 			xrefObj 		= new Xref();
	AccInfo 		accInfoObj 		= new AccInfo();
	
	/* COMPONENT OBJ LISTS */
	List<Reference> 	references 			= new ArrayList<Reference>();
	List<Feature> 		features 			= new ArrayList<Feature>();
	List<Accession> 	accessionsHeader 	= new ArrayList<Accession>();
	List<Accession> 	accessionsAccInfo 	= new ArrayList<Accession>();
	List<Author> 		authors 			= new ArrayList<Author>();
	List<Xref> 			xrefs 				= new ArrayList<Xref>();
	List<Classification> classifications 	= new ArrayList<Classification>();
	List<Keyword> 		keywords 			= new ArrayList<Keyword>();
	
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
			
	    	xrefObj 		= new Xref();
	    	accInfoObj 		= new AccInfo();
	    	proteinEntry = new ProteinEntry();
	    	header = new Header();
	    	organism = new Organism();
	    	reference = new Reference();
	    	refinfo = new RefInfo();
	    	feature = new Feature();
	    	summary = new Summary();
	    	
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
			System.out.println("headerB: " + charactersString);
		}
		
		/******************* HEADER - uid ******************/
		if(headerB && uid) {
			System.out.println("uid: " + charactersString);
			header.setUid(charactersString);
			uid = false;
		}
		/******************* HEADER - accession ******************/
		if(headerB && accession) {
			System.out.println("accession: " + charactersString );
			accessionsHeader.add(new Accession(charactersString));
			accession = false;
		}
		/******************* HEADER - createdDate ******************/
		if(headerB && createdDate) {
			System.out.println("createdDate: " + charactersString );
			header.setCreatedDate(charactersString);
			createdDate = false;
		}
		/******************* HEADER - seqRevDate ******************/
		if(headerB && seqRevDate) {
			System.out.println("seqRevDate: " + charactersString );
			header.setSeqRevDate(charactersString);
			seqRevDate = false;
		}
		/******************* HEADER - txtRevDate ******************/
		if(headerB && txtRevDate) {
			System.out.println("txtRevDate: " + charactersString );
			header.setTxtRevDate(charactersString);
			txtRevDate = false;
		}
		
		/******************* PROTEIN ******************/
		if(protein) {
			System.out.println("protein: " + charactersString);
			proteinEntry.setHeader(header);
			proteinEntry.setProtein(new Protein(charactersString,proteinEntry.getId()));
		}
		
		if(protein && proteinName) {
			proteinEntry.getProtein().setName(charactersString);
			proteinName = false;
			protein = false;
		}
		
		/******************* ORGANISM ******************/ 
		/******************* ORGANISM - source ******************/
		if(organismB && source) {
			System.out.println("source: " + charactersString);
			organism.setSource(charactersString);
			source = false;
		}
		/******************* ORGANISM - common ******************/
		if(organismB && common) {
			System.out.println("common: " + charactersString);
			organism.setCommon(charactersString);
			common = false;
		}
		/******************* ORGANISM - formal ******************/
		if(organismB && formal) {
			System.out.println("formal: " + charactersString);
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
				refinfo = new RefInfo(); 
				authors.clear();
			}
		}

		/******************* REFINFO - author ******************/
		if(referenceB && refinfoB && authorsB && author) {
			authors.add(new Author(charactersString));
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
			xrefObj = new Xref();
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
				accInfoObj = new AccInfo();
				accessionsAccInfo.clear();
			}
		}
		/******************* ACCINFO - accession ******************/ 
		if(referenceB && accinfo && accession) {
			accessionsAccInfo.add(new Accession(charactersString));
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
			xrefObj = new Xref();
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
			System.out.println("genetics: " + charactersString);
			proteinEntry.setGenetics(new Genetics("57/1 67/2"));
			genetics = false;
		}
		
		if(genetics && introns) {
			System.out.println("introns: " + charactersString);
			proteinEntry.setGenetics(new Genetics("57/1 67/2"));
			introns = false;
			genetics = false;
		}
		
		/******************* CLASSIFICATION ******************/
		if(classification && superFamily) {
			classifications.add(new Classification(charactersString));
			superFamily = false;
		}
		
		/******************* KEYWORDS ******************/
		if(keyword) {
			keywords.add(new Keyword(proteinEntry.getId(),charactersString));
			keyword = false;
		}
		
		/******************* FEATURE ******************/ 
		if(featureB && !featureType && !description && !seqSpec && !status) {
			System.out.println("featureB: " + charactersString);
			if(feature== null)feature = new Feature();
			feature.setId(proteinEntry.getId());
		}
		/******************* FEATURE - featureType ******************/ 
		if(featureB && featureType) {
			System.out.println("featureType: " + charactersString);
			feature.setFeatureType(charactersString);
			featureType = false;
		}
		/******************* FEATURE - description ******************/ 
		if(featureB && description) {
			System.out.println("description: " + charactersString);
			feature.setDescription(charactersString);
			description = false;
		}
		/******************* FEATURE - seqSpec ******************/ 
		if(featureB && seqSpec) {
			System.out.println("seqSpec: " + charactersString);
			feature.setSeqSqc(charactersString);
			seqSpec = false;
		}
		/******************* FEATURE - status ******************/ 
		if(featureB && status) {
			System.out.println("common: " + charactersString);
			feature.setStatus(charactersString);
			status = false;
		}
		
		/******************* SUMMARY ******************/ 
		/******************* SUMMARY - lengthB ******************/ 
		if(summaryB && lengthB) {
			System.out.println("lengthB: " + charactersString);
			summary.setLength(charactersString);
			lengthB = false;
		}
		/******************* SUMMARY - type ******************/ 
		if(summaryB && type) {
			System.out.println("type: " + charactersString);
			summary.setType(charactersString);
			type = false;
		}
		/******************* SUMMARY - status ******************/ 
		if(summaryB && status) {
			System.out.println("status: " + charactersString);
			summary.setStatus(charactersString);
			status = false;
		}
		
		/******************* SEQUENCE ******************/ 
		if(sequence) {
			System.out.println("sequence: " + charactersString);
			proteinEntry.setSequence(charactersString);
			sequence = false;
		}
		
		/* TESTS */
	//	 Runtime rt2 = Runtime.getRuntime();
	//		System.out.println(rt2.totalMemory() - rt2.freeMemory());
			
	}
}
