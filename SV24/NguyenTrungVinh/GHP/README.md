# QUẢN LÝ TRUNG TÂM NGOẠI NGỮ

## Thông tin ứng dụng
- Tên ứng dụng: **Quản lý trung tâm ngoại ngữ**
- Người thực hiện: ***[Nguyễn Trung Vĩnh](https://github.com/MinkuruDev)***
- Ngôn ngữ chính: **Java**
- Ngày code: **13/04/2023**
- Ngày hoàn thành: **02/05/2023**

## Hướng dẫn sử dụng

### Chạy ứng dụng
- Sử dụng IDE ***[IntelliJ IDEA](https://www.jetbrains.com/idea/)***
- Có thể sử dụng IDE khác nhưng cần thêm config
- Chạy File ***Application.java***

### Đăng nhập
- Tên đăng nhập: admin
- Mật khẩu: admin

### Thanh điều hướng
![Navigation](./Image/navigation.png)
Sử dụng các nút để chuyển màn hình chính sang các chức năng quản lý tương ứng

### Quản lý thông tin học viên
Chọn ***Student*** trên thanh điều hướng để thực hiện chức năng quản lý thông tin học viên
![Student](./Image/student.png)
1. Khu vực bên trái để nhập, sửa thông tin học viên
2. Khu vực bảng ở giữa để hiển thị thông tin của tất cả học viên hoặc một số học viên khớp với yêu cầu tìm kiếm
3. Khu vực bên phải dùng để tìm kiếm học viên, kết quả sau khi tìm kiếm sẽ được hiển thị trên bảng

### Quản lý thông tin giáo viên
Chọn ***Teacher*** trên thanh điều hướng để thực hiện chức năng quản lý thông tin giáo viên
![Teacher](./Image/teacher.png)
1. Khu vực bên trái để nhập, sửa thông tin giáo viên
2. Khu vực bảng ở giữa để hiển thị thông tin của tất cả giáo viên hoặc một số giáo viên khớp với yêu cầu tìm kiếm
3. Khu vực bên phải dùng để tìm kiếm giáo viên, kết quả sau khi tìm kiếm sẽ được hiển thị trên bảng

### Quản lý thông tin gói học
Chọn ***Course*** trên thanh điều hướng để thực hiện chức năng quản lý thông tin gói học
![Course](./Image/course.png)
1. Khu vực bên trái để nhập, sửa thông tin gói học
2. Khu vực bảng ở giữa để hiển thị thông tin của tất cả các gói học hoặc một số gói học khớp với yêu cầu tìm kiếm
3. Khu vực bên phải dùng để tìm kiếm gói học, kết quả sau khi tìm kiếm sẽ được hiển thị trên bảng
4. Nếu ở cột Teacher Name hiển thị **!!!** có nghĩa là ID giáo viên không hợp lệ 
5. Ấn vào **...** ở cột **Schedule** để hiển thị lịch học của gói học tương ứng
![Schedule](./Image/schedule.png)

minh hoạ lịch học của một gói học

***Lưu ý khi nhập thông tin:***
1. Nhập ngày (Start date/End date) phải nhập theo định dạng **yyyy-MM-dd**
ví dụ nếu muốn nhập **ngày 30 tháng 4 năm 2023** thì nhập **2023-04-30**
2. Thông tin ID của các học viên (Student IDs) nhập các id của học viên
cách nhau ***một ký tự cách hoặc 1 ký tự xuống dòng***

### Quản lý thông tin kỳ thi
Chọn ***Exam*** trên thanh điều hướng để thực hiện chức năng quản lý thông tin kỳ thi
![Exam](./Image/exam.png)
1. Khu vực bên trái dùng để nhập, sửa thông tin kỳ thi
2. Khu vực bảng ở giữa để hiển thị thông tin của tất cả các kỳ thi hoặc một số kỳ thi khớp với yêu cầu tìm kiếm
3. Khu vực bên phải để tìm kiếm kỳ thi, kết quả sau khi tìm kiếm sẽ được hiển thị trên bảng

***Lưu ý khi nhập thông tin***
1. Nhập ngày (Exam date) phải nhập theo định dạng **yyyy-MM-dd** 
ví dụ nếu muốn nhập **ngày 30 tháng 4 năm 2023** thì nhập **2023-04-30**
2. Nhập thời gian (Exam time) là thời gian trong ngày theo định dạng **hh:mm**
ví dụ nếu muốn nhập **14 giờ 30 phút** thì nhập **14:30**

### Quản lý thông tin tài liệu
Chọn ***Document*** trên thanh điều hướng để thực hiện chức năng quản lý thông tin tài liệu
![Document](./Image/document.png)
1. Khu vực bên trái dùng để nhập, sửa thông tin tài liệu
2. Khu vực bảng ở giữa để hiển thị thông tin của tất cả các tài liệu hoặc một số tài liệu khớp với yêu cầu tìm kiếm
3. Khu vực bên phải để tìm kiếm tài liệu, kết quả sau khi tìm kiếm sẽ được hiển thị trên bảng
