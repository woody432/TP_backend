package gcu.backend.administratorservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
