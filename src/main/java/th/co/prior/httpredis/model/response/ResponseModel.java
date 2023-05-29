package th.co.prior.httpredis.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseModel<T> {
    private Integer status;
    private String description;
    private T data;
}
