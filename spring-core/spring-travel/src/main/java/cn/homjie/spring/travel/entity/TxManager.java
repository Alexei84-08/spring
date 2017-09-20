package cn.homjie.spring.travel.entity;

/**
 * 事务管理器
 */
public class TxManager {
	// 只通过接口来表明依赖关系，能够在对象本身毫不知情的情况下，用不同的具体实现进行替换
	private DataSource dataSource;

	public TxManager(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void begin() {
		System.out.println("BEGIN TRANSACTION");
		dataSource.connect();
	}
}
