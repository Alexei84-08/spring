package cn.homjie.spring.wiringx.qualifier;

import cn.homjie.spring.wiringx.entity.DataSource;

public class Connection {
	private DataSource dataSource;

	public Connection(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void begin() {
		System.out.println(dataSource.getClass().getSimpleName() + " connect success");
	}
}
