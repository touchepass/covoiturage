package Classe;

import java.util.ArrayList;

public class CVehicule {
	
	private int IDVehicule;
	private CMembre conducteur;
	private ArrayList<CMembre> lstPassager;
	private int nbrPlaceAssise;
	private int nbrPlaceVelo;
	private String imma;
	
	// Constructeurs
	
	public CVehicule(CMembre conducteur, int nbrPlaceAssise, int nbrPlaceVelo, String imma) {
		
		this.conducteur = conducteur;
		this.nbrPlaceAssise = nbrPlaceAssise;
		this.nbrPlaceVelo = nbrPlaceVelo;
		this.imma = imma;
		lstPassager = new ArrayList<CMembre>();
	}
	
	public CVehicule(int IDVehicule, CMembre conducteur, int nbrPlaceAssise, int nbrPlaceVelo, String imma) {
		
		this.IDVehicule = IDVehicule;
		this.conducteur = conducteur;
		this.nbrPlaceAssise = nbrPlaceAssise;
		this.nbrPlaceVelo = nbrPlaceVelo;
		this.imma = imma;
		lstPassager = new ArrayList<CMembre>();
	}
	
	public CVehicule() {}
	
	// Accesseurs
	
	public int getIDVehicule() {
		return IDVehicule;
	}
	
	public CMembre getConducteur() {
		return conducteur;
	}
	
	public ArrayList<CMembre> getLstPassager(){
		return lstPassager;
	}
	
	public int getNbrPlaceAssise() {
		return nbrPlaceAssise;
	}
	
	public int getNbrPlaceVelo() {
		return nbrPlaceVelo;
	}
	
	public String getImma() {
		return imma;
	}
	
	
}
