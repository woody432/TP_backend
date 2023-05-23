package gcu.backend.patientservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    final PatientRepository patientRepository;
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostMapping("/api/patient")
    public String create(@RequestBody Patient patient) {
        patientRepository.save(patient);
        return "create ok";
    }

    @GetMapping("/api/patient/{patient_num}")
    public Optional<Patient> show(@PathVariable("patient_num") Long patient_num) {
        return patientRepository.findById(patient_num);
    }


    @GetMapping("/api/patients")
    public List<Patient> showAll() {
        return patientRepository.findAll();
    }

}

