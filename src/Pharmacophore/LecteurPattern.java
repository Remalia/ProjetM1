package src.Pharmacophore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class LecteurPattern {
    private List<Pharmacophore> pharmacophores;
    private File file;

    /***
     * Permet de créer un lecteur de pattern
     */
    public LecteurPattern() throws FileNotFoundException{
        this.pharmacophores = new ArrayList<>();
        this.file = new File("./DATA/pattern.txt");
        initInfo();
    }

    /***
     * Permet de lire tout le fichier pour rentrer les données dans la classe
     */
    private void initInfo() throws FileNotFoundException {
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            if (!lines.isEmpty()){
                int count = 0;
                for (String line: lines) {
                    int numDigits = String.valueOf(count).length();
                    String idCut = line.substring(numDigits+2);
                    String pattern = line.substring(numDigits+2,idCut.indexOf(" ")+numDigits+2);
                    String supportAndAct = line.substring(idCut.indexOf(" ")+numDigits+3,line.lastIndexOf(" "));
                    int support = Integer.parseInt(supportAndAct.substring(0,supportAndAct.indexOf("|")));
                    String molCut = line.substring(line.lastIndexOf(" ") + 1);
                    Pharmacophore ph = new Pharmacophore(Integer.parseInt(line.substring(0,numDigits)), pattern,support);
                    ajouterAllAct(ph,supportAndAct);
                    ajouterAllMol(ph,molCut);
                    pharmacophores.add(ph);
                    count ++;
                }
            }
        } catch (IOException e){
            throw new FileNotFoundException("Fichier pattern introuvable, vérifier le PATH");
        }
    }

    /***
     * Ajoute toutes les ids des molécules au pharmacophores
     * @param ph Le pharmacophore
     * @param molCut La ligne contenant toutes les molécules
     */
    private void ajouterAllMol(Pharmacophore ph, String molCut) {
        String molCutNext = molCut.substring(molCut.indexOf("|")+1);
        ph.addNextMolecules(Integer.parseInt(molCut.substring(0,molCut.indexOf("|"))));
        if(molCutNext.contains("|"))
            ajouterAllMol(ph,molCutNext);
        else
            ph.addNextMolecules(Integer.parseInt(molCutNext));
    }

    /***
     * Ajoute toutes les activités envers les cibles du pharmacophores
     * @param ph Le pharmacophore
     * @param supportAndAct La ligne contenant tous les supports et activités
     */
    private void ajouterAllAct(Pharmacophore ph, String supportAndAct) {
        int taillePh = String.valueOf(ph.getSupport()).length();
        String actCut = supportAndAct.substring(supportAndAct.indexOf(ph.getSupport()+"|")+1+taillePh);
        actCut.replace('.',',');
        while (actCut.contains(ph.getSupport()+"|")){
            ph.addNextActivites(Float.parseFloat(actCut.substring(0,actCut.indexOf(" "))));
            actCut = actCut.substring(actCut.indexOf(ph.getSupport()+"|")+1+taillePh);
        }
        ph.addNextActivites(Float.parseFloat(actCut));
    }

    /***
     * Ajoute un pharmacophores à la liste des pharmacophores
     * @param p Le pharmacophore à ajouter
     */
    private void addPharmacophores(Pharmacophore p){
        pharmacophores.add(p);
    }

    /***
     * Permet de récupérer la liste des pharmacophores dans le fichier
     * @return La liste des pharmacophores
     */
    public List<Pharmacophore> getPharmacophores() {
        return pharmacophores;
    }

    /***
     * Permet d'assigner une nouvelle liste de pharmacophores
     * @param pharmacophores la nouvelle liste
     */
    public void setPharmacophores(List<Pharmacophore> pharmacophores) {
        this.pharmacophores = pharmacophores;
    }

    /***
     * Permet de recupérer le fichier d'info de tous les patterns
     * @return le fichier de patterns
     */
    public File getFile() {
        return file;
    }
}
