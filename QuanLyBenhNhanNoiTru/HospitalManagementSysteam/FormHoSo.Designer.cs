namespace HospitalManagementSysteam
{
    partial class FormHoSo
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormHoSo));
            this.panel1 = new System.Windows.Forms.Panel();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.BacSiGV = new System.Windows.Forms.DataGridView();
            this.groupBoxDanhSachBenhNhan = new System.Windows.Forms.GroupBox();
            this.BenhNhanGV = new System.Windows.Forms.DataGridView();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.label2 = new System.Windows.Forms.Label();
            this.panel1.SuspendLayout();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.BacSiGV)).BeginInit();
            this.groupBoxDanhSachBenhNhan.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.BenhNhanGV)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.Purple;
            this.panel1.Controls.Add(this.label2);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(1030, 50);
            this.panel1.TabIndex = 2;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.BacSiGV);
            this.groupBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBox1.ForeColor = System.Drawing.Color.Blue;
            this.groupBox1.Location = new System.Drawing.Point(150, 284);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(868, 205);
            this.groupBox1.TabIndex = 20;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Danh Sách Bác Sĩ Quản Lý Bệnh Nhân";
            // 
            // BacSiGV
            // 
            this.BacSiGV.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.BacSiGV.BackgroundColor = System.Drawing.Color.White;
            this.BacSiGV.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.BacSiGV.GridColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.BacSiGV.Location = new System.Drawing.Point(0, 21);
            this.BacSiGV.Name = "BacSiGV";
            this.BacSiGV.ReadOnly = true;
            this.BacSiGV.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.BacSiGV.Size = new System.Drawing.Size(867, 184);
            this.BacSiGV.TabIndex = 13;
            this.BacSiGV.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.BacSiGV_CellContentClick);
            // 
            // groupBoxDanhSachBenhNhan
            // 
            this.groupBoxDanhSachBenhNhan.Controls.Add(this.BenhNhanGV);
            this.groupBoxDanhSachBenhNhan.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBoxDanhSachBenhNhan.ForeColor = System.Drawing.Color.Blue;
            this.groupBoxDanhSachBenhNhan.Location = new System.Drawing.Point(150, 113);
            this.groupBoxDanhSachBenhNhan.Name = "groupBoxDanhSachBenhNhan";
            this.groupBoxDanhSachBenhNhan.Size = new System.Drawing.Size(868, 154);
            this.groupBoxDanhSachBenhNhan.TabIndex = 52;
            this.groupBoxDanhSachBenhNhan.TabStop = false;
            this.groupBoxDanhSachBenhNhan.Text = "Danh Sách Bệnh Nhân";
            // 
            // BenhNhanGV
            // 
            this.BenhNhanGV.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.BenhNhanGV.BackgroundColor = System.Drawing.Color.White;
            this.BenhNhanGV.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.BenhNhanGV.Location = new System.Drawing.Point(0, 19);
            this.BenhNhanGV.Name = "BenhNhanGV";
            this.BenhNhanGV.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.BenhNhanGV.Size = new System.Drawing.Size(867, 135);
            this.BenhNhanGV.TabIndex = 23;
            this.BenhNhanGV.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.BenhNhanGV_CellContentClick);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(26, 149);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(101, 102);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 53;
            this.pictureBox1.TabStop = false;
            // 
            // pictureBox2
            // 
            this.pictureBox2.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox2.Image")));
            this.pictureBox2.Location = new System.Drawing.Point(26, 351);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(101, 102);
            this.pictureBox2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox2.TabIndex = 54;
            this.pictureBox2.TabStop = false;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Mistral", 20.25F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(320, 9);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(420, 33);
            this.label2.TabIndex = 55;
            this.label2.Text = "Hồ Sơ Chi Tiết Về Danh Sách Thông Tin ";
            // 
            // FormHoSo
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1030, 500);
            this.Controls.Add(this.pictureBox2);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.groupBoxDanhSachBenhNhan);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.panel1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "FormHoSo";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "FormHoSo";
            this.Load += new System.EventHandler(this.FormHoSo_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.BacSiGV)).EndInit();
            this.groupBoxDanhSachBenhNhan.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.BenhNhanGV)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.DataGridView BacSiGV;
        private System.Windows.Forms.GroupBox groupBoxDanhSachBenhNhan;
        private System.Windows.Forms.DataGridView BenhNhanGV;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.Label label2;
    }
}