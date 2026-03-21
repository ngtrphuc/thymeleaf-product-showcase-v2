package jp.ac.ccmc.thymeleaf_sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final MainController mainController;

    public CartController(MainController mainController) {
        this.mainController = mainController;
    }

    @SuppressWarnings("unchecked")
    private List<CartItem> getCart(HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    // Hàm này giúp cập nhật số lượng badge (góc phải màn hình)
    private void syncCartCount(HttpSession session) {
        List<CartItem> cart = getCart(session);
        int totalQuantity = cart.stream().mapToInt(CartItem::getQuantity).sum();
        session.setAttribute("cartCount", totalQuantity);
    }

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        List<CartItem> cart = getCart(session);
        int total = cart.stream().mapToInt(CartItem::getTotalPrice).sum();

        syncCartCount(session);
        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "cart";
    }

    @GetMapping("/add")
    public String addToCart(@RequestParam("id") String id, HttpSession session) {
        List<CartItem> cart = getCart(session);
        Optional<Map<String, String>> productOpt = mainController.findById(id);

        if (productOpt.isPresent()) {
            Map<String, String> p = productOpt.get();
            Optional<CartItem> existingItem = cart.stream()
                    .filter(item -> item.getId().equals(id))
                    .findFirst();

            if (existingItem.isPresent()) {
                existingItem.get().setQuantity(existingItem.get().getQuantity() + 1);
            } else {
                int price = Integer.parseInt(p.getOrDefault("price", "0"));
                cart.add(new CartItem(id, p.get("name"), price, 1));
            }
        }
        syncCartCount(session);
        return "redirect:/cart";
    }

    @GetMapping("/increase/{id}")
    public String increase(@PathVariable("id") String id, HttpSession session) {
        List<CartItem> cart = getCart(session);
        cart.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .ifPresent(item -> item.setQuantity(item.getQuantity() + 1));
        syncCartCount(session);
        return "redirect:/cart";
    }

    @GetMapping("/decrease/{id}")
    public String decrease(@PathVariable("id") String id, HttpSession session) {
        List<CartItem> cart = getCart(session);
        CartItem target = cart.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (target != null) {
            if (target.getQuantity() > 1) {
                target.setQuantity(target.getQuantity() - 1);
            } else {
                cart.remove(target);
            }
        }
        syncCartCount(session);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") String id, HttpSession session) {
        getCart(session).removeIf(item -> item.getId().equals(id));
        syncCartCount(session);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        List<CartItem> cart = getCart(session);
        int total = cart.stream().mapToInt(CartItem::getTotalPrice).sum();
        int count = cart.stream().mapToInt(CartItem::getQuantity).sum();

        model.addAttribute("total", total);
        model.addAttribute("count", count);
        model.addAttribute("cart", cart); // Thêm dòng này
        return "checkout";
    }

    @GetMapping("/confirm")
    public String confirm(HttpSession session) {
        session.removeAttribute("cart");
        session.setAttribute("cartCount", 0);
        return "success";
    }
}
