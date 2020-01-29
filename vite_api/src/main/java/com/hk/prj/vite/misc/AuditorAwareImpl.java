package com.hk.prj.vite.misc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.util.ObjectUtils;

import com.hk.prj.vite.model.CustomUserDetails;
import com.hk.prj.vite.service.UserService;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Autowired UserService userService;
	
	@Override
	public String getCurrentAuditor() {
		CustomUserDetails customUserDetails = userService.getLoggedInUser();
		return ObjectUtils.isEmpty(customUserDetails)?"System":customUserDetails.getUserName();
	}

}
