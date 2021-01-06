

public class test_num {
    
    // @Test
    public static int num(int m, int n) {
        int s = (m-n*(n+1)/2)/n+n;
        int c = (m-n*(n+1)/2)%n;
        if (c > 0) {
            return s+1;
        }
        return s;
    }















    public static void main(String[] args) {
        System.out.println(num(4, 2));
    }
}
