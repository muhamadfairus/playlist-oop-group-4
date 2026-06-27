/**
 * Team Assignment 1 - Group 4
 * Members:
 * - DEAN PANDEHEN SAHAY [2902760536]
 * - ADAM NUR HIDAYAT [2902801012]
 * - ACHMAD ALIF NASRULLOH [2902775065]
 * - LUKMAN NUL HAKIM [2902765562]
 * - MUHAMAD FAIRUS [2902792090]
 */


import java.util.Scanner;

public class PlaylistArray {
    // Array statis dengan ukuran maksimum 10
    private static Lagu[] playlist = new Lagu[10];
    private static int jumlahLagu = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== MENU PLAYLIST MUSIK ===");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Tambah lagu baru");
            System.out.println("3. Hapus lagu berdasarkan judul");
            System.out.println("4. Cari lagu berdasarkan judul");
            System.out.println("5. Urutkan lagu berdasarkan durasi (Ascending)");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline (buffer) setelah nextInt()

            System.out.println();
            switch (pilihan) {
                case 1:
                    tampilkanSemuaLagu();
                    break;
                case 2:
                    tambahLagu();
                    break;
                case 3:
                    hapusLagu();
                    break;
                case 4:
                    cariLagu();
                    break;
                case 5:
                    urutkanLaguBerdasarkanDurasi();
                    break;
                case 6:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 6);
    }

    // 1. TRAVERSAL: Menampilkan semua elemen dalam array
    public static void tampilkanSemuaLagu() {
        System.out.println("--- Daftar Lagu dalam Playlist ---");
        // Cek apakah kosong. Jika tidak, looping dari indeks 0 hingga batas jumlahLagu.
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong.");
            return;
        }
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.print((i + 1) + ". ");
            playlist[i].tampilkanInfo();
        }
    }

    // 2. INSERTION: Menambahkan lagu baru di akhir array
    public static void tambahLagu() {
        // Cek apakah array sudah mencapai kapasitas maksimal (10).
        if (jumlahLagu >= playlist.length) {
            System.out.println("Gagal menambahkan lagu. Playlist sudah penuh (Maksimal 10 lagu).");
            return;
        }

        System.out.print("Masukkan Judul Lagu : ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Nama Artis : ");
        String artis = scanner.nextLine();
        System.out.print("Masukkan Durasi (format MM:SS): ");
        String durasiString = scanner.nextLine(); 
        String[] parts = durasiString.split(":");
        double menit = Double.parseDouble(parts[0]);
        double detik = Double.parseDouble(parts[1]);
        double durasi = menit + (detik / 100.0);
        
        // Menambahkan objek baru ke indeks 'jumlahLagu' lalu increment jumlahLagu
        playlist[jumlahLagu] = new Lagu(judul, artis, durasi);
        jumlahLagu++;
        System.out.println("Lagu '" + judul + "' berhasil ditambahkan!");
    }

    // 3. DELETION: Menghapus lagu dan menggeser elemen array agar rapat
    public static void hapusLagu() {
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong. Tidak ada yang bisa dihapus.");
            return;
        }

        System.out.print("Masukkan judul lagu yang ingin dihapus: ");
        String judulCari = scanner.nextLine();
        int indexDihapus = -1;

        // Langkah 1: Mencari indeks lagu yang ingin dihapus
        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judulCari)) {
                indexDihapus = i;
                break;
            }
        }

        // Langkah 2: Jika ditemukan, lakukan pergeseran elemen (Shifting)
        if (indexDihapus != -1) {
            // Menggeser semua elemen di sebelah kanan indeks ke kiri sebanyak 1 langkah
            for (int i = indexDihapus; i < jumlahLagu - 1; i++) {
                playlist[i] = playlist[i + 1];
            }
            
            // Hapus referensi terakhir dan kurangi counter
            playlist[jumlahLagu - 1] = null;
            jumlahLagu--;
            System.out.println("Lagu '" + judulCari + "' berhasil dihapus dari playlist.");
        } else {
            System.out.println("Lagu dengan judul '" + judulCari + "' tidak ditemukan.");
        }
    }

    // 4. SEARCHING: Mencari lagu dengan Linear Search
    public static void cariLagu() {
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong.");
            return;
        }

        System.out.print("Masukkan judul lagu yang dicari: ");
        String judulCari = scanner.nextLine();
        boolean ditemukan = false;

        // LLinear search dengan memeriksa setiap elemen satu per satu dari awal sampai akhir
        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judulCari)) {
                System.out.println("Lagu ditemukan pada urutan ke-" + (i + 1) + ":");
                playlist[i].tampilkanInfo();
                ditemukan = true;
                break; // Hentikan pencarian jika sudah ditemukan
            }
        }

        if (!ditemukan) {
            System.out.println("Lagu dengan judul '" + judulCari + "' tidak ditemukan.");
        }
    }

    // 5. SORTING (Fitur Tambahan): Mengurutkan berdasarkan durasi dengan Bubble Sort
    public static void urutkanLaguBerdasarkanDurasi() {
        if (jumlahLagu < 2) {
            System.out.println("Lagu kurang dari 2. Tidak perlu diurutkan.");
            return;
        }

        System.out.println("--- SEBELUM PENGURUTAN ---");
        tampilkanSemuaLagu();

        // Bubble Sort membandingkan elemen berdekatan dan menukarnya jika salah urutan
        for (int i = 0; i < jumlahLagu - 1; i++) {
            for (int j = 0; j < jumlahLagu - 1 - i; j++) {
                if (playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    // Tukar (Swap) posisi objek lagu
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
            }
        }

        System.out.println("\n--- SESUDAH PENGURUTAN ---");
        tampilkanSemuaLagu();
    }
}
