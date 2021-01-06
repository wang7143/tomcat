import org.junit.Test;

import java.sql.Connection;

import com.utils.*;

public class jdtest {
    
    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            
            Connection con = jdbcutils.getcon();
            System.out.println(con);
            jdbcutils.close(con);
        }
    }
}
