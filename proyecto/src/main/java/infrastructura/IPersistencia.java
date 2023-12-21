package infrastructura;

import java.util.ArrayList;

import modelos.Orador;

public interface IPersistencia {
    // CRUD //
    // CREATE
    void guardar(Orador newOrador);
    // READ
    ArrayList<Orador> listarOradores();
    Orador getOradorPorId(String id);
    // UPDATE
    Orador update(String orador);
    // DELETE
    void delete(String id);
}
