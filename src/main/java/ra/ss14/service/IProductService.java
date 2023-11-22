package ra.ss14.service;

import org.springframework.web.multipart.MultipartFile;
import ra.ss14.dto.request.ProductRequest;
import ra.ss14.model.Product;

public interface IProductService extends IGenericService<Product, ProductRequest, Integer> {
    void edit (Product product, MultipartFile file);
}
