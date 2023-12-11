package src;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import src.Cible.LecteurCible;
import src.Molecule.LecteurMolecule;
import src.Pharmacophore.LecteurPattern;
import java.io.FileNotFoundException;

public class PopulationOntology {

    public static void main(String[] args) throws FileNotFoundException {
        // Charger le gestionnaire d'ontologie
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        LecteurPattern lecteurPH4 = new LecteurPattern();
        LecteurMolecule lecteurMol = new LecteurMolecule();
        LecteurCible lecteurCible = new LecteurCible();
        //TODO --> POUR QUE LE CODE MARCHE, RAJOUTER DANS LE DOSSIER DATA A LA RACINE DU PROJETS LES 3 FICHIERS SUIVANT : molecule.txt / pattern.txt / cible.csv       /!\ Au nom des fichiers !

        //TODO Si le PATH n'est toujours pas trouvé, c'est que vous codez sur Linux et que le path est différents de windows --> changer les "/" par "\" ou un truc de ce genre

        //TODO --> Realiser le peuplement en recréant toutes les données en fichier owl en utilisant tout les lecteurs au dessus qui récupère chacun des objets du projets
    }
}