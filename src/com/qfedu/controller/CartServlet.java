package com.qfedu.controller;

import com.qfedu.entity.Book;
import com.qfedu.entity.Cart;
import com.qfedu.entity.CartItem;
import com.qfedu.service.BookService;
import com.qfedu.service.impl.BookServiceImpl;
import com.qfedu.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {
    /**
     * 添加购物车
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1,得到车
         * 2,得到条目(图书bid和数量)
         */
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //获得条目所需信息
        int count = Integer.parseInt(request.getParameter("count"));
        BookServiceImpl bookService = new BookServiceImpl();
        Book book = bookService.load(request.getParameter("bid"));
        //创建条目
        CartItem cartItem = new CartItem();
        cartItem.setCount(count);
        cartItem.setBook(book);
        //填加条目到购物车
        cart.add(cartItem);
        Collection<CartItem> cartItems = cart.getCartItems();
        request.setAttribute("cart", cart);
        request.setAttribute("cartItems", cartItems);
        request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request, response);
    }

    public void clear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();
        Collection<CartItem> cartItems = cart.getCartItems();
        request.setAttribute("cart", cart);
        request.setAttribute("cartItems", cartItems);
        request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.delete(request.getParameter("bid"));
        Collection<CartItem> cartItems = cart.getCartItems();
        request.setAttribute("cart", cart);
        request.setAttribute("cartItems", cartItems);
        request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request, response);
    }
}
