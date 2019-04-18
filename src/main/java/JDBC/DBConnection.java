package JDBC;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static  Logger logger = Logger.getLogger(App.class);
    public static Connection connection=null;

    public DBConnection() {//yapıcı metod
        DOMConfigurator.configure("C:\\Users\\Win10\\Desktop\\JDBC\\src\\main\\resources\\log4j.xml");
        try {
            Class.forName("com.mysql.jdbc.Driver");//driveri yüklemek için yapıldı
            logger.info("Driver yüklenmiştir");
        } catch (ClassNotFoundException e) {
            logger.error("Driver yüklemede hata oluşmuştur.  HATA : "+e);//hata olur ise logger ile kaydet
            return;
        }
        //java.sql.Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/javaexample","root", "");//DB bağlantısı kuruyorum
            logger.info("Veritabanı bağlantısı kurulmuştur ");//logger ile bağlantı kuruduğunu kaydet
        } catch (SQLException e) {
            logger.error("Veritabanı bağlantısında hata oluşmuştur.   HATA : "+e);//hata olur ise logger ile kaydet
            return;
        }
    }

    public java.sql.Connection getConnection() {
        return this.connection;
    }
}
