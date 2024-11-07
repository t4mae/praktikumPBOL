import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tugas2 {
    private static Map<String, String> mhs = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah mahasiswa");
            System.out.println("2. Lihat mahasiswa");
            System.out.println("3. Edit mahasiswa");
            System.out.println("4. DO mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int pilih = getIntInput();
            switch (pilih) {
                case 1:
                    tambahMhs();
                    break;
                case 2:
                    readMhs();
                    break;
                case 3:
                    editMhs();
                    break;
                case 4:
                    hapusMhs();
                    break;
                case 5:
                    System.out.println("Terima kasih banyak lek.");
                    System.exit(0);
                default:
                    System.out.println("Silakan coba lagi.");
            }
        }
    }

    private static void tambahMhs() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        if (mhs.containsKey(nim)) {
            System.out.println("NIM sudah terdaftar.");
            return;
        }
        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();
        mhs.put(nim, name);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private static void readMhs() {
        if (mhs.isEmpty()) {
            System.out.println("Tidak ada mahasiswa terdaftar.");
            return;
        }
        System.out.println("Daftar Mahasiswa:");
        for (Map.Entry<String, String> entry : mhs.entrySet()) {
            System.out.println("NIM: " + entry.getKey() + ", Nama: " + entry.getValue());
        }
    }

    private static void editMhs() {
        System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nim = scanner.nextLine();
        if (!mhs.containsKey(nim)) {
            System.out.println("NIM tidak ditemukan.");
            return;
        }
        System.out.print("Masukkan nama baru: ");
        String newNama = scanner.nextLine();
        mhs.put(nim, newNama);
        System.out.println("Data mahasiswa berhasil diupdate.");
    }

    private static void hapusMhs() {
        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
        String nim = scanner.nextLine();
        if (mhs.remove(nim) != null) {
            System.out.println("Mahasiswa berhasil di-DO.");
        } else {
            System.out.println("NIM tidak ditemukan.");
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Input tidak valid. Masukkan angka: ");
            }
        }
    }
}