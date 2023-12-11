package src.Cible;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class LecteurCible {

    private List<Cible> cibles;

    private File file;

    /***
     * Permet de créer un lecteur de Cible
     */
    public LecteurCible() throws FileNotFoundException{
        this.cibles = new ArrayList<>();
        this.file = new File("./DATA/cible.csv");
        initInfo();
    }

    /***
     * Permet de lire tout le fichier pour rentrer les données dans la classe et créer les cibles
     */
    private void initInfo() throws FileNotFoundException {
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            lines.remove(0);
            for (String line: lines) {
                String assay = line.substring(0,line.indexOf(","));
                String descString = line.substring(line.indexOf(",")+2);
                String portString = descString.substring(descString.indexOf(",")+2);
                String family = line.substring(line.lastIndexOf(",")+2);
                this.cibles.add(new Cible(assay,descString.substring(0,descString.indexOf(",")),portString.substring(0,portString.indexOf(",")),family));
            }
        } catch (IOException e){
            throw new FileNotFoundException("Fichier pattern introuvable, vérifier le PATH");
        }
    }

    /***
     * Permet de récupérer la liste des cibles dans le fichier
     * @return La liste des cibles
     */
    public List<Cible> getCibles() {
        return cibles;
    }

    /***
     * Permet d'assigner une nouvelle liste de cibles
     * @param cibles la nouvelle liste
     */
    public void setCibles(List<Cible> cibles) {
        this.cibles = cibles;
    }

    /***
     * Permet de recupérer le fichier d'info de toutes les cibles
     * @return le fichier de cibles
     */
    public File getFile() {
        return file;
    }

}
