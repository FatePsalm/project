package cn.dingd.dd.common.util;

import java.util.ResourceBundle;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis连接
 * 
 * @author XCD
 *
 */
public class RedisClientPool {

	public volatile static JedisPool jedisPool;

	private RedisClientPool() {
	};

	public static JedisPool getInstance() {
		if (jedisPool == null) {
			synchronized (RedisClientPool.class) {
				if (null == jedisPool) {
					// 读取相关的配置
					String redis = null;
					if (Constant.ServerStatus == 1) {
						// 正式服务器
						redis = "redis";
					} else if (Constant.ServerStatus == 2) {
						// 测试服务器
						redis = "redisBack";
					}
					ResourceBundle resourceBundle = ResourceBundle.getBundle(redis);
					JedisPoolConfig jedisPoolConfig = initPoolConfig();
					String host = resourceBundle.getString("redis.ip");
					int port = Integer.parseInt(resourceBundle.getString("redis.port"));
					int timeout = Integer.parseInt(resourceBundle.getString("redis.timeout"));
					String password = resourceBundle.getString("redis.pass");
					// 构造连接池
					jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
				}
			}
		}
		return jedisPool;
	}

	/**
	 * 初始化Jedis <一句话功能简述> <功能详细描述>
	 * 
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private static JedisPoolConfig initPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 控制一个pool最多有多少个状态为idle的jedis实例
		jedisPoolConfig.setMaxIdle(1000);
		// 超时时间
//		// 在borrow一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的；
//		jedisPoolConfig.setTestOnBorrow(true);
//		// 在还会给pool时，是否提前进行validate操作
//		jedisPoolConfig.setTestOnReturn(true);
		return jedisPoolConfig;
	}
}
