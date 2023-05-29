# Redis
Data caching that's store data on memory(RAM)
## Docker commands
- docker exec -it {container_name} redis-cli -> access redis-cli in docker environment
- docker exec it {container_name} bash -> access redis OS in docker environment
## Commands
- KEYS* -> to list all keys(hashes) that store in redis #Ex KEYS*
- HGET {set}:{hash} {field} -> to get specific value from field #Ex HGET customer:4fe70a30-b580-472b-8e65-7dfcef818793 firstName
- HGETALL {set}:{hash} -> to get all fields and values #Ex HGETALL customer:4fe70a30-b580-472b-8e65-7dfcef818793
- TYPE [{set} | {set}:{hash}] -> to get type of data #Ex TYPE customer
