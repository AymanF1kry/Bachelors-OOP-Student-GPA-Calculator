package Mini_Project;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringJoiner;
import javax.swing.JOptionPane;


public class GPA_Calculator extends javax.swing.JFrame {
    
    private String semester = new String();
    private String subject_code = new String();
    private String subject_name = new String();
    private int credit_hour = 0, marks = 0, total_chrs = 0
            ,credit_points = 0, cum_cpts = 0;
    private String grade = new String();
    private double gpa = 0.0;
    private String academic_status = new String();
    private GPA_Calculation myGPA = new GPA_Calculation();
    DecimalFormat DF = new DecimalFormat("0.00");
    private boolean calcsub1 = true, calcsub2 = true, calcsub3 = true,
            calcsub4 = true,calcsub5 = false, subject5 = true, eligibleSemester = false, noCalculate = true;
    private int subjectMark1 = 0, subjectMark2 = 0, subjectMark3 = 0, subjectMark4 = 0, subjectMark5 = 0;
    private String subjectName1= new String(), subjectName2= new String(), subjectName3= new String()
            , subjectName4= new String(), subjectName5= new String();
    private int lowest_mark = 0;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm a");
    private SimpleDateFormat dayFormat = new SimpleDateFormat("E,");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
    private String time, day, date;
    private StringJoiner sub_retake = new StringJoiner("\n-> "); 
    private String addOn, saveSubtoretake;
    private Color white_text = new Color(255,255,255);
    private Color medium_black = new Color(34,40,44);
    private Color light_black = new Color(44,52,58);
    private Color dark_black = new Color(32,33,36);
    private Color grey_comboBox = new Color(204,204,204);
    private Color light_blue = new Color(138,180,248);
    private Color black_text = new Color(44,52,58);
    private Color solid_white = new Color(255,255,255);
    private Color light_white = new Color(246,246,246);
    private Color medium_white = new Color(236,236,236);
    private Color light_grey = new Color(225,225,225);
    private Color sky_blue = new Color(185,224,255);
    private Color ocean_blue = new Color(129,198,232);
    private Color navy_blue = new Color(93,167,219);
    private Color solid_black = new Color(50,50,50);
    private Color light_red = new Color(255,11,85);
    private Color dark_red = new Color(214,29,78);
    private String theme = new String();
    private int resetResponse = 0;
    
   
    public GPA_Calculator() {
        initComponents();
        darkTheme();
        setClock();
        lblDisplaySem.setVisible(false);
        selectSubjectFirst();
        deleteSubject5();
        btnDelsubject5.setEnabled(false);
        deactivateSubCode();
        hideSubtoRetake();
    }

    private void setSemester()
    {
        cmbSemester.setVisible(false);
        lblDisplaySem.setVisible(true);
        lblSemester.setVisible(false);
    }
    
    private void resetAll()
    {
        cmbSemester.setSelectedItem("Select Semester...");
        cmbSemester.setVisible(true);
        lblDisplaySem.setVisible(false);
        lblSemester.setVisible(true);
        cmbSubCode1.setSelectedItem("Subject Code...");
        lblSubName1.setText("No Subject Selected");
        cmbCredHrs1.setSelectedItem("1");
        txtSubMark1.setText("");
        lblSubGrade1.setText("No Grade");
        lblSubCredpoints1.setText("None");
        cmbSubCode2.setSelectedItem("Subject Code...");
        lblSubName2.setText("No Subject Selected");
        cmbCredHrs2.setSelectedItem("1");
        txtSubMark2.setText("");
        lblSubGrade2.setText("No Grade");
        lblSubCredpoints2.setText("None");
        cmbSubCode3.setSelectedItem("Subject Code...");
        lblSubName3.setText("No Subject Selected");
        cmbCredHrs3.setSelectedItem("1");
        txtSubMark3.setText("");
        lblSubGrade3.setText("No Grade");
        lblSubCredpoints3.setText("None");
        cmbSubCode4.setSelectedItem("Subject Code...");
        lblSubName4.setText("No Subject Selected");
        cmbCredHrs4.setSelectedItem("1");
        txtSubMark4.setText("");
        lblSubGrade4.setText("No Grade");
        lblSubCredpoints4.setText("None");
        cmbSubCode5.setSelectedItem("Subject Code...");
        lblSubName5.setText("No Subject Selected");
        cmbCredHrs5.setSelectedItem("1");
        txtSubMark5.setText("");
        lblSubGrade5.setText("No Grade");
        lblSubCredpoints5.setText("None");
        lblDisplay_TotCHrs.setText("0 Hrs");
        lblDisplay_CumcPts.setText("0 Points");
        lblGPA_Result.setText("0.00");
        lblDisplay_AcademicStat.setText("No Status");
        deactivateSubCode();
        hideSubtoRetake();
    }
    
    private void selectSubjectFirst()
    {
        txtSubMark1.setEnabled(false);
        cmbCredHrs1.setEnabled(false);
        txtSubMark2.setEnabled(false);
        cmbCredHrs2.setEnabled(false);
        txtSubMark3.setEnabled(false);
        cmbCredHrs3.setEnabled(false);
        txtSubMark4.setEnabled(false);
        cmbCredHrs4.setEnabled(false);
        txtSubMark5.setEnabled(false);
        cmbCredHrs5.setEnabled(false);
    }
    
    private void deleteSubject5()
    {
        jpSubject5.setVisible(false);
        subject5 = false;
        calcsub5 = false;
        lblDisplay_TotCHrs.setText("0 Hrs");
        lblDisplay_CumcPts.setText("0 Points");
        lblGPA_Result.setText("0.00");
        lblDisplay_AcademicStat.setText("No Status");
        cmbSubCode5.setSelectedItem("Subject Code...");
        lblSubName5.setText("No Subject Selected");
        cmbCredHrs5.setSelectedItem("1");
        txtSubMark5.setText("");
        lblSubGrade5.setText("No Grade");
        lblSubCredpoints5.setText("None");
        btnAddsubject5.setEnabled(true);
        btnDelsubject5.setEnabled(false);
        noCalculate = false;
        hideSubtoRetake();
    }
    
    private void addSubject5()
    {
        jpSubject5.setVisible(true);
        subject5 = true;
        calcsub5 = true;
        lblDisplay_TotCHrs.setText("0 Hrs");
        lblDisplay_CumcPts.setText("0 Points");
        lblGPA_Result.setText("0.00");
        lblDisplay_AcademicStat.setText("No Status");
        btnDelsubject5.setEnabled(true);
        btnAddsubject5.setEnabled(false);
        noCalculate = true;
        hideSubtoRetake();
    }
    
    private void deactivateSubCode()
    {
        cmbSubCode1.setEnabled(false);
        cmbSubCode2.setEnabled(false);
        cmbSubCode3.setEnabled(false);
        cmbSubCode4.setEnabled(false);
        cmbSubCode5.setEnabled(false);
    }
    
     private void activateSubCode()
    {
        cmbSubCode1.setEnabled(true);
        cmbSubCode2.setEnabled(true);
        cmbSubCode3.setEnabled(true);
        cmbSubCode4.setEnabled(true);
        cmbSubCode5.setEnabled(true);
    }
    
    private void setClock()
    {
        Thread clock = new Thread()
        {
            public void run()
            {
               try{
                    for(;;){
                    time = timeFormat.format(Calendar.getInstance().getTime());
                    lblTime.setText(time);
            
                    day = dayFormat.format(Calendar.getInstance().getTime());
                    lblDay.setText(day);
            
                    date = dateFormat.format(Calendar.getInstance().getTime());
                    lblDate.setText(date);
        
                    sleep(1000);
                    }
            }catch(InterruptedException e) {
                e.printStackTrace();
            } 
            }      
    };
    clock.start();
    }
    
    private void hideSubtoRetake()
    {
        lblSubRetake.setVisible(false);
        btnSubtoretake_check.setVisible(false);
        spSubRetake.setVisible(false);
    }
    
    private void showSubtoRetake()
    {
        lblSubRetake.setVisible(true);
        btnSubtoretake_check.setVisible(true);
        spSubRetake.setVisible(true);
    }
    
     private void darkTheme()
    {
        lblTitle.setForeground(white_text);
        lblTime.setForeground(white_text);
        lblDay.setForeground(white_text);
        lblDate.setForeground(white_text);
        cmbThemes.setBackground(grey_comboBox);
        jpHeader.setBackground(medium_black);
        jpSubjectTable.setBackground(light_black);
        lblSemester.setForeground(white_text);
        cmbSemester.setBackground(grey_comboBox);
        lblDisplaySem.setForeground(white_text);
        btnAddsubject5.setBackground(dark_black);
        btnAddsubject5.setForeground(white_text);
        btnDelsubject5.setBackground(dark_black);
        btnDelsubject5.setForeground(white_text);
        jpSubjectheader.setBackground(dark_black);
        lblSubjectNo.setForeground(white_text);
        lblSubjectcode.setForeground(white_text);
        lblSubjectname.setForeground(white_text);
        lblCredithrs.setForeground(white_text);
        lblSubjectmark.setForeground(white_text);
        lblSubjectgrade.setForeground(white_text);
        lblCreditpoint.setForeground(white_text);
        jpSubject1.setBackground(medium_black);
        jpSubject2.setBackground(medium_black);
        jpSubject3.setBackground(medium_black);
        jpSubject4.setBackground(medium_black);
        jpSubject5.setBackground(medium_black);
        lblSubNo1.setForeground(white_text);
        lblSubNo2.setForeground(white_text);
        lblSubNo3.setForeground(white_text);
        lblSubNo4.setForeground(white_text);
        lblSubNo5.setForeground(white_text);
        cmbSubCode1.setBackground(grey_comboBox);
        cmbSubCode2.setBackground(grey_comboBox);
        cmbSubCode3.setBackground(grey_comboBox);
        cmbSubCode4.setBackground(grey_comboBox);
        cmbSubCode5.setBackground(grey_comboBox);
        lblSubName1.setForeground(white_text);
        lblSubName2.setForeground(white_text);
        lblSubName3.setForeground(white_text);
        lblSubName4.setForeground(white_text);
        lblSubName5.setForeground(white_text);
        cmbCredHrs1.setBackground(grey_comboBox);
        cmbCredHrs2.setBackground(grey_comboBox);
        cmbCredHrs3.setBackground(grey_comboBox);
        cmbCredHrs4.setBackground(grey_comboBox);
        cmbCredHrs5.setBackground(grey_comboBox);
        txtSubMark1.setBackground(dark_black);
        txtSubMark1.setForeground(white_text);
        txtSubMark2.setBackground(dark_black);
        txtSubMark2.setForeground(white_text);
        txtSubMark3.setBackground(dark_black);
        txtSubMark3.setForeground(white_text);
        txtSubMark4.setBackground(dark_black);
        txtSubMark4.setForeground(white_text);
        txtSubMark5.setBackground(dark_black);
        txtSubMark5.setForeground(white_text);
        lblSubGrade1.setForeground(white_text);
        lblSubGrade2.setForeground(white_text);
        lblSubGrade3.setForeground(white_text);
        lblSubGrade4.setForeground(white_text);
        lblSubGrade5.setForeground(white_text);
        lblSubCredpoints1.setForeground(white_text);
        lblSubCredpoints2.setForeground(white_text);
        lblSubCredpoints3.setForeground(white_text);
        lblSubCredpoints4.setForeground(white_text);
        lblSubCredpoints5.setForeground(white_text);
        jpResults.setBackground(medium_black);
        lblTotCredHrs.setForeground(white_text);
        lblDisplay_TotCHrs.setForeground(white_text);
        lblCumCredpoints.setForeground(white_text);
        lblDisplay_CumcPts.setForeground(white_text);
        lblAcademicStatus.setForeground(white_text);
        lblDisplay_AcademicStat.setForeground(white_text);
        lblSubRetake.setForeground(white_text);
        btnSubtoretake_check.setBackground(dark_black);
        btnSubtoretake_check.setForeground(white_text);
        lblGPA_Result.setForeground(white_text);
        lblGPA.setForeground(white_text);
        jpMainBackground.setBackground(dark_black);
        btnReset.setBackground(light_blue);
        btnReset.setForeground(dark_black);
        btnCalculate.setBackground(light_blue);
        btnCalculate.setForeground(dark_black);
    }
     
     private void lightTheme()
    {
        lblTitle.setForeground(black_text);
        lblTime.setForeground(black_text);
        lblDay.setForeground(black_text);
        lblDate.setForeground(black_text);
        cmbThemes.setBackground(grey_comboBox);
        jpHeader.setBackground(light_white);
        jpSubjectTable.setBackground(solid_white);
        lblSemester.setForeground(black_text);
        cmbSemester.setBackground(grey_comboBox);
        lblDisplaySem.setForeground(black_text);
        btnAddsubject5.setBackground(light_grey);
        btnAddsubject5.setForeground(black_text);
        btnDelsubject5.setBackground(light_grey);
        btnDelsubject5.setForeground(black_text);
        jpSubjectheader.setBackground(medium_white);
        lblSubjectNo.setForeground(black_text);
        lblSubjectcode.setForeground(black_text);
        lblSubjectname.setForeground(black_text);
        lblCredithrs.setForeground(black_text);
        lblSubjectmark.setForeground(black_text);
        lblSubjectgrade.setForeground(black_text);
        lblCreditpoint.setForeground(black_text);
        jpSubject1.setBackground(light_white);
        jpSubject2.setBackground(light_white);
        jpSubject3.setBackground(light_white);
        jpSubject4.setBackground(light_white);
        jpSubject5.setBackground(light_white);
        lblSubNo1.setForeground(black_text);
        lblSubNo2.setForeground(black_text);
        lblSubNo3.setForeground(black_text);
        lblSubNo4.setForeground(black_text);
        lblSubNo5.setForeground(black_text);
        cmbSubCode1.setBackground(grey_comboBox);
        cmbSubCode2.setBackground(grey_comboBox);
        cmbSubCode3.setBackground(grey_comboBox);
        cmbSubCode4.setBackground(grey_comboBox);
        cmbSubCode5.setBackground(grey_comboBox);
        lblSubName1.setForeground(black_text);
        lblSubName2.setForeground(black_text);
        lblSubName3.setForeground(black_text);
        lblSubName4.setForeground(black_text);
        lblSubName5.setForeground(black_text);
        cmbCredHrs1.setBackground(grey_comboBox);
        cmbCredHrs2.setBackground(grey_comboBox);
        cmbCredHrs3.setBackground(grey_comboBox);
        cmbCredHrs4.setBackground(grey_comboBox);
        cmbCredHrs5.setBackground(grey_comboBox);
        txtSubMark1.setBackground(medium_white);
        txtSubMark1.setForeground(black_text);
        txtSubMark2.setBackground(medium_white);
        txtSubMark2.setForeground(black_text);
        txtSubMark3.setBackground(medium_white);
        txtSubMark3.setForeground(black_text);
        txtSubMark4.setBackground(medium_white);
        txtSubMark4.setForeground(black_text);
        txtSubMark5.setBackground(medium_white);
        txtSubMark5.setForeground(black_text);
        lblSubGrade1.setForeground(black_text);
        lblSubGrade2.setForeground(black_text);
        lblSubGrade3.setForeground(black_text);
        lblSubGrade4.setForeground(black_text);
        lblSubGrade5.setForeground(black_text);
        lblSubCredpoints1.setForeground(black_text);
        lblSubCredpoints2.setForeground(black_text);
        lblSubCredpoints3.setForeground(black_text);
        lblSubCredpoints4.setForeground(black_text);
        lblSubCredpoints5.setForeground(black_text);
        jpResults.setBackground(light_white);
        lblTotCredHrs.setForeground(black_text);
        lblDisplay_TotCHrs.setForeground(black_text);
        lblCumCredpoints.setForeground(black_text);
        lblDisplay_CumcPts.setForeground(black_text);
        lblAcademicStatus.setForeground(black_text);
        lblDisplay_AcademicStat.setForeground(black_text);
        lblSubRetake.setForeground(black_text);
        btnSubtoretake_check.setBackground(light_grey);
        btnSubtoretake_check.setForeground(black_text);
        lblGPA_Result.setForeground(black_text);
        lblGPA.setForeground(black_text);
        jpMainBackground.setBackground(medium_white);
        btnReset.setBackground(light_grey);
        btnReset.setForeground(black_text);
        btnCalculate.setBackground(light_grey);
        btnCalculate.setForeground(black_text);
    }
     
     private void skyTheme()
    {
        lblTitle.setForeground(black_text);
        lblTime.setForeground(black_text);
        lblDay.setForeground(black_text);
        lblDate.setForeground(black_text);
        cmbThemes.setBackground(grey_comboBox);
        jpHeader.setBackground(ocean_blue);
        jpSubjectTable.setBackground(sky_blue);
        lblSemester.setForeground(black_text);
        cmbSemester.setBackground(grey_comboBox);
        lblDisplaySem.setForeground(black_text);
        btnAddsubject5.setBackground(navy_blue);
        btnAddsubject5.setForeground(white_text);
        btnDelsubject5.setBackground(navy_blue);
        btnDelsubject5.setForeground(white_text);
        jpSubjectheader.setBackground(navy_blue);
        lblSubjectNo.setForeground(white_text);
        lblSubjectcode.setForeground(white_text);
        lblSubjectname.setForeground(white_text);
        lblCredithrs.setForeground(white_text);
        lblSubjectmark.setForeground(white_text);
        lblSubjectgrade.setForeground(white_text);
        lblCreditpoint.setForeground(white_text);
        jpSubject1.setBackground(ocean_blue);
        jpSubject2.setBackground(ocean_blue);
        jpSubject3.setBackground(ocean_blue);
        jpSubject4.setBackground(ocean_blue);
        jpSubject5.setBackground(ocean_blue);
        lblSubNo1.setForeground(black_text);
        lblSubNo2.setForeground(black_text);
        lblSubNo3.setForeground(black_text);
        lblSubNo4.setForeground(black_text);
        lblSubNo5.setForeground(black_text);
        cmbSubCode1.setBackground(grey_comboBox);
        cmbSubCode2.setBackground(grey_comboBox);
        cmbSubCode3.setBackground(grey_comboBox);
        cmbSubCode4.setBackground(grey_comboBox);
        cmbSubCode5.setBackground(grey_comboBox);
        lblSubName1.setForeground(black_text);
        lblSubName2.setForeground(black_text);
        lblSubName3.setForeground(black_text);
        lblSubName4.setForeground(black_text);
        lblSubName5.setForeground(black_text);
        cmbCredHrs1.setBackground(grey_comboBox);
        cmbCredHrs2.setBackground(grey_comboBox);
        cmbCredHrs3.setBackground(grey_comboBox);
        cmbCredHrs4.setBackground(grey_comboBox);
        cmbCredHrs5.setBackground(grey_comboBox);
        txtSubMark1.setBackground(sky_blue);
        txtSubMark1.setForeground(black_text);
        txtSubMark2.setBackground(sky_blue);
        txtSubMark2.setForeground(black_text);
        txtSubMark3.setBackground(sky_blue);
        txtSubMark3.setForeground(black_text);
        txtSubMark4.setBackground(sky_blue);
        txtSubMark4.setForeground(black_text);
        txtSubMark5.setBackground(sky_blue);
        txtSubMark5.setForeground(black_text);
        lblSubGrade1.setForeground(black_text);
        lblSubGrade2.setForeground(black_text);
        lblSubGrade3.setForeground(black_text);
        lblSubGrade4.setForeground(black_text);
        lblSubGrade5.setForeground(black_text);
        lblSubCredpoints1.setForeground(black_text);
        lblSubCredpoints2.setForeground(black_text);
        lblSubCredpoints3.setForeground(black_text);
        lblSubCredpoints4.setForeground(black_text);
        lblSubCredpoints5.setForeground(black_text);
        jpResults.setBackground(ocean_blue);
        lblTotCredHrs.setForeground(black_text);
        lblDisplay_TotCHrs.setForeground(black_text);
        lblCumCredpoints.setForeground(black_text);
        lblDisplay_CumcPts.setForeground(black_text);
        lblAcademicStatus.setForeground(black_text);
        lblDisplay_AcademicStat.setForeground(black_text);
        lblSubRetake.setForeground(black_text);
        btnSubtoretake_check.setBackground(navy_blue);
        btnSubtoretake_check.setForeground(white_text);
        lblGPA_Result.setForeground(white_text);
        lblGPA.setForeground(white_text);
        jpMainBackground.setBackground(navy_blue);
        btnReset.setBackground(navy_blue);
        btnReset.setForeground(white_text);
        btnCalculate.setBackground(navy_blue);
        btnCalculate.setForeground(white_text);
    }
     
     private void modernTheme()
    {
        lblTitle.setForeground(white_text);
        lblTime.setForeground(white_text);
        lblDay.setForeground(white_text);
        lblDate.setForeground(white_text);
        cmbThemes.setBackground(grey_comboBox);
        jpHeader.setBackground(solid_black);
        jpSubjectTable.setBackground(light_red);
        lblSemester.setForeground(black_text);
        cmbSemester.setBackground(grey_comboBox);
        lblDisplaySem.setForeground(black_text);
        btnAddsubject5.setBackground(solid_black);
        btnAddsubject5.setForeground(white_text);
        btnDelsubject5.setBackground(solid_black);
        btnDelsubject5.setForeground(white_text);
        jpSubjectheader.setBackground(dark_red);
        lblSubjectNo.setForeground(white_text);
        lblSubjectcode.setForeground(white_text);
        lblSubjectname.setForeground(white_text);
        lblCredithrs.setForeground(white_text);
        lblSubjectmark.setForeground(white_text);
        lblSubjectgrade.setForeground(white_text);
        lblCreditpoint.setForeground(white_text);
        jpSubject1.setBackground(solid_black);
        jpSubject2.setBackground(solid_black);
        jpSubject3.setBackground(solid_black);
        jpSubject4.setBackground(solid_black);
        jpSubject5.setBackground(solid_black);
        lblSubNo1.setForeground(white_text);
        lblSubNo2.setForeground(white_text);
        lblSubNo3.setForeground(white_text);
        lblSubNo4.setForeground(white_text);
        lblSubNo5.setForeground(white_text);
        cmbSubCode1.setBackground(grey_comboBox);
        cmbSubCode2.setBackground(grey_comboBox);
        cmbSubCode3.setBackground(grey_comboBox);
        cmbSubCode4.setBackground(grey_comboBox);
        cmbSubCode5.setBackground(grey_comboBox);
        lblSubName1.setForeground(white_text);
        lblSubName2.setForeground(white_text);
        lblSubName3.setForeground(white_text);
        lblSubName4.setForeground(white_text);
        lblSubName5.setForeground(white_text);
        cmbCredHrs1.setBackground(grey_comboBox);
        cmbCredHrs2.setBackground(grey_comboBox);
        cmbCredHrs3.setBackground(grey_comboBox);
        cmbCredHrs4.setBackground(grey_comboBox);
        cmbCredHrs5.setBackground(grey_comboBox);
        txtSubMark1.setBackground(light_red);
        txtSubMark1.setForeground(white_text);
        txtSubMark2.setBackground(light_red);
        txtSubMark2.setForeground(white_text);
        txtSubMark3.setBackground(light_red);
        txtSubMark3.setForeground(white_text);
        txtSubMark4.setBackground(light_red);
        txtSubMark4.setForeground(white_text);
        txtSubMark5.setBackground(light_red);
        txtSubMark5.setForeground(white_text);
        lblSubGrade1.setForeground(white_text);
        lblSubGrade2.setForeground(white_text);
        lblSubGrade3.setForeground(white_text);
        lblSubGrade4.setForeground(white_text);
        lblSubGrade5.setForeground(white_text);
        lblSubCredpoints1.setForeground(white_text);
        lblSubCredpoints2.setForeground(white_text);
        lblSubCredpoints3.setForeground(white_text);
        lblSubCredpoints4.setForeground(white_text);
        lblSubCredpoints5.setForeground(white_text);
        jpResults.setBackground(solid_black);
        lblTotCredHrs.setForeground(white_text);
        lblDisplay_TotCHrs.setForeground(white_text);
        lblCumCredpoints.setForeground(white_text);
        lblDisplay_CumcPts.setForeground(white_text);
        lblAcademicStatus.setForeground(white_text);
        lblDisplay_AcademicStat.setForeground(white_text);
        lblSubRetake.setForeground(white_text);
        btnSubtoretake_check.setBackground(light_red);
        btnSubtoretake_check.setForeground(white_text);
        lblGPA_Result.setForeground(light_red);
        lblGPA.setForeground(light_red);
        jpMainBackground.setBackground(dark_red);
        btnReset.setBackground(dark_red);
        btnReset.setForeground(white_text);
        btnCalculate.setBackground(dark_red);
        btnCalculate.setForeground(white_text);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMainBackground = new javax.swing.JPanel();
        jpHeader = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDay = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        cmbThemes = new javax.swing.JComboBox<>();
        jpSubjectTable = new javax.swing.JPanel();
        lblSemester = new javax.swing.JLabel();
        cmbSemester = new javax.swing.JComboBox<>();
        jpSubject1 = new javax.swing.JPanel();
        lblSubNo1 = new javax.swing.JLabel();
        cmbCredHrs1 = new javax.swing.JComboBox<>();
        lblSubName1 = new javax.swing.JLabel();
        cmbSubCode1 = new javax.swing.JComboBox<>();
        txtSubMark1 = new javax.swing.JTextField();
        lblSubGrade1 = new javax.swing.JLabel();
        lblSubCredpoints1 = new javax.swing.JLabel();
        jpSubjectheader = new javax.swing.JPanel();
        lblSubjectcode = new javax.swing.JLabel();
        lblSubjectname = new javax.swing.JLabel();
        lblCredithrs = new javax.swing.JLabel();
        lblSubjectmark = new javax.swing.JLabel();
        lblSubjectgrade = new javax.swing.JLabel();
        lblSubjectNo = new javax.swing.JLabel();
        lblCreditpoint = new javax.swing.JLabel();
        jpSubject2 = new javax.swing.JPanel();
        lblSubNo2 = new javax.swing.JLabel();
        cmbSubCode2 = new javax.swing.JComboBox<>();
        lblSubName2 = new javax.swing.JLabel();
        cmbCredHrs2 = new javax.swing.JComboBox<>();
        txtSubMark2 = new javax.swing.JTextField();
        lblSubGrade2 = new javax.swing.JLabel();
        lblSubCredpoints2 = new javax.swing.JLabel();
        jpSubject3 = new javax.swing.JPanel();
        lblSubNo3 = new javax.swing.JLabel();
        cmbSubCode3 = new javax.swing.JComboBox<>();
        lblSubName3 = new javax.swing.JLabel();
        cmbCredHrs3 = new javax.swing.JComboBox<>();
        txtSubMark3 = new javax.swing.JTextField();
        lblSubGrade3 = new javax.swing.JLabel();
        lblSubCredpoints3 = new javax.swing.JLabel();
        jpSubject4 = new javax.swing.JPanel();
        lblSubNo4 = new javax.swing.JLabel();
        cmbSubCode4 = new javax.swing.JComboBox<>();
        lblSubName4 = new javax.swing.JLabel();
        cmbCredHrs4 = new javax.swing.JComboBox<>();
        txtSubMark4 = new javax.swing.JTextField();
        lblSubGrade4 = new javax.swing.JLabel();
        lblSubCredpoints4 = new javax.swing.JLabel();
        jpSubject5 = new javax.swing.JPanel();
        lblSubNo5 = new javax.swing.JLabel();
        cmbSubCode5 = new javax.swing.JComboBox<>();
        lblSubName5 = new javax.swing.JLabel();
        cmbCredHrs5 = new javax.swing.JComboBox<>();
        txtSubMark5 = new javax.swing.JTextField();
        lblSubGrade5 = new javax.swing.JLabel();
        lblSubCredpoints5 = new javax.swing.JLabel();
        jpResults = new javax.swing.JPanel();
        lblTotCredHrs = new javax.swing.JLabel();
        lblCumCredpoints = new javax.swing.JLabel();
        lblAcademicStatus = new javax.swing.JLabel();
        lblSubRetake = new javax.swing.JLabel();
        lblDisplay_TotCHrs = new javax.swing.JLabel();
        lblDisplay_CumcPts = new javax.swing.JLabel();
        lblDisplay_AcademicStat = new javax.swing.JLabel();
        spTotalCredHrs = new javax.swing.JSeparator();
        spCumCredPts = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        spAcademicStat = new javax.swing.JSeparator();
        spSubRetake = new javax.swing.JSeparator();
        lblGPA_Result = new javax.swing.JLabel();
        lblGPA = new javax.swing.JLabel();
        btnSubtoretake_check = new javax.swing.JButton();
        lblDisplaySem = new javax.swing.JLabel();
        btnAddsubject5 = new javax.swing.JButton();
        btnDelsubject5 = new javax.swing.JButton();
        btnCalculate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GPA Calculator");
        setBackground(new java.awt.Color(51, 51, 51));

        jpMainBackground.setBackground(new java.awt.Color(214, 29, 78));
        jpMainBackground.setForeground(new java.awt.Color(255, 255, 255));

        jpHeader.setBackground(new java.awt.Color(50, 50, 50));

        lblTitle.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("GPA Calculator");

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("Time");

        lblDay.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDay.setForeground(new java.awt.Color(255, 255, 255));
        lblDay.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDay.setText("Day");

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Date");

        cmbThemes.setBackground(new java.awt.Color(208, 208, 208));
        cmbThemes.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        cmbThemes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dark Theme", "Light Theme", "Sky Theme", "Modern Theme" }));
        cmbThemes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbThemesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpHeaderLayout = new javax.swing.GroupLayout(jpHeader);
        jpHeader.setLayout(jpHeaderLayout);
        jpHeaderLayout.setHorizontalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeaderLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblTitle)
                .addGroup(jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpHeaderLayout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(lblDay, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpHeaderLayout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbThemes, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jpHeaderLayout.setVerticalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(36, 36, 36))
            .addGroup(jpHeaderLayout.createSequentialGroup()
                .addGroup(jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpHeaderLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDate)
                            .addComponent(lblDay)))
                    .addGroup(jpHeaderLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(cmbThemes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jpSubjectTable.setBackground(new java.awt.Color(255, 11, 85));

        lblSemester.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSemester.setForeground(new java.awt.Color(51, 51, 51));
        lblSemester.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblSemester.setText("Semester:");
        lblSemester.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cmbSemester.setBackground(new java.awt.Color(208, 208, 208));
        cmbSemester.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        cmbSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Semester...", "Semester 1", "Semester 2", "Special Sem" }));
        cmbSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSemesterActionPerformed(evt);
            }
        });

        jpSubject1.setBackground(new java.awt.Color(50, 50, 50));

        lblSubNo1.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubNo1.setForeground(new java.awt.Color(255, 255, 255));
        lblSubNo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubNo1.setText("1");

        cmbCredHrs1.setBackground(new java.awt.Color(208, 208, 208));
        cmbCredHrs1.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        cmbCredHrs1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cmbCredHrs1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCredHrs1ActionPerformed(evt);
            }
        });

        lblSubName1.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubName1.setForeground(new java.awt.Color(255, 255, 255));
        lblSubName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubName1.setText("No Subject Selected");

        cmbSubCode1.setBackground(new java.awt.Color(208, 208, 208));
        cmbSubCode1.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        cmbSubCode1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subject Code...", "CCSB2113", "CISB3433", "CISB4233", "CISB4413", "CSEB4123" }));
        cmbSubCode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSubCode1ActionPerformed(evt);
            }
        });

        txtSubMark1.setBackground(new java.awt.Color(255, 11, 85));
        txtSubMark1.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        txtSubMark1.setForeground(new java.awt.Color(255, 255, 255));
        txtSubMark1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblSubGrade1.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubGrade1.setForeground(new java.awt.Color(255, 255, 255));
        lblSubGrade1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubGrade1.setText("No Grade");

        lblSubCredpoints1.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubCredpoints1.setForeground(new java.awt.Color(255, 255, 255));
        lblSubCredpoints1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubCredpoints1.setText("None");

        javax.swing.GroupLayout jpSubject1Layout = new javax.swing.GroupLayout(jpSubject1);
        jpSubject1.setLayout(jpSubject1Layout);
        jpSubject1Layout.setHorizontalGroup(
            jpSubject1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubject1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblSubNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(cmbSubCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSubName1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(cmbCredHrs1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(txtSubMark1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(lblSubGrade1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSubCredpoints1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jpSubject1Layout.setVerticalGroup(
            jpSubject1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubject1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSubject1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubNo1)
                    .addComponent(cmbCredHrs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubName1)
                    .addComponent(cmbSubCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubMark1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubGrade1)
                    .addComponent(lblSubCredpoints1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jpSubjectheader.setBackground(new java.awt.Color(214, 29, 78));

        lblSubjectcode.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubjectcode.setForeground(new java.awt.Color(255, 255, 255));
        lblSubjectcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubjectcode.setText("Subject Code");

        lblSubjectname.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubjectname.setForeground(new java.awt.Color(255, 255, 255));
        lblSubjectname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubjectname.setText("Subject Name");

        lblCredithrs.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblCredithrs.setForeground(new java.awt.Color(255, 255, 255));
        lblCredithrs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCredithrs.setText("Credit Hours");

        lblSubjectmark.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubjectmark.setForeground(new java.awt.Color(255, 255, 255));
        lblSubjectmark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubjectmark.setText("Mark");

        lblSubjectgrade.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubjectgrade.setForeground(new java.awt.Color(255, 255, 255));
        lblSubjectgrade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubjectgrade.setText("Grade");

        lblSubjectNo.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubjectNo.setForeground(new java.awt.Color(255, 255, 255));
        lblSubjectNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubjectNo.setText("#");

        lblCreditpoint.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblCreditpoint.setForeground(new java.awt.Color(255, 255, 255));
        lblCreditpoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreditpoint.setText("Credit Points");

        javax.swing.GroupLayout jpSubjectheaderLayout = new javax.swing.GroupLayout(jpSubjectheader);
        jpSubjectheader.setLayout(jpSubjectheaderLayout);
        jpSubjectheaderLayout.setHorizontalGroup(
            jpSubjectheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubjectheaderLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblSubjectNo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(lblSubjectcode, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(lblSubjectname)
                .addGap(127, 127, 127)
                .addComponent(lblCredithrs)
                .addGap(65, 65, 65)
                .addComponent(lblSubjectmark, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSubjectgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCreditpoint, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        jpSubjectheaderLayout.setVerticalGroup(
            jpSubjectheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubjectheaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSubjectheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubjectcode)
                    .addComponent(lblSubjectname)
                    .addComponent(lblCredithrs)
                    .addComponent(lblSubjectmark)
                    .addComponent(lblSubjectgrade)
                    .addComponent(lblSubjectNo)
                    .addComponent(lblCreditpoint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpSubject2.setBackground(new java.awt.Color(50, 50, 50));

        lblSubNo2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubNo2.setForeground(new java.awt.Color(255, 255, 255));
        lblSubNo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubNo2.setText("2");

        cmbSubCode2.setBackground(new java.awt.Color(208, 208, 208));
        cmbSubCode2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        cmbSubCode2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subject Code...", "CCSB2113", "CISB3433", "CISB4233", "CISB4413", "CSEB4123" }));
        cmbSubCode2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSubCode2ActionPerformed(evt);
            }
        });

        lblSubName2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubName2.setForeground(new java.awt.Color(255, 255, 255));
        lblSubName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubName2.setText("No Subject Selected");

        cmbCredHrs2.setBackground(new java.awt.Color(208, 208, 208));
        cmbCredHrs2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        cmbCredHrs2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cmbCredHrs2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCredHrs2ActionPerformed(evt);
            }
        });

        txtSubMark2.setBackground(new java.awt.Color(255, 11, 85));
        txtSubMark2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        txtSubMark2.setForeground(new java.awt.Color(255, 255, 255));
        txtSubMark2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblSubGrade2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubGrade2.setForeground(new java.awt.Color(255, 255, 255));
        lblSubGrade2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubGrade2.setText("No Grade");

        lblSubCredpoints2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubCredpoints2.setForeground(new java.awt.Color(255, 255, 255));
        lblSubCredpoints2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubCredpoints2.setText("None");

        javax.swing.GroupLayout jpSubject2Layout = new javax.swing.GroupLayout(jpSubject2);
        jpSubject2.setLayout(jpSubject2Layout);
        jpSubject2Layout.setHorizontalGroup(
            jpSubject2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubject2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblSubNo2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(cmbSubCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSubName2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(cmbCredHrs2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(txtSubMark2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(lblSubGrade2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSubCredpoints2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jpSubject2Layout.setVerticalGroup(
            jpSubject2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubject2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSubject2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubNo2)
                    .addComponent(cmbSubCode2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubName2)
                    .addComponent(cmbCredHrs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubMark2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubGrade2)
                    .addComponent(lblSubCredpoints2))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jpSubject3.setBackground(new java.awt.Color(50, 50, 50));

        lblSubNo3.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubNo3.setForeground(new java.awt.Color(255, 255, 255));
        lblSubNo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubNo3.setText("3");

        cmbSubCode3.setBackground(new java.awt.Color(208, 208, 208));
        cmbSubCode3.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        cmbSubCode3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subject Code...", "CCSB2113", "CISB3433", "CISB4233", "CISB4413", "CSEB4123" }));
        cmbSubCode3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSubCode3ActionPerformed(evt);
            }
        });

        lblSubName3.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubName3.setForeground(new java.awt.Color(255, 255, 255));
        lblSubName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubName3.setText("No Subject Selected");

        cmbCredHrs3.setBackground(new java.awt.Color(208, 208, 208));
        cmbCredHrs3.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        cmbCredHrs3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cmbCredHrs3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCredHrs3ActionPerformed(evt);
            }
        });

        txtSubMark3.setBackground(new java.awt.Color(255, 11, 85));
        txtSubMark3.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        txtSubMark3.setForeground(new java.awt.Color(255, 255, 255));
        txtSubMark3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblSubGrade3.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubGrade3.setForeground(new java.awt.Color(255, 255, 255));
        lblSubGrade3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubGrade3.setText("No Grade");

        lblSubCredpoints3.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubCredpoints3.setForeground(new java.awt.Color(255, 255, 255));
        lblSubCredpoints3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubCredpoints3.setText("None");

        javax.swing.GroupLayout jpSubject3Layout = new javax.swing.GroupLayout(jpSubject3);
        jpSubject3.setLayout(jpSubject3Layout);
        jpSubject3Layout.setHorizontalGroup(
            jpSubject3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubject3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblSubNo3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(cmbSubCode3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSubName3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(cmbCredHrs3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(txtSubMark3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(lblSubGrade3, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(lblSubCredpoints3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jpSubject3Layout.setVerticalGroup(
            jpSubject3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubject3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSubject3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubNo3)
                    .addComponent(cmbSubCode3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubName3)
                    .addComponent(cmbCredHrs3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubMark3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubGrade3)
                    .addComponent(lblSubCredpoints3))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jpSubject4.setBackground(new java.awt.Color(50, 50, 50));

        lblSubNo4.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubNo4.setForeground(new java.awt.Color(255, 255, 255));
        lblSubNo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubNo4.setText("4");

        cmbSubCode4.setBackground(new java.awt.Color(208, 208, 208));
        cmbSubCode4.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        cmbSubCode4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subject Code...", "CCSB2113", "CISB3433", "CISB4233", "CISB4413", "CSEB4123" }));
        cmbSubCode4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSubCode4ActionPerformed(evt);
            }
        });

        lblSubName4.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubName4.setForeground(new java.awt.Color(255, 255, 255));
        lblSubName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubName4.setText("No Subject Selected");

        cmbCredHrs4.setBackground(new java.awt.Color(208, 208, 208));
        cmbCredHrs4.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        cmbCredHrs4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cmbCredHrs4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCredHrs4ActionPerformed(evt);
            }
        });

        txtSubMark4.setBackground(new java.awt.Color(255, 11, 85));
        txtSubMark4.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        txtSubMark4.setForeground(new java.awt.Color(255, 255, 255));
        txtSubMark4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblSubGrade4.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubGrade4.setForeground(new java.awt.Color(255, 255, 255));
        lblSubGrade4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubGrade4.setText("No Grade");

        lblSubCredpoints4.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubCredpoints4.setForeground(new java.awt.Color(255, 255, 255));
        lblSubCredpoints4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubCredpoints4.setText("None");

        javax.swing.GroupLayout jpSubject4Layout = new javax.swing.GroupLayout(jpSubject4);
        jpSubject4.setLayout(jpSubject4Layout);
        jpSubject4Layout.setHorizontalGroup(
            jpSubject4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubject4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblSubNo4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(cmbSubCode4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSubName4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(cmbCredHrs4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(txtSubMark4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(lblSubGrade4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(lblSubCredpoints4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jpSubject4Layout.setVerticalGroup(
            jpSubject4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubject4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSubject4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubNo4)
                    .addComponent(cmbSubCode4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubName4)
                    .addComponent(cmbCredHrs4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubMark4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubGrade4)
                    .addComponent(lblSubCredpoints4))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jpSubject5.setBackground(new java.awt.Color(50, 50, 50));

        lblSubNo5.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubNo5.setForeground(new java.awt.Color(255, 255, 255));
        lblSubNo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubNo5.setText("5");

        cmbSubCode5.setBackground(new java.awt.Color(208, 208, 208));
        cmbSubCode5.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        cmbSubCode5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subject Code...", "CCSB2113", "CISB3433", "CISB4233", "CISB4413", "CSEB4123" }));
        cmbSubCode5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSubCode5ActionPerformed(evt);
            }
        });

        lblSubName5.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubName5.setForeground(new java.awt.Color(255, 255, 255));
        lblSubName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubName5.setText("No Subject Selected");

        cmbCredHrs5.setBackground(new java.awt.Color(208, 208, 208));
        cmbCredHrs5.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        cmbCredHrs5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cmbCredHrs5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCredHrs5ActionPerformed(evt);
            }
        });

        txtSubMark5.setBackground(new java.awt.Color(255, 11, 85));
        txtSubMark5.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        txtSubMark5.setForeground(new java.awt.Color(255, 255, 255));
        txtSubMark5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblSubGrade5.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubGrade5.setForeground(new java.awt.Color(255, 255, 255));
        lblSubGrade5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubGrade5.setText("No Grade");

        lblSubCredpoints5.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubCredpoints5.setForeground(new java.awt.Color(255, 255, 255));
        lblSubCredpoints5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubCredpoints5.setText("None");

        javax.swing.GroupLayout jpSubject5Layout = new javax.swing.GroupLayout(jpSubject5);
        jpSubject5.setLayout(jpSubject5Layout);
        jpSubject5Layout.setHorizontalGroup(
            jpSubject5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubject5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblSubNo5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(cmbSubCode5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSubName5, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(cmbCredHrs5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(txtSubMark5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(lblSubGrade5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblSubCredpoints5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jpSubject5Layout.setVerticalGroup(
            jpSubject5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubject5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSubject5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubNo5)
                    .addComponent(cmbSubCode5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubName5)
                    .addComponent(cmbCredHrs5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubMark5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubGrade5)
                    .addComponent(lblSubCredpoints5))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jpResults.setBackground(new java.awt.Color(50, 50, 50));

        lblTotCredHrs.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblTotCredHrs.setForeground(new java.awt.Color(255, 255, 255));
        lblTotCredHrs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotCredHrs.setText("Total Credit Hours");

        lblCumCredpoints.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblCumCredpoints.setForeground(new java.awt.Color(255, 255, 255));
        lblCumCredpoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCumCredpoints.setText("Cummulative Credit Points");

        lblAcademicStatus.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblAcademicStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblAcademicStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAcademicStatus.setText("Academic Status");

        lblSubRetake.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblSubRetake.setForeground(new java.awt.Color(255, 255, 255));
        lblSubRetake.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubRetake.setText("Subject To Retake");

        lblDisplay_TotCHrs.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblDisplay_TotCHrs.setForeground(new java.awt.Color(255, 255, 255));
        lblDisplay_TotCHrs.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDisplay_TotCHrs.setText("0 Hrs");

        lblDisplay_CumcPts.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblDisplay_CumcPts.setForeground(new java.awt.Color(255, 255, 255));
        lblDisplay_CumcPts.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDisplay_CumcPts.setText("0 Points");

        lblDisplay_AcademicStat.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblDisplay_AcademicStat.setForeground(new java.awt.Color(255, 255, 255));
        lblDisplay_AcademicStat.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDisplay_AcademicStat.setText("No Status");

        spTotalCredHrs.setForeground(new java.awt.Color(255, 255, 255));

        spCumCredPts.setForeground(new java.awt.Color(255, 255, 255));

        spAcademicStat.setForeground(new java.awt.Color(255, 255, 255));

        spSubRetake.setForeground(new java.awt.Color(255, 255, 255));

        lblGPA_Result.setFont(new java.awt.Font("Tw Cen MT", 0, 100)); // NOI18N
        lblGPA_Result.setForeground(new java.awt.Color(255, 11, 85));
        lblGPA_Result.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGPA_Result.setText("0.00");

        lblGPA.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        lblGPA.setForeground(new java.awt.Color(255, 11, 85));
        lblGPA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGPA.setText("GPA");

        btnSubtoretake_check.setBackground(new java.awt.Color(214, 29, 78));
        btnSubtoretake_check.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        btnSubtoretake_check.setForeground(new java.awt.Color(255, 255, 255));
        btnSubtoretake_check.setText("Check");
        btnSubtoretake_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubtoretake_checkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpResultsLayout = new javax.swing.GroupLayout(jpResults);
        jpResults.setLayout(jpResultsLayout);
        jpResultsLayout.setHorizontalGroup(
            jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpResultsLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCumCredpoints)
                    .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpResultsLayout.createSequentialGroup()
                            .addComponent(lblTotCredHrs, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDisplay_TotCHrs, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(spTotalCredHrs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblDisplay_CumcPts, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpResultsLayout.createSequentialGroup()
                                .addComponent(lblSubRetake)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSubtoretake_check, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpResultsLayout.createSequentialGroup()
                                .addComponent(lblAcademicStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                .addComponent(lblDisplay_AcademicStat, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spAcademicStat)
                            .addComponent(spSubRetake)
                            .addComponent(spCumCredPts))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpResultsLayout.createSequentialGroup()
                        .addComponent(lblGPA)
                        .addGap(283, 283, 283))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpResultsLayout.createSequentialGroup()
                        .addComponent(lblGPA_Result, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
            .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpResultsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jpResultsLayout.setVerticalGroup(
            jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpResultsLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpResultsLayout.createSequentialGroup()
                        .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotCredHrs)
                            .addComponent(lblDisplay_TotCHrs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spTotalCredHrs, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDisplay_CumcPts)
                            .addComponent(lblCumCredpoints))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spCumCredPts, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDisplay_AcademicStat)
                            .addComponent(lblAcademicStatus)))
                    .addComponent(lblGPA_Result, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpResultsLayout.createSequentialGroup()
                        .addComponent(lblGPA)
                        .addGap(40, 40, 40))
                    .addGroup(jpResultsLayout.createSequentialGroup()
                        .addComponent(spAcademicStat, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubRetake)
                            .addComponent(btnSubtoretake_check))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(spSubRetake, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
            .addGroup(jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpResultsLayout.createSequentialGroup()
                    .addGap(0, 121, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 121, Short.MAX_VALUE)))
        );

        lblDisplaySem.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        lblDisplaySem.setForeground(new java.awt.Color(51, 51, 51));
        lblDisplaySem.setText("Semester 1 2022/2023");

        btnAddsubject5.setBackground(new java.awt.Color(51, 51, 51));
        btnAddsubject5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAddsubject5.setForeground(new java.awt.Color(255, 255, 255));
        btnAddsubject5.setText("+");
        btnAddsubject5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddsubject5ActionPerformed(evt);
            }
        });

        btnDelsubject5.setBackground(new java.awt.Color(51, 51, 51));
        btnDelsubject5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDelsubject5.setForeground(new java.awt.Color(255, 255, 255));
        btnDelsubject5.setText("-");
        btnDelsubject5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelsubject5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpSubjectTableLayout = new javax.swing.GroupLayout(jpSubjectTable);
        jpSubjectTable.setLayout(jpSubjectTableLayout);
        jpSubjectTableLayout.setHorizontalGroup(
            jpSubjectTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubjectTableLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jpSubjectTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpSubject1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpSubjectheader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpSubject2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpSubject3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpSubject4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpSubject5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpSubjectTableLayout.createSequentialGroup()
                        .addComponent(lblSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDisplaySem, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddsubject5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelsubject5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addComponent(jpResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpSubjectTableLayout.setVerticalGroup(
            jpSubjectTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSubjectTableLayout.createSequentialGroup()
                .addGroup(jpSubjectTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSubjectTableLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jpSubjectTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDisplaySem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSubjectTableLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpSubjectTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddsubject5)
                            .addComponent(btnDelsubject5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpSubjectheader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpSubject1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpSubject2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpSubject3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpSubject4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpSubject5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jpResults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnCalculate.setBackground(new java.awt.Color(255, 11, 85));
        btnCalculate.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        btnCalculate.setForeground(new java.awt.Color(255, 255, 255));
        btnCalculate.setText("Calculate");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 11, 85));
        btnReset.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpMainBackgroundLayout = new javax.swing.GroupLayout(jpMainBackground);
        jpMainBackground.setLayout(jpMainBackgroundLayout);
        jpMainBackgroundLayout.setHorizontalGroup(
            jpMainBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpMainBackgroundLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jpMainBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpSubjectTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpMainBackgroundLayout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalculate)))
                .addGap(35, 35, 35))
        );
        jpMainBackgroundLayout.setVerticalGroup(
            jpMainBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainBackgroundLayout.createSequentialGroup()
                .addComponent(jpHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jpSubjectTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jpMainBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnCalculate))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMainBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMainBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSubCode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSubCode1ActionPerformed
        subject_code = String.valueOf(cmbSubCode1.getSelectedItem());
        subject_name = myGPA.getSubjectName(subject_code);
        lblSubName1.setText(subject_name);
        if(subject_code.equalsIgnoreCase("Subject Code..."))
        {
            subjectName1 = String.valueOf(lblSubName1.getText());
            txtSubMark1.setEnabled(false);
            cmbCredHrs1.setEnabled(false);
            txtSubMark1.setText("");
            lblSubGrade1.setText("No Grade");
            lblSubCredpoints1.setText("None");
            cmbCredHrs1.setSelectedItem("1");
        }
        else
        {
            subjectName1 = String.valueOf(lblSubName1.getText());
            if(subjectName1.equals(subjectName2) || subjectName1.equals(subjectName3) || 
                        subjectName1.equals(subjectName4) || subjectName1.equals(subjectName5))
                {
                    JOptionPane.showMessageDialog(this,"Subject name cannot be the same","Error Name [Subject 1]", JOptionPane.ERROR_MESSAGE);
                    cmbSubCode1.setSelectedItem("Subject Code...");
                    lblSubName1.setText("No Subject Selected");
                    txtSubMark1.setEnabled(false);
                    cmbCredHrs1.setEnabled(false);
                    txtSubMark1.setText("");
                    lblSubGrade1.setText("No Grade");
                    lblSubCredpoints1.setText("None");
                    cmbCredHrs1.setSelectedItem("1");
                    calcsub1 = false;
                    lblDisplay_TotCHrs.setText("0 Hrs");
                    lblDisplay_CumcPts.setText("0 Points");
                    lblGPA_Result.setText("0.00");
                    lblDisplay_AcademicStat.setText("No Status");
                    hideSubtoRetake();
                }
                else
                {
                    txtSubMark1.setEnabled(true);
                    cmbCredHrs1.setEnabled(true);
                }
        }
    }//GEN-LAST:event_cmbSubCode1ActionPerformed

    private void cmbSubCode2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSubCode2ActionPerformed
        subject_code = String.valueOf(cmbSubCode2.getSelectedItem());
        subject_name = myGPA.getSubjectName(subject_code);
        lblSubName2.setText(subject_name);
        if(subject_code.equalsIgnoreCase("Subject Code..."))
        {
            subjectName2 = String.valueOf(lblSubName2.getText());
            txtSubMark2.setEnabled(false);
            cmbCredHrs2.setEnabled(false);
            txtSubMark2.setText("");
            lblSubGrade2.setText("No Grade");
            lblSubCredpoints2.setText("None");
            cmbCredHrs2.setSelectedItem("1");
        }
        else
        {
            subjectName2 = String.valueOf(lblSubName2.getText());
            if(subjectName2.equals(subjectName1) || subjectName2.equals(subjectName3) || 
                        subjectName2.equals(subjectName4) || subjectName2.equals(subjectName5))
                {
                    JOptionPane.showMessageDialog(this,"Subject name cannot be the same","Error Name [Subject 2]", JOptionPane.ERROR_MESSAGE);
                    cmbSubCode2.setSelectedItem("Subject Code...");
                    lblSubName2.setText("No Subject Selected");
                    txtSubMark2.setEnabled(false);
                    cmbCredHrs2.setEnabled(false);
                    txtSubMark2.setText("");
                    lblSubGrade2.setText("No Grade");
                    lblSubCredpoints2.setText("None");
                    cmbCredHrs2.setSelectedItem("1");
                    calcsub2 = false;
                    lblDisplay_TotCHrs.setText("0 Hrs");
                    lblDisplay_CumcPts.setText("0 Points");
                    lblGPA_Result.setText("0.00");
                    lblDisplay_AcademicStat.setText("No Status");
                    hideSubtoRetake();
                }
                else
                {
                    txtSubMark2.setEnabled(true);
                    cmbCredHrs2.setEnabled(true);
                }
        }
    }//GEN-LAST:event_cmbSubCode2ActionPerformed

    private void cmbSubCode3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSubCode3ActionPerformed
        subject_code = String.valueOf(cmbSubCode3.getSelectedItem());
        subject_name = myGPA.getSubjectName(subject_code);
        lblSubName3.setText(subject_name);
        if(subject_code.equalsIgnoreCase("Subject Code..."))
        {
            subjectName3 = String.valueOf(lblSubName3.getText());
            txtSubMark3.setEnabled(false);
            cmbCredHrs3.setEnabled(false);
            txtSubMark3.setText("");
            lblSubGrade3.setText("No Grade");
            lblSubCredpoints3.setText("None");
            cmbCredHrs3.setSelectedItem("1");
        }
        else
        {
            subjectName3 = String.valueOf(lblSubName3.getText());
            if(subjectName3.equals(subjectName1) || subjectName3.equals(subjectName2) || 
                        subjectName3.equals(subjectName4) || subjectName3.equals(subjectName5))
                {
                    JOptionPane.showMessageDialog(this,"Subject name cannot be the same","Error Name [Subject 3]", JOptionPane.ERROR_MESSAGE);
                    cmbSubCode3.setSelectedItem("Subject Code...");
                    lblSubName3.setText("No Subject Selected");
                    txtSubMark3.setEnabled(false);
                    cmbCredHrs3.setEnabled(false);
                    txtSubMark3.setText("");
                    lblSubGrade3.setText("No Grade");
                    lblSubCredpoints3.setText("None");
                    cmbCredHrs3.setSelectedItem("1");
                    calcsub3 = false;
                    lblDisplay_TotCHrs.setText("0 Hrs");
                    lblDisplay_CumcPts.setText("0 Points");
                    lblGPA_Result.setText("0.00");
                    lblDisplay_AcademicStat.setText("No Status");
                    hideSubtoRetake();
                }
                else
                {
                    txtSubMark3.setEnabled(true);
                    cmbCredHrs3.setEnabled(true);
                }
        }
    }//GEN-LAST:event_cmbSubCode3ActionPerformed

    private void cmbSubCode4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSubCode4ActionPerformed
        subject_code = String.valueOf(cmbSubCode4.getSelectedItem());
        subject_name = myGPA.getSubjectName(subject_code);
        lblSubName4.setText(subject_name);
        if(subject_code.equalsIgnoreCase("Subject Code..."))
        {
            subjectName4 = String.valueOf(lblSubName4.getText());
            txtSubMark4.setEnabled(false);
            cmbCredHrs4.setEnabled(false);
            txtSubMark4.setText("");
            lblSubGrade4.setText("No Grade");
            lblSubCredpoints4.setText("None");
            cmbCredHrs4.setSelectedItem("1");
        }
        else
        {
            subjectName4 = String.valueOf(lblSubName4.getText());
            if(subjectName4.equals(subjectName1) || subjectName4.equals(subjectName2) || 
                        subjectName4.equals(subjectName3) || subjectName4.equals(subjectName5))
                {
                    JOptionPane.showMessageDialog(this,"Subject name cannot be the same","Error Name [Subject 4]", JOptionPane.ERROR_MESSAGE);
                    cmbSubCode4.setSelectedItem("Subject Code...");
                    lblSubName4.setText("No Subject Selected");
                    txtSubMark4.setEnabled(false);
                    cmbCredHrs4.setEnabled(false);
                    txtSubMark4.setText("");
                    lblSubGrade4.setText("No Grade");
                    lblSubCredpoints4.setText("None");
                    cmbCredHrs4.setSelectedItem("1");
                    calcsub4 = false;
                    lblDisplay_TotCHrs.setText("0 Hrs");
                    lblDisplay_CumcPts.setText("0 Points");
                    lblGPA_Result.setText("0.00");
                    lblDisplay_AcademicStat.setText("No Status");
                    hideSubtoRetake();
                }
                else
                {
                    txtSubMark4.setEnabled(true);
                    cmbCredHrs4.setEnabled(true);
                }
        }
    }//GEN-LAST:event_cmbSubCode4ActionPerformed

    private void cmbSubCode5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSubCode5ActionPerformed
        subject_code = String.valueOf(cmbSubCode5.getSelectedItem());
        subject_name = myGPA.getSubjectName(subject_code);
        lblSubName5.setText(subject_name);
        if(subject_code.equalsIgnoreCase("Subject Code..."))
        {
            subjectName5 = String.valueOf(lblSubName5.getText());
            txtSubMark5.setEnabled(false);
            cmbCredHrs5.setEnabled(false);
            txtSubMark5.setText("");
            lblSubGrade5.setText("No Grade");
            lblSubCredpoints5.setText("None");
            cmbCredHrs5.setSelectedItem("1");
        }
        else
        {
            subjectName5 = String.valueOf(lblSubName5.getText());
            if(subjectName5.equals(subjectName1) || subjectName5.equals(subjectName2) || 
                        subjectName5.equals(subjectName3) || subjectName5.equals(subjectName4))
                {
                    JOptionPane.showMessageDialog(this,"Subject name cannot be the same","Error Name [Subject 5]", JOptionPane.ERROR_MESSAGE);
                    cmbSubCode5.setSelectedItem("Subject Code...");
                    lblSubName5.setText("No Subject Selected");
                    txtSubMark5.setEnabled(false);
                    cmbCredHrs5.setEnabled(false);
                    txtSubMark5.setText("");
                    lblSubGrade5.setText("No Grade");
                    lblSubCredpoints5.setText("None");
                    cmbCredHrs5.setSelectedItem("1");
                    calcsub5 = false;
                    lblDisplay_TotCHrs.setText("0 Hrs");
                    lblDisplay_CumcPts.setText("0 Points");
                    lblGPA_Result.setText("0.00");
                    lblDisplay_AcademicStat.setText("No Status");
                    hideSubtoRetake();
                }
                else
                {
                    txtSubMark5.setEnabled(true);
                    cmbCredHrs5.setEnabled(true);
                }
        }
    }//GEN-LAST:event_cmbSubCode5ActionPerformed

    private void cmbSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSemesterActionPerformed
        semester = String.valueOf(cmbSemester.getSelectedItem());
        if(semester.equalsIgnoreCase("Select Semester..."))
        {
            eligibleSemester= false;
        }
        else
        {
            eligibleSemester = true;
            lblDisplaySem.setText(myGPA.getSemester(semester));
            setSemester();  
            activateSubCode();
        }    
    }//GEN-LAST:event_cmbSemesterActionPerformed

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        ////////////////////////Calculate subject grade & credit points/////////////////////////////////////////////////
        ///Check selected semester eligibility
        if(eligibleSemester==false)
        {
            JOptionPane.showMessageDialog(this,"Select a semester first","Error Semester", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
        //Get Subject 1 marks & display (grade & credit points)//
            subject_code = String.valueOf(cmbSubCode1.getSelectedItem());
            if(subject_code.equalsIgnoreCase("Subject Code..."))
            {
                JOptionPane.showMessageDialog(this,"Please select a subject first","Error Name [Subject 1]", JOptionPane.ERROR_MESSAGE);
                calcsub1 = false;
            }
            else
            {
                try
                    {
                        marks = Integer.parseInt(txtSubMark1.getText());
                        if(marks>=0 && marks<=100)
                        {
                            myGPA.setInitialLowestmark(marks);
                            grade = myGPA.getSubjectGrade(marks);
                            lblSubGrade1.setText(String.valueOf(grade));
                            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs1.getSelectedItem()));
                            credit_points = myGPA.calculateCreditPoints(credit_hour);
                            lblSubCredpoints1.setText(String.valueOf(credit_points));
                            calcsub1 = true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this,"Marks must be between 0 to 100 only","Error Mark [Subject 1]", JOptionPane.ERROR_MESSAGE);
                            txtSubMark1.setText("");
                            lblSubGrade1.setText("No Grade");
                            lblSubCredpoints1.setText("None");
                            calcsub1 = false;
                            lblDisplay_TotCHrs.setText("0 Hrs");
                            lblDisplay_CumcPts.setText("0 Points");
                            lblGPA_Result.setText("0.00");
                            lblDisplay_AcademicStat.setText("No Status");
                            hideSubtoRetake();
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(this,"Marks must be integer only", "Error Mark [Subject 1]", JOptionPane.ERROR_MESSAGE );
                        txtSubMark1.setText("");
                        lblSubGrade1.setText("No Grade");
                        lblSubCredpoints1.setText("None");
                        calcsub1 = false;
                        lblDisplay_TotCHrs.setText("0 Hrs");
                        lblDisplay_CumcPts.setText("0 Points");
                        lblGPA_Result.setText("0.00");
                        lblDisplay_AcademicStat.setText("No Status");
                        hideSubtoRetake();
                    }
            }
        //Get Subject 2 marks & display (grade & credit points)//
        subject_code = String.valueOf(cmbSubCode2.getSelectedItem());
        if(subject_code.equalsIgnoreCase("Subject Code..."))
        {
            JOptionPane.showMessageDialog(this,"Please select a subject first","Error Name [Subject 2]", JOptionPane.ERROR_MESSAGE);
            calcsub2 = false;
        }
        else
        {
            
            
        try
        {
            marks = Integer.parseInt(txtSubMark2.getText());
        if(marks>=0 && marks<=100)
       {
            myGPA.setLowestMarks(marks);
            grade = myGPA.getSubjectGrade(marks);
            lblSubGrade2.setText(String.valueOf(grade));
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs2.getSelectedItem()));
            credit_points = myGPA.calculateCreditPoints(credit_hour);
            lblSubCredpoints2.setText(String.valueOf(credit_points));
            calcsub2 = true;
       }
       else
       {
            JOptionPane.showMessageDialog(this,"Marks must be between 0 to 100 only","Error Mark [Subject 2]", JOptionPane.ERROR_MESSAGE);
            txtSubMark2.setText("");
            lblSubGrade2.setText("No Grade");
            lblSubCredpoints2.setText("None");
            calcsub2 = false;
            lblDisplay_TotCHrs.setText("0 Hrs");
            lblDisplay_CumcPts.setText("0 Points");
            lblGPA_Result.setText("0.00");
            lblDisplay_AcademicStat.setText("No Status");
            hideSubtoRetake();
       }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Marks must be integer only", "Error Mark [Subject 2]", JOptionPane.ERROR_MESSAGE );
            txtSubMark2.setText("");
            lblSubGrade2.setText("No Grade");
            lblSubCredpoints2.setText("None");
            calcsub2 = false;
            lblDisplay_TotCHrs.setText("0 Hrs");
            lblDisplay_CumcPts.setText("0 Points");
            lblGPA_Result.setText("0.00");
            lblDisplay_AcademicStat.setText("No Status");
            hideSubtoRetake();
        }
        }
        //Get Subject 3 marks & display (grade & credit points)//
        subject_code = String.valueOf(cmbSubCode3.getSelectedItem());
        if(subject_code.equalsIgnoreCase("Subject Code..."))
        {
            JOptionPane.showMessageDialog(this,"Please select a subject first","Error Name [Subject 3]", JOptionPane.ERROR_MESSAGE);
            calcsub3 = false;
        }
        else
        {
        try
        {
            marks = Integer.parseInt(txtSubMark3.getText());
        if(marks>=0 && marks<=100)
       {
            myGPA.setLowestMarks(marks);
            grade = myGPA.getSubjectGrade(marks);
            lblSubGrade3.setText(String.valueOf(grade));
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs3.getSelectedItem()));
            credit_points = myGPA.calculateCreditPoints(credit_hour);
            lblSubCredpoints3.setText(String.valueOf(credit_points));
            calcsub3 = true;
       }
       else
       {
            JOptionPane.showMessageDialog(this,"Marks must be between 0 to 100 only","Error Mark [Subject 3]", JOptionPane.ERROR_MESSAGE);
            txtSubMark3.setText("");
            lblSubGrade3.setText("No Grade");
            lblSubCredpoints3.setText("None");
            calcsub3 = false;
            lblDisplay_TotCHrs.setText("0 Hrs");
            lblDisplay_CumcPts.setText("0 Points");
            lblGPA_Result.setText("0.00");
            lblDisplay_AcademicStat.setText("No Status");
            hideSubtoRetake();
       }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Marks must be integer only", "Error Mark [Subject 3]", JOptionPane.ERROR_MESSAGE );
            txtSubMark3.setText("");
            lblSubGrade3.setText("No Grade");
            lblSubCredpoints3.setText("None");
            calcsub3 = false;
            lblDisplay_TotCHrs.setText("0 Hrs");
            lblDisplay_CumcPts.setText("0 Points");
            lblGPA_Result.setText("0.00");
            lblDisplay_AcademicStat.setText("No Status");
            hideSubtoRetake();
        }
        }
        //Get Subject 4 marks & display (grade & credit points)//
        subject_code = String.valueOf(cmbSubCode4.getSelectedItem());
        if(subject_code.equalsIgnoreCase("Subject Code..."))
        {
            JOptionPane.showMessageDialog(this,"Please select a subject first","Error Name [Subject 4]", JOptionPane.ERROR_MESSAGE);
            calcsub4 = false;
        }
        else
        {
        try
        {
            marks = Integer.parseInt(txtSubMark4.getText());
        if(marks>=0 && marks<=100)
       {
            myGPA.setLowestMarks(marks);
            grade = myGPA.getSubjectGrade(marks);
            lblSubGrade4.setText(String.valueOf(grade));
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs4.getSelectedItem()));
            credit_points = myGPA.calculateCreditPoints(credit_hour);
            lblSubCredpoints4.setText(String.valueOf(credit_points));
            calcsub4 = true;
       }
       else
       {
            JOptionPane.showMessageDialog(this,"Marks must be between 0 to 100 only","Error Mark [Subject 4]", JOptionPane.ERROR_MESSAGE);
            txtSubMark4.setText("");
            lblSubGrade4.setText("No Grade");
            lblSubCredpoints4.setText("None");
            calcsub4 = false;
            lblDisplay_TotCHrs.setText("0 Hrs");
            lblDisplay_CumcPts.setText("0 Points");
            lblGPA_Result.setText("0.00");
            lblDisplay_AcademicStat.setText("No Status");
            hideSubtoRetake();
       }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Marks must be integer only", "Error Mark [Subject 4]", JOptionPane.ERROR_MESSAGE );
            txtSubMark4.setText("");
            lblSubGrade4.setText("No Grade");
            lblSubCredpoints4.setText("None");
            calcsub4 = false;
            lblDisplay_TotCHrs.setText("0 Hrs");
            lblDisplay_CumcPts.setText("0 Points");
            lblGPA_Result.setText("0.00");
            lblDisplay_AcademicStat.setText("No Status");
            hideSubtoRetake();
        }
        }
        //Get Subject 5 marks & display (grade & credit points)//
        if(subject5 == true)
        {
            subject_code = String.valueOf(cmbSubCode5.getSelectedItem());
        if(subject_code.equalsIgnoreCase("Subject Code..."))
        {
            JOptionPane.showMessageDialog(this,"Please select a subject first","Error Name [Subject 5]", JOptionPane.ERROR_MESSAGE);
            calcsub5 = false;
        }
        else
        {
        try
        {
            marks = Integer.parseInt(txtSubMark5.getText());
        if(marks>=0 && marks<=100)
       {
            myGPA.setLowestMarks(marks);
            grade = myGPA.getSubjectGrade(marks);
            lblSubGrade5.setText(String.valueOf(grade));
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs5.getSelectedItem()));
            credit_points = myGPA.calculateCreditPoints(credit_hour);
            lblSubCredpoints5.setText(String.valueOf(credit_points));
            calcsub5 = true;
       }
       else
       {
            JOptionPane.showMessageDialog(this,"Marks must be between 0 to 100 only","Error Mark [Subject 5]", JOptionPane.ERROR_MESSAGE);
            txtSubMark5.setText("");
            lblSubGrade5.setText("No Grade");
            lblSubCredpoints5.setText("None");
            calcsub5 = false;
            lblDisplay_TotCHrs.setText("0 Hrs");
            lblDisplay_CumcPts.setText("0 Points");
            lblGPA_Result.setText("0.00");
            lblDisplay_AcademicStat.setText("No Status");
            hideSubtoRetake();
       }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Marks must be integer only", "Error Mark [Subject 5]", JOptionPane.ERROR_MESSAGE );
            txtSubMark5.setText("");
            lblSubGrade5.setText("No Grade");
            lblSubCredpoints5.setText("None");
            calcsub5 = false;
            lblDisplay_TotCHrs.setText("0 Hrs");
            lblDisplay_CumcPts.setText("0 Points");
            lblGPA_Result.setText("0.00");
            lblDisplay_AcademicStat.setText("No Status");
            hideSubtoRetake();
        }
        }
        }
        
        ////////////////////////////////////End of Calculation////////////////////////////////////////////////////
        
        ///////////////////////////////////Calculate Total Credit Hours////////////////////////////////////////////////
        
        if(calcsub1 == true && calcsub2 == true && calcsub3 == true && calcsub4 == true && calcsub5 == true)
        {
            ///Input Subject 1 Credit Hour////
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs1.getSelectedItem()));
            myGPA.calculateTotalCreditHour(credit_hour);
        
            ///Input Subject 2 Credit Hour////
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs2.getSelectedItem()));
            myGPA.calculateTotalCreditHour(credit_hour);
        
            ///Input Subject 3 Credit Hour////
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs3.getSelectedItem()));
            myGPA.calculateTotalCreditHour(credit_hour);
        
            ///Input Subject 4 Credit Hour////
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs4.getSelectedItem()));
            myGPA.calculateTotalCreditHour(credit_hour);
        
            ///Input Subject 5 Credit Hour////
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs5.getSelectedItem()));
            myGPA.calculateTotalCreditHour(credit_hour);
        
            ///Display Total Credit Hour///
            total_chrs = myGPA.getTotalCreditHour();
            lblDisplay_TotCHrs.setText(String.valueOf(total_chrs + " Hrs"));
            myGPA.resetTotalCreditHour();
        }
        else if(calcsub1 == true && calcsub2 == true && calcsub3 == true && calcsub4 == true && noCalculate == false)
        {
            ///Input Subject 1 Credit Hour////
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs1.getSelectedItem()));
            myGPA.calculateTotalCreditHour(credit_hour);
        
            ///Input Subject 2 Credit Hour////
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs2.getSelectedItem()));
            myGPA.calculateTotalCreditHour(credit_hour);
        
            ///Input Subject 3 Credit Hour////
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs3.getSelectedItem()));
            myGPA.calculateTotalCreditHour(credit_hour);
        
            ///Input Subject 4 Credit Hour////
            credit_hour = Integer.parseInt(String.valueOf(cmbCredHrs4.getSelectedItem()));
            myGPA.calculateTotalCreditHour(credit_hour);
            
            ///Display Total Credit Hour///
            total_chrs = myGPA.getTotalCreditHour();
            lblDisplay_TotCHrs.setText(String.valueOf(total_chrs + " Hrs"));
            myGPA.resetTotalCreditHour();
        }
        ////////////////////////////////////End of Calculation////////////////////////////////////////////////////
        
        ///////////////////////////Calculate Cummulative Credit Points////////////////////////////////////////////////
        /////For 5 Subjects/////
        if(calcsub1 == true && calcsub2 == true && calcsub3 == true && calcsub4 == true && calcsub5 == true)
        {
            ///Input Subject 1 Credit Point//
            credit_points = Integer.parseInt(String.valueOf(lblSubCredpoints1.getText()));
            myGPA.calculateCummulativeCredPts(credit_points);
            
            ///Input Subject 2 Credit Point//
            credit_points = Integer.parseInt(String.valueOf(lblSubCredpoints2.getText()));
            myGPA.calculateCummulativeCredPts(credit_points);
            
            ///Input Subject 3 Credit Point//
            credit_points = Integer.parseInt(String.valueOf(lblSubCredpoints3.getText()));
            myGPA.calculateCummulativeCredPts(credit_points);
            
            ///Input Subject 4 Credit Point//
            credit_points = Integer.parseInt(String.valueOf(lblSubCredpoints4.getText()));
            myGPA.calculateCummulativeCredPts(credit_points);
            
            ///Input Subject 5 Credit Point//
            credit_points = Integer.parseInt(String.valueOf(lblSubCredpoints5.getText()));
            myGPA.calculateCummulativeCredPts(credit_points);
           
            //Display Cummulative Credit Points///
            cum_cpts = myGPA.getCummulativeCredPts();
            lblDisplay_CumcPts.setText(String.valueOf(cum_cpts + " Points"));
            myGPA.resetCummulativeCredPts();
        }
        ////For 4 Subjects/////
        else if(calcsub1 == true && calcsub2 == true && calcsub3 == true && calcsub4 == true && noCalculate == false)
        {
            ///Input Subject 1 Credit Point//
            credit_points = Integer.parseInt(String.valueOf(lblSubCredpoints1.getText()));
            myGPA.calculateCummulativeCredPts(credit_points);
            
            ///Input Subject 2 Credit Point//
            credit_points = Integer.parseInt(String.valueOf(lblSubCredpoints2.getText()));
            myGPA.calculateCummulativeCredPts(credit_points);
            
            ///Input Subject 3 Credit Point//
            credit_points = Integer.parseInt(String.valueOf(lblSubCredpoints3.getText()));
            myGPA.calculateCummulativeCredPts(credit_points);
            
            ///Input Subject 4 Credit Point//
            credit_points = Integer.parseInt(String.valueOf(lblSubCredpoints4.getText()));
            myGPA.calculateCummulativeCredPts(credit_points);
            
            //Display Cummulative Credit Points///
            cum_cpts = myGPA.getCummulativeCredPts();
            lblDisplay_CumcPts.setText(String.valueOf(cum_cpts + " Points"));
            myGPA.resetCummulativeCredPts();
        } 
        
        ////////////////////////////////////End of Calculation////////////////////////////////////////////////////
        
        /////////////////////////////////////////Calculate GPA//////////////////////////////////////////////////////
        /////For 5 Subjects//////
        if(calcsub1 == true && calcsub2 == true && calcsub3 == true && calcsub4 == true && calcsub5 == true)
        {
            gpa = myGPA.calculateGPA(total_chrs, cum_cpts);
            lblGPA_Result.setText(String.valueOf(DF.format(gpa)));
            myGPA.resetCummulativeCredPts();
            myGPA.resetTotalCreditHour();
        }
        /////For 4  Subjects/////
        else if(calcsub1 == true && calcsub2 == true && calcsub3 == true && calcsub4 == true && noCalculate == false)
        {
            gpa = myGPA.calculateGPA(total_chrs, cum_cpts);
            lblGPA_Result.setText(String.valueOf(DF.format(gpa)));
            myGPA.resetCummulativeCredPts();
            myGPA.resetTotalCreditHour();
        }
        
        ////////////////////////////////////End of Calculation////////////////////////////////////////////////////
        
        /////////////////////////////////////Get Academic Status///////////////////////////////////////////////////
        /////For 5 subjects/////
        if(calcsub1 == true && calcsub2 == true && calcsub3 == true && calcsub4 == true && calcsub5 == true)
        {
            academic_status = myGPA.getAcademicStatus(gpa);
            lblDisplay_AcademicStat.setText(academic_status);
        }
        /////For 4 Subjects/////
        else if(calcsub1 == true && calcsub2 == true && calcsub3 == true && calcsub4 == true && noCalculate == false)
        {
            academic_status = myGPA.getAcademicStatus(gpa);
            lblDisplay_AcademicStat.setText(academic_status);
        }
        ////////////////////////////////////End of Calculation////////////////////////////////////////////////////
        
        /////////////////////////////////////Get Subject to Retake///////////////////////////////////////////////////
        ///For 5 Subjects
        if(calcsub1 == true && calcsub2 == true && calcsub3 == true && calcsub4 == true && calcsub5 == true)
        {
            if(academic_status.equalsIgnoreCase("Poor"))
            {
                //Get All Subject Marks
            subjectMark1 = Integer.parseInt(txtSubMark1.getText());
            subjectMark2 = Integer.parseInt(txtSubMark2.getText());
            subjectMark3 = Integer.parseInt(txtSubMark3.getText());
            subjectMark4 = Integer.parseInt(txtSubMark4.getText());
            subjectMark5 = Integer.parseInt(txtSubMark5.getText());
        
            //Get All Subject Name
            subjectName1 = String.valueOf(lblSubName1.getText());
            subjectName2 = String.valueOf(lblSubName2.getText());
            subjectName3 = String.valueOf(lblSubName3.getText());
            subjectName4 = String.valueOf(lblSubName4.getText());
            subjectName5 = String.valueOf(lblSubName5.getText());
        
            //Find location of lowest marks & the subject to retake
            lowest_mark = myGPA.getLowestMarks();
        if(lowest_mark==subjectMark1)
        {
            addOn = String.valueOf(subjectName1);
            sub_retake.add(addOn);
        }
        if(lowest_mark==subjectMark2)
        {
            addOn = String.valueOf(subjectName2);
            sub_retake.add(addOn);
        }
        if(lowest_mark==subjectMark3)
        {
            addOn = String.valueOf(subjectName3);
            sub_retake.add(addOn);
        }
        if(lowest_mark==subjectMark4)
        {
            addOn = String.valueOf(subjectName4);
            sub_retake.add(addOn);
        }
        if(lowest_mark==subjectMark5)
        {
            addOn = String.valueOf(subjectName5);
            sub_retake.add(addOn);
        }
        saveSubtoretake = sub_retake.toString();
        sub_retake = new StringJoiner("\n-> ");
        JOptionPane.showMessageDialog(this,"Student is advised to retake these subject(s):\n-> "
                +saveSubtoretake, "Poor Academic Status", JOptionPane.INFORMATION_MESSAGE);
        showSubtoRetake();
        }
            else
            {
                hideSubtoRetake();
            }
        }
            
        /////For 4  Subjects/////
        else if(calcsub1 == true && calcsub2 == true && calcsub3 == true && calcsub4 == true && noCalculate == false)
        {
            if(academic_status.equalsIgnoreCase("Poor"))
            {
                //Get All Subject Marks except subject 5
            subjectMark1 = Integer.parseInt(txtSubMark1.getText());
            subjectMark2 = Integer.parseInt(txtSubMark2.getText());
            subjectMark3 = Integer.parseInt(txtSubMark3.getText());
            subjectMark4 = Integer.parseInt(txtSubMark4.getText());
            
        
            //Get All Subject Name except subject 5
            subjectName1 = String.valueOf(lblSubName1.getText());
            subjectName2 = String.valueOf(lblSubName2.getText());
            subjectName3 = String.valueOf(lblSubName3.getText());
            subjectName4 = String.valueOf(lblSubName4.getText());
        
            //Find location of lowest marks & the subject to retake
            lowest_mark = myGPA.getLowestMarks();
        if(lowest_mark==subjectMark1)
        {
            addOn = String.valueOf(subjectName1);
            sub_retake.add(addOn);
        }
        if(lowest_mark==subjectMark2)
        {
            addOn = String.valueOf(subjectName2);
            sub_retake.add(addOn);
        }
        if(lowest_mark==subjectMark3)
        {
            addOn = String.valueOf(subjectName3);
            sub_retake.add(addOn);
        }
        if(lowest_mark==subjectMark4)
        {
            addOn = String.valueOf(subjectName4);
            sub_retake.add(addOn);
        }
        saveSubtoretake = sub_retake.toString();
        sub_retake = new StringJoiner("\n-> ");
        JOptionPane.showMessageDialog(this,"Student is advised to retake these subject(s):\n-> "
                +saveSubtoretake, "Poor Academic Status", JOptionPane.INFORMATION_MESSAGE);
        showSubtoRetake();
            }
            else
            {
                hideSubtoRetake();
            }  
        }
        }
        ////////////////////////////////////End of Calculation////////////////////////////////////////////////////
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void cmbCredHrs1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCredHrs1ActionPerformed
        txtSubMark1.setText("");
        lblSubGrade1.setText("No Grade");
        lblSubCredpoints1.setText("None");
        lblDisplay_TotCHrs.setText("0 Hrs");
        lblDisplay_CumcPts.setText("0 Points");
        lblGPA_Result.setText("0.00");
        lblDisplay_AcademicStat.setText("No Status");
        hideSubtoRetake();
    }//GEN-LAST:event_cmbCredHrs1ActionPerformed

    private void cmbCredHrs2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCredHrs2ActionPerformed
        txtSubMark2.setText("");
        lblSubGrade2.setText("No Grade");
        lblSubCredpoints2.setText("None");
        lblDisplay_TotCHrs.setText("0 Hrs");
        lblDisplay_CumcPts.setText("0 Points");
        lblGPA_Result.setText("0.00");
        lblDisplay_AcademicStat.setText("No Status");
        hideSubtoRetake();
    }//GEN-LAST:event_cmbCredHrs2ActionPerformed

    private void cmbCredHrs3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCredHrs3ActionPerformed
        txtSubMark3.setText("");
        lblSubGrade3.setText("No Grade");
        lblSubCredpoints3.setText("None");
        lblDisplay_TotCHrs.setText("0 Hrs");
        lblDisplay_CumcPts.setText("0 Points");
        lblGPA_Result.setText("0.00");
        lblDisplay_AcademicStat.setText("No Status");
        hideSubtoRetake();
    }//GEN-LAST:event_cmbCredHrs3ActionPerformed

    private void cmbCredHrs4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCredHrs4ActionPerformed
        txtSubMark4.setText("");
        lblSubGrade4.setText("No Grade");
        lblSubCredpoints4.setText("None");
        lblDisplay_TotCHrs.setText("0 Hrs");
        lblDisplay_CumcPts.setText("0 Points");
        lblGPA_Result.setText("0.00");
        lblDisplay_AcademicStat.setText("No Status");
        hideSubtoRetake();
    }//GEN-LAST:event_cmbCredHrs4ActionPerformed

    private void cmbCredHrs5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCredHrs5ActionPerformed
        txtSubMark5.setText("");
        lblSubGrade5.setText("No Grade");
        lblSubCredpoints5.setText("None");
        lblDisplay_TotCHrs.setText("0 Hrs");
        lblDisplay_CumcPts.setText("0 Points");
        lblGPA_Result.setText("0.00");
        lblDisplay_AcademicStat.setText("No Status");
        hideSubtoRetake();
    }//GEN-LAST:event_cmbCredHrs5ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetResponse = JOptionPane.showConfirmDialog(this,"Do you want to reset?","Reset", JOptionPane.YES_NO_OPTION);
        if(resetResponse==JOptionPane.YES_OPTION)
        {
            resetAll();  
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnDelsubject5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelsubject5ActionPerformed
        deleteSubject5();
    }//GEN-LAST:event_btnDelsubject5ActionPerformed

    private void btnAddsubject5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddsubject5ActionPerformed
        addSubject5();
    }//GEN-LAST:event_btnAddsubject5ActionPerformed

    private void btnSubtoretake_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubtoretake_checkActionPerformed
        JOptionPane.showMessageDialog(this,"Student is advised to retake these subject(s):\n-> "
                +saveSubtoretake, "Poor Academic Status", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSubtoretake_checkActionPerformed

    private void cmbThemesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbThemesActionPerformed
        theme = String.valueOf(cmbThemes.getSelectedItem());
        if(theme.equalsIgnoreCase("Dark Theme"))
        {
            darkTheme();
        }
        else if(theme.equalsIgnoreCase("Light Theme"))
        {
            lightTheme();
        }
        else if(theme.equalsIgnoreCase("Sky Theme"))
        {
            skyTheme();
        }
        else if(theme.equalsIgnoreCase("Modern Theme"))
        {
            modernTheme();
        }
    }//GEN-LAST:event_cmbThemesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GPA_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GPA_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GPA_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GPA_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GPA_Calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddsubject5;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnDelsubject5;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubtoretake_check;
    private javax.swing.JComboBox<String> cmbCredHrs1;
    private javax.swing.JComboBox<String> cmbCredHrs2;
    private javax.swing.JComboBox<String> cmbCredHrs3;
    private javax.swing.JComboBox<String> cmbCredHrs4;
    private javax.swing.JComboBox<String> cmbCredHrs5;
    private javax.swing.JComboBox<String> cmbSemester;
    private javax.swing.JComboBox<String> cmbSubCode1;
    private javax.swing.JComboBox<String> cmbSubCode2;
    private javax.swing.JComboBox<String> cmbSubCode3;
    private javax.swing.JComboBox<String> cmbSubCode4;
    private javax.swing.JComboBox<String> cmbSubCode5;
    private javax.swing.JComboBox<String> cmbThemes;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JPanel jpMainBackground;
    private javax.swing.JPanel jpResults;
    private javax.swing.JPanel jpSubject1;
    private javax.swing.JPanel jpSubject2;
    private javax.swing.JPanel jpSubject3;
    private javax.swing.JPanel jpSubject4;
    private javax.swing.JPanel jpSubject5;
    private javax.swing.JPanel jpSubjectTable;
    private javax.swing.JPanel jpSubjectheader;
    private javax.swing.JLabel lblAcademicStatus;
    private javax.swing.JLabel lblCredithrs;
    private javax.swing.JLabel lblCreditpoint;
    private javax.swing.JLabel lblCumCredpoints;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblDisplaySem;
    private javax.swing.JLabel lblDisplay_AcademicStat;
    private javax.swing.JLabel lblDisplay_CumcPts;
    private javax.swing.JLabel lblDisplay_TotCHrs;
    private javax.swing.JLabel lblGPA;
    private javax.swing.JLabel lblGPA_Result;
    private javax.swing.JLabel lblSemester;
    private javax.swing.JLabel lblSubCredpoints1;
    private javax.swing.JLabel lblSubCredpoints2;
    private javax.swing.JLabel lblSubCredpoints3;
    private javax.swing.JLabel lblSubCredpoints4;
    private javax.swing.JLabel lblSubCredpoints5;
    private javax.swing.JLabel lblSubGrade1;
    private javax.swing.JLabel lblSubGrade2;
    private javax.swing.JLabel lblSubGrade3;
    private javax.swing.JLabel lblSubGrade4;
    private javax.swing.JLabel lblSubGrade5;
    private javax.swing.JLabel lblSubName1;
    private javax.swing.JLabel lblSubName2;
    private javax.swing.JLabel lblSubName3;
    private javax.swing.JLabel lblSubName4;
    private javax.swing.JLabel lblSubName5;
    private javax.swing.JLabel lblSubNo1;
    private javax.swing.JLabel lblSubNo2;
    private javax.swing.JLabel lblSubNo3;
    private javax.swing.JLabel lblSubNo4;
    private javax.swing.JLabel lblSubNo5;
    private javax.swing.JLabel lblSubRetake;
    private javax.swing.JLabel lblSubjectNo;
    private javax.swing.JLabel lblSubjectcode;
    private javax.swing.JLabel lblSubjectgrade;
    private javax.swing.JLabel lblSubjectmark;
    private javax.swing.JLabel lblSubjectname;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotCredHrs;
    private javax.swing.JSeparator spAcademicStat;
    private javax.swing.JSeparator spCumCredPts;
    private javax.swing.JSeparator spSubRetake;
    private javax.swing.JSeparator spTotalCredHrs;
    private javax.swing.JTextField txtSubMark1;
    private javax.swing.JTextField txtSubMark2;
    private javax.swing.JTextField txtSubMark3;
    private javax.swing.JTextField txtSubMark4;
    private javax.swing.JTextField txtSubMark5;
    // End of variables declaration//GEN-END:variables
}
