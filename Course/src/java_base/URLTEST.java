package java_base;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTEST {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL aurl = new URL("https://java.sun.com:80/docs/books");
		URL tuto = new URL(aurl, "tutorial.into.html#DOWNLOADING");
		System.out.println("protocol = " + tuto.getProtocol());
		System.out.println("host = " + tuto.getHost());
		System.out.println("port = " + tuto.getPort());
		System.out.println("ref = " + tuto.getRef());
		System.out.println("query = " + tuto.getQuery());
		System.out.println("path = " + tuto.getPath());
		System.out.println("UserInfo = " + tuto.getUserInfo());
		System.out.println("Authority = " + tuto.getAuthority());
	}

}
