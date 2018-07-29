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
	
	public boolean create(CPersonne cp, CCategorie ca) {
		try{
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			java.sql.Date sqlDate = new java.sql.Date(cp.getDateNaissance().getTime());
			
			String toto = "INSERT INTO TPersonne (nom,prenom,dateNaissance,genre,tel,mail,rue,numRue,localite,cp,pseudo,pass) "+
					" VALUES ('"+cp.getNom()+"','"+cp.getPrenom()+"','"+sqlDate+" 00:00:00','"+cp.getGenre()+"','"+cp.getTel()+
					"','"+cp.getMail()+"','"+cp.getRue()+"','"+cp.getNumRue()+"','"+cp.getLocalite()+"','"+cp.getCp()+
					"','"+cp.getPseudo()+"','"+cp.getPass()+"');" ;
			stmt.executeUpdate(toto);
			
			ResultSet k = stmt.getGeneratedKeys();
			k.next();
			
			cp.setIDPersonne((int)k.getLong(1));
			DMembre dm = new DMembre();
			if(!dm.create(ca, cp))
				return false;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
}
