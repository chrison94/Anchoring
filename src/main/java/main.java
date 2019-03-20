import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.hibernate.Session;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import config.Configuration;
import dbimport.accinfos;
import dbimport.accessions;
import dbimport.authors;
import dbimport.classifications;
import dbimport.features;
import dbimport.genetics;
import dbimport.headers;
import dbimport.keywords;
import dbimport.organism;
import dbimport.proteins;
import dbimport.proteinentries;
import dbimport.refinfos;
import dbimport.reference;
import dbimport.SaxImportHandler;
import dbimport.summary;
import dbimport.xrefs;
import dbimport.triggeranchor;
import hibernate.HibernateUtils;

public class main {
	static Configuration conf = new Configuration();
	static boolean useDom = conf.getUseDom();

	public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException {
		// double startTime = System.nanoTime();
		/* DOM */
		if (useDom) {
			System.out.println("import xml with DOM");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("psd7003.xml"));
			doc.getDocumentElement();
			xmlToMysqlDbB(doc);
		} else {
			/* SAX */
			System.out.println("import xml with SAX");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			SaxImportHandler handler = new SaxImportHandler();
			saxParser.parse("psd7003.xml", handler);
			handler.session.close();
		}

		/* SEND END OBJECT */
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(new triggeranchor("" + new Timestamp(System.currentTimeMillis()).getTime()));
		session.getTransaction().commit();
		triggeranchor t2 = session.find(triggeranchor.class,1);
	       if(t2 != null) {
	           t2.setTimestamp("12345");
	           session.update(t2);
	       }

		// final double duration = System.nanoTime() - startTime;
		// System.out.println("dura: "+ duration/1000000000);
		System.out.println("Import und Anchoring abgeschlossen");
	}

	private static void xmlToMysqlDbB(Document doc) {

		/* get all nodes with names like ProteinEntry and Database */
		NodeList proteinNodeList = doc.getElementsByTagName("ProteinEntry");

		/* init all ProteinEntries */
		Node proteinNode;
		headers header = new headers();
		organism organism = new organism();
		reference reference = new reference();
		refinfos refinfo = new refinfos();
		proteinentries proteinEntry = new proteinentries();
		features feature = new features(proteinEntry.getId());
		summary summary = new summary();

		List<reference> references = new ArrayList<reference>();
		List<features> features = new ArrayList<features>();
		List<accessions> accessionsHeader = new ArrayList<accessions>();
		List<authors> authors = new ArrayList<authors>();
		List<xrefs> xrefs = new ArrayList<xrefs>();
		List<classifications> classifications = new ArrayList<classifications>();
		List<keywords> keywords = new ArrayList<keywords>();

		/****************** ProteinEntry *******************/
		for (int b = 0; b < proteinNodeList.getLength(); b++) {
//			Runtime rt = Runtime.getRuntime();
//			// System.out.println(b + " RAMMMMMMMM" + (rt.totalMemory() - rt.freeMemory()));

			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();

			for (int i = 0; i < proteinNodeList.item(b).getChildNodes().getLength(); i++) {

				proteinNode = proteinNodeList.item(b).getChildNodes().item(i);

				if (proteinNode.getNodeType() == Node.ELEMENT_NODE) {
					// System.out.println(proteinNode.getNodeName());
					/****************** Init header *******************/
					if (proteinNode.getNodeName() == "header") {
						header = new headers();
						// // System.out.println("in header");
						for (int a = 0; a < proteinNode.getChildNodes().getLength(); a++) {
							/****************** uid *******************/
							if (proteinNode.getChildNodes().item(a).getNodeName() == "uid") {
								header.setUid(proteinNode.getChildNodes().item(a).getTextContent());
							}
							/****************** accession *******************/
							if (proteinNode.getChildNodes().item(a).getNodeName() == "accession") {
								accessionsHeader
										.add(new accessions(proteinNode.getChildNodes().item(a).getTextContent()));
							}
							/****************** CreatedDate *******************/
							if (proteinNode.getChildNodes().item(a).getNodeName() == "created_date") {
								header.setCreatedDate(proteinNode.getChildNodes().item(a).getTextContent());
							}
							/****************** SeqRevDate *******************/
							if (proteinNode.getChildNodes().item(a).getNodeName() == "seq-rev_date") {
								header.setSeqRevDate(proteinNode.getChildNodes().item(a).getTextContent());
							}
							/****************** TxtRevDate *******************/
							if (proteinNode.getChildNodes().item(a).getNodeName() == "txt-rev_date") {
								header.setTxtRevDate(proteinNode.getChildNodes().item(a).getTextContent());
							}
						}
						header.setAccessions(accessionsHeader);
						proteinEntry.setHeader(header);
					}
					/****************** Protein *******************/
					if (proteinNode.getNodeName() == "protein") {
						// // System.out.println("in protein");
						proteinEntry.setProtein(new proteins(proteinNode.getTextContent(), proteinEntry.getId()));
					}
					/****************** Organism *******************/
					if (proteinNode.getNodeName() == "organism") {
						// // System.out.println("in organism");
						organism = new organism();
						for (int a = 0; a < proteinNode.getChildNodes().getLength(); a++) {
							/****************** Source *******************/
							if (proteinNode.getChildNodes().item(a).getNodeName() == "source") {
								organism.setSource(proteinNode.getChildNodes().item(a).getTextContent());
							}
							/****************** Common *******************/
							if (proteinNode.getChildNodes().item(a).getNodeName() == "common") {
								organism.setCommon(proteinNode.getChildNodes().item(a).getTextContent());
							}
							/****************** Formal *******************/
							if (proteinNode.getChildNodes().item(a).getNodeName() == "formal") {
								organism.setFormal(proteinNode.getChildNodes().item(a).getTextContent());
							}
						}
						proteinEntry.setOrganism(organism);
					}
					/****************** Reference *******************/
					if (proteinNode.getNodeName() == "reference") {
						references.clear();
						// // System.out.println("in reference");
						reference = new reference();
						reference.setId(proteinEntry.getId());
						for (int a = 0; a < proteinNode.getChildNodes().getLength(); a++) {
							Node referenceChild = proteinNode.getChildNodes().item(a);

							/****************** Refinfo *******************/
							if (referenceChild.getNodeName() == "refinfo") {
								for (int r = 0; r < referenceChild.getChildNodes().getLength(); r++) {
									Node refinfoNodeChild = referenceChild.getChildNodes().item(r);
									/****************** Authors *******************/
									if (refinfoNodeChild.getNodeName() == "authors") {

										for (int au = 0; au < refinfoNodeChild.getChildNodes().getLength(); au++) {
											Node refinfoNodeChildAuthor = refinfoNodeChild.getChildNodes().item(au);
											/****************** Author *******************/
											if (refinfoNodeChildAuthor.getNodeName() == "author") {
												authors.add(new authors(refinfoNodeChildAuthor.getTextContent()));
											}
										}
										refinfo.setAuthors(authors);
									}
									/****************** Citation *******************/
									if (refinfoNodeChild.getNodeName() == "citation") {
										refinfo.setCitation(refinfoNodeChild.getTextContent());
									}
									/****************** Volume *******************/
									if (refinfoNodeChild.getNodeName() == "volume") {
										refinfo.setVolume(refinfoNodeChild.getTextContent());
									}
									/****************** Year *******************/
									if (refinfoNodeChild.getNodeName() == "year") {
										refinfo.setYear(refinfoNodeChild.getTextContent());
									}
									/****************** Pages *******************/
									if (refinfoNodeChild.getNodeName() == "pages") {
										refinfo.setPages(refinfoNodeChild.getTextContent());
									}
									/****************** Title *******************/
									if (refinfoNodeChild.getNodeName() == "title") {
										refinfo.setTitle(refinfoNodeChild.getTextContent());
									}
									/****************** Xrefs *******************/
									if (refinfoNodeChild.getNodeName() == "xrefs") {
										xrefs.clear();
										for (int au = 0; au < refinfoNodeChild.getChildNodes().getLength(); au++) {
											Node xref = refinfoNodeChild.getChildNodes().item(au);
											/****************** Xref *******************/
											if (xref.getNodeName() == "xref") {
												String db = "", uid = "";
												for (int x = 0; x < xref.getChildNodes().getLength(); x++) {
													/****************** db *******************/
													db = (xref.getChildNodes().item(x).getNodeName() == "db")
															? xref.getChildNodes().item(x).getTextContent()
															: "";
													/****************** uid *******************/
													uid = (xref.getChildNodes().item(x).getNodeName() == "uid")
															? xref.getChildNodes().item(x).getTextContent()
															: "";
												}
												xrefs.add(new xrefs(db, uid, refinfo.getId(), 0));
											}
										}
										refinfo.setXrefs(xrefs);
									}
								}
								reference.setRefinfo(refinfo);
							}

							/****************** Accinfo *******************/
							if (referenceChild.getNodeName() == "accinfo") {

								accinfos accinfo = new accinfos();
								Collection<accessions> accessions = new ArrayList<accessions>();
								for (int c = 0; c < referenceChild.getChildNodes().getLength(); c++) {
									Node accinfoChild = referenceChild.getChildNodes().item(c);
									// System.out.println("");
									/****************** Accession *******************/
									if (accinfoChild.getNodeName() == "accession") {
										accessions.add(new accessions(accinfoChild.getTextContent()));
									}
									/****************** mol-type *******************/
									if (accinfoChild.getNodeName() == "mol-type") {
										accinfo.setMolType(accinfoChild.getTextContent());
									}
									/****************** seq-spec *******************/
									if (accinfoChild.getNodeName() == "seq-spec") {
										accinfo.setSeqSpec(accinfoChild.getTextContent());
									}
									/****************** Xrefs *******************/
									if (accinfoChild.getNodeName() == "xrefs") {
										xrefs.clear();
										for (int au = 0; au < accinfoChild.getChildNodes().getLength(); au++) {
											Node xref = accinfoChild.getChildNodes().item(au);
											/****************** Xref *******************/
											if (xref.getNodeName() == "xref") {
												String db = "", uid = "";
												for (int x = 0; x < xref.getChildNodes().getLength(); x++) {
													/****************** db *******************/
													db = (xref.getChildNodes().item(x).getNodeName() == "db")
															? xref.getChildNodes().item(x).getTextContent()
															: "";
													/****************** uid *******************/
													uid = (xref.getChildNodes().item(x).getNodeName() == "uid")
															? xref.getChildNodes().item(x).getTextContent()
															: "";
												}
												xrefs.add(new xrefs(db, uid, 0, accinfo.getId()));
											}
										}

										accinfo.setXrefs(xrefs);
									}
									accinfo.setAccession(accessions);
								}

								reference.setAccinfo(accinfo);
							}
						}
						references.add(reference);
					}
					/****************** Genetics *******************/
					if (proteinNode.getNodeName() == "genetics") {
						proteinEntry.setGenetics(new genetics("57/1 67/2"));
					}

					/****************** Classification *******************/
					if (proteinNode.getNodeName() == "classification") {

						for (int c = 0; c < proteinNode.getChildNodes().getLength(); c++) {
							classifications
									.add(new classifications(proteinNode.getChildNodes().item(c).getTextContent()));
						}
						proteinEntry.setClassification(classifications);
					}
					/****************** Keywords *******************/
					if (proteinNode.getNodeName() == "keywords") {

						for (int c = 0; c < proteinNode.getChildNodes().getLength(); c++) {
							keywords.add(new keywords(proteinEntry.getId(),
									proteinNode.getChildNodes().item(c).getTextContent()));
						}
						proteinEntry.setKeywords(keywords);
					}
					/****************** Feature *******************/
					if (proteinNode.getNodeName() == "feature") {
						feature.setId(proteinEntry.getId());
						for (int c = 0; c < proteinNode.getChildNodes().getLength(); c++) {
							/****************** feature-type *******************/
							if (proteinNode.getChildNodes().item(c).getNodeName() == "feature-type") {
								feature.setFeatureType(proteinNode.getChildNodes().item(c).getTextContent());
							}
							/****************** description *******************/
							if (proteinNode.getChildNodes().item(c).getNodeName() == "description") {
								feature.setDescription(proteinNode.getChildNodes().item(c).getTextContent());
							}
							/****************** seq-spec *******************/
							if (proteinNode.getChildNodes().item(c).getNodeName() == "seq-spec") {
								feature.setSeqSqc(proteinNode.getChildNodes().item(c).getTextContent());
							}
							/****************** status *******************/
							if (proteinNode.getChildNodes().item(c).getNodeName() == "status") {
								feature.setStatus(proteinNode.getChildNodes().item(c).getTextContent());
							}
						}
						features.add(feature);
					}

					/****************** Summary *******************/
					if (proteinNode.getNodeName() == "summary") {
						// // System.out.println("summary found : " + proteinNode.getTextContent());

						for (int c = 0; c < proteinNode.getChildNodes().getLength(); c++) {
							/****************** feature-type *******************/
							if (proteinNode.getChildNodes().item(c).getNodeName() == "length") {
								summary.setLength(proteinNode.getChildNodes().item(c).getTextContent());
							}
							/****************** description *******************/
							if (proteinNode.getChildNodes().item(c).getNodeName() == "type") {
								summary.setType(proteinNode.getChildNodes().item(c).getTextContent());
							}
							/****************** seq-spec *******************/
							if (proteinNode.getChildNodes().item(c).getNodeName() == "status") {
								summary.setStatus(proteinNode.getChildNodes().item(c).getTextContent());
							}
						}
						proteinEntry.setSummary(summary);
					}

					/****************** Sequence *******************/
					if (proteinNode.getNodeName() == "sequence") {
						String snew = "";
						for(String s : proteinNode.getTextContent().split("\n")){
							snew += s;
						}
						proteinEntry.setSequence(snew);
					}
				}
			}
			proteinEntry.setFeatures(features);
			proteinEntry.setReferences(references);

			session.save(proteinEntry);

			session.getTransaction().commit();
			session.close();

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

	private static void xmlTest() {

		headers h = new headers("test", "12.12.2018", "adasd", "asdasdad", 2);
		List<accessions> l = new ArrayList<accessions>();
		l.add(new accessions("asd"));
		h.setAccessions(l);

		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(h);
		session.getTransaction().commit();

	}

}