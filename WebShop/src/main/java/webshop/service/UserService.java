package webshop.service;

import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> login(String username, String password);

	void logout(Integer id);

}
