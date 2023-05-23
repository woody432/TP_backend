package gcu.backend.prescriptionservice.controller;

import gcu.backend.prescriptionservice.domain.Prescription;
import gcu.backend.prescriptionservice.repository.PrescriptionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PrescriptionController {
    final PrescriptionRepository prescriptionRepository;
    public PrescriptionController(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @PostMapping("/api/prescription")
    public String create(@RequestBody Prescription prescription) {
        prescriptionRepository.save(prescription);
        return "create ok";
    }

    @GetMapping("/api/prescription/{prescription_id}")
    public Optional<Prescription> show(@PathVariable("prescription_id") Long prescription_id) {
        return prescriptionRepository.findById(prescription_id);
    }

    @GetMapping("/api/prescriptions")
    public List<Prescription> showAll() {
        return prescriptionRepository.findAll();
    }

    @PutMapping("/api/prescription/{prescription_id}")
    public ResponseEntity update(@PathVariable("prescription_id") Long prescription_id, @RequestBody Prescription prescription){
        Optional<Prescription> prescriptionUpdate = prescriptionRepository.findById(prescription_id);
        if (prescriptionUpdate.isPresent()) {
            Prescription _prescription = prescriptionUpdate.get();
            _prescription.setHospital_num(prescription.getHospital_num());
            _prescription.setHospital_name(prescription.getHospital_name());

            _prescription.setHospital_phone(prescription.getHospital_phone());
            _prescription.setDoctor_name(prescription.getDoctor_name());
            _prescription.setPatient_name(prescription.getPatient_name());
            _prescription.setPatient_phone(prescription.getPatient_phone());
            _prescription.setDisease_name(prescription.getDisease_name());

            return new ResponseEntity<>(prescriptionRepository.save(_prescription), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/prescription/{prescription_id}")
    public String delete(@PathVariable("prescription_id") Long prescription_id) {
        prescriptionRepository.deleteById(prescription_id);
        return "delete ok";
    }
}

