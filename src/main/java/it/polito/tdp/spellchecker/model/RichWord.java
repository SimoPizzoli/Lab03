package it.polito.tdp.spellchecker.model;

import java.util.*;

public class RichWord {
	
	private String parola;
//	private boolean corretta;
	
	public RichWord (String parola) {
		this.parola = parola;
//		this.corretta = true;
	}
	
/*	public boolean isCorretta(boolean corretta) {
		return corretta;
	}	*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RichWord other = (RichWord) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.parola;
	}
	
	
}
