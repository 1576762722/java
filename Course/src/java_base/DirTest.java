package java_base;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DirTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("src\\java_base");
		File[] fa = f.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".java");
			}
		});
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String date = null;
		String isDir = null;
		
		for(File ff : fa)
		{
			date = sdf.format(new Date(ff.lastModified()));
			isDir= ff.isDirectory()?"<dir>":":";
			System.out.printf("%s\t\t%d\t%s\t%s\n", ff.getName(), ff.length(), isDir, date);
			System.out.println(isDir);
		}
	}

}

/*
 * 
 *出现 ？ 就是 if else 的意思File.listFiles() 查看目录  可以重写方法进行过滤
 */
