package id.ac.unej.ilkom.simulatour.Models;

public class mTransportasi {
    private String id, img, judul,harga;

    public mTransportasi(String id, String img, String judul, String harga) {
        this.id = id;
        this.img = img;
        this.judul = judul;
        this.harga = harga;
    }

    public String getHarga() {

        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}
