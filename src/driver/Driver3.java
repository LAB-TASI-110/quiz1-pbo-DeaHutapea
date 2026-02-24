import model.LaundryBag; // Memanggil model baru
import java.util.ArrayList;
import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<LaundryBag> antrianLaundry = new ArrayList<>();

        System.out.println("--- Sistem Operasional Laundry Del ---");
        
        // Input Format: [Pemilik] [Asrama] [Tanggal] [Berat] [AdaCatatan:true/false] [AdaKhusus:true/false]
        // Contoh: Budi Archimedes 2023-10-11 5.5 true false
        while (sc.hasNext()) {
            String nama = sc.next();
            if (nama.equalsIgnoreCase("END")) break;

            String asrama = sc.next();
            String tanggal = sc.next();
            double berat = sc.nextDouble();
            boolean catatan = sc.nextBoolean();
            boolean khusus = sc.nextBoolean();

            // Poin 7: Penjemputan bertahap (FIFO)
            antrianLaundry.add(new LaundryBag(nama, tanggal, asrama, berat, catatan, khusus));
        }

        // Output Laporan
        System.out.println("\nDAFTAR PROSES LAUNDRY (FIFO):");
        System.out.println("==========================================================================================");
        System.out.printf("%-15s | %-10s | %-10s | %-8s | %-25s %s\n", "Nama", "Asrama", "Tanggal", "Berat", "Status", "Ket");
        System.out.println("------------------------------------------------------------------------------------------");

        for (LaundryBag bag : antrianLaundry) {
            System.out.println(bag.getInfo());
        }

        System.out.println("==========================================================================================");
        System.out.println("Catatan: Laundry 'DIPROSES' akan diantar 1x24 jam ke depan asrama (Poin 2 & 8).");
        System.out.println("Pengaduan kehilangan hanya dilayani 1x24 jam setelah pengantaran (Poin 6).");
        
        sc.close();
    }
}
