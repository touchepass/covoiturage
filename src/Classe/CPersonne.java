package Classe;

import java.util.Date;

public abstract class CPersonne {
	
	protected int IDPersonne;
	protected String nom;
	protected String prenom;
	protected Date dateNaissance;
	protected String genre;
	protected String tel;
	protected String mail;
	protected String rue;
	protected String numRue;
	protected String localite;
	protected String cp;
	protected String pseudo;
	protected String pass;
	
	public CPersonne(String nom, String prenom, Date dateNaissance, String genre, String tel, String mail,
			String rue, String numRue, String localite, String cp, String pseudo, String pass ) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.genre = genre;
		this.tel = tel;
		this.mail = mail;
		this.rue = rue;
		this.numRue = numRue;
		this.localite = localite;
		this.cp = cp;
		this.pseudo = pseudo;
		this.pass = pass;
	}
	
	public CPersonne(int IDPersonne, String nom, String prenom, Date dateNaissance, String genre, String tel, String mail,
			String rue, String numRue, String localite, String cp, String pseudo, String pass ) {
		
		this.IDPersonne = IDPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.genre = genre;
		this.tel = tel;
		this.mail = mail;
		this.rue = rue;
		this.numRue = numRue;
		this.localite = localite;
		this.cp = cp;
		this.pseudo = pseudo;
		this.pass = pass;
	}
	
	public CPersonne() {}
	
	// Accesseurs
	
	public int getIDPersonne() {
		return IDPersonne;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public Date getDateNaissance() {
		return dateNaissance;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public String getTel() {
		return tel;
	}
	
	public String getMail() {
		return mail;
	}
	
	public String getRue() {
		return rue;
	}
	public String getNumRue() {
		return numRue;
	}
	public String getLocalite() {
		return localite;
	}
	public String getCp() {
		return cp;
	}
	public String getPseudo() {
		return pseudo;
	}
	public String getPass() {
		return pass;
	}
}
