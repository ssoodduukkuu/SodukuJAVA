import java.util.Iterator;

//the unit of each point
@SuppressWarnings("rawtypes")
public class Seed implements Iterator{
	
	int X,Y,Value;
	int K_Original;
	int K_Label;
	int[] V_Maybe=new int[9];//直观讲就是可以填的数
    int Order;
    
    public int get_X() {
		return X;
	}
    public int get_Y() {
		return Y;
	}
    public void setV_Maybe(int i){
		K_Label=0;
		V_Maybe[i-1]=i;
	}
	
	public void setV_Maybe() {
		int[] v=new int[9];
		K_Label=0;
		for(int i=0;i<9;i++){
			if(V_Maybe[i]==0){
				v[K_Label]=i+1;
				K_Label++;
			}
		}
		V_Maybe=v;
		K_Label--;
	}

	public int getK_Label() {
		return K_Label;
	}

	public void setK_Label(int k_Label) {
		K_Label = k_Label;
	}

	public int getValue() {
		return Value;
	}
	
	public int getOrder() {
		return Order;
	}

	public void setValue(int value) {
		Value = value;
	}
    public void setOrder(int order) {
    	Order = order;
    }
	public Seed(int x, int y, int value) {
		super();
		X = x;
		Y = y;
		Value = value;
		K_Label=-2;
		K_Original=0;
		Order=-1;
		for(int i=0;i<9;i++){
			V_Maybe[i]=0;
		}
	}

	@Override
	public boolean hasNext() {
		if(Order==80){// TODO Auto-generated method stub
			return false;
		}
		else
			return true;
	}

	@Override
	public Seed next() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
	
}
