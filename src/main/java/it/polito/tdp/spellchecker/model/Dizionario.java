package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dizionario {	
	private List<String> dizionarioEng= new ArrayList<>();
	private List<String> dizionarioIta= new ArrayList<>();

	public Dizionario() {
		
		try {
			FileReader fr = new FileReader("src/main/resources/Italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				dizionarioIta.add(word);
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
		
		
		try {
			FileReader fr = new FileReader("src/main/resources/English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				dizionarioEng.add(word);
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}

	}
	
		
	
	public List<String> ricercaContains(String testo, String lingua){
		List<String> ritorno= new ArrayList<>();
		
		testo=testo.replaceAll("[^a-z A-Z]", "");
		testo=testo.toLowerCase();
		String [] array= testo.split(" ");
		
		if(lingua.compareTo("Italian")==0) {	
			for(int i=0;i<array.length;i++) {
				if(!dizionarioIta.contains(array[i]))
					ritorno.add(array[i]);
			}
		}
		
		else {
			for(int i=0;i<array.length;i++) {
				if(!dizionarioEng.contains(array[i]))
					ritorno.add(array[i]);
			}
		}

		return ritorno;
	}
	
	
	
	public List<String> ricercaLineare(String testo, String lingua){
		List<String> ritorno= new ArrayList<>();
		
		testo=testo.replaceAll("[^a-z A-Z]", "");
		testo=testo.toLowerCase();
		String [] array= testo.split(" ");
		
		
		if(lingua.compareTo("Italian")==0) {	
			int spy=0;
			for(int i=0;i<array.length;i++) {		
				
				for(int j=0;j<dizionarioIta.size();j++) {
					spy++;
					if(array[i].compareTo(dizionarioIta.get(j))==0) 
						break;
				}
				
				if(spy==dizionarioIta.size()) {
					ritorno.add(array[i]);
				}
				spy=0;
			}
		}
		
		
		else {
			int spy=0;
			for(int i=0;i<array.length;i++) {		
				
				for(int j=0;j<dizionarioEng.size();j++) {
					spy++;
					if(array[i].compareTo(dizionarioEng.get(j))==0) 
						break;
				}
				
				if(spy==dizionarioEng.size()) {
					ritorno.add(array[i]);
				}
				spy=0;
			}
		}
		return ritorno;
	}
	
	public List<String> ricercaDicotomica(String testo, String lingua){
		List<String> ritorno= new ArrayList<>();
		
		testo=testo.replaceAll("[^a-z A-Z]", "");
		testo=testo.toLowerCase();
		String [] array= testo.split(" ");
		
		
		if(lingua.compareTo("Italian")==0) {	
			int spy=0;
			
			for(int i=0;i<array.length;i++) {		
				boolean control=false;
				
				for(int j=0;j<(dizionarioIta.size()/2);j++) {
					spy++;
					if(array[i].compareTo(dizionarioIta.get(j))==0) {
						control=true;
						break;
					}	
				}
				
				if(control==false) {
					for(int j=(dizionarioIta.size()/2);j<dizionarioIta.size();j++) {
						spy++;
						if(array[i].compareTo(dizionarioIta.get(j))==0) 
							break;
					}
				}
				
				if(spy==dizionarioIta.size()) {
					ritorno.add(array[i]);
				}
				spy=0;	
			}
		}
		
		
		else {
			int spy=0;
			
			for(int i=0;i<array.length;i++) {		
				boolean control=false;
				
				for(int j=0;j<(dizionarioEng.size()/2);j++) {
					spy++;
					if(array[i].compareTo(dizionarioEng.get(j))==0) {
						control=true;
						break;
					}		
				}
				
				if(control==false) {
					for(int j=(dizionarioEng.size()/2);j<dizionarioEng.size();j++) {
						spy++;
						if(array[i].compareTo(dizionarioEng.get(j))==0) 
							break;
					}
				}
				
				if(spy==dizionarioEng.size()) {
					ritorno.add(array[i]);
				}
				spy=0;
			}
		}
		return ritorno;
	}
	
	
	
	
	
}
