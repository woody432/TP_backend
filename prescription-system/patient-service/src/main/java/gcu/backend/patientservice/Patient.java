package gcu.backend.patientservice;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity //@Entity 어노테이션을 적용해야 JPA가 엔티티로 인식함.
public class Patient {

    @jakarta.persistence.Id
    @Id //@Id 어노테이션을 선언하면 해당 컬럼이 기본키로 지정. 반드시 필요.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long NO;

    @Column(name = "patient_num", nullable = false)
    private Long patient_num;

    @Column(name = "patient_name", nullable = false)
    private String patient_name;

    @Column(name = "hospital_num", nullable = false)
    private Long hospital_num;

    @Column(name = "hospital_name", nullable = false)
    private String hospital_name;

    @Builder
    public Patient(Long patient_num, String patient_name, Long hospital_num, String hospital_name) {
        this.patient_num = patient_num;
        this.patient_name = patient_name;
        this.hospital_num = hospital_num;
        this.hospital_name = hospital_name;
    }
}

