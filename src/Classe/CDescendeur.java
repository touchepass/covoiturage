package Classe;

public class CDescendeur extends CVtt {
	
	private String caracteristique;
	
	public CDescendeur(String caracteristique, int diamPneu, String nom) {
		super(diamPneu, nom);
		this.caracteristique =  caracteristique;
	}
	
	public CDescendeur(String caracteristique, int diamPneu, int IDCategorie, String nom) {
		super(diamPneu, IDCategorie, nom);
		this.caracteristique =  caracteristique;
	}
	
	public CDescendeur() {
		super();
	}
	
	// Accesseurs
	
	public String getCaracteristique() {
		return caracteristique;
	}
	
}
