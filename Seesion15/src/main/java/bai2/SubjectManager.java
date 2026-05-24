package bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubjectManager<T extends Subject> {
    private List<T> list;

    public SubjectManager() {
        this.list = new ArrayList<>();
    }

    // 1. Thêm môn học
    public void addSubject(T subject) {
        list.add(subject);
    }

    // 2. Hiển thị danh sách môn học
    public List<T> displayAll() {
        if (list.isEmpty()) {
            System.out.println("(Danh sách môn học đang trống)");
        }
        return list;
    }

    // 3. Xóa môn học theo code (Trả về true nếu xóa thành công, false nếu không tìm thấy)
    public boolean deleteByCode(String code) {
        // Sử dụng Stream để tìm kiếm môn học trùng mã code
        Optional<T> subjectOpt = list.stream()
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst();

        if (subjectOpt.isPresent()) {
            list.remove(subjectOpt.get());
            return true;
        }
        return false;
    }

    // 4. Tìm kiếm môn học theo tên bằng Stream + Optional
    public Optional<T> searchByName(String name) {
        return list.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst();
    }

    // 5. Lọc môn học theo tín chỉ (credits > 3) bằng Stream API
    public List<T> filterByCredits(int minCredits) {
        return list.stream()
                .filter(s -> s.getCredits() > minCredits)
                .collect(Collectors.toList());
    }

    // Hàm phụ trợ check trùng mã khi thêm mới
    public boolean isCodeExist(String code) {
        return list.stream().anyMatch(s -> s.getCode().equalsIgnoreCase(code));
    }
}
