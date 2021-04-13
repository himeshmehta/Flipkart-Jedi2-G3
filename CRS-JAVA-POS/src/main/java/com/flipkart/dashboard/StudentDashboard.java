package com.flipkart.dashboard;

import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
import com.flipkart.constants.BankEnum;
import com.flipkart.constants.PaymentMode;
import com.flipkart.dao.StudentDB;
import com.flipkart.services.CourseRegistrationServices;
import com.flipkart.services.GradeCardServices;
import com.flipkart.services.PaymentServices;

import java.util.*;
import java.util.logging.Logger;

/**
 * The type studentDashboard
 */
public class StudentDashboard {
    Student student;
    CourseRegistrationServices courseRegistrationServices;
    PaymentServices paymentServices;
    StudentDB studentDB;
    GradeCardServices gradeCardServices;
    private static final Logger logger = Logger.getLogger(String.valueOf(com.flipkart.dashboard.StudentDashboard.class));

    /**
     * Constructor of studentDashboard
     * @param student
     */
    public StudentDashboard(Student student) {
        this.student = student;
        courseRegistrationServices = new CourseRegistrationServices();
        this.studentDB = new StudentDB();
        this.paymentServices = new PaymentServices();
        this.gradeCardServices = new GradeCardServices();
    }

    /**
     * This method is used for course registration
     * @param courseId
     * @return boolean
     */
    public Boolean registerCourse(Integer courseId) {
        try {
            return courseRegistrationServices.registerCourse(student, courseId);
        } catch (CourseRegistrationException ex) {
            ex.printStackTrace();
            return Boolean.FALSE;
        }
    }

    /**
     * This method is used to get the list of courses
     * @return
     */
    public List<Course> viewCourses() {
        try {
            return courseRegistrationServices.viewCourses();
        } catch (CourseRegistrationException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * This method is used to remove  course for student
     * @param courseId
     * @return
     */
    public Boolean removeCourse(Integer courseId) {
        try {
            return courseRegistrationServices.removeCourse(student, courseId);
        } catch (CourseRegistrationException ex) {
            ex.printStackTrace();
            return Boolean.FALSE;
        }
    }

    /**
     * This method is used to get the list of registered courses
     * @return list of courses
     */
    public List<Course> getRegisteredCourses() {
        return studentDB.registeredCourses(student);
    }

    /**
     * This method is to view the list of courses for which payment is not done
     * @param studentId
     * @param inputReader
     */
    private void getPaymentRemainingCourse(int studentId,Scanner inputReader) {
        try {
            HashMap<Integer,Integer> courseToFee = courseRegistrationServices.getNotPaidCourseList(studentId);
            if(courseToFee == null || courseToFee.isEmpty()){
                System.out.println("No payment is Due");
                return ;
            }
            int totalFeeRemaining = 0;
            System.out.println("List of courses for which payment is not done yet.");
            System.out.println("courseId  fee");
            for(Integer courseId : courseToFee.keySet()){
                System.out.println(courseId+"  "+courseToFee.get(courseId));
                totalFeeRemaining += courseToFee.get(courseId);
            }

            System.out.println("select courses for which you want to pay fee.\nEnter 0 to pay total fee OR Enter courseId in new line and enter -1 to stop.");
            int totalAmount = 0;
            Set<Integer> payingCoursesId = new HashSet<>(); // set of courses selected to pay fee
            int courseId = inputReader.nextInt();
            while(courseId !=-1){
                if(courseId == 0){
                    totalAmount = totalFeeRemaining;
                    payingCoursesId = courseToFee.keySet();
                    break;
                }
                totalAmount += courseToFee.get(courseId);
                payingCoursesId.add(courseId);
                courseId = inputReader.nextInt();
            }
            if(totalAmount == 0){
                System.out.println("Total amount is 0, So no payment requires.Exiting.");
                return;
            }

            System.out.println("Select payment mode.\n 1 --> CREDIT \n 2 --> DEBIT \n 3 --> OFFLINE \n -1 --> To cancel payment");
            int paymentMode = inputReader.nextInt();

            if(paymentMode == -1){
                System.out.println("Aborting payment");
                return ;
            }

            PaymentMode mode = getPaymentModeFromIndex(paymentMode);

            if(PaymentMode.OFFLINE.equals(mode)){
                System.out.println("Select bank to do offline payment.\n 1 --> SBI \n 2 --> HDFC \n -1 --> To cancel payment");
                int bankIndex = inputReader.nextInt();

                if(bankIndex == -1) {
                    System.out.println("Aborting Payment");
                    return ;
                }
                BankEnum bankEnumName = getBankNameFromIndex(bankIndex);
                String description = "payment for registered courses through " + bankEnumName.toString() + " bank.";
                paymentServices.makeOfflinePayment(description, bankEnumName,studentId,payingCoursesId);

            } else {
                System.out.println("Enter card number");
                String card_number = inputReader.next();

                System.out.println("Enter name on card.Separate first name and last name with underscore.");
                String name_on_card = inputReader.next();

                System.out.println("Enter CVV.");
                String cvv = inputReader.next();

                String description = "Payment for registered courses through online with " + mode.toString() + " card.";
                paymentServices.makeOnlinePayment(description,card_number,name_on_card,cvv,mode,studentId,payingCoursesId);
            }
            System.out.println("Payment was successful.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Payment was not successful.");
        }
    }


    /**
     * This method is used to get the bank name
     * @param bankIndex
     * @return
     */
    private BankEnum getBankNameFromIndex(int bankIndex) {
        BankEnum bankEnumName = null;
        switch (bankIndex){
            case 1:
                bankEnumName = BankEnum.SBI;
                break;
            case 2:
                bankEnumName = BankEnum.HDFC;
                break;
            default:
                bankEnumName = BankEnum.OTHER;
                break;
        }
        return bankEnumName;
    }

    /**
     * This method is used to get the payment mode
     * @param paymentMode
     * @return
     */
    private PaymentMode getPaymentModeFromIndex(int paymentMode) {
        PaymentMode mode = null;
        switch (paymentMode){
            case 1:
                mode = PaymentMode.CREDITCARD;
                break;
            case 2:
                mode = PaymentMode.DEBITCARD;
                break;
            case 3:
                mode = PaymentMode.OFFLINE;
                break;
        }
        return mode;
    }

    /**
     * This method is used to perform student operations
     */
    public void helper() {


        Scanner scanner = new Scanner(System.in);
        Integer courseId;
        Boolean response;
        String message;

        while(true) {
            showMenu();
            int operation = scanner.nextInt();

            try {
                switch (operation) {
                    case 1:
                        logger.info("Enter the Course ID");
                        courseId = scanner.nextInt();
                        response = registerCourse(courseId);
                        message = response ? "Registration Successful" : "Registration failed";
                        logger.info(message);
                        break;
                    case 2:
                        logger.info("Enter the Course ID");
                        courseId = scanner.nextInt();
                        response = removeCourse(courseId);
                        message = response ? "Course removed Successfully" : "Course removal failed";
                        logger.info(message);
                        break;
                    case 3:
                        List<Course> list = viewCourses();
                        message = "Fetching Course";
                        logger.info(message);
                        System.out.println("ID Name Fee ProfID");
                        for (Course course : list) {
                            message = course.getCourseId() + "  " + course.getCourseName() + "   " + course.getFee() + " " + course.getProfessorId();
                            System.out.println(message);
                        }
                        System.out.println();
                        break;
                    case 4:
                        List<Course> courseList = getRegisteredCourses();
                        System.out.println("Enrolled Courses : ");
                        System.out.println("ID Name Fee ProfID");
                        for (Course course : courseList) {
                            message = course.getCourseId() + "  " + course.getCourseName() + "   " + course.getFee() + " " + course.getProfessorId();
                            System.out.println(message);
                        }
                        break;
                    case 5:
                        getPaymentRemainingCourse(student.getUserId(),scanner);
                        break;
                    case 6:
                        viewGradeCard(student.getUserId());
                    default:
                        break;
                }

                if(operation == 7){
                    // Exit from student dashboard
                    break;
                }
            } catch (Exception ex){
                logger.info(ex.getMessage());
                System.out.println("An error occurred in last operation, Do you want to continue? Enter YES or NO." );
                String yesOrNo = scanner.next();
                if ("NO".equals(yesOrNo)){
                    break;
                }
            }
        }
    }

    /**
     * This method is used to view grade card
     * @param studentId
     */
    private void viewGradeCard(int studentId) {
        try {
            GradeCard gradeCard = gradeCardServices.viewGradeCard(studentId);
            Map<Integer,Integer> courseToMark = gradeCard.getCourseMarks();

            if(courseToMark == null || courseToMark.isEmpty()){
                System.out.println(" Grade card not available");
                return;
            }
            System.out.println("###-- GRADE CARD --###\n");
            System.out.println("courseId   Marks");
            for(Integer courseId : courseToMark.keySet()){
                System.out.println(courseId + "          " + courseToMark.get(courseId));
            }
            System.out.println("\n");
        } catch(Exception ex){
            System.out.println("Grade card not fetched successfully");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method is used to show the list of operations
     */
    private void showMenu() {
        System.out.println("Menu for student dashboard :- ");
        System.out.println("1. Register for Course.");
        System.out.println("2. Remove course.");
        System.out.println("3. View Courses");
        System.out.println("4. Get list of enrolled courses.");
        System.out.println("5. Pay Fee.");
        System.out.println("6. View Grade card");
        System.out.println("7. Exit");
        System.out.println("\n\n");
        System.out.println("Enter operation id");
    }
}