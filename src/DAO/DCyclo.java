package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classe.CCategorie;
import Classe.CCyclo;

public class DCyclo extends DAO<CCyclo> {
	
	public CCyclo find(Object obj) {
		CCategorie ca = (CCategorie)obj;
		
		CCyclo cy = null;
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TCyclo where IDCategorie="+ ca.getIDCategorie());
			
			if(result.first()) {
				cy = new CCyclo(result.getInt("capacitePorteBagage"),result.getInt("IDCategorie"), ca.getNom());
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return cy;
	}

	public boolean create(CCyclo obj) {
		return false;
	}

	public boolean delete(CCyclo obj) {
		return false;
	}

	public boolean update(CCyclo obj) {
		return false;
	}

	public ArrayList<CCyclo> findAll() {
		return null;
	}
}
