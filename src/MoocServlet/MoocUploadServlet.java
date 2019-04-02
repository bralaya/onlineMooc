package MoocServlet;
//�Ѿ����������޸��ˡ�
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
 * �����ļ��ϴ���demo1
 * @author scw
 *
 */
@WebServlet("/MoocUploadServlet")
public class MoocUploadServlet extends HttpServlet {
	
	//ȫ�ֱ���
	String chaptern="";
	String sectionn="";
	String courseid="";
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ļ���������
		request.setCharacterEncoding("utf-8");
		
		//1:�����ļ��ϴ��Ĺ�����ʵ������
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		
		//Ϊ����߶��ڴ��ļ��ϴ���Ч�ʣ���������һ����ʱĿ¼������WEB-INF�µ�tmp����Ȼ����WEB-INFĿǰ����Ҳ����
		diskFileItemFactory.setRepository(new File("WEB-INF/tmp"));
		diskFileItemFactory.setSizeThreshold(1024*1024*3);
		
		
		//2�������ļ��ϴ���servletFileUploadʵ������
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		//����request���������
		try {
			//�����ļ��ϴ��Ĵ�С����
			servletFileUpload.setFileSizeMax(1024*1024*3); //�����ļ����ܳ���3M
			servletFileUpload.setSizeMax(1024*1024*10); //�ܵ��ϴ��ļ���С���ܳ���10M
			
			//����ģ����������ܷ������˵�ʵ��
			//(1)��ȡ�ϴ���ʱ��
			long startTime = System.currentTimeMillis();
			//(2)ʵ�ֽ�����������
			servletFileUpload.setProgressListener(new ProgressListener() {
				/**
				 * ��һ���������Ѿ��ϴ��Ĵ�С
				 * �ڶ����������ܵĴ�С
				 * �������������ϴ���ǩ���ļ��ǵڼ���˳�����ûʲô����
				 */
				@Override
				public void update(long alreadloadsize, long totalsize, int formnumber) {
					//��ȡ��ǰ��ʱ��
					long currentTime = System.currentTimeMillis();
					//�����Ѿ����ѵ�ʱ��
					long useTime = currentTime - startTime;
					//�����ϴ����ٶ�
					long speed  = alreadloadsize / useTime ;
					//���㻹ʣ��δ�ϴ��Ĵ�С
					long unloadsize = totalsize - alreadloadsize;
					//���㻹��Ҫ�ϴ���ʱ��
					long nextTime = unloadsize / speed  ;
					System.out.println("�Ѿ�����ʱ�䣺" + useTime);
					System.out.println("�ϴ��ٶȣ�" + speed );
					System.out.println("ʣ���С��" + unloadsize);
					System.out.println("ʣ��ʱ�䣺" + nextTime);				
				}
			});
			
			
			List<FileItem> parseRequest = servletFileUpload.parseRequest(request);
			//4:��������
			for (FileItem fileItem : parseRequest) {
				//�����true�����ʾ��ȡ�ĵ�ǰ���������Ƿ��ϴ��ļ����ݣ�����false�����ϴ��ļ�������
				if(fileItem.isFormField()){
					//��ȡ��JSP��Ӧ��ǩ��name��������
					String fieldName = fileItem.getFieldName();
					//��ȡJSP��Ӧ��ǩvalue�����ݣ����ҽ��������������
					String value = fileItem.getString("utf-8");
				//	System.out.println(fieldName + "@" + value);
					
					
					//System.out.println( "����"+fieldName.substring(0,4) );
					//System.out.println( "����"+fieldName.length() );
					
					//����û�id��attribute
					if(fieldName.equals("userid")) {
						request.setAttribute("fixedPageUserid", value);
						System.out.println("�û�id" + "@" + value);
					}
					
					//��� �γ��� �γ�id ��attribute
					else if(fieldName.equals("courseName")) {
						request.setAttribute("courseName", value);
						System.out.println("�γ���" + "@" + value);
						//���ɿγ�16λ�γ�id����ӵ�xxx
						String aString = UUID.randomUUID().toString().substring(0,16);
						courseid = aString;
						request.setAttribute("courseid", aString);
						System.out.println("�γ�id" + "@" + aString);
					}
					
					//��ӿγ̼۸�attribute
					else if(fieldName.equals("coursePrice")) {
						request.setAttribute("coursePrice", value);
						System.out.println("�γ̼۸�" + "@" + value);
					}
					
					//�γ̽��ܵ�attribute
					else if(fieldName.equals("courseIntroduce")) {
						request.setAttribute("courseIntroduce", value);
						System.out.println("�γ̽���" + "@" + value);
					}
					
					
					//�γ̻���Ҫ��attribute
					else if(fieldName.equals("courseRequire")) {
						request.setAttribute("courseRequire", value);
						System.out.println("�γ̻���Ҫ��" + "@" + value);
					}
					
					//�γ�ר�����attribute
					else if(fieldName.equals("exclusiveService")) {
						request.setAttribute("exclusiveService", value);
						System.out.println("�γ�ר�����" + "@" + value);
					}
					
					//��ӷ���ѡ������attribute
					else if(fieldName.equals("classOneResult")) {
						request.setAttribute("classOneResult", value);
					}
					else if(fieldName.equals("classTwoResult")) {
						request.setAttribute("classTwoResult", value);
					}
					
						
					
					
					//����½�����attribute
					//��name��ǰn��Ϊchapter������½ڵ�ȫ�ֱ���������ӵ�attribute
					//ֱ�Ӱ�name��Ϊattribute�ı������Ͳ��ã�1��2��3��4��5...����
					else if(fieldName.substring(0,4).equals("chap")&&fieldName.length()==5) {
						chaptern = fieldName;
						System.out.println("�½�����:"+value);
						System.out.println("�½�Name:"+chaptern);
						request.setAttribute(fieldName, value);
					}
					
					//���С�ڵ�attribute
					//��ΪС�ڣ���Ҳ�ǿ���ֱ�Ӹ��ǲ���Ҫд1-8��С�ڵ�ȫ�ֱ���
					//��ɵ�Ĳ����Բ�...
					else if(fieldName.substring(5,9).equals("sect")) {
						sectionn = fieldName;
						System.out.println("С������:"+value);
						System.out.println("С��Name:"+sectionn);
						request.setAttribute(fieldName, value);
					}
					
					
					
					
					
				}else{
					//��ȡ���ϴ��ļ��У��ϴ��ļ�������
					String name = fileItem.getName();
					
					
					//Ϊ�˽��һЩ�����������IE6���ϴ��ļ���ʱ���ϴ��ļ���������·��������C��\\upload\file\aa.txt����Ҫ�ر���һ�£�
					//����һ��Ŀǰ��������������ˣ���Ҫ���һЩ�������
					int index = name.lastIndexOf("\\");
					//���ƥ�䵽���������ڵ���0���ͱ�ʾ��Ҫ���н�ȡ����Ϊƥ�䲻���Ļ��Ƿ���-1
					if(index >= 0){
						name = name.substring(index+1 , name.length());
					}
					//Ϊ�˷�ֹ������ϴ����ļ�����һ������ô�ͻ��֮ǰ�Ľ����滻����������ҲҪ�ر���һ�£���Ȼ��ʱ���Ҳ�У�
//					name = UUID.randomUUID().toString() + name;
					
					//���ϴ����ļ�����Ϊ�γ�id+�½�n+С��n�ĸ�ʽ
					//��ô�����׺����,ֱ������.�ַ�...Ȼ���ȡ
					//�ܳ��������Ȼ���ż���,һ����Ƶ��ʽ����wmv,mp4,avi,mkv���Ե�ʱ�����ƾ����ˡ�
					//��ȡ�ļ����ͺ�׺����λ�ã�Ȼ����ļ�Ϊ�̶���ʽ
					//System.out.println("�ļ���"+name.substring(0,name.length()-4));
					//System.out.println("�ļ���׺"+name.substring(name.length()-4,name.length() ));
					//�����滻�е��鷳���Ҿ���ȡ����׺��Ȼ��ֱ�Ӹ�ֵ�̶���ʽ��name
					String namePostfix = name.substring(name.length()-4,name.length() );
					name = courseid+sectionn + namePostfix;
					System.out.println("�滻��ɺ���ļ�����"+name);
					
					
					
					
					//��ȡ���ϴ��ļ����ֽ�������
					InputStream inputStream = fileItem.getInputStream();
					
					//��ȡ����ϴ����ݵ�·��
					//�ϴ�·������������web-infĿ¼����������ʽ
					//String realPath = getServletContext().getRealPath("/demo1path");
					String realPath = "C:\\Users\\bralaya_h\\Documents\\CodeProject\\eclipse-workspace\\OnlineMooc\\WebContent\\course\\freeCourse\\";
					//��������web-infĿ¼�ڲ��Ļ������������ʽ�����������ķ�ʽ����Ϊ�����Ļ��Ͳ���ֱ�Ӵ�������������Ŀ¼��������ݣ����Ӱ�ȫ
					//String realPath = getServletContext().getRealPath("WEB-INF/demo1path");
					//�������ļ�·������ֹĿ¼�����ڵ�ʱ������쳣����
					if(!new File(realPath).exists()){
						new File(realPath).mkdirs();
					}
					//����������������û�����������ܹ�����ϴ���Ч��
					OutputStream os =new BufferedOutputStream( new FileOutputStream(new File(realPath , name)));				
					//�����ϴ������õ�commons.io.jar�������һ����������Ա�һ��Ĵ������
					IOUtils.copy(inputStream, os);
					
					//����ʱĿ¼�е����ݽ���ɾ������Ҳ������֮ǰΪ������ϴ�Ч�ʶ���ӵ���ʱĿ¼
					fileItem.delete();
					
					//�ļ�·�����ݸ�moocServlet
					request.setAttribute(chaptern+sectionn, realPath+name);
					System.out.println("·����attribute������:"+chaptern+sectionn);
					//������سɹ����������ϴ�λ�õ�·�����ļ���
					System.out.println("�ϴ��ɹ���·��Ϊ��"+realPath+name);
					//�ر���Դ
					inputStream.close();
					os.close();
				}
			}
			
			//��������������
			//�ض���MoocServlet�������ݿ�д�����
			//request.setAttribute("satname", "shu");
			ServletContext application = this.getServletContext();
			RequestDispatcher rd = application.getRequestDispatcher("/MoocServlet?functionChoise=CourseMessageHandle");
			rd.forward(request,response);
			
		} catch (Exception e) {
			//ץȡ�����ļ��ϴ���С��������
			if(e instanceof FileSizeLimitExceededException){
				System.out.println("�����ļ�̫����~~~~~~~~~~~");
			}
			//ץȡ�ϴ�����ļ��ϴ���С��������
			if(e instanceof SizeLimitExceededException){
				System.out.println("�ܵ��ϴ��ļ�̫����~~~~~~~~~~~");
			}
			e.printStackTrace();
		}
		
		
	}
 
}
