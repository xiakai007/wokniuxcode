package com.woniu.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.woniu.bean.pojo.Cart;
import com.woniu.bean.pojo.Goods;
import com.woniu.bean.pojo.User;
import com.woniu.mappers.CartMapper;
import com.woniu.mappers.UserMapper;
import com.woniu.utils.Constaint;
import com.woniu.utils.MyBatisUtil;
import com.woniu.utils.TemplateUtil;

@WebServlet("/user")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger=Logger.getLogger(UserServlet.class);
    private UserMapper userMapper;
    private SqlSession sqlSession;
    public UserServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	sqlSession=MyBatisUtil.getSqlSession();
    	userMapper=sqlSession.getMapper(UserMapper.class);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	protected void goToCart(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		User loginUser=(User)session.getAttribute("user");
		User cartUser=userMapper.selectUserById(loginUser.getId());
		List<Goods> goodsCartList=cartUser.getGoodsList();
		request.setAttribute("goodsCartList", goodsCartList);
		TemplateUtil.process("cart", request, response);
	}
	protected void register(HttpServletRequest request, HttpServletResponse response) {
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String passwordCfm=request.getParameter("passwordCfm");
		if(password!=null&&!password.equals("")&&password.equals(passwordCfm)){
			int count=userMapper.register(account,password);
			sqlSession.commit();
			TemplateUtil.process("login", request, response);
		}
	}
	
	protected void uploadHeadImage(HttpServletRequest request, HttpServletResponse response) {
		boolean isMultipart=ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			String newFileName=null;
			String suffix=null;
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload fileUpload=new ServletFileUpload(factory);
			try {
				List<FileItem> fileItems=fileUpload.parseRequest(request);
				if(fileItems!=null){
					for (FileItem fileItem : fileItems) {
						if(!fileItem.isFormField()){
							//如果是文件域
							String fieldName=fileItem.getFieldName();
							if(fieldName!=null){
								if(fieldName.equals("avatar")){
									String contentType=fileItem.getContentType();
									String fileName=fileItem.getName();
									long size=fileItem.getSize();
									ServletContext context=request.getServletContext();
									String uploadHeadImgDir=context.getRealPath("/images/avatar");
									newFileName=UUID.randomUUID().toString();
									suffix=fileName.substring(fileName.lastIndexOf(".")+1);
									File headImgFile=new File(uploadHeadImgDir+File.separator+newFileName+"."+suffix);
									fileItem.write(headImgFile);
								}
							}
							
						}
					}
				}
				User user=new User();
				HttpSession session=request.getSession();
				User userSes=(User)session.getAttribute("user");
				user.setId(userSes.getId());
				user.setAvatar("images/avatar/"+newFileName+"."+suffix);
				int count=userMapper.updateUser(user);
				sqlSession.commit();
				if(count>0){
					TemplateUtil.process("userCenter", request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String vercode=(String)session.getAttribute("vercode");
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String vcode=request.getParameter("vcode");
		if(vcode!=null&&vercode!=null){
			if(!vercode.equals(vcode)){
				request.setAttribute("vcodeError", Constaint.VERCODE);
				TemplateUtil.process("login", request, response);
			}else{
				User user=userMapper.login(account, password);
				if(user!=null){
					session.setAttribute("user", user);
					try {
						request.getRequestDispatcher("index").forward(request, response);
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else{
					request.setAttribute("userError", Constaint.USERERROR);
					TemplateUtil.process("login", request, response);
				}
			}
		}
	}
	protected void goLogin(HttpServletRequest request, HttpServletResponse response) {
		TemplateUtil.process("login", request, response);
	}
	protected void goUserCenter(HttpServletRequest request, HttpServletResponse response) {
		TemplateUtil.process("userCenter", request, response);
	}
	protected void uploadImg(HttpServletRequest request, HttpServletResponse response) {
		TemplateUtil.process("userCenterUploadImg", request, response);
	}
	protected void goRegister(HttpServletRequest request, HttpServletResponse response) {
		TemplateUtil.process("register", request, response);
	}
	protected void goIndex(HttpServletRequest request, HttpServletResponse response) {
		TemplateUtil.process("index", request, response);
	}
	protected void forIndex(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("index").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
