package cn.homjie.spring.security.service;

import cn.homjie.spring.security.ExpressionSecurityConfig;
import cn.homjie.spring.security.domain.Spitter;
import cn.homjie.spring.security.domain.Spittle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExpressionSecurityConfig.class)
public class ExpressionSecuredSpittrServiceSecurityTest extends AbstractUserSecurityTest {

	@Autowired
	private ExpressionSpittleService spittleService;

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
		Spittle spittle = new Spittle(1L, spitter, "Hiya!", new Date());
		spittleService.addSpittle(spittle);
	}

	@Test(expected = AccessDeniedException.class)
	public void testSecuredMethod_withSufficientPrivilegeButLongText() {
		setupUser("ROLE_SPITTER");

		Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "craig@habuma.com", true);
		Spittle spittle = new Spittle(1L, spitter, "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 ", new Date());
		spittleService.addSpittle(spittle);
	}

	@Test
	public void testSecuredMethod_withPremimumPrivilegeAndLongText() {
		setupUser("ROLE_PREMIUM");

		Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "craig@habuma.com", true);
		Spittle spittle = new Spittle(1L, spitter, "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 ", new Date());
		spittleService.addSpittle(spittle);
	}

	@Test
	public void testGetSpittleById_withRightUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(new UsernamePasswordAuthenticationToken("habuma", "123456"));

		Spittle spittle = spittleService.getSpittleById(1);
		Assert.assertNotNull(spittle);
	}

	@Test(expected = AccessDeniedException.class)
	public void testGetSpittleById_withWrongUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(new UsernamePasswordAuthenticationToken("habuma", "123456"));

		spittleService.getSpittleById(2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetSpittleById_withRightUserRtnNull() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(new UsernamePasswordAuthenticationToken("habuma", "123456"));

		// Failed to evaluate expression 'returnObject.spitter.username == principal.username'
		spittleService.getSpittleById(3);
	}

	@Test
	public void testGetOffensiveSpittles_withAdmin() {
		setupUser("ROLE_ADMIN");

		List<Spittle> list = spittleService.getOffensiveSpittles();
		Assert.assertTrue(list.size() == 2);
	}

	@Test
	public void testGetOffensiveSpittles_withSpitter() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(new UsernamePasswordAuthenticationToken("habuma", "123456"));

		List<Spittle> list = spittleService.getOffensiveSpittles();
		Assert.assertTrue(list.size() == 1);
	}

	private List<Spittle> getSpittles() {
		List<Spittle> list = new ArrayList<>();

		Spitter habuma = new Spitter(1L, "habuma", null, "Craig Walls", "craig@habuma.com", true);
		list.add(new Spittle(1L, habuma, "Hiya!", new Date()));
		Spitter lemonguge = new Spitter(2L, "lemonguge", null, "Hom Jie", "lemonguge@gmail.com", true);
		list.add(new Spittle(2L, lemonguge, "Hello!", new Date()));
		return list;
	}

	@Test
	public void testDeleteSpittles_withAdmin() {
		setupUser("ROLE_ADMIN");

		List<Spittle> list = getSpittles();

		spittleService.deleteSpittles(list);
	}

	@Test
	public void testDeleteSpittles_withSpitter() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(new UsernamePasswordAuthenticationToken("habuma", "123456"));

		List<Spittle> list = getSpittles();

		spittleService.deleteSpittles(list);
	}

	@Test
	public void testDeleteSpittles2_withAdmin() {
		setupUser("ROLE_ADMIN");

		List<Spittle> list = getSpittles();

		spittleService.deleteSpittles2(list);
	}

	@Test
	public void testDeleteSpittles2_withSpitter() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(new UsernamePasswordAuthenticationToken("habuma", "123456"));

		List<Spittle> list = getSpittles();

		spittleService.deleteSpittles2(list);
	}

}
