package th.co.prior.httpredis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import th.co.prior.httpredis.component.CustomerComponent;
import th.co.prior.httpredis.model.CustomerModel;
import th.co.prior.httpredis.model.response.ResponseModel;
import th.co.prior.httpredis.pojo.CustomerPojo;
import th.co.prior.httpredis.repositry.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerComponent customerComponent;

    public CustomerService(CustomerRepository customerRepository, CustomerComponent customerComponent) {
        this.customerRepository = customerRepository;
        this.customerComponent = customerComponent;
    }

    public ResponseModel<Integer> insertCustomerThenResponse(CustomerModel customerModel) {
        ResponseModel<Integer> result = new ResponseModel<>();
        result.setStatus(200);
        result.setDescription("ok");

        try {

            if (this.customerComponent.isBadInsert(customerModel)) {
                result.setStatus(400);
                result.setDescription("Bad request");
                return result;
            }

            CustomerPojo customerPojo = new CustomerPojo();
            this.customerComponent.transformCustomerModelToPojo(customerPojo, customerModel);
            this.insertCustomer(customerPojo);

        } catch (Exception ex) {
            ex.printStackTrace();
            result.setStatus(500);
            result.setDescription(ex.getMessage());
        }

        return result;
    }

    public ResponseModel<List<CustomerModel>> findCustomersThenResponse() {
        ResponseModel<List<CustomerModel>> result = new ResponseModel<>();
        result.setDescription("ok");
        result.setStatus(200);

        try{

            List<CustomerModel> customerModels = this.findCustomers();

            result.setData(customerModels);

        } catch (Exception ex) {
            ex.printStackTrace();
            result.setStatus(500);
            result.setDescription(ex.getMessage());
        }

        return result;
    }

    public ResponseModel<CustomerModel> findCustomerThenResponse(String id) {
        ResponseModel<CustomerModel> result = new ResponseModel<>();
        result.setStatus(200);
        result.setDescription("ok");

        try{

            CustomerModel customerModel = this.findCustomer(id);
            log.info("{}", customerModel);
            result.setData(customerModel);

        } catch (Exception ex) {
            ex.printStackTrace();
            result.setStatus(500);
            result.setDescription(ex.getMessage());
        }

        return result;
    }

    private CustomerModel findCustomer(String id) {
        Optional<CustomerPojo> customerPojo = this.customerRepository.findById(id);
        if ( !customerPojo.isPresent() ){
            return null;
        }
        return this.customerComponent.transformCustomerPojoToModel(customerPojo.get());
    }

    private List<CustomerModel> findCustomers() {
        Iterable<CustomerPojo> customerPojos =  this.customerRepository.findAll();
        List<CustomerModel> customerModels = this.customerComponent.transformCustomerIterableToModel(customerPojos);
        return customerModels;
    }

    private void insertCustomer(CustomerPojo customerPojo) {
        this.customerRepository.save(customerPojo);
    }

}
