package gcu.backend.administratorservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity //@Entity 어노테이션을 적용해야 JPA가 엔티티로 인식함.
public class Administrator {

    @jakarta.persistence.Id
    @Id //@Id 어노테이션을 선언하면 해당 컬럼이 기본키로 지정. 반드시 필요.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long hospital_num;

    @Column(name = "hospital_name", nullable = false)
    private String hospital_name;

    @Column(name = "hospital_phone", nullable = false)
    private String hospital_phone;

    @Column(name = "doctor_name", nullable = false)
    private String doctor_name;

    @Column(name = "medical_department", nullable = false)
    private String medical_department;



    @Column(name = "pharmacy_name", nullable = false)
    private String pharmacy_name;

    @Column(name = "pharmacy_phone", nullable = false)
    private String pharmacy_phone;

    @Builder
    public Administrator(String hospital_name, String hospital_phone, String doctor_name, String medical_department, String pharmacy_name, String pharmacy_phone) {
        this.hospital_name = hospital_name;
        this.hospital_phone = hospital_phone;
        this.doctor_name = doctor_name;
        this.medical_department = medical_department;
        this.pharmacy_name = pharmacy_name;
        this.pharmacy_phone = pharmacy_phone;
    }
}

