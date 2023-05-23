package gcu.backend.prescriptionservice.repository;

import gcu.backend.prescriptionservice.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
