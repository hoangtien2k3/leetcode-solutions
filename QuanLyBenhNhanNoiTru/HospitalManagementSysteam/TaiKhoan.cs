using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuanLyBenhNhanNoiTru
{
    class TaiKhoan
    {
        private string tenTaiKhoan;
        private string tenMatKhau;

        public TaiKhoan()
        {
        }

        public TaiKhoan(string taiKhoan, string matKhau)
        {
            this.tenTaiKhoan = taiKhoan ?? throw new ArgumentNullException(nameof(taiKhoan));
            this.tenMatKhau = matKhau ?? throw new ArgumentNullException(nameof(matKhau));
        }

        public string TenTaiKhoan { get => tenTaiKhoan; set => tenTaiKhoan = value; }
        public string TenMatKhau { get => tenMatKhau; set => tenMatKhau = value; }
    }
}
