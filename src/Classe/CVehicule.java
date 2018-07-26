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
	
	public CVehicule(int IDVehicule, CMembre conducteur, int nbrPlaceAssise, int nbrPlaceVelo, String imma, ArrayList<CMembre> lstPassager) {
		
		this.IDVehicule = IDVehicule;
		this.conducteur = conducteur;
		this.nbrPlaceAssise = nbrPlaceAssise;
		this.nbrPlaceVelo = nbrPlaceVelo;
		this.imma = imma;
		this.lstPassager = lstPassager;
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
	
	// Mutateurs
	
	
	
	
	//Méthodes
	
	@Override
	public String toString() {
		return getConducteur().getPseudo() + " (" + placeLibre()+ " place(s) dispo. )";
	}
	
	public int placeLibre() {
		return  getNbrPlaceAssise() - getLstPassager().size();
	}
	
	public boolean estPassager(CMembre cm) {
		for(CMembre m : this.lstPassager) {
			if(cm.getPseudo() == m.getPseudo()) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean estConducteur(CMembre cm) {
		if(cm.getPseudo() == this.conducteur.getPseudo())
			return true;
		else
			return false;
	}
	
	public void ajouterPassager(CMembre cm) {
		getLstPassager().add(cm);
	}
	
}
