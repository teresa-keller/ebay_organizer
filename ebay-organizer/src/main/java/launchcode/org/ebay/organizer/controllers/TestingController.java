//package launchcode.org.ebay.organizer.controllers;
//
//import java.io.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//
//public class TestingController {
//    //
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
////
////import java.io.File;
////import java.io.FileNotFoundException;
////import java.io.FileOutputStream;
////import java.io.IOException;
////import java.io.InputStream;
////import java.io.OutputStream;
////import java.io.PrintWriter;
////import java.util.logging.Level;
////import java.util.logging.Logger;
////import javax.servlet.ServletException;
////import javax.servlet.annotation.MultipartConfig;
////import javax.servlet.annotation.WebServlet;
////import javax.servlet.http.HttpServlet;
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpServletResponse;
////import javax.servlet.http.Part;
//
//    @WebServlet(
//            name = "FileUploadServlet",
//            urlPatterns = {"/upload"}
//    )
//    @MultipartConfig
//    static
//    class TestingController$FileUploadServlet extends HttpServlet {
////        private final Logger LOGGER;
////
////        TestingController$FileUploadServlet(final TestingController this$0) {
////            this.this$0 = this$0;
////            this.LOGGER = Logger.getLogger(TestingController$FileUploadServlet.class.getCanonicalName());
//        }
//
//        protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            response.setContentType("text/html;charset=UTF-8");
//            String path = request.getParameter("destination");
//            Part filePart = request.getPart("file");
//            String fileName = this.getFileName(filePart);
//            OutputStream out = null;
//            InputStream filecontent = null;
//            PrintWriter writer = response.getWriter();
//
//            try {
//                out = new FileOutputStream(new File(path + File.separator + fileName));
////                filecontent = filePart.getInputStream();
////                int read = false;
////                byte[] bytes = new byte[1024];
////
////                int read;
////                while((read = filecontent.read(bytes)) != -1) {
////                    out.write(bytes, 0, read);
////                }
////
////                writer.println("New file " + fileName + "created at " + path);
////                this.LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", new Object[]{fileName, path});
////            } catch (FileNotFoundException var14) {
////                writer.println("You either did not specify a file to upload or are trying to upload a file to a protected or nonexistent location.");
////                writer.println("<br/> ERROR: " + var14.getMessage());
////                this.LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", new Object[]{var14.getMessage()});
////            } finally {
//                if (out != null) {
//                    out.close();
//                }
//
//                if (filecontent != null) {
//                    filecontent.close();
//                }
//
//                if (writer != null) {
//                    writer.close();
//                }
//
//            }
//
//        }
//
//        private String getFileName(final Part part) {
//            String partHeader = part.getHeader("content-disposition");
//            this.LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
//            String[] var3 = part.getHeader("content-disposition").split(";");
//            int var4 = var3.length;
//
//            for(int var5 = 0; var5 < var4; ++var5) {
//                String content = var3[var5];
//                if (content.trim().startsWith("filename")) {
//                    return content.substring(content.indexOf(61) + 1).trim().replace("\"", "");
//                }
//            }
//
//            return null;
//        }
//    }
//
//}
