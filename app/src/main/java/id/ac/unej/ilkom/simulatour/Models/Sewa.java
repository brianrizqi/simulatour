package id.ac.unej.ilkom.simulatour.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sewa implements Serializable {
    @SerializedName("harga")
    private String harga;

    @SerializedName("id_sewa")
    private String idSewa;

    @SerializedName("nama")
    private String nama;

    @SerializedName("foto")
    private String foto;

    @SerializedName("jenis_kendaraan")
    private String jenisKendaraan;

    public Sewa() {
    }

    public Sewa(String harga, String idSewa, String nama, String foto) {
        this.harga = harga;
        this.idSewa = idSewa;
        this.nama = nama;
        this.foto = foto;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getIdSewa() {
        return idSewa;
    }

    public void setIdSewa(String idSewa) {
        this.idSewa = idSewa;
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

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    @Override
    public String toString() {
        return
                "Makanan{" +
                        "harga = '" + harga + '\'' +
                        ",id_sewa = '" + idSewa + '\'' +
                        ",nama = '" + nama + '\'' +
                        ",foto = '" + foto + '\'' +
                        ",jenis_kendaraan = '" + jenisKendaraan + '\'' +
                        "}";
    }
}
