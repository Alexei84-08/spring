package cn.homjie.spring.security.database;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordEncoderTest {

	public static void main(String[] args) {
		StandardPasswordEncoder passwordEncoder = new StandardPasswordEncoder("53cr3t");
		System.out.println(passwordEncoder.encode("123456"));
		System.out.println(passwordEncoder.encode("123456"));
		// 可以发现加密后的密码不一样
	}
}
