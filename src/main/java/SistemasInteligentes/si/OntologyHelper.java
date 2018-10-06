package SistemasInteligentes.si;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

import java.io.File;
import java.util.ArrayList;

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

        for (OWLClass owlClass : ontology.getClassesInSignature()) {
            if (owlClass.getIRI().getFragment().equals(className)) {

                return reasoner.getInstances(owlClass, false);
            }
        }

        return null;
    }
}