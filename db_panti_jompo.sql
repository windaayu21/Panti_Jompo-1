-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 20 Jan 2021 pada 03.49
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_panti_jompo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kamar`
--

CREATE TABLE `kamar` (
  `no_kamar` int(20) NOT NULL,
  `nama_kamar` varchar(30) NOT NULL,
  `kapasitas` int(20) NOT NULL,
  `id_pasien` int(20) NOT NULL,
  `id_pj` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kamar`
--

INSERT INTO `kamar` (`no_kamar`, `nama_kamar`, `kapasitas`, `id_pasien`, `id_pj`) VALUES
(4, '4', 88, 2, 1),
(12, 'angrek', 209, 4, 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pasien`
--

CREATE TABLE `pasien` (
  `id_pasien` int(20) NOT NULL,
  `nama_pasien` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `umur` int(3) NOT NULL,
  `tanggal_masuk` varchar(20) NOT NULL,
  `tanggal_lahir` varchar(20) NOT NULL,
  `status` varchar(30) NOT NULL,
  `id_pj` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pasien`
--

INSERT INTO `pasien` (`id_pasien`, `nama_pasien`, `jenis_kelamin`, `umur`, `tanggal_masuk`, `tanggal_lahir`, `status`, `id_pj`) VALUES
(2, '2', '2', 2, '2', '2', '2', 1),
(4, '4', '4', 4, '4', '4', 'uiuy', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penanggung_jawab`
--

CREATE TABLE `penanggung_jawab` (
  `id_pj` int(11) NOT NULL,
  `nama_pj` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `status_keluarga` varchar(30) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `no_hp` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penanggung_jawab`
--

INSERT INTO `penanggung_jawab` (`id_pj`, `nama_pj`, `jenis_kelamin`, `status_keluarga`, `alamat`, `no_hp`) VALUES
(1, '1', '1', '1', '1', 1),
(2, '2', '2', '2', '2', 2),
(3, 'faris', 'laki laki', 'isteri', 'lampung', 8965),
(9, '9', '9', '9', '9', 9);

-- --------------------------------------------------------

--
-- Struktur dari tabel `perawat`
--

CREATE TABLE `perawat` (
  `id_perawat` int(20) NOT NULL,
  `nama_perawat` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `id_pasien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `perawat`
--

INSERT INTO `perawat` (`id_perawat`, `nama_perawat`, `jenis_kelamin`, `id_pasien`) VALUES
(1, 'windah', 'perempuan', 4),
(3, '3', '3', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `ranjang`
--

CREATE TABLE `ranjang` (
  `no_ranjang` int(20) NOT NULL,
  `id_pj` int(20) NOT NULL,
  `id_pasien` int(20) NOT NULL,
  `id_perawat` int(20) NOT NULL,
  `no_kamar` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ranjang`
--

INSERT INTO `ranjang` (`no_ranjang`, `id_pj`, `id_pasien`, `id_perawat`, `no_kamar`) VALUES
(5, 1, 2, 3, 4);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `kamar`
--
ALTER TABLE `kamar`
  ADD PRIMARY KEY (`no_kamar`),
  ADD KEY `id_pasien` (`id_pasien`),
  ADD KEY `id_pj` (`id_pj`);

--
-- Indeks untuk tabel `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id_pasien`),
  ADD KEY `id_pj` (`id_pj`);

--
-- Indeks untuk tabel `penanggung_jawab`
--
ALTER TABLE `penanggung_jawab`
  ADD PRIMARY KEY (`id_pj`);

--
-- Indeks untuk tabel `perawat`
--
ALTER TABLE `perawat`
  ADD PRIMARY KEY (`id_perawat`),
  ADD KEY `id_pasien` (`id_pasien`);

--
-- Indeks untuk tabel `ranjang`
--
ALTER TABLE `ranjang`
  ADD PRIMARY KEY (`no_ranjang`),
  ADD KEY `id_pj` (`id_pj`),
  ADD KEY `id_pasien` (`id_pasien`),
  ADD KEY `id_perawat` (`id_perawat`),
  ADD KEY `no_kamar` (`no_kamar`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `kamar`
--
ALTER TABLE `kamar`
  ADD CONSTRAINT `kamar_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`);

--
-- Ketidakleluasaan untuk tabel `pasien`
--
ALTER TABLE `pasien`
  ADD CONSTRAINT `pasien_ibfk_1` FOREIGN KEY (`id_pj`) REFERENCES `penanggung_jawab` (`id_pj`);

--
-- Ketidakleluasaan untuk tabel `perawat`
--
ALTER TABLE `perawat`
  ADD CONSTRAINT `perawat_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`);

--
-- Ketidakleluasaan untuk tabel `ranjang`
--
ALTER TABLE `ranjang`
  ADD CONSTRAINT `ranjang_ibfk_1` FOREIGN KEY (`no_kamar`) REFERENCES `kamar` (`no_kamar`),
  ADD CONSTRAINT `ranjang_ibfk_2` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `ranjang_ibfk_3` FOREIGN KEY (`id_perawat`) REFERENCES `perawat` (`id_perawat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
