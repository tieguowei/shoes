package com.hzcf.shoes.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.hzcf.shoes.enmu.TemplateConstants;

public class DataUtil {

	/**
	 * 文件上传
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	public static File dataUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		File file2 = null;
		String path = null;
		try {
			// 得到上传的文件名 System.out.println(file.getOriginalFilename());
			if (!file.isEmpty()) {
				// 文件不为空保存到webapp下
				String realPath = request.getSession().getServletContext().getRealPath(TemplateConstants.UPLOAD);
				// 修改文件名称
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				int index = (file).getOriginalFilename().indexOf('.');
				String prefix = (file).getOriginalFilename().substring(index);
				// 给上传的文件一个新的名称
				String fileName = sdf.format(new Date()) + file.getOriginalFilename();
				// 设置存放图片文件的路径
				path = realPath + "\\" + fileName;
				// 转存文件到指定的路径
				file.transferTo(new File(path));
				file2 = new File(path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file2;
	}

	/**
	 * 模板下载
	 * 
	 * @param realPath
	 * @param response
	 */
	public static void downLoadTemplate(String realPath, HttpServletResponse response) {
		BufferedInputStream br = null;
		OutputStream out = null;
		try {
			File f = new File(realPath);
			if (!f.exists()) {
				response.sendError(404, "File not found!");
				return;
			}
			br = new BufferedInputStream(new FileInputStream(f));
			byte[] buf = new byte[1024];
			int len = 0;
			response.reset();
			String filename = new String(f.getName().getBytes(), "ISO-8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");

			out = response.getOutputStream();
			while ((len = br.read(buf)) > 0)
				out.write(buf, 0, len);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
