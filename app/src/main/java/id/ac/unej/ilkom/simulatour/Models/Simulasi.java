package id.ac.unej.ilkom.simulatour.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Simulasi implements Serializable {

	@SerializedName("nama")
	private String nama;

	@SerializedName("harga")
	private String harga;

	@SerializedName("foto")
	private String foto;

	@SerializedName("jenis")
	private String jenis;

	@SerializedName("label")
	private String label;

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	@SerializedName("keterangan")
	private String keterangan;

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

	public void setJenis(String jenis){
		this.jenis = jenis;
	}

	public String getJenis(){
		return jenis;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	@Override
 	public String toString(){
		return 
			"Simulasi{" + 
			"nama = '" + nama + '\'' + 
			",harga = '" + harga + '\'' + 
			",foto = '" + foto + '\'' + 
			",jenis = '" + jenis + '\'' + 
			",label = '" + label + '\'' + 
			"}";
		}
}