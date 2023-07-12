package com.cdac.training.dao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cdac.training.bean.Product;
@Service
public class ProductManagerImpl implements ProductManager {
	private List<Product> products;
	
	public ProductManagerImpl() {
		
		this.products = new ArrayList<Product>();;
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public Product getProductById(int prodId) {
//		return products.stream()
//				.filter(product -> product.getProdId().equals(prodId))
//				.findFirst()
//				.orElseThrow(() -> new IllegalArgumentException("Invalid product id"+prodId));
		Product temp=null;
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getProdId()==prodId) {
				temp=products.get(i);
			}
		}
		return temp;
	}

	@Override
	public void addProduct(Product product) {
		products.add(product);

	}

	@Override
	public void modProduct(Product product) {
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getProdId()==product.getProdId()) {
				System.out.println("found:"+products.get(i));
				products.remove(i);
				products.add(i, product);
				System.out.println("added updated data:"+products.get(i));
				
			}
		}
	}

	@Override
	public void delProductById(int prodId) {
		Product temp=getProductById(prodId);
		if(temp!=null) {
			products.remove(temp);
			System.out.println("Product deleted:"+temp);
		}else {
			System.err.println("Entered Prod Id not found:"+ prodId);
		}
	}

	@Override
	public void delAllProduct() {
		if(products.size()>0) {
			System.out.println("All products has been deleted..");
		}else {
			System.err.println("No product found...");
		}
	}
}
