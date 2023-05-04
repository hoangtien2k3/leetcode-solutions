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
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ProgressBar;

namespace HospitalManagementSysteam
{
    public partial class FormBenhAn : Form
    {

        SqlConnection Con = Connection.getConnection();


        private void ConnectBenhAn()
        {
            Con.Open();
            string query = "SELECT * FROM BenhAn";
            SqlCommand sqlCommand = new SqlCommand(query, Con);
            SqlDataAdapter adapter = new SqlDataAdapter(sqlCommand);
            DataTable dataTable = new DataTable();
            adapter.Fill(dataTable);
            BenhAnGV.DataSource = dataTable;
            Con.Close();
        }

        public FormBenhAn()
        {
            InitializeComponent();
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            this.Hide();
            MainForm h = new MainForm();
            h.Show();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && e.ColumnIndex >= 0)
            {
                DataGridViewRow row = BenhAnGV.CurrentRow;

                cbbDoiTuong.Text = row.Cells["DoiTuong"].Value.ToString();
                cbbMaBN.Text = row.Cells["MaBN"].Value.ToString();
                txtCCCD.Text = row.Cells["CCCD"].Value.ToString();
                cbbKhoa.Text = row.Cells["Khoa"].Value.ToString();
                txtBHYT.Text = row.Cells["BHYT"].Value.ToString();
                cbbDanToc.Text = row.Cells["DanToc"].Value.ToString();
                cbbQuocTich.Text = row.Cells["QuocTich"].Value.ToString();
                cbbNgheNghiep.Text = row.Cells["NgheNghiep"].Value.ToString();
                cbbTienSuBenh.Text = row.Cells["TienSuBenh"].Value.ToString();
                cbbLoaiBenh.Text = row.Cells["LoaiBenh"].Value.ToString();
                cbbChieuCao.Text = row.Cells["ChieuCao"].Value.ToString();
                cbbCanNang.Text = row.Cells["CanNang"].Value.ToString();
                dateTimePickerNgayKhamBenh.Value = Convert.ToDateTime(row.Cells["NgayKhamBenh"].Value.ToString());

            }
        }

        private void txtNgheNhiep_TextChanged(object sender, EventArgs e)
        {

        }

        private void label4_Click_1(object sender, EventArgs e)
        {

        }


        private void btnLamMoi_Click(object sender, EventArgs e)
        {
            cbbDoiTuong.Text = "";
            cbbMaBN.Text = "";
            txtCCCD.Text = "";
            txtBHYT.Text = "";
            cbbDanToc.Text = "";
            cbbChieuCao.Text = "";
            cbbCanNang.Text = "";
            cbbLoaiBenh.Text = "";
            cbbKhoa.Text = "";
            cbbNgheNghiep.Text = "";
            cbbQuocTich.Text = "";
            cbbTienSuBenh.Text = "";
        }

        private void btnThemBenhAn_Click(object sender, EventArgs e)
        {
            if (cbbDoiTuong.Text==""||cbbMaBN.Text==""||txtCCCD.Text==""||cbbKhoa.Text==""||txtBHYT.Text==""||cbbDanToc.Text==""||cbbQuocTich.Text=="")
            {
                MessageBox.Show("Nhập đầy đủ thông tin !!!");
            } else
            {
                Con.Open();
                string query = "SELECT COUNT(*) FROM BenhAn WHERE MaBN = @MaBN";
                SqlCommand sqlCommand = new SqlCommand(query, Con);
                sqlCommand.Parameters.AddWithValue("@MaBN", cbbMaBN.Text);
                int count = Convert.ToInt32(sqlCommand.ExecuteScalar());

                if (count > 0) // Kiểm tra xem mã bệnh án đã tồn tại hay chưa
                {
                    MessageBox.Show("Mã bệnh án đã tồn tại. Hãy nhập lại mã khác.",
                        "Xác Nhận",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                } else
                {
                    try
                    {
                        query = "INSERT INTO BenhAn (DoiTuong, MaBN, CCCD, Khoa, BHYT, DanToc, QuocTich, NgheNghiep, TienSuBenh, LoaiBenh, ChieuCao, CanNang, NgayKhamBenh) VALUES (@DoiTuong, @MaBN, @CCCD, @Khoa, @BHYT, @DanToc, @QuocTich, @NgheNghiep, @TienSuBenh, @LoaiBenh, @ChieuCao, @CanNang, @NgayKhamBenh)";
                        sqlCommand = new SqlCommand(query, Con);

                        string DoiTuong = string.IsNullOrEmpty(cbbDoiTuong.Text) ? (cbbDoiTuong.SelectedItem.ToString()) : cbbDoiTuong.Text;
                        sqlCommand.Parameters.AddWithValue("@DoiTuong", DoiTuong);

                        string MaBN = string.IsNullOrEmpty(cbbMaBN.Text) ? (cbbMaBN.SelectedItem.ToString()) : cbbMaBN.Text;
                        sqlCommand.Parameters.AddWithValue("@MaBN", MaBN);

                        sqlCommand.Parameters.AddWithValue("@CCCD", txtCCCD.Text);

                        string Khoa = string.IsNullOrEmpty(cbbKhoa.Text) ? (cbbKhoa.SelectedItem.ToString()) : cbbKhoa.Text;
                        sqlCommand.Parameters.AddWithValue("@Khoa", Khoa);

                        sqlCommand.Parameters.AddWithValue("@BHYT", txtBHYT.Text);

                        string DanToc = string.IsNullOrEmpty(cbbDanToc.Text) ? (cbbDanToc.SelectedItem.ToString()) : cbbDanToc.Text;
                        sqlCommand.Parameters.AddWithValue("@DanToc", DanToc);

                        string QuocTich = string.IsNullOrEmpty(cbbQuocTich.Text) ? (cbbQuocTich.SelectedItem.ToString()) : cbbQuocTich.Text;
                        sqlCommand.Parameters.AddWithValue("@QuocTich", QuocTich);

                        string NgheNghiep = string.IsNullOrEmpty(cbbNgheNghiep.Text) ? (cbbNgheNghiep.SelectedItem.ToString()) : cbbNgheNghiep.Text;
                        sqlCommand.Parameters.AddWithValue("@NgheNghiep", NgheNghiep);

                        string TienSuBenh = string.IsNullOrEmpty(cbbTienSuBenh.Text) ? (cbbTienSuBenh.SelectedItem.ToString()) : cbbTienSuBenh.Text;
                        sqlCommand.Parameters.AddWithValue("@TienSuBenh", TienSuBenh);

                        string LoaiBenh = string.IsNullOrEmpty(cbbLoaiBenh.Text) ? (cbbLoaiBenh.SelectedItem.ToString()) : cbbLoaiBenh.Text;
                        sqlCommand.Parameters.AddWithValue("@LoaiBenh", LoaiBenh);

                        string ChieuCao = string.IsNullOrEmpty(cbbChieuCao.Text) ? (cbbChieuCao.SelectedItem.ToString()) : cbbChieuCao.Text;
                        sqlCommand.Parameters.AddWithValue("@ChieuCao", ChieuCao);

                        string CanNang = string.IsNullOrEmpty(cbbCanNang.Text) ? (cbbCanNang.SelectedItem.ToString()) : cbbCanNang.Text;
                        sqlCommand.Parameters.AddWithValue("@CanNang", CanNang);

                        sqlCommand.Parameters.AddWithValue("@NgayKhamBenh", dateTimePickerNgayKhamBenh.Value.ToString("yyyy-MM-dd"));

                        sqlCommand.ExecuteNonQuery(); // thực hiện câu SQL (nếu không có câu này thì nó không thực hiện được câu SQL đâu)
                        MessageBox.Show("Thêm Thông Tin Bênh Án Thành Công!!!" + "\n\t + Mã Bệnh Nhân: " + cbbMaBN.Text);
                    }
                    catch {
                        MessageBox.Show("Thêm Thông Tin Bệnh Án Không Thành Công !!!", "Xác Nhận", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }

                Con.Close();
                ConnectBenhAn(); // show du lieu ra GV
                btnLamMoi_Click(sender, e);
                lblMaBN_Click(sender, e);
            }
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

        private void FormBenhAn_Load(object sender, EventArgs e)
        {
            ConnectBenhAn(); // show dữ liệu ra datagridview
            LoadDataToComboBoxMaBN();  // load tất cả MaBN lên combobox
        }

        private void btnSuaBenhAn_Click(object sender, EventArgs e)
        {
            try
            {
                Con.Open();
                string query = "UPDATE BenhAn SET DoiTuong=@DoiTuong, MaBN=@MaBN, CCCD=@CCCD, Khoa=@Khoa, BHYT=@BHYT, DanToc=@DanToc, QuocTich=@QuocTich, NgheNghiep=@NgheNghiep, TienSuBenh=@TienSuBenh, LoaiBenh=@LoaiBenh, ChieuCao=@ChieuCao, CanNang=@CanNang, NgayKhamBenh=@NgayKhamBenh WHERE MaBN = @MaBN";
                SqlCommand sqlCommand = new SqlCommand(query, Con);

                string DoiTuong = string.IsNullOrEmpty(cbbDoiTuong.Text) ? (cbbDoiTuong.SelectedItem.ToString()) : cbbDoiTuong.Text;
                sqlCommand.Parameters.AddWithValue("@DoiTuong", DoiTuong);

                string MaBN = string.IsNullOrEmpty(cbbMaBN.Text) ? (cbbMaBN.SelectedItem.ToString()) : cbbMaBN.Text;
                sqlCommand.Parameters.AddWithValue("@MaBN", MaBN);

                sqlCommand.Parameters.AddWithValue("@CCCD", txtCCCD.Text);

                string Khoa = string.IsNullOrEmpty(cbbKhoa.Text) ? (cbbKhoa.SelectedItem.ToString()) : cbbKhoa.Text;
                sqlCommand.Parameters.AddWithValue("@Khoa", Khoa);

                sqlCommand.Parameters.AddWithValue("@BHYT", txtBHYT.Text);

                string DanToc = string.IsNullOrEmpty(cbbDanToc.Text) ? (cbbDanToc.SelectedItem.ToString()) : cbbDanToc.Text;
                sqlCommand.Parameters.AddWithValue("@DanToc", DanToc);

                string QuocTich = string.IsNullOrEmpty(cbbQuocTich.Text) ? (cbbQuocTich.SelectedItem.ToString()) : cbbQuocTich.Text;
                sqlCommand.Parameters.AddWithValue("@QuocTich", QuocTich);

                string NgheNghiep = string.IsNullOrEmpty(cbbNgheNghiep.Text) ? (cbbNgheNghiep.SelectedItem.ToString()) : cbbNgheNghiep.Text;
                sqlCommand.Parameters.AddWithValue("@NgheNghiep", NgheNghiep);

                string TienSuBenh = string.IsNullOrEmpty(cbbTienSuBenh.Text) ? (cbbTienSuBenh.SelectedItem.ToString()) : cbbTienSuBenh.Text;
                sqlCommand.Parameters.AddWithValue("@TienSuBenh", TienSuBenh);

                string LoaiBenh = string.IsNullOrEmpty(cbbLoaiBenh.Text) ? (cbbLoaiBenh.SelectedItem.ToString()) : cbbLoaiBenh.Text;
                sqlCommand.Parameters.AddWithValue("@LoaiBenh", LoaiBenh);

                string ChieuCao = string.IsNullOrEmpty(cbbChieuCao.Text) ? (cbbChieuCao.SelectedItem.ToString()) : cbbChieuCao.Text;
                sqlCommand.Parameters.AddWithValue("@ChieuCao", ChieuCao);

                string CanNang = string.IsNullOrEmpty(cbbCanNang.Text) ? (cbbCanNang.SelectedItem.ToString()) : cbbCanNang.Text;
                sqlCommand.Parameters.AddWithValue("@CanNang", CanNang);

                sqlCommand.Parameters.AddWithValue("@NgayKhamBenh", dateTimePickerNgayKhamBenh.Value.ToString("yyyy-MM-dd"));

                sqlCommand.ExecuteNonQuery(); // thực hiện câu SQL (nếu không có câu này thì nó không thực hiện được câu SQL đâu)
                
                MessageBox.Show("Sửa Thông Tin Bênh Án Thành Công !");
                Con.Close();
                ConnectBenhAn();
                lblMaBN_Click(sender, e);
            } catch(Exception ex)
            {
                MessageBox.Show("Sửa Thông Tin Bệnh Án không thanh công !!!");
            }
        }

        private void BtnXoaBenhAn_Click(object sender, EventArgs e)
        {
            try
            {
                Con.Open();

                DialogResult dialog = MessageBox.Show("Bạn Có Muốn Xóa Bệnh Nhân.",
                    "Xác Nhận",
                    MessageBoxButtons.YesNo,
                    MessageBoxIcon.Warning);

                if (dialog == DialogResult.Yes)
                {
                    string query = "DELETE FROM BenhAn WHERE MaBN = @MaBN";
                    SqlCommand command = new SqlCommand(query, Con);

                    // Truyền tham số vào câu lệnh SQL
                    command.Parameters.AddWithValue("@MaBN", cbbMaBN.Text);

                    // Thực thi câu lệnh SQL để xóa thông tin bệnh án
                    int result = command.ExecuteNonQuery();
                }

                Con.Close(); // Đóng kết nối
                // Cập nhật lại datagridview hiển thị danh sách bệnh nhân
                ConnectBenhAn();
                btnLamMoi_Click(sender, e); // xóa tất cả thông tin show ra ở phần nhập thông tin
            }
            catch(Exception ex)
            {
                MessageBox.Show("Xóa Thông Tin Bệnh Án Không Thành Công !!!");
            }
        }

        private void txtTimKiem_TextChanged(object sender, EventArgs e)
        {
            
        }

        private void btnTimKiem_Click(object sender, EventArgs e)
        {

            if (txtTimKiemBenhAn.Text == cbbMaBN.Text || txtTimKiemBenhAn.Text == txtBHYT.Text)
            {
                string strTimKiem = "\t--- Thông Tin Bệnh Án ---" + "\n\n- Đối tượng: "  + cbbDoiTuong.Text.Trim() +
                    "\n  + Mã BN: " + cbbMaBN.Text +
                    "\n  + CCCD: " + txtCCCD.Text +
                    "\n  + Khoa: " + cbbKhoa.Text +
                    "\n  + BHYT: " + txtBHYT.Text +
                    "\n  + Dân Tộc: " + cbbDanToc.Text +
                    "\n  + Quốc Tịch: " + cbbQuocTich.Text +
                    "\n  + Nghề Nghiệp: " + cbbNgheNghiep.Text +
                    "\n  + Tiền Sử Bệnh: " + cbbTienSuBenh.Text +
                    "\n  + Loại Bệnh: " + cbbLoaiBenh.Text +
                    "\n  + Chiều Cao: " + cbbChieuCao.Text +
                    "\n  + Cân Nặng: " + cbbCanNang.Text +
                    "\n  + Ngày Khám Bệnh: " + dateTimePickerNgayKhamBenh.Text;

                MessageBox.Show(strTimKiem);
            }
            else
            {
                MessageBox.Show("Không Tìm Thấy Bệnh Án !!!");
            }
        }

        private void lblMaBN_Click(object sender, EventArgs e)
        {
            lblMaBN.Text = cbbMaBN.Text;
        }

        private void cbbMaBN_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void FormBenhAn_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.Control && e.KeyCode == Keys.S)
            {
                // ấn tổ hợp phím (Ctrl + S) để lưu thông tin bênh nhân 
                btnThemBenhAn_Click(sender, e);
            }
            if (e.Control && e.KeyCode == Keys.F)
            {
                // ấn tổ hợp phím (Ctrl + D) để sửa thông tin bênh nhân 
                btnSuaBenhAn_Click(sender, e);
            }
            if (e.Control && e.KeyCode == Keys.D)
            {
                // ấn tổ hợp phím (Ctrl + F) để xóa thông tin bênh nhân 
                BtnXoaBenhAn_Click(sender, e);
            }
            if (e.KeyCode == Keys.Space)
            {
                // Xử lý sự kiện ấn phím Space tại đây
                btnLamMoi_Click(sender, e);
            }
        }
    }
}
