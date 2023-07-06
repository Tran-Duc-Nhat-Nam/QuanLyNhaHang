use master
go
if DB_ID('QuanLyNhaHang') is not null
   drop database QuanLyNhaHang
create database QuanLyNhaHang
go
use QuanLyNhaHang
go

SET DATEFORMAT DMY

create table ThongTin 
(
   TenThongTin		nvarchar(200) primary key,
   GiaTri			nvarchar(200),
);

create table DanhSach_ChucVu 
(
   MaCV				int primary key,
   TenChucVu		nvarchar(20) unique,
   HeSoLuongCoBan	float
);

create table NhanVien 
(
   MaNV             int,
   TenNV            nvarchar(50)	not null check (TenNV <> ''),
   ChucVu           int				not null check (ChucVu <> ''),
   GioiTinh         nvarchar(3)		not null check (GioiTinh = N'Nam' or GioiTinh = N'Nữ'),
   CMND_CCCD        varchar(11)		not null check (CMND_CCCD <> '') unique,
   SDT              varchar(11)		not null check (SDT <> ''),
   NgaySinh         date			not null check (YEAR(GETDATE()) - YEAR(NGAYSINH) >= 18),
   NoiSinh          nvarchar(20)	not null check (NoiSinh <> ''),
   DiaChi			nvarchar(100)	not null check (DiaChi <> ''),
   ThoiGianNhanViec	date			not null check (ThoiGianNhanViec <= Getdate()),
   ThoiGianThoiViec	date,
   HeSoLuong		float default 1 not null check (HeSoLuong >= 0),
   constraint PK_NhanVien primary key (MaNV),
   constraint FK_NhanVien_DSCV foreign key (ChucVu) references DanhSach_ChucVu(MaCV),
   constraint CK_NhanVien_ThoiGian check (ThoiGianNhanViec < ThoiGianThoiViec)
);

create table Luong 
(
   MaLuong		int,
   MaNV			int,
   ThoiGian		date check (ThoiGian <= Getdate()),
   TienLuong	int check (TienLuong >= 0),
   constraint PK_Luong primary key (MaLuong),
   constraint FK_Luong_NhanVien foreign key (MaNV) references NhanVien(MaNV)
);

create table Thuong 
(
   MaThuong		int primary key,
   MaNV			int,
   ThoiGian		date check(ThoiGian <= Getdate()),
   LyDo			nvarchar(50),
   TienThuong	float check(TienThuong >= 0),
   constraint FK_Thuong_NhanVien foreign key (MaNV) references NhanVien(MaNV)
);

create table Tang 
(
   SoTang	int	not null primary key
);

create table Phong 
(
   MaPhong		varchar(5)	not null primary key,
   SoTang		int not null,
   GiaDatTruoc	int not null,
   constraint FK_Phong_Tang foreign key (SoTang) references Tang(SoTang)
);

create table Ban 
(
   MaBan		int			not null primary key,
   SoBan		int			not null,
   MaPhong		varchar(5)	not null,
   GiaDatTruoc	int not null,
   constraint FK_Ban_Phong foreign key (MaPhong) references Phong(MaPhong)
);

create table HoaDon 
(
   MaHD					int primary key,
   MaNV					int not null,
   ThoiGianLap			datetime check (ThoiGianLap <= getdate()),
   TongTien				int	check(TongTien >= 0), 
   TinhTrangThanhToan	bit,
   constraint FK_HoaDon_NhanVien foreign key (MaNV) references NhanVien(MaNV)
);

create table ChiTietHoaDon_Ban
(
	MaHD				int not null,
	MaBan				int not null,
	constraint PK_ChiTietHoaDon_Ban primary key clustered (MaHD, MaBan),
    constraint FK_ChiTietHoaDon_Ban_MaHD foreign key (MaHD) references HoaDon(MaHD),
	constraint FK_ChiTietHoaDon_Ban_MaBan foreign key (MaBan) references Ban(MaBan)
);

create table ChiTietHoaDon_Phong
(
	MaHD				int not null,
	MaPhong				varchar(5) not null,
	constraint PK_ChiTietHoaDon_Phong primary key clustered (MaHD, MaPhong),
    constraint FK_ChiTietHoaDon_Phong_MaHD foreign key (MaHD) references HoaDon(MaHD),
	constraint FK_ChiTietHoaDon_Phong_MaPhong foreign key (MaPhong) references Phong(MaPhong)
);

create table DonDatTruoc 
(
   MaHD					int primary key,
   ThoiGianBatDau		datetime,
   ThoiGianKetThuc		datetime, 
   TienCoc				int,
   constraint FK_DonDatBan_MaHD foreign key (MaHD) references HoaDon(MaHD),
   constraint C_DonDatBan_ThoiGian check (ThoiGianBatDau < ThoiGianKetThuc)
);

create table VatTu 
(	
   MaVT			int				primary key,
   TenVT		nvarchar(50)	not null unique,
   NguonGoc		nvarchar(30)	not null,
   DonViTinh	nvarchar(10)	not null,
   SoLuong		float			default 0,
   DonGia		int				default 0  check (DonGia >= 0)
);

create table MonAn 
(
   MaMA			int				primary key not null,
   TenMA		nvarchar(100)	not null unique, 
   DonGia		int				default 0 check (DonGia >= 0),
   DonViTinh    nvarchar(10)	not null
);

create table ChiTietHoaDon
(
   MaHD			int,
   MaMA         int,
   SoLuong		int	not null check (SoLuong >= 0),
   constraint PK_ChiTietHoaDon primary key clustered (MaHD, MaMA),
   constraint FK_ChiTietHoaDon_MaMA foreign key (MaMA) references MonAn(MaMA),
   constraint FK_ChiTietHoaDon_MaHD foreign key (MaHD) references HoaDon(MaHD)
);

create table CheBien 
(
   MaMA				int	foreign key (MaMA) references MonAn(MaMA) not null,
   MaVT				int	foreign key (MaVT) references VatTu(MaVT) not null, 
   SoLuongTieuThu	float not null check (SoLuongTieuThu > 0),
   constraint PK_CheBien primary key (MaMA, MaVT)
);

create table NhapKho 
(
   MaNK			int			primary key,
   MaVT			int			foreign key (MaVT) references VatTu(MaVT), 
   MaNV			int			foreign key (MaNV) references NhanVien(MaNV),
   ThoiGianNhap	datetime	check (ThoiGianNhap <= getdate())	not null,
   SoLuongNhap	float		not null check (SoLuongNhap > 0),
   DonGiaNhap	int			not null check (DonGiaNhap >= 0), 
);

create table TaiKhoan 
(
   MaNV			int    not null,
   MatKhau      varchar(20)    not null,
   constraint PK_TaiKhoan primary key (MaNV),
   constraint FK_TaiKhoan_NhanVien_MaNV foreign key (MaNV) references NhanVien(MaNV)
);

insert into ThongTin values
(N'Mã khẩn cấp', '2002')

insert into DanhSach_ChucVu values
(1, N'Quản lý', 8),
(2, N'Bếp trưởng', 6),
(3, N'Đầu bếp', 6),
(4, N'Phục vụ', 4.5),
(5, N'Lao công', 3),
(6, N'Thu ngân', 5)

set dateformat dmy
insert into NhanVien values
(1, N'Trần Đức Nhật Nam', 1, N'Nam', '123456789', '987654321', '27/07/2002', N'TPHCM', N'29/9 Trần Hữu Trang, phường 11, quận Phú Nhuận, TPHCM','20/10/2022', NULL, 12),
(2, N'Nguyễn Thị Thương', 2, N'Nữ', '1357913579', '2133557799', '12/12/2000', N'Hà Nội', N'TPHCM','10/10/2021', NULL, 9),
(3, N'Chu Huy Khánh', 6, N'Nam', '2001207017', '2244668800', '11/09/2001', N'Ninh Thuận', N'TPHCM','20/02/2022', NULL, 6.5),
(4, N'Huỳnh Thế Bảo', 5, N'Nam', '999888777', '111222333', '01/01/1999', N'Bắc Kạn', N'TPHCM','19/02/2022', NULL, 4),
(5, N'Nguyễn Thanh Tâm', 4, N'Nữ', '222444666', '999777555', '24/06/2003', N'Đồng Nai', N'TPHCM','30/12/2021', NULL, 5.8)

insert into MonAn values
(1, N'Gà tiềm thuốc bắc', 150000, N'Nồi'),
(2, N'Bò bít tết', 80000, N'Miếng'),
(3, N'Salad', 25000, N'Dĩa'),
(4, N'Cơm tấm', 30000, 'Đĩa'),
(5, N'Phở bò', 35000, 'Tô'),
(6, N'Bánh mì', 15000, 'Cái'),
(7, N'Gà rán', 45000, 'Miếng')

insert into TaiKhoan values
(1, '123'),
(3, '123')

INSERT INTO Luong
VALUES 
(1, 1, '01/04/2022', 15000000),
(2, 2, '01/03/2021', 12000000),
(3, 3, '24/02/2020', 9000000),
(4, 4, '21/08/2021', 8000000),
(5, 5, '19/02/2022', 7000000),
(6, 1, '01/02/2021', 14000000)

INSERT INTO Thuong
VALUES 
(1, 1, '20/01/2022', N'Thưởng tháng 13', 5000000),
(2, 2, '10/06/2022', N'Thưởng kết quả kinh doanh', 20000000),
(3, 3, '01/02/2022', N'Thưởng doanh số cá nhân', 10000000),
(4, 4, '31/05/2022', N'Thưởng đạt mục tiêu', 3000000),
(5, 5, '01/03/2022', N'Thưởng chuyên cần', 1000000)

INSERT INTO Tang
VALUES (1), (2), (3)

INSERT INTO Phong
VALUES 
('101', 1, 1000000), 
('102', 1, 1500000), 
('201', 2, 1200000), 
('202', 2, 1800000)

INSERT INTO Ban
VALUES 
(1, 1, '101', 100000), 
(2, 2, '101', 100000), 
(3, 1, '102', 150000), 
(4, 2, '102', 150000), 
(5, 1, '201', 120000), 
(6, 2, '201', 120000), 
(7, 1, '202', 180000), 
(8, 2, '202', 180000)

INSERT INTO VatTu
VALUES 
(1, N'Thịt bò', N'Việt Nam', 'Kg', 0, 200000),
(2, N'Tôm', N'Việt Nam', 'Kg', 0, 300000),
(3, N'Bắp cải', N'Hà Lan', 'Kg', 0, 50000),
(4, N'Hành tây', N'Việt Nam', 'Kg', 0, 20000),
(5, N'Gừng', N'Việt Nam', 'Kg', 0, 100000)

INSERT INTO CheBien (MaMA, MaVT, SoLuongTieuThu) VALUES
(1, 1, 2.5),
(1, 2, 3.0),
(2, 1, 1.5),
(2, 3, 2.0),
(3, 2, 4.5);