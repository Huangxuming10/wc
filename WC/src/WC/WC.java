package WC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WC {
	public static void main (String[] args) throws IOException {
		
		do {
			System.out.println("-c [�ļ�·��]  �����ļ��ַ���");
			System.out.println("-w [�ļ�·��]  �����ļ�����");
			System.out.println("-l [�ļ�·��]  �����ļ�����");
			
			System.out.println("���������");
			Scanner m=new Scanner(System.in);     //��ȡ���������
			String n=m.nextLine();           //��ȡ��������
			String arr[]=n.split("\\s");     //��ȡ���������ÿһ���Կո�Ϊ����ĵ���
			File file=new File(arr[1]);
			
			int chars=0;
			int words=1;
			int lines=1;
			
			FileInputStream f=new FileInputStream(file);  //��ȡ�ļ�
			int a=0;
			Boolean b=false;
			String c="\t\n\r";
			while ((a=f.read())!=-1) {
				chars++;
				if(a=='\n') {
					lines++;
					
				}
				if(c.indexOf(a)!=-1) {
					if(b) {
						words++;
						
					}
				    b=false;
			    }
			    else {
				    b=true;
			}
			}
			
			
			try {
				switch (arr[0]) {
				case "-c":System.out.println("�ַ�����"+chars);break;       //�����ļ��ַ���
				case "-w":System.out.println("������"+words);break;        //�����ļ�����
				case "-l":System.out.println("������"+lines);break;     //�����ļ�����
				default:System.out.println("�����������!");break;   //���ط�������
				}
			} catch (Exception e) {
				System.out.println("���������ļ����뷢���쳣��");
			}
		} while (true);
		
	}
		

}
