import java.util.Comparator;


@SuppressWarnings("rawtypes")
public class Comparer implements Comparator{
	public int compare(Object o1, Object o2){
		Seed c1=(Seed) o1;
		Seed c2=(Seed) o2;
		if(c1.getK_Label()>c2.getK_Label()){
			return 1;
		}
		else if(c1.getK_Label()==c2.getK_Label()){
			return 0;
		}
		else{
			return -1;
		}
		
	}
}
