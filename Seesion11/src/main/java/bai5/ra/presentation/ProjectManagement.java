package bai5.ra.presentation;

import bai5.ra.business.EmployeeBusiness;
import bai5.ra.business.ProjectBusiness;
import bai5.ra.entity.Employee;
import bai5.ra.entity.Project;

import java.util.Scanner;

public class ProjectManagement {
    private static Employee[] arrEmplyees = new Employee[99];
    private static Project[] arrProjects = new Project[50];

    private static int countEmployees = 0;
    private static int countProjects = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("""
                    ================ QUẢN LÝ DỰ ÁN ===================
                    1. Quản lý nhân viên
                    2. Quản lý dự án
                    3. Thoát
                    ==================================================
                    Lựa chọn của bạn: 
                    """);
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        menuEmployee(scanner);
                        break;
                    case 2:
                        menuProject(scanner);
                        break;
                    case 3:
                        System.out.println("Thoát chương trình!");
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng chọn từ 1 đến 3!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        } while (true);
    }

    public static void menuEmployee(Scanner scanner) {
        do {
            System.out.print("""
                    ======================= QUẢN LÝ NHÂN VIÊN =======================
                    1. Thêm nhân viên
                    2. Hiển thị danh sách nhân viên
                    3. Cập nhập thông tin nhân viên
                    4. Xoá nhân viên
                    5. Tìm kiếm nhân viên theo tên
                    6. Sắp xếp nhân viên theo lương giảm dần
                    7. Thoát
                    ===================================================================
                    Lựa chọn của bạn: 
                    """);
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        EmployeeBusiness.addEmployees(scanner);
                        break;
                    case 2:
                        EmployeeBusiness.displayEmployees();
                        break;
                    case 3:
                        EmployeeBusiness.updateEmployee(scanner);
                        break;
                    case 4:
                        EmployeeBusiness.deleteEmployee(scanner);
                        break;
                    case 5:
                        EmployeeBusiness.searchEmployeeByName(scanner);
                        break;
                    case 6:
                        EmployeeBusiness.sortEmployeeBySalaryDesc();
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 đến 7!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        } while (true);
    }

    public static void menuProject(Scanner scanner) {
        do {
            System.out.print("""
                    ======================= QUẢN LÝ DỰ ÁN =======================
                    1. Thêm dự án
                    2. Hiển thị danh sách dự án
                    3. Cập nhập thông tin dự án
                    4. Xoá dự án (chỉ khi chưa có nhân viên tham gia)
                    5. Thêm nhân viên vào dự án
                    6. Tìm dự án theo tên
                    7. Thống kê số lượng nhân viên theo vai trò trong từng dự án
                    8. Tìm dự án đang chạy và gần kết thúc nhất
                    9. Thoát
                    ==============================================================
                    Lựa chọn của bạn: 
                    """);
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        ProjectBusiness.addProject(scanner);
                        break;
                    case 2:
                        ProjectBusiness.displayProjects();
                        break;
                    case 3:
                        ProjectBusiness.updateProject(scanner);
                        break;
                    case 4:
                        ProjectBusiness.deleteProject(scanner);
                        break;
                    case 5:
                        ProjectBusiness.addEmployeeToProject(scanner);
                        break;
                    case 6:
                        ProjectBusiness.searchProjectByName(scanner);
                        break;
                    case 7:
                        ProjectBusiness.statisticalEmployeeRole();
                        break;
                    case 8:
                        ProjectBusiness.findRunningProjectNearEnd();
                        break;
                    case 9:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 đến 9!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        } while (true);
    }

}
