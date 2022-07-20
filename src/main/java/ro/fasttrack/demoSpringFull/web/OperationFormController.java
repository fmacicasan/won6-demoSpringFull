package ro.fasttrack.demoSpringFull.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.fasttrack.demoSpringFull.dto.OperationDTO;
import ro.fasttrack.demoSpringFull.service.OperationService;

import java.util.List;

/**
 * @author flo
 * @since 20.07.2022.
 */
@Controller
public class OperationFormController {

    private OperationService operationService;

    public OperationFormController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/form")
    public String showHistory(Model model) {
        model.addAttribute("operations", operationService.listOperations());
        return "index";
    }

    @GetMapping("/newOp")
    public String showNewOp(Model model) {
        //create model attribute to bind from data
        OperationRequest operation = new OperationRequest();
        model.addAttribute("operation", operation);
        return "new_op";
    }

    @PostMapping("/newOperation")
    public String saveOperation(@ModelAttribute("operation") OperationRequest request) {
        operationService.performOperation(request.getOp1(), request.getOp(), request.getOp2());
        return "redirect:/form";
    }
}
