import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama: ");
        String nama =scanner.nextLine();

        System.out.print("Masukkan NIM: ");
        int nim = scanner.nextInt();

        System.out.println("Nama: " + nama);
        System.out.println("Nim: " + nim);

        scanner.close();
    }
}