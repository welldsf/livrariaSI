package SistemasInteligentes.si;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

class OntologyHelper {

    private OWLOntology ontology;
    private OWLReasoner reasoner;

    OntologyHelper(String ontologyPath) throws OWLOntologyCreationException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        ontology = manager.loadOntologyFromOntologyDocument(new File(ontologyPath));

        OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
        reasoner = reasonerFactory.createReasoner(ontology);
    }

    List<OWLNamedIndividual> getIndividualsOf(String className) {
        OWLClass owlClass = ontology.classesInSignature()
                .filter(it -> it.getIRI().getShortForm().equals(className))
                .findFirst()
                .get();

        return reasoner.getInstances(owlClass, false)
                .entities()
                .collect(Collectors.toList());
    }

    List<OWLObjectPropertyAssertionAxiom> getAxioms(String subject, String property) {
        return ontology.axioms(AxiomType.OBJECT_PROPERTY_ASSERTION)
                .filter(it -> it.getSubject().toString().contains(subject) &&
                        it.getProperty().getNamedProperty().getIRI().getShortForm().equals(property))
                .collect(Collectors.toList());
    }
}