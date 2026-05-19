public class NodeAntrian {
    int noAntrian;   
    Pembeli data;        
   
    NodeAntrian prev;     // Pointer prev digunakan untuk menunjuk node sebelumnya
    NodeAntrian next;     // Pointer next digunakan untuk menunjuk node berikutnya
   
    // Konstruktor node antrean
    NodeAntrian(int noAntrian, Pembeli data) {
       
        this.noAntrian = noAntrian;    // Mengisi nomor antrean
        this.data      = data;         // Mengisi data pembeli

        this.prev      = null;   // Pointer prev diisi null karena node baru belum memiliki node sebelumnya
        this.next      = null;   // Pointer next diisi null karena node baru belum memiliki node berikutnya
    }
}
 