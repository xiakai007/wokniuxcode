package com.woniu.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.woniu.bean.pojo.Address;
import com.woniu.bean.pojo.User;
import com.woniu.mappers.AddressMapper;
import com.woniu.utils.MyBatisUtil;
import com.woniu.utils.TemplateUtil;

@WebServlet("/address")
public class AddressServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private Logger logger=Logger.getLogger(AddressServlet.class);
    private SqlSession sqlSession;
    private AddressMapper addressMapper;
    public AddressServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	sqlSession=MyBatisUtil.getSqlSession();
    	addressMapper=sqlSession.getMapper(AddressMapper.class);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	protected void addressMana(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		List<Address> addresses=addressMapper.selectAllAddressByUserid(user.getId());
		request.setAttribute("addresses", addresses);
		TemplateUtil.process("userCenterAddress", request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
