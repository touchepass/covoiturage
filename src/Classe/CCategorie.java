package Classe;

public abstract class CCategorie {
	
	protected int IDCategorie;
	protected String nom;
	
	// Constructeurs
	
	public CCategorie(String nom) {
		
		this.nom = nom;
	}
	
	public CCategorie(int IDCategorie, String nom) {
		
		this.IDCategorie = IDCategorie;
		this.nom = nom;
	}
	
	public CCategorie() {}
	
	// Accesseurs
	
	public int getIDCategorie() {
		return IDCategorie;
	}
	
	public String getNom() {
		return nom;
	}
}
