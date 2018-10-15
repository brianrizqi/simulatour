package id.ac.unej.ilkom.simulatour.Model;

public class mHome {
    private String id, img, judul;

    public mHome(String id, String img, String judul) {
        this.id = id;
        this.img = img;
        this.judul = judul;
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
