import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SortTextFile
{
    public static void main(String[] args)throws IOException
    {
        //Creating BufferedReader object to read the input text file

        BufferedReader reader = new BufferedReader(new FileReader("CustomerList.txt"));

        //Creating ArrayList to hold Student objects

        ArrayList<Customer> customerRecord = new ArrayList<Customer>();

        //Reading Student records one by one

        String currentLine = reader.readLine();

        while (currentLine != null)
        {
            String[] customerDetail = currentLine.split (" , ");

            String name = customerDetail[0];

            int user_id;
            user_id = Integer.valueOf(customerDetail[1]);

            //Creating Student object for every student record and adding it to ArrayList

            customerRecord.add(new Customer(name, user_id));

            currentLine = reader.readLine();
        }

        //Sorting ArrayList studentRecords based on marks

        Collections.sort(customerRecord, new marksCompare());

        //Creating BufferedWriter object to write into output text file

        BufferedWriter writer = new BufferedWriter(new FileWriter("Out.txt"));

        //Writing every studentRecords into output text file

        for (Customer customer : customerRecord)
        {
            writer.write(customer.name);

            writer.write(" "+customer.user_id);

            writer.newLine();
        }

        //Closing the resources

        reader.close();
        writer.close();
    }
}