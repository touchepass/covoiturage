package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classe.CCategorie;
import Classe.CMembre;
import Classe.CPersonne;

public class DMembre extends DAO<CMembre>{
	
	public CMembre find(Object obj){
		CPersonne cp = (CPersonne)obj;
		
		DAO<CCategorie> dc = new DCategorie();
		
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
				
				ArrayList <CCategorie> lstCat = new ArrayList <CCategorie>();
				
				Statement stmt2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet result2 = stmt2.executeQuery("select * from TLigne_TCategorie where IDPersonne="+cm.getIDPersonne());
				while(result2.next()) {
					CCategorie ca = dc.find(result2.getInt("IDCategorie"));
					lstCat.add(ca);
				}
				
				cm.setLstCat(lstCat);
			}
	
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return cm;
	}
	
	public ArrayList <CMembre> findAll(){
		ArrayList <CMembre> lst = new ArrayList <CMembre>();
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select IDPersonne from TMembre ");
			
			while(result.next()) {
				DAO<CPersonne> dp = new DPersonne();
				
				CPersonne cp = dp.find(result.getInt("IDPersonne"));
				CMembre mb = this.find(cp);
				
				lst.add(mb);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return lst;
	}
	
	public boolean update(CMembre cm){
		
		try{
			String updateStr = "UPDATE TMembre SET payementCotistion = ? WHERE IDPersonne = ?";
			
			PreparedStatement updateStmt = this.connect.prepareStatement(updateStr);
			
			updateStmt.setBoolean(1, cm.getPayementCotistion() );
			updateStmt.setInt(2, cm.getIDPersonne());
			updateStmt.executeUpdate();
			
			// TODO: Faire ça de façon plus propre? Genre supprimer + ajouter celle qui n'ont été modifiée.
			String updateStr2 = "DELETE FROM TLigne_TCategorie WHERE IDPersonne = ?";
			PreparedStatement updateStmt2 = this.connect.prepareStatement(updateStr2);
			updateStmt2.setInt(1, cm.getIDPersonne());
			updateStmt2.executeUpdate();
			
			for(CCategorie ca : cm.getLstCat()) {
				String updateStr3 = "INSERT INTO TLigne_TCategorie (IDPersonne,IDCategorie) VALUES (?,?)";
				PreparedStatement updateStmt3 = this.connect.prepareStatement(updateStr3);
				
				updateStmt3.setInt(1, cm.getIDPersonne());
				updateStmt3.setInt(2, ca.getIDCategorie());
				
				updateStmt3.executeUpdate();
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean create(CMembre cp) {
		try {
			
			DAO<CPersonne> dp = new DPersonne();
			dp.create( (CPersonne)cp );

			String updateStr = "INSERT INTO TMembre (IDPersonne,payementCotistion) VALUES (?,?)";
			
			PreparedStatement updateStmt = this.connect.prepareStatement(updateStr);
			
			updateStmt.setInt(1, cp.getIDPersonne());
			updateStmt.setBoolean(2, false);
	
			updateStmt.executeUpdate();
			
			for(CCategorie ca : cp.getLstCat()) {
				String updateStr2 = "INSERT INTO TLigne_TCategorie (IDPersonne,IDCategorie) VALUES (?,?)";
				PreparedStatement updateStmt2 = this.connect.prepareStatement(updateStr2);
				
				updateStmt2.setInt(1, cp.getIDPersonne());
				updateStmt2.setInt(2, ca.getIDCategorie());
				
				updateStmt2.executeUpdate();
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	public boolean delete(CMembre obj) {
		return false;
	}
	
}
