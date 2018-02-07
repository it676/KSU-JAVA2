package arrayOfObjects;


public class Student {
    
    //instance variables
    private long id;
    private String name;
    private double gpa;
    
    
    //Constructors
    
    public Student(long id  , String name ,double gpa ){
        
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        
    }
    
    //empty  no-argument constructor
    public Student(){
      name="";
    }
    
    
    public Student(Student  std){
        
        this.id= std.getId();
        this.name=std.getName();
        this.gpa=std.getGpa();
        
    }
    
  
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    
    public void setStudent(Student  std){
        
        
        this.id=std.getId();
        this.name=std.getName();
        this.gpa=std.getGpa();
    }
    
    
    
    
   @Override
    public String  toString(){
        
        return String.format("ID:%d\tName :%s\tGPA:%.2f", getId(),getName(),getGpa());
    }
    
}
