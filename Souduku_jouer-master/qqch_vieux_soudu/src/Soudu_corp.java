
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

//create the corp of the game
public class Soudu_corp {
	
	//Vector <Seed> List_Tab=new Vector <Seed>(81); 
	List<Seed> List_Tab=new ArrayList<Seed>();
	Vector<Integer> List_Order=new Vector<Integer>();
	int[] Tab=new int[9];
	Vector<Integer> Init_T=new Vector<Integer>();
	int[][] Init_level = new int[9][9];
	
	
	public Soudu_corp(int[][] level) {
		super();
		Init_level=level;
		for(int i=0; i<9; i++){
			Tab[i]=i+1;
		}
		
	    for (int i=0; i<81; i++) {
	    	Seed t=new Seed(i/9,i%9,Init_level[i/9][i%9]);
	    	if(Init_level[i/9][i%9]!=0){
	    		Init_T.add(i);
	    	}
	    	List_Tab.add(t);
	    }
	    /*
	    for(int i=0; i<9; i++){
	    	List_Tab.get(i).setValue(i+1);
	    	Init_T.add(i);
	    }
	    for(int i=1;i<9;i++){
	    	List_Tab.get(i*9).setValue(10-i);
	    	Init_T.add(i*9);
	    }
	    */
	}
//把所有可以填的数填进数组里
	//把所有出现的数填进VAL_MAYBE里先
	public void Init_Seeds(){

		for(Iterator<Seed> it=List_Tab.iterator();it.hasNext();){
			Seed seed=(Seed) it.next();
			int p=seed.X*9+seed.Y;
			if(!Is_in(p)){
				for(int i=0;i<9;i++){
					if(List_Tab.get(p-(p%9)+i).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-(p%9)+i).getValue());
					}
				}
				for(int i=0;i<9;i++){
					if(List_Tab.get(9*i+p%9).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+(i-p/9)*9).getValue());
					}
				}
				if (((p/9)%3==0)&&((p%9)%3==0)) {
					if(List_Tab.get(p+10).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+10).getValue());
					}
					if(List_Tab.get(p+11).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+11).getValue());
					}
					if(List_Tab.get(p+19).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+19).getValue());
					}
					if(List_Tab.get(p+20).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+20).getValue());
					}
		        }
		        else if (((p/9)%3==0)&&((p%9)%3==1)) {
					if(List_Tab.get(p+8).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+8).getValue());
					}
					if(List_Tab.get(p+10).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+10).getValue());
					}
					if(List_Tab.get(p+17).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+17).getValue());
					}
					if(List_Tab.get(p+19).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+19).getValue());
					}
		        }
		        else if (((p/9)%3==0)&&((p%9)%3==2)) {
					if(List_Tab.get(p+7).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+7).getValue());
					}
					if(List_Tab.get(p+8).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+8).getValue());
					}
					if(List_Tab.get(p+16).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+16).getValue());
					}
					if(List_Tab.get(p+17).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+17).getValue());
					}
		        }
		        else if (((p/9)%3==1)&&((p%9)%3==0)) {
					if(List_Tab.get(p-8).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-8).getValue());
					}
					if(List_Tab.get(p-7).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-7).getValue());
					}
					if(List_Tab.get(p+10).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+10).getValue());
					}
					if(List_Tab.get(p+11).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+11).getValue());
					}
		        }
		        else if (((p/9)%3==1)&&((p%9)%3==1)) {
					if(List_Tab.get(p-8).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-8).getValue());
					}
					if(List_Tab.get(p-10).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-10).getValue());
					}
					if(List_Tab.get(p+8).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+8).getValue());
					}
					if(List_Tab.get(p+10).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+10).getValue());
					}
		        }
		        else if (((p/9)%3==1)&&((p%9)%3==2)) {
					if(List_Tab.get(p-11).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-11).getValue());
					}
					if(List_Tab.get(p-10).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-10).getValue());
					}
					if(List_Tab.get(p+7).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+7).getValue());
					}
					if(List_Tab.get(p+8).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p+8).getValue());
					}
		        }
		        else if (((p/9)%3==2)&&((p%9)%3==0)) {
					if(List_Tab.get(p-17).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-17).getValue());
					}
					if(List_Tab.get(p-16).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-16).getValue());
					}
					if(List_Tab.get(p-8).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-8).getValue());
					}
					if(List_Tab.get(p-7).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-7).getValue());
					}
				}
		        else if (((p/9)%3==2)&&((p%9)%3==1)) {
					if(List_Tab.get(p-19).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-19).getValue());
					}
					if(List_Tab.get(p-17).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-17).getValue());
					}
					if(List_Tab.get(p-10).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-10).getValue());
					}
					if(List_Tab.get(p-8).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-8).getValue());
					}
		        }
		        else{
					if(List_Tab.get(p-20).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-20).getValue());
					}
					if(List_Tab.get(p-19).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-19).getValue());
					}
					if(List_Tab.get(p-11).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-11).getValue());
					}
					if(List_Tab.get(p-10).getValue()!=0){
						seed.setV_Maybe(List_Tab.get(p-10).getValue());
					}
		        }
				seed.setV_Maybe();//此处实现逆转，把数组里出现的数删掉，剩下可以填的，也就是valeur maybe
				seed.K_Original=seed.K_Label;
			}
		}
	}
	//排序
	@SuppressWarnings("unchecked")
	public void Sorted_List(){
		
		Comparer com=new Comparer();
		List<Seed> List=new ArrayList<Seed>();
		for(int i=0;i<List_Tab.size();i++){
			List.add(List_Tab.get(i));
		}
		Collections.sort(List,com);
		for(int i=0;i<List.size();i++)
		{	
			//List.get(i).setOrder(i);
			List_Tab.get(List.get(i).get_X()*9+List.get(i).get_Y()).setOrder(i);
			List_Order.add(List.get(i).get_X()*9+List.get(i).get_Y());
		}
	}
	
	public boolean Is_in(int p){
		boolean test=false;
		for(int i=0;i<Init_T.size();i++){
			if(p==Init_T.get(i)){
				test=true;
			}
		}
		return test;
	}

	public List<Seed> getList_Tab() {
		return List_Tab;
	}
	
	public void Ajouter_Valeur(int x, int y, int val){List_Tab.get(x*9+y).setValue(val);}
	
	public boolean Check_Seed(int p){
	    boolean flag=true;
	    for (int i=0; i<9&&flag; i++) {
	        if (i!=(p%9)&&(List_Tab.get(p).getValue()==List_Tab.get(p+i-(p%9)).getValue())) {
	            flag=false;
	        }
	    }
	    for (int i=0; i<9&&flag; i++) {
	        if ((i!=p/9)&&(List_Tab.get(p).getValue()==List_Tab.get(p+(i-p/9)*9).getValue())) {
	            flag=false;
	        }
	    }
	    if (flag) {
	        if (((p/9)%3==0)&&((p%9)%3==0)) {
	            flag=!((List_Tab.get(p).getValue()==List_Tab.get(p+10).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+11).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+19).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+20).getValue()));
	        }
	        else if (((p/9)%3==0)&&((p%9)%3==1)) {
	        	flag=!((List_Tab.get(p).getValue()==List_Tab.get(p+8).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+10).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+17).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+19).getValue()));
	        }
	        else if (((p/9)%3==0)&&((p%9)%3==2)) {
	        	flag=!((List_Tab.get(p).getValue()==List_Tab.get(p+7).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+8).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+16).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+17).getValue()));
	        }
	        else if (((p/9)%3==1)&&((p%9)%3==0)) {
	        	flag=!((List_Tab.get(p).getValue()==List_Tab.get(p-8).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p-7).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+10).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+11).getValue()));
	        }
	        else if (((p/9)%3==1)&&((p%9)%3==1)) {
	        	flag=!((List_Tab.get(p).getValue()==List_Tab.get(p-8).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p-10).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+8).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+10).getValue()));
	        }
	        else if (((p/9)%3==1)&&((p%9)%3==2)) {
	        	flag=!((List_Tab.get(p).getValue()==List_Tab.get(p-11).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p-10).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+7).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p+8).getValue()));
	        }
	        else if (((p/9)%3==2)&&((p%9)%3==0)) {
	        	flag=!((List_Tab.get(p).getValue()==List_Tab.get(p-17).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p-16).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p-8).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p-7).getValue()));
	        }
	        else if (((p/9)%3==2)&&((p%9)%3==1)) {
	        	flag=!((List_Tab.get(p).getValue()==List_Tab.get(p-19).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p-17).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p-10).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p-8).getValue()));
	        }
	        else{
	        	flag=!((List_Tab.get(p).getValue()==List_Tab.get(p-20).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p-19).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p-11).getValue())||(List_Tab.get(p).getValue()==List_Tab.get(p-10).getValue()));
	        }
	    }
	    return flag;
	    
	}
	//*******************************************************
	//**********************问题核心所在************************
	//********************************************************
//	public Iterator<Seed> Init_Iterator(){
//		Iterator<Seed> it=List_Tab.iterator();
//		while(it.hasNext()){
//			if(((Seed)it.next()).getK_Label()!=-1){
//				return this.;
//			}
//		}
//	}
	
	public boolean Fill_List(Seed it){
		//Seed it_s=it;
		//Fill_List(List_Tab.get(List_Order.get(it.getOrder()+1)));	
		//Seed s=List_Tab.get(it.next().getOrder()+1);
		//if(it.hasNext()){
		//	it= List_Tab.get(it.next().getOrder()+1);
		//}
		if(it.K_Label==-2){
			return Fill_List(List_Tab.get(List_Order.get(it.getOrder()+1)));
		}
		else{
			if(it.hasNext()){
				if(it.getK_Label()>=0){
					it.setValue(it.V_Maybe[it.getK_Label()]);
					if(Check_Seed(it.X*9+it.Y)&&Fill_List(List_Tab.get(List_Order.get(it.getOrder()+1))))
						return true;
						//return Fill_List(it);
					else{
						it.setK_Label(it.getK_Label()-1);
						return Fill_List(it);
					}
				}
				else{
					it.K_Label=it.K_Original;
					it.setValue(0);
					return false;
					
				}	
			}
			else{
				if(it.getK_Label()>=0){
					it.setValue(it.V_Maybe[it.getK_Label()]);
					if(Check_Seed(it.X*9+it.Y))
						return true;
					else{
						it.setK_Label(it.getK_Label()-1);
						return Fill_List(it);
					}
				}
				else{
					it.K_Label=it.K_Original;
					it.setValue(0);
					return false;
				}
			}
		}
	}
	
	public void Afficher_Sys(){
	    System.out.print("******************************************************\n");
	    for (int i=0; i<9; i++) {
	        for (int j=0; j<9; j++) {
	            if ((i*9+j)==27||(i*9+j)==54) {
	                System.out.print("\n");
	            }
	            if (j==8) {
	            	System.out.print(" "+List_Tab.get(i*9+j).getValue()+"\n");
	            }
	            else if (j==3||j==6){
	            	System.out.print("  "+List_Tab.get(i*9+j).getValue());
	            }
	            else{
	            	System.out.print(" "+List_Tab.get(i*9+j).getValue());
	            }
	        }
	    }
	}





	
	
	
}
