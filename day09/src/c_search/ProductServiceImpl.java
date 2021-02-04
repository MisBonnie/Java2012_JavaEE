package c_search;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> findProductsByWord(String word) {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.findProductsByPname(word);
    }
}
