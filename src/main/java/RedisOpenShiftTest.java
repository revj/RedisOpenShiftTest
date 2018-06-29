import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class RedisOpenShiftTest {
	
	public static void main(String[] args) throws IOException, SQLException {
		
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
		
		String dbUrl = System.getenv("RuleDbUrl");
		String dbUsername = System.getenv("RuleDbUsername");
		String dbPassword = System.getenv("RuleDbPassword");
		
		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println(connection);
		connection.close();
		
	}
}
