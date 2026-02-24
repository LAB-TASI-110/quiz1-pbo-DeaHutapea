package model;

public class solution {
    public String kode;
    public String nama;
    public int porsiButet;
    public int totalPorsi;
    public int harga;
    public int totalHarga;

    // Constructor untuk menginisialisasi data pesanan
    public solution(String kode, String nama, int porsiButet, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.porsiButet = porsiButet;
        
        // Berdasarkan gambar berat tubuh (Ucok 100kg, Butet 50kg), rasionya 2:1
        // Maka Porsi Ucok = 2 * Porsi Butet. 
        // Total Porsi keseluruhan = 3 * Porsi Butet.
        this.totalPorsi = porsiButet * 3;
        this.harga = harga;
        this.totalHarga = this.totalPorsi * harga;
    }
}
