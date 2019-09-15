import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Task4 {
	
	static class MyFiles {
		public int key;
		public String path;
		public String dir;
		
		public MyFiles(int key, String path, String dir) {
			this.key = key;
			this.path = path;
			this.dir = dir;
		}
		
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}

		public String getDir() {
			return dir;
		}

		public void setDir(String dir) {
			this.dir = dir;
		}		
		
	}


	public static void main(String[] args) throws IOException {

		System.out.println("============================");        
		
		Scanner scanner = new Scanner(System.in);
		//int a = scanner.nextInt();
		
		//HashMap<MyFiles> hmap = new HashMap<MyFiles>();
		
		/*
		ArrayList<String> al = new ArrayList<String>(); 
        al.add("/etc/sudoers");
        al.add("/etc/sudoers2"); 
        al.add("/root/readme"); 
        al.add("/etc/ntp/keys");
        al.add("/test/ntp/keys");
        al.add("/etc/yet/keys");
        al.add("/etc/zshrc"); 
        al.add("/bin/curl");        
        List<String> al = InputLines();
        */
		
		List<String> al = InputLines();
		
        ArrayList<MyFiles> arraylist = new ArrayList<MyFiles>(); 
        String d = "";
        
        int i = 0;
        for (String str : al) {
        	i = str.split("/").length-2;
        	System.out.println(i + "   " + str);
        	
        	File f1 = new File(str);
        	d = f1.getParent();
        	
        	arraylist.add(new MyFiles(i, str, d));
        	i += 1;
		}
        System.out.println("============================");        
        arraylist.sort(Comparator.comparing(MyFiles::getDir).thenComparing(MyFiles::getKey));
        
        String prevDir = "", curDir = "";
        
        // 1 - silmek
        // 2 - geri qayitmaq
        // 3 - in folder
        
        int sec = 0;
        for (MyFiles myFile : arraylist) {
        	sec = sec + 1;        	
        	File f = new File( myFile.getPath() );
        	curDir = f.getParent();
        	
        	String[] s = myFile.getPath().split("/");
        	//if (prevDir.equals(""))
        	//	prevDir = curDir;
        	
        	if (!prevDir.equals(curDir)) {
        		prevDir = curDir;        		
        		sec = sec + s.length-1;
        	}
        	
        	System.out.println(myFile.getPath() + "   sec = " + sec);
		}
        
        System.out.println(sec);        
	}
	
	private static List<String> InputLines() throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int lineCount = Integer.parseInt(reader.readLine());
        List<String> files=new ArrayList<>(lineCount);
        for (int i = 0; i < lineCount; i++) {
            String line = reader.readLine();
            files.add(line);
        }
        reader.close();
        return files;
    }
}
