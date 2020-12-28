package org.o7planning.springbootrestfulclient.RestClientSpring;

import org.o7planning.springbootrestfulclient.model.Produit;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import static org.o7planning.springbootrestfulclient.RestClientSpring.RestClient.callCreateProduct;

public class Client  extends JFrame{


    private JTextField txtFname;
    private JLabel jLabel1;
    private JLabel jLabel2 ;
    private JTextField txtLname ;
    private JLabel jLabel5 ;
    private JTextField txtSname ;
    private JTextField txtID ;
    private JLabel jLabel3 ;
    private JScrollPane jScrollPane1 ;
    private JTable tblStudents ;
    private JButton btnSave ;
    private JButton btnUpdate ;
    private JButton btnDelete1;
    private JLabel jLabel4 ;
    private static int id ;
    //   private JTextField txtId;
    private static final String GET_ALL_PRODUCT_API = "http://localhost:8081/BOUTIQUE/produits" ;
    private static String DELETE_PRODUCT_API = "http://localhost:8081/BOUTIQUE/delete/";
    static RestTemplate restTemplate = new RestTemplate();
    private Produit produit = new Produit();


    public void initComponents() {
        txtFname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSname = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new JTable();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Application de Gestion de produits");
        // setResizable(false);

        jLabel1.setFont(new java.awt.Font("Verdana", 0,12));
        jLabel1.setText("ID") ;

        jLabel2.setFont(new java.awt.Font("Verdana", 0,12));
        jLabel2.setText("Nom") ;

        jLabel5.setFont(new java.awt.Font("Verdana", 0,12));
        jLabel5.setText("Prix") ;

        jLabel3.setFont(new java.awt.Font("Verdana", 0,12));
        jLabel3.setText("Quantite") ;

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
                new Object[] [] {

                },
                new String [] {
                        "ID" ,"Nom" , "Prix" , "Quantite"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false , false , false , false
            } ;

            public boolean isCellEditable(
                    int rowIndex, int columnIndex
            ) {
                return canEdit [columnIndex] ;
            }

        } ) ;

        // INSERTION DES METHODES

        tblStudents.setCellSelectionEnabled(true);
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsMouseClicked(evt) ;
               // CallGetAllProduct() ;
            }


        });

        jScrollPane1.setViewportView(tblStudents);
        if (tblStudents.getColumnModel().getColumnCount() > 0) {
            tblStudents.getColumnModel().getColumn(2).setResizable(false);
        }

        btnSave.setText("SAVE");
        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(BevelBorder.RAISED));
        btnSave.setIconTextGap(0);
        btnSave.setInheritsPopupMenu(true);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                String nom = txtLname.getText().trim();
                int prix = Integer.parseInt(txtSname.getText());
                int id = Integer.parseInt(txtID.getText());
              //  int quantite = Integer.parseInt(txtSname.getText());
                callCreateProduct (  nom ,prix ,id) ;
                alert("Created Succesfully");

            }
        }) ;



        btnUpdate.setText("Afficher");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(BevelBorder.RAISED)) ;
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CallGetAllProduct() ;
                // btnUpdateActionPerformed(evt);
            }
        }) ;

        btnDelete1.setText("Delete");
        btnDelete1.setBorder(new javax.swing.border.SoftBevelBorder(BevelBorder.RAISED)) ;
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        }) ;










        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("APPLICATION DE GESTION DE PRODUITS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                                )
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtSname, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                )))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(jLabel4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtSname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(39, 39, 39)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);


    } // the end of method initComponents()

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {

        int i = tblStudents.getSelectedRow() ;
        if ( i>= 0) {
            int option = JOptionPane.showConfirmDialog(
                    rootPane,
                    "Are you sure you want to Delete?",
                    "Delete Confirmation",
                    JOptionPane.YES_NO_OPTION
            ) ;

            if (option == 0) {
                TableModel model = tblStudents.getModel() ;

                int id = Integer.parseInt(model.getValueAt(i,2).toString()) ;
                if (tblStudents.getSelectedRows().length == 1) {
                    int samaid = Integer.parseInt(txtFname.getText().toString()) ;
                    delete(samaid) ;
                    DefaultTableModel model1 = (DefaultTableModel) tblStudents.getModel();
                    model1.setRowCount(0);

                }
            }

        } else {
            alert("Please select a row to delete") ;
        }
    }

    public void delete(int id) {

//        Map<String, String> params = new HashMap<String, String>();
//        params.put("id","58");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete ( DELETE_PRODUCT_API+id);


//        System.out.println("(Client side) Produit after delete: ");
//        System.out.println("Produit: " + produit.getId() + " - " + produit.getNom()
//                + "-" + produit.getPrix()  + "-" + produit.getQuantite());
//        System.out.println("Product delete Successfuly") ;

    }

    public void CallGetAllProduct() {
        DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
        Produit[] list = restTemplate.getForObject(GET_ALL_PRODUCT_API, Produit[].class) ;
     //   System.out.println("---------------liste des produits-----------------") ;
        if(list !=null) {
            for (Produit p : list) {


                // System.out.println("Produit: " +p.getId()+ " --> " + p.getNom()) ;
                Object[] row = new Object[4];

                row[0] = p.getId();
                row[1] = p.getNom();
                row[2] = p.getPrix();
                row[3] = p.getQuantite() ;
                model.addRow(row);
            }

            //tblStudents.setModel(model)
        }


    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {

        String nom = txtFname.getText().trim() ;
        String prix = txtLname.getText().trim();
        String qte = txtSname.getText().trim();
        String id    = txtID.getText().trim();

        if (!nom.isEmpty() && !prix.isEmpty() && !qte.isEmpty() && !id.isEmpty()) {
            try {

                DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
                Object[] row = new Object[5] ;
                row[0] =  id ;
                row[1] =  nom  ;
                row[2] =  prix ;
                row[3] =  qte ;
              //  model.addRow();
            } catch (Exception e) {

            }

        }

    }

    private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {

        int i = tblStudents.getSelectedRow() ;
        TableModel model = tblStudents.getModel();
        txtFname.setText(model.getValueAt(i,0).toString());
        txtLname.setText(model.getValueAt(i,1).toString());
        txtSname.setText(model.getValueAt(i,2).toString());
        txtID.setText(model.getValueAt(i,3).toString());
    }

    public Client() {

        initComponents();


    }
    public static void main(String[] args) {


        java.awt.EventQueue.invokeLater(() -> {
            new Client().setVisible(true);
        });
    }

    public void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

}


