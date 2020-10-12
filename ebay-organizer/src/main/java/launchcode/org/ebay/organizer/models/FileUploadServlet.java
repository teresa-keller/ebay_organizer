package launchcode.org.ebay.organizer.models;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

// (powered by FernFlower decompiler)
//

    public class FileUploadServlet extends HttpServlet {
        public FileUploadServlet() {
        }

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            Part filePart = request.getPart("fileToUpload");
            InputStream fileInputStream = filePart.getInputStream();
            File fileToSave = new File("C:/uploadtemp/" + filePart.getSubmittedFileName());
            Files.copy(fileInputStream, fileToSave.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
            String fileUrl = "http://localhost:8080/uploaded-files/" + filePart.getSubmittedFileName();
            String name = request.getParameter("name");
            response.getOutputStream().println("<p>Thanks " + name + "! Here's a link to your uploaded file:</p>");
            response.getOutputStream().println("<p><a href=\"" + fileUrl + "\">" + fileUrl + "</a></p>");
            response.getOutputStream().println("<p>Upload another file <a href=\"http://localhost:8080/index.html\">here</a>.</p>");
        }
    }

