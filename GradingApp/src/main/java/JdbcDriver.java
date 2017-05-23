
public class JdbcDriver {

    public static void main(String[] args) {

        String nazwaSterownika = "oracle.jdbc.driver.OracleDriver";

        try {
            Class c = Class.forName(nazwaSterownika);
            System.out.println("Pakiet     : " + c.getPackage());
            System.out.println("Sukces.");

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
