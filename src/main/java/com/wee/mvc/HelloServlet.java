package com.wee.mvc;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-27
 * Time: 8:49:41
 */
public class HelloServlet extends HttpServlet {
    private Logger log= LoggerFactory.getLogger(this.getClass());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> params=request.getParameterMap();
        for (Map.Entry<String,String[]> param : params.entrySet()) {
            log.debug("param pair :  name-<"+param.getKey()+">  ,   value-<"+spanStringArray(param.getValue())+">.");
        }
    }

    private String spanStringArray(String[] strs){
        String result="value length is "+strs.length+"{";
        for(String str:strs){
            result+=str+"},{";
        }
        return result+"}";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                  doPost(request,response);
    }
}
