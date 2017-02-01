package com.alvaro.Controller;


        import com.alvaro.Entity.Athlete;
        import com.alvaro.Entity.MedalType;
        import com.google.common.collect.ArrayListMultimap;
        import com.google.common.collect.ListMultimap;
        import com.alvaro.Repository.AthleteRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.format.annotation.DateTimeFormat;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;

        import java.util.*;

        import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/athlet")
public class AthleteController {

    @Autowired
    private AthleteRepository athleteRepository;

    @GetMapping
    public List<Athlete> findAll() {
        return athleteRepository.findAll();
    }

    @PutMapping
    public Athlete updateAthlete(@RequestBody Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Athlete createAthlete(@RequestBody Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    @GetMapping("/{id}")
    public Athlete findById(@PathVariable Long id) {
        Athlete athlete = athleteRepository.findOne(id);
        return athlete;
    }

    @DeleteMapping("/{id}")
    public void deleteAthlete(@PathVariable Long id) {
        athleteRepository.delete(id);}


    // 1 ---------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/nacionaliadLike/{nacionalidad}")
    public List<Athlete> findByNacionalidadLike(@PathVariable String nacionalidad) {
        return athleteRepository.findByNacionalidadLike(nacionalidad);
    }

    /* 2 ---------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/fechaNacimientoBefore/{fechaNacimiento}")
    public List<Atleta> findByfechaNacimientoBefore(@PathVariable("fechaNacimiento") LocalDate fechaNacimiento) {
        return atletaRepository.findByFechaNacimientoBefore(fechaNacimiento);
    }
     */

    // 3 ---------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/GroupByNacionalidad")
    public Map<String, List<Athlete>> getAtletaByNacionalidad(){
        return athleteRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(Athlete::getNacionalidad));
    }
    // 4 ---------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/groupByTipoMedalla")
    public Map<MedalType, List<Athlete>> getAtletasGroupByTipoMedalla(){
        return athleteRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(athlete -> {
                    if(athlete.getMedals().stream().anyMatch(medalla -> medalla.getMedalType() == MedalType.ORO)){
                        return MedalType.ORO;
                    }else if(athlete.getMedals().stream().anyMatch(medalla -> medalla.getMedalType() == MedalType.PLATA)){
                        return MedalType.PLATA;
                    }else if(athlete.getMedals().stream().anyMatch(medalla -> medalla.getMedalType() == MedalType.BRONZE)){
                        return MedalType.BRONZE;
                    }else {
                        return MedalType.FUERADEPODIUM;
                    }
                }));
    }
}