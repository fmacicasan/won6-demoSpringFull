package ro.fasttrack.demoSpringFull.dto;

import ro.fasttrack.demoSpringFull.domain.Operation;

/**
 * @author flo
 * @since 22.06.2022.
 */
public record OperationDTO(
        Integer op1,
        String op,
        Integer op2,
        double result
) {
    public OperationDTO(Operation operation) {
        this(operation.getOp1(), operation.getOp(), operation.getOp2(), operation.getResult());
    }
}
