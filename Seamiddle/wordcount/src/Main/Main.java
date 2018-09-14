package Main;

import java.io.*;

import javax.swing.*;

import Counter.CountFrame;
import Counter.FileCount;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String filename = null;
       
       String arguement = args[0];//参数
       
       File Filename = null;
       FileCount filecount = null;
       
     //如果参数为"x",创建图形界面类，显示所选文件的统计信息
       if(arguement.equals("-x")){
    	   JFileChooser jfc = new JFileChooser();//创建文件发送选择框
			jfc.setMultiSelectionEnabled(false);
			jfc.showOpenDialog(new JLabel());
			
			File file = jfc.getSelectedFile();//获取选中的文件
			if(file!=null) {
				if(file.toString().endsWith(".java"))
				new CountFrame(file);
			   else System.out.println("ERRORFile");
			}
			else System.out.println("ERRORFile");
       }
      
       //参数不是给定的提示输入参数错误
       else if(!(arguement.equals("-c")||arguement.equals("-w")||
    		   arguement.equals("-l")||arguement.equals("-s"))){
    	   System.out.println("\narguement ERROR");
       }
       
       else{
       try {
    	filename = args[1];//获取文件参数
    	Filename = new File(filename);
    	
    	//判断所填写的文件参数的文件是否存在
    	FileInputStream fip = new FileInputStream(Filename);
    	if(fip!=null) fip.close();
    	
    	//创建FileCount类统计文件信息
		filecount = new FileCount(Filename);
		filecount.count();
		
		if(arguement.equals("-c"))//第一个参数为"c",显示字符数
    		System.out.println("\nSysmbols are "+filecount.getSymbols());
    	
		else if(arguement.equals("-w"))//第一个参数为"w",显示词数
    		System.out.println("\nwords are "+filecount.getWords());
    	
		else if(arguement.equals("-l"))//第一个参数为"l",显示行数
		    System.out.println("\nlines are "+filecount.getLines());
    	
		else if(arguement.equals("-s"))//第一个参数为"s",显示该目录下符合的文件的统计信息
    	{
    	    File parent = Filename.getParentFile();//获取文件所在的目录
    
    	    File[] otherfiles = parent.listFiles();//获取目录中的文件
    	   
    	    //如果后缀为.java的文件进行统计
    	    for(File f:otherfiles){
    	    	if(f.toString().endsWith(".java")){
    	    		FileCount fc = new FileCount(f);
    	    		fc.count();
    	    		System.out.println("\nFile "+f+"\nsymbols are "+fc.getSymbols()+
    	    				"\nlines are "+fc.getLines()+"\nwords are "+fc.getWords());
    	    	}
    	    }
    	}  		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("ERRORFile");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
  }
}
