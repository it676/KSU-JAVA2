package arrayOfObjects;


public class SMS {
    
    
    
    public static void main(String[] args) {
        
        Student[] list = new Student[100];
        
        
        list[0]=new Student(11,"Sara",4.99);

        
      list[1]=new Student(22,"Abeer",4.98);
      
      
      list[2]=new Student(33,"Maram",5.0);

        
        Section  sec = new Section("A1020" , 50);
        
       
        sec.setSectionStudents(list);
        
        
        System.out.println(sec.getBestStudent());
        
        
}
    
}
