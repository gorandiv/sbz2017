package webshop.dao;

import org.springframework.data.repository.Repository;

import webshop.entity.Profile;

public interface ProfileDao extends Repository<Profile, Integer> {

	Profile findByBuyer_Id(Integer buyerId);

	Profile save(Profile profile);

}
