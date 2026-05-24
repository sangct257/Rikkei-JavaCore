package bai1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieManager<Movie> manager = new MovieManager<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        manager.addMovie(new Movie("01", "Na tra", "Nguyễn Công Hưởng", LocalDate.of(2025, 2, 23), 9.5));
        manager.addMovie(new Movie("02", "Tây Du Ký", "Không rõ", LocalDate.of(1973, 1, 1), 7.9));

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm phim");
            System.out.println("2. Xóa phim");
            System.out.println("3. Sửa phim");
            System.out.println("4. Hiển thị phim");
            System.out.println("5. Tìm kiếm phim theo tên");
            System.out.println("6. Lọc phim theo rating");
            System.out.println("7. Thoát");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng chọn một số từ 1 đến 7!\n");
                continue;
            }

            if (choice == 7) {
                System.out.println("Đã thoát chương trình.");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Nhập ID phim:");
                    String id = scanner.nextLine();
                    if (manager.findById(id) != null) {
                        System.out.println("Lỗi: ID phim này đã tồn tại!\n");
                        break;
                    }
                    System.out.println("Nhập tiêu đề phim:");
                    String title = scanner.nextLine();
                    System.out.println("Nhập đạo diễn:");
                    String director = scanner.nextLine();

                    // Bắt lỗi nhập sai định dạng ngày
                    LocalDate releaseDate = null;
                    while (releaseDate == null) {
                        System.out.println("Nhập ngày phát hành (dd-MM-yyyy):");
                        try {
                            releaseDate = LocalDate.parse(scanner.nextLine(), formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Lỗi: Định dạng ngày không hợp lệ! Hãy nhập dạng dd-MM-yyyy (Ví dụ: 23-02-2025).");
                        }
                    }

                    // Bắt lỗi nhập sai định dạng số rating
                    double rating = -1;
                    while (rating < 0 || rating > 10) {
                        System.out.println("Nhập rating:");
                        try {
                            rating = Double.parseDouble(scanner.nextLine());
                            if (rating < 0 || rating > 10) {
                                System.out.println("Rating phải nằm trong khoảng từ 0 đến 10!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi: Rating phải là một số thực hợp lệ!");
                        }
                    }

                    manager.addMovie(new Movie(id, title, director, releaseDate, rating));
                    System.out.println("Phim đã được thêm thành công.\n");
                    break;

                case 2: // Xóa phim
                    System.out.println("Nhập ID phim cần xóa:");
                    String deleteId = scanner.nextLine();
                    if (manager.deleteMovie(deleteId)) {
                        System.out.println("Phim đã được xóa thành công.\n");
                    } else {
                        System.out.println("Không tìm thấy phim muốn xóa !\n");
                    }
                    break;

                case 3: // Sửa phim
                    System.out.println("Mời nhập id phim muốn sửa :");
                    String editId = scanner.nextLine();
                    Movie editMovie = manager.findById(editId);
                    if (editMovie == null) {
                        System.out.println("Không tìm thấy phim với id = " + editId + "\n");
                        break;
                    }

                    System.out.println("Nhập tiêu đề phim:");
                    editMovie.setTitle(scanner.nextLine());
                    System.out.println("Nhập đạo diễn:");
                    editMovie.setDirector(scanner.nextLine());

                    LocalDate editDate = null;
                    while (editDate == null) {
                        System.out.println("Nhập ngày phát hành (dd-MM-yyyy):");
                        try {
                            editDate = LocalDate.parse(scanner.nextLine(), formatter);
                            editMovie.setReleaseDate(editDate);
                        } catch (DateTimeParseException e) {
                            System.out.println("Lỗi: Định dạng ngày không hợp lệ!");
                        }
                    }

                    double editRating = -1;
                    while (editRating < 0 || editRating > 10) {
                        System.out.println("Nhập rating:");
                        try {
                            editRating = Double.parseDouble(scanner.nextLine());
                            if (editRating >= 0 && editRating <= 10) {
                                editMovie.setRating(editRating);
                            } else {
                                System.out.println("Rating phải từ 0 đến 10!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi: Rating phải là số!");
                        }
                    }
                    System.out.println("Cập nhật phim thành công !\n");
                    break;

                case 4: // Hiển thị phim
                    System.out.println("Danh sách phim:");
                    List<Movie> allMovies = manager.getAllMovies();
                    if (allMovies.isEmpty()) {
                        System.out.println("(Danh sách trống)");
                    } else {
                        for (Movie m : allMovies) {
                            System.out.println(m);
                        }
                    }
                    System.out.println();
                    break;

                case 5: // Tìm kiếm theo tên
                    System.out.println("Nhập tiêu đề phim để tìm kiếm:");
                    String searchTitle = scanner.nextLine();
                    List<Movie> searchResult = manager.searchByTitle(searchTitle);
                    if (searchResult.isEmpty()) {
                        System.out.println("Không tìm thấy phim\n");
                    } else {
                        for (Movie m : searchResult) {
                            System.out.println("Phim tìm thấy: " + m);
                        }
                        System.out.println();
                    }
                    break;

                case 6: // Lọc phim theo rating
                    double minRating = 8.0;
                    System.out.println("Nhập rating tối thiểu để lọc (Mặc định trong ảnh là 8):");
                    try {
                        minRating = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Định dạng số sai, hệ thống tự động lấy mốc mặc định là 8.0");
                    }

                    System.out.println("Phim có rating lớn hơn " + minRating + ":");
                    List<Movie> filteredMovies = manager.filterByRating(minRating);
                    if (filteredMovies.isEmpty()) {
                        System.out.println("(Không có phim nào thỏa mãn)\n");
                    } else {
                        for (Movie m : filteredMovies) {
                            System.out.println(m);
                        }
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ từ 1-7!\n");
            }
        }
        scanner.close();
    }
}
