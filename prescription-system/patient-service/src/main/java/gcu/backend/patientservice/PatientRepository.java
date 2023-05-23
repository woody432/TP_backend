package gcu.backend.patientservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

//    @Query(value = "select * from Patient where Patient.patient_num = ?1", nativeQuery = true)
//    Optional<Patient> findByPatient_num(Long patient_num);

//    Patient findByPatient_num(Long patient_num);

//    Optional<Patient> findAllByPatient_num(Long patient_num);
}
