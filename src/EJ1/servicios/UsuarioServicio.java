package EJ1.servicios;
import EJ1.entidades.Usuario;
import EJ1.persistencia.UsuarioDAO;

import java.util.Collection;

public class UsuarioServicio {
    private UsuarioDAO usuarioDAO;

    public UsuarioServicio() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void crearUsuario(String correoElectronico, String clave){

        try {
            //Validamos
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }
            if (correoElectronico.contains("@") == false) {
                throw new Exception("El correo electrónico es incorrecto");
            }
            if (clave == null || clave.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave");
            }
            if (clave.length() < 8) {
                throw new Exception("La clave no puede tener menos de 8 caracteres");
            }
            if (usuarioDAO.buscarUsuarioPorCorreo(correoElectronico)!= null) {
                throw new Exception("Ya existe un usuario con el correo electrónico indicado " + correoElectronico);
            }

            //Creamos el usuario
            Usuario usuario = new Usuario();
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setClave(clave);
            usuarioDAO.guardarUsuario(usuario);
            System.out.println("Se creo correctamente con el siguiente email: " + usuario.getCorreoElectronico());

        }catch (Exception e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
        }
    }


    public void modificarUsuario(String correoElectronico, String claveNueva) throws Exception {

        try{
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }
            if (claveNueva == null || claveNueva.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave nueva");
            }

            //Buscar el usuario
            Usuario usuario = usuarioDAO.buscarUsuarioPorCorreo(correoElectronico);

            //Validar que el usuario exista
            if (usuario == null) {
                throw new Exception("No existe un usuario con el correo electrónico indicado " + correoElectronico);
            }

            //Seteando la nueva clave y modificando el usuario
            usuario.setClave(claveNueva);
            usuarioDAO.modificarUsuario(usuario);
            System.out.println("Se modifico correctamente el usuario con el siguiente email: " + usuario.getCorreoElectronico());


        }catch (Exception e){
            System.out.println("Error al modificar usuario: " + e.getMessage());
        }

    }

    public void eliminarUsuario(String correoElectronico) throws Exception {

        try {
            //Validamos
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }
            usuarioDAO.eliminarUsuario(correoElectronico);
            System.out.println("Se elimino correctamente el usuario con el siguiente email: " + correoElectronico);
        } catch (Exception e) {
            throw e;
        }
    }

    public Usuario buscarUsuarioPorCorreo(String correoElectronico) throws Exception {

        try {
            //Validamos
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }

            Usuario usuario = usuarioDAO.buscarUsuarioPorCorreo(correoElectronico);
            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

    public Usuario buscarUsuarioPorID (Integer id) throws Exception {
        try {
            //Validamos
            if (id == null) {
                throw new Exception("Debe indicar el ID");
            }

            Usuario usuario = usuarioDAO.buscarUsuarioPorId(id);
            System.out.println("El ID n° " + usuario.getId() +  " pertenece al usuario: " + usuario.getCorreoElectronico());
            return usuario;

        } catch (Exception e) {
            throw e;
        }

    }

    public Collection<Usuario> listarUsuarios() throws Exception {
        try {
            Collection<Usuario> usuarios = usuarioDAO.listarUsuarios();
            return usuarios;

        } catch (Exception e) {
            throw e;
        }
    }

}
