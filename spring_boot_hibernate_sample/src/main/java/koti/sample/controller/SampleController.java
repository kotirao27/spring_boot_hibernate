package koti.sample.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import koti.sample.pojo.UserBO;
import koti.sample.processor.SampleProcessor;

@RestController
@RequestMapping(value="/koti")
public class SampleController {

	@Autowired
	private Logger logger = Logger.getLogger(SampleController.class.toString());
	
	@Autowired
	private SampleProcessor processReq;

	// to post data to the service and store in db
	@RequestMapping(path = "/request", method = {RequestMethod.POST,RequestMethod.GET}, consumes = { MediaType.APPLICATION_JSON_VALUE},produces= { MediaType.APPLICATION_JSON_VALUE})
	public void processSampleRequest(@RequestBody UserBO reqObj) {

		try{
			 processReq.processRequest(reqObj);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("Exception Occured "+e.getMessage());
		}
		//return userRes;
	}
	
	// to retreive user based in the param
	@RequestMapping(path = "/request", method = {RequestMethod.POST,RequestMethod.GET}, consumes = { MediaType.APPLICATION_JSON_VALUE},produces= { MediaType.APPLICATION_JSON_VALUE})
	public UserBO processSampleRequestParam(@RequestParam String id) {

		UserBO userRes = null;
		try{
			userRes = processReq.processFetchRequest(id);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("Exception Occured "+e.getMessage());
		}
		return userRes;
}
	
}

