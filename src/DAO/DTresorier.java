package DAO;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Classe.*;

public class DTresorier extends DAO<CTresorier> {
	
	public CTresorier find(CPersonne cp){
		
		CTresorier ct = null; 
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TTresorier where IDPersonne="+cp.getIDPersonne());
			
			if(result.first()) {
				ct = new CTresorier(result.getString("compteBancaire"),cp.getIDPersonne(),
									cp.getNom(), cp.getPrenom(), cp.getDateNaissance(),
									cp.getGenre(), cp.getTel(), cp.getMail(),
									cp.getRue(), cp.getNumRue(), cp.getLocalite(),
									cp.getCp(), cp.getPseudo(), cp.getPass());
			}
	
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return ct;
	}
}
