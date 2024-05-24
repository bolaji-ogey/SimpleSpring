/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class PGDataRetriever {
    
   private   static  final   PGDataSource   pgDataSource  = PGDataSource.getInstance();
    
    private  static  PGDataRetriever   dataRetrieverx; 
    
    
    public static  PGDataRetriever  getInstance()
    {
        if (dataRetrieverx == null)
        {
            synchronized (PGDataRetriever.class)
            {
                dataRetrieverx = new PGDataRetriever();
            } 
        }
        return   dataRetrieverx;
    }
   
    
    private   PGDataRetriever(){}
    
    
    public  static  void  main(String[]  args){ 
      
        Connection cron   =  null;
         try{
             pgDataSource.getConnect();
         }catch(Exception ex){
             ex.printStackTrace();
         }
         System.out.println("cron  ==> "+cron);
    }
    
    
    /***
      private  static String   convertDateOfBirth(String  inDateOfBirth){
          String[]  procDateOfBirth =  null;
          String  newDateOfBirth =  "";
          if(inDateOfBirth.contains("/")){
              procDateOfBirth =  inDateOfBirth.split("/");
              StringBuilder   sb =  new StringBuilder();
              sb.append(procDateOfBirth[2]).append("-").append(procDateOfBirth[0]).append("-").append(procDateOfBirth[1]);
              newDateOfBirth =  sb.toString();
          }
          
          if(inDateOfBirth.contains("-")){
              procDateOfBirth =  inDateOfBirth.split("-");
              StringBuilder   sb =  new StringBuilder();
              sb.append(procDateOfBirth[2]).append("-").append(procDateOfBirth[0]).append("-").append(procDateOfBirth[1]);
              newDateOfBirth =  sb.toString();
          }
          return  newDateOfBirth;
      }
    
      
      
       
   private        int    getCount(String  query,   String inFilter){
         
           PreparedStatement  prepStmnt =    null; 
           ResultSet rs = null; 
           int count  = 0;
           Connection  cron   =  null;
            
           try {  
  
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
              
                prepStmnt =    cron.prepareStatement(query);
                 
                if(inFilter != null && !inFilter.isEmpty()){                    
                    prepStmnt.setString(1, inFilter);
                }
                
                 
               rs =  prepStmnt.executeQuery();
                // Parameters start with 1
                while (rs.next()) {
                    
                   count =  rs.getInt("c");                      
                    
                }  
                
              //  custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               query = null;
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(rs != null){
                        rs.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
           return   count;
       }
       
       
    
   
  private    int    getCountWithParams(String  query,   String[] inFilterParams){
         
           PreparedStatement  prepStmnt =    null; 
           ResultSet rs = null; 
           int count  = 0;
           Connection  cron   =  null;
            
           try {  
  
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
              
                prepStmnt =    cron.prepareStatement(query);
                 
                if(inFilterParams != null && inFilterParams.length > 0){
                   for(int v = 0; v < inFilterParams.length; v++) {                   
                      prepStmnt.setString(v + 1, inFilterParams[v]);
                   }
                }
                
                 
               rs =  prepStmnt.executeQuery();
                // Parameters start with 1
                while (rs.next()) {
                    
                   count =  rs.getInt("c");                      
                    
                }  
                
              //  custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               query = null;
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(rs != null){
                        rs.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
           return   count;
       }
    
    
    
    
    
  public     FetchStudentDetailResp    getStudentDetail(String inStudentMatric){
         
           StringBuilder   sbQuery = new StringBuilder(150);
           PreparedStatement    prepStmnt =    null; 
           ResultSet rs = null;
           FetchStudentDetailResp   fetchStudentDetailResp =   new FetchStudentDetailResp();
           StudentDetailData   studentDetailData =   null;
           Connection  cron   = null;
           FailedResp    failedResp  =  null;
            
           try { 
               
                sbQuery.append(" SELECT   u.matric_no as matric_no,  u.firstname as firstname,  u.middlename as middlename,   ");
                sbQuery.append("   u.lastname as lastname,   u.session as session,  u.std_level as std_level,  ");
                sbQuery.append("  p.p_code as programme_code, u.programme as programme, u.phone as phone,  ");
                sbQuery.append("  u.email as email,  u.dob as dateOfBirth, f.f_code as faculty_code,  ");
                sbQuery.append("    u.faculty as faculty,  d.d_code as dept_code,   u.department  as dept FROM    ");
                sbQuery.append("  users  u   LEFT OUTER JOIN   programme  p  on  (p.programme  = u.programme)   ");

                sbQuery.append("  LEFT OUTER JOIN    department   d  on (d.department  =  u.department)      ");
                sbQuery.append("  LEFT OUTER JOIN    faculty   f     on (f.faculty  =  u.department)  ");
 
                sbQuery.append("  WHERE  u.matric_no =  ?   AND   u.admission_status  = 'approved'  ");

 
              
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
                
                prepStmnt =    cron.prepareStatement(sbQuery.toString());
                
                if(inStudentMatric != null && !inStudentMatric.isEmpty()){
                    prepStmnt.setString(1, inStudentMatric);
                }
              
                        
                rs = prepStmnt.executeQuery();
                  
                        // Parameters start with 1
                        while (rs.next()) {

                            studentDetailData =  new StudentDetailData();

                            studentDetailData.setMatriculationNumber(rs.getString("matric_no"));
                            studentDetailData.setFirstName(rs.getString("firstname"));
                            studentDetailData.setMiddleName(rs.getString("middlename"));
                            studentDetailData.setLastName(rs.getString("lastname"));
                            studentDetailData.setCurrentSession(rs.getString("session"));
                            studentDetailData.setCurrentLevel(rs.getString("std_level"));

                            studentDetailData.setProgramOfStudyCode(rs.getString("programme_code"));
                            studentDetailData.setProgramOfStudyName(rs.getString("programme"));
                            studentDetailData.setPhoneNumber(rs.getString("phone"));
                            studentDetailData.setEmailAddress(rs.getString("email"));
                            studentDetailData.setDateOfBirth(convertDateOfBirth(rs.getString("dateOfBirth")));

                            studentDetailData.setFacultyCode(rs.getString("faculty_code"));                    
                            studentDetailData.setFacultyName(rs.getString("faculty"));

                           // studentDetailData.setGender(rs.getString("-"));
                            studentDetailData.setDepartmentName(rs.getString("department"));
                            studentDetailData.setDepartmentCode(rs.getString("dept_code"));

                        } 
                
                    studentDetailData.setStudentType("FullTime");
                    fetchStudentDetailResp.setData(studentDetailData);  
                    
                    fetchStudentDetailResp.setResponseCode(200);
                    fetchStudentDetailResp.setResponseMessage("Successful");
                
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(rs != null){
                        rs.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) { 
                      fetchStudentDetailResp.setResponseCode(300);
                     fetchStudentDetailResp.setResponseMessage("Error while processing request"); 
                    ex.printStackTrace();
                }
            } 
           return   fetchStudentDetailResp;
       }
     
  
  
       
   public     FetchStudentSchoolFeesResp    getStudentFeeDetails(String  inMatricNo){
         
           StringBuilder   sbQuery = new StringBuilder(150);
           PreparedStatement    prepStmnt =    null; 
           ResultSet rs = null;
           FetchStudentSchoolFeesResp   fetchStudentSchoolFeesResp =   new FetchStudentSchoolFeesResp();
         //  StudentFeeData[]   studentFeeData =   null;
           StudentFee[]    studentFee  =  null;
           int v = 0;
           Connection  cron   = null;
             
           try { 
                  
               sbQuery.append("  SELECT   t.tuition_id  as fee_id, t.faculty as faculty,  ");  
               sbQuery.append("    t.department  as  department,  t.programme  as  programme,   "); 
               sbQuery.append("  t.level as level,  t.semester  as  semester,  t.session as  session,   "); 
               sbQuery.append("   t.tuition  as  tuition  FROM   tuition  t  LEFT OUTER JOIN  users u     "); 
               sbQuery.append("   on (t.programme =  u.programme)   WHERE   u.matric_no =  ? "); 
               
                cron   =  pgDataSource.getConnection();                
                System.out.println("cron = "+cron);
              
                prepStmnt =    cron.prepareStatement(sbQuery.toString());
                
                if(inMatricNo != null && !inMatricNo.isEmpty()){
                    prepStmnt.setString(1, inMatricNo);
                }
              
                 
                rs = prepStmnt.executeQuery();
                  
                    // Parameters start with 1
                    while (rs.next()) {

                          studentFee  =  new StudentFee[1];
                          studentFee[v] =  new StudentFee();

                          studentFee[v].setMatriculationNumber(inMatricNo);
                          studentFee[v].setFeeid(rs.getString("fee_id"));
                          studentFee[v].setAmount(rs.getString("tuition"));
                          studentFee[v].setProgramOfStudyName(rs.getString("programme"));  
                          studentFee[v].setSession(rs.getString("session"));
                          
                          v = v + 1;
                    } 
                
                    StudentFeeData   studentFeeData  =  new  StudentFeeData();
                    studentFeeData.setFees(studentFee);
                    fetchStudentSchoolFeesResp.setData(studentFeeData);  
                    
                    fetchStudentSchoolFeesResp.setResponseCode(200);
                    fetchStudentSchoolFeesResp.setResponseMessage("Successful");
                    
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(rs != null){
                        rs.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) { 
                      fetchStudentSchoolFeesResp.setResponseCode(300);
                     fetchStudentSchoolFeesResp.setResponseMessage("Error while processing request"); 
                    ex.printStackTrace();
                }
            } 
           return   fetchStudentSchoolFeesResp;
       }
     
   
   
    
   public     FetchSchoolFacultiesResp    getFaculties(){
         
          StringBuilder   sbQuery = new StringBuilder(150);
           PreparedStatement    prepStmnt =    null; 
           ResultSet rs = null;
           FetchSchoolFacultiesResp   fetchSchoolFacultiesResp =   new FetchSchoolFacultiesResp();
           ArrayList<Faculty>   faculties =   new ArrayList<>(); 
            Connection  cron   = null;
            
           try { 
                 
               String  query =  " SELECT   faculty, f_code FROM  faculty   "; 
              
                 cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
              
                prepStmnt =    cron.prepareStatement(query);
                 
                rs = prepStmnt.executeQuery();
                   
                    while (rs.next()) {

                        Faculty   faculty =  new Faculty();

                        faculty.setName(rs.getString("faculty"));
                        faculty.setCode(rs.getString("f_code"));  

                        faculties.add(faculty);
                    } 
                
                
                    fetchSchoolFacultiesResp.setData((Faculty[])faculties.toArray());  
                    
                    fetchSchoolFacultiesResp.setResponseCode(200);
                    fetchSchoolFacultiesResp.setResponseMessage("Successful");
                    
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(rs != null){
                        rs.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) { 
                      fetchSchoolFacultiesResp.setResponseCode(300);
                     fetchSchoolFacultiesResp.setResponseMessage("Error while processing request"); 
                    ex.printStackTrace();
                }
            } 
           return   fetchSchoolFacultiesResp;
       }
     
            
            
    public     FetchSchoolDeptResp    getDepartmentByFacultyCode(String inFacultyCode){
         
           PreparedStatement    prepStmnt =    null; 
           ResultSet rs = null;
           FetchSchoolDeptResp   fetchSchoolDeptResp =   new FetchSchoolDeptResp();
           ArrayList<Department>   departments =   new  ArrayList<>();
           Connection  cron   =  null;
            
           try { 
                
                String  query =  " SELECT   department, d_code FROM  department  WHERE  f_code  =  ?  ";  
  
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
              
                prepStmnt =    cron.prepareStatement(query);
                                 
                prepStmnt.setString(1, inFacultyCode);
                
                rs = prepStmnt.executeQuery();
                  
                // Parameters start with 1
                while (rs.next()) {
                    
                   Department department =  new Department();
                    
                    department.setName(rs.getString("department"));
                    department.setCode(rs.getString("d_code"));                      
                    
                   departments.add(department);
                } 
                
                fetchSchoolDeptResp.setData((Department[])departments.toArray());  

                fetchSchoolDeptResp.setResponseCode(200);
                fetchSchoolDeptResp.setResponseMessage("Successful");
                
                //custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(rs != null){
                        rs.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) { 
                      fetchSchoolDeptResp.setResponseCode(300);
                     fetchSchoolDeptResp.setResponseMessage("Error while processing request"); 
                    ex.printStackTrace();
                }
            } 
           return   fetchSchoolDeptResp;
       }
     
    
           
   public     FetchCourseOfStudyListByDeptResp    getCourseOfStudyByDepartmentCode(String inDeptCode){
         
           Statement    stmnt =    null; 
           PreparedStatement    prepStmnt =    null;
           ResultSet rs = null;
           FetchCourseOfStudyListByDeptResp   fetchCourseOfStudyListByDeptResp =   null;
           ArrayList<CourseOfStudy>   courseOfStudies =   new  ArrayList<>();
           Connection  cron   =   null;
            
           try { 
                
                String  query1 =  " SELECT   programme, p_code FROM  programme  WHERE  d_code  =  ?  ";  
  
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
                 
              //  stmnt =    cron.createStatement();
                prepStmnt =  cron.prepareStatement(query1);
                
                prepStmnt.setString(1, inDeptCode);
                                  
              //  rs = stmnt.executeQuery(String.format(query1,   inDeptCode));
                rs = prepStmnt.executeQuery();
          
                // Parameters start with 1
                while (rs.next()) {
                     
                    CourseOfStudy   courseOfStudy  =  new CourseOfStudy();
                    
                    courseOfStudy.setName(rs.getString("programme"));
                    courseOfStudy.setCode(rs.getString("p_code"));                      
                    
                    courseOfStudies.add(courseOfStudy);
                } 
                
                fetchCourseOfStudyListByDeptResp.setData((CourseOfStudy[])courseOfStudies.toArray());  

                fetchCourseOfStudyListByDeptResp.setResponseCode(200);
                fetchCourseOfStudyListByDeptResp.setResponseMessage("Successful");
                
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     
                    if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(rs != null){
                        rs.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
           return   fetchCourseOfStudyListByDeptResp;
       }
    
    
    
             
   public     FetchActiveSessionResp    getActiveAcdemicSession(){
         
           Statement    stmnt =    null;  
           ResultSet rs = null;
           FetchActiveSessionResp   fetchActiveSessionResp =   new  FetchActiveSessionResp();
           ActiveSessionData   activeSession  = new  ActiveSessionData();
           ArrayList<SchoolSession>    schoolSessions  =  new  ArrayList<>();
           StringBuilder   sbQuery  =  new  StringBuilder(200);
            Connection  cron   =   null;
            
           try { 
                
               sbQuery.append( " SELECT   academic_year_id,   commencement_date, session    FROM   academic_year ");
               sbQuery.append(" WHERE  academic_year_id  =  (SELECT  MAX(academic_year_id)   FROM  academic_year) ");  
  
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
                   
                stmnt =  cron.createStatement(); 
                rs = stmnt.executeQuery(sbQuery.toString());
          
                // Parameters start with 1
                while (rs.next()) {
                     
                   SchoolSession  schoolSession   =  new SchoolSession();
                    
                   schoolSession.setSessionId(rs.getLong("academic_year_id"));
                   schoolSession.setSession(rs.getString("session"));  
                   schoolSession.setStartDate(rs.getString("commencement_date")); 
                   
                   schoolSessions.add(schoolSession);                     
                } 
                
                activeSession.setSessions((SchoolSession[])schoolSessions.toArray()); 
                fetchActiveSessionResp.setData(activeSession);

                fetchActiveSessionResp.setResponseCode(200);
                fetchActiveSessionResp.setResponseMessage("Successful");
                
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     
                    if(stmnt !=  null){
                        stmnt.cancel();
                        stmnt.close();
                    }
                    
                    if(rs != null){
                        rs.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) { 
                      fetchActiveSessionResp.setResponseCode(300);
                     fetchActiveSessionResp.setResponseMessage("Error while processing request");  
                    ex.printStackTrace();
                }
            } 
           return   fetchActiveSessionResp;
       }           
              
    
     
   
   
            
   public     FetchStudentResultResp    getStudentResult(String[]    inParameters){
         
           Statement    stmnt =    null; 
           PreparedStatement    prepStmnt =    null;
           StringBuilder  sbQuery =  new  StringBuilder(300);
           ResultSet rs = null;
           FetchStudentResultResp   fetchStudentResultResp =   new FetchStudentResultResp();
           StudentResultData   studentResultData =   new  StudentResultData();
           StudentResultSheet[]     resultSheet  =  new StudentResultSheet[1];
           ArrayList<CoursesTaken>     coursesTakents  =  new  ArrayList<>(); 
           Connection  cron   =   null;
            
           try { 
                
               sbQuery.append("SELECT  course_title,  programme, points, score,   grade   FROM   result_upload   ");
               sbQuery.append("  WHERE  matric_no   =  ?   AND  session =  ?  AND semester = ? ");
  
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
                 
              //  stmnt =    cron.createStatement();
                prepStmnt =  cron.prepareStatement(sbQuery.toString());
                
                if(inParameters != null && inParameters.length > 0){
                   for(int r = 0; r < inParameters.length; r++) {                   
                      prepStmnt.setString(r + 1, inParameters[r]);
                   }
                }
                                  
              //  rs = stmnt.executeQuery(String.format(query1,   inDeptCode));
                rs = prepStmnt.executeQuery();
          
                // Parameters start with 1
                while (rs.next()) {
                     
                   CoursesTaken coursesTaken  =  new CoursesTaken();
                    
                    coursesTaken.setCourse(rs.getString("course_title"));
                    coursesTaken.setGrade(rs.getString("grade"));    
                    coursesTaken.setPoint(rs.getString("points"));    
                    coursesTaken.setMarkScored(rs.getString("score"));    
                    
                    coursesTakents.add(coursesTaken);
                } 
                
                resultSheet[0] = new  StudentResultSheet();
                resultSheet[0].setCourses((CoursesTaken[])coursesTakents.toArray());
                studentResultData.setResultSheet(resultSheet);
                fetchStudentResultResp.setData(studentResultData);

                fetchStudentResultResp.setResponseCode(200);
                fetchStudentResultResp.setResponseMessage("Successful");
                
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{  
                 try{
                     sbQuery = null;
                    if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(rs != null){
                        rs.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) {
                    fetchStudentResultResp   =   new  FetchStudentResultResp();
                    fetchStudentResultResp.setResponseCode(300);
                    fetchStudentResultResp.setResponseMessage("Error while processing request");
                    ex.printStackTrace();
                }
            } 
           return   fetchStudentResultResp;
       }
   
   
   
   
   
     
  public     FetchStaffResp    getStaffDetail(String    inStaffId){
         
           StringBuilder   sbQuery = new StringBuilder(150);
           PreparedStatement    prepStmnt =    null; 
           ResultSet rs = null;
           FetchStaffResp   fetchStaffResp =   new FetchStaffResp();
           StaffRespData   staffRespData =   null;
           Connection  cron   = null;
           FailedResp    failedResp  =  null;
            
           try { 
                 
           
                sbQuery.append(" SELECT   username,  firstname,  middlename,  lastname    FROM "); 
               sbQuery.append("   admins   WHERE    username =  ?    AND   remark  = 'active'  ");  
              
              
                cron   =  pgDataSource.getConnect();                
                System.out.println("cron = "+cron);
                
                prepStmnt =    cron.prepareStatement(sbQuery.toString());
                
                if(inStaffId != null && !inStaffId.isEmpty()){
                    prepStmnt.setString(1, inStaffId);
                }
              
                        
                rs = prepStmnt.executeQuery();
                  
                        // Parameters start with 1
                        while (rs.next()) {

                            staffRespData =  new StaffRespData();

                            staffRespData.setStaffId(rs.getString("username"));
                            staffRespData.setFirstName(rs.getString("firstname"));
                            staffRespData.setMiddleName(rs.getString("middlename"));
                           // staffRespData.setGender(rs.getString("-"));
                            staffRespData.setLastName(rs.getString("lastname"));
                           // staffRespData.setPhoneNumber(rs.getString("-"));
                           // staffRespData.setEmailAddress(rs.getString("-"));

                          //  staffRespData.setDateOfBirth(rs.getString("-")); 

                           // staffRespData.setFacultyCode(rs.getString("faculty_code"));                    
                           // staffRespData.setFacultyName(rs.getString("faculty"));

                           // studentDetailData.setGender(rs.getString("-"));
                          //  staffRespData.setDepartmentName(rs.getString("department"));
                           // staffRespData.setDepartmentCode(rs.getString("dept_code"));
                            
                            staffRespData.setStaffType(rs.getString("role"));

                        } 
                
                    staffRespData.setStaffType("FullTime");
                    fetchStaffResp.setData(staffRespData);  
                    
                    fetchStaffResp.setResponseCode(200);
                    fetchStaffResp.setResponseMessage("Successful");
                
               // custPool.closePoolConnection(identKey); 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{
                     if(prepStmnt !=  null){
                        prepStmnt.cancel();
                        prepStmnt.close();
                    }
                    
                    if(rs != null){
                        rs.close();
                    } 
                    if(cron != null){
                        cron.close();
                    }
                } catch (Exception ex) { 
                      fetchStaffResp.setResponseCode(300);
                     fetchStaffResp.setResponseMessage("Error while processing request"); 
                    ex.printStackTrace();
                }
            } 
           return   fetchStaffResp;
       }
  
  
  ****/
  
  
              
}
