using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace HospitalManagementSysteam
{
    public partial class FormBatDau : Form
    {
        public FormBatDau()
        {
            InitializeComponent();
        }

        int startpos = 0; // vị trí bắt đầu thời gian là 0;
        private void timer1_Tick(object sender, EventArgs e)
        {
            startpos += 1;
            MyprogressBar.Value = startpos;
            if (MyprogressBar.Value == 100)
            {
                MyprogressBar.Value = 0;
                timer1.Stop();
                FormDangNhap log = new FormDangNhap();
                log.Show();
                this.Hide();
            }
        }

        private void progressBar1_Click(object sender, EventArgs e)
        {
            
        }

        private void FormBatDau_Load(object sender, EventArgs e)
        {
            timer1.Start();
        }
    }
}
