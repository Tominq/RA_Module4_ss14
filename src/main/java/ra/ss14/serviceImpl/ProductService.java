package ra.ss14.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.ss14.dao.IProductDao;
import ra.ss14.dto.request.ProductRequest;
import ra.ss14.model.Product;
import ra.ss14.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Autowired
    private  UploadService uploadService;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public boolean save(ProductRequest productRequest) {
        String imageUrl = null;
        if (!productRequest.getFile().isEmpty()) {
            imageUrl = uploadService.uploadFileToServer(productRequest.getFile());
        }
        Product product = new Product(
                productRequest.getName(),
                imageUrl,
                productRequest.getPrice(),
                productRequest.getDesc(),
                productRequest.getStock());
        return productDao.save(product);
    }

    @Override
    public void edit(Product product, MultipartFile file) {
        if (!file.isEmpty()) {
            product.setImageUrl(uploadService.uploadFileToServer(file));
        }
        productDao.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        productDao.deleteById(id);
    }


}
