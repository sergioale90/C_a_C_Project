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
        String query = "INSERT INTO oradores (nombre, apellido, email, tema, estado) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, orador.getNombre());
            statement.setString(2, orador.getApellido());
            statement.setString(3, orador.getEmail());
            statement.setString(4, orador.getTema());
            statement.setBoolean(6, orador.isEstado());
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
