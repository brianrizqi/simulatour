package id.ac.unej.ilkom.simulatour.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Transportasi implements Serializable {
    @SerializedName("harga")
    private String harga;

    @SerializedName("id_transportasi")
    private String idTransportasi;

    @SerializedName("nama_tempat")
    private String namaTempat;

    @SerializedName("foto")
    private String foto;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("akses")
    private String akses;

    public Transportasi() {
    }

    public Transportasi(String harga, String idTransportasi, String namaTempat, String foto) {
        this.harga = harga;
        this.idTransportasi = idTransportasi;
        this.namaTempat = namaTempat;
        this.foto = foto;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getIdTransportasi() {
        return idTransportasi;
    }

    public void setIdTransportasi(String idTransportasi) {
        this.idTransportasi = idTransportasi;
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getAkses() {
        return akses;
    }

    public void setAkses(String akses) {
        this.akses = akses;
    }
    @Override
    public String toString(){
        return
                "Transportasi{" +
                        "harga = '" + harga + '\'' +
                        ",id_transportasi = '" + idTransportasi + '\'' +
                        ",nama_tempat = '" + namaTempat + '\'' +
                        ",foto = '" + foto + '\'' +
                        ",deskripsi = '" + deskripsi + '\'' +
                        ",akses = '" + akses + '\'' +
                        "}";
    }
}
