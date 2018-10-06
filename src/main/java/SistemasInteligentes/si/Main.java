package SistemasInteligentes.si;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.reasoner.NodeSet;

public class Main {

    private static final String ONTOLOGY_PATH = "src/main/java/resources/livraria.owl";
    private static final String USUARIO = "Usuario";
    private static final String LIVRO = "Livro";

    public static void main(String args[]) throws OWLOntologyCreationException {
        OntologyHelper helper = new OntologyHelper(ONTOLOGY_PATH);

        NodeSet<OWLNamedIndividual> usuarios = helper.getIndividualsOf(USUARIO);
        NodeSet<OWLNamedIndividual> livros = helper.getIndividualsOf(LIVRO);
    }
}
