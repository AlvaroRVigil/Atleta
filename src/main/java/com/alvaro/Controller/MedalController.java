package com.alvaro.Controller;

        import com.alvaro.Entity.Medal;
        import com.alvaro.Repository.MedalRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/medal")
public class MedalController {

    @Autowired
    private MedalRepository medalRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medal createPlayer(@RequestBody Medal medal) {
        return medalRepository.save(medal);
    }

    @PutMapping
    public Medal updatePlayer(@RequestBody Medal medal) {
        return medalRepository.save(medal);
    }

    @GetMapping
    public List<Medal> findAll() {
        return medalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Medal findById(@PathVariable Long id) {
        Medal medal = medalRepository.findOne(id);
        return medal;
    }
    @DeleteMapping("/{id}")
    public void deleteMedalla(@PathVariable Long id) {
        medalRepository.delete(id);}
}