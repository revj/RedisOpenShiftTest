import redis.clients.jedis.Jedis;

public class RedisOpenShiftTest {
	
	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("redis://redis-ephemeral", 6379);
		jedis.set("1", "Hello World!");
		System.out.println(jedis.get("1"));
		
	}

}
