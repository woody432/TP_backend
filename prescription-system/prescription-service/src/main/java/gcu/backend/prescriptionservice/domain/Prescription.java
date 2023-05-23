package gcu.backend.prescriptionservice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class Prescription {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescription_num;

    @Column(name = "hospital_num", nullable = false)
    private Long hospital_num;

    @Column(name = "hospital_name", nullable = false)
    private String hospital_name;

    @Column(name = "hospital_phone")
    private String hospital_phone;

    @Column(name = "doctor_name")
    private String doctor_name;



    @Column(name = "patient_name", nullable = false)
    private String patient_name;

    @Column(name = "patient_phone")
    private String patient_phone;

    @Column(name = "disease_name", nullable = false)
    private String disease_name;

    @Builder
    public Prescription(Long hospital_num, String hospital_name, String hospital_phone, String doctor_name, String patient_name, String patient_phone, String disease_name) {
        this.hospital_num = hospital_num;
        this.hospital_name = hospital_name;
        this.hospital_phone = hospital_phone;
        this.doctor_name = doctor_name;
        this.patient_name = patient_name;
        this.patient_phone = patient_phone;
        this.disease_name = disease_name;
    }

    public Long getPrescription_num() {
        return prescription_num;
    }

    public void setPrescription_num(Long prescription_num) {
        this.prescription_num = prescription_num;
    }
}
