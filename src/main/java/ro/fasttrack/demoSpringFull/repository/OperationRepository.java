package ro.fasttrack.demoSpringFull.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrack.demoSpringFull.domain.Operation;

/**
 * @author flo
 * @since 20.07.2022.
 */
@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {
}
