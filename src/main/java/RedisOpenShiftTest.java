import com.lambdaworks.redis.*;

public class RedisOpenShiftTest {
	
	public static void main(String[] args) {
		
		System.out.println("Test... can you see me?");
		
		RedisClient redisClient = new RedisClient(
			      RedisURI.create("redis://redis:6379/"));
			    RedisConnection<String, String> connection = redisClient.connect();

			    System.out.println("Connected to Redis");

			    connection.close();
			    redisClient.shutdown();
		
	}

}
