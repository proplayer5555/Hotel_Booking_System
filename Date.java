package afrikaniki;

import java.util.Scanner;

public class Date {
    
    private int day ;
    private int month ;
    private int year ;
    
    public Date()
    {
        this.day=0;
        this.month=0;
        this.year=0;
        
    }
/*Ελέγχουμε μέσα στον constructor μέσω της checkdate για αν οι ημερομηνίες είναι σωστές και εμφανίζουμε ένα μήνυμα για ξέρει ο χρήστης.*/    
    public Date (int day,int month, int year)
    {
        if(checkDate(day,month,year))
        {
            System.out.println("SOSTES HMEROMINIES!!");
            this.day=day;
            this.month=month;
            this.year=year;
        }
        else
        {
            System.out.println("ERROR LATHOS HMEROMINIES!!");
            
            this.day=0;
            this.month=0;
            this.year=0;
        }
    } 
/*Η συνάρτηση αυτή ελέγχει αν οι ημερομηνίες είναι σωστές ή όχι.*/   
    public boolean checkDate(int day, int month, int year)
    {
        
        if(year>0)
        {    
            if ((month>=1)&&(month<=12))
            {
                if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12))
                {
                    if ((day>=1)&&(day<=31))
                    {
                        return true ;
                    }
                    else 
                    {
                        return false ;
                    }
                }
                else if((month==4)||(month==6)||(month==9)||(month==11))
                {
                    if ((day>=1)&&(day<=30))
                    {
                        return true ;
                    }
                    else
                    {
                        return false ;
                    }
                }
                else if((month==2) && (day>=1 && day<=28))
                {
                    return true ;
                }
                else if (month==2 && day==29 && (year%400==0 || (year%4==0 && year%100!=0)))
                {
                    return true ;
                }
                else 
                {
                    return false ;
                }
            }
            
            else 
            {
                return false ;    
            }
        }
       
        else 
        {
            return false ;
        }
    }
/*Συναρτήσεις για να βάζει ο χρήστης την μέρα τον μήνα και τον χρόνο.*/   
    public void setDay ()
    {
        int x;
        System.out.println("Dose tin HMERA pou thelis ");
        Scanner scan = new Scanner (System.in);
        x=scan.nextInt();
        this.day=x;
    }
    
    public void setMonth ()
    {
        Scanner scan = new Scanner (System.in);
        int x;
        System.out.println("Dose ton MHNA pou thelis ");
        x=scan.nextInt();
        this.month=x;
    }
    
    public void setYear ()
    {
        Scanner scan = new Scanner (System.in);
        int x;
        System.out.println("Dose to ETOS pou thelis ");
        x=scan.nextInt();
        this.year=x;
    }
    /*Επιστρέφει την μέρα η επόμενη τον μήνα και η άλλη τον χρόνο.*/      
    public int getDay()
    {
        return(this.day);
    }
    
    public int getMonth()
    {
        return(this.month);
    }
    
    public int getYear ()
    {
        return(this.year);
    }
/*Η συνάρτηση αυτή προσθέτει d μέρες στην ημερομηνία που έχουμε.*/   
    public Date findDate(int d)
    {
        Date mera = new Date ();
        
        
        int count=0,i=0,countYear=0,year,month,day,extra;
        int days [] = new int [12];
        days[0]=31;
        days[1]=29;
        days[2]=31;
        days[3]=30;
        days[4]=31;
        days[5]=30;
        days[6]=31;
        days[7]=31;
        days[8]=30;
        days[9]=31;
        days[10]=30;
        days[11]=31;
        
        year=this.year;
        month=this.month;
        day=this.day+d;
        i=month-1;
        extra=year;
        do
        {
        	
        	    if((extra%400==0 || (extra%4==0 && extra%100!=0)))
                {
                   days[1]=29;
                }
        	    else 
                {
                   days[1]=28; 
                }
           	
        	    if(day>days[i])
                {
                    count=1;
                    day=day-days[i];
                    i++;
                }
                else if (day<=days[i])
                {
                    count=2;
                    
                }
                if(i>11)
                {
                    i=0;
                    extra+=1;
                     
               }
                      
        		
        }while(count!=2);
        
        year=extra;
        month=i+1;
        
        mera.day=day;
        mera.month=month;
        mera.year=year;
        return (mera);
        			
    }
        
    }