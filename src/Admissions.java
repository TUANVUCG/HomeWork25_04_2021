import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admissions {
    Scanner sc = new Scanner(System.in);
    List<Student> studentList = new ArrayList<>();
    String KHONG_TIM_THAY_SO_BAO_DANH = "Không tìm thấy số báo danh phù hợp !";
    // Them thong tin mot thi sinh
    public void addStudent() {
        menu();
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                StudentBranchA studentBranchA = new StudentBranchA();
                studentBranchA.inputStudentBranchAInfo();
                studentList.add(studentBranchA);
                break;
            }
            case 2: {
                StudentBranchB studentBranchB = new StudentBranchB();
                studentBranchB.inputStudentBranchBInfo();
                studentList.add(studentBranchB);
                break;
            }
            case 3: {
                StudentBranchC studentBranchC = new StudentBranchC();
                studentBranchC.inputStudentInfo();
                studentList.add(studentBranchC);
                break;
            }
        }
    }

    private void menu() {
        System.out.println("Bạn muốn nhập thông tin thí sinh khối nào ?");
        System.out.println("1. Khối A");
        System.out.println("2. Khối B");
        System.out.println("3. Khối C");
    }

    // Hien thi thong tin tat ca thi sinh
    public void showInfoAllStudent() {
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    // Hien thi thong tin ve mot thi sinh
    public void showInfoStudentByName(String name) {
        boolean k = false;
        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                System.out.println(student.toString());
                k = true;
            }
        }if(!k){
            System.out.println("Không tìm thấy tên thí sinh phù hợp !");
        }
    }

    // Sap xep danh sach thi sinh theo ho ten su dung selection sort
    public void sortStudentListByNameUseSelectionSort() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            Student studentMin = studentList.get(i);
            int minIndex = i;
            for (int j = i + 1; j < studentList.size(); j++) {
                if (studentMin.getName().charAt(0) > studentList.get(j).getName().charAt(0)) {
                    studentMin = studentList.get(j);
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                studentList.set(minIndex,studentList.get(i));
                studentList.set(i,studentMin);
            }
        }
    }

    // Sap xep thi sinh theo so bao danh
    public void sortStudentById(){
        for(int i = 0; i<studentList.size()-1; i++){
            Student studentMin = studentList.get(i);
            int minIndex = i;
            for(int j = i +1; j<studentList.size();j++){
                if(studentList.get(i).getId()>studentList.get(j).getId()){
                    studentMin = studentList.get(j);
                    minIndex = j;
                }
            }
            if(minIndex !=i){
                studentList.set(minIndex,studentList.get(i));
                studentList.set(i,studentMin);
            }
        }
    }

    // Tim kiem theo so bao danh su dung thuat toan tim kiem nhi phan
    public void searchStudentByIdUseBinarySearch(int id){
        sortStudentById();
        int left = 0;
        int right = studentList.size()-1;
        boolean k = false;
        do{
            int mid = (left+right)/2;
            if(studentList.get(mid).getId()==id){
                System.out.println(studentList.get(mid));
                k = true;
                return;
            }
            if(studentList.get(mid).getId()<id){
                left=mid+1;
            }
            if(studentList.get(mid).getId()>id){
                right=mid-1;
            }
        }while(left<=right);
        System.out.println(KHONG_TIM_THAY_SO_BAO_DANH);
    }

    // Chỉnh sửa thông tin khi biết số báo danh
    public void editStudentInfoById(int id){
        sortStudentById();
        int left = 0;
        int right = studentList.size()-1;
        boolean k = false;
        do{
            int mid = (left+right)/2;
            if(studentList.get(mid).getId()==id){
                editStudentScore(mid);
                k = true;
                return;
            }
            if(studentList.get(mid).getId()<id){
                left=mid+1;
            }
            if(studentList.get(mid).getId()>id){
                right=mid-1;
            }
        }while(left<=right);
        System.out.println(KHONG_TIM_THAY_SO_BAO_DANH);
    }

    private void editStudentScore(int mid) {
        editIdNameAddressPrioritizeType(mid);
        if(studentList.get(mid) instanceof StudentBranchA) {
            System.out.print("Sửa điểm Toán : ");
            ((StudentBranchA) studentList.get(mid)).setMathScore(sc.nextDouble());
            System.out.print("Sửa điểm Vật lý : ");
            ((StudentBranchA) studentList.get(mid)).setPhysicalScore(sc.nextDouble());
            System.out.print("Sửa điểm Hóa học : ");
            ((StudentBranchA) studentList.get(mid)).setChemicalScore(sc.nextDouble());
        } else if(studentList.get(mid) instanceof StudentBranchB){
            System.out.print("Sửa điểm Toán : ");
            ((StudentBranchB) studentList.get(mid)).setMathScore(sc.nextDouble());
            System.out.print("Sửa điểm Hóa học : ");
            ((StudentBranchB) studentList.get(mid)).setChemicalScore(sc.nextDouble());
            System.out.print("Sửa điểm Sinh học : ");
            ((StudentBranchB) studentList.get(mid)).setBiologicalScore(sc.nextDouble());
        }else if(studentList.get(mid) instanceof StudentBranchC) {
            System.out.print("Sửa điểm Ngữ văn : ");
            ((StudentBranchC) studentList.get(mid)).setLiteraryScore(sc.nextDouble());
            System.out.print("Sửa điểm Lịch sử : ");
            ((StudentBranchC) studentList.get(mid)).setHistoryScore(sc.nextDouble());
            System.out.print("Sửa điểm Địa lý : ");
            ((StudentBranchC) studentList.get(mid)).setGeographyScore(sc.nextDouble());
        }
    }

    private void editIdNameAddressPrioritizeType(int mid) {
        System.out.print("Sửa id : ");
        studentList.get(mid).setId(sc.nextInt());
        sc.nextLine();
        System.out.print("Sửa tên : ");
        studentList.get(mid).setName(sc.nextLine());
        System.out.print("Sửa địa chỉ : ");
        studentList.get(mid).setAddress(sc.nextLine());
        System.out.print("Sửa diện khu vực ưu tiên : ");
        studentList.get(mid).setPrioritizeType(sc.nextLine());
    }

    // Xóa thông tin một thí sinh khi biết số báo danh
    public void removeStudentById(int id){
        sortStudentById();
        int left = 0;
        int right = studentList.size();
        boolean k = false;
        do{
            int mid = (left+right)/2;
            if(studentList.get(mid).getId()==id){
                studentList.remove(mid);
                k = true;
                return;
            }
            if(studentList.get(mid).getId()<id){
                left = mid +1;
            }
            if(studentList.get(mid).getId()>id){
                right= mid-1;
            }
        }while(left<=right);
        System.out.println(KHONG_TIM_THAY_SO_BAO_DANH);
    }
}
