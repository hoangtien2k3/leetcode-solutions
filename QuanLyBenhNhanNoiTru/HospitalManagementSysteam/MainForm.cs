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
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();
            FormDangNhap form = new FormDangNhap();
            form.Show();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            FormTimKiem form = new FormTimKiem();
            form.MdiParent= this;
            form.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            FormBenhAn form= new FormBenhAn();
            form.MdiParent = this;
            form.Show();
        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void pictureBoxHome_Click(object sender, EventArgs e)
        {
            FormMain form = new FormMain();
            form.MdiParent = this;
            form.Show();
        }

        private void pictureBoxHoSo_Click(object sender, EventArgs e)
        {
            FormBenhAn form = new FormBenhAn();
            form.MdiParent = this;
            form.Show();
        }

        private void pictureBoxBenhNhan_Click(object sender, EventArgs e)
        {
            FormBenhNhan form = new FormBenhNhan(); 
            form.MdiParent = this;  
            form.Show();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void pictureBoxBacSi_Click(object sender, EventArgs e)
        {
            FormBacSi form = new FormBacSi();
            form.MdiParent = this;
            form.Show();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void pictureBoxBenhAn_Click(object sender, EventArgs e)
        {
            FormHoSo benhAn= new FormHoSo();
            benhAn.MdiParent = this; 
            benhAn.Show();
        }

        private void pictureBox1_Click_1(object sender, EventArgs e)
        {
        
        }

        private void MainForm_Load(object sender, EventArgs e)
        {

        }

        private void menuStrip1_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void menuStrip1_ItemClicked_1(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {

        }

        private void btnLeTan_Click(object sender, EventArgs e)
        {
            FormLeTan form = new FormLeTan();
            form.MdiParent = this;
            form.Show();
        }

        private void button4_Click(object sender, EventArgs e)
        {

        }

        private void btnKhamBenh_Click(object sender, EventArgs e)
        {
            FormKhamBenh form = new FormKhamBenh();
            form.MdiParent = this;
            form.Show();
        }

        private void pictureBox2_Click_1(object sender, EventArgs e)
        {
            DialogResult dialog = MessageBox.Show("Bạn Có Chắc Chắn Muốn Đăng Xuất.",
                "Xác Nhận",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning);

            if (dialog == DialogResult.Yes)
            {
                this.Hide();
                FormDangNhap form = new FormDangNhap();
                form.Show();
            }
        }

        private void label8_Click(object sender, EventArgs e)
        {

        }

        private void btnLogout_Click(object sender, EventArgs e)
        {
            DialogResult dialog = MessageBox.Show("Bạn Có Chắc Chắn Muốn Đăng Xuất.",
                "Xác Nhận",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning);

            if (dialog == DialogResult.Yes)
            {
                this.Hide();
                FormDangNhap form = new FormDangNhap();
                form.Show();
            }
        }

        private void btnTimKiem_Click(object sender, EventArgs e)
        {
            FormTimKiem form = new FormTimKiem();
            form.MdiParent = this;
            form.Show();
        }

        private void button3_Click_1(object sender, EventArgs e)
        {
            FormBenhAn form = new FormBenhAn();
            form.MdiParent = this;
            form.Show();
        }

        private void button4_Click_1(object sender, EventArgs e)
        {
            FormBacSi form = new FormBacSi();
            form.MdiParent = this;
            form.Show();
        }

        private void button11_Click(object sender, EventArgs e)
        {
            FormBenhNhan form = new FormBenhNhan();
            form.MdiParent = this;
            form.Show();
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            FormHoSo form = new FormHoSo();
            form.MdiParent = this;
            form.Show();
        }

        private void btnTrangChu_Click(object sender, EventArgs e)
        {
            FormMain form = new FormMain();
            form.MdiParent = this;
            form.Show();
        }

        private void btnCaiDatPhimTat_Click(object sender, EventArgs e)
        {
            string phimtat = "CÁC PHÍM TẮT CÀI ĐẶT NHANH MẶC ĐỊNH CHO CHƯƠNG TRÌNH\n" + 
                "\n Ctrl + S: Dùng để lưu " + 
                "\n\n Ctrl + D: Dùng để xóa" + 
                "\n\n Ctrl + F: Dùng để sửa" + 
                "\n\n Ctrl + Space: Dùng để xóa khoảng trắng" + 
                "\n\n Enter: Xác nhận thông tin";

            MessageBox.Show(phimtat);
        }

        private void ptbHome_Click(object sender, EventArgs e)
        {
            FormMain form = new FormMain();
            form.MdiParent = this;
            form.Activate();
            form.Show();
        }
    }
}
