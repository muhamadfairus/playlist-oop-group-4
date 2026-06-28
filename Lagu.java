public class Lagu {
  private String judul;
  private String artis;
  private double durasi;

  // Constructor untuk membuat objek Lagu
  public Lagu(String judul, String artis, double durasi) {
    this.judul = judul;
    this.artis = artis;
    this.durasi = durasi;
  }

  // Method getter untuk judul lagu
  public String getJudul() {
    return judul;
  }

  // Method getter untuk artis lagu
  public String getArtis() {
    return artis;
  }

  // Method getter untuk durasi lagu
  public double getDurasi() {
    return durasi;
  }

  // Method setter untuk judul lagu
  public void setJudul(String judul) {
    this.judul = judul;
  }

  // Method setter untuk artis lagu
  public void setArtis(String artis) {
    this.artis = artis;
  }

  // Method setter untuk durasi lagu
  public void setDurasi(double durasi) {
    this.durasi = durasi;
  }

  // Method untuk menampilkan informasi lagu
  public void tampilkanInfo() {
    System.out.printf("%s - %s (%.2f menit)%n",
            this.judul,
            this.artis,
            this.durasi);
  }
}