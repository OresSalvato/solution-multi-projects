package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ores.salvato.entities.User;
import org.springframework.stereotype.Repository;

@Repository()
public interface UserRepository extends JpaRepository<User, String> {

}