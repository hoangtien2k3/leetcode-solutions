using HospitalManagementSysteam;
using Microsoft.AnalysisServices;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ProgressBar;

namespace QuanLyBenhNhanNoiTru
{
    public partial class FormLeTan : Form
    {
        SqlConnection Con = Connection.getConnection();

        public FormLeTan()
        {
            InitializeComponent();
        }


        private void ConnectBenhNhan()
        {
            Con.Open();
            string query = "SELECT * FROM BenhNhan";
            SqlCommand sqlCommand = new SqlCommand(query, Con);
            SqlDataAdapter sqlDataAdapter = new SqlDataAdapter(sqlCommand);
            DataTable dataTable = new DataTable();
            sqlDataAdapter.Fill(dataTable);
            DanhSachBenhNhanGV.DataSource = dataTable;
            Con.Close();
        }

        private void ConnectLeTan()
        {
            Con.Open();
            string query = "SELECT * FROM LeTan";
            SqlCommand sqlCommand = new SqlCommand(query, Con);
            SqlDataAdapter sqlDataAdapter = new SqlDataAdapter(sqlCommand);
            DataTable dataTable = new DataTable();
            sqlDataAdapter.Fill(dataTable);
            DanhSachBenhNhanChoGV.DataSource = dataTable;
            Con.Close();
        }

        // lấy ảnh từ thư mục và đẩy nó lên pictureBox
        private void btnTaiAnh_Click(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();

            openFileDialog.Title = "Select an image file";
            openFileDialog.Filter = "Image Files (*.bmp;*.jpg;*.jpeg,*.png)|*.bmp;*.jpg;*.jpeg;*.png";

            if (openFileDialog.ShowDialog() == DialogResult.OK) { 
                ptbTaiAnh.Image = new Bitmap(openFileDialog.FileName);
                txtImageData.Text = openFileDialog.FileName;
            }
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

        // load thông tin MaBN từ database lên combobox
        private void LoadDataToComboBox()
        {
            string query = "SELECT MaBN FROM LeTan";
            using (SqlConnection connection = Connection.getConnection())
            {
                SqlCommand command = new SqlCommand(query, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    cbbMaBN.Items.Add(reader.GetString(0));
                }
                reader.Close();
                command.Dispose();
                connection.Close();
            }
        }

        // thêm thông tin
        private void btnThemBN_Click(object sender, EventArgs e)
        {
            if (cbbMaBN.Text == "" || txtHoTen.Text == "" || cbbDiaChi.Text == "" || cbbMaBA.Text == "" || cbbGioiTinh.Text == "" || txtNgaySinh.Text == "")
            {
                MessageBox.Show("Hãy Nhập Đầy Đủ Thông Tin");
            }
            else {
                try
                {
                    using (var connection = Connection.getConnection())
                    {
                        connection.Open();
                        string query = "INSERT INTO LeTan (MaBN, MaBA, HoTen, GioiTinh, DiaChi, NgaySinh, ImageData) VALUES (@MaBN, @MaBA, @HoTen, @GioiTinh, @DiaChi, @NgaySinh, @ImageData)";
                        var command = new SqlCommand(query, connection);

                        // thêm dữ liệu và đẩy vào combobox
                        string maBN = string.IsNullOrEmpty(cbbMaBN.Text) ? cbbMaBN.SelectedItem.ToString() : cbbMaBN.Text.Trim();
                        command.Parameters.AddWithValue("@MaBN", maBN);

                        string maBA = string.IsNullOrEmpty(cbbMaBA.Text) ? cbbMaBA.SelectedItem.ToString() : cbbMaBA.Text.Trim();
                        command.Parameters.AddWithValue("@MaBA", maBA);

                        command.Parameters.AddWithValue("@HoTen", txtHoTen.Text.Trim());

                        string gioiTinh = string.IsNullOrEmpty(cbbGioiTinh.Text) ? cbbGioiTinh.SelectedItem.ToString() : cbbGioiTinh.Text.Trim();
                        command.Parameters.AddWithValue("@GioiTinh", gioiTinh);

                        string diaChi = string.IsNullOrEmpty(cbbDiaChi.Text) ? cbbDiaChi.SelectedItem.ToString() : cbbDiaChi.Text.Trim();
                        command.Parameters.AddWithValue("@DiaChi", diaChi);

                        DateTime ngaySinh = txtNgaySinh.Value;
                        command.Parameters.AddWithValue("@NgaySinh", ngaySinh.Date);

                        command.Parameters.AddWithValue("@ImageData", convert());

                        var rowsAffected = command.ExecuteNonQuery();

                        if (rowsAffected > 0)
                        {
                            MessageBox.Show("Đã Thêm Bệnh Nhân Vào Danh Sách Chờ !!!");
                        }
                        connection.Close();
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show($"Lỗi: {ex.Message}");
                }
                finally
                {
                    ConnectLeTan();
                }
            }
        }

        private void FormLeTan_Load(object sender, EventArgs e)
        {
            ConnectLeTan(); // load tất cả dữ liệu từ DB lên 
            ConnectBenhNhan(); // load tất cả thông tin của bệnh nhân
            LoadDataToComboBox();
        }

        private void cbbMaBS_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void FormLeTan_FormClosing(object sender, FormClosingEventArgs e)
        {

        }

        private void DanhSachBenhNhanChoGV_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && e.ColumnIndex >= 0)
            {
                // Lấy thông tin bệnh nhân được chọn
                DataGridViewRow row = DanhSachBenhNhanChoGV.CurrentRow;

                // Lấy các giá trị cần thiết của bệnh nhân
                cbbMaBN.Text = row.Cells["MaBN"].Value.ToString();
                cbbMaBA.Text = row.Cells["MaBA"].Value.ToString();
                txtHoTen.Text = row.Cells["HoTen"].Value.ToString();
                cbbGioiTinh.Text = row.Cells["GioiTinh"].Value.ToString();
                cbbDiaChi.Text = row.Cells["DiaChi"].Value.ToString();
                txtNgaySinh.Value = Convert.ToDateTime(row.Cells["NgaySinh"].Value.ToString());

                // Lấy thông tin ảnh từ cơ sở dữ liệu
                byte[] imageBytes = (byte[])row.Cells["ImageData"].Value;

                // Chuyển đổi dữ liệu Binary về kiểu Image
                MemoryStream ms = new MemoryStream(imageBytes);
                Image image = Image.FromStream(ms);

                // Hiển thị ảnh lên PictureBox
                ptbTaiAnh.Image = image;
            }
        }
    }
}
