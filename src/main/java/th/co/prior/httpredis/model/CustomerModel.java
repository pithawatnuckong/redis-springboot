package th.co.prior.httpredis.model;

import lombok.Data;

@Data
public class CustomerModel {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
}
