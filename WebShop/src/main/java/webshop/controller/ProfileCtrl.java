package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.entity.Profile;
import webshop.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileCtrl {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping(path = "/get/{buyerId}")
	public Profile getBuyerProfile(@PathVariable("buyerId") Integer buyerId) {
		return profileService.getBuyerProfile(buyerId);
	}

}
