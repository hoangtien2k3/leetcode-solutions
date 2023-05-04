Use QuanLyBenhNhanNoiTru
Go

-- tạo bảng tài khoản.
Create Table TaiKhoan
(
	TaiKhoan nvarchar(30) not null primary key,
	MatKhau nvarchar(30) not null,
	Email nvarchar(50) not null
)
Go


-- tạo bảng bệnh nhân
Create Table BenhNhan
(
	MaBN nvarchar(20) not null primary key,
	TenBN nvarchar(50) not null,
	DiaChi nvarchar(100) not null,
	NgaySinh DateTime not null,
	Tuoi int not null,
	DienThoai nvarchar(15) not null,
	GioiTinh nvarchar(10) not null,
	NhomMau nvarchar(10) not null,
	LoaiBenh nvarchar(70) not null,
	ImageData VARBINARY(MAX) not null
)
Go


-- tạo bảng bác sĩ
Create Table BacSi
(
	MaBS nvarchar(30) not null primary key,
	MaBN nvarchar(30) not null,
	TenBS nvarchar(50) not null,
	KinhNghiem nvarchar(30) not null,
	TuoiTac int not null,
	ChuyenKhoa nvarchar(50) not null
)
Go


-- tạo bảng bệnh án
Create Table BenhAn
(
	MaBN nvarchar(20) not null primary key,
	DoiTuong int not null,
	CCCD varchar(14) not null,
	Khoa nvarchar(40) not null,
	BHYT nvarchar(50) not null,
	DanToc nvarchar(20) not null,
	QuocTich nvarchar(50) not null,
	NgheNghiep nvarchar(60) not null,
	TienSuBenh nvarchar(40) not null,
	LoaiBenh nvarchar(50) not null,
	ChieuCao nvarchar(20) not null,
	CanNang nvarchar(20) not null,
	NgayKhamBenh datetime
)
Go


CREATE TABLE LeTan 
(
    MaBN NVARCHAR(30) PRIMARY KEY NOT NULL,
    MaBA NVARCHAR(30) NOT NULL,
    HoTen NVARCHAR(50) NOT NULL,
    GioiTinh NVARCHAR(10) NOT NULL,
    DiaChi NVARCHAR(50) NOT NULL,
    NgaySinh DATE NOT NULL,
	ImageData VARBINARY(MAX)
);
Go

Use QuanLyBenhNhanNoiTru
Go

Create Table ThongTinKhamBenh
(
	MaBN nvarchar(50) primary key not null,
	CanNang varchar(50) not null,
	NhomMau varchar(5) not null,
	NhietDo nvarchar(30) not null,
	Mach varchar(30) not null,
	HuyetAp varchar(20) not null,
	NhipTho nvarchar(30) not null,
	LyDoKham nvarchar(500) not null,
	TinhTrangHienTai nvarchar(500) not null
)
Go


Create Table NoiDungKhamBenh
(
	MaBN nvarchar(50) primary key not null,
	ChuanDoanSoBo nvarchar(500) not null,
	YeuCauThem nvarchar(500) not null,
	HuongDieuTri nvarchar(500) not null
)
Go


