package com.mvp.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mvp.DAO.CommentDAO;
import com.mvp.DAO.ProducerDAO;
import com.mvp.DAO.ProductDAO;
import com.mvp.DAO.ProductTypeDAO;
import com.mvp.DAO.StaffDAO;
import com.mvp.model.Account;
import com.mvp.model.Color;
import com.mvp.model.Image;
import com.mvp.model.Material;
import com.mvp.model.Producer;
import com.mvp.model.Product;
import com.mvp.model.ProductImage;
import com.mvp.model.ProductPrice;
import com.mvp.model.ProductType;
import com.mvp.model.ShoeSize;
import com.mvp.model.ShoppingCart;
import com.mvp.services.ProductServices;
import com.mvp.services.SupportServices;

@Controller
public class ProductController {
	@RequestMapping(value="/getListProductPrice/{typeID}/{searchContent}", method = RequestMethod.GET)
	public String getListProducer(@PathVariable String typeID, @PathVariable String searchContent, ModelMap md) {
		List<ProductPrice> list = ProductDAO.getInstance().GetPriceProductList();		
		try {
			if(!searchContent.equals("-1")) {
				if(typeID.equals("CNMSP"))
					list =  list.stream().filter(p->p.getiD().toLowerCase().contains(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("CNTSP"))
					list =  list.stream().filter(p->p.getName().toLowerCase().contains(searchContent.toLowerCase())).collect(Collectors.toList());
				else if(typeID.equals("CNG"))
					list =  list.stream().filter(p->p.getPrice().contains(searchContent.trim())).collect(Collectors.toList());
				else if(typeID.equals("CNGG"))
					list =  list.stream().filter(p->p.getDiscount() == Integer.parseInt(searchContent.trim())).collect(Collectors.toList());
			}
		}
		catch(Exception e){
			list = null;
		}
		
		md.addAttribute("list", list);
		return "ajax/updatePrice";
	}
	
	@RequestMapping(value="/getProductList/{mID}/{pID}/{ptID}/{typeID}/{searchContent}/{page}", method = RequestMethod.GET )
	public String getProductList(@PathVariable String mID, @PathVariable String pID, @PathVariable String ptID, 
			@PathVariable String typeID, @PathVariable String searchContent,@PathVariable int page, ModelMap md) {
		
		List<Product> list = ProductDAO.getInstance().GetProductList();
		if(!mID.equals("0"))
			list = list.stream().filter(p->p.getMaterialID() == Integer.parseInt(mID)).collect(Collectors.toList());
		
		if(!pID.equals("0"))
			list = list.stream().filter(p->p.getProducerID() == Integer.parseInt(pID)).collect(Collectors.toList());
		
		if(!ptID.equals("0"))
			list = list.stream().filter(p->p.getTypeID() == Integer.parseInt(ptID)).collect(Collectors.toList());
		
		try {	

			if(!searchContent.equals("-1")) {
				if(typeID.equals("TKMSP"))
					list =  list.stream().filter(p->p.getiD().toLowerCase().contains(searchContent.toLowerCase().trim())).collect(Collectors.toList());
				else if(typeID.equals("TKTSP"))
					list =  list.stream().filter(p->p.getName().toLowerCase().contains(searchContent.toLowerCase().trim())).collect(Collectors.toList());
				else if(typeID.equals("TKG"))
					list =  list.stream().filter(p->p.getPrice().contains(searchContent.trim())).collect(Collectors.toList());
				else if(typeID.equals("TKGG"))
					list =  list.stream().filter(p->p.getDiscount() == Integer.parseInt(searchContent.trim())).collect(Collectors.toList());
			}
		}
		catch(Exception e){
			list = null;
		}
		
		
		int pageSize = 10;
		int lsize = list.size();
		
		int pageNums = lsize/pageSize;
		if(lsize % pageSize != 0)
			pageNums += 1;
		
		int startPos = (page-1) * pageSize;
		
		list = list.stream().skip(startPos).limit(pageSize).collect(Collectors.toList());
		
		md.addAttribute("page", page);
		md.addAttribute("pageNums", pageNums);
		md.addAttribute("list", list);
		
		return "ajax/productList";
	}
	
	@RequestMapping(value = "/searchShoeList", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String shoeList(ModelMap md) {
		List<Product> list = ProductDAO.getInstance().GetProductList();
		md.addAttribute("list", list);
		
		return "ajax/selectBoxShoeList";
	}
	
	@RequestMapping(value="/getLowStockList", method = RequestMethod.GET )
	public String getLowStockList(ModelMap md) {
		
		List<Product> list = ProductDAO.getInstance().GetLowStockProduct();
		md.addAttribute("list", list);
		
		return "ajax/lowStockList";
	}
	
	
	@RequestMapping(value="/deleteProduct/{ID}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String deleteProduct(@PathVariable String ID ,ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldProduct = (ProductDAO.getInstance().GetProductByID(ID)).getName();		
		String log = staffName + " ("+username+") " + "đã xóa giày "+oldProduct;
		
		if(ProductServices.getInstance().DeleteProduct(ID)) {
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Xóa sản phẩm thành công";
		}
		else
			return "Đã xảy ra lỗi khi xóa sản phẩm";
	}
	
	@RequestMapping(value="/updateDiscount/{ID}/{Discount}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String updateDiscount(@PathVariable String ID, @PathVariable String Discount ,ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldProduct = (ProductDAO.getInstance().GetProductByID(ID)).getName();		
		String log = staffName + " ("+username+") " + "đã cập nhật giảm giá giày "+oldProduct;
		
		if(ProductServices.getInstance().updateDiscount(ID, Discount)) {
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Cập nhật giảm giá sản phẩm thành công";
		}
		else
			return "Đã xảy ra lỗi khi cập nhật giảm giá sản phẩm";
	}
	
	@RequestMapping(value="/updatePrice/{ID}/{Price}",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String updatePrice(@PathVariable String ID, @PathVariable String Price ,ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldProduct = (ProductDAO.getInstance().GetProductByID(ID)).getName();		
		String log = staffName + " ("+username+") " + "đã cập nhật giá giày "+oldProduct;
		
		if(ProductServices.getInstance().updatePrice(ID, Price)) {
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
			return "Cập nhật giá sản phẩm thành công";
		}
		else
			return "Đã xảy ra lỗi khi cập nhật giá sản phẩm";
	}
	
	@RequestMapping(value="/getProducer/{ID}", method = RequestMethod.GET )
	public String getProducer(@PathVariable String ID, ModelMap md) {
		
		List<Producer> list = ProductDAO.getInstance().GetProducerList();
		md.addAttribute("list", list);
		md.addAttribute("id", ID);
		
		return "ajax/producer";
	}
	
	@RequestMapping(value="/getColor", method = RequestMethod.GET )
	public String getColor(ModelMap md) {
		
		List<Color> list = ProductDAO.getInstance().GetColorList();
		md.addAttribute("list", list);
		
		return "ajax/color";
	}
	
	@RequestMapping(value="/getMaterial/{ID}", method = RequestMethod.GET )
	public String getMaterial(@PathVariable String ID,ModelMap md) {
		
		List<Material> list = ProductDAO.getInstance().GetMaterialList();
		md.addAttribute("list", list);
		md.addAttribute("id", ID);
		
		return "ajax/material";
	}
	
	@RequestMapping(value="/getSize", method = RequestMethod.GET )
	public String getSize(ModelMap md) {
		
		List<ShoeSize> list = ProductDAO.getInstance().GetSizeList();
		md.addAttribute("list", list);
		
		return "ajax/size";
	}
	
	@RequestMapping(value="/getProductType/{ID}", method = RequestMethod.GET )
	public String getProductType(@PathVariable String ID,ModelMap md) {
		
		List<ProductType> list = ProductDAO.getInstance().GetProductTypeList();
		md.addAttribute("list", list);
		md.addAttribute("id", ID);
		
		return "ajax/producttype";
	}
	
	
	@RequestMapping(value="/addProductAD",  method = RequestMethod.POST,produces = "text/html; charset=utf-8", headers=("content-type=multipart/*"))
	@ResponseBody
	public String AddProductAD(@RequestParam("iD") String ID,@RequestParam("name") String Name,
			@RequestParam("producerID") String ProducerID, @RequestParam("materialID") String MaterialID,
					@RequestParam("price") String Price, @RequestParam("discount") int Discount,
					@RequestParam("typeID") String TypeID, @RequestParam("image") MultipartFile Image,
					@RequestParam("description") String Description, HttpSession session) throws IOException {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();		
		String log = staffName + " ("+username+") " + "đã thêm mới giày ";
		
		String notify = "";
		try {
		
			if(!Image.isEmpty()) {
				byte[] contents = Image.getBytes();
				if(ProductServices.getInstance().AddProductAD(ID, Name, 0,Integer.parseInt(ProducerID), Integer.parseInt(MaterialID), Price, 
						Discount, contents,Integer.parseInt(TypeID), Description)) {
					notify = "Đã thêm thành công sản phẩm";
					if(SupportServices.getInstance().AddNewLog(log + Name))
						System.out.println("Thêm nhật ký hệ thống thành công");
					else
						System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				}
				else {
					notify= "Đã xảy ra lỗi khi thêm sản phẩm, vui lòng kiểm tra lại thông tin nhập";
				}	
			}
			else {
				notify= "Đã xảy ra lỗi khi thêm sản phẩm, vui lòng kiểm tra lại thông tin nhập";
			}	
		}
		catch(Exception e) {
			notify= "Đã xảy ra lỗi khi thêm sản phẩm, vui lòng kiểm tra lại thông tin nhập";
		}
		
		return notify;
	}
	
	@RequestMapping(value="/product/{ID}",  method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String product(@PathVariable String ID, ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		
		if(acc == null) {
			session.setAttribute("url", "/VerOne/login" );
			session.setAttribute("headerText","Đăng nhập/Đăng ký" );			
		    synchronized(session) {
		        ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		        if (cart == null) {
		          cart = new ShoppingCart();
		          session.setAttribute("shoppingCart", cart);
		        }
		    }
		}
		else {
			if(acc.getPhanQuyen() == 4) {
				session.setAttribute("user", acc);
				session.setAttribute("url", "/VerOne/home" );
				session.setAttribute("headerText","Tài khoản: " + acc.getCus().getName());
			}
			else if(acc.getPhanQuyen() == 3){
				session.setAttribute("user", acc);
				session.setAttribute("url", "/VerOne/profile" );
				session.setAttribute("headerText",acc.getTenDangNhap() );
			}
			else if(acc.getPhanQuyen() == 2){
				session.setAttribute("user", acc);
				session.setAttribute("url", "/VerOne/profile" );
				session.setAttribute("headerText",acc.getTenDangNhap() );
			}
			else if(acc.getPhanQuyen() == 1){
				session.setAttribute("user", acc);
				session.setAttribute("url", "/VerOne/profile" );
				session.setAttribute("headerText", acc.getTenDangNhap() );
			}
		    synchronized(session) {
		        ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		        if (cart == null) {
		          cart = new ShoppingCart();
		          session.setAttribute("shoppingCart", cart);
		        }
		    }
		}
		
		Product p = ProductDAO.getInstance().GetProductByID(ID);
		List<ShoeSize> size = ProductDAO.getInstance().GetSizeListByPID(ID);
		List<Color> color = ProductDAO.getInstance().GetColorListByPID(ID);
		List<Product> productList = ProductDAO.getInstance().GetHotProductByTypeID(p.getTypeID());
		int cid = 0;
		try {
			cid = color.get(0).getiD();
		}
		catch(Exception ex) {
			
		}
		List<Image> image = ProductDAO.getInstance().getListImageByPIDAndColorID(ID, cid);
		int NumsComment = CommentDAO.getInstance().CountComment(ID);
		float NumsStar = CommentDAO.getInstance().GetStar(ID);
		
		md.addAttribute("product", p);
		md.addAttribute("color", color);
		md.addAttribute("size", size);
		md.addAttribute("numsComment", NumsComment);
		md.addAttribute("numsStar", NumsStar);
		md.addAttribute("productList", productList);
		md.addAttribute("image", image);
		
		return "productdetail";
	}
	
	@RequestMapping(value="/viewProductDetail/{ID}",  method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String viewProductDetail(@PathVariable String ID, ModelMap md) {
		
		Product p = ProductDAO.getInstance().GetProductByID(ID);
		
		md.addAttribute("product", p);
		
		return "ajax/viewProductDetail";
	}
	
	@RequestMapping(value="/editProduct/{ID}/{mID}/{pID}/{ptID}",  method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String editProduct(@PathVariable String ID, @PathVariable String mID, @PathVariable String pID, @PathVariable String ptID, 
			ModelMap md) {
		
		Product p = ProductDAO.getInstance().GetProductByID(ID);
		
		md.addAttribute("product", p);
		
		List<Material> list = ProductDAO.getInstance().GetMaterialList();
		md.addAttribute("list", list);
		
		List<Producer> list1 = ProductDAO.getInstance().GetProducerList();
		md.addAttribute("list1", list1);
		
		List<ProductType> list2 = ProductDAO.getInstance().GetProductTypeList();
		md.addAttribute("list2", list2);
		
		
		md.addAttribute("mID", mID);
		md.addAttribute("pID", mID);
		md.addAttribute("ptID", mID);
		
		return "ajax/editProduct";
	}
	
	@RequestMapping(value="/editProductImage/{ID}",  method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String editProductImage(@PathVariable String ID, ModelMap md) {
		
		Product pr = ProductDAO.getInstance().GetProductByID(ID);
		md.addAttribute("product", pr);
		
		List<ProductImage> lst = ProductDAO.getInstance().GetProductImageList(ID);
		md.addAttribute("listProductImage",lst);
		
		List<Color> list = ProductDAO.getInstance().GetColorList();
		md.addAttribute("listColor", list);
		
		
		return "ajax/editImageWithColor";
	}
	
	@RequestMapping(value="/deleteProductImage/{pID}/{cID}/{keyID}",  method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String deleteProductImage(@PathVariable String pID, @PathVariable String cID, @PathVariable String keyID, 
			ModelMap md, HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldProduct = (ProductDAO.getInstance().GetProductByID(pID)).getName();		
		String log = staffName + " ("+username+") " + "đã xóa hình ảnh của giày "+oldProduct;
		
		String notify = "";
		
		if(ProductServices.getInstance().DeleteProductImage(pID, Integer.parseInt(cID), Integer.parseInt(keyID))) {
			notify = "Xóa hình ảnh này thành công!";
			if(SupportServices.getInstance().AddNewLog(log))
				System.out.println("Thêm nhật ký hệ thống thành công");
			else
				System.out.println("Có lỗi khi thêm nhật ký hệ thống");
		}
		else {
			notify = "Không thể xóa hình ảnh này!";
		}
		
		return notify;
	}
	
	@RequestMapping(value="/editProductImageDetail",  method = RequestMethod.POST,produces = "text/html; charset=utf-8", headers=("content-type=multipart/*"))
	@ResponseBody
	public String EditProductDetail(@RequestParam("pID") String pID, @RequestParam("piColorID") String cID,
						@RequestParam("piKeyID") String keyID, @RequestParam("piImage") MultipartFile Image,
						HttpSession session) throws IOException {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldProduct = (ProductDAO.getInstance().GetProductByID(pID)).getName();		
		String log = staffName + " ("+username+") " + "đã chỉnh sửa hình ảnh của giày "+oldProduct;
		
		String notify = "";
		try {		
			if(!Image.isEmpty()) {
				byte[] contents = Image.getBytes();
				if(ProductServices.getInstance().EditProductHasColorHasImage(pID, Integer.parseInt(cID), Integer.parseInt(keyID), 
						contents)) {
					notify = "Chỉnh sửa hình ảnh thành công!";
					if(SupportServices.getInstance().AddNewLog(log))
						System.out.println("Thêm nhật ký hệ thống thành công");
					else
						System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				}else {
					notify = "Không thể chỉnh sửa hình ảnh này!";
				}
			}
			else{
				if(ProductServices.getInstance().EditProductHasColorNoImage(pID, Integer.parseInt(cID), Integer.parseInt(keyID))) {
					notify = "Chỉnh sửa màu thành công!";
				}else {
					notify = "Không thể chuyển đổi sang màu này!";
				}
			}	
		}
		catch(Exception e) {
			notify= "Đã xảy ra lỗi khi chỉnh sửa sản phẩm, vui lòng kiểm tra lại thông tin nhập";
		}
		
		return notify;
	}
	
	@RequestMapping(value="/editProductDetail",  method = RequestMethod.POST,produces = "text/html; charset=utf-8", headers=("content-type=multipart/*"))
	@ResponseBody
	public String EditProductDetail(@RequestParam("pProductID") String ID,@RequestParam("pName") String Name,
			@RequestParam("pPrice") String Price, @RequestParam("pDiscount") int Discount,
			@RequestParam("pMaterialID") String MaterialID,	@RequestParam("pProducerID") String ProducerID, 			
			@RequestParam("pProductTypeID") String TypeID, 
			@RequestParam("pDescription") String Description, @RequestParam("pImage") MultipartFile Image,
			HttpSession session) throws IOException {
		
		Account acc = (Account)session.getAttribute("user");
		String staffName = (StaffDAO.getInstance().GetStaffByID(acc.getMaNguoiDung())).getTenNV();
		String username = acc.getMaNguoiDung();
		String oldProduct = (ProductDAO.getInstance().GetProductByID(ID)).getName();		
		String log = staffName + " ("+username+") " + "đã chỉnh sửa thông của giày "+oldProduct;
		
		String notify = "";
		try {
		
			if(!Image.isEmpty()) {
				byte[] contents = Image.getBytes();
				if(ProductServices.getInstance().EditProductHasImage(ID, Name,Integer.parseInt(ProducerID), Integer.parseInt(MaterialID), 
						Price, Discount, contents,Integer.parseInt(TypeID), Description)) {
					notify = "Đã chỉnh sửa thành công sản phẩm";
					if(SupportServices.getInstance().AddNewLog(log+", có chỉnh sửa ảnh"))
						System.out.println("Thêm nhật ký hệ thống thành công");
					else
						System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				}
				else {
					notify= "Đã xảy ra lỗi khi chỉnh sửa sản phẩm, vui lòng kiểm tra lại thông tin nhập";
				}	
			}
			else {
				if(ProductServices.getInstance().EditProductNoImage(ID, Name,Integer.parseInt(ProducerID), Integer.parseInt(MaterialID), 
						Price, Discount,Integer.parseInt(TypeID), Description)) {
					notify = "Đã chỉnh sửa thành công sản phẩm";
					if(SupportServices.getInstance().AddNewLog(log+", không chỉnh sửa ảnh"))
						System.out.println("Thêm nhật ký hệ thống thành công");
					else
						System.out.println("Có lỗi khi thêm nhật ký hệ thống");
				}
				else {
					notify= "Đã xảy ra lỗi khi chỉnh sửa sản phẩm, vui lòng kiểm tra lại thông tin nhập";
				}	
			}	
		}
		catch(Exception e) {
			notify= "Đã xảy ra lỗi khi chỉnh sửa sản phẩm, vui lòng kiểm tra lại thông tin nhập";
		}
		
		return notify;
	}
	
	
	@RequestMapping(value="/addColorItem",  method = RequestMethod.POST,produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addColorItem(@RequestParam("prID") String prID ,@RequestParam("colorID") int colorID, @RequestParam("fileSelector") MultipartFile[] Image) {
		String notify=" ";
		
		Color color = ProductDAO.getInstance().GetColorById(colorID);
		
		if(!Image[0].isEmpty()) { 
			if(!ProductServices.getInstance().AddColorItem(prID, colorID, Image)) {
				notify = "Đã xảy ra lỗi khi thêm màu " + color.getName()  +", Vui lòng kiểm tra lại thông tin và thử lại";
			}
			
		}
		else {
			notify="Bạn chưa chọn hình cho màu " + color.getName();
		}
		
		
		return notify;
	}
	
	@RequestMapping(value="/getproductcolorimage/{pID}/{colorID}",  method = RequestMethod.GET,produces = "text/html; charset=utf-8")
	public String getProductColorImg(@PathVariable String pID, @PathVariable int colorID, ModelMap md) {
		
		List<Image> image = ProductDAO.getInstance().getListImageByPIDAndColorID(pID, colorID);
		
		md.addAttribute("image", image);
		
		return "ajax/productImage";
	}
	
}
