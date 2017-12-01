package cn.homjie.spring.security.service;

import cn.homjie.spring.security.domain.Spittle;
import org.springframework.security.access.annotation.Secured;

public class SecuredSpittleService implements SpittleService {

	@Override
	@Secured({"ROLE_SPITTER", "ROLE_ADMIN"})
	public void addSpittle(Spittle spittle) {
		System.out.println("Method was called successfully");
	}

}
