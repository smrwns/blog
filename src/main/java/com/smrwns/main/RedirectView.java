package com.smrwns.main;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

@Component
public class RedirectView implements View {

    @Override
    public String getContentType() {
        return MediaType.TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //Alert alert = (Alert) model.get("alert");
        response.setContentType(this.getContentType());
        
        PrintWriter out = null;
        
        try {
            out = response.getWriter();
            
            StringBuffer sb = new StringBuffer();
            sb.append("<!DOCTYPE html>  ").append("\r\n");
            sb.append("<html>           ").append("\r\n");
            sb.append("<head>           ").append("\r\n");
            sb.append("</head>          ").append("\r\n");
            sb.append("<body>           ").append("\r\n");
            sb.append("RedirectView     ").append("\r\n");
            sb.append(model.get("msg")   ).append("\r\n");
            sb.append("</body>          ").append("\r\n");
            sb.append("</html>          ").append("\r\n");
         
            sb.append("<script type='text/javascript'>").append("\r\n");
            
            out.print(sb.toString());
            out.flush();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(out != null) try { out.close();} catch (Exception e2) {e2.printStackTrace();};
        }
        
    }

}
