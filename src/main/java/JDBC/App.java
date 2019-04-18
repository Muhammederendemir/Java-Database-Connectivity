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

    }
}
