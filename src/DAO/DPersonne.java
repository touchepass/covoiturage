package DAO;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Classe.*;

public class DPersonne extends DAO<CPersonne> {
	
	
	public CPersonne find(String pseudo, String pass){
		
		CPersonne p = null;
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TPersonne where pseudo='"+pseudo+"' and pass='"+pass+"'");
			
			if(result.first()) {
				p = new CPersonne(	result.getInt("IDPersonne"),result.getString("nom"),result.getString("prenom"),
									result.getDate("dateNaissance"), result.getString("genre"), result.getString("tel"),
									result.getString("mail"), result.getString("rue"), result.getString("numRue"),
									result.getString("localite"), result.getString("cp"), result.getString("pseudo"),
									result.getString("pass"));
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return p;
	}
	
	public CPersonne find(int IDPersonne){
		
		CPersonne p = null;
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TPersonne where IDPersonne="+IDPersonne);
			
			if(result.first()) {
				p = new CPersonne(	result.getInt("IDPersonne"),result.getString("nom"),result.getString("prenom"),
									result.getDate("dateNaissance"), result.getString("genre"), result.getString("tel"),
									result.getString("mail"), result.getString("rue"), result.getString("numRue"),
									result.getString("localite"), result.getString("cp"), result.getString("pseudo"),
									result.getString("pass"));
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return p;
	}
	
	public boolean update(CPersonne cpers,String tel,String mail,String rue,String numRue,String cp,String ville){
		
		try{
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate("UPDATE TPersonne SET"
					+ " tel = '"+tel+"',"
					+ " rue = '"+rue+"',"
					+ " mail ='"+mail+"',"
					+ " numRue ='"+numRue+"',"
					+ " cp='"+cp+"',"
					+ " localite='"+ville+"'"
					+ " WHERE IDPersonne = "+cpers.getIDPersonne()+";");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
}
