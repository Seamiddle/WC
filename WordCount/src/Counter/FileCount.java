package Counter;

import java.io.*;

//��������ͳ���ı����������ַ����ʹ���
public class FileCount {
    private File filename; //�ļ���
    
    private int lines; //����
    
    private int symbols; //������
    
    private int words; //������
    
    public int getLines()
    {
    	return this.lines;
    }
    
    public int getSymbols()
    {
    	return this.symbols;
    }
    
    public int getWords()
    {
    	return this.words;
    }
    
    public FileCount(File filename)
    {
    	this.filename = filename;
    	this.lines = 0;
    	this.symbols = 0;
    	this.words = 0;
    }
    
   public void count(){   //�����ļ����������ַ����͵�����
	   FileReader fr = null; 
	   try {
		fr = new FileReader(this.filename);
		
		int firstread,nowread;
		char c_firstread,c_nowread; //����ļ��еĵ�ǰ�ַ���ǰһ���ַ�
		
		if((firstread = fr.read())!=-1){ //�ж��ļ��Ƿ�Ϊ��   
    	     c_firstread = (char)firstread;
    	     
    	     this.lines++;
    	     if(!(c_firstread=='\n')) this.symbols++;
    	     
    	     for(nowread = fr.read();;nowread = fr.read()){  //���ζ��ļ��е�ÿ���ַ�
    	    	
    	    	 if(nowread==-1){//�ж��Ƿ�ֻ��һ���ַ�
    	    		 if((c_firstread>='A'&&c_firstread<='Z')||
    	    				 (c_firstread>='a'&&c_firstread<='z'))
    	    			 words++;
    	    		 break;
    	    	 }
    	    	 c_firstread = (char)firstread;
    	    	 c_nowread = (char)nowread;
    	    	 //System.out.print(c_nowread);
    	    	 
    	    	 if(nowread=='\n') this.lines++;//��ǰ�������ǻ��з���������һ
    	    	 
    	    	 if(!((c_nowread>='A'&&c_nowread<='Z')||(c_nowread>='a'&&c_nowread<='z')))
    	    		 if((c_firstread>='A'&&c_firstread<='Z')||(c_firstread>='a'&&c_firstread<='z'))
    	    		 words++;//�����ǰ�������Ƿ���ĸ��ǰһ������Ϊ��ĸ����������һ
    	    	 
    	    	 if(!(c_nowread=='\n')) this.symbols++;
    	    	 
    	    	 firstread = nowread;
    	     }
    	}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(fr!=null)
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
   }
}
