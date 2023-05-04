using QuanLyBenhNhanNoiTru;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace HospitalManagementSysteam
{
    public partial class FormDangNhap : Form
    {
        public FormDangNhap()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private bool IsValidUser(string username, string password)
        {
            // Kiểm tra xem username và password có hợp lệ hay không
            return (username == "admin" && password == "password"); 
        }


        
        private void button2_Click(object sender, EventArgs e)
        {
            string taiKhoan = txtTaiKhoan.Text;
            string matKhau = txtMatKhau.Text;

            // nếu người dùng nhập khoản trắng
            if (taiKhoan.Trim() == "")
            {
                MessageBox.Show("Vui lòng nhập tài khoản.");
                return;
            }else if (matKhau.Trim() == "")
            {
                MessageBox.Show("Vui lòng nhập mật khẩu.");
                return;
            } else
            {
                string query = "SELECT * FROM TaiKhoan WHERE TaiKhoan = '"+taiKhoan+"' AND MatKhau = '"+matKhau+"'";
                if (new Modify().TaiKhoans(query).Count != 0)
                {
                    MainForm mainForm = new MainForm();
                    this.Hide();
                    mainForm.ShowDialog();
                } else
                {
                    MessageBox.Show("Tài khoản đăng nhập không đúng.", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
            }



            /*
            string username = txtTaiKhoan.Text;
            string password = txtMatKhau.Text;

            if (IsValidUser(username, password))
            {
                // Đăng nhập thành công
                MainForm home = new MainForm();
                home.Show();
                this.Hide();
            }
            else
            {
                // Hiển thị thông báo lỗi
                if (username != "admin" && password != "password") {
                    DialogResult result = MessageBox.Show("Error Username and Password", "Login Againt", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
                } else if (username != "admin")
                {
                    DialogResult result = MessageBox.Show("Error Username.", "Login Againt", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
                } else
                {
                    DialogResult result = MessageBox.Show("Error Password.", "Login Againt", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
                }
            }
            */

        }

        
        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click_1(object sender, EventArgs e)
        {
            
        }

        private void textBox1_TextChanged_1(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            txtTaiKhoan.Text = "";
            txtMatKhau.Text = "";
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            Close();
        }

        private void label6_Click(object sender, EventArgs e)
        {
            FormDangKyTaiKhoan formDangKyTaiKhoan = new FormDangKyTaiKhoan();
            this.Hide();
            formDangKyTaiKhoan.Show();
        }

        private void label3_Click(object sender, EventArgs e)
        {
            FormQuenMatKhau formQuenMatKhau = new FormQuenMatKhau();
            this.Hide();
            formQuenMatKhau.Show();
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void FormDangNhap_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                //gọi hàm đăng nhập tại đây
                button2_Click(sender, e);
            }
        }

        Modify modify = new Modify();
        private void btnDangNhap_Click(object sender, EventArgs e)
        {
            string taiKhoan = txtTaiKhoan.Text;
            string matKhau = txtMatKhau.Text;

            // nếu người dùng nhập khoản trắng
            if (taiKhoan.Trim() == "")
            {
                MessageBox.Show("Vui lòng nhập tài khoản.");
                return;
            }
            else if (matKhau.Trim() == "")
            {
                MessageBox.Show("Vui lòng nhập mật khẩu.");
                return;
            }
            else
            {
                string query = "SELECT * FROM TaiKhoan WHERE TaiKhoan = '" + taiKhoan + "' AND MatKhau = '" + matKhau + "'";
                if (new Modify().TaiKhoans(query).Count != 0)
                {
                    MainForm mainForm = new MainForm();
                    this.Hide();
                    mainForm.ShowDialog();
                }
                else
                {
                    MessageBox.Show("Tài khoản đăng nhập không đúng.", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
            }



            /*
            string username = txtTaiKhoan.Text;
            string password = txtMatKhau.Text;

            if (IsValidUser(username, password))
            {
                // Đăng nhập thành công
                MainForm home = new MainForm();
                home.Show();
                this.Hide();
            }
            else
            {
                // Hiển thị thông báo lỗi
                if (username != "admin" && password != "password") {
                    DialogResult result = MessageBox.Show("Error Username and Password", "Login Againt", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
                } else if (username != "admin")
                {
                    DialogResult result = MessageBox.Show("Error Username.", "Login Againt", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
                } else
                {
                    DialogResult result = MessageBox.Show("Error Password.", "Login Againt", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
                }
            }
            */

        }
    }
}
