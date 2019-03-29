package id.ac.unej.ilkom.simulatour.Models;

public class DetailPesan {
    private String title, tanggal, img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public DetailPesan() {
    }

    public DetailPesan(String title, String tanggal, String img) {
        this.title = title;
        this.tanggal = tanggal;
        this.img = img;
    }
}
