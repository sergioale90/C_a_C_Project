package edu.codoacodo.infrastructure.persistence.memory;

import java.util.ArrayList;

import edu.codoacodo.infrastructure.IPersistencia;
import edu.codoacodo.modelos.Orador;

public class MemoryRepositoryImpl implements IPersistencia {

    private static ArrayList<Orador> bdMemoria = new ArrayList<>();

    @Override
    public void guardar(Orador newOrador) {
        if(MemoryRepositoryImpl.bdMemoria.add(newOrador)) {
            System.out.println("Orador " + newOrador.getApellido()+ " fue grabado exitosamente con el id : " + newOrador.getId() + ", idUUID: " + newOrador.getIdOrador());
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
