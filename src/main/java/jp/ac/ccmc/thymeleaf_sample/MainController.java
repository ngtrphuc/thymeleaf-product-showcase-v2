package jp.ac.ccmc.thymeleaf_sample;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    private final List<Map<String, String>> phones = List.of(
        Map.ofEntries(
            Map.entry("id", "1"),
            Map.entry("name", "iPhone 16 Pro Max"),
            Map.entry("price", "249800"),
            Map.entry("image", "/images/iphone16.jpg"),
            Map.entry("os", "iOS 18"),
            Map.entry("ram", "8 GB"),
            Map.entry("cpu", "Apple A18 Pro"),
            Map.entry("speed", "4.05 GHz"),
            Map.entry("storage", "1 TB"),
            Map.entry("size", "6.9 inch"),
            Map.entry("resolution", "2868 x 1320"),
            Map.entry("battery", "4676 mAh"),
            Map.entry("charging", "30W"),
            Map.entry("description", "高級なチタン設計、改良されたカメラ、強力なA18 Proチップを搭載したiPhone 16 Pro Maxです。")
    ),Map.ofEntries(
            Map.entry("id", "2"),
            Map.entry("name", "Samsung Galaxy S25 Ultra"),
            Map.entry("price", "253800"),
            Map.entry("image", "/images/galaxy_s25.jpg"),
            Map.entry("os", "Android 15"),
            Map.entry("ram", "12 GB"),
            Map.entry("cpu", "Snapdragon 8 Elite for Galaxy"),
            Map.entry("speed", "4.47 GHz"),
            Map.entry("storage", "1 TB"),
            Map.entry("size", "6.9 inch"),
            Map.entry("resolution", "3120 x 1440"),
            Map.entry("battery", "5000 mAh"),
            Map.entry("charging", "45W"),
            Map.entry("description", "6.9インチのDynamic AMOLED 2XディスプレイとSペンを搭載したGalaxy S25 Ultraです。")
    ), Map.ofEntries(
            Map.entry("id", "3"),
            Map.entry("name", "Google Pixel 9 Pro XL"),
            Map.entry("price", "212900"),
            Map.entry("image", "/images/pixel9.jpg"),
            Map.entry("os", "Android 15"),
            Map.entry("ram", "16 GB"),
            Map.entry("cpu", "Tensor G4"),
            Map.entry("speed", "3.1 GHz"),
            Map.entry("storage", "1 TB"),
            Map.entry("size", "6.8 inch"),
            Map.entry("resolution", "2992 x 1344"),
            Map.entry("battery", "5060 mAh"),
            Map.entry("charging", "45W"),
            Map.entry("description", "先進的なAIカメラと長期間のソフトウェアアップデートをサポートするPixel 9 Pro XLです。")
    ), Map.ofEntries(
            Map.entry("id", "4"),
            Map.entry("name", "Oppo Find X8 Ultra"),
            Map.entry("price", "165000"),
            Map.entry("image", "/images/oppo_x8.jpg"),
            Map.entry("os", "Android 15"),
            Map.entry("ram", "16 GB"),
            Map.entry("cpu", "Snapdragon 8 Elite"),
            Map.entry("speed", "4.32 GHz"),
            Map.entry("storage", "1 TB"),
            Map.entry("size", "6.82 inch"),
            Map.entry("resolution", "3168 x 1440"),
            Map.entry("battery", "6100 mAh"),
            Map.entry("charging", "100W"),
            Map.entry("description", "超ズームカメラシステムと薄型で高級感のあるデザインを持つFind X8 Ultraです。")
    ), Map.ofEntries(
            Map.entry("id", "5"),
            Map.entry("name", "Vivo X200 Ultra"),
            Map.entry("price", "152200"),
            Map.entry("image", "/images/vivo_x200.jpg"),
            Map.entry("os", "Android 15"),
            Map.entry("ram", "16 GB"),
            Map.entry("cpu", "Snapdragon 8 Elite"),
            Map.entry("speed", "4.32 GHz"),
            Map.entry("storage", "1 TB"),
            Map.entry("size", "6.82 inch"),
            Map.entry("resolution", "3168 x 1440"),
            Map.entry("battery", "6000 mAh"),
            Map.entry("charging", "90W"),
            Map.entry("description", "LTPO 2Kディスプレイとジンバル手ぶれ補正カメラが特徴のVivo X200 Ultraです。")
    ), Map.ofEntries(
            Map.entry("id", "6"),
            Map.entry("name", "Xiaomi 15 Ultra"),
            Map.entry("price", "199800"),
            Map.entry("image", "/images/xiaomi15.jpg"),
            Map.entry("os", "Android 15"),
            Map.entry("ram", "16 GB"),
            Map.entry("cpu", "Snapdragon 8 Elite"),
            Map.entry("speed", "4.32 GHz"),
            Map.entry("storage", "1 TB"),
            Map.entry("size", "6.73 inch"),
            Map.entry("resolution", "3200 x 1440"),
            Map.entry("battery", "5410 mAh"), Map.entry("charging", "90W"),
            Map.entry("description", "90W急速充電技術と1インチセンサーを搭載したXiaomi 15 Ultraです。")
    ), Map.ofEntries(
            Map.entry("id", "7"),
            Map.entry("name", "ASUS ROG Phone 9 Pro"),
            Map.entry("price", "239800"),
            Map.entry("image", "/images/rog9.jpg"),
            Map.entry("os", "Android 15"),
            Map.entry("ram", "24 GB"),
            Map.entry("cpu", "Snapdragon 8 Elite"),
            Map.entry("speed", "4.32 GHz"),
            Map.entry("storage", "1 TB"),
            Map.entry("size", "6.78 inch"),
            Map.entry("resolution", "2400 x 1080"),
            Map.entry("battery", "5800 mAh"),
            Map.entry("charging", "65W"),
            Map.entry("description", "ゲーマー向けに最適化され、強化冷却システムを備えたROG Phone 9 Proです。")
    ), Map.ofEntries(
            Map.entry("id", "8"),
            Map.entry("name", "ZTE Nubia RedMagic 10 Pro"),
            Map.entry("price", "189800"),
            Map.entry("image", "/images/redmagic10.jpg"),
            Map.entry("os", "Android 15"),
            Map.entry("ram", "24 GB"),
            Map.entry("cpu", "Snapdragon 8 Elite"),
            Map.entry("speed", "4.32 GHz"),
            Map.entry("storage", "1 TB"),
            Map.entry("size", "6.85 inch"),
            Map.entry("resolution", "2400 x 1080"),
            Map.entry("battery", "7050 mAh"),
            Map.entry("charging", "80W"),
            Map.entry("description", "144Hzリフレッシュレートディスプレイと内蔵ファンを備えたRedMagic 10 Proです。"))
    );

    public Optional<Map<String, String>> findById(String id) {
        return phones.stream()
                .filter(p -> p.get("id").equals(id))
                .findFirst();
    }

    @GetMapping("/")
    public String showTopPage(@RequestParam(name = "keyword", required = false) String keyword,
            HttpSession session,
            Model model) {
        
        if (session.getAttribute("cartCount") == null) {
            session.setAttribute("cartCount", 0);
        }

        List<Map<String, String>> filtered = phones.stream()
                .filter(p -> keyword == null || p.get("name").toLowerCase().contains(keyword.toLowerCase()))
                .toList();

        model.addAttribute("shopname", "Smartphone Shop");
        model.addAttribute("address", "Asaka, Saitama, Japan");
        model.addAttribute("phones", filtered);
        model.addAttribute("keyword", keyword);

        return "index";
    }

    @GetMapping("/product/{id}")
    public String showItemPage(@PathVariable("id") String id, Model model) {

        Optional<Map<String, String>> phoneOpt = findById(id);

        Map<String, String> product = phoneOpt.orElse(
                Map.of(
                        "id", "0",
                        "name", "製品が見つかりません",
                        "price", "0",
                        "image", "/images/notfound.jpg",
                        "description", "この製品の説明はありません。"
                )
        );

        model.addAttribute("product", product);

        return "detail";
    }
}
