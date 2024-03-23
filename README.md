**İKİLİ ARAMA AĞACI İŞLEMLERİ**

Bu proje, Java dilinde ikili arama ağacı (binary search tree) üzerinde çeşitli işlemler gerçekleştiren bir uygulamayı içerir. İkili arama ağacı, her düğümün en fazla iki çocuğu olan bir veri yapısıdır. Sol alt ağaçtaki düğümler, kök düğümden küçük olan değerlere sahipken, sağ alt ağaçtaki düğümler kök düğümden büyük olan değerlere sahiptir.

**İŞLEVLER**

*1-Veri Ekleme:* Kullanıcıdan alınan bir sayı, ikili arama ağacına eklenir.
*2-Veri Ara:* Kullanıcıdan alınan bir sayının ağaçta olup olmadığı kontrol edilir.
*3-Veri Silme:* Kullanıcıdan alınan bir sayı, ağaçtan silinir.
*4-Ağacı Yazdırma:* İkili arama ağacı, "In-Order" sırasında dolaşılıp yazdırılır.
*5-Matris Oluşturma ve Yazdırma:* İkili arama ağacının geçiş matrisi oluşturulur ve yazdırılır. Bu matris, ağacın yapısını görselleştirir.

**KULLANIM**

Kullanıcı, terminal üzerinden aşağıdaki işlevleri seçerek ikili arama ağacı üzerinde işlem yapabilir:
*Veri Ekle*
*Veri Ara*
*Veri Sil*
*Ağacı Yazdır*
*Matrisi Oluştur ve Yazdır*
*Çıkış*

**ÖRNEK KULLANIM**

```java
public class Main {
    public static void main(String[] args) {
        // İkili arama ağacı işlemleri başlatılır
        IkiliAramaAgaciIslemleri agac = new IkiliAramaAgaciIslemleri();
        
        // Kullanıcı ile etkileşim başlatılır
        // Kullanıcı seçimler yaparak ağaç üzerinde işlemler gerçekleştirir
    }
}
```

**KATKIDA BULUNMA**

Bu proje açık kaynaklıdır ve katkıda bulunmaya açıktır. Eğer bir hata bulursanız veya bir özellik eklemek isterseniz, lütfen bir pull isteği gönderin ya da bir issue açın.
