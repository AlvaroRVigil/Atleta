package com.alvaro.Entity;

        import javax.persistence.*;

@Entity
public class Medal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private MedalType medalType;

    @Column
    public String especialidad;

    @Column
    public String competicion;

    @ManyToOne
    private Athlete athlete;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public MedalType getMedalType() {
        return medalType;
    }
    public void setMedalType(MedalType medalType) {
        this.medalType = medalType;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCompeticion() {
        return competicion;
    }
    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public Athlete getAthlete() {return athlete;}
    public void setAthlete(Athlete athlete) {this.athlete = athlete;}

    @Override
    public String toString() {
        return "Medal{" +
                "id=" + id +
                ", medalType=" + medalType +
                ", especialidad='" + especialidad + '\'' +
                ", competicion='" + competicion + '\'' +
                ", athlete=" + athlete +
                '}';
    }
}
