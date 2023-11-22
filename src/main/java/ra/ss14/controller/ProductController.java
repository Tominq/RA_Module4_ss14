package ra.ss14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.ss14.dto.request.ProductRequest;
import ra.ss14.model.Product;
import ra.ss14.service.IProductService;

@Controller
@RequestMapping("/exercise14")
public class ProductController {
    @Autowired
    private IProductService productService;

    @PostMapping("/add")
    public String doAddProduct(@ModelAttribute ProductRequest productRequest) {
        productService.save(productRequest);
        return "redirect:/exercise14/product";
    }

    @PostMapping("/edit")
    public String doEditProduct(@ModelAttribute Product product, @RequestParam("file") MultipartFile file){
        productService.edit(product, file);
        return "redirect:/exercise14/product";
    }

    @GetMapping("/delete-product")
    public String doDeleteProduct(@RequestParam("id") int id){
        productService.deleteById(id);
        return "redirect:/exercise14/product";
    }
}
