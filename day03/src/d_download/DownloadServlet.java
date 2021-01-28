package d_download;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.要确定下载的文件
        String filename = request.getParameter("filename");
        String path = this.getServletContext().getRealPath("/download/" + filename);
        // 2.打开这个文件的输入流
        InputStream is = new BufferedInputStream(new FileInputStream(new File(path)));
        // 需要告诉客户端响应方式是附件形式 -- filename 中文乱码  浏览器本身的引擎不支持中文解析
        // 解决乱码
        String agent = request.getHeader("user-agent");
        String fileName2 = DownLoadUtils.getFileName(agent, filename);
        response.setHeader("Content-Disposition","attachment;filename=" + fileName2);
        // 告诉客户端响应类型是什么 - 根据文件后缀名动态得到的响应类型 - MIME Type (JavaEE服务器提前设定好的文件类型, web.xml)
        response.setContentType(this.getServletContext().getMimeType(filename));
        // 3.打开文件复制的输出流
        ServletOutputStream os = response.getOutputStream();
        // 4.复制文件
        byte[] bs = new byte[1024];
        int len = -1;
        while ((len = is.read(bs)) > 0) {
            os.write(bs, 0, len);
        }
        // 5.关闭输入流
        is.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
