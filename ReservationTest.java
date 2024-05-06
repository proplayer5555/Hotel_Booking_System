package afrikaniki;

import java.util.Scanner;
import java.util.ArrayList;

public class ReservationTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
/*Θα φτιάξουμε ένα πρόγραμμα που θα διαχειρίζεται τις κρατήσεις ξενοδοχείων.*/        
        Scanner scan = new Scanner (System.in);
        int count,days=0,month=0,year=0,duration,flag=0,count2,days2=0,month2=0,year2=0,i,d,flag2,j,FLAG1=0,FLAG2=0,Tflag=0,o,v;
        String client,client2 ;
        double cost=0,a,b,c,f,min1=0,min2=0,teliko=0;
        double price; // gia na ypologisei ta extra lefta
        boolean confirmed,pay ;
/*Αρχικοποιούμε τα δεδομένα μας πρώτα σε αντικείμενα date μετά σε reservation μετά σε λίστες και τέλος σε αντικείμενα hotel.*/       
        Date d1=new Date(1,7,2020);
        Date d2=new Date(11,7,2020);
        Date d3=new Date(4,7,2020);
        Date d4=new Date(3,7,2020);
        Date d5=new Date(21,7,2020);
        Date d6=new Date(28,7,2020);
        Date d7=new Date(6,7,2020);
        Date d8=new Date(17,7,2020);
        Date d9=new Date(31,7,2020);
        
        Reservation R1 = new Reservation (d1,5,"PAPPAS",650.6,true);
        Reservation R2 = new Reservation (d2,3,"MPIMPI",523.5,true);
        Reservation R3 = new Reservation (d3,12,"PETROY",2123,false);
        Reservation R4 = new Reservation (d4,8,"KOSTIS",800,true);
        Reservation R5 = new Reservation (d5,16,"PALLAS",726.5,true);
        Reservation R6 = new Reservation (d6,11,"KONTAKI",3000,true);
        Reservation R7 = new Reservation (d7,2,"VOURAS",189.5,false);
        Reservation R8 = new Reservation (d8,1,"MPOZINIS",200,true);
        Reservation R9 = new Reservation (d9,4,"VIRVOU",512,false);
        ArrayList <Reservation> copyTita = new ArrayList <> ();
        ArrayList <Reservation> copyErmis = new ArrayList <> ();
        
        copyTita.add(R1);
        copyTita.add(R3);
        copyTita.add(R4);
        copyTita.add(R5);
        copyTita.add(R7);
        copyTita.add(R9);
        
        copyErmis.add(R2);
        copyErmis.add(R6);
        copyErmis.add(R8);
        
        Hotel Tita = new Hotel(copyTita,"Titania");
        Hotel Ermis = new Hotel(copyErmis,"Ermis");
/*Ζητάμε από τον χρήστη να δώσει σε ποιο ξενοδοχείο θέλει να είναι.*/        
        do
        {
            System.out.println("Dose 1 ean thelis to Titania Hotel h 2 gia to Ermis ");
            flag=scan.nextInt();
        }while((flag!=1)&&(flag!=2));
                    
        do
        {
            printMenu();
            count=scan.nextInt();
            switch (count) 
            {
/*Κάνουμε το switch case του μενού και κάνουμε αυτά που λέει στο κάθε βήμα να κάνει η λογική για να γράφουμε στις λίστες
 και να αποθηκέουμε τα δεδομένα είναι η ίδια σε κάθε περίπτωση.*/                
               case 1:
                    System.out.println("Dose tis Hmerominies tis kratisis sou");
                    System.out.println("Days :");
                    days=scan.nextInt();
                    System.out.println("Month :");
                    month=scan.nextInt();
                    System.out.println("Year :");
                    year=scan.nextInt();
                    Date extra = new Date(days,month,year);
                    do
                    {
                        System.out.println("Dose poses meres tha katsis ");
                        duration=scan.nextInt();    
                    }while(duration<=0);
                    System.out.println("Dose to onoma tou pelati ");
                    client=scan.next();
                    do
                    {
                        System.out.println("Dose to kostos ");
                        cost=scan.nextDouble();
                    }while(cost<=0);
                    System.out.println("Dose true an exeis plirosei allios false");
                    confirmed = scan.nextBoolean();
                    Reservation Extra = new Reservation (extra,duration,client,cost,confirmed);
                    if(flag==1)
                    {
                        Tita.addReservation(Extra);
                    }
                    if(flag==2)
                    {
                        Ermis.addReservation(Extra);
                    }
                    System.out.println(Extra);
                    break;
                case 2:
                    System.out.println("Dose to onoma tou Client pou thelis na kaneis allages");
                    client2=scan.next(); // To onoma tou pelati pou tha kanei allagi 
                    Reservation c1 = new Reservation ();//apothikeuei tin thesi pou briskete o pelatis sto arraylist
                    if(flag==1)
                    {
                        c1=Tita.findReservation(client2);
                    }
                    if(flag==2)
                    {
                        c1=Ermis.findReservation(client2);
                    }
                    if(c1.getClient().equals("ERROR"))
                    {
                        break;
                    }
                    do//Deytero Menu
/*Κάνουμε ένα δεύτερο μενού για να είναι ποιο ελκυστικό στον χρήστη.*/                    	
                    {
                        System.out.println("===================");
                        System.out.println("Dose 1 gia na allaksis tin imerominia kratisiS.");
                        System.out.println("Dose 2 gia na allaksis poses meres tha katsis.");
                        System.out.println("Dose 3 an thelis na allaksis Hotel.");
                        System.out.println("Dose 4 an thelis na allaksis to status pliromhs.");
                        System.out.println("Dose 0 gia exit.");
                        System.out.println("===================");
                        count2=scan.nextInt();
                        
                        switch(count2)//Deytero case
                        {
                            case 1 ://Zitaei tin nea hmerominia apo ton xristi 
                                System.out.println("Dose tis nees Hmerominies.");
                                System.out.println("Days :");
                                days2=scan.nextInt();
                                System.out.println("Month :");
                                month2=scan.nextInt();
                                System.out.println("Year :");
                                year2=scan.nextInt();
                                Date New_date = new Date (days2,month2,year2);
                                Reservation c2 = new Reservation (New_date,c1.getDuration(),c1.getClient(),c1.getCost(),c1.getConfirmed());
                                ArrayList <Reservation> No = new ArrayList <> ();
                                if(flag==1)
                                {
                                    No=Tita.getHotel();
                                    i=No.indexOf(c1);
                                    No.remove(i);
                                    No.add(c2);
                                    Hotel Tita2 = new Hotel (No,"Titania");
                                    Tita=Tita2;
                                }
                                else if (flag==2)
                                {
                                    No=Ermis.getHotel();
                                    i=No.indexOf(c1);
                                    No.remove(i);
                                    No.add(c2);
                                    Hotel Ermis2 = new Hotel (No,"Ermis");
                                    Ermis=Ermis2;
                                }
                                break;
                                
                            case 2 ://Zitaei poses meres theli na katsi akoma o xristis         
                                do
                                {
                                    System.out.println("Dose poses meres thelis na katsis akoma.");
                                    d=scan.nextInt();
                                }while(d<=0);
                                Reservation lion = new Reservation ();
                                ArrayList <Reservation> Manolis  = new ArrayList<> ();
                                if(flag==1)
                                {
                                    lion=Tita.findReservation(client2);
                                    price=lion.price()*(c1.getDuration()+d);
                                    Reservation Spiros = new Reservation(lion.getArrival(),d,lion.getClient(),price,lion.getConfirmed());
                                    Manolis=Tita.getHotel();
                                    i=Manolis.indexOf(lion);
                                    Manolis.remove(i);
                                    Manolis.add(Spiros);
                                    Hotel Tita3 = new Hotel (Manolis,"Titania");
                                    Tita=Tita3;
                                }
                                else if(flag==2)
                                {
                                    lion=Ermis.findReservation(client2);
                                    price=lion.price()*(c1.getDuration()+d);
                                    Reservation Spiros = new Reservation(lion.getArrival(),d,lion.getClient(),price,lion.getConfirmed());
                                    Manolis=Ermis.getHotel();
                                    i=Manolis.indexOf(lion);
                                    Manolis.remove(i);
                                    Manolis.add(Spiros);
                                    Hotel Ermis3 = new Hotel (Manolis,"Ermis");
                                    Ermis=Ermis3;
                                }
                                break;
                            case 3 : // allazei ksenodoxeio
                                
                                    do
                                    {
                                        System.out.println("Dose 1 ean thelis to Titania Hotel h 2 gia to Ermis ");
                                        flag2=scan.nextInt();
                                    }while((flag2!=1)&&(flag2!=2));
                                    if(flag2==flag)
                                    {
                                        System.out.println("ERROR! H ALLAGH DEN GINETAI");
                                    }
                                    else
                                    {
                                        if(flag2==1)
                                        {
                                            Reservation Giwrgos = new Reservation (c1.getArrival(),c1.getDuration(),c1.getClient(),c1.getCost(),c1.getConfirmed());
                                            ArrayList <Reservation> Thomas = new ArrayList <> ();
                                            Thomas=Ermis.getHotel();
                                            j=Thomas.indexOf(c1);
                                            Thomas.remove(j);
                                            Hotel lol = new Hotel (Thomas,"Ermis");
                                            Ermis=lol;
                                            Tita.addReservation(Giwrgos);
                                        }
                                        else if(flag2==2)
                                        {
                                            Reservation Giwrgos = new Reservation (c1.getArrival(),c1.getDuration(),c1.getClient(),c1.getCost(),c1.getConfirmed());
                                            ArrayList <Reservation> Thomas = new ArrayList <> ();
                                            Thomas=Tita.getHotel();
                                            j=Thomas.indexOf(c1);
                                            Thomas.remove(j);
                                            Hotel lol = new Hotel (Thomas,"Titania");
                                            Tita=lol;
                                            Ermis.addReservation(Giwrgos);                                            
                                        }
                                    }
                                    break;
                            case 4 : //allazei to status pliromis 
                                   System.out.println("Dose true ean exeis plirosei h false ean den exeis plirosei");
                                   pay=scan.nextBoolean();
                                   Reservation apex = new Reservation (c1.getArrival(),c1.getDuration(),c1.getClient(),c1.getCost(),pay);
                                   ArrayList <Reservation> lol2 = new ArrayList <> ();
                                   if(flag==1)
                                   {
                                       lol2=Tita.getHotel();
                                       j=lol2.indexOf(c1);
                                       lol2.remove(j);
                                       lol2.add(apex);
                                       Hotel kati = new Hotel(lol2,"Titania");
                                       Tita=kati;
                                   }
                                   else if (flag==2)
                                   {
                                       lol2=Ermis.getHotel();
                                       j=lol2.indexOf(c1);
                                       lol2.remove(j);
                                       lol2.add(apex);
                                       Hotel kati = new Hotel(lol2,"Ermis");
                                       Ermis=kati;
                                   }
                                   break;
                        }
                    }while(count2!=0);
                    break;
                case 3:             
/*Εκτυπώνουμε τα στοιχεία των επιβεβαιωμένων κρατήσεων ανάλογα το ξενοδοχείο που επιλέγει ο χρήστης.*/                  
                	if (flag==1)
                    {
                        Tita.findConfirmedReservation();
                    }
                    else if (flag==2)
                    {
                        Ermis.findConfirmedReservation();
                    }
                    break;
/*Εκτύπωση στοιχείων κράτησεις ανάλογα με το όνομα που θα δώσει ο χρήστης.*/         
                case 4:
                    System.out.println("Dose to onoma tou Client pou thelis na deis ta stoixeia");
                    client2=scan.next();
                    Reservation c2 = new Reservation ();                    
                    if(flag==1)
                    {
                        c2=Tita.findReservation(client2);
                        System.out.println(c2);
                    }
                    else if (flag==2)
                    {
                        c2=Ermis.findReservation(client2);
                        System.out.println(c2);
                    }
                    break;
            }        
        }while(count!=0);//Telos tou megalou menu
/*Εκτυπώνουμε τα κέρδοι κάθε ξενοδοχείου και βρίσκουμε ποια είναι η κράτηση με την ποιο συμφέρουσα τιμή.*/        
        a=Tita.kerdoi();
        b=Ermis.kerdoi();
        System.out.println("Ta kerdi tou Titania einai "+a+" \n Ta kerdi tou Ermis einai "+b);
        ArrayList <Reservation> copy2 = new ArrayList <> ();
        copy2=Tita.getHotel();
        ArrayList <Reservation> copy3 = new ArrayList <> ();
        copy3=Ermis.getHotel();
        for(int z=0;z<copy2.size();z++)
        {
            if(z==0) min1=copy2.get(z).price();
            
            if(copy2.get(z).price()<min1)
            {
                min1=copy2.get(z).price();
                FLAG1=z;
            }
        }
        for(int l=0;l<copy3.size();l++)
        {
            if(l==0) min2=copy3.get(l).price();
            
            if(copy3.get(l).price()<min2)
            {
                min2=copy3.get(l).price();
                FLAG2=l;
            }
        }
        if(min1<min2)
        {
            teliko=min1;
            Tflag=FLAG1;
            System.out.println("H kratisi me tin kaliteri timi einai "+copy2.get(Tflag).toString()+" kai i timi ana bradia einai "+min1);
        }
        else 
        {
            teliko=min2;
            Tflag=FLAG2;
            System.out.println("H kratisi me tin kaliteri timi einai "+copy3.get(Tflag).toString()+" kai i timi ana bradia einai "+min2);
        }
/*Εμφανίζουμε τα στοιχεία των κρατήσεων που έχουν χρονική επικάλυψη με δύο for την μια εμφολευμένη μέσα στην άλλη.*/     
        System.out.println("Oi epikalipsis pou emfanizontai sto Titania einai oi eksis");
        ArrayList <Reservation> Jojo = new ArrayList <> ();
        Reservation Kira = new Reservation();
        Reservation Giorno = new Reservation ();
        Jojo=Tita.getHotel();
        for(o=0;o<Jojo.size();o++)
        {
            Kira=Jojo.get(o);
            for(v=0;v<Jojo.size();v++)
            {
                Giorno = Jojo.get(v);
                if(Kira.EPIK(Giorno)&&o!=v)
                {
                    System.out.println("O\t"+Kira+"\tExei xroniki epikalipsi me ton\n"+Giorno);
                }
            }
        }
        
    }
/*Κάνουμε την συνάρτηση που έχει τα στοιχεία για το μενού.*/ 
    private static void printMenu() 
    {
        System.out.println("--------------");
        System.out.println(" Menu ");
        System.out.println("--------------");
        System.out.println("1. Add Reservation");
        System.out.println("2. Change Reservation");
        System.out.println("3. Print all confirmed Reservations");
        System.out.println("4. Search Reservation using last name");
        System.out.println("0. Exit");
        System.out.print("Please give a choice (0,1,2,3 or 4):");
    }
}

