package ro.fasttrack.demoSpringFull.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrack.demoSpringFull.dto.OperationDTO;
import ro.fasttrack.demoSpringFull.service.OperationService;

import java.util.List;

/**
 * @author flo
 * @since 20.07.2022.
 */
@RestController
public class OperationController {

    private OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/operations")
    public List<OperationDTO> showHistory() {
        return operationService.listOperations();
    }

    @PostMapping("/operations")
    public double saveOperation(
            @RequestParam("op1") String op1,
            @RequestParam("op") String op,
            @RequestParam("op2") String op2) {
        return operationService.performOperation(op1, op, op2);
    }
}
