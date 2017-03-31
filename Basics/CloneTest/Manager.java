
public class Manager extends Employee
{
   private double bonus;

   /**
    * @param n the employee's name
    * @param s the salary
    * @param year the hire year
    * @param month the hire month
    * @param day the hire day
    */
   public Manager(String n, double s, int year, int month, int day)
   {
      super(n, s);
      bonus = 0;
   }

   public Manager clone() throws CloneNotSupportedException
   {
      // call Object.clone()
      Manager cloned = (Manager) super.clone();

      return cloned;
   }
   
   
   public double getSalary()
   {
      double baseSalary = super.getSalary();
      return baseSalary + bonus;
   }

   public void setBonus(double b)
   {
      bonus = b;
   }
}

