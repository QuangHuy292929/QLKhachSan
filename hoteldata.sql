-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 03, 2024 lúc 10:48 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `hoteldata`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `MAKH` varchar(50) NOT NULL,
  `HOTEN` varchar(255) NOT NULL,
  `CCCD` varchar(25) NOT NULL,
  `SDT` varchar(25) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `PASS` mediumtext NOT NULL,
  `USERNAME` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`MAKH`, `HOTEN`, `CCCD`, `SDT`, `EMAIL`, `PASS`, `USERNAME`) VALUES
('23320240603120040', 'Le Thi Vy', '049205010484', '0329949233', 'Hanhle.06111988@gmail.com', 'dnlhc2RmZ2hqa2w=', 'levi'),
('28020240603102409', 'Ho Nguyen Khanh', '049234235332', '0343737280', 'claudehuy29@gmail.com', 'a2hhbmhhc2RmZ2hqa2w=', 'nguyenkhanh'),
('34320240603115131', 'Vo Thi Thao Ly', '049205012043', '0238942343', 'lyvo.010905@gmail.com', 'bHlhc2RmZ2hqa2w=', 'thaoly'),
('46320240602190211', 'Nguyen quang huy', '020902392093', '0982326463', 'quocbo303@gmail.com', 'aHV5aHV5YXNkZmdoamts', 'huyhuy'),
('51320240603095925', 'Vo Thanh Nam', '049205013424', '0324243513', 'quansang104@gmail.com', 'bmFtYXNkZmdoamts', 'thanhnam'),
('59820240603095248', 'Ngo Huynh Loc', '049205013098', '0789454598', 'claudehuy29@gmail.com', 'bG9jYXNkZmdoamts', 'huynhloc'),
('82420240603112057', 'Le Ngo Quoc Bo', '049205010923', '0923853824', 'claudehuy29@gmail.com', 'Ym9hc2RmZ2hqa2w=', 'quocbo'),
('89820240603114345', 'Truong Van Nhat Tan', '032895823498', '0238832898', 'truongvannhattann@gmail.com', 'dGFuYXNkZmdoamts', 'nhattan'),
('99220240602185102', 'L� Ng� Qu?c Bo', '049205100999', '0382463992', 'quocbo303@gmail.com', 'Ym9hc2RmZ2hqa2w=', 'bobo');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `datphong`
--

CREATE TABLE `datphong` (
  `MADP` varchar(255) NOT NULL,
  `MAKH` varchar(50) NOT NULL,
  `MAPHONG` int(10) NOT NULL,
  `NGAYGIOVP` varchar(50) NOT NULL,
  `NGAYGIOTP` varchar(50) NOT NULL,
  `CHIPHI` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `datphong`
--

INSERT INTO `datphong` (`MADP`, `MAKH`, `MAPHONG`, `NGAYGIOVP`, `NGAYGIOTP`, `CHIPHI`) VALUES
('25450', '46320240602190211', 101, '19:16:00 02/06/2024', '19:16:28 02/06/2024', 1200000),
('29008', '26020240530212445', 101, '21:57:33 31/05/2024', '21:57:47 31/05/2024', 800000),
('32212', '46320240602190211', 101, '20:34:10 02/06/2024', '20:34:26 02/06/2024', 800000),
('36920', '46320240602190211', 303, '20:32:37 02/06/2024', '20:33:10 02/06/2024', 2400000),
('45174', '26020240530212445', 101, '23:52:21 31/05/2024', '23:53:35 31/05/2024', 2800000),
('47870', '34320240603115131', 101, '11:54:16 03/06/2024', '11:56:36 03/06/2024', 4800000),
('48221', '46320240602190211', 101, '20:05:56 02/06/2024', '20:07:17 02/06/2024', 2800000),
('48960', '26020240530212445', 101, '21:47:56 31/05/2024', '21:48:15 31/05/2024', 800000),
('49964', '26020240530212445', 101, '16:43:12 02/06/2024', '16:46:22 02/06/2024', 6400000),
('58638', '26020240530212445', 101, '22:00:41 31/05/2024', '22:00:54 31/05/2024', 800000),
('59377', '26020240530212445', 101, '21:54:13 31/05/2024', '21:54:26 31/05/2024', 800000),
('60163', '26020240530212445', 101, '21:50:06 31/05/2024', '21:50:29 31/05/2024', 800000),
('62591', '26020240530212445', 101, '21:52:24 31/05/2024', '21:53:02 31/05/2024', 1600000),
('71420', '46320240602190211', 303, '20:35:12 02/06/2024', '20:35:40 02/06/2024', 2400000),
('82750', '99220240602185102', 101, '20:14:27 02/06/2024', '20:14:55 02/06/2024', 1200000),
('85324', '99220240602185102', 102, '20:10:59 02/06/2024', '20:11:57 02/06/2024', 2000000),
('95779', '46320240602190211', 101, '21:38:40 02/06/2024', '21:39:13 02/06/2024', 1200000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dichvu`
--

CREATE TABLE `dichvu` (
  `MADV` int(1) NOT NULL,
  `TENDV` varchar(255) NOT NULL,
  `GIACA` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `dichvu`
--

INSERT INTO `dichvu` (`MADV`, `TENDV`, `GIACA`) VALUES
(0, 'Nước lọc', 15000),
(1, 'Snack khoai tây', 20000),
(2, 'Coca/Pepsi', 20000),
(3, 'Rượu Vodka SMIRNOFF 700ML', 400000),
(4, 'Bánh KitKat', 25000),
(5, 'Nước Smartwater 500ML', 60000),
(6, 'Bia Heineken 250ML', 20000),
(7, 'Vang Ý Mango Tropical 750ML', 500000),
(8, 'Chivas Regal 18 Gold Signature 700ML', 1400000),
(9, 'Cho thuê xe tự lái', 700000),
(10, 'Dùng điểm tâm', 500000),
(11, 'Đưa đón sân bay', 200000),
(12, 'Trông trẻ', 300000),
(13, 'Tuần trăng mật', 100000),
(14, 'Giặt ủi', 3000000),
(15, 'Spa', 1500000),
(16, 'Fitness', 200000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phongks`
--

CREATE TABLE `phongks` (
  `MAPHONG` int(3) NOT NULL,
  `GIACA` int(11) NOT NULL,
  `TRANGTHAI` varchar(50) NOT NULL,
  `LoaiPhong` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phongks`
--

INSERT INTO `phongks` (`MAPHONG`, `GIACA`, `TRANGTHAI`, `LoaiPhong`) VALUES
(101, 500000, 'TRONG', 'THƯỜNG'),
(102, 500000, 'TRONG', 'THƯỜNG'),
(103, 500000, 'TRONG', 'THƯỜNG'),
(104, 500000, 'TRONG', 'THƯỜNG'),
(201, 600000, 'TRONG', 'TRUNG'),
(202, 600000, 'TRONG', 'TRUNG'),
(203, 600000, 'TRONG', 'TRUNG'),
(204, 600000, 'TRONG', 'TRUNG'),
(301, 800000, 'TRONG', 'VIP'),
(302, 800000, 'TRONG', 'VIP'),
(303, 800000, 'TRONG', 'VIP'),
(304, 800000, 'TRONG', 'VIP');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sudungthemdichvu`
--

CREATE TABLE `sudungthemdichvu` (
  `MASDDV` varchar(225) NOT NULL,
  `MADP` varchar(225) NOT NULL,
  `MADV` int(11) NOT NULL,
  `SLDV` int(25) NOT NULL,
  `CHIPHI` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sudungthemdichvu`
--

INSERT INTO `sudungthemdichvu` (`MASDDV`, `MADP`, `MADV`, `SLDV`, `CHIPHI`) VALUES
('45174177', '45174', 15, 1, 111000000),
('45174277', '45174', 11, 1, 14800000),
('45174313', '45174', 10, 1, 37000000),
('45174392', '45174', 12, 1, 22200000),
('45174663', '45174', 16, 1, 14800000),
('45174667', '45174', 9, 1, 51800000),
('45174696', '45174', 14, 1, 7400000),
('45174897', '45174', 13, 1, 222000000),
('47870269', '47870', 4, 4, 100000),
('47870342', '47870', 6, 4, 80000),
('47870379', '47870', 14, 1, 14000000),
('47870392', '47870', 15, 1, 210000000),
('47870448', '47870', 12, 1, 42000000),
('47870586', '47870', 9, 1, 98000000),
('47870734', '47870', 16, 1, 28000000),
('95779168', '95779', 9, 1, 23100000),
('95779231', '95779', 7, 4, 2000000),
('95779255', '95779', 10, 1, 16500000),
('95779372', '95779', 12, 1, 9900000),
('95779375', '95779', 14, 1, 3300000),
('95779394', '95779', 5, 7, 420000),
('95779511', '95779', 11, 1, 6600000),
('95779704', '95779', 15, 1, 49500000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thanhtoan`
--

CREATE TABLE `thanhtoan` (
  `MATHANHTOAN` varchar(225) NOT NULL,
  `MADP` varchar(100) NOT NULL,
  `NGAYGIOTT` varchar(50) NOT NULL,
  `THUE` int(50) NOT NULL,
  `TONGCHIPHI` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `thanhtoan`
--

INSERT INTO `thanhtoan` (`MATHANHTOAN`, `MADP`, `NGAYGIOTT`, `THUE`, `TONGCHIPHI`) VALUES
('3221251320:34:30 02/06/2024', '32212', '20:34:30 04/06/2024', 19909672, 135909672),
('3692012420:33:26 05/06/2024', '36920', '20:33:26 03/06/2024', 4469672, 199269672),
('4787027811:57:03 03/06/2024', '47870', '11:57:03 03/06/2024', 7463345, 404443345),
('7142040520:35:44 02/06/2024', '71420', '20:35:44 02/06/2024', 20235000, 123810000),
('8275078420:14:59 03/06/2024', '82750', '20:14:59 06/06/2024', 7829672, 184629672),
('9577914221:39:22 02/06/2024', '95779', '21:39:22 02/06/2024', 0, 91930328);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`MAKH`);

--
-- Chỉ mục cho bảng `datphong`
--
ALTER TABLE `datphong`
  ADD PRIMARY KEY (`MADP`),
  ADD KEY `MAPHONG` (`MAPHONG`);

--
-- Chỉ mục cho bảng `dichvu`
--
ALTER TABLE `dichvu`
  ADD PRIMARY KEY (`MADV`);

--
-- Chỉ mục cho bảng `phongks`
--
ALTER TABLE `phongks`
  ADD PRIMARY KEY (`MAPHONG`);

--
-- Chỉ mục cho bảng `sudungthemdichvu`
--
ALTER TABLE `sudungthemdichvu`
  ADD PRIMARY KEY (`MASDDV`),
  ADD KEY `MADV` (`MADV`),
  ADD KEY `MADP` (`MADP`);

--
-- Chỉ mục cho bảng `thanhtoan`
--
ALTER TABLE `thanhtoan`
  ADD PRIMARY KEY (`MATHANHTOAN`),
  ADD KEY `MADP` (`MADP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
