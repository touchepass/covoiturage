package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Classe.*;

public class DVehicule extends DAO<CVehicule>{
	
	public ArrayList <CVehicule> find(int IDBalade){
		
		ArrayList <CVehicule> lst_ve = new ArrayList <CVehicule>();
		CVehicule ve = null;
		DMembre dm = new DMembre();
		DPersonne dp = new DPersonne();
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TVehicule where IDBalade="+IDBalade+";");
			
			while(result.next()) {
				ve = new CVehicule(	result.getInt("IDVehicule"),dm.find(dp.find("IDPersonne")),result.getInt("nbrPlaceAssise"),
									result.getInt("nbrPlaceVelo"), result.getString("imma"));
				lst_ve.add(ve);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			lst_ve = null;
		}
		
		return lst_ve;
	}
}

