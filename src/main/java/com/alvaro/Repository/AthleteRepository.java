package com.alvaro.Repository;

import com.alvaro.Entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    public List<Athlete> findByNombre(String nombreAtleta);

    // 1. -------------------------------------------------------------------------------------------------------------
    List<Athlete> findByNacionalidadLike(String nacionalidad);

    // 2. -------------------------------------------------------------------------------------------------------------
    List<Athlete> findByfechaNacimientoLessThan(Date fechaNacimiento);

    // 3. -------------------------------------------------------------------------------------------------------------
    @Query("SELECT athlete " +
            "FROM Athlete athlete")
    List<Athlete> getAthletesGroupByNacionalidad();
}
