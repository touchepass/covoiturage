package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classe.CCategorie;
import Classe.CVtt;

public class DVtt extends DAO<CVtt> {
	
	public CVtt find(Object obj) {
		CCategorie ca = (CCategorie)obj;
		CVtt cv = null;
		
		try {
			Statement stmt = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("select * from TVtt where IDCategorie="+ ca.getIDCategorie());
			//int diamPneu, int IDCategorie, String nom
			if(result.first()) {
				cv = new CVtt(result.getInt("diamPneu"),result.getInt("IDCategorie"), ca.getNom());
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return cv;
	}

	public boolean create(CVtt obj) {
		return false;
	}

	public boolean delete(CVtt obj) {
		return false;
	}

	public boolean update(CVtt obj) {
		return false;
	}

	public ArrayList<CVtt> findAll() {
		return null;
	}
}
