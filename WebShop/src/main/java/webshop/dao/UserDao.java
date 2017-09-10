package webshop.dao;

import org.springframework.data.repository.Repository;

import webshop.entity.Buyer;
import webshop.entity.User;

public interface UserDao extends Repository<User, Integer> {

	User findByUsernameAndPassword(String username, String password);

	Buyer findById(Integer buyerId);

}
