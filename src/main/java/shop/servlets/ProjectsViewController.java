package shop.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;

/**
 * Created by Администратор on 25.04.2018.
 */

@Controller
public class ProjectsViewController {

    @RequestMapping(value={"projectsOpen"}, method = RequestMethod.GET)
    public String getPost(ModelMap model){
        return "projects";
    }


    @RequestMapping(value="/download/{type}", method = RequestMethod.GET)
    public String getPostGuitar(HttpServletRequest req, HttpServletResponse resp){
        try {

            File file = null;

            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            file = new File(classloader.getResource("GuitarTab-2.0-SNAPSHOT.jar").getFile());

            String mimeType= URLConnection.guessContentTypeFromName(file.getName());
            if(mimeType==null){
                System.out.println("mimetype is not detectable, will take default");
                mimeType = "application/octet-stream";
            }

            System.out.println("mimetype : "+mimeType);

            resp.setContentType(mimeType);

        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
            resp.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));


        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
            //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));

            resp.setContentLength((int)file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            //Copy bytes from source to destination(outputstream in this example), closes both streams.
            FileCopyUtils.copy(inputStream, resp.getOutputStream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


}
