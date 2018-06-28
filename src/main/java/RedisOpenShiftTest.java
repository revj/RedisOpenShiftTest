import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import redis.clients.jedis.Jedis;

public class RedisOpenShiftTest {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Test... can you see me?");
		
		String url = System.getenv("RedisUrlTest");
		
		Jedis jedis = new Jedis(url, 6379);	
		jedis.set("1", "Hello World!");
		System.out.println(jedis.get("1"));
		jedis.close();
	}
}
