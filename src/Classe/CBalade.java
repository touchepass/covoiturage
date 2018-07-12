package Classe;

import java.util.ArrayList;
import java.util.Date;

public class CBalade {
	
	private int IDBalade;
	private String rue;
	private String numRue;
	private String localite;
	private int cp;
	private Date dateD;
	private int forfait;
	private ArrayList<CVehicule> lstVehicule;
	
	// Constructeurs
	
	public CBalade(String rue, String numRue, String localite, int cp, Date dateD, int forfait) {
		
		this.rue = rue;
		this.numRue = numRue;
		this.localite = localite;
		this.cp = cp;
		this.dateD = dateD;
		this.forfait = forfait;
		lstVehicule = new ArrayList<CVehicule>();
	}
	
	public CBalade(int IDBalade, String rue, String numRue, String localite, int cp, Date dateD, int forfait) {
		
		this.IDBalade = IDBalade;
		this.rue = rue;
		this.numRue = numRue;
		this.localite = localite;
		this.cp = cp;
		this.dateD = dateD;
		this.forfait = forfait;
		lstVehicule = new ArrayList<CVehicule>();
	}
	
	public CBalade() {}
	
	// Accesseurs
	
	public int getIDBalade() {
		return IDBalade;
	}
	
	public String getRue() {
		return rue;
	}
	
	public String getNumRue() {
		return numRue;
	}
	
	public String getLocalite() {
		return localite;
	}
	
	public int getCp() {
		return cp;
	}
	
	public Date getDateD() {
		return dateD;
	}
	
	public int getForfait() {
		return forfait;
	}
	
	public ArrayList<CVehicule> getLstVehicule(){
		return lstVehicule;
	}
	
}
