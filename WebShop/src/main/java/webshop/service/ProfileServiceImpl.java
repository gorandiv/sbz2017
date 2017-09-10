package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.dao.ProfileDao;
import webshop.entity.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao profileDao;
	
	@Override
	public Profile getBuyerProfile(Integer buyerId) {
		return profileDao.findByBuyer_Id(buyerId);
	}

}
