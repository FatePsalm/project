package cn.dingd.dd.common.shiro.fileter;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;

import cn.dingd.dd.biz.backgroud.service.PermissionService;
import cn.dingd.dd.biz.common.entity.MenuInfo;

/**
* @author ZC
* @date 2018年4月24日上午11:05:03
*/
public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {
	//**权限service*/
	private PermissionService permissionService;
	
	public static final String PREMISSION_STRING = "dd_perms[\"{0}\"]";

	/** 记录配置中的过滤链,这个要和配置文件中的名称要一样 */
	public static String filterChainDefinitions = "";

	/**
	 * 初始化设置过滤链
	 */
	@Override
	public void setFilterChainDefinitions(String definitions) {
		filterChainDefinitions = definitions;// 记录配置的静态过滤链
		Map<String, String> otherChains = new LinkedHashMap<String, String>();
		List<MenuInfo> list =  permissionService.permissionList();
		for (MenuInfo resource : list) {
			if (StringUtils.isNotBlank(resource.getUrl()) && StringUtils.isNotBlank(resource.getMenuCode())) {
				otherChains.put(resource.getUrl(), MessageFormat.format(PREMISSION_STRING, resource.getMenuCode()));
			}
		}
		//其他路径设置
		otherChains.put("/**", "anon");
		//加载配置默认的过滤链
		Ini ini = new Ini();
		ini.load(filterChainDefinitions);
		Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
		if (CollectionUtils.isEmpty(section)) {
			section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		}
		// 加上数据库中过滤链
		section.putAll(otherChains);
		Set<String> keySet = section.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next+"="+section.get(next));
			
		}
		setFilterChainDefinitionMap(section);
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

}
