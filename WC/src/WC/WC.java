package WC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WC {
	public static void main (String[] args) throws IOException {
		
		do {
			System.out.println("-c [文件路径]  返回文件字符数");
			System.out.println("-w [文件路径]  返回文件词数");
			System.out.println("-l [文件路径]  返回文件行数");
			
			System.out.println("请输入命令：");
			Scanner m=new Scanner(System.in);     //读取输入的命令
			String n=m.nextLine();           //读取输入命令
			String arr[]=n.split("\\s");     //读取输入命令的每一个以空格为间隔的单词
			File file=new File(arr[1]);
			
			int chars=0;
			int words=1;
			int lines=1;
			
			FileInputStream f=new FileInputStream(file);  //读取文件
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
				case "-c":System.out.println("字符数："+chars);break;       //返回文件字符数
				case "-w":System.out.println("词数："+words);break;        //返回文件词数
				case "-l":System.out.println("行数："+lines);break;     //返回文件行数
				default:System.out.println("输入命令错误!");break;   //返回发生错误
				}
			} catch (Exception e) {
				System.out.println("发生错误：文件读入发生异常！");
			}
		} while (true);
		
	}
		

}
