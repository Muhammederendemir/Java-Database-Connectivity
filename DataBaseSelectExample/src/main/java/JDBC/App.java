package JDBC;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import java.sql.*;
public class App
{
    static  final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        DOMConfigurator.configure("C:\\Users\\Win10\\Desktop\\Log4jExample4\\src\\main\\resources\\log4j.xml");
        try {
            Class.forName("com.mysql.jdbc.Driver");//driveri yüklemek için yapıldı
            logger.info("Driver yüklenmiştir");
        } catch (ClassNotFoundException e) {
            logger.error("Driver yüklemede hata oluşmuştur.  HATA : "+e);//hata olur ise logger ile kaydet
            return;
        }
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/javaexample","root", "");//DB bağlantısı kuruyorum
            logger.info("Veritabanı bağlantısı kurulmuştur ");//logger ile bağlantı kuruduğunu kaydet
        } catch (SQLException e) {
            logger.error("Veritabanı bağlantısında hata oluşmuştur.   HATA : "+e);//hata olur ise logger ile kaydet
            return;
        }

        Statement statement = null;

        try {
            statement = connection.createStatement();
            logger.info("statement oluşturulmuştur");
        } catch (SQLException e) {
            logger.error("statement oluşturmada hata meydana gelmiştir   HATA :"+e);
        }

        String selectTableSQL="SELECT * FROM personeller";
        try {
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {

                String id = rs.getString("personelNo");
                String name = rs.getString("isim");
                String surname = rs.getString("soyisim");

                System.out.println("userid : " + id);
                System.out.println("username : " + name);
                System.out.println("username : " + surname);

                logger.info("Veritabanından veri çekilmiştir");
            }
        } catch (SQLException e) {
            logger.error("Veritabanından veri çekilme işleminde hata oluşmuştur   HATA :"+e);
        }

    }
}
