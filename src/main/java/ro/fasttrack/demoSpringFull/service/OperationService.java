package ro.fasttrack.demoSpringFull.service;

import org.springframework.stereotype.Service;
import ro.fasttrack.demoSpringFull.domain.Operation;
import ro.fasttrack.demoSpringFull.dto.OperationDTO;
import ro.fasttrack.demoSpringFull.repository.OperationRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author flo
 * @since 22.06.2022.
 */
@Service
public class OperationService {
    // three layers architecture
    // 1. web layer: servlets
    // 2. service layer: business logic (calculul operatilor)
    // 3. database/repository/infrastrature layer:  interact with DB
    // 2 & 3 use the domain objects

    private OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public List<OperationDTO> listOperations() {
        List<OperationDTO> operations = new ArrayList<>();
        for (Operation operation : operationRepository.findAll()) {
            operations.add(new OperationDTO(operation));
        }
        return operations;
    }

    public double performOperation(String sNr1, String sOp, String sNr2) {
        int nr1 = Integer.parseInt(sNr1);
        int nr2 = Integer.parseInt(sNr2);


        // do the work (apply the operation)
        double resultValue=0;
        //save history
        String operation = nr1 + " " + sOp + " " + nr2;
        MyOperation performedOperation;
        System.out.println(operation);
        switch (sOp) {
            case "+":
                performedOperation = Integer::sum;
                break;
            case "-":
                performedOperation = (a, b) -> a - b;
                break;
            case "*":
                performedOperation = (a, b) -> a * b;
                break;
            case "/":
                performedOperation = (n1, n2) -> (double) n1 / n2;
                break;
            case "%":
                performedOperation = (a, b) -> a % b;
                break;
            default:
                System.out.println("Operation not supported " + sOp);
                throw new OperationNotSupported(sOp);
        }
        resultValue = performedOperation.doOp(nr1, nr2);

        operationRepository.save(new Operation(nr1, sOp, nr2, resultValue));
        return resultValue;
    }
}
