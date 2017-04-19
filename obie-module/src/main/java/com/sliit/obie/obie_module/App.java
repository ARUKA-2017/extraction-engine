package com.sliit.obie.obie_module;

import java.io.File;
import java.util.List;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 *
 */
public class App {
	
	private static OntologyFactory ontologyFactory;
	
	public static void main( String[] args ){
		ontologyFactory = new OntologyFactoryImpl();
		List<OWLOntology> ontology = ontologyFactory.create().createOntolgy();
		System.out.println(ontology);
	}
}
