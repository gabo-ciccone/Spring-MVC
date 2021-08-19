/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entidad.Persona;
import config.conexion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gabriel
 */
@Controller 
public class Controlador {
    conexion con=new conexion();
    JdbcTemplate jdbcTemplate=new JdbcTemplate(con.Conectar());
    ModelAndView mav=new ModelAndView();
    int id; //declaramos la variable id para recibirla cuando se haya seleccionado la opcion de actualizar o eliminar
    List datos; //definimos esta variable global para todos los metodos
    
    @RequestMapping("index.htm") 
    public ModelAndView Listar() {
        String sql="select * from persona";
        datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("index");
        return mav; 
    }
@RequestMapping (value = "agregar.htm", method = RequestMethod.GET) 
public ModelAndView agregar (){
    mav.addObject(new Persona());
    mav.setViewName("agregar"); 
    return mav;
}
@RequestMapping (value = "agregar.htm", method = RequestMethod.POST) 
public ModelAndView agregar (Persona p){ //la clase persona es donde usaremos para agregar o editar valores
    String sql="insert into persona (nombre, correo, nacionalidad) values (?,?,?)";
    this.jdbcTemplate.update(sql, p.getNombre(), p.getCorreo(), p.getNacionalidad());
    return new ModelAndView("redirect:/index.htm");
}

@RequestMapping (value = "editar.htm", method = RequestMethod.GET)
public ModelAndView editar (HttpServletRequest request){ //capturamos el id mediante el url, con una variable tipo httpservlet
id=Integer.parseInt(request.getParameter("id"));
String sql="select * from persona where id="+id; //con esta consulta nos situamos en el id correspondiente al registro
datos=this.jdbcTemplate.queryForList(sql); //recorremos todo el array para verificar los datos
mav.addObject("lista",datos);
mav.setViewName("editar");
return mav;
}

@RequestMapping (value = "editar.htm", method = RequestMethod.POST)
public ModelAndView editar (Persona p){ //con esto accedemos a la clase persona para usar los sets y ggets
    String sql = "update persona set nombre=?, correo=?, nacionalidad=? where id=?";
    this.jdbcTemplate.update(sql, p.getNombre(), p.getCorreo(), p.getNacionalidad(), id);
    return new ModelAndView("redirect:/index.htm"); //despues de insetar los datos nos redirecciona a la pagina principal
}
@RequestMapping (value = "delete.htm") 
public ModelAndView Delete (HttpServletRequest request){ //cachamos el id atraves del tipo de dato httpservlet
    id=Integer.parseInt(request.getParameter("id")); //parseamos el id para convertirlo a entero
    String sql="delete from persona where id="+id; //consulta para borrar 
    this.jdbcTemplate.update(sql);
    return new ModelAndView("redirect:/index.htm"); //cuando termina nos redirecciona a la pagina principal
}
}
