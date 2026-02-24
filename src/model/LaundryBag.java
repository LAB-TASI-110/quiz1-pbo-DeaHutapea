package model;

public class LaundryBag {
    public String pemilik;
    public String asrama;
    public String tanggal;
    public double berat;
    public boolean adaCatatan;
    public boolean adaPakaianKhusus;
    public String status;

    private static final double BERAT_MAKSIMAL = 10.0;

    public LaundryBag(String pemilik, String asrama, String tanggal, double berat, boolean adaCatatan, boolean adaPakaianKhusus) {
        this.pemilik = pemilik;
        this.asrama = asrama;
        this.tanggal = tanggal;
        this.berat = berat;
        this.adaCatatan = adaCatatan;
        this.adaPakaianKhusus = adaPakaianKhusus;
        this.status = validasi();
    }

    private String validasi() {
        if (!adaCatatan) return "DITOLAK (Tanpa List)";
        if (berat > BERAT_MAKSIMAL) return "DITOLAK (Overweight)";
        return "DIPROSES";
    }

    public String getInfo() {
        String penanda = adaPakaianKhusus ? "[KHUSUS/TERPISAH]" : "[REGULER]";
        return String.format("%-15s | %-10s | %-10s | %5.1f kg | %-25s %s", 
                pemilik, asrama, tanggal, berat, status, penanda);
    }
}
