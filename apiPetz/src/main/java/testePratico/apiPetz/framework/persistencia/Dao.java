package testePratico.apiPetz.framework.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Dao<E, ID> extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {

}
