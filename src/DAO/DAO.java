package DAO;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO<T> {
	
	protected Connection connect = null;
	
	public DAO(){
		this.connect = DConnection.getInstance();
	}
	
	public abstract boolean create(T obj);	
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find(Object obj);
	
	public abstract ArrayList<T> findAll();

}
