package Classe;

public class CTrialiste extends CVtt {

	private String matiere;
	
	public CTrialiste(String matiere, int diamPneu, String nom) {
		super(diamPneu, nom);
		this.matiere =  matiere;
	}
	
	public CTrialiste(String matiere, int diamPneu, int IDCategorie, String nom) {
		super(diamPneu, IDCategorie, nom);
		this.matiere =  matiere;
	}
	
	public CTrialiste() {
		super();
	}
	
	// Accesseurs
	
	public String getMatiere() {
		return matiere;
	}
}
