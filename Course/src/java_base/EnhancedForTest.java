package java_base;

/**
 * @author ming
 *�Ա� for �� foreach
 */
public class EnhancedForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sa = {"����", "����","Ψ��Java!"};
		for(int i = 0; i < sa.length; i++) {
			System.out.println(sa[i]);
		}
		for(String s:sa) {
			System.out.println(s);
		}
	}

}
