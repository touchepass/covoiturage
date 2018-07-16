package DAO;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Classe.*;

public class DRandonneur extends DAO<CRandonneur>{
	
	public CRandonneur find(CVtt cv) {
		
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
}
