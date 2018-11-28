package id.ac.unej.ilkom.simulatour.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Makanan implements Serializable {
    @SerializedName("harga")
    private String harga;

    @SerializedName("id_makanan")
    private String idMakanan;

    @SerializedName("nama")
    private String nama;

    @SerializedName("foto")
    private String foto;

    @SerializedName("alamat")
    private String alamat;

    @SerializedName("menu_khas")
    private String menuKhas;

    public Makanan() {
    }

    public Makanan(String harga, String idMakanan, String nama, String foto) {
        this.harga = harga;
        this.idMakanan = idMakanan;
        this.nama = nama;
        this.foto = foto;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getIdMakanan() {
        return idMakanan;
    }

    public void setIdMakanan(String idMakanan) {
        this.idMakanan = idMakanan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMenuKhas() {
        return menuKhas;
    }

    public void setMenuKhas(String menuKhas) {
        this.menuKhas = menuKhas;
    }

    @Override
    public String toString() {
        return
                "Makanan{" +
                        "harga = '" + harga + '\'' +
                        ",id_makanan = '" + idMakanan + '\'' +
                        ",nama = '" + nama + '\'' +
                        ",foto = '" + foto + '\'' +
                        ",alamat = '" + alamat + '\'' +
                        ",menu_khas = '" + menuKhas + '\'' +
                        "}";
    }
}
