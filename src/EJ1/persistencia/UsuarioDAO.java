package EJ1.persistencia;
import EJ1.entidades.Usuario;
import java.util.ArrayList;
import java.util.Collection;

public final class UsuarioDAO extends DAO {
    public void guardarUsuario(Usuario usuario) throws Exception {

        try{
            if (usuario == null){
                throw new Exception("El usuario no puede ser nulo");
            }

            String sql = "INSERT INTO usuario (correoElectronico, clave)" + " VALUES ('" + usuario.getCorreoElectronico() + "', '" + usuario.getClave() + "')";
            insertarModificarEliminar(sql);

        }catch (Exception e){
            desconectarBase();
            throw e;
        }

    }

    public void modificarUsuario (Usuario usuario) throws Exception {

        try{
            if (usuario == null){
                throw new Exception("Indique el usuario que desea modificar");
            }

            String sql = "UPDATE usuario SET " + "clave = '" + usuario.getClave() + "' WHERE correoElectronico = '" + usuario.getCorreoElectronico() + "'";
            insertarModificarEliminar(sql);

        }catch (Exception e){
            desconectarBase();
            throw e;
        }

    }
    public void eliminarUsuario(String correEletronico) throws Exception {
        try {

            String sql = "DELETE FROM Usuario WHERE correoElectronico = '" + correEletronico + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Usuario buscarUsuarioPorCorreo (String correoElectronico) throws Exception {
        Usuario usuario = null;
        try{
            if (correoElectronico == null){
                throw new Exception("Indique el correo electronico del usuario que desea buscar");
            }

            String sql = "SELECT * FROM usuario WHERE correoElectronico = '" + correoElectronico + "'";
            consultarBase(sql);
            while (resultado.next()){
                usuario = new Usuario();
                usuario.setId(resultado.getInt(1));
                usuario.setCorreoElectronico(resultado.getString(2));
                usuario.setClave(resultado.getString(3));
            }
            desconectarBase();
            return usuario;

        }catch (Exception e){
            throw e;
        }
    }

    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
        try {

            String sql = "SELECT * FROM Usuario "
                    + " WHERE id = '" + id + "'";

            consultarBase(sql);

            Usuario usuario = null;
            while (resultado.next()) {
                usuario = new Usuario();
                usuario.setId(resultado.getInt(1));
                usuario.setCorreoElectronico(resultado.getString(2));
                usuario.setClave(resultado.getString(3));
            }
            desconectarBase();
            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

  public Collection<Usuario> listarUsuarios() throws Exception {
        Collection<Usuario> usuarios = new ArrayList<>();
        try{
            String sql = "SELECT correoElectronico, clave FROM Usuario";
            consultarBase(sql);
            while (resultado.next()){
                Usuario usuario = new Usuario();
                usuario.setCorreoElectronico(resultado.getString("correoElectronico"));
                usuario.setClave(resultado.getString("clave"));
                usuarios.add(usuario);
            }
            desconectarBase();
            return usuarios;

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }


}
