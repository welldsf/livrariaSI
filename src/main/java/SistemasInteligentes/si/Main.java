package SistemasInteligentes.si;

import java.util.Optional;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class Main {

	public static String OntologyPath;
	public static OWLOntology Ontology;

	public static void main(String args[]) throws OWLOntologyCreationException {

		OWLOntology ontology = OntologyHelper
				.load("D:\\programacao\\workspace\\si\\src\\main\\java\\resources\\root-ontology.owl");
		OntologyPath = "D:\\\\programacao\\\\workspace\\\\si\\\\src\\\\main\\\\java\\\\resources\\\\root-ontology.owl";

		Ontology = OntologyHelper.load(OntologyPath);
		Optional<IRI> iri = Ontology.getOntologyID().getOntologyIRI();

		for (OWLClass c : OntologyHelper.getAllClasses(OntologyPath)) {
			System.out.println("Eu sou " + OntologyHelper.getClassName(c));
//			for (OWLClass cl : OntologyHelper.getAllClasses(c)) {
//				System.out.println(OntologyHelper.getClassName(cl));
		}

	}

//		new SpeakingInterface();

//		Set<OWLClass> classes = ontology.getClassesInSignature();
//
//		Set<OWLNamedIndividual> names = ontology.getIndividualsInSignature();
//
//		for (OWLNamedIndividual c : names) {
//			System.out.println(OntologyHelper.getIndividualName(c));
//			Set<OWLClassAssertionAxiom> a = ontology.getClassAssertionAxioms(c);
//			System.out.println(a.toString());
//			for (OWLClassAssertionAxiom t : a) {
//				Set<OWLClass> type = t.getClassesInSignature();
//				for (OWLClass owlClass : type) {
//					System.out.println(OntologyHelper.getClassName(owlClass));
//				}
//			}
//		}

}
//}