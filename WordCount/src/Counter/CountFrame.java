package Counter;

import java.awt.*;
import java.io.*;

import javax.swing.*;

//图形界面类
public class CountFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();;
	public static final int screenWidth = screenSize.width; //窗口宽度
	public static final int screenHeigh = screenSize.height;  //窗口高度
	
    private File filename;//文件名
    
	public CountFrame(File filename)
	{
		super(filename.toString());
		this.filename = filename;
		this.setSize(screenWidth/2, screenHeigh/2);
		this.setLocation(screenWidth / 4, screenHeigh / 8);
		
		JTextArea textarea = new JTextArea(filename.toString());//文本框
		JScrollPane scroller = new JScrollPane(textarea);
		
		FileReader fr = null;
		BufferedReader bfr = null;
		char[] buff = new char[128];
		try {
			fr = new FileReader(filename);
			bfr = new BufferedReader(fr);
			while(bfr.read(buff)!=-1)//读取文本，并显示在文本框中
			{
				String s = new String(buff);
				textarea.append(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(bfr!=null) bfr.close();
					if(fr!=null)fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		//创建FileCount类对象，统计文本中的行数、字符数和词数
		FileCount filecount = new FileCount(this.filename);
		filecount.count();
		textarea.append("\n\nSysmbols are "+filecount.getSymbols()+"\nwords are "+filecount.getWords()+
						"\nlines are "+filecount.getLines());
		
		textarea.setVisible(true);
		this.add(scroller);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
