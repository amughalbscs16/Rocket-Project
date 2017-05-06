/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockets;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author amughal.bscs16seecs
 */
abstract class Rockets {
    protected boolean flight=false,checks=true;
    abstract void launch();
    protected String propellant_used;
    private double angle_of_launch;
    @Override
    public String toString(){return "This is a Rocket\n"+ "The Flight ="+ this.flight;}
    public boolean setangle(double angle)
   {
       if ( angle > 90 || angle < -90 )
       {
           System.out.println("angle can't be greater than 90 or less than -90");
           this.angle_of_launch=0;
           checks=false;
           return checks;
       }
   this.angle_of_launch=angle;
   return checks;
   }
       public boolean setpropellant(String propellant)
   {
   if ( propellant == "" )
   {
       
           System.out.println("Please Define the Propellant Used");
           checks=false;
           return checks;
   }
   propellant_used=propellant;
   return checks;
   }
   public String getpropellant()
   {
       return propellant_used;
   }
   public double getangle()
   {
       return angle_of_launch;
   }
    public void setchecks()
    {
        if (setpropellant(propellant_used) && setangle(angle_of_launch) )
        {
            this.checks=true;
        }
        
    }
    public void setflight(boolean flight)
    {
        this.flight=flight;
    }
    public boolean getflight()
    {
        return flight;
    }
    public boolean getchecks()
    {
        return checks;
    }
}
class ToyRocket extends Rockets
{
    
    private String color_of_firework;
    ToyRocket(){}
    ToyRocket(double angle,String propellant,String color)
    {
        setangle(angle); setpropellant(propellant); setcolor(color);
    }
    public void setcolor(String color)
    {
     color_of_firework=color;   
    }
    public String getcolor()
    {
        return color_of_firework;
    }
    @Override
    public void setchecks()
    {
        if (getcolor() != null && getchecks())
            checks=true;
    }
    @Override
    public void launch()
    {
        setchecks();
        if (getchecks())
        {
            setflight(true);
            System.out.println("\n" + toString());
        }
    }
    public String toString()
    {
        return super.toString() + "This is a ToyRocket \n"+"The Angle of Launch = "+getangle()+ "\n The Color of Firework is = " + getcolor();
    }
}

class AdvancedRockets extends Rockets{

   private double fuel,distance,velocity,accleration,lift_capacity;
   
   AdvancedRockets(){
   }
   AdvancedRockets(double fuel, double distance,double angle_of_launch, double velocity, double accleration, double lift_capacity, String propellant)
   {
    this.setfuel(fuel);  this.setdistance(distance); this.setangle(angle_of_launch); this.setvelocity(velocity); this.setliftcapacity(lift_capacity);
    this.setpropellant(propellant);
   }
   
   
   public boolean setfuel(double fuel)
   {
       if ( fuel < 0  )
       {
           this.fuel = 0;
           System.out.println("Distance can't be negative");
           checks=false;
           return checks;
       }
       this.fuel=fuel;
       return checks;
   }
   public boolean setdistance(double distance)
   {
       if ( distance < 0 || distance == 0 )
       {
           this.distance=0;
           System.out.println("Distance can't be negative");
           checks=false;
           return checks;
       }
       this.distance=distance;
       return checks;
   }
   public boolean setliftcapacity(double lift_capacity)
   {
       if ( lift_capacity < 0 || lift_capacity == 0 )
       {
           System.out.println("lift capacity can't be negative or zero");
           this.lift_capacity=0;
           checks=false;
           return checks;
       }
       this.lift_capacity=lift_capacity;
       return checks;
   }
   public boolean setvelocity(double velocity)
   {
       if ( lift_capacity < 0 )
       {
           System.out.println("Velocity can't be negative or zero");
           this.velocity=0;
           checks=false;
           return checks;
       }
       else
       {
       this.velocity=velocity;
       return checks;
       }
   }
    public double getvelocity()
   {
       return velocity;
   }
   
   
   public double getliftcapacity()
   {
       return lift_capacity;
   }
   
   @Override
  public void setchecks()
  {
      if (this.setfuel(fuel) &&  this.setdistance(distance) && this.setangle(getangle())&& this.setvelocity(velocity) && this.setliftcapacity(lift_capacity) &&
    this.setpropellant(propellant_used)){
      this.checks=true;
      System.out.println("The Checks are True and Flight is ready to be launched");
      }
      else this.checks=false;
              
  }
   @Override
  public void launch()
  {
      setchecks();
      if (getchecks()){
      setflight(true);
      System.out.println(toString());
      }
  }
   @Override
  public String toString()
  {
      return super.toString()+"\nAngle of Launch is = "+getangle()+"\nVelocity is ="+getvelocity()+ "\nLift Capacity is = "+getliftcapacity()+"\nThe Propellant used is "+getpropellant();
     
  }
    
}

class MultistageRockets extends AdvancedRockets
{
    private int stages;
    private double initial_mass,final_mass;
    MultistageRockets(){}
    MultistageRockets(double fuel, double distance,double angle_of_launch, double velocity, double accleration, double lift_capacity, String propellant , int stages, double initial_mass, double final_mass)
    {
        setfuel(fuel);  setdistance(distance); setangle(angle_of_launch); setvelocity(velocity); setliftcapacity(lift_capacity);
        setinitialmass(initial_mass); setfinalmass(final_mass); setpropellant(propellant);
    }

     public boolean setinitialmass(double initial_mass)
   {
       if ( initial_mass < 0 || initial_mass == 0 )
       {
           System.out.println("Initial Mass can't be negative or zero");
           this.initial_mass=0;
           checks=false;
           return checks;
       }
       this.initial_mass=initial_mass;
       return checks;
   }
   public boolean setfinalmass(double final_mass)
   {
       if ( final_mass < 0 || final_mass == 0 )
       {
           System.out.println("Final Mass can't be negative or zero");
           this.final_mass=0;
           checks=false;
           return checks;
       }
       this.final_mass=final_mass;
       return checks;
   }
   public double getinitialmass()
   {
       return initial_mass;
   }
   public double getfinalmass()
   {
       
       return final_mass;
   }
   public boolean setstages (int stages)
   {
       if ( stages < 0 )
       {
           System.out.println("Stages can't be negative or zero");
           this.stages=0;
           checks=false;
           return checks;
       }
       this.stages=stages;
       return checks;
   }
   public int getstages()
   {
       return this.stages;
   }
  
   
            
   @Override     
   public void setchecks()
  {     
      if (setinitialmass(initial_mass) && setfinalmass(final_mass) && setstages(stages))
      {
          checks=true;
      }
      super.setchecks();
  }
  
    @Override
     public String toString()
  {
      return super.toString()+"\nInitial Mass = "+getinitialmass()+"\nFinal Mass = "+getfinalmass()+"\nStages of flight = "+getstages();
     
  }
}
public class testrocket
{
    public static void main(String args[])
    {
    int choice=1,index=0;
    double fuel,distance,angle_of_launch,velocity,acceleration;
    double distance_left,distance_covered,lift_capacity,initial_mass,final_mass; String propellant,color;
    int stages;
        Scanner input = new Scanner(System.in);
        ArrayList<Rockets> rockets = new ArrayList<>();
        while (choice >0 && choice<4)  
        {
            System.out.println("You have Three Choices of Rockets\n1: ToyRocket");
            System.out.println("2: Advanced Rocket\n3: Multi Stage Rockets");
            System.out.println("Enter the Rocket number you want to make (for Ending enter Anyother number)");
            choice=0;
            choice = input.nextInt();
            switch (choice){
                case 1:
                System.out.println("Enter the angle of projection"); angle_of_launch=input.nextDouble();
                System.out.println("Enter the Propellant used"); propellant=input.next();
                System.out.println("Enter the Color of FireWork"); color=input.next();
                rockets.add(new ToyRocket(angle_of_launch, propellant, color)); 
                rockets.get(index).launch();
                break;
                case 2:
                    System.out.println("Enter the angle of projection"); angle_of_launch=input.nextDouble();
                    System.out.println("Enter the Fuel"); fuel=input.nextDouble();
                System.out.println("Enter the Propellant used"); propellant=input.next();
                System.out.println("Enter the Velocity"); velocity=input.nextDouble();
                System.out.println("Enter the Acceleration"); acceleration=input.nextDouble();
                System.out.println("Enter the Distance for Rocket"); distance=input.nextDouble();
                System.out.println("Enter the lift Capacity of Rocket"); lift_capacity=input.nextDouble();
                rockets.add(new AdvancedRockets(fuel,distance,angle_of_launch, velocity,  acceleration, lift_capacity, propellant));
                rockets.get(index).launch();
                break;
                case 3:
                    System.out.println("Enter the angle of projection"); angle_of_launch=input.nextDouble();
                    System.out.println("Enter the Fuel"); fuel=input.nextDouble();
                System.out.println("Enter the Propellant used"); propellant=input.next();
                System.out.println("Enter the Velocity"); velocity=input.nextDouble();
                System.out.println("Enter the Acceleration"); acceleration=input.nextDouble();
                System.out.println("Enter the Distance for Rocket"); distance=input.nextDouble();
                System.out.println("Enter the lift Capacity of Rocket"); lift_capacity=input.nextDouble();
                System.out.println("Enter the stages"); stages=input.nextInt();
                System.out.println("Enter the Initial Mass"); initial_mass=input.nextDouble();
                System.out.println("Enter the Final Mass"); final_mass=input.nextDouble();
                 rockets.add(new MultistageRockets(fuel, distance, angle_of_launch, velocity, acceleration, lift_capacity, propellant , stages, initial_mass, final_mass));
                 rockets.get(index).launch();
                 break;

                    }
            if (choice>0 && choice<4)
            {
            index++;
            System.out.println("A New Rocket is Added." + " Total Rockets = "+ index +"\n" );
            }
            else
                System.out.println("Thanks for Making Rockets Total Rockets Made = " + index);
        }
    

}

}
