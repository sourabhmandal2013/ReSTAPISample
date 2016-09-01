package psl.main;

//import psl.base.US500;
import psl.crud.CRUDOps;

public class Tester {

	public static void main(String[] args) 
	{
//		US500 obj = new US500("Sourabh","Mandal","PSL","Bangalore","Belendur","KA","A",-1,"B","C","Yahoo","E");
		CRUDOps crud = new CRUDOps();
//		System.out.println(obj.toString());
//		crud.writeToDb(obj);
		crud.readFromDb();
		
//		crud.deleteFromDb("Yahoo");
//		crud.updateToDb("Y", obj);
//		crud.searchDB("donette.foller@cox.net");
	}

}