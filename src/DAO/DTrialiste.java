package DAO;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Classe.*;

public class DTrialiste extends DAO<CTrialiste>{
	
	public CTrialiste find(CVtt cv) {
		
		CTrialiste ct = null;
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TTrialiste  where IDCategorie="+ cv.getIDCategorie());
			
			if(result.first()) {
				ct = new CTrialiste(result.getString("matiere"),result.getInt("diamPneu"),result.getInt("IDCategorie"), cv.getNom());
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return ct;
	}
}
