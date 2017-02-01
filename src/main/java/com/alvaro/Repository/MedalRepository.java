package com.alvaro.Repository;

import com.alvaro.Entity.Medal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedalRepository extends JpaRepository<Medal, Long> {
    @Query("SELECT medal " +
            "FROM Medal medal")
    List<Medal> getAthletesGroupByTipoMedalla();
}
