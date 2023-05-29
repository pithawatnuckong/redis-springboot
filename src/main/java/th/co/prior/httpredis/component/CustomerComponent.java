package th.co.prior.httpredis.component;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import th.co.prior.httpredis.model.CustomerModel;
import th.co.prior.httpredis.pojo.CustomerPojo;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerComponent {

    public boolean isBadInsert(CustomerModel customerModel) {
        Boolean condition = customerModel.getAge() != null && customerModel.getAge() != 0
                && StringUtils.isBlank(customerModel.getEmail()) && StringUtils.isEmpty(customerModel.getEmail())
                && StringUtils.isBlank(customerModel.getFirstName()) && StringUtils.isEmpty(customerModel.getFirstName())
                && StringUtils.isBlank(customerModel.getLastName()) && StringUtils.isEmpty(customerModel.getLastName());
        return condition;
    }

    public void transformCustomerModelToPojo(CustomerPojo customerPojo, CustomerModel customerModel) {
        customerPojo.setAge(customerModel.getAge());
        customerPojo.setEmail(customerModel.getEmail());
        customerPojo.setFirstName(customerModel.getFirstName());
        customerPojo.setLastName(customerModel.getLastName());
    }

    public List<CustomerModel> transformCustomerIterableToModel(Iterable<CustomerPojo> customerPojos) {
        List<CustomerModel> customerModels = new ArrayList<>();

        for (CustomerPojo customerPojo : customerPojos) {
            CustomerModel model = new CustomerModel();
            model.setId(customerPojo.getId());
            model.setAge(customerPojo.getAge());
            model.setEmail(customerPojo.getEmail());
            model.setFirstName(customerPojo.getFirstName());
            model.setLastName(customerPojo.getFirstName());
            customerModels.add(model);
        }

        return customerModels;
    }

    public CustomerModel transformCustomerPojoToModel(CustomerPojo customerPojo) {
        CustomerModel model = new CustomerModel();
        model.setId(customerPojo.getId());
        model.setAge(customerPojo.getAge());
        model.setEmail(customerPojo.getEmail());
        model.setFirstName(customerPojo.getFirstName());
        model.setLastName(customerPojo.getFirstName());
        return model;
    }
}
