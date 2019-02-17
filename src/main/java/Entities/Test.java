package Entities;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

class Test
{
    public static void main(String[] args)
    {
//        Demo object = new Demo(1, "geeksforgeeks");
        String filename = "file.ser";


        //Oh boy lets make a complete form
        List<BrewersPermit> Brews = new ArrayList<>();
        Brews.add(new BrewersPermit("123ABC", true));
        Brews.add(new BrewersPermit("456DEF", false));

        List<Address> Adds = new ArrayList<>();
        Adds.add(new Address("Worcester", "MA", "01609", "100 Institue Road", "John Smith", true));
        Adds.add(new Address("Acton", "MA", "123456", "2 Street Ave", "Bob Dijon", false));

        long milli = System.currentTimeMillis();
        Date d = new Date(milli);

        Form form = new Form(null, Brews, true, "00123SE", AlcoholType.MaltBeverage,
                "Bubbly", "BU", Adds, "John Smith", null, null,
                "1112223333", "john@johnmail.com", "No other info", d, 123,
                new Approval(), (float)12.3, ApprovalStatus.Incomplete);
        form.setWorkingOn(0);



        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(form);

            out.close();
            file.close();

            System.out.println("form has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }


        Form object1 = null;

        // Deserialization
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (Form)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("BrandName = " + object1.getBrandName());
            System.out.println("fancyName = " + object1.getFancifulName());
            System.out.println("Approval = " + object1.getApprovalStatus());
            System.out.println("Email = " + object1.getEmail());
            System.out.println("Add1 City = " + object1.getAddress().get(0).getCity());

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

    }
}