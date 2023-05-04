using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ProgressBar;

namespace HospitalManagementSysteam
{
    public partial class FormBacSi : Form
    {
        SqlConnection Con = Connection.getConnection();
        
        public FormBacSi()
        {
            InitializeComponent();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            MainForm h = new MainForm();
            h.Show();
            this.Hide();
        }


        void ConnectBacSi()
        {
            try
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
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            
        }


        private void button1_Click(object sender, EventArgs e)
        {
            if (txtMaBN.Text == "" || txtMaBS.Text== "" || txtTenBS.Text == "" || txtTuoiTac.Text == "" || txtKinhNghiem.Text == "" || txtChuyenKhoa.Text == "") 
            {
                MessageBox.Show("Hãy Điền đầy đủ thông tin.");
            } else
            {
                try
                {
                    Con.Open();
                    string query = "INSERT INTO BacSi(MaBS, MaBN, TenBS, KinhNghiem, TuoiTac, ChuyenKhoa) VALUES(@MaBS, @MaBN, @TenBS, @KinhNghiem, @TuoiTac, @ChuyenKhoa)";
                    SqlCommand cmd = new SqlCommand(query, Con);

                    cmd.Parameters.AddWithValue("@MaBS", txtMaBS.Text);
                    cmd.Parameters.AddWithValue("@MaBN", txtMaBN.Text);
                    cmd.Parameters.AddWithValue("@TenBS", txtTenBS.Text);
                    cmd.Parameters.AddWithValue("@KinhNghiem", txtKinhNghiem.Text);
                    cmd.Parameters.AddWithValue("@TuoiTac", txtTuoiTac.Text);

                    if (txtChuyenKhoa.Text != "")
                    {
                        cmd.Parameters.AddWithValue("@ChuyenKhoa", txtChuyenKhoa.Text);
                    }
                    else
                    {
                        cmd.Parameters.AddWithValue("@ChuyenKhoa", txtChuyenKhoa.SelectedItem.ToString());
                    }

                    cmd.ExecuteNonQuery(); // thực thi lệnh truy vấn.
                    MessageBox.Show("Thêm Bác Sĩ Thanh Công.");
                    Con.Close();
                    ConnectBacSi();
                } catch(Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
                btnLamSach_Click(sender, e);
            }
        }

        private void DoctorForm_Load(object sender, EventArgs e)
        {
            ConnectBacSi();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Con.Open();
            DialogResult dialog = MessageBox.Show("Bạn Có Muốn Xóa Bác Sĩ.",
                "Xác Nhận",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning);

            if (dialog == DialogResult.Yes)
            {
                string query = "DELETE FROM BacSi WHERE MaBS = @MaBS";
                SqlCommand command = new SqlCommand(query, Con);

                // Truyền tham số vào câu lệnh SQL
                command.Parameters.AddWithValue("@MaBS", txtMaBS.Text);

                // Thực thi câu lệnh SQL để xóa thông tin bệnh nhân
                int result = command.ExecuteNonQuery();

                /*
                if (result > 0)
                {
                    MessageBox.Show("Xóa thông tin bác sĩ thành công!");
                }
                else
                {
                    MessageBox.Show("Không tìm thấy bác sĩ có mã " + txtMaBN.Text);
                }
                */
            }
            // Đóng kết nối
            Con.Close();

            // Cập nhật lại datagridview hiển thị danh sách bác sĩ
            ConnectBacSi();
            btnLamSach_Click(sender, e);
        }

        private void DoctorGV_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && e.ColumnIndex >= 0)
            {
                DataGridViewRow row = BacSiGV.Rows[e.RowIndex];
                txtMaBS.Text = row.Cells["MaBS"].Value.ToString();
                txtMaBN.Text = row.Cells["MaBN"].Value.ToString();
                txtTenBS.Text = row.Cells["TenBS"].Value.ToString();
                txtKinhNghiem.Text = row.Cells["KinhNghiem"].Value.ToString();
                txtTuoiTac.Text = row.Cells["TuoiTac"].Value.ToString();
                txtChuyenKhoa.SelectedItem = row.Cells["ChuyenKhoa"].Value.ToString();
            }
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            try
            {
                Con.Open();

                string query = "UPDATE BacSi SET MaBS = @MaBS, MaBN = @MaBN, TenBS = @TenBS, KinhNghiem = @KinhNghiem, TuoiTac = @TuoiTac, ChuyenKhoa = @ChuyenKhoa WHERE MaBS = @MaBS";
                SqlCommand cmd = new SqlCommand(query, Con);
                cmd.Parameters.AddWithValue("@MaBS", txtMaBS.Text);
                cmd.Parameters.AddWithValue("@MaBN", txtMaBN.Text);
                cmd.Parameters.AddWithValue("@TenBS", txtTenBS.Text);
                cmd.Parameters.AddWithValue("@KinhNghiem", txtKinhNghiem.Text);
                cmd.Parameters.AddWithValue("@TuoiTac", txtTuoiTac.Text);
                cmd.Parameters.AddWithValue("@ChuyenKhoa", txtChuyenKhoa.SelectedItem.ToString());
                cmd.ExecuteNonQuery();

                MessageBox.Show("Sửa Thông Tin Thành Công.");
                Con.Close();
                ConnectBacSi();
            } catch(Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            this.Hide();
            MainForm h = new MainForm();
            h.Show();
        }

        private void DoctorId_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnLamSach_Click(object sender, EventArgs e)
        {
            txtMaBS.Text = "";
            txtMaBN.Text = "";
            txtTenBS.Text = "";
            txtTuoiTac.Text = "";
            txtKinhNghiem.Text = "";
            txtChuyenKhoa.Text = "";
        }

        private void pictureBox3_Click_1(object sender, EventArgs e)
        {

        }

        private void FormBacSi_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.Control && e.KeyCode == Keys.S)
            {
                // ấn tổ hợp phím (Ctrl + S) để lưu thông tin bênh nhân 
                btnThemThongTin_Click(sender, e);
            }
            if (e.Control && e.KeyCode == Keys.F)
            {
                // ấn tổ hợp phím (Ctrl + D) để sửa thông tin bênh nhân 
                btnSuaThongTin_Click(sender, e);
            }
            if (e.Control && e.KeyCode == Keys.D)
            {
                // ấn tổ hợp phím (Ctrl + F) để xóa thông tin bênh nhân 
                btnXoaThongTin_Click(sender, e);
            }
        }

        // thêm thông tin bác sĩ vào database và load lên datagridview
        private void btnThemThongTin_Click(object sender, EventArgs e)
        {
            if (txtMaBN.Text == "" || txtMaBS.Text == "" || txtTenBS.Text == "" || txtTuoiTac.Text == "" || txtKinhNghiem.Text == "" || txtChuyenKhoa.Text == "")
            {
                MessageBox.Show("Hãy Điền đầy đủ thông tin.");
            }
            else
            {
                try
                {
                    Con.Open();
                    string query = "INSERT INTO BacSi(MaBS, MaBN, TenBS, KinhNghiem, TuoiTac, ChuyenKhoa) VALUES(@MaBS, @MaBN, @TenBS, @KinhNghiem, @TuoiTac, @ChuyenKhoa)";
                    SqlCommand cmd = new SqlCommand(query, Con);

                    cmd.Parameters.AddWithValue("@MaBS", txtMaBS.Text);
                    cmd.Parameters.AddWithValue("@MaBN", txtMaBN.Text);
                    cmd.Parameters.AddWithValue("@TenBS", txtTenBS.Text);
                    cmd.Parameters.AddWithValue("@KinhNghiem", txtKinhNghiem.Text);
                    cmd.Parameters.AddWithValue("@TuoiTac", txtTuoiTac.Text);

                    if (txtChuyenKhoa.Text != "")
                    {
                        cmd.Parameters.AddWithValue("@ChuyenKhoa", txtChuyenKhoa.Text);
                    }
                    else
                    {
                        cmd.Parameters.AddWithValue("@ChuyenKhoa", txtChuyenKhoa.SelectedItem.ToString());
                    }

                    cmd.ExecuteNonQuery(); // thực thi lệnh truy vấn.
                    MessageBox.Show("Thêm Bác Sĩ Thanh Công.");
                    Con.Close();
                    ConnectBacSi();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
                btnLamSach_Click(sender, e);
            }
        }

        // sửa thông tin bác sĩ vào database và load lên datagridview
        private void btnSuaThongTin_Click(object sender, EventArgs e)
        {
            try
            {
                Con.Open();

                string query = "UPDATE BacSi SET MaBS = @MaBS, MaBN = @MaBN, TenBS = @TenBS, KinhNghiem = @KinhNghiem, TuoiTac = @TuoiTac, ChuyenKhoa = @ChuyenKhoa WHERE MaBS = @MaBS";
                SqlCommand cmd = new SqlCommand(query, Con);
                cmd.Parameters.AddWithValue("@MaBS", txtMaBS.Text);
                cmd.Parameters.AddWithValue("@MaBN", txtMaBN.Text);
                cmd.Parameters.AddWithValue("@TenBS", txtTenBS.Text);
                cmd.Parameters.AddWithValue("@KinhNghiem", txtKinhNghiem.Text);
                cmd.Parameters.AddWithValue("@TuoiTac", txtTuoiTac.Text);
                cmd.Parameters.AddWithValue("@ChuyenKhoa", txtChuyenKhoa.SelectedItem.ToString());
                cmd.ExecuteNonQuery();

                MessageBox.Show("Sửa Thông Tin Thành Công.");
                Con.Close();
                ConnectBacSi();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        // xóa thông tin bác sĩ vào database và load lên datagridview
        private void btnXoaThongTin_Click(object sender, EventArgs e)
        {
            Con.Open();
            DialogResult dialog = MessageBox.Show("Bạn Có Muốn Xóa Bác Sĩ.",
                "Xác Nhận",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning);

            if (dialog == DialogResult.Yes)
            {
                string query = "DELETE FROM BacSi WHERE MaBS = @MaBS";
                SqlCommand command = new SqlCommand(query, Con);

                // Truyền tham số vào câu lệnh SQL
                command.Parameters.AddWithValue("@MaBS", txtMaBS.Text);

                // Thực thi câu lệnh SQL để xóa thông tin bệnh nhân
                int result = command.ExecuteNonQuery();

                /*
                if (result > 0)
                {
                    MessageBox.Show("Xóa thông tin bác sĩ thành công!");
                }
                else
                {
                    MessageBox.Show("Không tìm thấy bác sĩ có mã " + txtMaBN.Text);
                }
                */
            }
            // Đóng kết nối
            Con.Close();

            // Cập nhật lại datagridview hiển thị danh sách bác sĩ
            ConnectBacSi();
            btnLamSach_Click(sender, e);
        }
    }
}
