//hemanta Parajuli
import java.lang.reflect.Array;

public class driver {

	public static void main(String[] args) throws Exception {
		AList<String> mylist = new AList<>();
        
	     System.out.println("Is the List is empty at the moment?");
	     System.out.println("***********************");
	     System.out.println(mylist.isEmpty());
	     System.out.println("***********************");
	     
	      mylist.add("The Sopranos");
	      mylist.add("Breaking Bad");
	      mylist.add("Old man and the sea");
	      mylist.add("kites");
	      
	      System.out.println("Is the List is empty at the moment?");
	      System.out.println("***********************");
		  System.out.println(mylist.isEmpty());
	       
		  for(int i = 1; i <= mylist.getLength(); i++)
			{
				System.out.println(i + ") " + mylist.getEntry(i));
			}
		  System.out.println("Trying the replace method,replacing breaking bad with Game of Thrones");
		  System.out.println("***********************");
		  
		  mylist.replace(2,"Game of thrones" );
		  for(int i = 1; i <= mylist.getLength(); i++)
			{
				System.out.println(i + ") " + mylist.getEntry(i));
			} 
		  System.out.println("***********************");
		  System.out.println(" trying the contains method");
          System.out.println("***********************");
          //using contains method
          System.out.println("does it have the thing called kites?");
          System.out.println(mylist.contains("kites"));
          System.out.println("***********************");
		  System.out.println(" trying the get position method");
          System.out.println("***********************");
          //getting the position of element 
          int j = mylist.getPosition("kites");
          System.out.println("the Position of kites in list is "+ j);
          // trying the remove  method
          System.out.println("new list after removing 3rd element");
          mylist.remove(3);
          for(int i = 1; i <= mylist.getLength(); i++)
			{
				System.out.println(i + ") " + mylist.getEntry(i));
			} 
          int k = mylist.getPosition("kites");
          System.out.println("the Position of kites in list is "+ k);
          for(int i = 1; i <= mylist.getLength(); i++)
			{
				System.out.println(i + ") " + mylist.getEntry(i));
			} 
          mylist.add(3, "pringles");
          for(int i = 1; i <= mylist.getLength(); i++)
			{
				System.out.println(i + ") " + mylist.getEntry(i));
			} 
	}
}
