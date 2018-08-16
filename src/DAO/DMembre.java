package DAO;

import java.sql.PreparedStatement;
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
			String updateStr = "UPDATE TMembre SET payementCotistion = ? WHERE IDPersonne = ?";
			
			PreparedStatement updateStmt = this.connect.prepareStatement(updateStr);
			
			updateStmt.setBoolean(1, paye);
			updateStmt.setInt(2, cm.getIDPersonne());
	
			updateStmt.executeUpdate();
		
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean create(CCategorie ca, CMembre cm) {
		try{
			String updateStr = "INSERT INTO TLigne_TCategorie (IDPersonne,IDCategorie) VALUES (?,?) ";
			
			PreparedStatement updateStmt = this.connect.prepareStatement(updateStr);
			
			updateStmt.setInt(1, cm.getIDPersonne());
			updateStmt.setInt(2, ca.getIDCategorie());
	
			updateStmt.executeUpdate();
	
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	
	public boolean create(CCategorie ca, CPersonne cp) {
		try{
			String updateStr = "INSERT INTO TMembre (IDPersonne,payementCotistion) VALUES (?,?)";
			
			PreparedStatement updateStmt = this.connect.prepareStatement(updateStr);
			
			updateStmt.setInt(1, cp.getIDPersonne());
			updateStmt.setBoolean(2, false);
	
			updateStmt.executeUpdate();
			
			String updateStr2 = "INSERT INTO TLigne_TCategorie (IDPersonne,IDCategorie) VALUES (?,?)";
			PreparedStatement updateStmt2 = this.connect.prepareStatement(updateStr2);
			
			updateStmt2.setInt(1, cp.getIDPersonne());
			updateStmt2.setInt(2, ca.getIDCategorie());
			
			updateStmt2.executeUpdate();
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
}
