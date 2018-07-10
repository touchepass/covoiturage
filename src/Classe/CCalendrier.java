package Classe;

import java.util.ArrayList;

public class CCalendrier {
	
	private int IDCalendrier;
	private ArrayList<CBalade> lstBalade;
	private String nom;
	
	// constructeurs
	
	public CCalendrier() {}
	
	public CCalendrier(String nom) {
		
		this.nom = nom;
		lstBalade = new ArrayList<CBalade>();
	}
	
	public CCalendrier(int IDCalendrier, String nom) {
		
		this.IDCalendrier = IDCalendrier;
		this.nom = nom;
		lstBalade = new ArrayList<CBalade>();
	}
	
	// Accesseurs
	
	public int getIDCalendrier() {
		return IDCalendrier;
	}
	
	public String getNom() {
		return nom;
	}
	
	public ArrayList<CBalade> getLstBalade(){
		return lstBalade;
	}
}
