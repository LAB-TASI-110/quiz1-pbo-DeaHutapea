import model.solution; // Memanggil class solution dari folder model
import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<solution> daftarPesanan = new ArrayList<>();

        // Membaca input
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals("END")) {
                break;
            }

            String kode = input;
            int porsiButet = scanner.nextInt();

            String namaMenu = "";
            int hargaMenu = 0;

            // Mapping Kode Menu ke Nama Menu dan Harga
            switch (kode) {
                case "NGS": namaMenu = "Nasi Goreng Spesial"; hargaMenu = 15000; break;
                case "AP":  namaMenu = "Ayam Penyet"; hargaMenu = 20000; break;
                case "SA":  namaMenu = "Sate Ayam (10 Tusuk)"; hargaMenu = 25000; break;
                case "BU":  namaMenu = "Bakso Urat"; hargaMenu = 18000; break;
                case "MAP": namaMenu = "Mie Ayam Pangsit"; hargaMenu = 15000; break;
                case "GG":  namaMenu = "Gado-Gado"; hargaMenu = 15000; break;
                case "SAM": namaMenu = "Soto Ayam"; hargaMenu = 17000; break;
                case "RD":  namaMenu = "Rendang Daging"; hargaMenu = 25000; break;
                case "IB":  namaMenu = "Ikan Bakar"; hargaMenu = 35000; break;
                case "NUK": namaMenu = "Nasi Uduk Komplit"; hargaMenu = 20000; break;
                default:    namaMenu = "Menu Tidak Dikenal"; hargaMenu = 0; break;
            }

            if (hargaMenu > 0) {
                // Membuat objek dari class model.solution
                daftarPesanan.add(new solution(kode, namaMenu, porsiButet, hargaMenu));
            }
        }

        // Mencetak Header Struk
        System.out.printf("%-25s %-7s %-11s %s\n", "Menu", "Porsi", "Harga", "Total");
        System.out.println("=====================================================");

        int subtotal = 0;

        // Mencetak Rincian Pesanan
        for (solution pesanan : daftarPesanan) {
            System.out.printf("%-25s %-7d %-11d %d\n", pesanan.nama, pesanan.totalPorsi, pesanan.harga, pesanan.totalHarga);
            subtotal += pesanan.totalHarga;
        }

        System.out.println("=====================================================");

        // Menentukan Diskon Kupon
        double diskon = 0.0;
        if (subtotal >= 500000) {
            diskon = 0.25; // Kupon Hitam
        } else if (subtotal >= 400000) {
            diskon = 0.20; // Kupon Hijau
        } else if (subtotal >= 300000) {
            diskon = 0.15; // Kupon Merah
        } else if (subtotal >= 200000) {
            diskon = 0.10; // Kupon Kuning
        } else if (subtotal >= 100000) {
            diskon = 0.05; // Kupon Biru
        }

        // Mencetak Total Akhir
        int totalPembayaran = (int) (subtotal - (subtotal * diskon));
        System.out.printf("%-44s %d\n", "Total Pembayaran", totalPembayaran);

        scanner.close();
    }
}
