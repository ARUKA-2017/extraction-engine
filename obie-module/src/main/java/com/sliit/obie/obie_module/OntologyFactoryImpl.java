package com.sliit.obie.obie_module;

public class OntologyFactoryImpl implements OntologyFactory{
	private DisposableOntology disposableOntology;
	public DisposableOntology create() {
		disposableOntology = new DisposableOntologyImpl();
		return disposableOntology;
	}

}
