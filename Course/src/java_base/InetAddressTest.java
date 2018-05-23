package java_base;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress local1 = InetAddress.getByName("localhost");
		byte[] ba = {127, 0, 0, 1};
		InetAddress local2 = InetAddress.getByAddress(ba);
		InetAddress local3 = InetAddress.getLocalHost();
		System.out.println("取InetAddress中的ip地址:" + local1.getHostAddress());
		System.out.println("取InetAddress中的域名或计算机名:" + local2.getHostName());
		
		InetAddress local4 = InetAddress.getByName("www.baidu.com");
		System.out.println(local4.getHostAddress());
		System.out.println(Arrays.toString(local4.getAddress()));
		System.out.println((byte)220);
	}

}
