package Classe;

public class CRandonneur extends CVtt {
	
	private String marque;
	
	public CRandonneur(String marque, int diamPneu, String nom) {
		super(diamPneu, nom);
		this.marque =  marque;
	}
	
	public CRandonneur(String marque, int diamPneu, int IDCategorie, String nom) {
		super(diamPneu, IDCategorie, nom);
		this.marque =  marque;
	}
	
	public CRandonneur() {
		super();
	}
	
	// Accesseurs
	
	public String getMarque() {
		return marque;
	}
	
}
