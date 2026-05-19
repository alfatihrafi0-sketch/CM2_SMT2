public class PesananDll {
    NodePesanan head;    // Pointer head digunakan untuk menunjuk node pertama pada linked list pesanan
    NodePesanan tail;    // Pointer tail digunakan untuk menunjuk node terakhir pada linked list pesanan

    PesananDll() {  // Konstruktor inisialisasi Dll kosong
        head = null;
        tail = null;
    }
    
     // Method untuk menambahkan pesanan baru
    void tambahPesanan(int kodePesanan, String namaPesanan, int harga) {
        Pesanan p         = new Pesanan(kodePesanan, namaPesanan, harga); 
        NodePesanan baru  = new NodePesanan(p);                          

        if (head == null) {
            head = baru;
            tail = baru;
        } else {
            tail.next  = baru;
            baru.prev  = tail;
            tail       = baru;
        }
    }

   // Method untuk menampilkan laporan pesanan
    void laporanPesanan() {
        if (head == null) {
            System.out.println("Belum ada pesanan.");
            return;
        }

        boolean swapped; // Proses sorting menggunakan Bubble Sort
        do {
            swapped = false;
            NodePesanan current = head;   // Current digunakan untuk traversal

            while (current != null && current.next != null) {

                if (current.data.namaPesanan.compareToIgnoreCase(current.next.data.namaPesanan) > 0) {

                    Pesanan tmp        = current.data;
                    current.data       = current.next.data;
                    current.next.data  = tmp;

                    swapped = true;  
                }
                current = current.next;
            }
        } while (swapped);   // Sorting berhenti jika tidak ada pertukaran lagi
       
        System.out.println("======================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("======================================");
        System.out.printf("%-14s %-20s %-10s%n", "Kode Pesanan", "Nama Pesanan", "Harga");

        int total = 0;
        NodePesanan current = head;
        while (current != null) {
            System.out.printf("%-14d %-20s %-10d%n",
                current.data.kodePesanan,
                current.data.namaPesanan,
                current.data.harga);
            total  += current.data.harga;
            current = current.next;
        }

        System.out.println("--------------------------------------");
        System.out.printf("%-14s %-20s %-10d%n", "", "TOTAL PENDAPATAN", total);
        System.out.println("======================================");
    }

    boolean isEmpty() {
        return head == null;
    }
}