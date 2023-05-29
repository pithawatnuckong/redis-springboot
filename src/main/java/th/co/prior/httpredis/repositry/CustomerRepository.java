package th.co.prior.httpredis.repositry;

import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import th.co.prior.httpredis.pojo.CustomerPojo;

@EnableRedisRepositories
public interface CustomerRepository extends CrudRepository<CustomerPojo, String> {
}
