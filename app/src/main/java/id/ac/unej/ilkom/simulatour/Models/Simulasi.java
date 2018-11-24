package id.ac.unej.ilkom.simulatour.Models;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Simulasi implements Serializable {

	@SerializedName("harga")
	private String harga;

	@SerializedName("foto")
	private String foto;

	@SerializedName("id_paket")
	private String idPaket;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("nama_paket")
	private String namaPaket;

	@SerializedName("durasi")
	private String durasi;

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

	public void setIdPaket(String idPaket){
		this.idPaket = idPaket;
	}

	public String getIdPaket(){
		return idPaket;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public void setNamaPaket(String namaPaket){
		this.namaPaket = namaPaket;
	}

	public String getNamaPaket(){
		return namaPaket;
	}

	public void setDurasi(String durasi){
		this.durasi = durasi;
	}

	public String getDurasi(){
		return durasi;
	}

	@Override
 	public String toString(){
		return 
			"Simulasi{" + 
			"harga = '" + harga + '\'' + 
			",foto = '" + foto + '\'' + 
			",id_paket = '" + idPaket + '\'' + 
			",deskripsi = '" + deskripsi + '\'' + 
			",nama_paket = '" + namaPaket + '\'' + 
			",durasi = '" + durasi + '\'' + 
			"}";
		}
}