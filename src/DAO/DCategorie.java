package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Classe.CCategorie;


public class DCategorie extends DAO<CCategorie>{
	
	public CCategorie find(String nom){
		
		CCategorie ca = null;
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TCategorie where nom='"+nom+"'");
			
			if(result.first()) {
				ca = new CCategorie(result.getInt("IDCategorie"),result.getString("nom"));
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return ca;
	}
	
	public CCategorie find(int IDCategorie){
		
		CCategorie ca = null;
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TCategorie where IDCategorie="+IDCategorie);
			
			if(result.first()) {
				ca = new CCategorie(result.getInt("IDCategorie"),result.getString("nom"));
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return ca;
	}
}
