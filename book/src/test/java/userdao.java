import com.dao.UserDaoImpl;
import com.pojo.User;

import org.junit.Test;

public class userdao {
    UserDaoImpl user = new UserDaoImpl();
    @Test
    public void name() {
        if (user.queryUserByUsername("admin") == null){
            System.out.println("可用");
        }else{
            System.out.println("不可用");
        }
    }

    @Test
    public void na_pa() {
        if(user.queryUserByUsernamePassword("admin", "123") == null){
            System.out.println("登录失败");
        }else{
            System.out.println("查询成功");
        }

    }


    @Test
    public void test3() {
        System.out.println(user.saveUser(new User(null,"asd","123","qq126.com")));
    }
}
