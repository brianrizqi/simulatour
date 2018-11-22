package id.ac.unej.ilkom.simulatour.Models;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Penginapan implements Serializable {

	@SerializedName("kontak")
	private String kontak;

	@SerializedName("nama")
	private String nama;

	@SerializedName("harga")
	private String harga;

	@SerializedName("foto")
	private String foto;

	@SerializedName("jenis_penginapan")
	private String jenisPenginapan;

	@SerializedName("id")
	private String id;

	@SerializedName("fasilitas")
	private String fasilitas;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("alamat")
	private String alamat;

	public void setKontak(String kontak){
		this.kontak = kontak;
	}

	public String getKontak(){
		return kontak;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setHarga(String harga){
		this.harga = harga;
	}

	public String getHarga(){
		return harga;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setJenisPenginapan(String jenisPenginapan){
		this.jenisPenginapan = jenisPenginapan;
	}

	public String getJenisPenginapan(){
		return jenisPenginapan;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setFasilitas(String fasilitas){
		this.fasilitas = fasilitas;
	}

	public String getFasilitas(){
		return fasilitas;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	@Override
 	public String toString(){
		return 
			"Penginapan{" + 
			"kontak = '" + kontak + '\'' + 
			",nama = '" + nama + '\'' + 
			",harga = '" + harga + '\'' + 
			",foto = '" + foto + '\'' + 
			",jenis_penginapan = '" + jenisPenginapan + '\'' + 
			",id = '" + id + '\'' + 
			",fasilitas = '" + fasilitas + '\'' + 
			",deskripsi = '" + deskripsi + '\'' + 
			",alamat = '" + alamat + '\'' + 
			"}";
		}
}