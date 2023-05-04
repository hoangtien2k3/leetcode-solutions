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
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace HospitalManagementSysteam
{
    public partial class FormTimKiem : Form
    {
        SqlConnection Con = Connection.getConnection();
        public FormTimKiem()
        {
            InitializeComponent();
        }


        // LOAD tất cả dữ liệu MaBN từ database lên combobox 
        private void LoadDataToComboBoxTKBN()
        {
            string query = "SELECT MaBN FROM BenhNhan;";
            using (SqlConnection connection = Connection.getConnection())
            {
                SqlCommand command = new SqlCommand(query, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    cbbTKBN.Items.Add(reader.GetString(0));
                }
                reader.Close();
                command.Dispose();
                connection.Close();
            }
        }

        // LOAD tất cả dữ liệu MaBN từ database lên combobox 
        private void LoadDataToComboBoxTKBS()
        {
            string query = "SELECT MaBS FROM BacSi;";
            using (SqlConnection connection = Connection.getConnection())
            {
                SqlCommand command = new SqlCommand(query, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    cbbTKBS.Items.Add(reader.GetString(0));
                }
                reader.Close();
                command.Dispose();
                connection.Close();
            }
        }

        private void btnTimKiemBenhNhan_Click(object sender, EventArgs e)
        {
            Con.Open();
            // dấu '%' là wildcard character (đại diện cho bất kỳ ký tự nào).
            string query = "SELECT * FROM BenhNhan WHERE MaBN LIKE '%' + @cbbTKBN + '%' OR TenBN LIKE '%' + @cbbTKBN + '%'";
            SqlCommand command = new SqlCommand(query, Con);
            string KTBN = string.IsNullOrEmpty(cbbTKBN.Text) ? cbbTKBN.SelectedItem.ToString() : cbbTKBN.Text;
            command.Parameters.AddWithValue("@cbbTKBN", KTBN); // Thêm giá trị của TextBox vào Parameter
            SqlDataAdapter adapter = new SqlDataAdapter(command);
            DataTable table = new DataTable();
            adapter.Fill(table);
            ThongTinBenhNhanGV.DataSource = table;
            Con.Close();
        }

        private void txtTimKiemBenhNhan_TextChanged(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void btnTimKiemBacSi_Click(object sender, EventArgs e)
        {
            Con.Open();
            // dấu '%' là wildcard character (đại diện cho bất kỳ ký tự nào).
            string query = "SELECT * FROM BacSi WHERE MaBS LIKE '%' + @cbbTKBS + '%' OR TenBS LIKE '%' + @cbbTKBS + '%'";
            SqlCommand command = new SqlCommand(query, Con);
            string KTBS = string.IsNullOrEmpty(cbbTKBS.Text) ? cbbTKBS.SelectedItem.ToString() : cbbTKBS.Text;
            command.Parameters.AddWithValue("@cbbTKBS", KTBS); // Thêm giá trị của TextBox vào Parameter
            SqlDataAdapter adapter = new SqlDataAdapter(command);
            DataTable table = new DataTable();
            adapter.Fill(table);
            ThongTinBacSiGV.DataSource = table;
            Con.Close();
        }

        private void btnLamSachBN_Click(object sender, EventArgs e)
        {
            cbbTKBN.Text = "";
            ThongTinBenhNhanGV.DataSource = null; // hoặc ThongTinBenhNhanGV.DataSource = new DataTable();
        }

        private void btnLamSachBS_Click(object sender, EventArgs e)
        {
            cbbTKBS.Text = "";
            ThongTinBacSiGV.DataSource= null;
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void txtTimKiemBacSi_TextChanged(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void FormTimKiem_Load(object sender, EventArgs e)
        {
            // load tất cả thông tin cần tìm kiếm từ database lên combobox 
            LoadDataToComboBoxTKBN();
            LoadDataToComboBoxTKBS();
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {

        }

        private void cbbTKBN_SelectedIndexChanged(object sender, EventArgs e)
        {

        }


        // dùng để convert đường dẫn ảnh sang mảng byte[] để lưu trữ vào DB
        private byte[] convert()
        {
            FileStream fileStream = new FileStream(txtImageData.Text, FileMode.Open, FileAccess.Read);
            byte[] data = new byte[fileStream.Length];
            fileStream.Read(data, 0, System.Convert.ToInt32(fileStream.Length));
            fileStream.Close();
            return data;
        }

        private void ThongTinBenhNhanGV_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && e.ColumnIndex >= 0)
            {
                // DataGridViewRow row = BenhNhanGV.Rows[e.RowIndex];
                DataGridViewRow row = ThongTinBenhNhanGV.CurrentRow;

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


                // Lấy thông tin ảnh từ cơ sở dữ liệu
                byte[] imageBytes = (byte[])row.Cells["ImageData"].Value;

                // Chuyển đổi dữ liệu Binary về kiểu Image
                MemoryStream ms = new MemoryStream(imageBytes);
                Image image = Image.FromStream(ms);

                // Hiển thị ảnh lên PictureBox
                ptbTimKiemBenhNhan.Image = image;

                MessageBox.Show(result);
            }
        }

        private void ThongTinBacSiGV_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && e.ColumnIndex >= 0)
            {
                // DataGridViewRow row = BenhNhanGV.Rows[e.RowIndex];
                DataGridViewRow row = ThongTinBacSiGV.CurrentRow;

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

        private void ptbTimKiemBenhNhan_Click(object sender, EventArgs e)
        {

        }
    }
}
