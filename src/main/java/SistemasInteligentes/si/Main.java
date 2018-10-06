package SistemasInteligentes.si;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.reasoner.NodeSet;

public class Main {

    public static void main(String args[]) throws OWLOntologyCreationException {
        String ontologyPath = "src\\main\\java\\resources\\livraria.owl";

        OntologyHelper helper = new OntologyHelper(ontologyPath);

        NodeSet<OWLNamedIndividual> usuarios = helper.getIndividualsOf("Usuario");
        NodeSet<OWLNamedIndividual> livros = helper.getIndividualsOf("Livro");
    }
}
