using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ProgressBar;

namespace HospitalManagementSysteam
{
    public partial class FormHoSo : Form
    {
        SqlConnection Con = Connection.getConnection();
        public FormHoSo()
        {
            InitializeComponent();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            MainForm h = new MainForm();
            h.Show();
            this.Hide();
        }

        private void ConnecBenhNhan()
        {
            Con.Open();
            string query = "SELECT * FROM BenhNhan";
            SqlCommand sqlCommand = new SqlCommand(query, Con);
            SqlDataAdapter adapter = new SqlDataAdapter(sqlCommand);
            DataTable dataTable = new DataTable();
            adapter.Fill(dataTable);
            BenhNhanGV.DataSource = dataTable;
            Con.Close();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {

        }

        private void BenhNhanGV_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && e.ColumnIndex >= 0)
            {
                // DataGridViewRow row = BenhNhanGV.Rows[e.RowIndex];
                DataGridViewRow row = BenhNhanGV.CurrentRow;

                string result = "\tTHÔN TIN BỆNH NHÂN\n" + 
                    "\n+ Mã Bệnh Nhân: " + row.Cells["MaBN"].Value.ToString() + 
                    "\n+ Tên Bệnh Nhân: " + row.Cells["TenBn"].Value.ToString() + 
                    "\n+ Địa Chỉ: " + row.Cells["DiaChi"].Value.ToString() + 
                    "\n+ Ngày Sinh: " + row.Cells["NgaySinh"].Value.ToString() +
                    "\n+ Tuổi: " + row.Cells["Tuoi"].Value.ToString() + 
                    "\n+ Điện Thoại: " + row.Cells["DienThoai"].Value.ToString() +
                    "\n+ Giới Tính: " + row.Cells["GioiTinh"].Value.ToString() + 
                    "\n+ Nhóm Máu: " + row.Cells["NhomMau"].Value.ToString() + 
                    "\n+ Loại Bệnh: " + row.Cells["LoaiBenh"].Value.ToString();

                MessageBox.Show(result);                
            }
        }

        void ConnectBacSi()
        {
            Con.Open();
            string query = "SELECT * FROM BacSi";
            SqlCommand command = new SqlCommand(query, Con);
            SqlDataAdapter adapter = new SqlDataAdapter(command);
            DataTable dataTable = new DataTable();
            adapter.Fill(dataTable);
            BacSiGV.DataSource = dataTable;
            Con.Close();
        }

        private void BacSiGV_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && e.ColumnIndex >= 0)
            {
                // DataGridViewRow row = BenhNhanGV.Rows[e.RowIndex];
                DataGridViewRow row = BacSiGV.CurrentRow;

                string result = "\tTHÔN TIN BÁC SĨ\n" +
                    "\n+ Mã Bác Sĩ: " + row.Cells["MaBS"].Value.ToString() +
                    "\n+ Mã Bệnh Nhân: " + row.Cells["MaBN"].Value.ToString() +
                    "\n+ Tên Bác Sĩ: " + row.Cells["TenBS"].Value.ToString() +
                    "\n+ Kinh Nghiệm: " + row.Cells["KinhNghiem"].Value.ToString() +
                    "\n+ Tuổi Tác: " + row.Cells["TuoiTac"].Value.ToString() +
                    "\n+ Chuyên Khoa: " + row.Cells["ChuyenKhoa"].Value.ToString();

                MessageBox.Show(result);
            }
        }


        FormBenhNhan formBenhNhan = new FormBenhNhan();
        FormBacSi formBacSi = new FormBacSi();
        private void FormHoSo_Load(object sender, EventArgs e)
        {
            ConnecBenhNhan();
            ConnectBacSi();
        }
    }
}
