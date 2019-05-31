

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wh.warehouse.department.dao.DepartmentDao;
import cn.wh.warehouse.department.entity.Department;
import cn.wh.warehouse.echarts.dao.EchartsDao;
import cn.wh.warehouse.echarts.entity.SendPeople;
import cn.wh.warehouse.project.dao.ProjectDao;
import cn.wh.warehouse.project.entity.Project;



public class TestProjectDao {
	private ClassPathXmlApplicationContext context;
	@Test
	public void test4() throws ParseException{
		String  st1="hello";
		String  st2="he"+new String("llo");
		System.err.println(st1==st2);
	}
	@Test
	public void test7() throws ParseException{
		context=	new ClassPathXmlApplicationContext("spring-mvc.xml",
				"spring-pool.xml","spring-mybatis.xml");
		EchartsDao echartsDao=(EchartsDao) context.getBean("echartsDao");
		Integer integer=echartsDao.getCount();
		System.out.println("缁翠慨鏁版嵁="+integer);
		
		
	}
	@Test
	public void test6() throws ParseException{
		context=	new ClassPathXmlApplicationContext("spring-mvc.xml",
				"spring-pool.xml","spring-mybatis.xml");
		EchartsDao echartsDao=(EchartsDao) context.getBean("echartsDao");
		List<SendPeople> list=echartsDao.getSendPeople();
		System.out.println("缁翠慨鏁版嵁="+list);
		
		
	}
	@Test
	public void test5() throws ParseException{
		context=	new ClassPathXmlApplicationContext("spring-mvc.xml",
				"spring-pool.xml","spring-mybatis.xml");
		ProjectDao projectDao=(ProjectDao) context.getBean("projectDao");
		double cost=projectDao.getSumCost(null);
		int rowCount=projectDao.getRowCount(new Project());
		System.out.println(cost);
		
		
	}
	@Test
	public void test3() throws ParseException{
	context=	new ClassPathXmlApplicationContext("spring-mvc.xml",
			"spring-pool.xml","spring-mybatis.xml");
	ProjectDao projectDao=(ProjectDao) context.getBean("projectDao");
	Project project=new Project();
	project.setId(2);
	Project GetProject=projectDao.FindById(project);
	System.out.println(GetProject);
	}
	@Test
	public void test1() throws ParseException{
	context=	new ClassPathXmlApplicationContext("spring-mvc.xml",
			"spring-pool.xml","spring-mybatis.xml");
	DepartmentDao departmentDao=(DepartmentDao) context.getBean("departmentDao");
	List<Department> list=departmentDao.GetDepartment();
	for(Department e:list){
		
		System.out.println("ID="+e.getDepartment_name());
	}
	}
	
	@Test
	public void tesrInsertObject() throws ParseException{
	context=	new ClassPathXmlApplicationContext("spring-mvc.xml",
			"spring-pool.xml","spring-mybatis.xml");
	ProjectDao projectDao=(ProjectDao) context.getBean("projectDao");
	Project project=new Project();
	project.setType("锟斤拷锟�");
	projectDao.saveObject(project);
	}
	@After
	public void destory(){
		context.close();
	}
}













