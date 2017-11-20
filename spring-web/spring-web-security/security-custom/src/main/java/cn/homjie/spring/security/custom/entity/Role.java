package cn.homjie.spring.security.custom.entity;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 3776374111366371757L;

	private int id;
	private String name;
	private boolean enabled;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
