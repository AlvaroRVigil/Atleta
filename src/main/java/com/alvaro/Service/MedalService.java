package com.alvaro.Service;

        import com.alvaro.Entity.Athlete;
        import com.alvaro.Entity.Medal;
        import com.alvaro.Entity.MedalType;
        import com.alvaro.Repository.AthleteRepository;
        import com.alvaro.Repository.MedalRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedalService {
    @Autowired
    private MedalRepository medalRepository;
    @Autowired
    private AthleteRepository athleteRepository;

    public void registrarMedallas() {
        Athlete athlete;
        Medal medal1 = new Medal();
        medal1.setMedalType(MedalType.ORO);
        medal1.setEspecialidad("200m lisos");
        medal1.setCompeticion("JJ.OO. Rio 2016");
        athlete = athleteRepository.findByNombre("Alvaro").get(0);
        medal1.setAthlete(athlete);
        medalRepository.save(medal1);

        Medal medal2 = new Medal();
        medal2.setMedalType(MedalType.PLATA);
        medal2.setEspecialidad("Pertiga");
        medal2.setCompeticion("JJ.OO. Rio 2016");
        athlete = athleteRepository.findByNombre("Jon").get(0);
        medal2.setAthlete(athlete);
        medalRepository.save(medal2);

        Medal medal3 = new Medal();
        medal3.setMedalType(MedalType.BRONZE);
        medal3.setEspecialidad("Martillo");
        medal3.setCompeticion("JJ.OO. Rio 2016");
        athlete = athleteRepository.findByNombre("Kilian").get(0);
        medal3.setAthlete(athlete);
        medalRepository.save(medal3);

        Medal medal4 = new Medal();
        medal4.setMedalType(MedalType.FUERADEPODIUM);
        medal4.setEspecialidad("110m vallas");
        medal4.setCompeticion("JJ.OO. Rio 2016");
        athlete = athleteRepository.findByNombre("Sam").get(0);
        medal4.setAthlete(athlete);
        medalRepository.save(medal4);
    }
}