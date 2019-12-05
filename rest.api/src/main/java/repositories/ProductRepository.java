package repositories;

import com.ores.salvato.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface ProductRepository extends JpaRepository<Product, String> {


}
