package DAO;

import java.sql.Connection;

public abstract class DAO<T> {
	
	protected Connection connect = null;
	
	public DAO(){
		this.connect = DConnection.getInstance();
	}
	
	public boolean create(T obj) {
		throw new java.lang.UnsupportedOperationException();
	}
	
	public boolean delete(T obj){
		throw new java.lang.UnsupportedOperationException();
	}
	
	public boolean update(T obj){
		throw new java.lang.UnsupportedOperationException();
	}
	
	public T find(Object obj){
		throw new java.lang.UnsupportedOperationException();
	}


}
