import java.util.Scanner;
import java.util.Random;

public class OyunParki {
    public static void main(String[] args) {
        Giris giris = new Giris();
        giris.girisYap();




        // Personel bilgilerini görüntüle
        Personel personel = new Personel();
        personel.personelBilgileri();
    }
}

class Giris {
    public static int toplamGirisSayisi = 0;
    public static int toplamBinenSayisi = 0;
    public static int abonmanUyeSayisi = 0;
    public static int abonmanIptalSayisi = 0;
    public static int gunlukGelir = 0;
    public static int haftalikGelir = 0;
    private VeriOlcum veriOlcum = new VeriOlcum();

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
    }
}

class VeriOlcum {
    public void veriOlcumu(int toplamGirisSayisi, int toplamBinenSayisi) {
        double dolulukOrani = (double) toplamGirisSayisi / 100 * 100;
        double gurultuSeviyesi = 50 + toplamBinenSayisi * 0.5;
        double elektrikTuketimi = toplamBinenSayisi * 1.2;
        double isiUretimi = 22 + toplamBinenSayisi * 0.2;

        System.out.println("Veri Ölçümü:");
        System.out.println("Gürültü Seviyesi: " + gurultuSeviyesi + " dB");
        System.out.println("Doluluk Oranı: " + dolulukOrani + "%");
        System.out.println("Elektrik Tüketimi: " + elektrikTuketimi + " kW");
        System.out.println("Isı Üretimi: " + isiUretimi + " °C");
    }
}



class Personel {
    public void personelBilgileri() {
        System.out.println("\n--- Personel Bilgileri ---");

        System.out.println("Müşteri Destek: Ayşe Yılmaz, Nöbet: Gündüz, İzin Günleri: Cumartesi");
        System.out.println("Oyuncak Bakım: Mehmet Can, Nöbet: Gece, İzin Günleri: Pazar");
        System.out.println("Maaşlar: Ayşe: 9.000 TL, Mehmet: 10.000 TL");
    }
}