using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Drawing;
using System.Data.SqlClient;


namespace HospitalManagementSysteam
{
    class BenhNhan
    {
        private string MaBN;
        private string TenBN;
        private string DiaChi;
        private DateTime NgaySinh;
        private int Tuoi;
        private int DienThoai;
        private string GioiTinh;
        private string NhomMau;
        private string LoaiBenh;

        public BenhNhan() { 
        
        }

        public BenhNhan(string maBN, string tenBN, string diaChi, DateTime ngaySinh, int tuoi, int dienThoai, string gioiTinh, string nhomMau, string loaiBenh)
        {
            MaBN = maBN;
            TenBN = tenBN;
            DiaChi = diaChi;
            NgaySinh = ngaySinh;
            Tuoi = tuoi;
            DienThoai = dienThoai;
            GioiTinh = gioiTinh;
            NhomMau = nhomMau;
            LoaiBenh = loaiBenh;
        }

        public string MaBN1 { get => MaBN; set => MaBN = value; }
        public string TenBN1 { get => TenBN; set => TenBN = value; }
        public string DiaChi1 { get => DiaChi; set => DiaChi = value; }
        public DateTime NgaySinh1 { get => NgaySinh; set => NgaySinh = value; }
        public int Tuoi1 { get => Tuoi; set => Tuoi = value; }
        public int DienThoai1 { get => DienThoai; set => DienThoai = value; }
        public string GioiTinh1 { get => GioiTinh; set => GioiTinh = value; }
        public string NhomMau1 { get => NhomMau; set => NhomMau = value; }
        public string LoaiBenh1 { get => LoaiBenh; set => LoaiBenh = value; }
    }
}
