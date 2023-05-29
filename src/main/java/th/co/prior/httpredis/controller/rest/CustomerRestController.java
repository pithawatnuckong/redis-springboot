package th.co.prior.httpredis.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import th.co.prior.httpredis.model.CustomerModel;
import th.co.prior.httpredis.model.response.ResponseModel;
import th.co.prior.httpredis.service.CustomerService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/customers")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public ResponseModel<List<CustomerModel>> findCustomers() {
        return this.customerService.findCustomersThenResponse();
    }

    @GetMapping("/{id}/customer")
    public ResponseModel<CustomerModel> findCustomer(@PathVariable(value = "id") String id){
        return this.customerService.findCustomerThenResponse(id);
    }

    @PostMapping()
    public ResponseModel<Integer> insertCustomer(@RequestBody CustomerModel customerModel) {
        return this.customerService.insertCustomerThenResponse(customerModel);
    }

}
