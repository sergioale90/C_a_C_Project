package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import infrastructura.IPersistencia;
import infrastructura.persistencia.memory.MemoryRepositoryImpl;
import mappers.MapperJson;
import modelos.Orador;

public class Controlador extends HttpServlet {
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

        Orador orador = new Orador (nombre, apellido, email, tema);
        persistence.guardar(orador);
    String usarioJson = mapper.toJson(orador);
    response.getWriter().write(usarioJson);
	}
}
