package src.Molecule;

import src.Pharmacophore.Pharmacophore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
public class LecteurMolecule {

    private List<Molecule> molecules;
    private File file;

    /***
     * Permet de créer un lecteur de Molecule
     */
    public LecteurMolecule() throws FileNotFoundException{
        this.molecules = new ArrayList<>();
        this.file = new File("./DATA/molecule.txt");
        initInfo();
    }

    /***
     * Permet de lire tout le fichier pour rentrer les données dans la classe et créer les molecules
     */
    private void initInfo() throws FileNotFoundException {
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            if (!lines.isEmpty()){
                int count = 0;
                for (String line: lines) {
                    String lineAct = line.substring(line.indexOf(" ")+1,line.lastIndexOf(" "));
                    String linePH = line.substring(line.lastIndexOf(" ")+1);
                    Molecule mol = new Molecule(line.substring(0,line.indexOf(" ")));
                    ajouterAllAct(mol,lineAct);
                    ajouterAllPH(mol,linePH);
                    molecules.add(mol);
                    count ++;
                }
            }
        } catch (IOException e){
            throw new FileNotFoundException("Fichier pattern introuvable, vérifier le PATH");
        }
    }


    /***
     * Ajoute toutes les activités envers les cibles de la molecules
     * @param mol La molecule
     * @param lineAct La ligne contenant toutes les activités
     */
    private void ajouterAllAct(Molecule mol, String lineAct) {
        while (lineAct.contains("|")){
            mol.addNextActivites(Float.parseFloat(lineAct.substring(0,lineAct.indexOf("|"))));
            lineAct = lineAct.substring(lineAct.indexOf("|")+1);
        }
        mol.addNextActivites(Float.parseFloat((lineAct)));
    }

    /***
     * Ajoute toutes les ids des pharmacophores à la molécule
     * @param mol La molécule
     * @param linePH La ligne contenant toutes les pharmacophores
     */
    private void ajouterAllPH(Molecule mol, String linePH) {
        while (linePH.contains("|")){
            mol.addNextPharcophores(Integer.parseInt(linePH.substring(0,linePH.indexOf("|"))));
            linePH = linePH.substring(linePH.indexOf("|")+1);
        }
        mol.addNextPharcophores(Integer.parseInt((linePH)));
    }

    /***
     * Ajoute une molécule à la liste des molecules
     * @param mol La molécule à ajouter
     */
    private void addMolecule(Molecule mol){
        this.molecules.add(mol);
    }

    /***
     * Permet de récupérer la liste des molecules dans le fichier
     * @return La liste des molecules
     */
    public List<Molecule> getMolecules() {
        return molecules;
    }

    /***
     * Permet d'assigner une nouvelle liste de molecules
     * @param molecules la nouvelle liste
     */
    public void setMolecules(List<Molecule> molecules) {
        this.molecules = molecules;
    }

    /***
     * Permet de recupérer le fichier d'info de toutes les molécules
     * @return le fichier de molécules
     */
    public File getFile() {
        return file;
    }

}
