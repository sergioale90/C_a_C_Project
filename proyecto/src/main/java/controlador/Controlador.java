package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import infrastructura.IPersistencia;
import infrastructura.persistencia.mysql.MysqlRepositoryImpl;
import mappers.MapperJson;
import modelos.Orador;

@WebServlet("/endpoint")
public class Controlador extends HttpServlet {
        private static final long serialVersionUID = 1L;
    private IPersistencia persistence = new MysqlRepositoryImpl();
    private MapperJson mapper = new MapperJson();
    public Controlador(){
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Orador> lista = persistence.listarOradores();
        String listaUsuariosJson = mapper.toJson(lista);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(listaUsuariosJson);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombreInput");
        String apellido = request.getParameter("apellidoInput");
        String email = request.getParameter("emailInput");
        String telefono = request.getParameter("telefonoInput");
        String tema = request.getParameter("temaInput");

        Orador orador = new Orador (nombre, apellido, email, telefono, tema);
        persistence.guardar(orador);
        String usarioJson = mapper.toJson(orador);
        response.getWriter().write(usarioJson);
	}
}
