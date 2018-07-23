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
	
}
