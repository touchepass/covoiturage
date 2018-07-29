package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Classe.*;

public class DBalade extends DAO<CBalade> {
	
	public ArrayList <CBalade> find(int IDCalendrier) {
		
		ArrayList <CBalade> lst_ba = new ArrayList <CBalade>();
		CBalade ca = null;
		DVehicule de = new DVehicule();
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TBalade where IDBalade in ( select IDBalade from TLigne_TBalade where IDCalendrier="+IDCalendrier+");");
			
			while(result.next()) {
				ca = new CBalade(	result.getInt("IDBalade"),result.getString("rue"),result.getString("numRue"),
									result.getString("localite"), result.getInt("cp"), result.getDate("dateD"),
									result.getInt("forfait"),de.find(result.getInt("IDBalade")));
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
	
	public boolean create(CBalade cb, CCalendrier cc) {
		try{
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			java.sql.Date sqlDate = new java.sql.Date(cb.getDateD().getTime());
			
			String toto = "INSERT INTO TBalade (rue,numRue,localite,cp,dateD,forfait) "+
					" VALUES ('"+cb.getRue()+"','"+cb.getNumRue()+"','"+cb.getLocalite()+"',"+cb.getCp()+",'"+sqlDate+" 00:00:00',"+cb.getForfait()+");" ;
			
			stmt.executeUpdate(
					toto
					);
			
			ResultSet k = stmt.getGeneratedKeys();
			k.next();
			stmt.executeUpdate(
					"INSERT INTO TLigne_TBalade (IDBalade,IDCalendrier) "+
					" VALUES ("+k.getLong(1)+","+cc.getIDCalendrier()+");" 
					);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
}
