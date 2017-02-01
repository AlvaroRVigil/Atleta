package com.alvaro.Service;

        import com.alvaro.Entity.Athlete;
        import com.alvaro.Repository.AthleteRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.Calendar;
        import java.util.GregorianCalendar;

@Service
@Transactional
public class AthleteService {
    @Autowired
    private AthleteRepository athleteRepository;
    Calendar calendar = GregorianCalendar.getInstance();

    public void registrarAtletas() {
        Athlete athlete1 = new Athlete();
        athlete1.setNombre("Kilian");
        athlete1.setApellidos("Snow");
        calendar.set(1992, Calendar.FEBRUARY, 23);
        athlete1.setFechaNacimiento(calendar.getTime());
        athlete1.setNacionalidad("USA");
        athleteRepository.save(athlete1);

        Athlete athlete2 = new Athlete();
        athlete2.setNombre("Jon");
        athlete2.setApellidos("Magnusson");
        calendar.set(1980, Calendar.JANUARY, 23);
        athlete2.setFechaNacimiento(calendar.getTime());
        athlete2.setNacionalidad("IS");
        athleteRepository.save(athlete2);

        Athlete athlete3 = new Athlete();
        athlete3.setNombre("Alvaro");
        athlete3.setApellidos("Rodriguez");
        calendar.set(1995, Calendar.MAY, 5);
        athlete3.setFechaNacimiento(calendar.getTime());
        athlete3.setNacionalidad("Esp");
        athleteRepository.save(athlete3);

        Athlete athlete4 = new Athlete();
        athlete4.setNombre("Sam");
        athlete4.setApellidos("Tzurit");
        calendar.set(1991, Calendar.AUGUST, 17);
        athlete4.setFechaNacimiento(calendar.getTime());
        athlete4.setNacionalidad("URS");
        athleteRepository.save(athlete4);
    }
}