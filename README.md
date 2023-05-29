# Redis
Caching that's store data on memory(RAM) | short term memory
## Docker commands
- docker exec -it {container_name} redis-cli -> access redis-cli in docker environment
- docker exec -it {container_name} bash -> access redis OS in docker environment
## Commands
- KEYS* -> to list all keys(hashes) that store in redis <br>#Ex KEYS*<br>
- HGET {set}:{hash} {field} -> to get specific value from field <br>#Ex HGET customer:4fe70a30-b580-472b-8e65-7dfcef818793 firstName<br>
- HGETALL {set}:{hash} -> to get all fields and values <br>#Ex HGETALL customer:4fe70a30-b580-472b-8e65-7dfcef818793<br>
- TYPE [{set} | {set}:{hash}] -> to get type of data <br>#Ex TYPE customer

## Installation
1. git clone https://github.com/pithawatnuckong/redis-springboot.git
2. cd redis-springboot
3. docker-compose up -d
4. mvn clean install package -DskipTests
5. java -jar ./target/http-redis-0.0.1-SNAPSHOT.jar

## API
1. Find all customers => /api/customers (GET)
2. Insert customer => /api/customers (POST) <br>Body {firstName: String, lastName: String, age: Integer, email: String}
3. Find customer by id => /api/customers/{id}/customer (GET)

