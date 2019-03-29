package id.ac.unej.ilkom.simulatour.Models;

public class Pemesanan {
    private String id, berangkat, pulang, status;

    public Pemesanan(String id, String berangkat, String pulang, String status) {
        this.id = id;
        this.berangkat = berangkat;
        this.pulang = pulang;
        this.status = status;
    }

    public Pemesanan() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBerangkat() {
        return berangkat;
    }

    public void setBerangkat(String berangkat) {
        this.berangkat = berangkat;
    }

    public String getPulang() {
        return pulang;
    }

    public void setPulang(String pulang) {
        this.pulang = pulang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
