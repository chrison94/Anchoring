import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import dbimport.AccInfo;
import dbimport.Accession;
import dbimport.Author;
import dbimport.Classification;
import dbimport.Feature;
import dbimport.Genetics;
import dbimport.Header;
import dbimport.Keyword;
import dbimport.Organism;
import dbimport.Protein;
import dbimport.ProteinDatabase;
import dbimport.ProteinEntry;
import dbimport.RefInfo;
import dbimport.Reference;
import dbimport.Summary;
import dbimport.Xref;
import hibernate.HibernateUtils;

class Main{
	public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException {
		System.out.println("test");
		/* import database */
		File xmlFile = new File("t.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlFile);
		doc.getDocumentElement();
		xmlToMysqlDbB(doc);
		
	}
	
	private static void xmlToMysqlDbB(Document doc) {
		/** Prepare db connection*/
		SessionFactory sFactory = HibernateUtils.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		session.getTransaction().begin();
		
		/*get all nodes with names like ProteinEntry and Database */
		NodeList proteinNodeList 		=  doc.getElementsByTagName("ProteinEntry");
		NodeList proteinDatabaseList 	=  doc.getElementsByTagName("Database");
		
		/*ProrteinDatabase init*/
		ProteinDatabase proteinDatabase = new ProteinDatabase();
		
		proteinDatabase.setDatabase(proteinDatabaseList.item(0).getTextContent());

		/*init all ProteinEntries*/
		/****************** ProteinEntry *******************/
	    for(int b=0; b<proteinNodeList.getLength(); b++)
	    {
	    	ProteinEntry proteinEntry = new ProteinEntry();
	    	List<Reference> references = new ArrayList<Reference>();
	    	List<Feature> features = new ArrayList<Feature>();
	    	for(int i=0; i<proteinNodeList.item(b).getChildNodes().getLength(); i++) {
	    		
	    	Node proteinNode = proteinNodeList.item(b).getChildNodes().item(i);
	    	
	        if(proteinNode.getNodeType() == Node.ELEMENT_NODE)
	        {
	        	System.out.println(proteinNode.getNodeName());
	        	/****************** Init header *******************/
	        	if(proteinNode.getNodeName() == "header") {
	        		System.out.println("in header");
	        		Header header = new Header();
	        		List<Accession> accessionsHeader = new ArrayList<Accession>();
	        		for(int a=0; a<proteinNode.getChildNodes().getLength(); a++) {
	        			/****************** uid *******************/
	        			if(proteinNode.getChildNodes().item(a).getNodeName() == "uid") {
	        				header.setUid(proteinNode.getChildNodes().item(a).getTextContent());
	        			}
	        			/****************** accession *******************/
	        			if(proteinNode.getChildNodes().item(a).getNodeName() == "accession") {
	        				accessionsHeader.add(new Accession(proteinNode.getChildNodes().item(a).getTextContent()));
	        			}
	        			/****************** CreatedDate *******************/
	        			if(proteinNode.getChildNodes().item(a).getNodeName() == "created_date") {
	        				header.setCreatedDate(proteinNode.getChildNodes().item(a).getTextContent());
	        			}
	        			/****************** SeqRevDate *******************/
	        			if(proteinNode.getChildNodes().item(a).getNodeName() == "seq-rev_date") {
	        				header.setSeqRevDate(proteinNode.getChildNodes().item(a).getTextContent());
	        			}
	        			/****************** TxtRevDate *******************/
	        			if(proteinNode.getChildNodes().item(a).getNodeName() == "txt-rev_date") {
	        				header.setTxtRevDate(proteinNode.getChildNodes().item(a).getTextContent());
	        			}
	        		}
	        		header.setAccessions(accessionsHeader);
	        		proteinEntry.setHeader(header);
	        	}
	        	/****************** Protein *******************/
	        	if(proteinNode.getNodeName() == "protein") {
	        		System.out.println("in protein");
	        		proteinEntry.setProtein(new Protein(proteinNode.getTextContent(),proteinEntry.getId()));
	        	}
	        	/****************** Organism *******************/
	        	if(proteinNode.getNodeName() == "organism") {
	        		System.out.println("in organism");
	        		Organism organism = new Organism();
	        		for(int a=0; a<proteinNode.getChildNodes().getLength(); a++) {
	        			/****************** Source *******************/
	        			if(proteinNode.getChildNodes().item(a).getNodeName() == "source") {
	        				organism.setSource(proteinNode.getChildNodes().item(a).getTextContent());
	        			}
	        			/****************** Common *******************/
	        			if(proteinNode.getChildNodes().item(a).getNodeName() == "common") {
	        				organism.setCommon(proteinNode.getChildNodes().item(a).getTextContent());
	        			}
	        			/****************** Formal *******************/
	        			if(proteinNode.getChildNodes().item(a).getNodeName() == "formal") {
	        				organism.setFormal(proteinNode.getChildNodes().item(a).getTextContent());
	        			}
	        		}
	        		proteinEntry.setOrganism(organism);
	        	}
	        	/****************** Reference *******************/
	        	if(proteinNode.getNodeName() == "reference") {
	        		System.out.println("in reference");
	        		Reference reference = new Reference(proteinEntry.getId());
	        		for(int a=0; a<proteinNode.getChildNodes().getLength(); a++) {
	        			Node referenceChild = proteinNode.getChildNodes().item(a);
	        			
	        			/****************** Refinfo *******************/
	        			if(referenceChild.getNodeName() == "refinfo") {
	        				RefInfo refinfo = new RefInfo();
	        				
	        				for(int r=0; r<referenceChild.getChildNodes().getLength(); r++) {
	        					Node refinfoNodeChild = referenceChild.getChildNodes().item(r);
	        					/****************** Authors *******************/
	        					if(refinfoNodeChild.getNodeName()== "authors") {
	        						List<Author> authors = new ArrayList<Author>();
	        						for(int au=0;au<refinfoNodeChild.getChildNodes().getLength(); au++) {
	        							Node refinfoNodeChildAuthor = refinfoNodeChild.getChildNodes().item(au);
	        							/****************** Author *******************/
	        							if(refinfoNodeChildAuthor.getNodeName() == "author") {
	        								authors.add(new Author(refinfoNodeChildAuthor.getTextContent()));
	        							}
	        						}
	        						refinfo.setAuthors(authors);
	        					}
	        					/****************** Citation *******************/
	        					if(refinfoNodeChild.getNodeName()== "citation") {
	        						refinfo.setCitation(refinfoNodeChild.getTextContent());
	        					}
	        					/****************** Volume *******************/
	        					if(refinfoNodeChild.getNodeName()== "volume") {
	        						refinfo.setVolume(refinfoNodeChild.getTextContent());
	        					}
	        					/****************** Year *******************/
	        					if(refinfoNodeChild.getNodeName()== "year") {
	        						refinfo.setYear(refinfoNodeChild.getTextContent());
	        					}
	        					/****************** Pages *******************/
	        					if(refinfoNodeChild.getNodeName()== "pages") {
	        						refinfo.setPages(refinfoNodeChild.getTextContent());
	        					}
	        					/****************** Title *******************/
	        					if(refinfoNodeChild.getNodeName()== "title") {
	        						refinfo.setTitle(refinfoNodeChild.getTextContent());
	        					}
	        					/****************** Xrefs *******************/
	        					if(refinfoNodeChild.getNodeName()== "xrefs") {
	        						List<Xref> xrefs = new ArrayList<Xref>();
	        						for(int au=0;au<refinfoNodeChild.getChildNodes().getLength(); au++) {
	        							Node xref = refinfoNodeChild.getChildNodes().item(au);
	        							/****************** Xref *******************/
	        							if(xref.getNodeName() == "xref") {
	        								String db = "",uid ="";
	        								for(int x=0;x<xref.getChildNodes().getLength(); x++) {
	        									/****************** db *******************/
	        									db = (xref.getChildNodes().item(x).getNodeName()== "db")? xref.getChildNodes().item(x).getTextContent() :"" ;
	        									/****************** uid *******************/
	        									uid = (xref.getChildNodes().item(x).getNodeName()== "uid")? xref.getChildNodes().item(x).getTextContent() :"" ;
	        								}
	        								xrefs.add(new Xref(db,uid, refinfo.getId(),0));
	        							}
	        						}
	        						refinfo.setXrefs(xrefs);
	        					}
	        				}
	        				reference.setRefinfo(refinfo);
	        			}
	        			
	        			/****************** Accinfo *******************/
	        			if(referenceChild.getNodeName() == "accinfo") {
	        				
	        				AccInfo accinfo = new AccInfo();
	        				
	        				for(int c=0; c<referenceChild.getChildNodes().getLength(); c++) {
	        					
	        					Node accinfoChild = referenceChild.getChildNodes().item(c);
	        					System.out.println("");
	        					/****************** Accession *******************/
	        					if(accinfoChild.getNodeName() == "accession") {
	        						accinfo.setAccession(new Accession(accinfoChild.getTextContent()));
	        					}
	        					/****************** mol-type *******************/
	        					if(accinfoChild.getNodeName()== "mol-type") {
	        						accinfo.setMolType(accinfoChild.getTextContent());
	        					}
	        					/****************** seq-spec *******************/
	        					if(accinfoChild.getNodeName()== "seq-spec") {
	        						accinfo.setSeqSpec(accinfoChild.getTextContent());
	        					}
	        					/****************** Xrefs *******************/
	        					if(accinfoChild.getNodeName()== "xrefs") {
	        						List<Xref> xrefs = new ArrayList<Xref>();
	        						for(int au=0;au<accinfoChild.getChildNodes().getLength(); au++) {
	        							Node xref = accinfoChild.getChildNodes().item(au);
	        							/****************** Xref *******************/
	        							if(xref.getNodeName() == "xref") {
	        								String db = "",uid ="";
	        								for(int x=0;x<xref.getChildNodes().getLength(); x++) {
	        									/****************** db *******************/
	        									db = (xref.getChildNodes().item(x).getNodeName()== "db")? xref.getChildNodes().item(x).getTextContent() :"" ;
	        									/****************** uid *******************/
	        									uid = (xref.getChildNodes().item(x).getNodeName()== "uid")? xref.getChildNodes().item(x).getTextContent() :"" ;
	        								}
	        								xrefs.add(new Xref(db,uid,0,accinfo.getId()));
	        							}
	        						}
	        						accinfo.setXrefs(xrefs);
	        					}
	        				}
	        				reference.setAccinfo(accinfo);
	        			}
	        		}
	        		references.add(reference);
	        	}
    			/****************** Genetics *******************/
    			if(proteinNode.getNodeName() == "genetics") {
    				proteinEntry.setGenetics(new Genetics(proteinNode.getChildNodes().item(0).getTextContent()));
    			}
	        	
    			/****************** Classification *******************/
    			if(proteinNode.getNodeName() == "classification") {
    				List<Classification> classifications = new ArrayList<Classification>();
    				for(int c=0; c<proteinNode.getChildNodes().getLength(); c++) {
    					classifications.add(new Classification(proteinNode.getChildNodes().item(c).getTextContent()));
    				}
    				proteinEntry.setClassification(classifications);
    			}
    			/****************** Keywords *******************/
    			if(proteinNode.getNodeName() == "keywords") {
    				List<Keyword> keywords = new ArrayList<Keyword>();
    				for(int c=0; c<proteinNode.getChildNodes().getLength(); c++) {
    					keywords.add(new Keyword(proteinEntry.getId(),proteinNode.getChildNodes().item(c).getTextContent()));
    				}
    				proteinEntry.setKeywords(keywords);
    			}
    			/****************** Feature *******************/
    			if(proteinNode.getNodeName() == "feature") {
    				Feature feature = new Feature(proteinEntry.getId());
    				for(int c=0; c<proteinNode.getChildNodes().getLength(); c++) {
    					/****************** feature-type *******************/
    					if(proteinNode.getChildNodes().item(c).getNodeName() == "feature-type") {
    						feature.setFeatureType(proteinNode.getChildNodes().item(c).getTextContent());
    					}
    					/****************** description *******************/
    					if(proteinNode.getChildNodes().item(c).getNodeName() == "description") {
    						feature.setDescription(proteinNode.getChildNodes().item(c).getTextContent());
    					}
    					/****************** seq-spec *******************/
    					if(proteinNode.getChildNodes().item(c).getNodeName() == "seq-spec") {
    						feature.setSeqSqc(proteinNode.getChildNodes().item(c).getTextContent());
    					}
    					/****************** status *******************/
    					if(proteinNode.getChildNodes().item(c).getNodeName() == "status") {
    						feature.setStatus(proteinNode.getChildNodes().item(c).getTextContent());
    					}
    				}
    				features.add(feature);
    			}
    			
    			/****************** Summary *******************/
    			if(proteinNode.getNodeName() == "summary") {
    				System.out.println("summary found : " + proteinNode.getTextContent());
    				Summary summary = new Summary();
    				for(int c=0; c<proteinNode.getChildNodes().getLength(); c++) {
    					/****************** feature-type *******************/
    					if(proteinNode.getChildNodes().item(c).getNodeName() == "length") {
    						summary.setLength(proteinNode.getChildNodes().item(c).getTextContent());
    					}
    					/****************** description *******************/
    					if(proteinNode.getChildNodes().item(c).getNodeName() == "type") {
    						summary.setType(proteinNode.getChildNodes().item(c).getTextContent());
    					}
    					/****************** seq-spec *******************/
    					if(proteinNode.getChildNodes().item(c).getNodeName() == "status") {
    						summary.setStatus(proteinNode.getChildNodes().item(c).getTextContent());
    					}
    				}
    				proteinEntry.setSummary(summary);
    			}
    			
    			/****************** Sequence *******************/
    			if(proteinNode.getNodeName() == "sequence") {
    				System.out.println("sequence: " + proteinNode.getTextContent());
    				proteinEntry.setSequence(proteinNode.getTextContent());
    			}
    			
	        }
	    	}
	        proteinEntry.setFeatures(features);
	        proteinEntry.setReferences(references);
	        session.save(proteinEntry);
	        
	    }
	    
	    session.getTransaction().commit();
	    sFactory.close();
	   // proteinDatabase.setProteinEntries(proteinEntries);
	    
	}

	
}