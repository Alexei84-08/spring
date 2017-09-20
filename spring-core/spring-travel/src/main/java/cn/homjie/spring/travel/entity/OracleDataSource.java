package cn.homjie.spring.travel.entity;

public class OracleDataSource implements DataSource {
	@Override
	public void connect() {
		System.out.println("Oracle connect success");
	}
}
