package Classe;

public abstract class CVtt extends CCategorie{
	
	protected int diamPneu;
	
	public CVtt(int diamPneu, String nom) {
		super(nom);
	}
	
	public CVtt(int diamPneu, int IDCategorie, String nom) {
		super(IDCategorie, nom);
	}
	
	public CVtt() {
		super();
	}
	
	// Accesseurs
	
	public int getDiamPneu() {
		return diamPneu;
	}
	
}
