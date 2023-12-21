package infrastructura.persistencia.memory;

import java.util.ArrayList;

import infrastructura.IPersistencia;
import modelos.Orador;

public class MemoryRepositoryImpl implements IPersistencia {
    private static ArrayList<Orador> bdMemoria = new ArrayList<>();

    @Override
    public void guardar(Orador newOrador) {
    if(newOrador != null){
        bdMemoria.add(newOrador);
        System.out.println("Orador guardado exitosamente.");
    } else{
        System.out.println("El orador proporcionado es nulo.");
    }
    }

    @Override
    public ArrayList<Orador> listarOradores() {
        return MemoryRepositoryImpl.bdMemoria;
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
