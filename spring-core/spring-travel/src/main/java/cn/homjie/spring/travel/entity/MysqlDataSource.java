package cn.homjie.spring.travel.entity;

public class MysqlDataSource implements DataSource {
	@Override
	public void connect() {
		System.out.println("Mysql connect success");
	}
}
