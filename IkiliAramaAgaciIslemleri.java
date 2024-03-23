import java.util.Scanner;

class Dugum {
    int veri;
    Dugum sol, sag;

    public Dugum(int eleman) {
        veri = eleman;
        sol = sag = null;
    }
}

public class IkiliAramaAgaciIslemleri {
    Dugum kok;

    IkiliAramaAgaciIslemleri() {
        kok = null;
    }

    void ekle(int veri) {
        kok = ekleRec(kok, veri);
    }

    Dugum ekleRec(Dugum kok, int veri) {
        if (kok == null) {
            kok = new Dugum(veri);
            return kok;
        }

        if (veri < kok.veri)
            kok.sol = ekleRec(kok.sol, veri);
        else if (veri > kok.veri)
            kok.sag = ekleRec(kok.sag, veri);

        return kok;
    }

    Dugum ara(Dugum kok, int veri) {
        if (kok == null || kok.veri == veri)
            return kok;

        if (veri < kok.veri)
            return ara(kok.sol, veri);
        return ara(kok.sag, veri);
    }

    Dugum enKucukDugum(Dugum dugum) {
        Dugum current = dugum;
        while (current.sol != null)
            current = current.sol;
        return current;
    }

    Dugum sil(Dugum kok, int veri) {
        if (kok == null)
            return kok;

        if (veri < kok.veri)
            kok.sol = sil(kok.sol, veri);
        else if (veri > kok.veri)
            kok.sag = sil(kok.sag, veri);
        else {
            if (kok.sol == null)
                return kok.sag;
            else if (kok.sag == null)
                return kok.sol;

            kok.veri = enKucukDugum(kok.sag).veri;
            kok.sag = sil(kok.sag, kok.veri);
        }

        return kok;
    }

    void inorderDolas(Dugum kok) {
        if (kok != null) {
            inorderDolas(kok.sol);
            System.out.print(kok.veri + " ");
            inorderDolas(kok.sag);
        }
    }

    void matrisiYazdir() {
        int[][] matris = matrisOlustur(kok);

        System.out.println("Geçiş Matrisi:");
        for (int[] satir : matris) {
            for (int deger : satir) {
                System.out.print(deger + " ");
            }
            System.out.println();
        }
    }

    int[][] matrisOlustur(Dugum kok) {
        int boyut = agacBoyutu(kok);
        int[][] matris = new int[boyut][boyut];

        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                matris[i][j] = cocukMu(kok, i + 1, j + 1) ? 1 : 0;
            }
        }

        return matris;
    }

    int agacBoyutu(Dugum kok) {
        if (kok == null)
            return 0;
        return 1 + agacBoyutu(kok.sol) + agacBoyutu(kok.sag);
    }

    boolean cocukMu(Dugum kok, int ebeveyn, int cocuk) {
        if (kok == null)
            return false;

        if (ebeveyn == 1 && cocuk == 1)
            return true;

        return cocukMu(kok.sol, ebeveyn - 1, cocuk) || cocukMu(kok.sag, ebeveyn - 1, cocuk);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IkiliAramaAgaciIslemleri agac = new IkiliAramaAgaciIslemleri();

        while (true) {
            System.out.println("1. Veri Ekle");
            System.out.println("2. Veri Ara");
            System.out.println("3. Veri Sil");
            System.out.println("4. Yazdır");
            System.out.println("5. Matrisi Oluştur ve Yazdır");
            System.out.println("0. Çıkış");
            System.out.println("Seçenek Girin: ");

            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Eklenecek Sayıyı Girin: ");
                    int eklemeVerisi = scanner.nextInt();
                    agac.ekle(eklemeVerisi);
                    break;
                case 2:
                    System.out.println("Aranacak Sayıyı Girin: ");
                    int aramaVerisi = scanner.nextInt();
                    Dugum bulunanDugum = agac.ara(agac.kok, aramaVerisi);
                    System.out.println(bulunanDugum != null ? "Sayı Bulundu" : "Sayı Bulunamadı");
                    break;
                case 3:
                    System.out.println("Silinecek Sayıyı Girin: ");
                    int silmeVerisi = scanner.nextInt();
                    agac.kok = agac.sil(agac.kok, silmeVerisi);
                    break;
                case 4:
                    System.out.print("İkili Arama Ağacı (In-Order): ");
                    agac.inorderDolas(agac.kok);
                    System.out.println();
                    break;
                case 5:
                    agac.matrisiYazdir();
                    break;
                case 0:
                    System.out.println("Çıkış Yapılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz Seçenek!");
            }
        }
    }
}
