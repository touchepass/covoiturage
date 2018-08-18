package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Classe.CBalade;
import Classe.CCalendrier;
import Classe.CCategorie;

public class DCalendrier extends DAO<CCalendrier> {
	
	public CCalendrier find(Object obj){
		
		String nom = (String)obj;
		
		DAO<CCategorie> dc = new DCategorie();
		DAO<CBalade> db = new DBalade();
		CCalendrier cl = null;
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from Tcalendrier where nom='"+nom+"';");
			
			if(result.first()) {
				cl = new CCalendrier(
						result.getInt("IDCalendrier"),
						dc.find(result.getInt("IDCategorie")),
						((DBalade)db).findAll(result.getInt("IDCalendrier")),
						result.getString("nom")
				);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cl;
	}

	
	
	public boolean create(CCalendrier obj) {
		return false;
	}

	public boolean delete(CCalendrier obj) {
		return false;
	}

	public boolean update(CCalendrier cc) {
		try {
			
			String updateStr2 = "DELETE FROM TLigne_TBalade WHERE IDCalendrier = ?";
			PreparedStatement updateStmt2 = this.connect.prepareStatement(updateStr2);
			updateStmt2.setInt(1, cc.getIDCalendrier() );
			updateStmt2.executeUpdate();
			
			
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);			
			for(CBalade cb : cc.getLstBalade() ) {
				stmt.executeUpdate("INSERT INTO TLigne_TBalade (IDBalade,IDCalendrier)  VALUES ("+cb.getIDBalade()+","+cc.getIDCalendrier()+ ");");
			}
			
			
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}

	public ArrayList<CCalendrier> findAll() {
		return null;
	}
	
}
