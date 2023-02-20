package edu.prestamosVista.aplicacion;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import edu.prestamosVista.aplicacion.dal.Alumnos;

/**
 * Definición de la configuración del contexto general de la aplicación
 *
 */
@Configuration
@ComponentScan
//Con esta etiqueta añadimos el archivos de propiedades
@PropertySource("classpath:propiedadesBD.properties")
//Con esta etiqueta indicamos el paquete del repositorio
@EnableJpaRepositories("edu.prestamosVista.aplicacion.dal")
public class AplicacionConfiguracionContexto {
	
	@Autowired 
    private Environment env;
    
 	//Establecemos la conexion pasandole las propiedades desde el archivo propiedadesBD.properties
 	//el cual hemos creado a mano. 
    @Bean
    public DataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }
    
    //Configuracion del EntityManagerFactory
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        //Con esto extraemos el nombre del paquete donde este el EntityManager
        emf.setPackagesToScan(Alumnos.class.getPackage().getName());
        //emf.setPackagesToScan("edu.deVistaaBD.aplicacion.dal");
        
        HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
        //Para que funcione el Database 
        hibernateJpa.setDatabase(Database.POSTGRESQL);
        hibernateJpa.setDatabasePlatform(env.getProperty("hibernate.dialect"));
        hibernateJpa.setGenerateDdl(env.getProperty("hibernate.generateDdl", Boolean.class));
        hibernateJpa.setShowSql(env.getProperty("hibernate.show_sql", Boolean.class));       
        emf.setJpaVendorAdapter(hibernateJpa);
        
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        jpaProperties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        emf.setJpaProperties(jpaProperties);
        
        return emf;
    }
    
    //Configuracion de las transacciones
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager txnMgr = new JpaTransactionManager();
        txnMgr.setEntityManagerFactory(entityManagerFactory().getObject());
        return txnMgr;
    }
}
