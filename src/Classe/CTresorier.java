package Classe;

import java.util.Date;

public class CTresorier extends CPersonne{
	
	private int IDTresorier;
	private String compteBancaire;
	
	// Constructeurs
	
	public CTresorier(String compteBancaire, String nom, String prenom, Date dateNaissance, String genre, String tel, String mail,
			String rue, String numRue, String localite, String cp, String pseudo, String pass ) {
			
		super(nom,prenom,dateNaissance,genre,tel,mail,rue,numRue,localite,cp,pseudo,pass);
		this.compteBancaire = compteBancaire;
	}
		
	public CTresorier(int IDTresorier, String compteBancaire, int IDPersonne, String nom, String prenom, Date dateNaissance, String genre, String tel, String mail,
			String rue, String numRue, String localite, String cp, String pseudo, String pass ) {
			
		super(IDPersonne,nom,prenom,dateNaissance,genre,tel,mail,rue,numRue,localite,cp,pseudo,pass);
		this.IDTresorier = IDTresorier;
		this.compteBancaire = compteBancaire;
	}
		
	public CTresorier() {
		super();
	}
	
	// Accesseurs
	
	public int getIDTresorier() {
		return IDTresorier;
	}
	
	public String getCompteBancaire() {
		return compteBancaire;
	}
}
