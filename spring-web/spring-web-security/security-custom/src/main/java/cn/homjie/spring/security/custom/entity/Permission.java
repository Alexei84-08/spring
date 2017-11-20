package cn.homjie.spring.security.custom.entity;

import java.io.Serializable;

public class Permission implements Serializable {

	private static final long serialVersionUID = 2278405437092693034L;

	private int id;
	private String authority;
	private String name;
	private boolean enabled;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
