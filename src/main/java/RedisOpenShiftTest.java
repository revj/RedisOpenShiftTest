import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class RedisOpenShiftTest {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Test... can you see me?");
		
		String url = System.getenv("RedisUrl");
		String port = System.getenv("RedisPort");
		String password = System.getenv("RedisPassword");
		
		JedisShardInfo shardInfo = new JedisShardInfo(url, port);
		shardInfo.setPassword(password);
		Jedis jedis = new Jedis(shardInfo);	
		jedis.set("1", "Hello World!");
		System.out.println(jedis.get("1"));
		jedis.close();
	}
}
