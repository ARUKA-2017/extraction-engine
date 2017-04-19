package com.sliit.obie.obie_module;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

public class DisposableOntologyImpl implements DisposableOntology{
	private static final String ONTOLOGY_CREATION_EXCEPTION = "Error occured while creating tempory ontology";
	private OWLOntologyManager ontologyManager;
	private OWLOntology ontology;
	private List<OWLOntology> ontologies;
	//for mock usage
	private File tempFile;
	private final Logger logger;

	public DisposableOntologyImpl(){
		this.ontologyManager = OWLManager.createOWLOntologyManager();
		//for mock usage
		this.tempFile = new File("sample-ontologies/functions.owl");
		this.ontologies = new LinkedList<OWLOntology>();
		logger = LoggerFactory.getLogger(DisposableOntologyImpl.class);
	}
	
	public List<OWLOntology> createOntolgy() {
			//mock usage
			OWLOntology owlOntology = null;
			try {				
				owlOntology = ontologyManager.loadOntologyFromOntologyDocument(this.tempFile);
				logger.info("Ontology created and transfered successfully");
				System.out.println(owlOntology);
			} catch (OWLOntologyCreationException e) {
				logger.error(ONTOLOGY_CREATION_EXCEPTION);
			}
			ontologies.add(owlOntology);
		
		return ontologies;
	}

}
