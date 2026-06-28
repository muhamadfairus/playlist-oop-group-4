# playlist-array-group-4

Implementasi Operasi Array

Dalam program ini, kami mengelola data lagu menggunakan array objek Lagu[] dengan kapasitas maksimal 10. Berikut adalah operasi dasar yang diimplementasikan:
 1. Traversal: Menelusuri seluruh elemen array dari indeks 0 hingga n-1. Setiap elemen dikunjungi tepat satu kali, sehingga waktu eksekusi berbanding lurus dengan jumlah elemen (n).
 2. Searching : Menggunakan Linear Search yang memeriksa setiap elemen satu per satu dari awal hingga akhir. Pada kasus terburuk, elemen yang dicari berada di posisi terakhir atau tidak ada, sehingga semua n elemen harus diperiksa.
 3. Insertion: Penambahan dilakukan di akhir array (posisi jumlahLagu), tanpa perlu menggeser elemen lain. Operasi ini hanya membutuhkan satu langkah assignment, sehingga konstan.
 4. Deletion: Setelah menemukan elemen yang akan dihapus (O(n)), elemen-elemen setelahnya harus digeser ke kiri satu per satu untuk menjaga kesinambungan array. Pada kasus terburuk, elemen pertama dihapus sehingga n-1 elemen harus digeser. Total kompleksitas: O(n) + O(n) = O(n).
 5. Sorting: Bubble sort termasuk dalam kategori O(n²) karena pada kasus rata-rata dan worst case nya algoritma ini harus membandingkan hampir dari setiap elemennya dengan elemen yang lainnya melalui nested loop. Selection sort juga termasuk dalam kategori O(n²) karena untuk setiap posisi dalam array algoritma ini harus mencari elemen terkecil terlebih dahulu dari sisa array nya, sehingga menghasilkan dua perulangan bersarang (nested loop).
