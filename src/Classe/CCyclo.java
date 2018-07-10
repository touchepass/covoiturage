package Classe;

public class CCyclo extends CCategorie {
	
	private int capacitePorteBagage;
	
	// Constructeurs
	
	public CCyclo(int capacitePorteBagage, String nom) {
		super(nom);
	}
	
	public CCyclo(int capacitePorteBagage, int IDCategorie, String nom) {
		super(IDCategorie, nom);
	}
	
	public CCyclo() {
		super();
	}
	
	// Accesseurs
	
	public int getCapacitePorteBagage() {
		return capacitePorteBagage;
	}
	
}
