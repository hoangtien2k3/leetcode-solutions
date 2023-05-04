using HospitalManagementSysteam;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace QuanLyBenhNhanNoiTru
{
    public partial class FormKhamBenh : Form
    {
        // tạo kết nối với CSDL
        SqlConnection Con = Connection.getConnection();

        public FormKhamBenh()
        {
            InitializeComponent();
        }

        // load tất cả thông tin từ DB lên DanhSachBenhNhanChoXetNghiemGV
        private void ConnectKhamBenh()
        {
            Con.Open();
            string query = "SELECT * FROM LeTan";
            SqlCommand sqlCommand = new SqlCommand(query, Con);
            SqlDataAdapter sqlDataAdapter = new SqlDataAdapter(sqlCommand);
            DataTable dataTable = new DataTable();
            sqlDataAdapter.Fill(dataTable);
            DanhSachBenhNhanChoXetNghiemGV.DataSource = dataTable;
            Con.Close();
        }


        // lấy ảnh từ thư mục và đẩy nó lên pictureBox
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

        // load thông tin MaBN từ database lên combobox
        private void LoadDataToComboBoxMaBN()
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

        private void FormKhamBenh_Load(object sender, EventArgs e)
        {
            ConnectKhamBenh();          // load tất cả dữ liệu từ DB lên datagridview DanhSachBenhNhanChoXetNghiemGV
            LoadDataToComboBoxMaBN();   // load tất cả thông tin của MaBN lên cbbMaBN
            LoadDataToComboBoxMaBS();   // load tất cả thông tin MaBS lên cbbMaBS cbbMaBS
            LoadDataToComboBoxTenBS();  // load tất cả thông tin TenBS lên cbbTenBacSi
        }

        private void label21_Click(object sender, EventArgs e)
        {

        }

        private void DanhSachBenhNhanChoXetNghiemGV_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && e.ColumnIndex >= 0)
            {
                // Lấy thông tin bệnh nhân được chọn
                DataGridViewRow row = DanhSachBenhNhanChoXetNghiemGV.CurrentRow;

                // Lấy các giá trị cần thiết của bệnh nhân
                cbbMaBN.Text = row.Cells["MaBN"].Value.ToString();
                cbbMaBA.Text = row.Cells["MaBA"].Value.ToString();
                txtHoTen.Text = row.Cells["HoTen"].Value.ToString();
                cbbGioiTinh.Text = row.Cells["GioiTinh"].Value.ToString();
                cbbDiaChi.Text = row.Cells["DiaChi"].Value.ToString();
                txtNgaySinh.Value = Convert.ToDateTime(row.Cells["NgaySinh"].Value.ToString());

                byte[] imageBytes = (byte[])row.Cells["ImageData"].Value; // Lấy thông tin ảnh từ cơ sở dữ liệu
                MemoryStream ms = new MemoryStream(imageBytes); // Chuyển đổi dữ liệu Binary về kiểu Image
                Image image = Image.FromStream(ms);
                ptbTaiAnh.Image = image; // Hiển thị ảnh lên PictureBox
            }
        }

        private void FormKhamBenh_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.Modifiers == Keys.Control && e.KeyCode == Keys.N)
            {
                MessageBox.Show("Control + N");
            }
        }

        private String InThonTin1()
        {
            string result =
                "\n\n+ Ngày Khám: " + dtpNgayKham.Value.ToString("yyyy-MM-dd") +
                "\n+ Mã Bác Sĩ: " + cbbMaBS.Text +
                "\n+ Phòng Khám: " + cbbPhongKham.Text +
                "\n+ Tên Bác Sĩ: " + cbbTenBacSi.Text;
            return result;
        }

        private String InThonTin2()
        {
            string result = 
                "\n\n+ Cân Nặng: " + cbbCanNang.SelectedItem.ToString() +
                "\n+ Nhóm Máu: " + cbbNhomMau.SelectedItem.ToString() +
                "\n+ Nhiệt Độ: " + cbbNhietDo.SelectedItem.ToString() +
                "\n+ Mạch: " + cbbMach.SelectedItem.ToString() +
                "\n+ Huyết Áp: " + cbbHuyetAp.SelectedItem.ToString() +
                "\n+ Nhịp Thở: " + cbbNhipTho.SelectedItem.ToString() +
                "\n- Lý Do Khám: " + txtLyDoKham.Text +
                "\n- Tình Trạng Hiện Tại: " + txtTinhTrangHienTai.Text;

            return result;
        }

        private String InThonTin3()
        {
            string result = 
                "\n\n+ Chuẩn đoán hồ sơ: " + cbbChuanDoanSoBo.Text + 
                "\n+ Yêu cầu thêm: " + cbbYeuCauThem.Text + 
                "\n+ Hướng điều trị: " + cbbHuongDieuTri.Text;
            return result;
        }


        private void btnIn_Click(object sender, EventArgs e)
        {
            if (dtpNgayKham.Text==""||cbbTenBacSi.Text==""||cbbPhongKham.Text==""||cbbMaBS.Text=="")
            {
                if (cbbCanNang.Text==""||cbbNhomMau.Text==""||cbbNhietDo.Text==""||cbbMach.Text==""||cbbHuyetAp.Text==""||cbbNhipTho.Text==""||txtLyDoKham.Text==""||txtTinhTrangHienTai.Text=="")
                {
                    if (cbbChuanDoanSoBo.Text==""||cbbYeuCauThem.Text==""||cbbHuongDieuTri.Text=="")
                    {
                        MessageBox.Show("Hãy điền vào đầy đủ thông tin",
                                        "Xác Nhận",
                                        MessageBoxButtons.OK,
                                        MessageBoxIcon.Warning);
                    } else
                    {
                        MessageBox.Show("\tTHÔNG TIN KHÁM BỆNH: " + InThonTin3());
                    }
                } else
                {
                    MessageBox.Show("\tTHÔNG TIN KHÁM BỆNH: " + InThonTin2());
                }
            } else 
            {
                if (cbbCanNang.Text == "" || cbbNhomMau.Text == "" || cbbNhietDo.Text == "" || cbbMach.Text == "" || cbbHuyetAp.Text == "" || cbbNhipTho.Text == "" || txtLyDoKham.Text == "" || txtTinhTrangHienTai.Text == "")
                {
                    MessageBox.Show("\tTHÔNG TIN KHÁM BỆNH: " + InThonTin1());
                } else
                {
                    if (cbbChuanDoanSoBo.Text != "" || cbbYeuCauThem.Text != "" || cbbHuongDieuTri.Text != "")
                    {
                        MessageBox.Show("\tTHÔNG TIN KHÁM BỆNH: " + InThonTin1() + InThonTin2() + InThonTin3());
                    } else
                    {
                        MessageBox.Show("\tTHÔNG TIN KHÁM BỆNH: " + InThonTin1() + InThonTin2());
                    }
                }
            }
        }


        // load tất cả MaBS lên combobox cbbMaBS
        private void LoadDataToComboBoxMaBS()
        {
            string query = "SELECT MaBS FROM BacSi";

            using (SqlConnection connection = Connection.getConnection())
            {
                SqlCommand command = new SqlCommand(query, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    cbbMaBS.Items.Add(reader.GetString(0));
                }
                reader.Close();
                command.Dispose();
                connection.Close();
            }
        }

        // load tất cả TenBS lên combobox cbbTenBacSi
        private void LoadDataToComboBoxTenBS()
        {
            string query = "SELECT TenBS FROM BacSi";

            using (SqlConnection connection = Connection.getConnection())
            {
                SqlCommand command = new SqlCommand(query, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    cbbTenBacSi.Items.Add(reader.GetString(0));
                }
                reader.Close();
                command.Dispose();
                connection.Close();
            }
        }

        private void btnLuu_Click(object sender, EventArgs e)
        {
            if (cbbCanNang.Text == "" || cbbNhomMau.Text == "" || cbbNhietDo.Text == "" || cbbMach.Text == "" || cbbHuyetAp.Text == "" || cbbNhipTho.Text == "" || txtLyDoKham.Text == "" || txtTinhTrangHienTai.Text == "")
            {
                MessageBox.Show("Hãy điền vào đầy đủ thông tin",
                                        "Xác Nhận",
                                        MessageBoxButtons.OK,
                                        MessageBoxIcon.Warning);
            } else
            {
                Con.Open();

                string query = "SELECT COUNT(*) FROM ThongTinKhamBenh WHERE MaBN = @MaBN";
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
                    query = "INSERT INTO ThongTinKhamBenh (MaBN, CanNang, NhomMau, NhietDo, Mach, HuyetAp, NhipTho, LyDoKham, TinhTrangHienTai) VALUES (@MaBN, @CanNang, @NhomMau, @NhietDo, @Mach, @HuyetAp, @NhipTho, @LyDoKham, @TinhTrangHienTai)";
                    command = new SqlCommand(query, Con);

                    string Mabn = string.IsNullOrEmpty(cbbMaBN.Text) ? cbbMaBN.SelectedItem.ToString() : cbbMaBN.Text;
                    command.Parameters.AddWithValue("@MaBN", Mabn);

                    string CanNang = string.IsNullOrEmpty(cbbCanNang.Text) ? cbbCanNang.SelectedItem.ToString() : cbbCanNang.Text;
                    command.Parameters.AddWithValue("@CanNang", CanNang);

                    string NhomMau = string.IsNullOrEmpty(cbbNhomMau.Text) ? cbbNhomMau.SelectedItem.ToString() : cbbNhomMau.Text;
                    command.Parameters.AddWithValue("@NhomMau", NhomMau);

                    string NhietDo = string.IsNullOrEmpty(cbbNhietDo.Text) ? cbbNhietDo.SelectedItem.ToString() : cbbNhietDo.Text;
                    command.Parameters.AddWithValue("@NhietDo", NhietDo);

                    string Mach = string.IsNullOrEmpty(cbbMach.Text) ? cbbMach.SelectedItem.ToString() : cbbMach.Text;
                    command.Parameters.AddWithValue("@Mach", Mach);

                    string HuyetAp = string.IsNullOrEmpty(cbbHuyetAp.Text) ? cbbHuyetAp.SelectedItem.ToString() : cbbHuyetAp.Text;
                    command.Parameters.AddWithValue("@HuyetAp", HuyetAp);

                    string NhipTho = string.IsNullOrEmpty(cbbNhipTho.Text) ? cbbNhipTho.SelectedItem.ToString() : cbbNhipTho.Text;
                    command.Parameters.AddWithValue("@NhipTho", NhipTho);

                    command.Parameters.AddWithValue("@LyDoKham", txtLyDoKham.Text);
                    command.Parameters.AddWithValue("@TinhTrangHienTai", txtTinhTrangHienTai.Text);

                    command.ExecuteNonQuery();
                    MessageBox.Show("Lưu Thông Tin Thành Công");
                }
                Con.Close();
            }
        }

        private void btnNhapVien_Click(object sender, EventArgs e)
        {
            if (cbbChuanDoanSoBo.Text == "" || cbbYeuCauThem.Text == "" || cbbHuongDieuTri.Text == "")
            {
                MessageBox.Show("Hãy điền vào đầy đủ thông tin",
                                        "Xác Nhận",
                                        MessageBoxButtons.OK,
                                        MessageBoxIcon.Warning);
            }
            else
            {
                Con.Open();
                string query = "SELECT COUNT(*) FROM NoiDungKhamBenh WHERE MaBN = @MaBN";
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
                    query = "INSERT INTO NoiDungKhamBenh (MaBN, ChuanDoanSoBo, YeuCauThem, HuongDieuTri) VALUES (@MaBN, @ChuanDoanSoBo, @YeuCauThem, @HuongDieuTri)";
                    command = new SqlCommand(query, Con);

                    string Mabn = string.IsNullOrEmpty(cbbMaBN.Text) ? cbbMaBN.SelectedItem.ToString() : cbbMaBN.Text;
                    command.Parameters.AddWithValue("@MaBN", Mabn);

                    string ChuanDoanSoBo = string.IsNullOrEmpty(cbbChuanDoanSoBo.Text) ? cbbChuanDoanSoBo.SelectedItem.ToString() : cbbChuanDoanSoBo.Text;
                    command.Parameters.AddWithValue("@ChuanDoanSoBo", ChuanDoanSoBo);

                    string YeuCauThem = string.IsNullOrEmpty(cbbYeuCauThem.Text) ? cbbYeuCauThem.SelectedItem.ToString() : cbbYeuCauThem.Text;
                    command.Parameters.AddWithValue("@YeuCauThem", YeuCauThem);

                    string HuongDieuTri = string.IsNullOrEmpty(cbbHuongDieuTri.Text) ? cbbHuongDieuTri.SelectedItem.ToString() : cbbHuongDieuTri.Text;
                    command.Parameters.AddWithValue("@HuongDieuTri", HuongDieuTri);

                    command.ExecuteNonQuery();
                    MessageBox.Show("Nhập Viện Thành Công");
                }
                Con.Close();
            }
        }

        private void btnXoaTTBN_Click(object sender, EventArgs e)
        {
            Con.Open();
            string query = "SELECT COUNT(*) FROM ThongTinKhamBenh WHERE MaBN = @MaBN";
            SqlCommand command = new SqlCommand(query, Con);

            string MaBN = string.IsNullOrEmpty(cbbMaBN.Text) ? cbbMaBN.SelectedItem.ToString() : cbbMaBN.Text;
            command.Parameters.AddWithValue("@MaBN", MaBN);
            int count = Convert.ToInt32(command.ExecuteScalar());

            if (count > 0) // Kiểm tra xem mã bệnh nhân đã tồn tại hay chưa
            {
                // xóa thông tin có MaBN trong database ThongTinKhamBenh
                DialogResult dialog = MessageBox.Show("Bạn Có Muốn Xóa Bệnh Nhân (" + cbbMaBN.Text + ").",
                    "Xác Nhận",
                    MessageBoxButtons.YesNo,
                    MessageBoxIcon.Warning);
                if (dialog == DialogResult.Yes)
                {
                    query = "DELETE FROM ThongTinKhamBenh WHERE MaBN = @MaBN";
                    command = new SqlCommand(query, Con);
                    command.Parameters.AddWithValue("@MaBN", cbbMaBN.Text);
                    command.ExecuteNonQuery();
                }

                // xóa thông tin có MaBN trong database NoiDungKhamBenh
                if (dialog == DialogResult.Yes)
                {
                    query = "DELETE FROM NoiDungKhamBenh WHERE MaBN = @MaBN";
                    command = new SqlCommand(query, Con);
                    command.Parameters.AddWithValue("@MaBN", cbbMaBN.Text);
                    command.ExecuteNonQuery();
                }

                if (dialog == DialogResult.Yes)
                {
                    MessageBox.Show("Xóa Thông Tin Bệnh Nhân '" + cbbMaBN.Text + "' Khám Bệnh Thành Công!!!");
                }
            } else if (count == 0)
            {
                MessageBox.Show("Mã bệnh nhân (" + cbbMaBN.Text + ") đã được xóa, hãy chọn bệnh nhân khác!",
                    "Xác Nhận",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }

            Con.Close(); // đóng kết nối với CSDL
        }

        private void ptbTaiAnh_Click(object sender, EventArgs e)
        {

        }
    }
}
