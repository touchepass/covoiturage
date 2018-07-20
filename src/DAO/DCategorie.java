package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classe.CCategorie;
import Classe.CMembre;


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
	
	public ArrayList <CCategorie> find(){
		
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
	
	public ArrayList <CCategorie> find(CMembre cm){
		
		ArrayList <CCategorie> lstCat = new ArrayList <CCategorie>();
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TLigne_TCategorie where IDPersonne="+cm.getIDPersonne());
			
			while(result.next()) {
				CCategorie ca = find(result.getInt("IDCategorie"));
				lstCat.add(ca);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			lstCat = null;
			
		}
		
		return lstCat;
	}
	
	public ArrayList <CCategorie> notFind(CMembre cm){
		
		ArrayList <CCategorie> lstCat = new ArrayList <CCategorie>();
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT * FROM TCategorie WHERE IDCategorie NOT IN( select IDCategorie  FROM TLigne_TCategorie WHERE IDPersonne = "+cm.getIDPersonne()+");");
			
			while(result.next()) {
				CCategorie ca = find(result.getInt("IDCategorie"));
				lstCat.add(ca);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			lstCat = null;
			
		}
		
		return lstCat;
	}
	
	
	
}
