import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CobaUmur1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan tanggal lahir (1-31): ");
        int hariLahir = scanner.nextInt();

        System.out.print("Masukkan bulan lahir (1-12): ");
        int bulanLahir = scanner.nextInt();

        System.out.print("Masukkan tahun lahir (misal: 1990): ");
        int tahunLahir = scanner.nextInt();

        LocalDate tanggalLahir = LocalDate.of(tahunLahir, bulanLahir, hariLahir);
        Period usia = hitungUsia(tanggalLahir);

        // Tampilkan usia dalam tahun, bulan, dan hari
        System.out.printf("Usia Anda saat ini: %d tahun, %d bulan, dan %d hari.%n",
                usia.getYears(), usia.getMonths(), usia.getDays());

        // Fitur tambahan: Menghitung hari menuju ulang tahun berikutnya
        long hariMenujuUlangTahun = hitungHariMenujuUlangTahun(tanggalLahir);
        System.out.printf("Hari hingga ulang tahun Anda berikutnya: %d hari.%n", hariMenujuUlangTahun);
    }

    private static Period hitungUsia(LocalDate tanggalLahir) {
        LocalDate sekarang = LocalDate.now();
        return Period.between(tanggalLahir, sekarang);
    }

    // Fitur tambahan: Menghitung hari menuju ulang tahun berikutnya
    private static long hitungHariMenujuUlangTahun(LocalDate tanggalLahir) {
        LocalDate sekarang = LocalDate.now();
        LocalDate ulangTahunBerikutnya = tanggalLahir.withYear(sekarang.getYear());

        if (ulangTahunBerikutnya.isBefore(sekarang) || ulangTahunBerikutnya.isEqual(sekarang)) {
            ulangTahunBerikutnya = ulangTahunBerikutnya.plusYears(1);
        }

        return ChronoUnit.DAYS.between(sekarang, ulangTahunBerikutnya);
    }
}
