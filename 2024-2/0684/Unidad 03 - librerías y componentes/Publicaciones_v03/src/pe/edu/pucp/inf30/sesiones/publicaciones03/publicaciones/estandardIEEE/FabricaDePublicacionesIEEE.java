package pe.edu.pucp.inf30.sesiones.publicaciones03.publicaciones.estandardIEEE;

import pe.edu.pucp.inf30.sesiones.publicaciones03.publicaciones.Clase_de_Tesis;
import pe.edu.pucp.inf30.sesiones.publicaciones03.publicaciones.FabricaDePublicaciones;
import pe.edu.pucp.inf30.sesiones.publicaciones03.publicaciones.Publicacion;

public class FabricaDePublicacionesIEEE extends FabricaDePublicaciones {

    @Override
    public Publicacion crearArticulo(String nombre, String nombre_completo_autor, Integer año, String revista, Integer volumen, Integer numero, String mes) {
        return new Articulo(nombre, nombre_completo_autor, año, revista, volumen, numero, mes);
    }

    @Override
    public Publicacion crearArticulo(String nombre, String[] nombres_completos_autores, Integer año, String revista, Integer volumen, Integer numero, String mes) {
        return new Articulo(nombre, nombres_completos_autores, año, revista, volumen, numero, mes);
    }

    @Override
    public Publicacion crearLibro(String nombre, String nombre_completo_autor, Integer año, String edicion, String lugar, String editorial) {
        return new Libro(nombre, nombre_completo_autor, año, edicion, lugar, editorial);
    }

    @Override
    public Publicacion crearLibro(String nombre, String[] nombres_completos_autores, Integer año, String edicion, String lugar, String editorial) {
        return new Libro(nombre, nombres_completos_autores, año, edicion, lugar, editorial);
    }

    @Override
    public Publicacion crearTesis(String nombre, String nombre_completo_autor, Integer año, Clase_de_Tesis clase, String departamento, String institucion, String ciudad, String estado) {
        return new Tesis(nombre, nombre_completo_autor, año, clase, departamento, institucion, ciudad, estado);
    }

    @Override
    public Publicacion crearTesis(String nombre, String[] nombres_completos_autores, Integer año, Clase_de_Tesis clase, String departamento, String institucion, String ciudad, String estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
