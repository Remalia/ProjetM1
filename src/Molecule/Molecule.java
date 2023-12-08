package src.Molecule;

import java.util.ArrayList;
import java.util.List;

public class Molecule {

    public static int NBMOLECULE = 0;
    private int id;
    private String nom;
    private List<Float> activites;
    private List<Integer> idPharmacophores;

    /***
     * Constructeur vide d'une molecule
     */
    public Molecule(){
        this.id = nextid();
        this.nom = "";
        this.activites = new ArrayList<>();
        this.idPharmacophores = new ArrayList<>();
    }

    /***
     * Constructeur d'une molecule
     * @param nom Nom de la molecule (Code smile)
     */
    public Molecule(String nom){
        this.id = nextid();
        this.nom = nom;
        this.activites = new ArrayList<>();
        this.idPharmacophores = new ArrayList<>();
    }

    /***
     * Retourne le prochain id de molecule
     * @return Le prochain id
     */
    private int nextid() {
        return NBMOLECULE++;
    }

    /***
     * Permet de recuperer le nom de la molécule
     * @return Le nom de la molecule
     */
    public String getNom() {
        return nom;
    }

    /***
     * Permet de definir le nom de la molecule
     * @param nom Le nouveau nom de la molecule
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /***
     * Recupère la liste de toutes les activités de la molecule
     * @return La liste des activités
     */
    public List<Float> getActivites() {
        return activites;
    }

    /***
     * Assigne une nouvelle liste d'activités
     * @param activites La nouvelle liste d'activités
     */
    public void setActivites(List<Float> activites) {
        this.activites = activites;
    }

    /***
     * Recupère la liste de tous les numéros de pharmacophores de la molecule
     * @return La liste des numéros de pharmacophores
     */
    public List<Integer> getIdPharmacophores() {
        return idPharmacophores;
    }

    /***
     * Assigne une nouvelle liste de numéros de pharmacophores
     * @param idPharmacophores La nouvelle liste de numéros de pharmacophores
     */
    public void setIdPharmacophores(List<Integer> idPharmacophores) {
        this.idPharmacophores = idPharmacophores;
    }

    /***
     * Ajoute une valeur en fin de liste des activités
     * @param valActivite La valeur à ajouter
     */
    public void addNextActivites(Float valActivite){
        this.activites.add(valActivite);
    }

    /***
     * Ajoute une valeur en fin de liste de numéros de pharmacophores
     * @param numPharmacophore Le numéro à ajouter
     */
    public void addNextPharcophores(int numPharmacophore){
        this.idPharmacophores.add(numPharmacophore);
    }

    /***
     * Permet de récupérer l'ID de la molecule
     * @return L'ID de la molecule
     */
    public int getId() {
        return id;
    }

    /***
     * Permet de modifier l'ID de la molecule
     * @param id la nouvelle ID
     */
    public void setId(int id) {
        this.id = id;
    }
}

