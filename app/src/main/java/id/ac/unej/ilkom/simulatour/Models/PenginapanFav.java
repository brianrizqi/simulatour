package id.ac.unej.ilkom.simulatour.Models;

public class PenginapanFav {
    private String img, title,harga;

    public PenginapanFav() {
    }

    public PenginapanFav(String img, String title) {
        this.img = img;
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
