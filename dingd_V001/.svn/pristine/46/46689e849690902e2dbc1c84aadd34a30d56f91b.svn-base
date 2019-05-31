package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SoketTest {



		/*
		 * 发送消息线程
		 */
		Thread send;
		
		/*
		 * 接收消息线程
		 */
		Thread receive;
		
		/*
		 * 客户端到服务器的连接
		 */
		Socket socket;
		
		public static void main(String[] args)
			throws Exception{
			//调用start
			SoketTest client = new SoketTest();
			client.start();
		}
		
		public void start() throws Exception{
			//连接到服务器 
			//创建两个 流
			//创建线程，启动线程
			//发送线程sent处理 out：向服务器发送数据
			//接收线程receive处理in，从服务接收数据
			socket = new Socket("10.150.8.8", 8890);
			final PrintWriter out = 
					new PrintWriter(
						new OutputStreamWriter(
							socket.getOutputStream(),
							"utf-8"), true);
			final BufferedReader in = 
					new BufferedReader(
					new InputStreamReader(
							socket.getInputStream(),"utf-8"));
			//创建两个线程，分别处理in和out
			send = new Thread(){
				public void run(){
					//将控制输入的信息发送到 out(服务器)中
					Scanner sc = new Scanner(System.in 

	);
					while(true){
						String str = sc.nextLine();
						//发送到服务器
						out.println(str);
						if(str.equals("bye")){
							break;
						}
					}
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					//结束客户端程序
					System.exit(0);//关闭Java进程！
				}
			};
			receive = new Thread(){
				public void run() {
					//从in（服务器）读取消息，显示在控制台上
					try{
						while(true){
							String str = in.readLine();
							if(str==null){
								//得到null表示与服务器断线
								//就抛出异常结束线程
								throw new IOException("断线！");
							}
							//将接收的消息显示控制台
							System.out.println(str); 
						}
					}catch(IOException e){
						e.printStackTrace();
						System.out.println("下线"); 
					}
				}
			};
			//务必启动线程
			send.start();
			receive.start();
		}
	

}
