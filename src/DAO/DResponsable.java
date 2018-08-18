package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classe.CCategorie;
import Classe.CPersonne;
import Classe.CResponsable;

public class DResponsable extends DAO<CResponsable>{
	
	public CResponsable find(Object obj){
		
		CPersonne cp = (CPersonne)obj;
		
		CResponsable cr = null;
		DAO<CCategorie> dc = new DCategorie();
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TResponsable where IDPersonne="+cp.getIDPersonne());
			
			if(result.first()) {
				cr = new CResponsable(dc.find(result.getInt("IDCategorie")),cp.getIDPersonne(),
									cp.getNom(), cp.getPrenom(), cp.getDateNaissance(),
									cp.getGenre(), cp.getTel(), cp.getMail(),
									cp.getRue(), cp.getNumRue(), cp.getLocalite(),
									cp.getCp(), cp.getPseudo(), cp.getPass());
			}
	
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return cr;
	}

	public boolean create(CResponsable obj) {
		return false;
	}

	public boolean delete(CResponsable obj) {
		return false;
	}

	public boolean update(CResponsable obj) {
		return false;
	}

	public ArrayList<CResponsable> findAll() {
		return null;
	}

}
