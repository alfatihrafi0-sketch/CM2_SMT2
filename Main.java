import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner    sc      = new Scanner(System.in);
        AntrianDll antrian = new AntrianDll();     // Membuat object double linked list antrean
        PesananDll pesanan = new PesananDll();     // Membuat object double linked list pesanan

        // Menambahkan data awal antrian
        antrian.tambahAntrian("Ainra", "08224500000");
        antrian.tambahAntrian("Danra", "08224511111");
        antrian.tambahAntrian("Sanri", "08224522222");

        int pilihan;

         // Perulangan menu utama program
        do {

            // Menampilkan menu langsung di dalam perulangan
            System.out.println("==============================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("==============================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");

            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {    // Seleksi pilihan menu menggunakan switch case

                case 1:
                
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP        : ");
                    String noHp = sc.nextLine();
                    antrian.tambahAntrian(nama, noHp);
                    break;

                case 2:
                   
                    antrian.cetakAntrian();
                    break;

                case 3:
                   
                    if (antrian.isEmpty()) {
                        System.out.println("Antrian kosong, tidak ada yang bisa dihapus.");
                        break;
                    }

                     // Input data pesanan
                    System.out.print("Kode Pesanan  : ");
                    int kodePesanan = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Nama Pesanan  : ");
                    String namaPesanan = sc.nextLine();
                   
                    System.out.print("Harga         : ");
                    int harga = sc.nextInt();
                    sc.nextLine();

                    // Menghapus antrean paling depan menggunakan nomor antrean head
                    NodeAntrian dihapus = antrian.hapusAntrian(antrian.head.noAntrian);

                    if (dihapus != null) {
                        pesanan.tambahPesanan(kodePesanan, namaPesanan, harga);
                        System.out.println(dihapus.data.namaPembeli + " telah memesan " + namaPesanan);
                    } else {
                        System.out.println("Nomor antrian tidak ditemukan.");
                    }
                    break;

                case 4:
                   
                    pesanan.laporanPesanan();
                    break;

                case 0:
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (pilihan != 0);   // Program berhenti saat user memilih menu 0

        sc.close();  // Menutup scanner
    }

}