package infrastructura.persistencia.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetFactory;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import infrastructura.IPersistencia;
import modelos.Orador;

public class MysqlRepositoryImpl implements IPersistencia {
    private Connection connection;
    public MysqlRepositoryImpl(){
        connection = ConexionBD.getConnection();
    }

    @Override
    public void guardar(Orador orador) {
        String query = "INSERT INTO oradores (nombre, apellido, mail, telefono, tema, activo) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, orador.getNombre());
            statement.setString(2, orador.getApellido());
            statement.setString(3, orador.getEmail());
            statement.setString(4, orador.getTelefono());
            statement.setString(5, orador.getTema());
            statement.setBoolean(6, orador.isEstado());
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<Orador> listarOradores() {
        ArrayList<Orador> oradores = new ArrayList<>();
        String query = "SELECT * FROM oradores";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("mail");
                String telefono = resultSet.getString("telefono");
                String tema = resultSet.getString("tema");
                Orador orador = new Orador(nombre, apellido, email, telefono, tema);
                oradores.add(orador);
            }
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return oradores;
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
