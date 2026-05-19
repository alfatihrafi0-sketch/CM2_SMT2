public class NodePesanan {
    Pesanan     data;   
 
    NodePesanan prev;    // Pointer prev digunakan untuk menunjuk node sebelumnya
    NodePesanan next;    // Pointer next digunakan untuk menunjuk node berikutnya
 
    NodePesanan(Pesanan data) {  // Konstruktor node pesanan
        this.data = data;        // Mengisi data pesanan ke dalam node
       
        this.prev = null; 
        this.next = null;
    }
}
 