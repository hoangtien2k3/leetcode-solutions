using HospitalManagementSysteam;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace QuanLyBenhNhanNoiTru
{
    public partial class FormQuenMatKhau : Form
    {
        public FormQuenMatKhau()
        {
            InitializeComponent();
            labelMatKhau.Text = "";
        }

        private void button1_Click_1(object sender, EventArgs e)
        {

        }


        Modify modify = new Modify();
        private void btnLayLaiMatKhau_Click(object sender, EventArgs e)
        {
            string email = txtEmailDangKy.Text;
            if (email.Trim() == "")
            {
                MessageBox.Show("Vui lòng nhập Email đăng ký");
            } else
            {
                string query = "SELECT * FROM TaiKhoan WHERE Email = '"+email+"' ";
                if (modify.TaiKhoans(query).Count != 0)
                {
                    labelMatKhau.ForeColor = Color.Blue; // set màu cho tài khoản lấy ra 
                    labelMatKhau.Text = "Mật Khẩu: " + modify.TaiKhoans(query)[0].TenMatKhau;
                } else
                {
                    labelMatKhau.ForeColor = Color.Red;
                    labelMatKhau.Text = "Email này chưa được đăng ký";
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click_2(object sender, EventArgs e)
        {
            FormDangNhap formDangNhap = new FormDangNhap();
            this.Hide();
            formDangNhap.ShowDialog();
        }

        private void FormQuenMatKhau_Load(object sender, EventArgs e)
        {

        }

        private void FormQuenMatKhau_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                btnLayLaiMatKhau_Click(sender, e);
            }
        }
    }
}
