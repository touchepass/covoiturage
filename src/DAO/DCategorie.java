package DAO;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
			System.out.println(e.getMessage());
			ca = null;
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
			System.out.println(e.getMessage());
			ca = null;
		}
		
		return ca;
	}
	
	public ArrayList <CCategorie> findAll(){
		
		ArrayList <CCategorie> lstCat = new ArrayList <CCategorie>();
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TCategorie");
			
			while(result.next()) {
				CCategorie ca = new CCategorie(result.getInt("IDCategorie"),result.getString("nom"));
				lstCat.add(ca);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			lstCat = null;
			
		}
		
		return lstCat;
	}

	public boolean create(CCategorie obj) {
		return false;
	}
	public boolean delete(CCategorie obj) {
		return false;
	}

	public boolean update(CCategorie obj) {
		return false;
	}

	public CCategorie find(Object obj) {
		if( obj instanceof String )
			return find( (String)obj );
		return find( (int)obj );
	}
	
	
	
}
