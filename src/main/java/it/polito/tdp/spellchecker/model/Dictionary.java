package it.polito.tdp.spellchecker.model;


import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Dictionary {

	private Set<String> dizionario;
	
	public Dictionary () {
		this.dizionario =new HashSet<String>();
	}
	
	public void loadDictionary(String language) {
		try {
			FileReader fr = new FileReader(language+".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
			// Aggiungere parola alla struttura dati
				dizionario.add(word);
			}
			br.close();
		} catch (IOException e){
			System.out.println("Errore nella lettura del file");
		}
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> listErrors = new LinkedList<RichWord>();
		RichWord richword = null;
		for(String s : inputTextList) {
			richword = new RichWord(s);
			if(!dizionario.contains(richword.toString()))
				listErrors.add(richword);
				//richword.isCorretta(false);
		}
		return listErrors;
	}
}
