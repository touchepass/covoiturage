package Classe;

import java.util.ArrayList;
import java.util.Date;

public class CResponsable extends CPersonne {
	private CCategorie cat;
	
	// Constructeurs
	
	public CResponsable(CCategorie cat, String nom, String prenom, Date dateNaissance, String genre, String tel, String mail,
			String rue, String numRue, String localite, String cp, String pseudo, String pass ) {
			
		super(nom,prenom,dateNaissance,genre,tel,mail,rue,numRue,localite,cp,pseudo,pass);
		this.cat = cat;
	}
		
	public CResponsable(CCategorie cat, int IDPersonne, String nom, String prenom, Date dateNaissance, String genre, String tel, String mail,
			String rue, String numRue, String localite, String cp, String pseudo, String pass ) {
			
		super(IDPersonne,nom,prenom,dateNaissance,genre,tel,mail,rue,numRue,localite,cp,pseudo,pass);
		this.cat = cat;
	}
		
	public CResponsable() {
		super();
	}
	
	// Accesseurs
	
	
	public CCategorie getCat() {
		return cat;
	}
}
