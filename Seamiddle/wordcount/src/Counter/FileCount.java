package Counter;

import java.io.*;

//该类用于统计文本的行数、字符数和词数
public class FileCount {
    private File filename; //文件名
    
    private int lines; //行数
    
    private int symbols; //符号数
    
    private int words; //单词数
    
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
    
   public void count(){   //计算文件中行数、字符数和单词书
	   FileReader fr = null; 
	   try {
		fr = new FileReader(this.filename);
		
		int firstread,nowread;
		char c_firstread,c_nowread; //标记文件中的当前字符和前一个字符
		
		if((firstread = fr.read())!=-1){ //判断文件是否为空   
    	     c_firstread = (char)firstread;
    	     
    	     this.lines++;
    	     if(!(c_firstread=='\n')) this.symbols++;
    	     
    	     for(nowread = fr.read();;nowread = fr.read()){  //依次读文件中的每个字符
    	    	
    	    	 if(nowread==-1){//判断是否只有一个字符
    	    		 if((c_firstread>='A'&&c_firstread<='Z')||
    	    				 (c_firstread>='a'&&c_firstread<='z'))
    	    			 words++;
    	    		 break;
    	    	 }
    	    	 c_firstread = (char)firstread;
    	    	 c_nowread = (char)nowread;
    	    	 //System.out.print(c_nowread);
    	    	 
    	    	 if(nowread=='\n') this.lines++;//当前所读的是换行符，行数加一
    	    	 
    	    	 if(!((c_nowread>='A'&&c_nowread<='Z')||(c_nowread>='a'&&c_nowread<='z')))
    	    		 if((c_firstread>='A'&&c_firstread<='Z')||(c_firstread>='a'&&c_firstread<='z'))
    	    		 words++;//如果当前所读的是非字母，前一个所读为字母，单词数加一
    	    	 
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
