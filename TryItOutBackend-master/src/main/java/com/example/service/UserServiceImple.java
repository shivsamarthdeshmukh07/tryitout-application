package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CartItemsCountResponseDto;
import com.example.dto.CartProductsRequestDto;
import com.example.dto.CartProductsResponseDto;
import com.example.dto.UserAddressDto;
import com.example.dto.UserAddressRequestDto;
import com.example.dto.UserLoginDto;
import com.example.dto.UserProductDeleteRequestDto;
import com.example.dto.UserProductUpdateRequestDto;
import com.example.dto.UserProfileInfoDto;
import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.entity.UserAddress;
import com.example.entity.UserProducts;
import com.example.exception.UserAlreadyPresent;
import com.example.exception.UserException;
import com.example.exception.UserRegistrationException;
import com.example.repository.GenericCartRepo;
import com.example.repository.GenericProductReopository;
import com.example.repository.GenericUserProductRepo;
import com.example.repository.GenericUserRepository;
import com.example.repository.GenricAddressRepo;
import com.example.utility.UserProfileDto;

@Service
@Transactional
public class UserServiceImple implements UserService {

	@Autowired
	private GenericUserProductRepo genUserproductsRepo;

	@Autowired
	private GenericUserRepository genUserRepo;

	@Autowired
	private GenericCartRepo genCartRepo;

	@Autowired
	private GenericProductReopository genProductRepo;

	@Autowired
	private GenricAddressRepo genAddressRepo;

	@Override
	public User addUser(User u) {

		try {
			return genUserRepo.save(u);
		} catch (Exception e) {

			throw new UserRegistrationException("Already registered!");

		}

	}

	@Override
	public UserLoginDto authenticateUser(UserLoginDto uld) {
		User u = null;
		uld.setPassword(uld.getPassword());
		System.out.println(uld.getPassword());
		UserLoginDto userDetails = new UserLoginDto();
		try {
			if ((u = genUserRepo.findByEmailAndPassword(uld.getEmail(), uld.getPassword())) != null) {

				userDetails.setRoleId(u.getRole());
				userDetails.setUserId(u.getUserId());
				userDetails.setStatus(true);
				userDetails.setUserImg(u.getImage());
				return userDetails;
			} else {
				throw new UserException("User Not found!! Please try again.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("User Not found!! Please try again.");
		}

	}

	public List<User> getAllUsersList() {
		try {
			return genUserRepo.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public User getUserById(int id) {

		try {
			return genUserRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println(id);
			e.printStackTrace();
			throw new UserException("User with id not found");
		}

	}

	@Override
	public UserProducts addtoCartProduct(CartProductsRequestDto p) {
		UserProducts cartProduct;
		try {
			User u = getUserById(p.getUserid());
			Cart c = genCartRepo.findByUser(u);

			cartProduct = new UserProducts();

			cartProduct.setCart(c);
			cartProduct.setColour(p.getColour());
			cartProduct.setSize(p.getSize());
			Product product = genProductRepo.findById(p.getProductid()).get();
			String visiblity = "Pending";
			UserProducts up = genUserproductsRepo.findByProductAndCartAndVisiblity(product, c, visiblity);

			if (up == null)
				cartProduct.setProduct(product);
			else {
				throw new UserAlreadyPresent();
			}
			cartProduct.setQuantity(p.getQuantity());
			cartProduct.setVisiblity(p.getStatus());

			return genUserproductsRepo.save(cartProduct);

		} catch (UserAlreadyPresent e) {
			e.printStackTrace();
			throw new UserAlreadyPresent("User is already present");
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("Cart");
		}

	}

	@Override
	public List<CartProductsResponseDto> getAllCartProducts(int cartId) {

		try {
			List<CartProductsResponseDto> product = new ArrayList<CartProductsResponseDto>();
			List<UserProducts> up = genUserproductsRepo
					.findAllProductsWhereVisiblityIsPendingAndCartIdIsPresent(genCartRepo.findById(cartId).get());
			for (UserProducts x : up) {

				CartProductsResponseDto cp = new CartProductsResponseDto();

				cp.setBrand(x.getProduct().getBrand());
				cp.setColour(x.getColour());
				cp.setName(x.getProduct().getName());
				cp.setPrice(x.getProduct().getPrice());
				cp.setProductId(x.getProduct().getProductId());
				cp.setProductImg(x.getProduct().getProductImg());
				cp.setQuantity(x.getQuantity());
				cp.setSize(x.getSize());
				product.add(cp);
			}

			System.out.println(up);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public boolean updateUserProductQuantityByadd1(UserProductUpdateRequestDto updto) {

		try {
			genUserproductsRepo.updateUserProductQuantityByplus1(updto.getQuantity(), updto.getUserCartId(),
					updto.getProductId());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public boolean updateUserProductQuantityBySub1(UserProductUpdateRequestDto updto) {

		try {
			genUserproductsRepo.updateUserProductQuantityByminus1(updto.getQuantity(), updto.getUserCartId(),
					updto.getProductId());
			return true;

		} catch (Exception e) {
			throw e;
		}
	}

	public boolean updateUserCartProducts(int cid) {

		try {
			genUserproductsRepo.updateCartProductsVisiblity(genCartRepo.findById(cid).get());
			return true;

		} catch (Exception e) {
			throw e;
		}
	}

	public boolean addAddress(UserAddressRequestDto userAddress) {

		try {
			UserAddress uAdd = new UserAddress();
			System.out.println(userAddress.isDefault());
			UserAddress ua = genAddressRepo.findByUserAndAddLine1AndAddLine2AndCity(
					genUserRepo.findById(userAddress.getUid()).get(), userAddress.getAddress1(),
					userAddress.getAddress2(), userAddress.getCity());

			if (ua != null) {
				return false;
			}

			if (userAddress.isDefault()) {
				UserAddress uadd = genAddressRepo.findByIsDefault(true);
				System.out.println(uadd);
				if (uadd != null) {
					uadd.setDefault(false);
					genAddressRepo.save(uadd);
					uAdd.setAddLine1(userAddress.getAddress1());
					uAdd.setAddLine2(userAddress.getAddress2());
					uAdd.setCity(userAddress.getCity());
					uAdd.setCountry(userAddress.getCountry());
					uAdd.setFname(userAddress.getFirstName());
					uAdd.setLname(userAddress.getLastName());
					uAdd.setPostalCode(userAddress.getZip());
					uAdd.setState(userAddress.getState());
					uAdd.setUser(genUserRepo.findById(userAddress.getUid()).get());
					uAdd.setDefault(true);
					genAddressRepo.save(uAdd);
				} else {
					uAdd.setAddLine1(userAddress.getAddress1());
					uAdd.setAddLine2(userAddress.getAddress2());
					uAdd.setCity(userAddress.getCity());
					uAdd.setCountry(userAddress.getCountry());
					uAdd.setFname(userAddress.getFirstName());
					uAdd.setLname(userAddress.getLastName());
					uAdd.setPostalCode(userAddress.getZip());
					uAdd.setState(userAddress.getState());
					uAdd.setUser(genUserRepo.findById(userAddress.getUid()).get());
					uAdd.setDefault(true);
					genAddressRepo.save(uAdd);
				}
			} else {

				uAdd.setAddLine1(userAddress.getAddress1());
				uAdd.setAddLine2(userAddress.getAddress2());
				uAdd.setCity(userAddress.getCity());
				uAdd.setCountry(userAddress.getCountry());
				uAdd.setFname(userAddress.getFirstName());
				uAdd.setLname(userAddress.getLastName());
				uAdd.setPostalCode(userAddress.getZip());
				uAdd.setState(userAddress.getState());
				uAdd.setUser(genUserRepo.findById(userAddress.getUid()).get());
				uAdd.setDefault(false);
				genAddressRepo.save(uAdd);
			}

			return true;

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean deleteProductFromTheCart(UserProductDeleteRequestDto delprod) {
		try {
			genUserproductsRepo.deleteProductFromCart(delprod.getProductId(), delprod.getUserCartId());
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Boolean clearCart(int cartId) {

		try {
			genUserproductsRepo.deleteCart(genCartRepo.findById(cartId).get());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public UserProfileDto getUserProfileInfo(int id) {

		try {
			System.out.println(id);
			return genUserRepo.getUserProfileInfo(id);
		} catch (Exception e) {
			throw new UserException("User Details not found");

		}
	}

	public boolean updateAddress(UserAddressDto uAdd) {

		try {
			System.out.println("in user Imple");
			System.out.println(uAdd.getAddId());
			UserAddress userAdd = genAddressRepo.findById(uAdd.getAddId()).get();
			System.out.println(userAdd);

			userAdd.setAddLine1(uAdd.getAddLine1());
			userAdd.setAddLine2(uAdd.getAddLine2());
			userAdd.setCity(uAdd.getCity());
			userAdd.setCountry(uAdd.getCountry());
			userAdd.setPostalCode(uAdd.getPostalCode());
			userAdd.setState(uAdd.getState());
			System.out.println(userAdd);
			if (genAddressRepo.save(userAdd) != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			throw new UserException("Address not updated");
		}
	}

	public boolean userInfoUpdate(UserProfileInfoDto userDto) {
		try {
			User u = genUserRepo.findById(userDto.getUserId()).get();

			u.setFirstName(userDto.getFirstName());
			u.setLastName(userDto.getLastName());
			u.setMobile(userDto.getMobile());

			if (genUserRepo.save(u) != null)
				return true;
			return false;
		} catch (Exception e) {
			throw new UserException("User not updated");
		}
	}

	public CartItemsCountResponseDto getCartItemsQuantity(int cartId) {
		CartItemsCountResponseDto dto = null;
		try {
			dto = new CartItemsCountResponseDto();
			dto.setQuantity(genUserproductsRepo.getCartProductsQuantity(cartId));
			dto.setStatus("success");
			return dto;

		} catch (Exception e) {
			dto = new CartItemsCountResponseDto();
			dto.setQuantity(0);
			dto.setStatus("fail");
			return dto;
		}
	}

}
