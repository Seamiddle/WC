package Main;

import java.io.*;

import javax.swing.*;

import Counter.CountFrame;
import Counter.FileCount;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String filename = null;
       
       String arguement = args[0];//����
       
       File Filename = null;
       FileCount filecount = null;
       
     //�������Ϊ"x",����ͼ�ν����࣬��ʾ��ѡ�ļ���ͳ����Ϣ
       if(arguement.equals("-x")){
    	   JFileChooser jfc = new JFileChooser();//�����ļ�����ѡ���
			jfc.setMultiSelectionEnabled(false);
			jfc.showOpenDialog(new JLabel());
			
			File file = jfc.getSelectedFile();//��ȡѡ�е��ļ�
			if(file!=null) {
				if(file.toString().endsWith(".java"))
				new CountFrame(file);
			   else System.out.println("ERRORFile");
			}
			else System.out.println("ERRORFile");
       }
      
       //�������Ǹ�������ʾ�����������
       else if(!(arguement.equals("-c")||arguement.equals("-w")||
    		   arguement.equals("-l")||arguement.equals("-s"))){
    	   System.out.println("\narguement ERROR");
       }
       
       else{
       try {
    	filename = args[1];//��ȡ�ļ�����
    	Filename = new File(filename);
    	
    	//�ж�����д���ļ��������ļ��Ƿ����
    	FileInputStream fip = new FileInputStream(Filename);
    	if(fip!=null) fip.close();
    	
    	//����FileCount��ͳ���ļ���Ϣ
		filecount = new FileCount(Filename);
		filecount.count();
		
		if(arguement.equals("-c"))//��һ������Ϊ"c",��ʾ�ַ���
    		System.out.println("\nSysmbols are "+filecount.getSymbols());
    	
		else if(arguement.equals("-w"))//��һ������Ϊ"w",��ʾ����
    		System.out.println("\nwords are "+filecount.getWords());
    	
		else if(arguement.equals("-l"))//��һ������Ϊ"l",��ʾ����
		    System.out.println("\nlines are "+filecount.getLines());
    	
		else if(arguement.equals("-s"))//��һ������Ϊ"s",��ʾ��Ŀ¼�·��ϵ��ļ���ͳ����Ϣ
    	{
    	    File parent = Filename.getParentFile();//��ȡ�ļ����ڵ�Ŀ¼
    
    	    File[] otherfiles = parent.listFiles();//��ȡĿ¼�е��ļ�
    	   
    	    //�����׺Ϊ.java���ļ�����ͳ��
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
