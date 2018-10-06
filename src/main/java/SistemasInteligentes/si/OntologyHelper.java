package SistemasInteligentes.si;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

import java.io.File;

class OntologyHelper {

    private OWLOntology ontology;
    private OWLReasoner reasoner;

    OntologyHelper(String ontologyPath) throws OWLOntologyCreationException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        ontology = manager.loadOntologyFromOntologyDocument(new File(ontologyPath));

        OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
        reasoner = reasonerFactory.createReasoner(ontology);
    }

    NodeSet<OWLNamedIndividual> getIndividualsOf(String className) {
        OWLClass owlClass = ontology.classesInSignature()
                .filter(it -> it.getIRI().getShortForm().equals(className))
                .findFirst()
                .get();
        return reasoner.getInstances(owlClass, false);
    }
}