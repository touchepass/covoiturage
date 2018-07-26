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
				int IDVehicule = result.getInt("IDVehicule");
				CPersonne cp = dp.find(result.getInt("IDPersonne"));
				CMembre cm = dm.find(cp);
				int nbrPlaceAssise = result.getInt("nbrPlaceAssise");
				int nbrPlaceVelo = result.getInt("nbrPlaceVelo");
				String imma = result.getString("imma");
				ArrayList <CMembre> lst = findPassagers(result.getInt("IDVehicule"));
	
				ve = new CVehicule(	IDVehicule, cm, nbrPlaceAssise, nbrPlaceVelo, imma,lst);
				
				lst_ve.add(ve);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			lst_ve = null;
		}
		
		return lst_ve;
	}
	
	public boolean create(int IDPersonne, int nbrPlaceAssise, int nbrPlaceVelo, String imma,int IDBalade) {
		try{
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(
					"INSERT INTO TVehicule (IDPersonne,nbrPlaceAssise,nbrPlaceVelo,imma,IDBalade) "+
					" VALUES ("+IDPersonne+","+nbrPlaceAssise+","+nbrPlaceVelo+",'"+imma+"',"+IDBalade+");" 
					);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public boolean createCoVoiturage(CMembre cm, CVehicule cv) {
		try{
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(
					"INSERT INTO TPassager_TVehicule (IDVehicule,IDPersonne) "+
					" VALUES ("+cv.getIDVehicule()+","+cm.getIDPersonne()+");" 
					);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public ArrayList <CMembre> findPassagers(int IDVehicule){
		DMembre dm = new DMembre();
		DPersonne dp = new DPersonne();
		ArrayList <CMembre> lst_cm = new ArrayList <CMembre>();
		CMembre cm = null;
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TPassager_TVehicule where IDVehicule="+IDVehicule+";");
			
			while(result.next()) {
				cm = dm.find(dp.find(result.getInt("IDPersonne")));
				lst_cm.add(cm);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("erreur dans liste passagers");
			lst_cm = null;
		}
		
		return lst_cm;
	}
}

