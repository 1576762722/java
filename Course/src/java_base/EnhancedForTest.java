package java_base;

/**
 * @author ming
 *对比 for 与 foreach
 */
public class EnhancedForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sa = {"何以", "解忧","唯有Java!"};
		for(int i = 0; i < sa.length; i++) {
			System.out.println(sa[i]);
		}
		for(String s:sa) {
			System.out.println(s);
		}
	}

}
