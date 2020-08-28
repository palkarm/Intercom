import java.util.Comparator;

public class Customer {
    String name;
    int user_id;
    public Customer(String name , Integer user_id){
        this.name = name;
        this.user_id = user_id;
    }
}
//nameCompare Class to compare the names

class  nameCompare implements Comparator<Customer>
{

    public int compare(Customer c1, Customer c2)
    {
        return c1.name.compareTo(c2.name);
    }
}

//marksCompare Class to compare the marks

class marksCompare implements Comparator<Customer>
{

    public int compare(Customer c1, Customer c2)
    {
        return c2.user_id - c1.user_id;
    }
}
