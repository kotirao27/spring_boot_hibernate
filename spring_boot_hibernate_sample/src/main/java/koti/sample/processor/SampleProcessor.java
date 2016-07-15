package koti.sample.processor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import koti.sample.entity.User;
import koti.sample.pojo.UserBO;
import koti.sample.util.DataManager;

@Service
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
public class SampleProcessor {

	@Autowired
	private DataManager dataResouceManager;

	private Logger logger = Logger.getLogger(SampleProcessor.class.toString());

	public void processRequest(UserBO reqObj) throws Exception {
		try {
			if(reqObj != null){
				logger.info("Request Received : "+reqObj.getId() + " "+reqObj.getName());
				User user = new User();
				setBOdatatoEntity(reqObj, user);	
				dataResouceManager.getDaoImpl().storeData(user);
				logger.info("Request stored successfully");
			}
			else{
				logger.info("Request Received is null");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception();
		}
	}

	private void setBOdatatoEntity(UserBO reqObj, User user) {
		user.setId(reqObj.getId());
		user.setName(reqObj.getName());
	}

	public UserBO processFetchRequest(String id) throws Exception {
		try {
			logger.info("Request Received for user id: "+id);
			UserBO userBo = new UserBO();
			if(id != null){
				User user = dataResouceManager.getDaoImpl().fetchUser(id);
				if(user != null){
					setEntitytoBO(user, userBo);
				}
				else{
					logger.info("received null for the requested id : "+ id);	
				}
			}
			return userBo;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception();
		}
	}

	private void setEntitytoBO(User user, UserBO userBo) {
		userBo.setId(user.getId());
		userBo.setName(user.getName());
	}

}
