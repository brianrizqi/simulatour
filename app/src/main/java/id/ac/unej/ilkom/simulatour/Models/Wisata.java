package id.ac.unej.ilkom.simulatour.Models;


import com.google.gson.annotations.SerializedName;


public class Wisata{

	@SerializedName("harga_tiket")
	private String hargaTiket;

	@SerializedName("id_wisata")
	private String idWisata;

	@SerializedName("nama")
	private String nama;

	@SerializedName("foto")
	private String foto;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("jenis_obyek_wisata")
	private String jenisObyekWisata;

	@SerializedName("akses")
	private String akses;

	public Wisata() {
	}

	public Wisata(String hargaTiket, String idWisata, String nama, String foto) {

		this.hargaTiket = hargaTiket;
		this.idWisata = idWisata;
		this.nama = nama;
		this.foto = foto;
	}

	public void setHargaTiket(String hargaTiket){
		this.hargaTiket = hargaTiket;
	}

	public String getHargaTiket(){
		return hargaTiket;
	}

	public void setIdWisata(String idWisata){
		this.idWisata = idWisata;
	}

	public String getIdWisata(){
		return idWisata;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public void setJenisObyekWisata(String jenisObyekWisata){
		this.jenisObyekWisata = jenisObyekWisata;
	}

	public String getJenisObyekWisata(){
		return jenisObyekWisata;
	}

	public void setAkses(String akses){
		this.akses = akses;
	}

	public String getAkses(){
		return akses;
	}

	@Override
 	public String toString(){
		return 
			"Wisata{" + 
			"harga_tiket = '" + hargaTiket + '\'' + 
			",id_wisata = '" + idWisata + '\'' + 
			",nama = '" + nama + '\'' + 
			",foto = '" + foto + '\'' + 
			",deskripsi = '" + deskripsi + '\'' + 
			",jenis_obyek_wisata = '" + jenisObyekWisata + '\'' + 
			",akses = '" + akses + '\'' + 
			"}";
		}
}