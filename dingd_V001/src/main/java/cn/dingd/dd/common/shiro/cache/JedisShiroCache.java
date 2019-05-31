package cn.dingd.dd.common.shiro.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.dingd.dd.common.util.RedisClient;
import cn.dingd.dd.common.util.SerializeUtil;

public class JedisShiroCache<K, V> implements Cache<K, V> {

	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * shiro中缓存数据的前缀
	 */
	private final String REDIS_SHIRO_CACHE = "shiro-cache:";

	private RedisClient cache;
	/**
	 * 缓存对象的名字
	 */
	private String name;

	public JedisShiroCache(String name, RedisClient jedisManager) {
		this.name = name;
		this.cache = jedisManager;
	}

	/**
	 * 保存
	 */
	@Override
	public V put(K key, V value) throws CacheException {
		try {
			cache.set(getByteKey(key), SerializeUtil.serialize(value));
			return value;
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	/**
	 * 获取
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) throws CacheException {
		try {
			if (key == null) {
				return null;
			} else {
				byte[] rawValue = cache.get(getByteKey(key));
				V value = (V) SerializeUtil.unserialize(rawValue);
				return value;
			}
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	/**
	 * 删除
	 */
	@Override
	public V remove(K key) throws CacheException {
		try {
			V previous = get(key);
			cache.del(getByteKey(key));
			return previous;
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	/**
	 * 清空
	 */
	@Override
	public void clear() throws CacheException {
		try {
			String preKey = this.REDIS_SHIRO_CACHE + "*";
			byte[] keysPattern = preKey.getBytes();
			cache.del(keysPattern);
			// cache.flushDB();
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	/**
	 * 缓存对象的个数
	 */
	@Override
	public int size() {
		if (keys() == null)
			return 0;
		return keys().size();
	}

	/**
	 * 所有缓存的key
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<K> keys() {
		try {
			Set<byte[]> keys = cache.keys(this.REDIS_SHIRO_CACHE + "*");
			if (CollectionUtils.isEmpty(keys)) {
				return Collections.emptySet();
			} else {
				Set<K> newKeys = new HashSet<K>();
				for (byte[] key : keys) {
					newKeys.add((K) key);
				}
				return newKeys;
			}
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	/**
	 * 获取所有的缓存数据
	 */
	@Override
	public Collection<V> values() {
		try {
			Set<byte[]> keys = cache.keys(this.REDIS_SHIRO_CACHE + "*");
			if (!CollectionUtils.isEmpty(keys)) {
				List<V> values = new ArrayList<V>(keys.size());
				for (byte[] key : keys) {
					@SuppressWarnings("unchecked")
					V value = get((K) key);
					if (value != null) {
						values.add(value);
					}
				}
				return Collections.unmodifiableList(values);
			} else {
				return Collections.emptyList();
			}
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	public String getName() {
		if (name == null)
			return "";
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * z 获得byte[]型的key
	 * 
	 * @param key
	 * @return
	 */
	private byte[] getByteKey(K key) {
		String preKey = this.REDIS_SHIRO_CACHE + getName() + ":" + key;
		return preKey.getBytes();
	}
}
