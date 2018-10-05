package SistemasInteligentes.si;

import java.io.File;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import jdk.nashorn.internal.runtime.logging.Logger;

@Logger
public class App {

	public static void main(String[] args) {
		try {
			OWLOntologyManager man = OWLManager.createOWLOntologyManager();
			File file = new File("D:\\programacao\\workspace\\si\\src\\main\\java\\resources\\root-ontology.owl");
			OWLOntology moduleOWL = man.loadOntologyFromOntologyDocument(file);
			Set<OWLNamedIndividual> entOnt = moduleOWL.getIndividualsInSignature();

			for (OWLNamedIndividual a : entOnt) {
				System.out.println("Entity " + a);
			}
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		}
	}

}