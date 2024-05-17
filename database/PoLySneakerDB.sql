CREATE DATABASE PoLySneaker
GO 

USE PoLySneaker
GO 
CREATE TABLE [ThuongHieu] (
  [IDThuongHieu] INT IDENTITY,
  [Ma_ThuongHieu] VarChar(50),
  [TenThuongHieu] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDThuongHieu])
);

CREATE TABLE [Size] (
  [IDSize] INT IDENTITY,
  [Ma_Size] Varchar(50),
  [Size] INT,
  [TrangThai] BIT,
  PRIMARY KEY ([IDSize])
);

CREATE TABLE [XuatXu] (
  [IDXuatXu] INT IDENTITY,
  [Ma_XuatXu] Varchar(50),
  [TenXuatXu] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDXuatXu])
);

CREATE TABLE [ChatLieu] (
  [IDChatLieu] INT IDENTITY,
  [Ma_ChatLieu] Varchar(50),
  [TenChatLieu] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDChatLieu])
);

CREATE TABLE [KhachHang] (
  [IDKhangHang] INT IDENTITY,
  [TenKhachHang] Nvarchar(50),
  [SDT] Nvarchar(50),
  [NgaySinh] Date,
  [Email] Nvarchar(50),
  [DiaChi] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDKhangHang])
);

CREATE TABLE [KhuyenMai] (
  [IDKhuyenMai] INT IDENTITY,
  [Ma_KhuyenMai] Nvarchar(50),
  [GiaTri] INT,
  [NgayBatDau] Date,
  [NgayKetThuc] Date,
  [TrangThai] BIT,
  PRIMARY KEY ([IDKhuyenMai])
);

CREATE TABLE [NhanVien] (
  [IDNhanVien] INT IDENTITY,
  [Ma_NhanVien] Varchar(50),
  [HoTen] Nvarchar(50),
  [ChucVu] BIT,
  [NgaySinh] Date,
  [SDT] Nvarchar(10),
  [Email] Nvarchar(50),
  [GioiTinh] BIT,
  [DiaChi] Nvarchar(50),
  [UserName] Varchar(50),
  [MatKhau] Nvarchar(32),
  [TrangThai] BIT,
  PRIMARY KEY ([IDNhanVien])
);

CREATE TABLE [HoaDon] (
  [IDHoaDon] INT IDENTITY,
  [ID_KhachHang] INT,
  [ID_NhanVien] INT,
  [ID_KhuyenMai] INT,
  [Ma_HoaDon] Varchar(50),
  [TienSauGiamGia] Decimal,
  [ThanhTien] Decimal,
  [PhuongThucThanhToan] BIT,
  [NgayThanhToan] Date,
  [TrangThai] BIT,
  PRIMARY KEY ([IDHoaDon]),
  CONSTRAINT [FK_HoaDon.ID_KhachHang]
    FOREIGN KEY ([ID_KhachHang])
      REFERENCES [KhachHang]([IDKhangHang]),
  CONSTRAINT [FK_HoaDon.ID_KhuyenMai]
    FOREIGN KEY ([ID_KhuyenMai])
      REFERENCES [KhuyenMai]([IDKhuyenMai]),
  CONSTRAINT [FK_HoaDon.ID_NhanVien]
    FOREIGN KEY ([ID_NhanVien])
      REFERENCES [NhanVien]([IDNhanVien])
);

CREATE TABLE [DanhMucSanPham] (
  [IDDanhMuc] INT IDENTITY,
  [Ma_DanhMuc] VarChar(50),
  [TenDanhMuc] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDDanhMuc])
);

CREATE TABLE [SanPham] (
  [IDSanPham] INT IDENTITY,
  [ID_ThuongHieu] INT,
  [ID_DanhMuc] INT,
  [Ma_SanPham] VarChar(50),
  [TenSanPham] NVARCHAR(100),
  [Url_Anh] VARCHAR(200),
  [TrangThai] BIT,
  PRIMARY KEY ([IDSanPham]),
  CONSTRAINT [FK_SanPham.ID_ThuongHieu]
    FOREIGN KEY ([ID_ThuongHieu])
      REFERENCES [ThuongHieu]([IDThuongHieu]),
  CONSTRAINT [FK_SanPham.ID_DanhMuc]
    FOREIGN KEY ([ID_DanhMuc])
      REFERENCES [DanhMucSanPham]([IDDanhMuc])
);

CREATE TABLE [MauSac] (
  [IDMauSac] INT IDENTITY,
  [Ma_MauSac] Varchar(50),
  [TenMauSac] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDMauSac])
);

CREATE TABLE [ChiTietSanPham] (
  [IDChiTietSanPham] INT IDENTITY,
  [ID_SanPham] INT,
  [ID_MauSac] INT,
  [ID_ChatLieu] INT,
  [ID_Size] INT,
  [ID_XuatXu] INT,
  [Ma_ChiTietSanPham] VarChar(50),
  [SoLuong] INT,
  [GiaNhap] Decimal,
  [GiaBan] Decimal,
  [NgayNhap] Date,
  [TrangThai] BIT,
  PRIMARY KEY ([IDChiTietSanPham]),
  CONSTRAINT [FK_ChiTietSanPham.ID_Size]
    FOREIGN KEY ([ID_Size])
      REFERENCES [Size]([IDSize]),
  CONSTRAINT [FK_ChiTietSanPham.ID_XuatXu]
    FOREIGN KEY ([ID_XuatXu])
      REFERENCES [XuatXu]([IDXuatXu]),
  CONSTRAINT [FK_ChiTietSanPham.ID_ChatLieu]
    FOREIGN KEY ([ID_ChatLieu])
      REFERENCES [ChatLieu]([IDChatLieu]),
  CONSTRAINT [FK_ChiTietSanPham.ID_SanPham]
    FOREIGN KEY ([ID_SanPham])
      REFERENCES [SanPham]([IDSanPham]),
  CONSTRAINT [FK_ChiTietSanPham.ID_MauSac]
    FOREIGN KEY ([ID_MauSac])
      REFERENCES [MauSac]([IDMauSac])
);

CREATE TABLE [HoaDonChiTiet] (
  [IDHoaDonChiTiet] INT IDENTITY,
  [ID_HoaDon] INT,
  [ID_ChiTietSanPham] INT,
  [Ma_HoaDonChiTiet] Varchar(50),
  [SoLuong] INT,
  [DonGia] Decimal,
  [TrangThai] BIT,
  PRIMARY KEY ([IDHoaDonChiTiet]),
  CONSTRAINT [FK_HoaDonChiTiet.ID_HoaDon]
    FOREIGN KEY ([ID_HoaDon])
      REFERENCES [HoaDon]([IDHoaDon]),
  CONSTRAINT [FK_HoaDonChiTiet.ID_ChiTietSanPham]
    FOREIGN KEY ([ID_ChiTietSanPham])
      REFERENCES [ChiTietSanPham]([IDChiTietSanPham])
);


-- Then data to tables 
INSERT INTO [ThuongHieu] (Ma_ThuongHieu, TenThuongHieu, TrangThai) VALUES 
('TH001', N'Nike', 1),
('TH002', N'Adidas', 1),
('TH003', N'Puma', 1),
('TH004', N'Reebok', 1),
('TH005', N'Converse', 1),
('TH006', N'Vans', 1),
('TH007', N'New Balance', 1),
('TH008', N'Asics', 1),
('TH009', N'Fila', 1),
('TH010', N'Skechers', 1),
('TH011', N'Under Armour', 1),
('TH012', N'Jordan', 1),
('TH013', N'Balenciaga', 1),
('TH014', N'Gucci', 1),
('TH015', N'Yeezy', 1),
('TH016', N'Dior', 1),
('TH017', N'Louis Vuitton', 1),
('TH018', N'Bape', 1),
('TH019', N'Off-White', 1),
('TH020', N'Common Projects', 1);

INSERT INTO [Size] (Ma_Size, Size, TrangThai) VALUES 
('S001', 36, 1),
('S002', 37, 1),
('S003', 38, 1),
('S004', 39, 1),
('S005', 40, 1),
('S006', 41, 1),
('S007', 42, 1),
('S008', 43, 1),
('S009', 44, 1),
('S010', 45, 1),
('S011', 46, 1),
('S012', 47, 1),
('S013', 48, 1),
('S014', 49, 1),
('S015', 50, 1),
('S016', 51, 1),
('S017', 52, 1),
('S018', 53, 1),
('S019', 54, 1),
('S020', 55, 1);

INSERT INTO [XuatXu] (Ma_XuatXu, TenXuatXu, TrangThai) VALUES 
('XX001', N'USA', 1),
('XX002', N'Germany', 1),
('XX003', N'Italy', 1),
('XX004', N'France', 1),
('XX005', N'UK', 1),
('XX006', N'Japan', 1),
('XX007', N'China', 1),
('XX008', N'Vietnam', 1),
('XX009', N'Indonesia', 1),
('XX010', N'India', 1),
('XX011', N'Brazil', 1),
('XX012', N'Thailand', 1),
('XX013', N'Korea', 1),
('XX014', N'Canada', 1),
('XX015', N'Mexico', 1),
('XX016', N'Turkey', 1),
('XX017', N'Portugal', 1),
('XX018', N'Spain', 1),
('XX019', N'Malaysia', 1),
('XX020', N'Australia', 1);

INSERT INTO [ChatLieu] (Ma_ChatLieu, TenChatLieu, TrangThai) VALUES 
('CL001', N'Leather', 1),
('CL002', N'Suede', 1),
('CL003', N'Canvas', 1),
('CL004', N'Mesh', 1),
('CL005', N'Synthetic', 1),
('CL006', N'Rubber', 1),
('CL007', N'Knit', 1),
('CL008', N'Flyknit', 1),
('CL009', N'Primeknit', 1),
('CL010', N'Nubuck', 1),
('CL011', N'Textile', 1),
('CL012', N'Foam', 1),
('CL013', N'EVA', 1),
('CL014', N'PU Leather', 1),
('CL015', N'Jacquard', 1),
('CL016', N'Neoprene', 1),
('CL017', N'Polyester', 1),
('CL018', N'Cotton', 1),
('CL019', N'Spandex', 1),
('CL020', N'Gore-Tex', 1);

INSERT INTO [KhachHang] (TenKhachHang, SDT, NgaySinh, Email, DiaChi, TrangThai) VALUES 
(N'Khách hàng lẻ', '0909123456', '1990-01-01', 'nguyenvana@example.com', N'123 Le Loi, HCMC', 1),
(N'Tran Thi B', '0909123457', '1992-02-02', 'tranthib@example.com', N'456 Tran Hung Dao, HCMC', 1),
(N'Le Van C', '0909123458', '1994-03-03', 'levanc@example.com', N'789 Nguyen Trai, HCMC', 1),
(N'Pham Thi D', '0909123459', '1996-04-04', 'phamthid@example.com', N'321 Hai Ba Trung, HCMC', 1),
(N'Hoang Van E', '0909123460', '1988-05-05', 'hoangvane@example.com', N'654 Ly Tu Trong, HCMC', 1),
(N'Dang Thi F', '0909123461', '1986-06-06', 'dangthif@example.com', N'987 Cach Mang Thang Tam, HCMC', 1),
(N'Bui Van G', '0909123462', '1990-07-07', 'buivang@example.com', N'123 Pham Van Dong, HCMC', 1),
(N'Nguyen Thi H', '0909123463', '1991-08-08', 'nguyenthih@example.com', N'456 Le Duan, HCMC', 1),
(N'Tran Van I', '0909123464', '1993-09-09', 'tranvani@example.com', N'789 Dinh Tien Hoang, HCMC', 1),
(N'Le Thi J', '0909123465', '1995-10-10', 'lethij@example.com', N'321 Vo Thi Sau, HCMC', 1),
(N'Pham Van K', '0909123466', '1997-11-11', 'phamvank@example.com', N'654 Nguyen Dinh Chieu, HCMC', 1),
(N'Hoang Thi L', '0909123467', '1989-12-12', 'hoangthil@example.com', N'987 Dien Bien Phu, HCMC', 1),
(N'Dang Van M', '0909123468', '1987-01-13', 'dangvanm@example.com', N'123 Pasteur, HCMC', 1),
(N'Bui Thi N', '0909123469', '1991-02-14', 'buithin@example.com', N'456 Nguyen Thi Minh Khai, HCMC', 1),
(N'Nguyen Van O', '0909123470', '1992-03-15', 'nguyenvano@example.com', N'789 Vo Van Tan, HCMC', 1),
(N'Tran Thi P', '0909123471', '1994-04-16', 'tranthip@example.com', N'321 Hoang Dieu, HCMC', 1),
(N'Le Van Q', '0909123472', '1996-05-17', 'levanq@example.com', N'654 Phan Xich Long, HCMC', 1),
(N'Pham Thi R', '0909123473', '1988-06-18', 'phamthir@example.com', N'987 Nam Ky Khoi Nghia, HCMC', 1),
(N'Hoang Van S', '0909123474', '1986-07-19', 'hoangvans@example.com', N'123 Tan Son Nhi, HCMC', 1),
(N'Dang Thi T', '0909123475', '1990-08-20', 'dangthit@example.com', N'456 Phan Dang Luu, HCMC', 1);

INSERT INTO [KhuyenMai] (Ma_KhuyenMai, GiaTri, NgayBatDau, NgayKetThuc, TrangThai) VALUES 
(N'KM001', 10, '2024-01-01', '2024-01-31', 1),
(N'KM002', 15, '2024-02-01', '2024-02-28', 1),
(N'KM003', 20, '2024-03-01', '2024-03-31', 1),
(N'KM004', 25, '2024-04-01', '2024-04-30', 1),
(N'KM005', 30, '2024-05-01', '2024-05-31', 1),
(N'KM006', 35, '2024-06-01', '2024-06-30', 1),
(N'KM007', 40, '2024-07-01', '2024-07-31', 1),
(N'KM008', 45, '2024-08-01', '2024-08-31', 1),
(N'KM009', 50, '2024-09-01', '2024-09-30', 1),
(N'KM010', 55, '2024-10-01', '2024-10-31', 1),
(N'KM011', 60, '2024-11-01', '2024-11-30', 1),
(N'KM012', 65, '2024-12-01', '2024-12-31', 1),
(N'KM013', 70, '2024-01-01', '2024-01-31', 1),
(N'KM014', 75, '2024-02-01', '2024-02-28', 1),
(N'KM015', 80, '2024-03-01', '2024-03-31', 1),
(N'KM016', 85, '2024-04-01', '2024-04-30', 1),
(N'KM017', 90, '2024-05-01', '2024-05-31', 1),
(N'KM018', 95, '2024-06-01', '2024-06-30', 1),
(N'KM019', 100, '2024-07-01', '2024-07-31', 1),
(N'KM020', 50, '2024-08-01', '2024-08-31', 1);

INSERT INTO [NhanVien] (Ma_NhanVien, HoTen, ChucVu, NgaySinh, SDT, Email, GioiTinh, DiaChi, UserName, MatKhau, TrangThai) VALUES 
('NV001', N'Nguyen Van A', 1, '1985-01-01', '0909123456', 'nguyenvana@example.com', 1, N'123 Le Loi, HCMC', 'nguyenvana', 'password123', 1),
('NV002', N'Tran Thi B', 0, '1990-02-02', '0909123457', 'tranthib@example.com', 0, N'456 Tran Hung Dao, HCMC', 'tranthib', 'password123', 1),
('NV003', N'Le Van C', 1, '1982-03-03', '0909123458', 'levanc@example.com', 1, N'789 Nguyen Trai, HCMC', 'levanc', 'password123', 1),
('NV004', N'Pham Thi D', 0, '1995-04-04', '0909123459', 'phamthid@example.com', 0, N'321 Hai Ba Trung, HCMC', 'phamthid', 'password123', 1),
('NV005', N'Hoang Van E', 1, '1988-05-05', '0909123460', 'hoangvane@example.com', 1, N'654 Ly Tu Trong, HCMC', 'hoangvane', 'password123', 1),
('NV006', N'Dang Thi F', 0, '1992-06-06', '0909123461', 'dangthif@example.com', 0, N'987 Cach Mang Thang Tam, HCMC', 'dangthif', 'password123', 1),
('NV007', N'Bui Van G', 1, '1987-07-07', '0909123462', 'buivang@example.com', 1, N'123 Pham Van Dong, HCMC', 'buivang', 'password123', 1),
('NV008', N'Nguyen Thi H', 0, '1994-08-08', '0909123463', 'nguyenthih@example.com', 0, N'456 Le Duan, HCMC', 'nguyenthih', 'password123', 1),
('NV009', N'Tran Van I', 1, '1983-09-09', '0909123464', 'tranvani@example.com', 1, N'789 Dinh Tien Hoang, HCMC', 'tranvani', 'password123', 1),
('NV010', N'Le Thi J', 0, '1991-10-10', '0909123465', 'lethij@example.com', 0, N'321 Vo Thi Sau, HCMC', 'lethij', 'password123', 1),
('NV011', N'Pham Van K', 1, '1986-11-11', '0909123466', 'phamvank@example.com', 1, N'654 Nguyen Dinh Chieu, HCMC', 'phamvank', 'password123', 1),
('NV012', N'Hoang Thi L', 0, '1990-12-12', '0909123467', 'hoangthil@example.com', 0, N'987 Dien Bien Phu, HCMC', 'hoangthil', 'password123', 1),
('NV013', N'Dang Van M', 1, '1989-01-13', '0909123468', 'dangvanm@example.com', 1, N'123 Pasteur, HCMC', 'dangvanm', 'password123', 1),
('NV014', N'Bui Thi N', 0, '1993-02-14', '0909123469', 'buithin@example.com', 0, N'456 Nguyen Thi Minh Khai, HCMC', 'buithin', 'password123', 1),
('NV015', N'Nguyen Van O', 1, '1984-03-15', '0909123470', 'nguyenvano@example.com', 1, N'789 Vo Van Tan, HCMC', 'nguyenvano', 'password123', 1),
('NV016', N'Tran Thi P', 0, '1996-04-16', '0909123471', 'tranthip@example.com', 0, N'321 Hoang Dieu, HCMC', 'tranthip', 'password123', 1),
('NV017', N'Le Van Q', 1, '1985-05-17', '0909123472', 'levanq@example.com', 1, N'654 Phan Xich Long, HCMC', 'levanq', 'password123', 1),
('NV018', N'Pham Thi R', 0, '1992-06-18', '0909123473', 'phamthir@example.com', 0, N'987 Nam Ky Khoi Nghia, HCMC', 'phamthir', 'password123', 1),
('NV019', N'Hoang Van S', 1, '1981-07-19', '0909123474', 'hoangvans@example.com', 1, N'123 Tan Son Nhi, HCMC', 'hoangvans', 'password123', 1),
('NV020', N'Dang Thi T', 0, '1995-08-20', '0909123475', 'dangthit@example.com', 0, N'456 Phan Dang Luu, HCMC', 'dangthit', 'password123', 1);

INSERT INTO [HoaDon] (ID_KhachHang, ID_NhanVien, ID_KhuyenMai, Ma_HoaDon, TienSauGiamGia, ThanhTien, PhuongThucThanhToan, NgayThanhToan, TrangThai) VALUES
(1, 1, 1, 'HD001', 900000, 1000000, 1, '2024-01-01', 1),
(2, 2, 2, 'HD002', 850000, 1000000, 1, '2024-02-01', 1),
(3, 3, 3, 'HD003', 800000, 1000000, 1, '2024-03-01', 1),
(4, 4, 4, 'HD004', 750000, 1000000, 1, '2024-04-01', 1),
(5, 5, 5, 'HD005', 700000, 1000000, 1, '2024-05-01', 1),
(6, 6, 6, 'HD006', 650000, 1000000, 1, '2024-06-01', 1),
(7, 7, 7, 'HD007', 600000, 1000000, 1, '2024-07-01', 1),
(8, 8, 8, 'HD008', 550000, 1000000, 1, '2024-08-01', 1),
(9, 9, 9, 'HD009', 500000, 1000000, 1, '2024-09-01', 1),
(10, 10, 10, 'HD010', 450000, 1000000, 1, '2024-10-01', 1),
(11, 11, 11, 'HD011', 400000, 1000000, 1, '2024-11-01', 1),
(12, 12, 12, 'HD012', 350000, 1000000, 1, '2024-12-01', 1),
(13, 13, 13, 'HD013', 300000, 1000000, 1, '2024-01-15', 1),
(14, 14, 14, 'HD014', 250000, 1000000, 1, '2024-02-15', 1),
(15, 15, 15, 'HD015', 200000, 1000000, 1, '2024-03-15', 1),
(16, 16, 16, 'HD016', 150000, 1000000, 1, '2024-04-15', 1),
(17, 17, 17, 'HD017', 100000, 1000000, 1, '2024-05-15', 1),
(18, 18, 18, 'HD018', 50000, 1000000, 1, '2024-06-15', 1),
(19, 19, 19, 'HD019', 0, 1000000, 1, '2024-07-15', 1),
(20, 20, 20, 'HD020', 500000, 1000000, 1, '2024-08-15', 1);

INSERT INTO [DanhMucSanPham] (Ma_DanhMuc, TenDanhMuc, TrangThai) VALUES 
('DM001', N'Giày Thể Thao', 1),
('DM002', N'Giày Chạy Bộ', 1),
('DM003', N'Giày Tennis', 1),
('DM004', N'Giày Bóng Rổ', 1),
('DM005', N'Giày Bóng Đá', 1),
('DM006', N'Giày Leo Núi', 1),
('DM007', N'Giày Đá Banh', 1),
('DM008', N'Giày Trượt Patin', 1),
('DM009', N'Giày Cầu Lông', 1),
('DM010', N'Giày Bóng Chuyền', 1),
('DM011', N'Giày Đi Bộ', 1),
('DM012', N'Giày Luyện Tập', 1),
('DM013', N'Giày Golf', 1),
('DM014', N'Giày Dã Ngoại', 1),
('DM015', N'Giày Thời Trang', 1),
('DM016', N'Giày Cao Gót', 1),
('DM017', N'Giày Búp Bê', 1),
('DM018', N'Giày Lười', 1),
('DM019', N'Giày Dép', 1),
('DM020', N'Giày Sandal', 1);

INSERT INTO [SanPham] (ID_ThuongHieu, ID_DanhMuc, Ma_SanPham, TenSanPham, Url_Anh, TrangThai) VALUES 
(1, 1, 'SP001', N'Giày Thể Thao Nam Adidas', 'adidas.jpg', 1),
(1, 2, 'SP002', N'Giày Chạy Bộ Adidas', 'adidas.jpg', 1),
(2, 3, 'SP003', N'Giày Tennis Nike', 'nike.jpg', 1),
(2, 4, 'SP004', N'Giày Bóng Rổ Nike', 'nike.jpg', 1),
(1, 5, 'SP005', N'Giày Bóng Đá Adidas', 'adidas.jpg', 1),
(1, 6, 'SP006', N'Giày Leo Núi Adidas', 'adidas.jpg', 1),
(2, 7, 'SP007', N'Giày Đá Banh Nike', 'nike.jpg', 1),
(2, 8, 'SP008', N'Giày Trượt Patin Nike', 'nike.jpg', 1),
(1, 9, 'SP009', N'Giày Cầu Lông Adidas', 'adidas.jpg', 1),
(1, 10, 'SP010', N'Giày Bóng Chuyền Adidas', 'adidas.jpg', 1),
(2, 11, 'SP011', N'Giày Đi Bộ Nike', 'nike.jpg', 1),
(2, 12, 'SP012', N'Giày Luyện Tập Nike', 'nike.jpg', 1),
(1, 13, 'SP013', N'Giày Golf Adidas', 'adidas.jpg', 1),
(1, 14, 'SP014', N'Giày Dã Ngoại Adidas', 'adidas.jpg', 1),
(2, 15, 'SP015', N'Giày Thời Trang Nike', 'nike.jpg', 1),
(2, 16, 'SP016', N'Giày Cao Gót Nike', 'nike.jpg', 1),
(1, 17, 'SP017', N'Giày Búp Bê Adidas', 'adidas.jpg', 1),
(1, 18, 'SP018', N'Giày Lười Adidas', 'adidas.jpg', 1),
(2, 19, 'SP019', N'Giày Dép Nike', 'nike.jpg', 1),
(2, 20, 'SP020', N'Giày Sandal Nike', 'nike.jpg', 1);

INSERT INTO [MauSac] (Ma_MauSac, TenMauSac, TrangThai) VALUES 
('MS001', N'Đen', 1),
('MS002', N'Trắng', 1),
('MS003', N'Xám', 1),
('MS004', N'Đỏ', 1),
('MS005', N'Xanh Dương', 1),
('MS006', N'Xanh Lá Cây', 1),
('MS007', N'Vàng', 1),
('MS008', N'Cam', 1),
('MS009', N'Nâu', 1),
('MS010', N'Hồng', 1),
('MS011', N'Be', 1),
('MS012', N'Tím', 1),
('MS013', N'Xám Đậm', 1),
('MS014', N'Xanh Lá', 1),
('MS015', N'Xanh Dương Nhạt', 1),
('MS016', N'Nâu Đậm', 1),
('MS017', N'Vàng Đậm', 1),
('MS018', N'Xanh Lục', 1),
('MS019', N'Tím Đậm', 1),
('MS020', N'Hồng Đậm', 1);

INSERT INTO [ChiTietSanPham] (ID_SanPham, ID_MauSac, ID_ChatLieu, ID_Size, ID_XuatXu, Ma_ChiTietSanPham, SoLuong, GiaNhap, GiaBan, NgayNhap, TrangThai) VALUES 
(1, 1, 1, 1, 1, 'SP_CT001', 50, 500000, 800000, '2024-05-01', 1),
(1, 2, 2, 2, 2, 'SP_CT002', 50, 550000, 850000, '2024-05-02', 1),
(2, 3, 3, 3, 3, 'SP_CT003', 50, 600000, 900000, '2024-05-03', 1),
(2, 4, 4, 4, 4, 'SP_CT004', 50, 650000, 950000, '2024-05-04', 1),
(3, 5, 5, 5, 5, 'SP_CT005', 50, 700000, 1000000, '2024-05-05', 1),
(3, 6, 6, 6, 6, 'SP_CT006', 50, 750000, 1050000, '2024-05-06', 1),
(4, 7, 7, 7, 7, 'SP_CT007', 50, 800000, 1100000, '2024-05-07', 1),
(4, 8, 8, 8, 8, 'SP_CT008', 50, 850000, 1150000, '2024-05-08', 1),
(5, 9, 9, 9, 9, 'SP_CT009', 50, 900000, 1200000, '2024-05-09', 1),
(5, 10, 10, 10, 10, 'SP_CT010', 50, 950000, 1250000, '2024-05-10', 1),
(6, 11, 11, 11, 11, 'SP_CT011', 50, 1000000, 1300000, '2024-05-11', 1),
(6, 12, 12, 12, 12, 'SP_CT012', 50, 1050000, 1350000, '2024-05-12', 1),
(7, 13, 13, 13, 13, 'SP_CT013', 50, 1100000, 1400000, '2024-05-13', 1),
(7, 14, 14, 14, 14, 'SP_CT014', 50, 1150000, 1450000, '2024-05-14', 1),
(8, 15, 15, 15, 15, 'SP_CT015', 50, 1200000, 1500000, '2024-05-15', 1),
(8, 16, 16, 16, 16, 'SP_CT016', 50, 1250000, 1550000, '2024-05-16', 1),
(9, 17, 17, 17, 17, 'SP_CT017', 50, 1300000, 1600000, '2024-05-17', 1),
(9, 18, 18, 18, 18, 'SP_CT018', 50, 1350000, 1650000, '2024-05-18', 1),
(10, 19, 19, 19, 19, 'SP_CT019', 50, 1400000, 1700000, '2024-05-19', 1),
(10, 20, 20, 20, 20, 'SP_CT020', 50, 1450000, 1750000, '2024-05-20', 1);

INSERT INTO [HoaDonChiTiet] (ID_HoaDon, ID_ChiTietSanPham, Ma_HoaDonChiTiet, SoLuong, DonGia, TrangThai) VALUES 
(1, 1, 'HDCT001', 2, 800000, 1),
(1, 2, 'HDCT002', 1, 850000, 1),
(2, 3, 'HDCT003', 3, 900000, 1),
(2, 4, 'HDCT004', 2, 950000, 1),
(3, 5, 'HDCT005', 1, 1000000, 1),
(3, 6, 'HDCT006', 2, 1050000, 1),
(4, 7, 'HDCT007', 3, 1100000, 1),
(4, 8, 'HDCT008', 2, 1150000, 1),
(5, 9, 'HDCT009', 1, 1200000, 1),
(5, 10, 'HDCT010', 2, 1250000, 1),
(6, 11, 'HDCT011', 2, 1300000, 1),
(6, 12, 'HDCT012', 1, 1350000, 1),
(7, 13, 'HDCT013', 3, 1400000, 1),
(7, 14, 'HDCT014', 2, 1450000, 1),
(8, 15, 'HDCT015', 1, 1500000, 1),
(8, 16, 'HDCT016', 2, 1550000, 1),
(9, 17, 'HDCT017', 3, 1600000, 1),
(9, 18, 'HDCT018', 2, 1650000, 1),
(10, 19, 'HDCT019', 1, 1700000, 1),
(10, 20, 'HDCT020', 2, 1750000, 1);

