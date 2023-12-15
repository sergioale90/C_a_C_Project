package edu.codoacodo.mappers;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.codoacodo.modelos.Orador;

public class MapperJson {
    ObjectMapper mapper;

    public MapperJson() {
        this.mapper = new ObjectMapper();
    }
    public String toJson(Orador orador) {
        try {
            return mapper.writeValueAsString(orador);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String toJson(ArrayList<Orador> listaOradores) {
        StringBuilder listaOradoresString = new StringBuilder();
        for (int i = 0; i < listaOradores.size(); i++) {
            try {
                listaOradoresString.append(mapper.writeValueAsString(listaOradores.get(i)));
                if (i < listaOradores.size() - 1) {
                    listaOradoresString.append(",");
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return "[" + listaOradoresString.toString() + "]";
    }
}
