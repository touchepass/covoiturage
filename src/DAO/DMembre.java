package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Classe.*;

public class DMembre extends DAO<CMembre>{
	
	public CMembre find(CPersonne cp){
		
		CMembre cm = null; 
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TMembre where IDPersonne="+cp.getIDPersonne());
			
			if(result.first()) {
				cm = new CMembre(	result.getBoolean("payementCotistion"),cp.getIDPersonne(),
									cp.getNom(), cp.getPrenom(), cp.getDateNaissance(),
									cp.getGenre(), cp.getTel(), cp.getMail(),
									cp.getRue(), cp.getNumRue(), cp.getLocalite(),
									cp.getCp(), cp.getPseudo(), cp.getPass());
			}
	
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return cm;
	}
	
	public ArrayList <CMembre> findCotisationImpaye(){
		ArrayList <CMembre> lstCotisationImpaye = new ArrayList <CMembre>();
		CMembre cm = null; 
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TMembre where payementCotistion='false'");
			
			while(result.next()) {
				DPersonne dp = new DPersonne();
				CPersonne cp = dp.find(result.getInt("IDPersonne"));
				cm = new CMembre(	result.getBoolean("payementCotistion"),cp.getIDPersonne(),
									cp.getNom(), cp.getPrenom(), cp.getDateNaissance(),
									cp.getGenre(), cp.getTel(), cp.getMail(),
									cp.getRue(), cp.getNumRue(), cp.getLocalite(),
									cp.getCp(), cp.getPseudo(), cp.getPass());
				lstCotisationImpaye.add(cm);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return lstCotisationImpaye;
	}
	
	public boolean updateCotisation(CMembre cm, boolean paye){
		
		try{
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate("UPDATE TMembre SET"
					+ " payementCotistion = "+paye
					+ " WHERE IDPersonne = "+cm.getIDPersonne()+";");
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean create(CCategorie ca, CMembre cm) {
		try{
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(
					"INSERT INTO TLigne_TCategorie (IDPersonne,IDCategorie) "+
					" VALUES ("+cm.getIDPersonne()+","+ca.getIDCategorie()+");" 
					);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
}
