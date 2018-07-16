package DAO;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Classe.*;

public class DCyclo extends DAO<CCyclo> {
	
	public CCyclo find(CCategorie ca) {
		
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
}
