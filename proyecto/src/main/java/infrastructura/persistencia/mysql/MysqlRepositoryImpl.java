package infrastructura.persistencia.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import infrastructura.IPersistencia;
import modelos.Orador;

public class MysqlRepositoryImpl implements IPersistencia {
    private Connection connection;
    public MysqlRepositoryImpl(){
        connection = ConexionBD.getConnection();
    }

    @Override
    public void guardar(Orador orador) {
        String query = "INSERT INTO oradores (nombre, apellido, email, telefono, tema, estado) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(2, orador.getNombre());
            statement.setString(3, orador.getApellido());
            statement.setString(4, orador.getEmail());
            statement.setString(5, orador.getTelefono());
            statement.setString(6, orador.getTema());
            statement.setBoolean(8, orador.isEstado());
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<Orador> listarOradores() {
        return null;
    }
    @Override
    public Orador getOradorPorId(String id) {
        return null;
    }
    @Override
    public Orador update(String orador) {
        return null;
    }
    @Override
    public void delete(String id) {
    }
}
