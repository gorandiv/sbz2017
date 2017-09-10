package webshop.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.Repository;

import webshop.entity.ActiveUser;

public interface ActiveUserDao extends Repository<ActiveUser, Integer> {
	
		ActiveUser findByUser_UsernameAndUser_Password(String username, String password);

		ActiveUser save(ActiveUser activeUser);
		
		@Transactional
		void removeByUser_Id(Integer id);

}
