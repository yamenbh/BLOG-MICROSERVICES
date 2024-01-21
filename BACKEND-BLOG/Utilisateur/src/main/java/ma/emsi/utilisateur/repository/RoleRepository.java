package ma.emsi.utilisateur.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.utilisateur.model.ERole;
import ma.emsi.utilisateur.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
