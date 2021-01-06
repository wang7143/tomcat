import com.pojo.User;
import com.service.Userservice;
import com.service.Userserviceimp;

import org.junit.Test;

public class UserServicetest {
    
    Userservice userS = new Userserviceimp();

    @Test
    public void testreg() {
        userS.registUser(new User(null,"asdsdfsd","666","ghgh@163.com"));
        userS.registUser(new User(null,"8151555","666","ghgh@168.com"));
    }

    @Test
    public void logintest() {
        System.out.println(userS.login(new User(null,"asd","123",null)));
    }

    @Test
    public void exist_name() {
        if(userS.existsusername("852")){
            System.out.println("cunzai");
        }else{
            System.out.println("keyong");
        }
    }
}
