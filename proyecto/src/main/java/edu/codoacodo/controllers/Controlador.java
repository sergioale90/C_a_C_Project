package edu.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.codoacodo.infrastructure.IPersistencia;
import edu.codoacodo.infrastructure.persistence.memory.MemoryRepositoryImpl;
import edu.codoacodo.mappers.MapperJson;
import edu.codoacodo.modelos.Orador;

public class Controlador {
    private static final long serialVersionUID = 1L;
    private IPersistencia persistence = new MemoryRepositoryImpl();
    private MapperJson mapper = new MapperJson();
    public Controlador(){

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Orador> lista = persistence.listarOradores();
        String listaUsuariosJson = mapper.toJson(lista);
        response.getWriter().write(listaUsuariosJson);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombreInput");
        String apellido = request.getParameter("apellidoInput");
        String email = request.getParameter("emailInput");
        String tema = request.getParameter("temaInput");
        String fechaAlta = request.getParameter("fechaAltaInput");
        int id = Integer.parseInt(request.getParameter("idInput"));
        boolean estado = Boolean.parseBoolean(request.getParameter("estadoInput"));

        Orador orador = new Orador (nombre, apellido, email, tema, fechaAlta, estado, id);
        persistence.guardar(orador);
        String jsonFake = String.format(
                "{\"id\": \"%s\", \"nombre\": \"%s\", \"apellido\": \"%s\", \"email\": \"%s\", \"tema\": \"%s\", \"fechaAlta\": \"%s\", \"estado\": \"%s\"}",
                orador.getId(), orador.getNombre(), orador.getApellido(), orador.getEmail(), orador.getTema(), orador.getfechaAlta();, orador.isEstado());
        response.getWriter().write(jsonFake);
    }
}
