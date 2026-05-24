package bai1;

import java.util.ArrayList;
import java.util.List;

public class MovieManager<T extends Movie> {
    private List<T> list;

    public MovieManager() {
        this.list = new ArrayList<>();
    }

    // 1. Thêm phim
    public void addMovie(T movie) {
        list.add(movie);
    }

    // 2. Lấy toàn bộ danh sách phim
    public List<T> getAllMovies() {
        return list;
    }

    // 3. Tìm phim theo ID
    public T findById(String id) {
        for (T movie : list) {
            if (movie.getId().equalsIgnoreCase(id)) {
                return movie;
            }
        }
        return null;
    }

    // 4. Xóa phim theo ID
    public boolean deleteMovie(String id) {
        T movie = findById(id);
        if (movie != null) {
            list.remove(movie);
            return true;
        }
        return false;
    }

    // 5. Tìm kiếm phim theo tên
    public List<T> searchByTitle(String title) {
        List<T> result = new ArrayList<>();
        for (T movie : list) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(movie);
            }
        }
        return result;
    }

    // 6. Lọc phim theo rating tối thiểu
    public List<T> filterByRating(double minRating) {
        List<T> result = new ArrayList<>();
        for (T movie : list) {
            if (movie.getRating() > minRating) {
                result.add(movie);
            }
        }
        return result;
    }
}
