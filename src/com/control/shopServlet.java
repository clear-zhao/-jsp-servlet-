import com.bean.Item;
import com.bean.shopBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "shopServlet", value = "/shopServlet")
public class shopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        int flag = 0;
        //初始化bean
        shopBean shop = new shopBean();
        String name_session =(String) request.getSession().getAttribute("name");
        String email_session = (String) request.getSession().getAttribute("email");
        String name_cookie = null;
        String email_cookie = null;
        if(name_session == null)
        {
            Cookie cookie = null;
            Cookie[] cookies = null;
            // 获取cookies的数据,是一个数组
            cookies = request.getCookies();
            if( cookies != null ){
                for (int i = 0; i < cookies.length; i++)
                {
                    cookie = cookies[i];
                    String user_name = cookie.getName();
                    if(user_name.equals("name"))
                    {
                        name_cookie =cookie.getValue();
                        flag = 1;
                    }
                    if(user_name.equals("email"))
                    {
                        email_cookie =cookie.getValue();
                        flag = 1;
                    }
                }
            }
        }
        else
        {
            flag = 1;
        }
        if(flag == 0)  // 未登录
        {
            response.sendRedirect("login.jsp");
        }
        else
        {
            if(id.equals("1"))  // 加入购物车商品
            {
                int book_id = Integer.parseInt(request.getParameter("item_id"));
                String book_name = request.getParameter("book_name");
                float price = Float.parseFloat(request.getParameter("price"));
                shop.setId(book_id);
                shop.setBook_name(book_name);
                shop.setPrice(price);
                if(email_cookie == null)
                {
                    shop.setEmail(name_session);
                }
                else
                {
                    shop.setEmail(name_cookie);
                }
                shop.addItem();
                response.sendRedirect("shop.jsp");
            }
            if(id.equals("2"))  // 读取购物车
            {
                ArrayList<Item> list = new ArrayList<Item>();
                if(email_cookie == null)
                {
                    shop.setEmail(name_session);
                }
                else
                {
                    shop.setEmail(name_cookie);
                }
                list = shop.selectUser();
                request.setAttribute("list",list);
                request.getRequestDispatcher("cart.jsp").forward(request,response);
            }
            if(id.equals("3"))  // 清空购物车商品
            {

                if(email_cookie == null)
                {
                    shop.setEmail(name_session);
                }
                else
                {
                    shop.setEmail(name_cookie);
                }
                shop.clearAll();
                response.sendRedirect("shop.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
