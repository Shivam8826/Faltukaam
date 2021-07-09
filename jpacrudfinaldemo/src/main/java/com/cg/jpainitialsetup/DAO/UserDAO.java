package com.cg.jpainitialsetup.DAO;

import java.util.List;


public interface UserDAO {
public void save(User user);
	
	public List<User> findAll();
	
	public void update(User user);
	
	public void delete(int id);
}
