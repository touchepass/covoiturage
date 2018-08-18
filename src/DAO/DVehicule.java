package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Classe.CMembre;
import Classe.CPersonne;
import Classe.CVehicule;

public class DVehicule extends DAO<CVehicule>{
	
	public ArrayList <CVehicule> findAll(int IDBalade){
		
		ArrayList <CVehicule> lst_ve = new ArrayList <CVehicule>();
		DAO<CMembre> dm = new DMembre();
		DAO<CPersonne> dp = new DPersonne();
		CVehicule ve = null;
		
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
	
	public boolean create(CVehicule obj) {
		try{
			
			String insertStr = 	"INSERT INTO TVehicule (IDPersonne,nbrPlaceAssise,nbrPlaceVelo,imma,IDBalade)"+
								"VALUES (?,?,?,?,?)";

			PreparedStatement insertStmt = this.connect.prepareStatement(insertStr);
			
			insertStmt.setInt(1, obj.getConducteur().getIDPersonne() );
			
			insertStmt.setInt(2, obj.getNbrPlaceAssise());
			insertStmt.setInt(3, obj.getNbrPlaceVelo());
			insertStmt.setString(4, obj.getImma());
			insertStmt.setInt(5, obj.GetBalade().getIDBalade() );
			
			insertStmt.executeUpdate();

		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public ArrayList <CMembre> findPassagers(int IDVehicule){
		DAO<CMembre> dm = new DMembre();
		DAO<CPersonne> dp = new DPersonne();
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
	
	public boolean delete(CVehicule obj) {
		return false;
	}

	public boolean update(CVehicule cv) {
		
		try{
			
			String updateStr2 = "DELETE FROM TPassager_TVehicule WHERE IDVehicule = ?";
			
			PreparedStatement updateStmt2 = this.connect.prepareStatement(updateStr2);
			updateStmt2.setInt(1, cv.getIDVehicule() );
			updateStmt2.executeUpdate();
			
			for(CPersonne pers : cv.getLstPassager() ) {
			
				String insertStr = 	"INSERT INTO TPassager_TVehicule (IDVehicule,IDPersonne) VALUES (?,?)"; 
	
				PreparedStatement insertStmt = this.connect.prepareStatement(insertStr);
				
				insertStmt.setInt(1, cv.getIDVehicule());
				insertStmt.setInt(2, pers.getIDPersonne());
				
				insertStmt.executeUpdate();
			}

		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	public CVehicule find(Object obj) {
		return null;
	}

	public ArrayList<CVehicule> findAll() {
		return null;
	}
}

