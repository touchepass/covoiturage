package Classe;

public class CCyclo extends CCategorie {
	
	private int capacitePorteBagage;
	
	// Constructeurs
	
	public CCyclo(int capacitePorteBagage, String nom) {
		super(nom);
		this.capacitePorteBagage = capacitePorteBagage;
	}
	
	public CCyclo(int capacitePorteBagage, int IDCategorie, String nom) {
		super(IDCategorie, nom);
		this.IDCategorie = IDCategorie;
		this.capacitePorteBagage = capacitePorteBagage;
	}
	
	public CCyclo() {
		super();
	}
	
	// Accesseurs
	
	public int getCapacitePorteBagage() {
		return capacitePorteBagage;
	}
	
}
