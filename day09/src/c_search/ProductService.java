package c_search;

import java.util.List;

public interface ProductService {
    List<Product> findProductsByWord(String word);
}
