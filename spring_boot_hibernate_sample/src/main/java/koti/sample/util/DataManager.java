package koti.sample.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import koti.sample.dao.SampleDAO;


@Component
@Scope(value="singleton")
public class DataManager {
	
	@Autowired(required=true)
	@Qualifier("sampleDao")
	public SampleDAO daoImpl;

	public SampleDAO getDaoImpl() {
		return daoImpl;
	}

	public void setDaoImpl(SampleDAO daoImpl) {
		this.daoImpl = daoImpl;
	}

		
}
