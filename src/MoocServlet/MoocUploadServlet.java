package MoocServlet;
//已经可以任意修改了。
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;
import javax.naming.SizeLimitExceededException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
//import sun.security.jca.GetInstance.Instance;
 
/**
 * 进行文件上传的demo1
 * @author scw
 *
 */
@WebServlet("/MoocUploadServlet")
public class MoocUploadServlet extends HttpServlet {
	
	//全局变量
	String chaptern="";
	String sectionn="";
	String courseid="";
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决文件乱码问题
		request.setCharacterEncoding("utf-8");
		
		//1:创建文件上传的工厂类实例对象
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		
		//为了提高对于大文件上传的效率，这里就添加一个临时目录，放在WEB-INF下的tmp，当然放在WEB-INF目前外面也可以
		diskFileItemFactory.setRepository(new File("WEB-INF/tmp"));
		diskFileItemFactory.setSizeThreshold(1024*1024*3);
		
		
		//2：创建文件上传的servletFileUpload实例对象
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		//解析request对象的内容
		try {
			//设置文件上传的大小限制
			servletFileUpload.setFileSizeMax(1024*1024*3); //单个文件不能超过3M
			servletFileUpload.setSizeMax(1024*1024*10); //总的上传文件大小不能超过10M
			
			//进行模拟进度条功能服务器端的实现
			//(1)获取上传的时间
			long startTime = System.currentTimeMillis();
			//(2)实现进度条监听器
			servletFileUpload.setProgressListener(new ProgressListener() {
				/**
				 * 第一个参数：已经上传的大小
				 * 第二个参数：总的大小
				 * 第三个参数：上传标签中文件是第几个顺序，这个没什么作用
				 */
				@Override
				public void update(long alreadloadsize, long totalsize, int formnumber) {
					//获取当前的时间
					long currentTime = System.currentTimeMillis();
					//计算已经花费的时间
					long useTime = currentTime - startTime;
					//计算上传的速度
					long speed  = alreadloadsize / useTime ;
					//计算还剩于未上传的大小
					long unloadsize = totalsize - alreadloadsize;
					//计算还需要上传的时间
					long nextTime = unloadsize / speed  ;
					System.out.println("已经花费时间：" + useTime);
					System.out.println("上传速度：" + speed );
					System.out.println("剩余大小：" + unloadsize);
					System.out.println("剩余时间：" + nextTime);				
				}
			});
			
			
			List<FileItem> parseRequest = servletFileUpload.parseRequest(request);
			//4:遍历内容
			for (FileItem fileItem : parseRequest) {
				//如果是true，则表示获取的当前内容数据是非上传文件内容，返回false就是上传文件的内容
				if(fileItem.isFormField()){
					//获取到JSP对应标签的name属性内容
					String fieldName = fileItem.getFieldName();
					//获取JSP对应标签value的内容，并且解决中文乱码问题
					String value = fileItem.getString("utf-8");
				//	System.out.println(fieldName + "@" + value);
					
					
					//System.out.println( "测试"+fieldName.substring(0,4) );
					//System.out.println( "测试"+fieldName.length() );
					
					//添加用户id到attribute
					if(fieldName.equals("userid")) {
						request.setAttribute("fixedPageUserid", value);
						System.out.println("用户id" + "@" + value);
					}
					
					//添加 课程名 课程id 到attribute
					else if(fieldName.equals("courseName")) {
						request.setAttribute("courseName", value);
						System.out.println("课程名" + "@" + value);
						//生成课程16位课程id并添加到xxx
						String aString = UUID.randomUUID().toString().substring(0,16);
						courseid = aString;
						request.setAttribute("courseid", aString);
						System.out.println("课程id" + "@" + aString);
					}
					
					//添加课程价格到attribute
					else if(fieldName.equals("coursePrice")) {
						request.setAttribute("coursePrice", value);
						System.out.println("课程价格" + "@" + value);
					}
					
					//课程介绍到attribute
					else if(fieldName.equals("courseIntroduce")) {
						request.setAttribute("courseIntroduce", value);
						System.out.println("课程介绍" + "@" + value);
					}
					
					
					//课程基础要求到attribute
					else if(fieldName.equals("courseRequire")) {
						request.setAttribute("courseRequire", value);
						System.out.println("课程基础要求" + "@" + value);
					}
					
					//课程专享服务到attribute
					else if(fieldName.equals("exclusiveService")) {
						request.setAttribute("exclusiveService", value);
						System.out.println("课程专享服务" + "@" + value);
					}
					
					//添加分类选择结果到attribute
					else if(fieldName.equals("classOneResult")) {
						request.setAttribute("classOneResult", value);
					}
					else if(fieldName.equals("classTwoResult")) {
						request.setAttribute("classTwoResult", value);
					}
					
						
					
					
					//添加章节名到attribute
					//若name的前n个为chapter则添加章节到全局变量，并添加到attribute
					//直接把name作为attribute的变量名就不用，1，2，3，4，5...这样
					else if(fieldName.substring(0,4).equals("chap")&&fieldName.length()==5) {
						chaptern = fieldName;
						System.out.println("章节名称:"+value);
						System.out.println("章节Name:"+chaptern);
						request.setAttribute(fieldName, value);
					}
					
					//添加小节到attribute
					//若为小节，那也是可以直接覆盖不需要写1-8个小节的全局变量
					//好傻的操作卧槽...
					else if(fieldName.substring(5,9).equals("sect")) {
						sectionn = fieldName;
						System.out.println("小节名称:"+value);
						System.out.println("小节Name:"+sectionn);
						request.setAttribute(fieldName, value);
					}
					
					
					
					
					
				}else{
					//获取到上传文件中，上传文件的名字
					String name = fileItem.getName();
					
					
					//为了解决一些浏览器（比如IE6）上传文件的时候，上传文件名是整个路径，比如C：\\upload\file\aa.txt所以要特别处理一下，
					//但是一般目前不存在这个问题了，主要针对一些老浏览器
					int index = name.lastIndexOf("\\");
					//如果匹配到的索引大于等于0，就表示需要进行截取，因为匹配不到的话是返回-1
					if(index >= 0){
						name = name.substring(index+1 , name.length());
					}
					//为了防止，如果上传的文件名字一样，那么就会把之前的进行替换，所以这里也要特别处理一下（当然用时间戳也行）
//					name = UUID.randomUUID().toString() + name;
					
					//将上传的文件改名为课程id+章节n+小节n的格式
					//怎么解决后缀问题,直到遇到.字符...然后截取
					//总长算出来，然后倒着计算,一般视频格式就是wmv,mp4,avi,mkv可以到时做限制就行了。
					//获取文件名和后缀名的位置，然后改文件为固定格式
					//System.out.println("文件名"+name.substring(0,name.length()-4));
					//System.out.println("文件后缀"+name.substring(name.length()-4,name.length() ));
					//这里替换有点麻烦，我就提取出后缀，然后直接赋值固定格式给name
					String namePostfix = name.substring(name.length()-4,name.length() );
					name = courseid+sectionn + namePostfix;
					System.out.println("替换完成后的文件名："+name);
					
					
					
					
					//获取到上传文件的字节流内容
					InputStream inputStream = fileItem.getInputStream();
					
					//获取存放上传内容的路径
					//上传路径如果是想放在web-inf目录外就下面的形式
					//String realPath = getServletContext().getRealPath("/demo1path");
					String realPath = "C:\\Users\\bralaya_h\\Documents\\CodeProject\\eclipse-workspace\\OnlineMooc\\WebContent\\course\\freeCourse\\";
					//如果想放在web-inf目录内部的话，就下面的形式，建议这样的方式，因为这样的话就不能直接从浏览器访问这个目录下面的内容，更加安全
					//String realPath = getServletContext().getRealPath("WEB-INF/demo1path");
					//创建出文件路径，防止目录不存在的时候出现异常问题
					if(!new File(realPath).exists()){
						new File(realPath).mkdirs();
					}
					//创建输出流，这里用缓冲输出流，能够提高上传的效率
					OutputStream os =new BufferedOutputStream( new FileOutputStream(new File(realPath , name)));				
					//进行上传处理，用到commons.io.jar包里面的一个方法，相对比一般的处理方便点
					IOUtils.copy(inputStream, os);
					
					//将临时目录中的内容进行删除，这也是由于之前为了提高上传效率而添加的临时目录
					fileItem.delete();
					
					//文件路径传递给moocServlet
					request.setAttribute(chaptern+sectionn, realPath+name);
					System.out.println("路径的attribute变量名:"+chaptern+sectionn);
					//输出返回成功，并返回上传位置的路径和文件名
					System.out.println("上传成功，路径为："+realPath+name);
					//关闭资源
					inputStream.close();
					os.close();
				}
			}
			
			//这里可以做点操作
			//重定向到MoocServlet进行数据库写入操作
			//request.setAttribute("satname", "shu");
			ServletContext application = this.getServletContext();
			RequestDispatcher rd = application.getRequestDispatcher("/MoocServlet?functionChoise=CourseMessageHandle");
			rd.forward(request,response);
			
		} catch (Exception e) {
			//抓取单个文件上传大小超过限制
			if(e instanceof FileSizeLimitExceededException){
				System.out.println("单个文件太大啦~~~~~~~~~~~");
			}
			//抓取上传多个文件上传大小超过限制
			if(e instanceof SizeLimitExceededException){
				System.out.println("总的上传文件太大啦~~~~~~~~~~~");
			}
			e.printStackTrace();
		}
		
		
	}
 
}
