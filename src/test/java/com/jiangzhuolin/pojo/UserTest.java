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
//		// ���� hibernate ���ö���
//		Configuration configuration = new Configuration().configure();
//		// ��������ע�����
//		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
//	            .build();
//		Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
//		// SessionFactoryBuilder
//	    SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
//	    SessionFactory sessionFactory = sessionFactoryBuilder.build();
	    
		
		// �� 5.x �汾�У�hibernate �������·�ʽ��ȡ sessionFactory
	    // 1. �������Ͱ�ȫ��׼����ע���࣬���ǵ�ǰӦ�õĵ������󣬲����޸ģ���������Ϊfinal
	    // �� configure("hibernate.cfg.xml") �����У������ָ����Դ·����Ĭ������·����Ѱ����Ϊ hibernate.cfg.xml ���ļ�
	    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	    // 2. ���ݷ���ע���ഴ��һ��Ԫ������Դ����ͬʱ����Ԫ���ݲ�����Ӧ��һ��Ψһ�ĵ�session����
	    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
	    /****����������׼�������濪ʼ���ǵ����ݿ����******/
	    Session session = sessionFactory.openSession();//�ӻỰ������ȡһ��session

	    Transaction transaction = session.beginTransaction();//����һ���µ�����
	    User user = new User();
	    user.setUsername("test");
	    session.save(user);
	    transaction.commit();//�ύ����
	}

}
