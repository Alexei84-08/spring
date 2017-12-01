package cn.homjie.spring.security.service;

import cn.homjie.spring.security.JSR250Config;
import cn.homjie.spring.security.domain.Spitter;
import cn.homjie.spring.security.domain.Spittle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JSR250Config.class)
public class JSR250SpittrServiceSecurityTest extends AbstractUserSecurityTest {

	@Autowired
	private SpittleService spittleService;

	@Before
	public void clearContext() {
		SecurityContextHolder.clearContext();
	}

	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void testSecuredMethod_noCredentials() {
		Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "craig@habuma.com", true);
		Spittle spittle = new Spittle(1L, spitter, "", new Date());
		spittleService.addSpittle(spittle);
	}

	@Test(expected = AccessDeniedException.class)
	public void testSecuredMethod_insufficentPrivilege() {
		setupUser();

		Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "craig@habuma.com", true);
		Spittle spittle = new Spittle(1L, spitter, "", new Date());
		spittleService.addSpittle(spittle);
	}

	@Test
	public void testSecuredMethod_withSufficientPrivilege() {
		setupUser("ROLE_SPITTER");

		Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "craig@habuma.com", true);
		Spittle spittle = new Spittle(1L, spitter, "", new Date());
		spittleService.addSpittle(spittle);
	}

}
