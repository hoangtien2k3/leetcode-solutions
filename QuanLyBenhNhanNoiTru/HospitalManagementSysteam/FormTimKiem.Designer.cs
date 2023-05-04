namespace HospitalManagementSysteam
{
    partial class FormTimKiem
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormTimKiem));
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.ThongTinBenhNhanGV = new System.Windows.Forms.DataGridView();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.ThongTinBacSiGV = new System.Windows.Forms.DataGridView();
            this.panel1 = new System.Windows.Forms.Panel();
            this.label3 = new System.Windows.Forms.Label();
            this.btnTimKiemBenhNhan = new System.Windows.Forms.Button();
            this.btnTimKiemBacSi = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.ptbTimKiemBenhNhan = new System.Windows.Forms.PictureBox();
            this.ptbTimKiemBacSi = new System.Windows.Forms.PictureBox();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.pictureBox4 = new System.Windows.Forms.PictureBox();
            this.cbbTKBN = new System.Windows.Forms.ComboBox();
            this.cbbTKBS = new System.Windows.Forms.ComboBox();
            this.txtImageData = new System.Windows.Forms.TextBox();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ThongTinBenhNhanGV)).BeginInit();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ThongTinBacSiGV)).BeginInit();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ptbTimKiemBenhNhan)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.ptbTimKiemBacSi)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.ThongTinBenhNhanGV);
            this.groupBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBox1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.groupBox1.Location = new System.Drawing.Point(30, 225);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(556, 232);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Thông Tin Bệnh Nhân";
            // 
            // ThongTinBenhNhanGV
            // 
            this.ThongTinBenhNhanGV.BackgroundColor = System.Drawing.SystemColors.Control;
            this.ThongTinBenhNhanGV.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.ThongTinBenhNhanGV.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.ThongTinBenhNhanGV.GridColor = System.Drawing.Color.Blue;
            this.ThongTinBenhNhanGV.Location = new System.Drawing.Point(0, 19);
            this.ThongTinBenhNhanGV.Name = "ThongTinBenhNhanGV";
            this.ThongTinBenhNhanGV.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.ThongTinBenhNhanGV.Size = new System.Drawing.Size(555, 213);
            this.ThongTinBenhNhanGV.TabIndex = 0;
            this.ThongTinBenhNhanGV.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.ThongTinBenhNhanGV_CellContentClick);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Modern No. 20", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(183, 150);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(123, 15);
            this.label1.TabIndex = 1;
            this.label1.Text = "Search Bệnh Nhân";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Modern No. 20", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(725, 150);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(92, 15);
            this.label2.TabIndex = 3;
            this.label2.Text = "Search Bác Sĩ";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.ThongTinBacSiGV);
            this.groupBox2.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBox2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.groupBox2.Location = new System.Drawing.Point(620, 225);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(398, 232);
            this.groupBox2.TabIndex = 5;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Thông Tin Bác Sĩ:";
            // 
            // ThongTinBacSiGV
            // 
            this.ThongTinBacSiGV.BackgroundColor = System.Drawing.SystemColors.Control;
            this.ThongTinBacSiGV.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.ThongTinBacSiGV.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.ThongTinBacSiGV.GridColor = System.Drawing.Color.Blue;
            this.ThongTinBacSiGV.Location = new System.Drawing.Point(0, 19);
            this.ThongTinBacSiGV.Name = "ThongTinBacSiGV";
            this.ThongTinBacSiGV.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.ThongTinBacSiGV.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.ThongTinBacSiGV.Size = new System.Drawing.Size(383, 213);
            this.ThongTinBacSiGV.TabIndex = 0;
            this.ThongTinBacSiGV.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.ThongTinBacSiGV_CellContentClick);
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.Purple;
            this.panel1.Controls.Add(this.label3);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(1030, 58);
            this.panel1.TabIndex = 6;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.White;
            this.label3.Location = new System.Drawing.Point(387, 18);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(259, 29);
            this.label3.TabIndex = 0;
            this.label3.Text = "TÌM KIẾM THÔNG TIN";
            this.label3.Click += new System.EventHandler(this.label3_Click);
            // 
            // btnTimKiemBenhNhan
            // 
            this.btnTimKiemBenhNhan.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.btnTimKiemBenhNhan.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("btnTimKiemBenhNhan.BackgroundImage")));
            this.btnTimKiemBenhNhan.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnTimKiemBenhNhan.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnTimKiemBenhNhan.ForeColor = System.Drawing.Color.Yellow;
            this.btnTimKiemBenhNhan.Location = new System.Drawing.Point(412, 161);
            this.btnTimKiemBenhNhan.Name = "btnTimKiemBenhNhan";
            this.btnTimKiemBenhNhan.Size = new System.Drawing.Size(106, 34);
            this.btnTimKiemBenhNhan.TabIndex = 7;
            this.btnTimKiemBenhNhan.Text = "Tìm Kiếm";
            this.btnTimKiemBenhNhan.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btnTimKiemBenhNhan.UseVisualStyleBackColor = false;
            this.btnTimKiemBenhNhan.Click += new System.EventHandler(this.btnTimKiemBenhNhan_Click);
            // 
            // btnTimKiemBacSi
            // 
            this.btnTimKiemBacSi.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.btnTimKiemBacSi.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnTimKiemBacSi.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnTimKiemBacSi.ForeColor = System.Drawing.Color.Yellow;
            this.btnTimKiemBacSi.Location = new System.Drawing.Point(904, 162);
            this.btnTimKiemBacSi.Name = "btnTimKiemBacSi";
            this.btnTimKiemBacSi.Size = new System.Drawing.Size(99, 34);
            this.btnTimKiemBacSi.TabIndex = 8;
            this.btnTimKiemBacSi.Text = "Tìm Kiếm";
            this.btnTimKiemBacSi.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btnTimKiemBacSi.UseVisualStyleBackColor = false;
            this.btnTimKiemBacSi.Click += new System.EventHandler(this.btnTimKiemBacSi_Click);
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.Color.Silver;
            this.button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button1.Location = new System.Drawing.Point(602, 225);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(2, 250);
            this.button1.TabIndex = 12;
            this.button1.UseVisualStyleBackColor = false;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // ptbTimKiemBenhNhan
            // 
            this.ptbTimKiemBenhNhan.Image = ((System.Drawing.Image)(resources.GetObject("ptbTimKiemBenhNhan.Image")));
            this.ptbTimKiemBenhNhan.Location = new System.Drawing.Point(41, 85);
            this.ptbTimKiemBenhNhan.Name = "ptbTimKiemBenhNhan";
            this.ptbTimKiemBenhNhan.Size = new System.Drawing.Size(104, 111);
            this.ptbTimKiemBenhNhan.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.ptbTimKiemBenhNhan.TabIndex = 15;
            this.ptbTimKiemBenhNhan.TabStop = false;
            this.ptbTimKiemBenhNhan.Click += new System.EventHandler(this.ptbTimKiemBenhNhan_Click);
            // 
            // ptbTimKiemBacSi
            // 
            this.ptbTimKiemBacSi.Image = ((System.Drawing.Image)(resources.GetObject("ptbTimKiemBacSi.Image")));
            this.ptbTimKiemBacSi.Location = new System.Drawing.Point(602, 85);
            this.ptbTimKiemBacSi.Name = "ptbTimKiemBacSi";
            this.ptbTimKiemBacSi.Size = new System.Drawing.Size(104, 111);
            this.ptbTimKiemBacSi.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.ptbTimKiemBacSi.TabIndex = 16;
            this.ptbTimKiemBacSi.TabStop = false;
            // 
            // pictureBox3
            // 
            this.pictureBox3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.pictureBox3.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox3.Image")));
            this.pictureBox3.Location = new System.Drawing.Point(479, 164);
            this.pictureBox3.Name = "pictureBox3";
            this.pictureBox3.Size = new System.Drawing.Size(29, 25);
            this.pictureBox3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox3.TabIndex = 17;
            this.pictureBox3.TabStop = false;
            // 
            // pictureBox4
            // 
            this.pictureBox4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.pictureBox4.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox4.Image")));
            this.pictureBox4.Location = new System.Drawing.Point(972, 167);
            this.pictureBox4.Name = "pictureBox4";
            this.pictureBox4.Size = new System.Drawing.Size(29, 25);
            this.pictureBox4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox4.TabIndex = 18;
            this.pictureBox4.TabStop = false;
            this.pictureBox4.Click += new System.EventHandler(this.pictureBox4_Click);
            // 
            // cbbTKBN
            // 
            this.cbbTKBN.FormattingEnabled = true;
            this.cbbTKBN.Location = new System.Drawing.Point(186, 169);
            this.cbbTKBN.Name = "cbbTKBN";
            this.cbbTKBN.Size = new System.Drawing.Size(200, 21);
            this.cbbTKBN.TabIndex = 19;
            this.cbbTKBN.SelectedIndexChanged += new System.EventHandler(this.cbbTKBN_SelectedIndexChanged);
            // 
            // cbbTKBS
            // 
            this.cbbTKBS.FormattingEnabled = true;
            this.cbbTKBS.Location = new System.Drawing.Point(728, 169);
            this.cbbTKBS.Name = "cbbTKBS";
            this.cbbTKBS.Size = new System.Drawing.Size(160, 21);
            this.cbbTKBS.TabIndex = 20;
            // 
            // txtImageData
            // 
            this.txtImageData.BackColor = System.Drawing.SystemColors.Control;
            this.txtImageData.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.txtImageData.ForeColor = System.Drawing.Color.Green;
            this.txtImageData.Location = new System.Drawing.Point(41, 66);
            this.txtImageData.Name = "txtImageData";
            this.txtImageData.Size = new System.Drawing.Size(104, 13);
            this.txtImageData.TabIndex = 38;
            // 
            // FormTimKiem
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1030, 500);
            this.Controls.Add(this.txtImageData);
            this.Controls.Add(this.cbbTKBS);
            this.Controls.Add(this.cbbTKBN);
            this.Controls.Add(this.pictureBox4);
            this.Controls.Add(this.pictureBox3);
            this.Controls.Add(this.ptbTimKiemBacSi);
            this.Controls.Add(this.ptbTimKiemBenhNhan);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.btnTimKiemBacSi);
            this.Controls.Add(this.btnTimKiemBenhNhan);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.groupBox1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "FormTimKiem";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Load += new System.EventHandler(this.FormTimKiem_Load);
            this.groupBox1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.ThongTinBenhNhanGV)).EndInit();
            this.groupBox2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.ThongTinBacSiGV)).EndInit();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ptbTimKiemBenhNhan)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.ptbTimKiemBacSi)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.DataGridView ThongTinBenhNhanGV;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.DataGridView ThongTinBacSiGV;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnTimKiemBenhNhan;
        private System.Windows.Forms.Button btnTimKiemBacSi;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.PictureBox ptbTimKiemBenhNhan;
        private System.Windows.Forms.PictureBox ptbTimKiemBacSi;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.PictureBox pictureBox4;
        private System.Windows.Forms.ComboBox cbbTKBN;
        private System.Windows.Forms.ComboBox cbbTKBS;
        private System.Windows.Forms.TextBox txtImageData;
    }
}