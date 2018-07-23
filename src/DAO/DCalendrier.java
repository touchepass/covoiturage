package DAO;

import java.sql.ResultSet;
import java.sql.Statement;

import Classe.*;

public class DCalendrier extends DAO<CCalendrier> {
	
	public CCalendrier find(String nom){
		
		DCategorie dc = new DCategorie();
		CCalendrier cl = null;
		DBalade db = new DBalade();
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from Tcalendrier where nom='"+nom+"';");
			
			if(result.first()) {
				cl = new CCalendrier(	result.getInt("IDCalendrier"),dc.find(result.getInt("IDCategorie")), db.find(result.getInt("IDCalendrier")) , result.getString("nom") );
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cl;
	}
}
