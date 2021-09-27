package com.hemebiotech.analytics;

import com.hemebiotech.analytics.exception.FileReaderException;
import com.hemebiotech.analytics.exception.FileWriterException;
import java.io.*;
import java.util.TreeMap;

/** SymptomReader est une classe qui va pouvoir lire des symptomes sur un fichier externe, les compter
 * puis elle va renvoyer un fichier dans lequel les symptomes seront classés en colonne et dénombrés.
 */
public class SymptomReader {
    private static final String INPUT_FILENAME = "symptoms.txt";

    /**
     getSymptomesFromAFile parcours une liste de symptome depuis un fichier et recense toutes les occurences de ces derniers.
     * @return un treeMap contenant les symptomes du fichier
     * @throws FileReaderException lorsque le fichier  "symptoms.txt" est introuvable ou impossible à lire.
     */
    public TreeMap<String, Integer> getSymptomesFromAFile() throws FileReaderException {

        BufferedReader reader;
        String line;
        try {
            reader = new BufferedReader(new FileReader(INPUT_FILENAME));
        } catch (FileNotFoundException e) {
            throw new FileReaderException("Le fichier d'entrée est introuvable");
        }

        TreeMap<String, Integer> symptomes = new TreeMap<>();
        try {
            while ((line = reader.readLine()) != null) {
                String key = line;
                if (!symptomes.containsKey(key)) {
                    symptomes.put(key, 1);
                } else {
                    int value = symptomes.get(key);
                    value++;
                    symptomes.put(key, value);
                }
            }
        } catch (IOException e) {
            throw new FileReaderException("Impossible de lire le fichier d'entrée");
        }
        return symptomes;
    }

    /**
     * getWriterFromAfile créer un fichier "result.out" dans lequel il écrit sous forme de colonne  un TreeMap (String, Integer).
     * @return un fichier result.out
     * @throws FileWriterException lorsque writer n'arrive pas a lire le TreeMap
     */
    public void getWriterFromATreeMap(TreeMap<String, Integer> result) throws FileWriterException {

        try {
            final FileWriter writer = new FileWriter("result.out");

            result.forEach((s, integer) -> {
                try {
                    writer.write(s + " : " + integer + "\n");
                } catch (IOException e) {
                    System.err.println("Impossible d'ecrire sur le fichier de sortie");
                }
            });
            writer.close();
        } catch (IOException e) {
            throw new FileWriterException("Impossible d'écrire sur le fichier de sortie");
        }
    }
}

