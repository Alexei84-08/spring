package cn.homjie.spring.travel.entity;

/**
 * 数据源
 */
public interface DataSource {

	/**
	 * 获取连接
	 */
	void connect();
}
