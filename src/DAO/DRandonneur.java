package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classe.CCategorie;
import Classe.CRandonneur;

public class DRandonneur extends DAO<CRandonneur>{
	
	public CRandonneur find(Object obj) {
		
		CCategorie cv = (CCategorie)obj;
		CRandonneur cr = null;
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TRandonneur  where IDCategorie="+ cv.getIDCategorie());
			
			if(result.first()) {
				cr = new CRandonneur(result.getString("marque"),result.getInt("diamPneu"),result.getInt("IDCategorie"), cv.getNom());
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return cr;
	}

	public boolean create(CRandonneur obj) {
		return false;
	}

	public boolean delete(CRandonneur obj) {
		return false;
	}
	
	public boolean update(CRandonneur obj) {
		return false;
	}

	public ArrayList<CRandonneur> findAll() {
		return null;
	}	
}
