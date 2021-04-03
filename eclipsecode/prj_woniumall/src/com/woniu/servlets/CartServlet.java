package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.bean.pojo.Cart;
import com.woniu.bean.pojo.PageBean;
import com.woniu.bean.pojo.User;
import com.woniu.mappers.CartMapper;
import com.woniu.utils.MyBatisUtil;
import com.woniu.utils.TemplateUtil;

@WebServlet("/cart")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private Logger logger=Logger.getLogger(CartServlet.class);
    private CartMapper cartMapper;
    private SqlSession sqlSession;
    public CartServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	sqlSession=MyBatisUtil.getSqlSession();
    	cartMapper=sqlSession.getMapper(CartMapper.class);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}
	protected void goToCart(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		User loginUser=(User)session.getAttribute("user");
		if(loginUser!=null){
			int currentPage=1;
			String crtpage=request.getParameter("currentPage");
			if(crtpage==null){
				currentPage=1;
			}else{
				currentPage=Integer.parseInt(crtpage);
			}
			PageBean<Cart> pageBean=new PageBean<>();
			int count=cartMapper.getCountCartByUserid(loginUser.getId());
			//给pageBean赋值totalCount
			pageBean.setTotalCount(count);
			//每页的条目数
			int pageSize=5;
			//给pageBean赋值pageSize
			pageBean.setPageSize(pageSize);
			int pages=pageBean.getPages();
			//给pageBean赋值pages
			pageBean.setPages(pages);
			//给pageBean赋值currentPage
			pageBean.setCurrentPage(currentPage);
			if(currentPage>pages){
				currentPage=pages;
			}
			Page<Cart> page=PageHelper.startPage(currentPage, pageSize);
			List<Cart> cartList=cartMapper.selectCartByUserid(loginUser.getId());
			//给pageBean赋值goodsList
			pageBean.setData(cartList);
			
			/*JSONObject cartJO=new JSONObject(pageBean);
			response.setContentType("text/html;charset=utf-8");
			try {
				PrintWriter out=response.getWriter();
				out.print(cartJO);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			
			request.setAttribute("pageBean", pageBean);
			TemplateUtil.process("cart", request, response);
		}else{
			TemplateUtil.process("index", request, response);
		}
		
	}
	protected void deleteCartGoods(HttpServletRequest request, HttpServletResponse response) {
		String goodsid=request.getParameter("goodsid");
		int count=cartMapper.deleteCartByGoodsid(Integer.parseInt(goodsid));
		sqlSession.commit();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out=response.getWriter();
			out.print("删除成功");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void joinCart(HttpServletRequest request, HttpServletResponse response) {
		String userid=request.getParameter("userid");
		String goodsid=request.getParameter("goodsid");
		String price=request.getParameter("price");
		String nums=request.getParameter("nums");
		String addtime=request.getParameter("addtime");
		if(userid==null){
			TemplateUtil.process("login", request, response);
			return;
		}
		logger.info("userid:"+userid);
		logger.info("goodsid:"+goodsid);
		logger.info("salesprice:"+price);
		logger.info("nums:"+nums);
		logger.info("addtime:"+addtime);
		Cart cart=new Cart(Integer.parseInt(userid), Integer.parseInt(goodsid), new BigDecimal(price), Integer.parseInt(nums), new Timestamp(Long.parseLong(addtime)));
		Cart cartQuery=cartMapper.isCartExit(cart);
		if(cartQuery==null){
			cartMapper.addCart(cart);
		}else{
			cartMapper.updateCartByGoodsidAndUserid(cart);
		}
		sqlSession.commit();
		TemplateUtil.process("cartGo", request, response);
	}
	protected void forCart(HttpServletRequest request, HttpServletResponse response) {
		TemplateUtil.process("cart", request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
