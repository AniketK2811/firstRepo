package com.cjc.app.app.configure;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cjc.app.model.Product;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.cjc.app")
public class AppConfigure {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/vies/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	@Bean
	public DriverManagerDataSource ds() {
	DriverManagerDataSource ds=	new DriverManagerDataSource();
	ds.setDriverClassName("com.mysql.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost:3306/springmvcb04");
	ds.setUsername("root");
	ds.setPassword("root");
	return ds;
	}
	@Bean
	public LocalSessionFactoryBean sf(){
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(ds());
		Properties pr =new Properties();
		pr.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect" );
		pr.setProperty("hibernate.hbm2ddl.auto", "update");
		pr.setProperty("hibernate.show_sql","true" );
		
		sf.setHibernateProperties(pr);
		sf.setAnnotatedClasses(Product.class);
		
		return sf;
	}

}
