using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Text.RegularExpressions;
using System.Data.SqlClient;
using HospitalManagementSysteam;

namespace QuanLyBenhNhanNoiTru
{
    public partial class FormDangKyTaiKhoan : Form
    {
        public FormDangKyTaiKhoan()
        {
            InitializeComponent();
        }

        public bool checkAccount(string acc) // check mật khẩu và tài khoản.
        {
            return Regex.IsMatch(acc, "^[a-zA-Z0-9]{6,24}$");
        }

        public bool checkEmail(string email) {
            return Regex.IsMatch(email, @"^[a-zA-Z0-9_.]{3,20}@gmail.com(.vn|)$");
        }

        Modify modify = new Modify();

        private void btnDangKyTaiKhoan_Click(object sender, EventArgs e)
        {
            string taiKhoan = txtTenTaiKhoan.Text;
            string matKhau = txtMatKhau.Text;
            string xacNhanMatKhau = txtXacNhanMatKhau.Text;
            string email = txtEmail.Text;

            if (!checkAccount(taiKhoan))
            {
                MessageBox.Show("Vui lòng nhập lại tên tài khoản.");
                return;
            }
            if (!checkAccount(matKhau)) {
                MessageBox.Show("Vui lòng nhập lại mật khẩu.");
                return;
            }
            if (xacNhanMatKhau != matKhau)
            {
                MessageBox.Show("Xác nhận mật khẩu không khớp.");
                return;
            }
            if (!checkEmail(email))
            {
                MessageBox.Show("Vui lòng nhập đúng định dạng Email.");
                return;
            }
            if (modify.TaiKhoans("SELECT * FROM TaiKhoan WHERE Email = '"+email+"'").Count != 0)
            {
                MessageBox.Show("Email này đã tồn tại, vui lòng đăng ký email khác.");
                return;
            }

            try
            {
                SqlConnection Con = Connection.getConnection();
                Con.Open();

                string query = "INSERT INTO TaiKhoan(TaiKhoan, MatKhau, Email) VALUES(@TaiKhoan, @MatKhau, @Email)";
                SqlCommand sqlCommand = new SqlCommand(query, Con);
                sqlCommand.Parameters.AddWithValue("@TaiKhoan", txtTenTaiKhoan.Text);
                sqlCommand.Parameters.AddWithValue("@MatKhau", txtMatKhau.Text);
                sqlCommand.Parameters.AddWithValue("@Email", txtEmail.Text);
                sqlCommand.ExecuteNonQuery();

                Con.Close();

                if (MessageBox.Show("Chúc mừng bạn đã đăng ký thành công.", "Thông Báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
                {
                    FormDangNhap formDangNhap = new FormDangNhap();
                    this.Hide();
                    formDangNhap.ShowDialog();
                }

            } catch
            {
                MessageBox.Show("Tài khoản này đã được đăng ký, vui lòng đăng ký tài khoản khác.");
            }

        }

        private void button1_Click(object sender, EventArgs e)
        {
            FormDangNhap formDangNhap = new FormDangNhap();
            this.Hide();
            formDangNhap.ShowDialog();
        }

        private void FormDangKyTaiKhoan_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                btnDangKyTaiKhoan_Click(sender, e);
            }
        }
    }
}
