package com.smrwns.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import com.smrwns.domains.User;

/**
 * 학습용 클래스
 */
@Component
public class UserAddConfirm implements View{

    
    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType(this.getContentType());
        User addedUser = (User) model.get("addedUser");
        PrintWriter out = null;
        
        try {
            out = response.getWriter();
            StringBuffer sb = new StringBuffer();
            sb.append("<!DOCTYPE html>                          ").append("\r\n");
            sb.append("<html>                                   ").append("\r\n");
            sb.append("<head>                                   ").append("\r\n");
            sb.append("</head>                                  ").append("\r\n");
            sb.append("<body>                                   ").append("\r\n");
            sb.append("RedirectView<br />                       ").append("\r\n");
            sb.append(addedUser.getName() + " 님<br />          ").append("\r\n");
            sb.append(model.get("msg") + "<br />"                ).append("\r\n");
            sb.append("<a href='"+model.get("href")+"'>확인</a> ").append("\r\n");
            sb.append("</body>                                  ").append("\r\n");
            sb.append("</html>                                  ").append("\r\n");
            
            sb.append("<script type='text/javascript'>").append("\r\n");
            
            out.print(sb.toString());
            out.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            if(out!=null) try {out.close(); } catch (Exception e2) { e2.printStackTrace(); }
        }
        
    }
    
    public String getContentType() {
        return MediaType.TEXT_HTML_VALUE;
    }
    
}
