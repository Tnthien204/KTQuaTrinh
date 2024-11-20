package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import services.ICategoryService_22110235;
import entity.Category;
import services.impl.CategoryServiceImpl_22110235;
import utils.Constant_22110235;

@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/add", "/admin/category/insert",
		"/admin/category/edit", "/admin/category/update",
		"/admin/category/delete", "/admin/category/search"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CategoryController_22110235 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ICategoryService_22110235 cateService = new CategoryServiceImpl_22110235();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if(url.contains("categories")) {
			List<Category> list = cateService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}else if(url.contains("add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		}else if(url.contains("edit")) {
			int id = Integer.parseInt(req.getParameter("categoryid"));
			Category category = cateService.findById(id);
			req.setAttribute("cate", category);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		}else if(url.contains("delete")) {
			int id = Integer.parseInt(req.getParameter("categoryid"));
			try {
			    cateService.delete(id);
			} catch (Exception e) {
			    e.printStackTrace();
			    // Xử lý lỗi ở đây, ví dụ: đặt thông báo lỗi và chuyển hướng đến trang lỗi.
			    req.setAttribute("errorMessage", "Có lỗi xảy ra khi xóa danh mục.");
			    req.getRequestDispatcher("/views/admin/error.jsp").forward(req, resp);
			}
			resp.sendRedirect(req.getContextPath()+ "/admin/categories");
		}else if(url.contains("search")) {
			String key = req.getParameter("keyword");
			List<Category> list = cateService.searchByName(key);
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
	    
		if(url.contains("insert")) {	
			Category category = new Category();
			String categoryname = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			category.setCategoryname(categoryname);
			category.setStatus(status);			
			String fname = "";
			String uploadPath = Constant_22110235.DIR;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
		        Part part = req.getPart("images");
		        if (part.getSize() > 0) {
		        	String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		            int index = filename.lastIndexOf(".");
		            String ext = filename.substring(index + 1);
		            fname = System.currentTimeMillis() + "." + ext ;
		            part.write(uploadPath + "/" + fname);
		            category.setImages(fname);
		        } else {
		        	category.setImages("avata.png");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}else if(url.contains("update")) {
			int categoryid = Integer.parseInt(req.getParameter("categoryid"));
			String categoryname = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			Category category = cateService.findById(categoryid);
			String fileold = category.getImages();
			category.setCategoryId(categoryid);
			category.setCategoryname(categoryname);
			category.setStatus(status);
			
			String fname = "";
			String uploadPath = Constant_22110235.DIR;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
		        Part part = req.getPart("images");
		        if (part.getSize() > 0) {
		        	String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		            int index = filename.lastIndexOf(".");
		            String ext = filename.substring(index + 1);
		            fname = System.currentTimeMillis() + "." + ext ;
		            part.write(uploadPath + "/" + fname);
		            category.setImages(fname);
		        } else {
		        	category.setImages(fileold);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
			cateService.update(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}
}