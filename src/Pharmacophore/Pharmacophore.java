package src.Pharmacophore;

import java.util.ArrayList;
import java.util.List;

public class Pharmacophore {

    public static int NBPHARMACOPHORE=0;
    private int id;
    private String pattern;
    private int support;
    private List<Integer> activites;
    private List<Integer> idMolecules;

    /***
     * Constructeur vide d'un pharmacophore
     */
    public Pharmacophore(){
        NBPHARMACOPHORE++;
    }

    /***
     * Constructeur de pharmacophore
     * @param id id du pharmacophore
     * @param pattern pattern du pharmacophore
     * @param support numero du support
     */
    public Pharmacophore(int id,String pattern,int support){
        NBPHARMACOPHORE++;
        this.id = id;
        this.pattern = pattern;
        this.support = support;
        this.idMolecules = new ArrayList<>();
        this.activites = new ArrayList<>();
    }

    /***
     * Recupère le support du pharmacophore
     * @return le support du pharmacophore
     */
    public int getSupport() {
        return support;
    }

    /***
     * Permet de changer le support du pharmacophore
     * @param support Nouveau support
     */
    public void setSupport(int support) {
        this.support = support;
    }

    /***
     * Recupère le pattern du pharmacophore
     * @return le pattern du pharmacophore
     */
    public String getPattern() {
        return pattern;
    }

    /***
     * Permet de changer le pattern du pharmacophore
     * @param pattern Nouveau pattern
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /***
     * Permet de récupérer l'ID du pharmacophore
     * @return L'ID du pharmacophore
     */
    public int getId() {
        return id;
    }

    /***
     * Permet de modifier l'ID du pharmacophore
     * @param id la nouvelle ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     * Recupère la liste de toutes les activités de la molecule
     * @return La liste des activités
     */
    public List<Integer> getActivites() {
        return activites;
    }

    /***
     * Assigne une nouvelle liste d'activités
     * @param activites La nouvelle liste d'activités
     */
    public void setActivites(List<Integer> activites) {
        this.activites = activites;
    }

    /***
     * Recupère la liste de tous les numéros de molecules du pharmacophore
     * @return La liste des numéros des molecules
     */
    public List<Integer> getIdMolecules() {
        return idMolecules;
    }

    /***
     * Assigne une nouvelle liste de numéros de molecules
     * @param idMolecules La nouvelle liste de numéros de molecules
     */
    public void setIdMolecules(List<Integer> idMolecules) {
        this.idMolecules = idMolecules;
    }

    /***
     * Ajoute une valeur en fin de liste des activités
     * @param valActivite La valeur à ajouter
     */
    public void addNextActivites(int valActivite){
        this.activites.add(valActivite);
    }

    /***
     * Ajoute une valeur en fin de liste de numéros des molecules
     * @param numMolecules Le numéro à ajouter
     */
    public void addNextMolecules(int numMolecules){
        this.idMolecules.add(numMolecules);
    }
}
