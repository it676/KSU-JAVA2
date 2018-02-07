package arrayOfObjects;



public class Section {
    
    
    //instance variables
    private String code; //A1290
    private Student[] students;
    private int  studentsCounter;
    
    //const
    public Section(String  code  , int size){
        
        this.code=code;
        students = new Student[size];
        studentsCounter=0;
    }
    
    public Section(String code  ,Student[] studentsList ){
        
        this.code=code;
        
        
        //creation of the arrray  , get the length from the passed array
        students= new Student[studentsList.length];
        
        
        
        //copy 
        
        for (int i = 0; i <studentsList.length; i++) {
            
            if(studentsList[i]==null)
                break;

            students[i]= new Student(studentsList[i]);
            
                studentsCounter++;
            
        }
        
        
      
    }
    
  
    public boolean  addStudent(Student  std){
       
        if(studentsCounter==students.length)
            return false;
       
        students[studentsCounter]=std;//make the pointer at the index pointing to the student object
        studentsCounter++;//update the counter
        
        return true;
        
    }
    
    
    public int  numberOfStudents(){
        
        return studentsCounter;
    }
    
    
     public int  capacity(){
        
        return students.length;
    }
    
    
    public  boolean isFull(){
        
     return (studentsCounter == students.length);
            
    }
    
    public int  searchStudent(long id){
        
        for (int i = 0; i <studentsCounter; i++) {
            
            if(id ==  students[i].getId())
                return i;
        }
        
        return -1;
    }
    
    
    public Student  remove(long  id){
        
        //index of the object to remvoe
        int  index= searchStudent(id);
        
        //check if the index is found or not
        
        if(index==-1)
            return null;

        Student  std= students[index];
        
        //remove by shifting 
        
        for(int i = index;   i<studentsCounter-1 ; i++){
            students[i]=students[i+1];
            
        }
         students[--studentsCounter]=null;
         
         
         return std;
        
    }
    
    
   public  Student  getStudent(long id){
       
        int index = searchStudent(id);
        
        if(index==-1)
            return null;
                
        Student  s = students[index];
       
        return s;

   }
    
   
   
   
   public  void  setSectionStudents(Student[] studentsList){
       
       for (int i = 0; i < (studentsList.length) && (i<students.length); i++) {
          
           
           if(studentsList[i]!=null){
               
           students[i]=new Student();
           
           students[i].setStudent(studentsList[i]);
           
           studentsCounter++;
           }
           
          
       }
       
       
   }
   
   
   public  Student  getBestStudent(){
       
       
       Student best=students[0];
       
       
       for (int i = 1; i <studentsCounter; i++) {
           
            if(students[i].getGpa() > best.getGpa() ){
                
                best = students[i];
                
            }
       }
       
       return best;
   }
   
   
   public  boolean searchStudentByName(String name){
       
       
       for (int i = 0; i < studentsCounter; i++) {
           
           if(students[i].getName().equals(name))
               return true;
       }
       
       return false;
   }
   
   
   
   public int  findStudent(Student  std){
       
       
       for (int i = 0; i <studentsCounter; i++) {
           
           
           if(students[i].getName().equals(std.getName()))
               if(students[i].getId()==std.getId())
                   if(students[i].getGpa()==std.getGpa())
                       return i;
       }
      
       
       return -1;
   }
   
   
   public double  getAverageGpa(){
        
       
       double total=0.0;
       
        for (int i = 0; i <studentsCounter; i++) {
            
            
           total+=students[i].getGpa();
            
        }
        
        
        return  (total/studentsCounter);
        
        
    }
   
   
   
   @Override
   public String toString(){
      
       String str="Code Section is :"+code+"\n";
       
       for (int i = 0; i <studentsCounter; i++) {
           
             str+=students[1].toString()+"\n";
       }
       
       return str;
       
   }
   
   
}
