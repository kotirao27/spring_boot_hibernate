package koti.sample.dao;

import koti.sample.entity.User;

public interface SampleDAO {

	void storeData(Object user);
	
	User fetchUser(String id);
}
