package src;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import src.Pharmacophore.LecteurPattern;

import java.io.File;
import java.io.FileNotFoundException;

public class PopulationOntology {

    public static void main(String[] args) throws FileNotFoundException {
        // Charger le gestionnaire d'ontologie
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        LecteurPattern lecteur = new LecteurPattern();
        lecteur.getPharmacophores();
    }

}