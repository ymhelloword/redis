import org.junit.Test;
import redis.clients.jedis.Jedis;
import ym.springRedis.entity.User;
import ym.springRedis.util.RedisPoolUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zjl
 * @Date 2019/6/29 18:25
 */
public class RedisTest {
    @Test
    public void test(){
        Jedis jedis = RedisPoolUtil.getJedis();
        jedis.auth("123456");
        System.out.println(jedis.exists("user")) ;
        RedisPoolUtil.closeJedis(jedis);
    }
    @Test
    public void test2(){
        Jedis jedis = RedisPoolUtil.getJedis();
        jedis.auth("123456");
        if ( jedis.exists("user") ){
            Map<String,String> usermap= jedis.hgetAll("user");
            System.out.println(usermap.get("name")) ;
            System.out.println(usermap.get("age")) ;
        }else {
            User user = new User();
            user.setAge(12);
            user.setName("ym");
            Map<String,String> usermap = new HashMap <>();
            usermap.put("name",user.getName());
            usermap.put("age",Integer.toString(user.getAge()));
            jedis.hmset("user",usermap);
        }
        RedisPoolUtil.closeJedis(jedis);
    }

}
