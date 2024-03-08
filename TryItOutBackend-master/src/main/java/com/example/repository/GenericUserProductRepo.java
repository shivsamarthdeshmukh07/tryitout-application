package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.UserProducts;

import com.example.utility.UserDefinedUserProductsDto;


@Repository
public interface GenericUserProductRepo extends JpaRepository<UserProducts,Integer> {
	

	public UserProducts findByProduct(Product p);

	public UserProducts findByProductAndCartAndVisiblity(Product p,Cart c,String v);

	@Query(value = "select * from user_products where visiblity='pending' and cart_id = :c",nativeQuery = true)
	public List<UserProducts> findAllProductsWhereVisiblityIsPendingAndCartIdIsPresent(@Param("c") Cart c);
	
	@Modifying
	@Query(value="update user_products set quantity = :q + 1 where cart_id = :cid and product_id= :pid",nativeQuery=true)
	public void updateUserProductQuantityByplus1(@Param("q") int quantity,@Param("cid") int cartId,  @Param("pid") int productId);
	
	@Modifying
	@Query(value="update user_products set quantity = :q - 1 where cart_id = :cid and product_id= :pid",nativeQuery=true)
	public void updateUserProductQuantityByminus1(@Param("q") int quantity,@Param("cid") int cartId, @Param("pid") int productId);
	
	
	@Modifying
	@Query(value="update user_products set visiblity= 'deleted' where cart_id= :cid and product_id= :pid", nativeQuery=true)
	public void deleteProductFromCart(@Param("pid") int productId, @Param("cid") int cartId); 
	
	@Modifying
	@Query(value="update user_products set visiblity= 'deleted' where cart_id= :cid", nativeQuery=true)
	public void deleteCart(@Param("cid") Cart cartId); 

	@Query(value = "select id as Id , price as Price, payment_table.payment_date as PaymentDate, "
			+ "payment_table.amount as Amount, payment_table.payment_id as PaymentId, payment_table.provider as "
			+ "Provider,payment_table.status as Status , order_item.order_id as OrderId, user_table.user_id as UserId, "
			+ "product_table.product_id as ProductId, product_table.name as ProductName, product_table.product_img as ProductImg , "
			+ "brand as Brand, category as Category, user_products.quantity as Quantity, user_products.colour as Colour, "
			+ "user_products.size as Size, receipt as Receipt from user_products join cart_table join user_table join payment_table "
			+ "join order_item join product_table where user_products.cart_id = cart_table.cart_id and product_table.product_id = "
			+ "user_products.product_id and cart_table.user_user_id = user_table.user_id and cart_table.cart_id = order_item.cart_id "
			+ "and payment_table.order_id = order_item.order_id and user_products.cart_id = :cid and user_products.visiblity = 'Bought' group by user_products.product_id",nativeQuery = true)
	public List<UserDefinedUserProductsDto> getAllOrderDetails(@Param("cid") int id);
	
	@Modifying
	@Query(value = "update user_products set visiblity = 'Bought' where cart_id = :cid", nativeQuery = true)
	public void updateCartProductsVisiblity(@Param("cid") Cart c);
	
	@Modifying
	@Query(value="update user_products set quantity = :q + 1 where cart_id = :cid",nativeQuery=true)
	public void updateUserProductQuantityByplus1(@Param("q") int quantity,@Param("cid") int cartId);
	
	@Query(value = "select sum(quantity) from user_products where cart_id = :cartId and visiblity = 'pending'",nativeQuery = true)
	public int getCartProductsQuantity(@Param("cartId")int cartId);

}


