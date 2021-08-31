package com.hemebiotech.analytics;




import java.util.*;



public class AnalyticsCounter {

	public static void main(String[] args) {

		SymptomReader symptome = new SymptomReader();
		TreeMap<String, Integer> map = symptome.getSymptomes();
		symptome.getResult(map);
	}




}


