import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;

class Editor extends WindowAdapter implements ActionListener 
{
		Frame f,f3;
		MenuBar mb;
		int tofind;
		Menu m1,m2,m3;
		String stemp="";
		TextArea ta;
		Button b1,b2,b3,b4;
		FileInputStream fis;
		String str1,str2,strn="";
		String str3="",str4,str5;
		String REGEX="";
		FileWriter fos;
		TextField tf1,tf2,tf;
		MenuItem nw,opn,sve,sveas,ext,fnd,fndrp,ab,bu,rn;
		public Editor() //throws IOException
		{
			f = new Frame();
		
			f.setSize(400,400);
			f.addWindowListener(this);
			
			mb = new MenuBar();
			m1 = new Menu("File");
			m2 = new Menu("Tools");
			m3 = new Menu("Build");
			
			nw = new MenuItem("New");
			opn = new MenuItem("Open");
			sve= new MenuItem("Save");
			sveas = new MenuItem("SaveAs");
			ext = new MenuItem("Exit");
			fnd = new MenuItem("Find");
			fndrp = new MenuItem("Find & Replace");
			ab = new MenuItem("About Notepad");
			bu = new MenuItem("Compile");
			rn = new MenuItem("Run");
			
			ta = new TextArea();
			ta.setEditable(false);
			f.add(ta);
			nw.addActionListener(this);
			opn.addActionListener(this);
			sve.addActionListener(this);
			sveas.addActionListener(this);
			ext.addActionListener(this);
			fnd.addActionListener(this);
			fndrp.addActionListener(this);
			ab.addActionListener(this);
			bu.addActionListener(this);
			rn.addActionListener(this);
			
			m1.add(nw);		m1.add(opn);	m1.add(sve);	m1.add(sveas);		m1.addSeparator();	m1.add(ext);
			m2.add(fnd);	m2.add(fndrp);	m2.addSeparator();		m2.add(ab);	m2.addSeparator();
			m3.add(bu);		m3.add(rn);
			
			mb.add(m1);		mb.add(m2);		mb.add(m3);
			
			f.setMenuBar(mb);
		//	f.add(ta);
			f.setVisible(true);		
		}
		
		public void actionPerformed(ActionEvent e) //throws IOException
		{
			String str = e.getActionCommand();
		//	System.out.println(str+ " was Pressed. ");
			if(str.equals("New"))
			{
				ta.setEditable(true);
			}
			
			
			if(str.equals("Open"))
			{
				
				ta.setEditable(true);
				FileDialog fd = new FileDialog(f,"SELECT",FileDialog.LOAD);
				fd.setVisible(true);
			
				int ch;
				str1 = fd.getFile();
				str2 = fd.getDirectory();
				File  f1 = new File(str2,str1);
				
					
				 try {
				 	fis = new FileInputStream(f1);
				 	while((ch=fis.read())!=-1)
				 	{
				 		strn = strn+(char)ch;
				 	}
				 	ta.setText(strn);
						}
				
				 catch ( IOException e2 ) {
					e2.printStackTrace();
					}
					
					//fis = new FileInputStream(f);
				
			}
			if(str.equals("Save"))
			{
				if(str3.equals(""))
				{
				
				FileDialog fd2 = new FileDialog(f,"SELECT",FileDialog.SAVE);
				fd2.setVisible(true);
				//fd2.addWindowListener(this);
				//String str3,str4,str5;
				int ch;
				str3 = fd2.getFile();
				str4 = fd2.getDirectory();
				File  f2 = new File(str4,str3);
				str5 = ta.getText();
				 try {
				 	//System.out.println(str5);
				 	fos = new FileWriter(f2);
				 	fos.write(str5,0,str5.length());
				 	fos.close();
				 	}
				
				 catch ( IOException e3 ) {
					e3.printStackTrace();
					}
				
				}
				
				else
					try {
				 	//System.out.println(str5);
				 	File  f2 = new File(str4,str3);
				 	str5 = ta.getText();
				 	fos = new FileWriter(f2);
				 	fos.write(str5,0,str5.length());
				 	fos.close();
				 	}
				
				 catch ( IOException e4 ) {
					e4.printStackTrace();
					}
					
			}
			if(str.equals("SaveAs"))
			{
				FileDialog fd2 = new FileDialog(f,"SELECT",FileDialog.SAVE);
				fd2.setVisible(true);
				//fd2.addWindowListener(this);
				String str3,str4,str5;
				int ch;
				str3 = fd2.getFile();
				str4 = fd2.getDirectory();
				File  f2 = new File(str4,str3);
				str5 = ta.getText();
				 try {
				 	//System.out.println(str5);
				 	fos = new FileWriter(f2);
				 	fos.write(str5,0,str5.length());
				 	fos.close();
				 	}
				
				 catch ( IOException e3 ) {
					e3.printStackTrace();
					}
				
			}
			if(str.equals("Find"))
			{
				f3 = new Frame();
				f3.setSize(200,200);
				f3.addWindowListener(this);
				Label lf = new Label("Find");
				f3.add(lf,"North");
				
				Panel pf1 = new Panel ();
				tf1 = new TextField(20);
				pf1.add(tf1);
				f3.add(pf1);
				
				Panel pf = new Panel ();
				b1 = new Button("Find Next");
				b2 = new Button("Close"); 
				pf.add(b1);
			
				b1.addActionListener(this);
				b2.addActionListener(this);

				pf.add(b2);
				f3.add(pf,"South");
				f3.setVisible(true);
				
			}
			if(str.equals("Find & Replace"))
			{	
				f3 = new Frame();
				f3.setSize(300,200);
				f3.addWindowListener(this);
				
				//f3.add(lf,"North");
				Panel pf0 = new Panel ();
				pf0.setLayout(new GridLayout(4,0));
				Panel pf1 = new Panel ();
				Panel pf2 = new Panel ();
				Panel pf3 = new Panel ();
				Panel pf4 = new Panel ();
				Label lf1 = new Label("Find");
				Label lf2 = new Label("Replace With");
				 tf1 = new TextField(20);
				 tf2 = new TextField(20);
				pf1.add(lf1);
				pf2.add(tf1);
				
				pf3.add(lf2);
				pf4.add(tf2);
				
				pf0.add(pf1);
				pf0.add(pf2);
				pf0.add(pf3);
				pf0.add(pf4);
				
				f3.add(pf0);
				
				Panel pf = new Panel ();
				b1 = new Button("Find Next");
				b3 = new Button("Replace");
				b4 = new Button("Replace All");
				b2 = new Button("Close"); 
				
			
				b1.addActionListener(this);
				b2.addActionListener(this);
				b3.addActionListener(this);
				b4.addActionListener(this);
				pf.add(b1);
				pf.add(b3);
				pf.add(b4);
				pf.add(b2);
				
				f3.add(pf,"South");
				f3.setVisible(true);

				
			}
			if(str.equals("About Notepad"))
			{
				Frame f2 = new Frame();
				f2.setSize(300,150);
				f2.addWindowListener(this);
				Label l = new Label("This Notepad Developed by Pankaj");
				f2.add(l);
				f2.setVisible(true);
			}
			
			if(str.equals("Exit")){
			
				System.exit(1);
			}
			
			if(str.equals("Compile")){
			
				String location = str2;
    			try
    			{
    			Process process = Runtime.getRuntime().exec("javac " + str1,null,new File(location));
    			Frame fc = new Frame();
				fc.setSize(200,200);
				fc.addWindowListener(this);
    			InputStream in=process.getErrorStream();
         		int chc;
         		String strc="";
         		while((chc = in.read()) != -1) {
            	strc = strc+(char)chc;
				}
				
				if(strc.equals(""))
					strc = "Process Completed";
				TextArea tc = new TextArea(strc);
		
				fc.add(tc);
				fc.setVisible(true);	
					}
    			catch (IOException ec) {
         		ec.printStackTrace();
      			}
      			}
			
			
			if(str.equals("Run")){
				String dosCommand = "cmd /c start cmd /k java ";
				String location = str2;
				int position = str1.lastIndexOf(".");
				String s2 = str1.substring(0,position);
    			try
    			{
    			Process process = Runtime.getRuntime().exec(dosCommand + s2,null,new File(location));
    			Frame fr = new Frame();
				fr.setSize(200,200);
				fr.addWindowListener(this);
    			InputStream in=process.getErrorStream();
         		int chr;
         		String strr="";
         		while((chr = in.read()) != -1) {
            	strr = strr+(char)chr;
				}
				TextArea tr = new TextArea(strr);
		
				fr.add(tr);
				fr.setVisible(true);	
					}
    			catch (IOException er) {
         		er.printStackTrace();
      }
			}
			
			
			if( e.getSource()==b1)
			{
				
				REGEX = tf1.getText();
				String INPUT = ta.getText();
				INPUT=INPUT.replace("\r","");
				//String REPLACE = tf2.getText();
				Pattern p = Pattern.compile(REGEX);
				Matcher m = p.matcher(INPUT);
				//INPUT = m.replaceFirst(REPLACE);
			//	m.start();
			//	m.end();
				m.find(tofind);
				f.toFront();
			//	if(REGEX.equals())
				if((stemp.equals(tf1.getText())))
				{
					//System.out.println("ok");
					tofind=m.end();	
				}
				else
				tofind = 0;
				ta.select(m.start(),m.end());
					stemp =tf1.getText();
				
				//ta.setText(INPUT);
				
			}
			
			if(e.getSource()==b2)
			{
				System.out.println("Yes");
				f3.setVisible(false);
				//f3.addWindowListener(this);
			}
			
			if( e.getSource()==b3)
			{
				REGEX = tf1.getText();
				String INPUT = ta.getText();
				String REPLACE = tf2.getText();
				Pattern p = Pattern.compile(REGEX);
				Matcher m = p.matcher(INPUT);
				INPUT = m.replaceFirst(REPLACE);
				ta.setText(INPUT);	
			}
			
			if( e.getSource()==b4)
			{
				String REGEX = tf1.getText();
				String INPUT = ta.getText();
				String REPLACE = tf2.getText();
				Pattern p = Pattern.compile(REGEX);
				Matcher m = p.matcher(INPUT);
				INPUT = m.replaceAll(REPLACE);
				ta.setText(INPUT);
			}
			
			
		}
		
		
		public void windowClosing(WindowEvent e)
		{
			
			Window w = e.getWindow();
			w.setVisible(false);
			w.dispose();
			//if()
			//System.exit(1);
	
		}
		
		public static void main(String args[]) //throws IOException
		{
			DemoNote dn = new DemoNote();
		} 
	
}
