public class AntrianDll {
    NodeAntrian head;     // Pointer head digunakan untuk menunjuk node pertama pada antrean        
    NodeAntrian tail;     // Pointer tail digunakan untuk menunjuk node terakhir pada antrean    
    int counterAntrian;   // Counter digunakan untuk membuat nomor antrean otomatis    
 
    // Konstruktor untuk mengatur kondisi awal double linked list saat masih kosong
   AntrianDll() {
        head           = null;
        tail           = null;
        counterAntrian = 0;   // Counter dimulai dari 0
    }
 
     // Method untuk menambahkan antrian baru
    void tambahAntrian(String namaPembeli, String noHp) {
        counterAntrian++;    // Nomor antrean otomatis bertambah

        Pembeli pembeli   = new Pembeli(namaPembeli, noHp);               // Membuat object pembeli
        NodeAntrian baru  = new NodeAntrian(counterAntrian, pembeli);     // Membuat node antrean baru
 
        if (head == null) {    // Jika linked list masih kosong
           // Node baru menjadi head dan tail
            head = baru;      
            tail = baru;
        } else {
             // Menghubungkan node terakhir dengan node baru
            tail.next  = baru;  
             // Menghubungkan node baru ke node sebelumnya 
            baru.prev  = tail;  
             // Memindahkan tail ke node baru
            tail       = baru;  
        }
 
        System.out.println("Antrian berhasil ditambahkan dengan nomor: " + counterAntrian);
    }
       // Method untuk menghapus antrean berdasarkan nomor antrean
        NodeAntrian hapusAntrian(int noAntrian) {
       
        // Current digunakan untuk menelusuri linked list
        NodeAntrian current = head;
        
         // Perulangan pencarian data
        while (current != null) {
        // Jika nomor antrean ditemukan
            if (current.noAntrian == noAntrian) {
         // Jika node bukan head        
                if (current.prev != null) {

                    current.prev.next = current.next;   // Node sebelumnya dihubungkan ke node setelah current
                    head = current.next;                // Jika node adalah head, maka head dipindah ke node berikutnya        
                }
                if (current.next != null) {
        // Node setelah current dihubungkan ke node sebelumnya
                    current.next.prev = current.prev;   
                } else {
                    tail = current.prev;                
                }
 
                current.prev = null;
                current.next = null;
                
                return current;  // Mengembalikan node yang dihapus
            }
            current = current.next;  // Pindah ke node berikutnya
        }
 
        return null;  // Jika data tidak ditemukan
    }
 
     // Method untuk menampilkan seluruh antrian
    void cetakAntrian() {
        if (head == null) {   // Jika antrean kosong
            System.out.println("Antrian kosong.");
            return;
        }
 
        System.out.println("==============================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("==============================");
        System.out.printf("%-12s %-15s %-15s%n", "No Antrian", "Nama", "No HP");
 
        NodeAntrian current = head;  // Current digunakan untuk traversal
        while (current != null) {    // Menampilkan data satu per satu

            System.out.printf("%-12d %-15s %-15s%n",
                current.noAntrian,
                current.data.namaPembeli,
                current.data.noHp);
            current = current.next;  // Pindah ke node berikutnya
        }
    }
 
    boolean isEmpty() {        // Method untuk mengecek apakah antrian kosong
        return head == null;   // Jika head null berarti linked list kosong
    }
}