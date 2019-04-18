package JDBC;

public class DataBaseModel {
   private int id;
   private String isim;
   private String soyisim;

    public int getId() {
        return id;
    }

    public String getIsim() {
        return this.isim;
    }

    public String getSoyisim() {
        return this.soyisim;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }
}
