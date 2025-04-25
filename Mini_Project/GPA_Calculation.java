
package Mini_Project;

public class GPA_Calculation 
{
    private String semester = new String();
    private String subcode = new String();
    private String subname = new String();
    private int credhr = 0, marks = 0, totalhrs = 0
            ,gradepts = 0, crdpts = 0, cumpts = 0, lowest_mark = 0;
    private String grade = new String();
    private double gpa = 0.0;
    private String acdmstat = new String();
    
    
    public GPA_Calculation()
    {
        this.semester = " ";
        this.subcode = " ";
        this.subname = " ";
        this.marks = 0;
        this.grade = " ";
        this.gradepts = 0;
        this.credhr = 0;
        this.crdpts = 0;
        this.totalhrs = 0;
        this.cumpts = 0;
        this.gpa = 0.0;
        this.acdmstat = " ";
        this.lowest_mark = 0;
    }
    
    public String getSemester(String semester)
    {
        this.semester = semester;
        if(this.semester.equalsIgnoreCase("Semester 1"))
        {
            this.semester = "Semester 1 2022/2023";
        }
        else if(this.semester.equalsIgnoreCase("Semester 2"))
        {
            this.semester = "Semester 2 2022/2023";
        }
        else if(this.semester.equalsIgnoreCase("Special Sem"))
        {
            this.semester = "Special Sem 2022/2023";
        }
        return this.semester;
    }
    
    public String getSubjectName(String subject_code)
    {
        this.subcode = subject_code;
        if (this.subcode.equalsIgnoreCase("CCSB2113"))
        {
            this.subname = "Cyber Security Essentials";
        }
        else if (this.subcode.equalsIgnoreCase("CISB3433"))
        {
            this.subname ="IS Project Management";
        }
        else if(this.subcode.equalsIgnoreCase("CISB4233"))
        {
            this.subname = "Business Analytics";
        }
        else if(this.subcode.equalsIgnoreCase("CISB4413"))
        {
            this.subname = "Enterprise Architecture";
        }
        else if(this.subcode.equalsIgnoreCase("CSEB4123"))
        {
            this.subname = "Web Programming";
        }
        else
        {
            this.subname = "No Subject Selected";
        }
       
        return this.subname;
    }
    
    public String getSubjectGrade(int marks)
    {
        this.marks = marks;
        
        if(this.marks >=0 && this.marks <50)
        {
            this.grade = "F";
            this.gradepts = 0;
        }
        else if(this.marks >=50 && this.marks <60)
        {
            this.grade = "D";
            this.gradepts = 1;
        }
        else if(this.marks >=60 && this.marks <70)
        {
            this.grade = "C";
            this.gradepts = 2;
        }
        else if(this.marks >=70 && this.marks <90)
        {
            this.grade = "B";
            this.gradepts = 3;
        }
        else if(this.marks >=90 && this.marks <=100)
        {
            this.grade = "A";
            this.gradepts = 4;
        }
        else
        {
            this.grade = "Invalid";
        }
        return this.grade;
    }
   
    
    public int calculateCreditPoints(int credit_hour)
    {
        this.credhr = credit_hour;
        this.crdpts = this.credhr * this.gradepts;
        return this.crdpts;
    }
    
    
    public void calculateTotalCreditHour(int credit_hour)
    {
        this.credhr = credit_hour;
        this.totalhrs = this.totalhrs + this.credhr;
    }
    
    public int getTotalCreditHour()
    {
        return this.totalhrs;
    }
    
    public void resetTotalCreditHour()
    {
        this.totalhrs = 0;
    }
    
    public void calculateCummulativeCredPts(int credit_points)
    {
        this.crdpts = credit_points;
        this.cumpts = this.cumpts + this.crdpts;
    }
    
    public int getCummulativeCredPts()
    {
        return this.cumpts;
    }
    
    public void resetCummulativeCredPts()
    {
        this.cumpts = 0;
    }
    
    public double calculateGPA(int total_chrs, int cum_cpts)
    {
        this.totalhrs = total_chrs;
        this.cumpts = cum_cpts;
        this.gpa = (double)this.cumpts/this.totalhrs;
        return this.gpa;
    }
    
    public String getAcademicStatus(double gpa)
    {
        this.gpa = gpa;
        if(this.gpa>=3.5)
        {
            this.acdmstat = "Dean's List";
        }
        else if (this.gpa>=3 && this.gpa<3.5)
        {
            this.acdmstat = "Good Standing";
        }
        else if (this.gpa>=2.5 && this.gpa<3)
        {
            this.acdmstat = "Satisfactory";
        }
        else if (this.gpa>=2 && this.gpa<2.5)
        {
            this.acdmstat = "Average";
        }
        else if(this.gpa>=0 && this.gpa<2)
        {
            this.acdmstat = "Poor";
        }
        else
        {
            this.acdmstat = "No Status";
        }
        return this.acdmstat;
    }
    
    public void setInitialLowestmark(int marks)
    {
        this.lowest_mark = marks;
    }
    
    public void setLowestMarks(int marks)
    {
        this.marks = marks;
        if(this.marks < this.lowest_mark)
        {
            this.lowest_mark = this.marks;
        }
    }
    
    public int getLowestMarks()
    {
        return this.lowest_mark;
    }
}
