package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import webshop.dao.ActiveUserDao;
import webshop.dao.UserDao;
import webshop.entity.ActiveUser;
import webshop.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ActiveUserDao activeUserDao;

	@Override
	public ResponseEntity<?> login(String username, String password) {

		ActiveUser activeUser = activeUserDao.findByUser_UsernameAndUser_Password(username, password);

		if (activeUser != null) {
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(activeUser.getUser());
		}

		User user = userDao.findByUsernameAndPassword(username, password);

		if (user == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN)
					.body("User with that username and password doesn't exist.");
		}

		activeUserDao.save(new ActiveUser(user));

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(user);
	}

	@Override
	public void logout(Integer id) {
		activeUserDao.removeByUser_Id(id);
	}

}
