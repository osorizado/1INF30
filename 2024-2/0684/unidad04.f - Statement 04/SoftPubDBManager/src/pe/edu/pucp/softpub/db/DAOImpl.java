package pe.edu.pucp.softpub.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softpub.config.DBManager;

public abstract class DAOImpl {

    protected String nombre_tabla;
    protected Connection conexion;
    protected Statement statement;
    protected ResultSet resultset;

    public DAOImpl(String nombre_tabla) {
        this.nombre_tabla = nombre_tabla;
    }
    
    protected void abrirConexion() throws SQLException {
        this.conexion = DBManager.getInstance().getConnection();
    }
    protected void cerrarConexion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.close();
        }
    }

    protected void iniciarTransaccion() throws SQLException {
        this.conexion = DBManager.getInstance().getConnection();
        this.conexion.setAutoCommit(false);
    }

    protected void comitarTransaccion() throws SQLException {
        this.conexion.commit();
    }

    protected void rollbackTransaccion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.rollback();
        }
    }

    protected Integer ejecutarModificacionesEnBD(String sql) throws SQLException {
        this.statement = this.conexion.createStatement();
        return this.statement.executeUpdate(sql);
    }
    
    protected void ejecutarConsultaEnBD(String sql) throws SQLException {
        this.statement = this.conexion.createStatement();
        this.resultset = this.statement.executeQuery(sql);
    }

    public Integer insertar() {
        Integer resultado = 0;
        try {
            this.iniciarTransaccion();
            String sql = this.generarSQLParaInsercion();
            resultado = this.ejecutarModificacionesEnBD(sql);
            this.comitarTransaccion();
        } catch (SQLException ex) {
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;

    }

    private String generarSQLParaInsercion() {
        String sql = "insert into " + this.nombre_tabla;
        sql = sql.concat(" (");
        sql = sql.concat(this.obtenerListaDeAtributosParaInsert());
        sql = sql.concat(") values(");
        sql = sql.concat(this.obtenerListaDeValoresParaInsert());
        sql = sql.concat(")");
        return sql;
    }

    protected abstract String obtenerListaDeAtributosParaInsert();

    protected abstract String obtenerListaDeValoresParaInsert();

}
