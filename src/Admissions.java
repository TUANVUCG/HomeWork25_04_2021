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
                boolean k = true;
                StudentBranchA studentBranchA = new StudentBranchA();
                studentBranchA.inputStudentBranchAInfo(studentList);
                studentList.add(studentBranchA);
                break;
            }
            case 2: {
                StudentBranchB studentBranchB = new StudentBranchB();
                studentBranchB.inputStudentBranchBInfo(studentList);
                studentList.add(studentBranchB);
                break;
            }
            case 3: {
                StudentBranchC studentBranchC = new StudentBranchC();
                studentBranchC.inputStudentBranchCInfo(studentList);
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
        }
        if (!k) {
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
                studentList.set(minIndex, studentList.get(i));
                studentList.set(i, studentMin);
            }
        }
    }

    // Sap xep thi sinh theo so bao danh
    public void sortStudentById() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            Student studentMin = studentList.get(i);
            int minIndex = i;
            for (int j = i + 1; j < studentList.size(); j++) {
                if (studentList.get(i).getId() > studentList.get(j).getId()) {
                    studentMin = studentList.get(j);
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                studentList.set(minIndex, studentList.get(i));
                studentList.set(i, studentMin);
            }
        }
    }

    // Tim kiem theo so bao danh su dung thuat toan tim kiem nhi phan
    public int searchStudentByIdUseBinarySearch(int id) {
        sortStudentById();
        int left = 0;
        int right = studentList.size() - 1;
        do {
            int mid = (left + right) / 2;
            if (studentList.get(mid).getId() == id) {
                return mid;
            }
            if (studentList.get(mid).getId() < id) {
                left = mid + 1;
            }
            if (studentList.get(mid).getId() > id) {
                right = mid - 1;
            }
        } while (left <= right);
        System.out.println(KHONG_TIM_THAY_SO_BAO_DANH);
        return -1;
    }


    // Hien thi thong tin theo so bao danh
    public void showStudentInfoById(int id) {
        int search = searchStudentByIdUseBinarySearch(id);
        if (search != -1) {
            System.out.println(studentList.get(search));
        }
    }

    // Sửa thông tin khi biết số báo danh
    public void editStudentInfoById(int id) {
        int search = searchStudentByIdUseBinarySearch(id);
        if (search != -1) {
            Student studentSearch = studentList.get(search);
            if (studentSearch instanceof StudentBranchA) {
                StudentBranchA studentBranchA = new StudentBranchA();
                studentBranchA.inputStudentBranchAInfo(studentList);
                studentList.set(search, studentBranchA);
            }
            if (studentSearch instanceof StudentBranchB) {
                StudentBranchB studentBranchB = new StudentBranchB();
                studentBranchB.inputStudentBranchBInfo(studentList);
                studentList.set(search, studentBranchB);
            }
            if (studentSearch instanceof StudentBranchC) {
                StudentBranchC studentBranchC = new StudentBranchC();
                studentBranchC.inputStudentBranchCInfo(studentList);
                studentList.set(search, studentBranchC);
            }
        }
    }


    // Xóa thông tin một thí sinh khi biết số báo danh
    public void removeStudentById(int id) {
        int search = searchStudentByIdUseBinarySearch(id);
        if (search != -1) {
            studentList.remove(studentList.get(search));
        }
    }


}
