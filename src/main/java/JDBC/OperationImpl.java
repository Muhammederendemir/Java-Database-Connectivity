package JDBC;

import javafx.scene.chart.PieChart;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OperationImpl implements Operation {
    static Logger logger = Logger.getLogger(App.class);


    @Override
    public void createTable(String command,Connection connection) {
        //DBConnection dbConnection=new DBConnection();
        //connection= (Connection) dbConnection.getConnection();
        Statement statement=null;
        try {
             statement=connection.createStatement();
            statement.execute(command);
            logger.info("Tablo oluşturulmuştur");
        } catch (SQLException e) {
            logger.error("Tablo oluşturulurken hata bulunmaktadır   HATA :"+e);
        }
        finally {
            if (connection!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.warn("statement kapatılırken hata meydana geldi  HATA :" + e);
                }
            }
        }
    }

    @Override
    public void closeConnection(Connection connection) {
        if(connection!=null){
            try {
                connection.close();
                logger.info("Bağlantı kapatılmıştır");
            } catch (SQLException e) {
                logger.warn("Bağlantı kapatılamamıştır bir hata oluşmurtur  HATA : "+e);
            }
        }
    }

    @Override
    public void selectCommand(Connection connection) {
        Statement statement=null;
        String selectTableSQL="SELECT * FROM personeller";
        List<DataBaseModel> dataList=new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                DataBaseModel dataBaseModel=new DataBaseModel();

                dataBaseModel.setId(rs.getInt("personelNo"));
                dataBaseModel.setIsim(rs.getString("isim"));
                dataBaseModel.setSoyisim(rs.getString("soyisim"));
                dataList.add(dataBaseModel);

            }
        } catch (SQLException e) {
            logger.error("Veritabanından veri çekilme işleminde hata oluşmuştur   HATA :"+e);
        }
        finally {
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.warn("Statement kapatılamadı   HATA : "+e);
                }
            }
        }
        System.out.println("---  isimler  ----");
        for (int i=0;i<dataList.size();i++) {
            System.out.println("id : "+dataList.get(i).getId());
            System.out.println("isim : "+dataList.get(i).getIsim());
            System.out.println("soyisim : "+dataList.get(i).getSoyisim());
        }
    }
}
