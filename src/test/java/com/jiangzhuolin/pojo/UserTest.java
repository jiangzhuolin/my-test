package com.jiangzhuolin.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
//		// 创建 hibernate 配置对象
//		Configuration configuration = new Configuration().configure();
//		// 创建服务注册对象
//		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
//	            .build();
//		Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
//		// SessionFactoryBuilder
//	    SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
//	    SessionFactory sessionFactory = sessionFactoryBuilder.build();
	    
		
		// 在 5.x 版本中，hibernate 采用如下方式获取 sessionFactory
	    // 1. 配置类型安全的准服务注册类，这是当前应用的单例对象，不作修改，所以声明为final
	    // 在 configure("hibernate.cfg.xml") 方法中，如果不指定资源路径，默认在类路径下寻找名为 hibernate.cfg.xml 的文件
	    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	    // 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
	    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
	    /****上面是配置准备，下面开始我们的数据库操作******/
	    Session session = sessionFactory.openSession();//从会话工厂获取一个session

	    Transaction transaction = session.beginTransaction();//开启一个新的事务
	    User user = new User();
	    user.setUsername("test");
	    session.save(user);
	    transaction.commit();//提交事务
	}

}
