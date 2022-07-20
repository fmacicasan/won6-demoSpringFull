package ro.fasttrack.demoSpringFull.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrack.demoSpringFull.domain.Operation;

import java.util.List;

/**
 * @author flo
 * @since 20.07.2022.
 */
@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

    List<Operation> findByOp(String op);

    @Query("select o from Operation o where o.op = ?1")
    List<Operation> findWithCustomQuery(String op);
}
