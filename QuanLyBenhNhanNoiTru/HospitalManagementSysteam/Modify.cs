using HospitalManagementSysteam;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuanLyBenhNhanNoiTru
{
    class Modify // mục đích của class Modify là lấy ra tất cả các tài khoản và add vào list<TaiKhoan>
    {
        public Modify() { } 

        SqlCommand sqlCommand;
        SqlDataReader dataReader;
        public List<TaiKhoan> TaiKhoans(string query)
        {
            List<TaiKhoan> taiKhoans = new List<TaiKhoan>();

            using(SqlConnection Con= Connection.getConnection()) {
                Con.Open();
                sqlCommand = new SqlCommand(query, Con);
                dataReader = sqlCommand.ExecuteReader();
                while(dataReader.Read())
                {
                    taiKhoans.Add(new TaiKhoan(dataReader.GetString(0), dataReader.GetString(1)));
                }
                Con.Close();
            }

            return taiKhoans;
        }


        // hàm này dùng để check tài khoản.
        public void Command(string query)
        {
            using (SqlConnection Con= Connection.getConnection()) { 
                Con.Open();
                sqlCommand = new SqlCommand(query, Con);
                sqlCommand.ExecuteNonQuery();
                Con.Close();
            }
        }

    }
}
