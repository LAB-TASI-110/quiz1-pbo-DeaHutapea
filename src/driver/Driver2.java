import model.solution; // Memanggil class solution dari folder model
import java.util.ArrayList;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Membaca jumlah total data (N)
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // 2. Membaca deret nilai
        int[] deretNilai = new int[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                deretNilai[i] = scanner.nextInt();
            }
        }

        // 3. Membaca kode kelompok berdasarkan Gender
        if (!scanner.hasNext()) return;
        String kodeGender = scanner.next().toUpperCase();

        int totalNilai = 0;

        for (int i = 0; i < n; i++) {
            int urutan = i + 1; // Urutan manusia (1, 2, 3...)

            // Logika: Ganjil = Wanita, Genap = Pria
            if (kodeGender.equals("WANITA") || kodeGender.equals("PEREMPUAN")) {
                if (urutan % 2 != 0) {
                    totalNilai += deretNilai[i];
                }
            } else if (kodeGender.equals("PRIA") || kodeGender.equals("LAKI-LAKI")) {
                if (urutan % 2 == 0) {
                    totalNilai += deretNilai[i];
                }
            }
        }

        System.out.println(totalNilai);
        scanner.close();
    }
}
