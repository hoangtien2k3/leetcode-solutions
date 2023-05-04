using Microsoft.AnalysisServices;
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
    public partial class FormBenhNhan : Form
    {
        SqlConnection Con = Connection.getConnection();

        public FormBenhNhan()
        {
            InitializeComponent();
        }

        public void ConnecBenhNhan()
        {
            Con.Open();
            string query = "SELECT * FROM BenhNhan";
            SqlCommand sqlCommand = new SqlCommand(query, Con);
            SqlDataAdapter adapter = new SqlDataAdapter(sqlCommand);
            DataTable dataTable= new DataTable();
            adapter.Fill(dataTable);
            BenhNhanGV.DataSource = dataTable;
            Con.Close();
        }

        private void btnTaiAnh_Click(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();

            openFileDialog.Title = "Select an image file";
            openFileDialog.Filter = "Image Files (*.bmp;*.jpg;*.jpeg,*.png)|*.bmp;*.jpg;*.jpeg;*.png";

            if (openFileDialog.ShowDialog() == DialogResult.OK)
            {
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

        // convert từ mảng byte[] sang string
        private string ConvertToString(byte[] data)
        {
            return Convert.ToBase64String(data);
        }

        // Thêm thông tin bệnh nhân.
        private void btnThemBenhNhan_Click(object sender, EventArgs e)
        {
            if (cbbMaBN.Text == "" || cbbTen.Text == "" || cbbDiaChi.Text == "" || txtNgaySinh.Text == "" || cbbLoaiBenh.Text == "" || txtDienThoai.Text == "" || cbbNhomMau.Text == "" || cbbLoaiBenh.Text == "" || ptbTaiAnh.Image == null)
            {
                MessageBox.Show("Hãy điền đầy đủ thông tin.");
            }
            else
            {
                Con.Open();

                string query = "SELECT COUNT(*) FROM BenhNhan WHERE MaBN = @MaBN";
                SqlCommand command = new SqlCommand(query, Con);

                string MaBN = string.IsNullOrEmpty(cbbMaBN.Text) ? cbbMaBN.SelectedItem.ToString() : cbbMaBN.Text;
                command.Parameters.AddWithValue("@MaBN", MaBN);

                int count = Convert.ToInt32(command.ExecuteScalar());
                if (count > 0) // Kiểm tra xem mã bệnh nhân đã tồn tại hay chưa
                {
                    MessageBox.Show("Mã bệnh nhân đã tồn tại. Hãy nhập lại mã khác.",
                        "Xác Nhận",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
                else
                {
                    query = "INSERT INTO BenhNhan (MaBN, TenBn, DiaChi, NgaySinh, Tuoi, DienThoai, GioiTinh, NhomMau, LoaiBenh, ImageData) VALUES (@MaBN, @TenBn, @DiaChi, @NgaySinh, @Tuoi, @DienThoai, @GioiTinh, @NhomMau, @LoaiBenh, @ImageData)";
                    command = new SqlCommand(query, Con);

                    string Mabn = string.IsNullOrEmpty(cbbMaBN.Text) ? cbbMaBN.SelectedItem.ToString() : cbbMaBN.Text;
                    command.Parameters.AddWithValue("@MaBN", Mabn);

                    string Ten = string.IsNullOrEmpty(cbbTen.Text) ? cbbTen.SelectedItem.ToString() : cbbTen.Text;
                    command.Parameters.AddWithValue("@TenBN", Ten);

                    string DiaChi = string.IsNullOrEmpty(cbbDiaChi.Text) ? cbbDiaChi.SelectedItem.ToString() : cbbDiaChi.Text;
                    command.Parameters.AddWithValue("@DiaChi", DiaChi);

                    DateTime ngaySinh = txtNgaySinh.Value;
                    string strNgaySinh = ngaySinh.ToString("yyyy-MM-dd"); // Chuyển đổi sang chuỗi theo định dạng yyyy-MM-dd
                    command.Parameters.AddWithValue("@NgaySinh", strNgaySinh);

                    string Tuoi = string.IsNullOrEmpty(cbbTuoi.Text) ? cbbTuoi.SelectedItem.ToString() : cbbTuoi.Text;
                    command.Parameters.AddWithValue("@Tuoi", Tuoi);

                    command.Parameters.AddWithValue("@DienThoai", txtDienThoai.Text);
                    command.Parameters.AddWithValue("@GioiTinh", (chkNam.Checked) ? "Nam" : "Nữ");

                    string NhomMau = string.IsNullOrEmpty(cbbNhomMau.Text) ? cbbNhomMau.SelectedItem.ToString() : cbbNhomMau.Text;
                    command.Parameters.AddWithValue("@NhomMau", NhomMau);

                    string LoaiBenh = string.IsNullOrEmpty(cbbLoaiBenh.Text) ? cbbLoaiBenh.SelectedItem.ToString() : cbbLoaiBenh.Text;
                    command.Parameters.AddWithValue("@LoaiBenh", LoaiBenh);

                    command.Parameters.AddWithValue("@ImageData", convert());

                    command.ExecuteNonQuery();

                    MessageBox.Show("Thêm Bệnh Nhân Thành Công");
                }

                Con.Close();
                ConnecBenhNhan(); // show dữ liệu ra datagridview
                
            }
        }

        private void FormBenhNhan_Load(object sender, EventArgs e)
        {
            ConnecBenhNhan(); // show dữ liệu ra datagridview
            LoadDataToComboBoxMaBN();
            LoadDataToComboBoxTenBN();
            LoadDataToComboBoxLoaiBenh();
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void txtDienThoai_TextChanged(object sender, EventArgs e)
        {

        }
        public void LockControl()
        {
            
        }


        // sửa thông tin của bệnh nhân.
        private void btnSuaBenhNhan_Click(object sender, EventArgs e)
        {
            Con.Open();

            string query = "UPDATE BenhNhan SET MaBN = @MaBN, TenBN = @TenBN, DiaChi = @DiaChi, NgaySinh = @NgaySinh, Tuoi = @Tuoi, DienThoai = @DienThoai, GioiTinh = @GioiTinh, NhomMau = @NhomMau, LoaiBenh = @LoaiBenh WHERE MaBN = @MaBN";
            SqlCommand command = new SqlCommand(query, Con);

            command.Parameters.AddWithValue("@MaBN", cbbMaBN.Text);
            command.Parameters.AddWithValue("@TenBN", cbbTen.Text);
            command.Parameters.AddWithValue("@DiaChi", cbbDiaChi.Text);

            // Chuyển đổi ngày tháng sang chuỗi định dạng yyyy-MM-dd
            string strNgaySinh = txtNgaySinh.Value.ToString("yyyy-MM-dd");
            SqlParameter parameterNgaySinh = new SqlParameter("@NgaySinh", SqlDbType.Date); // Thêm đối tượng SqlParameter vào câu lệnh truy vấn
            parameterNgaySinh.Value = strNgaySinh;
            command.Parameters.Add(parameterNgaySinh);

            command.Parameters.AddWithValue("@Tuoi", cbbTuoi.Text);
            command.Parameters.AddWithValue("@DienThoai", txtDienThoai.Text);
            command.Parameters.AddWithValue("@GioiTinh", (chkNam.Checked) ? "Nam" : "Nữ");

            command.Parameters.AddWithValue("@NhomMau", cbbNhomMau.Text);
            command.Parameters.AddWithValue("@LoaiBenh", cbbLoaiBenh.Text);

            /*
            if (txtImageData.Text == "")
            {
                command.Parameters.AddWithValue("@ImageData", convert());
            }
            */

            command.ExecuteNonQuery(); // thực hiện câu truy vấn

            MessageBox.Show("Sửa Thông Tin Bệnh Nhân Thành Công.");
            Con.Close();
            ConnecBenhNhan();
        }

        // xóa thông tin của bệnh nhân.
        private void BtnXoaBenhNhan_Click(object sender, EventArgs e)
        {
            Con.Open();

            DialogResult dialog = MessageBox.Show("Bạn Có Muốn Xóa Bệnh Nhân.",
                "Xác Nhận",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning);

            if (dialog == DialogResult.Yes)
            {
                string query = "DELETE FROM BenhNhan WHERE MaBN = @MaBN";
                SqlCommand command = new SqlCommand(query, Con);

                // Truyền tham số vào câu lệnh SQL
                command.Parameters.AddWithValue("@MaBN", cbbMaBN.Text);

                // Thực thi câu lệnh SQL để xóa thông tin bệnh nhân
                int result = command.ExecuteNonQuery();

                /*
                if (result > 0)
                {
                    MessageBox.Show("Xóa thông tin bệnh nhân thành công!");
                }
                else
                {
                    MessageBox.Show("Không tìm thấy bệnh nhân có mã " + cbbMaBN.Text);
                }
                */

                Con.Close(); // Đóng kết nối
                ConnecBenhNhan(); // Cập nhật lại datagridview hiển thị danh sách bệnh nhân
                btnLamMoi_Click(sender, e); // xóa tất cả thông tin show ra ở phần nhập thông tin
                return;
            }

            Con.Close();
        }

        // click để hiện giá trị của bệnh nhân 
        private void BenhNhanGV_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && e.ColumnIndex >= 0)
            {   
                // DataGridViewRow row = BenhNhanGV.Rows[e.RowIndex];
                DataGridViewRow row = BenhNhanGV.CurrentRow;

                cbbMaBN.Text = row.Cells["MaBN"].Value.ToString();
                cbbTen.Text = row.Cells["TenBn"].Value.ToString();
                cbbDiaChi.Text = row.Cells["DiaChi"].Value.ToString();
                txtNgaySinh.Value = Convert.ToDateTime(row.Cells["NgaySinh"].Value.ToString());
                cbbTuoi.Text = row.Cells["Tuoi"].Value.ToString();
                txtDienThoai.Text = row.Cells["DienThoai"].Value.ToString();

                if (row.Cells["GioiTinh"].Value.ToString() == "Nam")
                {
                    chkNam.Checked = true;
                }
                else if (row.Cells["GioiTinh"].Value.ToString() == "Nữ")
                {
                    chkNu.Checked = true;
                }
                else
                {
                    chkNam.Checked = false;
                    chkNu.Checked = false;
                }

                cbbNhomMau.SelectedItem = row.Cells["NhomMau"].Value.ToString();
                cbbLoaiBenh.Text = row.Cells["LoaiBenh"].Value.ToString();

                // Lấy thông tin ảnh từ cơ sở dữ liệu
                byte[] imageBytes = (byte[])row.Cells["ImageData"].Value;

                // Chuyển đổi dữ liệu Binary về kiểu Image
                MemoryStream ms = new MemoryStream(imageBytes);
                Image image = Image.FromStream(ms);

                // Hiển thị ảnh lên PictureBox
                ptbTaiAnh.Image = image;

                // Chuyển đổi dữ liệu Binary sang chuỗi Base64 string
                // Hiển thị dữ liệu Base64 string lên TextBox
                txtImageData.Text = Convert.ToBase64String(imageBytes);
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {

        }

        private void button7_Click(object sender, EventArgs e)
        {

        }

        // load tất cả MaBN lên combobox
        private void LoadDataToComboBoxMaBN()
        {
            string query = "SELECT MaBN FROM BenhNhan";

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

        // load tất cả TenBN lên combobox
        private void LoadDataToComboBoxTenBN()
        {
            string query = "SELECT TenBN FROM BenhNhan";

            using (SqlConnection connection = Connection.getConnection())
            {
                SqlCommand command = new SqlCommand(query, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    cbbTen.Items.Add(reader.GetString(0));
                }
                reader.Close();
                command.Dispose();
                connection.Close();
            }
        }

        // load tất cả LoaiBenh lên combobox
        private void LoadDataToComboBoxLoaiBenh()
        {
            string query = "SELECT LoaiBenh FROM BenhNhan";

            using (SqlConnection connection = Connection.getConnection())
            {
                SqlCommand command = new SqlCommand(query, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    cbbLoaiBenh.Items.Add(reader.GetString(0));
                }
                reader.Close();
                command.Dispose();
                connection.Close();
            }
        }


        private void btnLamMoi_Click(object sender, EventArgs e)
        {
            cbbMaBN.Text = "";
            cbbTen.Text = "";
            cbbLoaiBenh.Text = "";
            txtDienThoai.Text = "";
            cbbDiaChi.Text = "";
            cbbNhomMau.Text = "";
            cbbTuoi.Text = "";
            txtNgaySinh.Text = "";
            chkNam.Checked = false;
            chkNu.Checked = false;
            ptbTaiAnh.Image = null;
        }

        private void label11_Click(object sender, EventArgs e)
        {

        }

        private void txtMaBN_TextChanged(object sender, EventArgs e)
        {

        }

        private void pictureBox9_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox8_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox10_Click(object sender, EventArgs e)
        {

        }

        private void chkNam_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void cbbMaBN_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void lblLink_Click(object sender, EventArgs e)
        {

        }

        private void btnThemMoiBN_Click(object sender, EventArgs e)
        {
            btnLamMoi_Click(sender, e);
        }

        private void FormBenhNhan_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.Control && e.KeyCode == Keys.S)
            {
                // ấn tổ hợp phím (Ctrl + S) để lưu thông tin bênh nhân 
                btnThemBenhNhan_Click(sender, e);
            }
            if (e.Control && e.KeyCode == Keys.F)
            {
                // ấn tổ hợp phím (Ctrl + F) để sửa thông tin bênh nhân 
                btnSuaBenhNhan_Click(sender, e);
            }
            if (e.Control && e.KeyCode == Keys.D)
            {
                // ấn tổ hợp phím (Ctrl + D) để xóa thông tin bênh nhân 
                BtnXoaBenhNhan_Click(sender, e);
            }
        }

        private void FormBenhNhan_KeyPress(object sender, KeyPressEventArgs e)
        {

        }

        private void txtImageData_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
