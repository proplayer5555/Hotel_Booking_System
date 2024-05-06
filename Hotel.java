package afrikaniki;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    
    private ArrayList <Reservation> Hotel_Bookings= new ArrayList<>();
    private String  hotel_name;
/*Κάνουμε τους constructors με ορίσματα και χωρίς ορίσματα.*/   
    public Hotel ()
    {
        hotel_name = "";
    }
    public Hotel(ArrayList <Reservation> T,String name)
    {
        this.Hotel_Bookings=T;
        this.hotel_name=name;
    }
/*Συνάρτηση που βάζουμε κράτηση.*/    
    public void addReservation( Reservation r)
    {
        Hotel_Bookings.add(r);   
    }
/*Συνάρτηση που βρίσκει τις επιβεβαιωμένες κρατήσεις και εμφανίζει τα στοιχεία τους.*/    
    public void findConfirmedReservation() 
    {
        Reservation c1=new Reservation();
        int i=0;
        for(i=0;i<Hotel_Bookings.size();i++)
        {
            c1=Hotel_Bookings.get(i);
        
            if(c1.getConfirmed())
            {
                System.out.println("Ta stoixeia twn epivevaiomenwn kratisewn einai:"+c1);
            }
        }
    }
    
/*Συνάρτηση που βρίσκει την κράτηση ανάλογα το όνομα του πελάτη που δίνει ο χρήστης.*/
    public Reservation findReservation(String name) 
    {
        
        Reservation c1=new Reservation();
        
        for(int i=0;i<Hotel_Bookings.size();i++)
        {
            c1=Hotel_Bookings.get(i);
            if(c1.getClient().equals(name))
            {
                return c1 ;
            }
        }
        Reservation c2 = new Reservation (c1.getArrival(),c1.getDuration(),"ERROR",c1.getCost(),c1.getConfirmed());
        System.out.println("ERROR CLIENT WASN'T FOUND ");
        return c2 ;
    }
/*Συνάρτηση που βρίσκει τα κέρδοι του ξενοδοχείου.*/    
    public double kerdoi()
    {
        Reservation c1=new Reservation();
        
        double sum=0;
        
        for(int i=0;i<Hotel_Bookings.size();i++)
        {
            c1=Hotel_Bookings.get(i);
            if(c1.getConfirmed())
            {
               sum = sum + c1.getCost();
            }
            else
            {
                sum=sum;
            }
        }
        return sum;
    }
/*Η συνάρτηση toString για να εκτυπώνουμε τα στοιχεία των ξενοδοχείων.*/    
    public String toString ()
    {
        return("To onoma tou Hotel einai "+hotel_name+" kai oi kratiseis einai oi eksis "+this.Hotel_Bookings);
    }
    public ArrayList getHotel ()
    {
        return (this.Hotel_Bookings);
    }
  
}
