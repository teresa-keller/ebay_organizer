package launchcode.org.ebay.organizer.models;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 51200;
    private int maxMemSize = 4096;
    private File file;

    UploadServlet() {
    }

    public void init() {
        this.filePath = this.getServletContext().getInitParameter("file-upload");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (!this.isMultipart) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>No file uploaded</p>");
            out.println("</body>");
            out.println("</html>");
        } else {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(this.maxMemSize);
            factory.setRepository(new File("c:\\temp"));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax((long)this.maxFileSize);

            try {
                List fileItems = upload.parseRequest((RequestContext)request);
                Iterator i = fileItems.iterator();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");
                out.println("</head>");
                out.println("<body>");

                while(i.hasNext()) {
                    FileItem fi = (FileItem)i.next();
                    if (!fi.isFormField()) {
                        String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        String contentType = fi.getContentType();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();
                        String var10003;
                        if (fileName.lastIndexOf("\\") >= 0) {
                            var10003 = this.filePath;
                            this.file = new File(var10003 + fileName.substring(fileName.lastIndexOf("\\")));
                        } else {
                            var10003 = this.filePath;
                            this.file = new File(var10003 + fileName.substring(fileName.lastIndexOf("\\") + 1));
                        }

                        fi.write(this.file);
                        out.println("Uploaded Filename: " + fileName + "<br>");
                    }
                }

                out.println("</body>");
                out.println("</html>");
            } catch (Exception var15) {
                System.out.println(var15);
            }

        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("GET method used with " + this.getClass().getName() + ": POST method required.");
    }
}


