/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Gabriel
 */
public class conexion {
    public DriverManagerDataSource Conectar (){
    DriverManagerDataSource dataSource=new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/registro");
    dataSource.setUsername("root");
    dataSource.setPassword("perez12345");
    return dataSource;
    }
    
}
