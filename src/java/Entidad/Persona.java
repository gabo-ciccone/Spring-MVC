/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Gabriel
 */
public class Persona {
    int id;          //generamos los tipos de datos que tenemos en la base de datos
    String nombre;
    String correo;
    String nacionalidad; 

    public Persona() {   //generar constructor vacio
    }

    public Persona(int id, String nombre, String correo, String nacionalidad) {
        this.id = id;   //generar constructor con los campos referenciados
        this.nombre = nombre;
        this.correo = correo;
        this.nacionalidad = nacionalidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    
    
    
}
