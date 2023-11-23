package src.Cible;

public class Cible {

    private static int NBCIBLE = 0;
    private int id;
    private String family;
    private String protein;
    private String description;
    private String assay;
    public Cible(){
        this.id = nextid();
        this.assay = "";
        this.protein = "";
        this.description = "";
        this.family = "";
    }

    public Cible(String assay,String description,String protein,String family){
        this.id = nextid();
        this.assay = assay;
        this.description = description;
        this.protein = protein;
        this.family = family;
    }

    /***
     * Retourne le prochain id de Cible
     * @return Le prochain id
     */
    private int nextid() {
        return NBCIBLE++;
    }

    /***
     * Recupère l'assay de la cible
     * @return l'assay de la cible
     */
    public String getAssay() {
        return assay;
    }

    /***
     * Permet de changer l'assay de la cible
     * @param assay Nouvelle assay
     */
    public void setAssay(String assay) {
        this.assay = assay;
    }

    /***
     * Permet de récupérer la famille de la cible
     * @return La famille de la cible
     */
    public String getFamily() {
        return family;
    }

    /***
     * Permet de changer la famille de la cible
     * @param family Nouvelle famille
     */
    public void setFamily(String family) {
        this.family = family;
    }

    /***
     * Permet de récupérer la protein de la cible
     * @return La protein de la cible
     */
    public String getProtein() {
        return protein;
    }

    /***
     * Permet de changer la protein de la cible
     * @param protein Nouvelle protein
     */
    public void setProtein(String protein) {
        this.protein = protein;
    }

    /***
     * Permet de récupérer la description de la cible
     * @return La description de la cible
     */
    public String getDescription() {
        return description;
    }

    /***
     * Permet d'assigner une nouvelle description a la cible
     * @param description Nouvelle description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
