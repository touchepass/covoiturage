package Classe;

import java.util.Date;
import java.util.ArrayList;

public class CMembre extends CPersonne{
	private ArrayList<CCategorie> lstCat;
	private boolean payementCotistion;
	
	// Constructeurs
	
	public CMembre(String nom, String prenom, Date dateNaissance, String genre, String tel, String mail,
			String rue, String numRue, String localite, String cp, String pseudo, String pass ) {
		
		super(nom,prenom,dateNaissance,genre,tel,mail,rue,numRue,localite,cp,pseudo,pass);
		lstCat = new ArrayList<CCategorie>();
		this.payementCotistion = false;
	}
	
	public CMembre(boolean payementCotistion, int IDPersonne, String nom, String prenom, Date dateNaissance, String genre, String tel, String mail,
			String rue, String numRue, String localite, String cp, String pseudo, String pass ) {
		
		super(IDPersonne,nom,prenom,dateNaissance,genre,tel,mail,rue,numRue,localite,cp,pseudo,pass);
		lstCat = new ArrayList<CCategorie>();
		this.payementCotistion = payementCotistion;
	}
	
	public CMembre() {
		super();
	}
	
	// Accesseurs
	
	
	public ArrayList<CCategorie> getLstCat(){
		return lstCat;
	}
	
	public boolean getPayementCotistion() {
		return payementCotistion;
	}
	
	// mutateurs
	
	public void setPayementCotistion(boolean choix) {
		this.payementCotistion = choix;
	}
	
	// méthodes
	
	public void ajouterCategorie(CCategorie ca) {
		this.lstCat.add(ca);
	}
	
}
