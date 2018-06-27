import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import redis.clients.jedis.Jedis;

public class RedisOpenShiftTest {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Test... can you see me?");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Connect to 1. Peter's or 2. OpenShift's (1/2):");
		String result = input.readLine();
		if (result.equals("1")) {
			
			Jedis jedis = new Jedis("142.145.212.217", 6379);
			jedis.set("1", "Hello World!");
			System.out.println(jedis.get("1"));
			jedis.close();
			
		}
		else {
			
			Jedis jedis = new Jedis("redis://redis", 6379);
			jedis.set("1", "Hello World!");
			System.out.println(jedis.get("1"));
			jedis.close();
		}
	}
}
