package afrikaniki;

public class Reservation {
    
    private Date arrival_date = new Date () ;
    private int duration ;
    private String client ;
    private double cost ;
    private boolean confirmed ;
/*���������� ���� constructors �� �������� ��� ����� ��������.*/    
    public Reservation ()
    {
        duration =0;
        client ="";
        cost = 0;
        confirmed = false ;
    }
    
    public Reservation (Date arrival, int duration, String client, double cost, boolean confirmed)
    {
        arrival_date=arrival;
        this.duration=duration;
        this.client=client;
        this.cost=cost;
        this.confirmed=confirmed;
    }
/*����������� ��� ����������� ��� �� ��������.*/  
    public Date getArrival ()
    {
        return(this.arrival_date);
    }
    public int getDuration ()
    {
        return (this.duration);
    }
    public String getClient ()
    {
        return (this.client);
    }
    public double getCost ()
    {
        return (this.cost);
    }
    public boolean getConfirmed ()
    {
        return(this.confirmed);
    }
/*��������� ��� ���������� ��� ����/������� ��������*/   
    public double price ()
    {
        double x;
        x=(this.cost/this.duration);
        return (x);
    }
    public Date Hmerominia ()//ypologizei tin hmerominia anaxorisis
    {
        Date day = new Date ();
        day=this.arrival_date.findDate(this.duration);
        return(day);
    }
/*� ��������� ���� ��������� �� �������� ��� ��������.*/    
    public String toString ()
    {
        Reservation R = new Reservation (this.arrival_date,this.duration,this.client,this.cost,this.confirmed);
        Date day = new Date () ;
        day=R.Hmerominia();
        return ("Arrival Date "+arrival_date.getDay()+"/"+arrival_date.getMonth()+"/"+arrival_date.getYear()+" CLIENT "+this.client+" COST "+this.cost+" PAYED "+this.confirmed+" DURATION "+this.duration+" LEAVING DAY "+day.getDay()+"/"+day.getMonth()+"/"+day.getYear());
    }
/*� ��������� ���� ��������� ��� ������� ������� ��������� ������� �� ��� ���������.*/    
    public boolean EPIK (Reservation B)
    {
        Reservation R = new Reservation (this.arrival_date,this.duration,this.client,this.cost,this.confirmed);
        Date first = new Date ();
        Date second = new Date ();
        first = R.Hmerominia();
        second = B.Hmerominia();
        int i,j,x,z,p;
        Date first_array [] = new Date [this.duration] ;
        for(i=0;i<this.duration;i++)
        {
            Reservation SAMPLE = new Reservation (this.arrival_date,i,this.client,this.cost,this.confirmed);
            first_array [i] = SAMPLE.Hmerominia();
        }
        Date second_array [] = new Date [B.duration];
        for(p=0;p<B.duration;p++)
        {
            Reservation SAMPLE = new Reservation (B.arrival_date,p,B.client,B.cost,B.confirmed);
            second_array [p]= SAMPLE.Hmerominia();
        }
        for(i=0,j=this.duration;i<j;i++)
        {
            for(x=0,z=B.duration;x<z;x++)
            {
                if((first_array[i].getDay()==second_array[x].getDay())&&(first_array[i].getMonth()==second_array[x].getMonth())&&(first_array[i].getYear()==second_array[x].getYear()))
                {
                    return true;
                }
            }
        } 

        return false;
    } 
    
}
