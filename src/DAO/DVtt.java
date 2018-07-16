package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import Classe.CCategorie;
import Classe.CVtt;

public class DVtt extends DAO<CVtt> {
	
	public CVtt find(CCategorie ca) {
		
		CVtt cv = null;
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TVtt where IDCategorie="+ ca.getIDCategorie());
			//int diamPneu, int IDCategorie, String nom
			if(result.first()) {
				cv = new CVtt(result.getInt("diamPneu"),result.getInt("IDCategorie"), ca.getNom());
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return cv;
	}
}
