package Form;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Form implements ActionListener {

    JTextField labelNama2, labelAlamat2, tahun;
    JButton reset, simpan;
    JRadioButton labelJKL, labelJKP;
    JComboBox combo, combo2;
    ButtonGroup bGrup;

    public static void main(String[] args) {
        new Form();

    }

    public Form() {

        initComponent();
    }

    private void initComponent() {
        //container
        JFrame form = new JFrame("BioData Diri");
        // ukuran Form
        form.setSize(400, 550);
        form.setResizable(false);
        // mengatur fungsi close Form
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // display ditengah
        form.setLocationRelativeTo(null);
        form.setIconImage(new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\form.png").getImage());
        form.getContentPane().setBackground(Color.gray);
        //mengatur layout manual
        form.setLayout(null);

        //end
        /**
         * Bagian Judul
         */
        //membuat object komponen
        JLabel labelJudul = new JLabel("DATA DIRI");
        //mengatur komponen
        labelJudul.setBounds(172, 15, 90, 30);
        //memasukkan komponenn
        labelJudul.setForeground(Color.white);
        form.add(labelJudul);

        /**
         * Bagian Nama
         */
        JLabel labelNama = new JLabel("Nama : ");
        labelNama.setBounds(20, 80, 150, 25);
        labelNama.setForeground(Color.white);
        form.add(labelNama);

        labelNama2 = new JTextField();
        labelNama2.setBounds(150, 80, 150, 25);
        labelNama2.setEditable(true);
        form.add(labelNama2);

        /**
         * Bagian Alamat
         */
        JLabel labelAlamat = new JLabel("Alamat : ");
        labelAlamat.setBounds(20, 110, 150, 25);
        labelAlamat.setForeground(Color.white);
        form.add(labelAlamat);

        labelAlamat2 = new JTextField();
        labelAlamat2.setBounds(150, 110, 150, 25);
        labelAlamat2.setEditable(true);
        form.add(labelAlamat2);

        /**
         * Bagian Jenis Kelamin
         */
        JLabel labelJK = new JLabel("Jenis Kelamin : ");
        labelJK.setBounds(20, 140, 150, 25);
        labelJK.setForeground(Color.white);
        form.add(labelJK);

        //membuat radio button
        labelJKL = new JRadioButton();
        labelJKL.setText("Laki-Laki");
        labelJKL.setForeground(Color.white);
        labelJKL.setBackground(Color.gray);
        labelJKL.setBounds(150, 140, 80, 25);

        labelJKP = new JRadioButton();
        labelJKP.setForeground(Color.white);
        labelJKP.setBackground(Color.gray);
        labelJKP.setText("Perempuan");
        labelJKP.setBounds(230, 140, 150, 25);

        form.add(labelJKL);
        form.add(labelJKP);

        //membuat grup radio button
        bGrup = new ButtonGroup();
        bGrup.add(labelJKL);
        bGrup.add(labelJKP);

        JLabel labelTTL = new JLabel("TTL : ");
        labelTTL.setForeground(Color.white);
        labelTTL.setBounds(20, 170, 150, 25);
        form.add(labelTTL);

        String hari[] = new String[31];
        for (int i = 0; i < hari.length; i++) {
            hari[i] = Integer.toString(i + 1);
        }

        //komponen combo box tanggal
        combo = new JComboBox(hari);
        combo.setBounds(150, 170, 40, 25);
        form.add(combo);

        String bulan[] = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun",
            "Jul", "Aug", "Sep", "Okt", "Nov", "Dec",};

        //komponen combo box bulan
        combo2 = new JComboBox(bulan);
        combo2.setBounds(200, 170, 60, 25);
        combo2.setEditable(true);
        form.add(combo2);

        tahun = new JTextField();
        tahun.setBounds(270, 170, 40, 25);
        tahun.setEditable(true);
        form.add(tahun);

        simpan = new JButton("Simpan");
        simpan.setBounds(150, 200, 80, 25);
        simpan.setBackground(Color.black);
        simpan.setForeground(Color.white);
        simpan.setFocusable(false);
        form.add(simpan);

        reset = new JButton("Reset");
        reset.setBounds(250, 200, 75, 25);
        reset.setBackground(Color.black);
        reset.setForeground(Color.white);
        reset.setFocusable(false);
        form.add(reset);

        //menampilkan (paling bawah)
        form.setVisible(true);

        simpan.addActionListener(this);
        reset.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
        if (e.getSource() == simpan) {
                        
            String nama = labelNama2.getText();
            String alamat = labelAlamat2.getText();

            String jenisKelamin = "";
            if (labelJKL.isSelected()) {
                jenisKelamin = "Laki-Laki";
            } else if (labelJKP.isSelected()) {
                jenisKelamin = "Perempuan";
            }

            String tanggal = (String) combo.getSelectedItem();
            String bulan = (String) combo2.getSelectedItem();

            String tahunn = tahun.getText();

           
                if (nama.isEmpty() || alamat.isEmpty() || tahunn.isEmpty()
                        || bGrup.getSelection() == null) {
                    JOptionPane.showMessageDialog(null, "Pastikan Semua Input Terisi", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tersimpan");
                }
          
        } else if (e.getSource() == reset) {
            if (e.getSource() == reset) {
                labelNama2.setText("");
                labelAlamat2.setText("");
                tahun.setText("");
                combo.setSelectedIndex(0);
                combo2.setSelectedIndex(0);

                if (e.getSource() == reset) {
                    bGrup.clearSelection();
                }
            }
            JOptionPane.showMessageDialog(null, "Reset Berhasil");

        } else {            
            JOptionPane.showMessageDialog(null, "ERROR");
        }

    }

}
