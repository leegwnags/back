package product;

import java.util.List;

public interface Service {

	int register(ProductVO pvo);

	int remove(int pno);

	int edit(ProductVO productVO);

	ProductVO detail(int pno);

	List<ProductVO> list();
	
}
