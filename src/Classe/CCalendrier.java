package Classe;

import java.util.ArrayList;

public class CCalendrier {
	
	private int IDCalendrier;
	private CCategorie ca;
	private ArrayList<CBalade> lstBalade;
	private String nom;
	
	// constructeurs
	
	public CCalendrier() {}
	
	public CCalendrier(String nom, CCategorie ca) {
		
		this.ca = ca;
		this.nom = nom;
		lstBalade = new ArrayList<CBalade>();
	}
	
	public CCalendrier(int IDCalendrier, CCategorie ca, ArrayList<CBalade> lstBalade,  String nom) {
		
		this.IDCalendrier = IDCalendrier;
		this.ca = ca;
		this.nom = nom;
		this.lstBalade = lstBalade;
	}
	
	// Accesseurs
	
	public int getIDCalendrier() {
		return IDCalendrier;
	}
	
	public CCategorie getCa() {
		return ca;
	}
	
	public String getNom() {
		return nom;
	}
	
	public ArrayList<CBalade> getLstBalade(){
		return lstBalade;
	}
}
