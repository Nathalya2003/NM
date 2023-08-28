package rnml20230828.entidades;

public class Empleados {
    private int Id;
    private String Nombre;
    private String Apellido;
      private String Email;
        private String PuestoEmpleado;

    public Empleados() {
    }

    public Empleados(int Id, String Nombre, String Apellido, String Email, String PuestoEmpleado) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Email = Email;
        this.PuestoEmpleado = PuestoEmpleado;
    }

    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPuestoEmpleado() {
        return PuestoEmpleado;
    }

    public void setPuestoEmpleado(String PuestoEmpleado) {
        this.PuestoEmpleado = PuestoEmpleado;
    }
        
    
}
