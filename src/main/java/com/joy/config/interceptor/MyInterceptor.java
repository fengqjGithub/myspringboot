package com.joy.config.interceptor;

import com.google.gson.Gson;
import com.joy.java.util.lang.MyStringUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class MyInterceptor implements HandlerInterceptor {
    //在请求处理之前进行调用（Controller方法调用之前）
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //获取用户信息
       String   tokenid  = request.getHeader("tokenid");
//        if (MyStringUtil.isBlankMy(tokenid)){
//            System.out.println("tokenid为空-------------");
//            PrintWriter out = response.getWriter();
//            out.print("{'returnState': 'failure','returnMessage': 'tokenid is null'}");
//            return  false;
//        }
//        //获取用户信息
//        SessionBean sessionBean=null;
//        //冲缓存中获取数据
//        String token  =  redisutil.get(tokenid);
//        if(MyStringUtil.isNotBlankMy(token)){
//             sessionBean =  new Gson().fromJson(token,SessionBean.class);
//        }
//        if(sessionBean==null){
//            List<LoginLog> loginLogList = logindao.getLoginLogByTokenid(tokenid);
//           if(loginLogList!=null && loginLogList.size()>0) {
//               //重新放入redis
//               token = loginLogList.get(0).getSessionBean();
//               redisutil.set(tokenid,token ,(long)1800);
//               sessionBean = new Gson().fromJson(token, SessionBean.class);
//           }
//        }
//        if (sessionBean==null){
//            PrintWriter out = response.getWriter();
//            out.print("{'returnState': 'failure','returnMessage': 'tokenid is failure'}");
//            return  false;
//        }
//        //将用户信息放入session信息中心
//        request.getSession().setAttribute("user",sessionBean);
//        //记录用户的用户的请求历史
//        Map map = request.getParameterMap();
//        Log log = new Log();
//        log.setAddtime(new Date());
//        log.setCenter(new Gson().toJson(map));
//        log.setMemberid(sessionBean.getBasisMemberEn().getMemberid());
//        log.setTokenid(tokenid);
//        log.setType("in");
//        logdao.save(log);
        return true;
    }

    //  请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}