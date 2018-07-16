package DAO;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Classe.*;

public class DDescendeur extends DAO<CDescendeur>{

	public CDescendeur find(CVtt cv) {
		
		CDescendeur cd = null;
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TDescendeur where IDCategorie="+ cv.getIDCategorie());
			
			if(result.first()) {
				cd = new CDescendeur(result.getString("caracteristique"),result.getInt("diamPneu"),result.getInt("IDCategorie"), cv.getNom());
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return cd;
	}
}
