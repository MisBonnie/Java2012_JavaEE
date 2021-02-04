package c_search;

import java.util.List;

public interface ProductDao {
    List<Product> findProductsByPname(String word);
}
