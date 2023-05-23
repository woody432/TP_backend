package gcu.backend.administratorservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


    @RestController
    public class AdministratorController {
        final AdministratorRepository administratorRepository;

        public AdministratorController(AdministratorRepository administratorRepository) {
            this.administratorRepository = administratorRepository;
        }


        @PostMapping("/api/admin")
        public String create(@RequestBody Administrator administrator) {
            administratorRepository.save(administrator);
            return "create ok";
        }

        @GetMapping("/api/admin/{hospital_num}")
        public Optional<Administrator> show(@PathVariable("hospital_num") Long hospital_num) {
            return administratorRepository.findById(hospital_num);
        }

        @GetMapping("/api/admins")
        public List<Administrator> showAll() {
            return administratorRepository.findAll();
        }

        @PutMapping("/api/admin/{hospital_num}")
        public ResponseEntity update(@PathVariable("hospital_num") Long hospital_num, @RequestBody Administrator administrator){
            Optional<Administrator> administratorUpdate = administratorRepository.findById(hospital_num);

            if (administratorUpdate.isPresent()) {
                Administrator _administrator = administratorUpdate.get();

                _administrator.setHospital_name(administrator.getHospital_name());
                _administrator.setHospital_phone(administrator.getHospital_phone());

                _administrator.setDoctor_name(administrator.getDoctor_name());
                _administrator.setMedical_department(administrator.getMedical_department());

                _administrator.setPharmacy_name(administrator.getPharmacy_name());
                _administrator.setPharmacy_phone(administrator.getPharmacy_phone());

                return new ResponseEntity<>(administratorRepository.save(_administrator), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/api/admin/{hospital_num}")
        public String delete(@PathVariable("hospital_num") Long hospital_num) {
            administratorRepository.deleteById(hospital_num);
            return "delete ok";
        }
    }



