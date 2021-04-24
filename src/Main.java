import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String NHAP_SBD = "Nhập số báo danh : ";
        String DANH_SACH_SAU_SAP_XEP = "Danh sách thí sinh sau sắp xếp : ";
        Admissions admissions = new Admissions();
        admissions.studentList.add(new StudentBranchA(1,"Naruto", "Bac Ninh","kv1", 9,10,7));
        admissions.studentList.add(new StudentBranchB(4,"Aasuke", "Ha Noi","kv2", 7,6.5,8));
        admissions.studentList.add(new StudentBranchC(2,"Kakura", "Bac Kan","kv3", 8,9,8.5));
        admissions.studentList.add(new StudentBranchA(5,"Lee", "Ha Tinh","kv2", 6,8,9));
        admissions.sortStudentById();
        admissions.showInfoAllStudent();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập lựa chọn của bạn");
        int choice = -1;
        do{
            menu();
            choice = sc.nextInt();
            switch (choice){
                case 1 : {
                    admissions.addStudent();
                    break;
                }
                case 2 : {
                    admissions.showInfoAllStudent();
                    break;
                }
                case 3 : {
                    sortByName(DANH_SACH_SAU_SAP_XEP, admissions);
                    break;
                }
                case 4 : {
                    sortById(DANH_SACH_SAU_SAP_XEP, admissions);
                    break;
                }
                case 5 : {
                    searchByIdUseBinary(NHAP_SBD, admissions, sc);
                    break;
                }
                case 6 : {
                    editById(NHAP_SBD, admissions, sc);
                    break;
                }
                case 7 : {
                    removeById(NHAP_SBD, admissions, sc);
                }
            }

        }while(choice!=0);
    }

    private static void sortById(String DANH_SACH_SAU_SAP_XEP, Admissions admissions) {
        admissions.sortStudentById();
        System.out.println(DANH_SACH_SAU_SAP_XEP);
        admissions.showInfoAllStudent();
    }

    private static void sortByName(String DANH_SACH_SAU_SAP_XEP, Admissions admissions) {
        admissions.sortStudentListByNameUseSelectionSort();
        System.out.println(DANH_SACH_SAU_SAP_XEP);
        admissions.showInfoAllStudent();
    }

    private static void removeById(String NHAP_SBD, Admissions admissions, Scanner sc) {
        int id = inputId(NHAP_SBD, sc);
        admissions.removeStudentById(id);
        System.out.println("Danh sách thí sinh sau khi xóa ");
        admissions.showInfoAllStudent();
        return;
    }

    private static void editById(String NHAP_SBD, Admissions admissions, Scanner sc) {
        int id = inputId(NHAP_SBD, sc);
        admissions.editStudentInfoById(id);
        System.out.println("Danh sách thí sinh sau khi sửa ");
        admissions.showInfoAllStudent();
        return;
    }

    private static void searchByIdUseBinary(String NHAP_SBD, Admissions admissions, Scanner sc) {
        int id = inputId(NHAP_SBD, sc);
        admissions.searchStudentByIdUseBinarySearch(id);
        return;
    }


    private static void menu() {
        System.out.println("1. Nhập thông tin thí sinh");
        System.out.println("2. Hiển thị thông tin tất cả thí sinh");
        System.out.println("3. Sắp xếp danh sách thí sinh theo họ tên sử dụng selection sort");
        System.out.println("4. Sắp xếp danh sách thí sinh theo mã thí sinh");
        System.out.println("5. Tìm kiếm theo số báo danh sử dụng thuật toán tìm kiếm nhị phân");
        System.out.println("6. Chỉnh sửa thông tin của một thí sinh khi biết số báo danh");
        System.out.println("7. Xóa thông tin của thí sinh khi biết số báo danh");
        System.out.println("0. Thoát chương trình");
    }

    private static int inputId(String NHAP_SBD, Scanner sc) {
        System.out.print(NHAP_SBD);
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }
}
