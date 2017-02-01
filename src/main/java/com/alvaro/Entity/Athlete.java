package com.alvaro.Entity;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import javax.persistence.*;
        import java.util.Date;
        import java.util.HashSet;
        import java.util.Set;

@Entity
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Long id;

    @Column
    public String nombre;

    @Column
    public String apellidos;

    @Column
    public String nacionalidad;

    @Column
    public Date fechaNacimiento;

    @JsonIgnore
    @OneToMany(mappedBy = "athlete")
    private Set<Medal> medals = new HashSet<>();

    public Athlete() {}

    public Athlete(String nombre, String apellidos, String nacionalidad, Date cumple) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = cumple;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellidos() {return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}

    public String getNacionalidad() {return nacionalidad;}
    public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}

    public Date getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(Date fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public Set<Medal> getMedals() {return medals;}
    public void setMedals(Set<Medal> medal) {this.medals = medal;}


    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}