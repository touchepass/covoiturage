package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Classe.CBalade;
import Classe.CVehicule;

public class DBalade extends DAO<CBalade> {
	
	public ArrayList <CBalade> findAll(int IDCalendrier) {
		
		ArrayList <CBalade> lst_ba = new ArrayList <CBalade>();
		DAO<CVehicule> de = new DVehicule();
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TBalade where IDBalade in ( select IDBalade from TLigne_TBalade where IDCalendrier="+IDCalendrier+");");
			
			while(result.next()) {
				CBalade ca = new CBalade(result.getInt("IDBalade"),result.getString("rue"),result.getString("numRue"),
									result.getString("localite"), result.getInt("cp"), result.getDate("dateD"),
									result.getInt("forfait"),
									((DVehicule)de).findAll(result.getInt("IDBalade"))
				);
				
				lst_ba.add(ca);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			lst_ba = null;
		}
		
		return lst_ba;
	}
	
	
	public boolean delete(CBalade obj){
		try{
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate("DELETE FROM TBalade WHERE IDBalade = "+obj.getIDBalade()+";");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public boolean create(CBalade cb) {
		try{
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			java.sql.Date sqlDate = new java.sql.Date(cb.getDateD().getTime());
			
			String toto = "INSERT INTO TBalade (rue,numRue,localite,cp,dateD,forfait) "+
					" VALUES ('"+cb.getRue()+"','"+cb.getNumRue()+"','"+cb.getLocalite()+"',"+cb.getCp()+",'"+sqlDate+" 00:00:00',"+cb.getForfait()+");" ;
			
			stmt.executeUpdate(toto);
			
			
			ResultSet k = stmt.getGeneratedKeys();
			k.next();
			
			
			cb.SetIDBalade( (int)k.getLong(1) );
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	public boolean update(CBalade obj) {
		return false;
	}


	public CBalade find(Object obj) {
		return null;
	}

	public ArrayList<CBalade> findAll() {
		return null;
	}
	
}
