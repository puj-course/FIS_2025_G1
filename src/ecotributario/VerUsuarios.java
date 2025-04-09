package ecotributario;

import ecotributario.dao.UsuarioDAO;
import ecotributario.model.Usuario;

import java.util.List;

public class VerUsuarios {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.obtenerTodos();

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios en la base de datos.");
        } else {
            System.out.println("Usuarios registrados:");
            for (Usuario u : usuarios) {
                System.out.println("ID: " + u.getIdUsuario());
                System.out.println("Nombre: " + u.getNombre());
                System.out.println("Correo: " + u.getEmail());
                System.out.println("Tipo: " + u.getRol());
                System.out.println("-----------------------------");
            }
        }
    }
}
