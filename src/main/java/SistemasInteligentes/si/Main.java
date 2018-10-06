package SistemasInteligentes.si;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.util.List;
import java.util.Map;

public class Main {

    private static final String ONTOLOGY_PATH = "src/main/java/resources/livraria.owl";
    private static final String USUARIO = "Usuario";
    private static final String LIVROS = "Livro";
    private static final String ALUGOU = "alugou";

    public static void main(String args[]) throws OWLOntologyCreationException {
        OntologyHelper helper = new OntologyHelper(ONTOLOGY_PATH);

        List<OWLNamedIndividual> usuarios = helper.getIndividualsOf(USUARIO);
        List<OWLNamedIndividual> livros = helper.getIndividualsOf(LIVROS);

        Map<OWLNamedIndividual, List<OWLObjectPropertyAssertionAxiom>> alugueisPorUsuario = helper.mapAxioms(usuarios, ALUGOU);
        Map<OWLNamedIndividual, String> livrosPorCategoria = helper.mapCategorias(livros);
    }
}
