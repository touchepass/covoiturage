package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Classe.CPersonne;

public class DPersonne extends DAO<CPersonne> {
	
	
	public CPersonne find(String pseudo, String pass){
		
		CPersonne p = null;
		String querry;
		try {			
				
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			querry = "select * from TPersonne where pseudo='"+pseudo+"' and pass='"+pass+"'";
			ResultSet result = stmt.executeQuery(querry);
				
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
			querry = " erreur";
		}
		
		//System.out.println(querry);
		return p;
	}
	
	public CPersonne find(String pseudo){
		
		CPersonne p = null;
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TPersonne where pseudo='"+pseudo+"'");
			
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
	
	public boolean update(CPersonne cpers) {
		
		try{
			
			String updateStr ="UPDATE TPersonne SET"
					+ " tel = ?,"
					+ " rue = ?,"
					+ " mail = ?,"
					+ " numRue = ?,"
					+ " cp= ?,"
					+ " localite= ?"
					+ " WHERE IDPersonne = ?;";
			
			PreparedStatement updateStmt = this.connect.prepareStatement(updateStr);
			
			updateStmt.setString(1, cpers.getTel());
			updateStmt.setString(2, cpers.getRue());
			updateStmt.setString(3, cpers.getMail());
			updateStmt.setString(4, cpers.getNumRue());
			updateStmt.setString(5, cpers.getCp());
			updateStmt.setString(6, cpers.getLocalite());
			updateStmt.setInt(7, cpers.getIDPersonne());
	
			updateStmt.executeUpdate();
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	
	public boolean create(CPersonne cp) {
		try{
			
			java.sql.Date sqlDate = new java.sql.Date(cp.getDateNaissance().getTime());
			
			String insertStr = 	"INSERT INTO TPersonne (nom,prenom,dateNaissance,genre,tel,mail,rue,numRue,localite,cp,pseudo,pass) "+
								" VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
			
			PreparedStatement insertStmt = this.connect.prepareStatement(insertStr);
			
			insertStmt.setString(1, cp.getNom());
			insertStmt.setString(2, cp.getPrenom());
			insertStmt.setDate(3, (Date) sqlDate);
			insertStmt.setString(4, cp.getGenre());
			insertStmt.setString(5, cp.getTel());
			insertStmt.setString(6, cp.getMail());
			insertStmt.setString(7, cp.getRue());
			insertStmt.setString(8, cp.getNumRue());
			insertStmt.setString(9, cp.getLocalite());
			insertStmt.setString(10,cp.getCp());
			insertStmt.setString(11,cp.getPseudo() );
			insertStmt.setString(12,cp.getPass());
			
			insertStmt.executeUpdate();
			
			
			ResultSet k = insertStmt.getGeneratedKeys();
			k.next();
			
			cp.setIDPersonne((int)k.getLong(1));
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	public boolean delete(CPersonne obj) {
		return false;
	}

	public CPersonne find(Object obj) {
		if( obj instanceof String )
			return find( (String)obj );
		return find( (int)obj );
	}

	public ArrayList<CPersonne> findAll() {
		return null;
	}
	
}
