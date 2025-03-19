import java.util.Scanner;
import java.util.Random;

public class OyunParki {
    public static void main(String[] args) {
        Giris giris = new Giris();
        giris.girisYap();
    }
}

class Giris {
    public static int toplamGirisSayisi = 100;
    public static int toplamBinenSayisi = 50;
    public static int abonmanUyeSayisi = 95;
    public static int abonmanIptalSayisi = 02;
    public static int gunlukGelir = 3500;
    public static int haftalikGelir = 0;
    private VeriOlcum veriOlcum = new VeriOlcum();
    private Raporlama raporlama = new Raporlama();

    public void girisYap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Oyun Parkına Hoş Geldiniz! Lütfen yaşınızı giriniz:");
        int yas = scanner.nextInt();

        System.out.println("Lütfen giriş yöntemini seçin:");
        System.out.println("1. Abonman Kart");
        System.out.println("2. Nakit");
        System.out.println("3. Kart ile Günübirlik");
        System.out.println("4. QR Kartı Doğrulama");

        int secim = scanner.nextInt();
        toplamGirisSayisi++;
        //veriOlcum.veriOlcumu(toplamGirisSayisi, toplamBinenSayisi);

        switch (secim) {
            case 1:
                abonmanKart();
                abonmanUyeSayisi++;
                break;
            case 2:
                nakit();
                gunlukGelir += 50;
                haftalikGelir += 50;
                break;
            case 3:
                kartIleGunubirlik();
                gunlukGelir += 50;
                haftalikGelir += 50;
                break;
            case 4:
                qrKartiDogrulama();
                break;
            default:
                System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
                girisYap();
        }
        oyuncagaBin(yas);
    }

    private void abonmanKart() {
        System.out.println("Abonman Kart ile giriş yapıldı.");
        System.out.println("Kart numaranızı giriniz: ");
        Scanner scanner = new Scanner(System.in);
        String kartNumarasi = scanner.nextLine();
        System.out.println("Kart numarası " + kartNumarasi + " doğrulandı. Giriş başarılı!");

        Random rand = new Random();
        int kalanGun = rand.nextInt(30) + 1;
        System.out.println("Kart süreniz " + kalanGun + " gün içinde dolacaktır. Yenilemek için danışmaya başvurabilirsiniz.");
    }

    private void nakit() {
        System.out.println("Nakit ödeme alındı, giriş yapıldı.");
        System.out.println("Lütfen 50 TL ödeme yapınız.");
        System.out.println("Ödeme alındı. İyi eğlenceler!");
    }

    private void kartIleGunubirlik() {
        System.out.println("Kart ile günübirlik giriş yapıldı.");
        System.out.println("Lütfen kartınızı pos cihazına okutun.");
        System.out.println("Ödeme başarılı. Giriş yapabilirsiniz!");
    }

    private void qrKartiDogrulama() {
        Random rand = new Random();
        boolean basarili = rand.nextBoolean();

        if (basarili) {
            System.out.println("QR Kart doğrulandı, giriş yapıldı.");
            System.out.println("Lütfen QR kodunuzu okutun.");
            System.out.println("QR kod başarıyla okundu. İyi eğlenceler!");
        } else {
            System.out.println("QR Kart doğrulama başarısız! Lütfen tekrar deneyin.");
        }
    }

    private void oyuncagaBin(int yas) {
        toplamBinenSayisi++;
        System.out.println("Bir oyuncağa binildi!");

        String muzik = yas < 10 ? "Çocuk Şarkıları" : yas < 18 ? "Pop Müzik" : "Rock Müzik";
        int hiz = yas < 10 ? 5 : yas < 18 ? 10 : 15;
        int sure = yas < 10 ? 5 : yas < 18 ? 10 : 15;

        System.out.println("Yaşınıza uygun olarak oyuncağın hızı: " + hiz + " km/h");
        System.out.println("Çalacak müzik türü: " + muzik);
        System.out.println("Oyuncakta geçirebileceğiniz süre: " + sure + " dakika");

        veriOlcum.veriOlcumu(toplamGirisSayisi, toplamBinenSayisi);
    }
}

class VeriOlcum {
    public void veriOlcumu(int toplamGirisSayisi, int toplamBinenSayisi) {
        double kapasite = 100;
        double dolulukOrani = (double) toplamGirisSayisi / kapasite * 100;
        double gürültüSeviyesi = 50 + toplamBinenSayisi * 0.5;
        double elektrikTuketimi = toplamBinenSayisi * 1.2;
        double isiUretimi = 22 + toplamBinenSayisi * 0.2;

        System.out.println("Veri Ölçümü Yapılıyor...");
        System.out.println("Gürültü Seviyesi: " + gürültüSeviyesi + " dB");
        System.out.println("Doluluk Oranı: " + dolulukOrani + "%");
        System.out.println("Elektrik Tüketimi: " + elektrikTuketimi + " kW");
        System.out.println("Isı Üretimi: " + isiUretimi + " °C");
    }
}

class Raporlama {
    public void gunlukRapor() {
        System.out.println("Günlük Giriş Sayısı: " + Giris.toplamGirisSayisi);
        System.out.println("Abonman Üyeliğine Sahip Kişi Sayısı: " + Giris.abonmanUyeSayisi);
        System.out.println("Günlük Kazanç: " + Giris.gunlukGelir + " TL");
    }

    public void haftalikRapor() {
        System.out.println("Haftalık Kazanç: " + Giris.haftalikGelir + " TL");
        System.out.println("Abonman Üyeliğini İptal Ettiren Kişi Sayısı: " + Giris.abonmanIptalSayisi);
    }
}
