package com.hemebiotech.analytics;

import com.hemebiotech.analytics.exception.FileReaderException;
import com.hemebiotech.analytics.exception.FileWriterException;
import java.util.*;

public class AnalyticsCounter {

	public static void main(String[] args) {
		try {
			SymptomReader symptome = new SymptomReader();
			TreeMap<String, Integer> map = symptome.getSymptomesFromAFile();
			symptome.getWriterFromATreeMap(map);
		} catch (FileReaderException e) {
			System.err.println("Problème avec le fichier d'entrée : " + e.getMessage());
		} catch (FileWriterException e) {
			System.err.println("Problème avec le fichier de sortie : " + e.getMessage());
		}
	}

}


