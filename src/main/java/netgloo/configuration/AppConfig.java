package netgloo.configuration;

import java.util.Locale;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@EnableAutoConfiguration
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
//		resolver.setViewClass(JstlView.class);
		return resolver;
	}
//	
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	} 
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
//		interceptor.setParamName("language");
//		registry.addInterceptor(interceptor);
//	}
//
//	
//	
//	// Maps resources path to webapp/resources
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	}
////
////	@Bean(name = "dataSource")
////	public DriverManagerDataSource dataSource() {
////		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
////		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
////		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/carsystem");
////		driverManagerDataSource.setUsername("davitko");
////		driverManagerDataSource.setPassword("MojLaptopn75");
////		return driverManagerDataSource;
////	}
////	  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws ClassNotFoundException {
////		return null;}
////
//	@Bean
//	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasename("/WEB-INF/messages/messages");
//		messageSource.setDefaultEncoding("UTF-8");
//		return messageSource;
//	}
//	@Bean
//	public LocaleResolver localeResolver(){
//		CookieLocaleResolver resolver = new CookieLocaleResolver();
//		resolver.setDefaultLocale(new Locale("en"));
//		resolver.setCookieName("myLocaleCookie");
//		resolver.setCookieMaxAge(4800);
//		return resolver;
//	}
	
	
//	@Bean
//	public DataSource dataSource() {
//	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
//	    dataSource.setUrl("jdbc:hsqldb:mem:testdb");
//	    dataSource.setUsername("sa");
//	    dataSource.setPassword("");
//	    return dataSource;
//	}
//
//	@Bean
//	public EntityManager entityManager() {
//	    return entityManagerFactory().getObject().createEntityManager();
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//	    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//	    em.setDataSource(dataSource());
//	    em.setPackagesToScan("com.repository");
//	    return em;
//	}
}
