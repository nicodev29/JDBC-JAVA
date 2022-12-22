package EJ1.entidades;
public class Mascota {
    private int id;
    private String apodo;
    private String raza;
    private Usuario usuario;

    public Mascota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String toString() {
        return "Mascota{" + "id=" + id + ", apodo=" + apodo + ", raza=" + raza + ", usuario=" + usuario + '}';
    }

}
