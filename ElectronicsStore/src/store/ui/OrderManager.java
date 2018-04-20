/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.*;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import store.classes.Customer;
import store.classes.Store;
import store.classes.TechnicalDevice;

/**
 *
 * @author IT676
 */
public class OrderManager extends javax.swing.JFrame {

    Store currentStore;
    Customer currentCustomer;
    String[] itemsIDs;
    int[] quantities;
    int itemsCounter = 0;
    boolean isNumberOfITemsEntered = false;

    /**
     * Creates new form OrderManager
     *
     * @param store
     * @param customer who logged to the system
     */
    //another constructor to Recive Customer object 
    public OrderManager(Store store, Customer customer) {

        this(); // to init the JFrame

        //show welcome msg
        JOptionPane.showMessageDialog(null, "Welcome Back " + customer.getName() + " !\t\n Let's Shopping !", "Welcome !", JOptionPane.INFORMATION_MESSAGE);

        //set the recived store to the currentStore
        this.currentStore = store;
        //set the recived customer to the currentCustomer 
        this.currentCustomer = customer;

        welcomeLbl.setText("Welcome ، " + currentCustomer.getName() + " !");
    }

    public OrderManager() {
        initComponents();

        customSettings();
        initCurrentOrderPanel();

        loadAllProducts("All", "");

    }

    public final void customSettings() {

        this.getContentPane().setBackground(Color.WHITE);

        this.setLocation(450, 200);

        //add all radi btns to one group 
        ButtonGroup group = new ButtonGroup();

        group.add(allRB);
        group.add(brandRB);
        group.add(typeRB);

    }

    //re-use this method many times 
    public final void loadAllProducts(String filter, String flag) {

        String productsData = loadAllProducts("TechnicalDevices.ser", filter, flag);

        productsTxtA.setText(productsData);
    }

    //this method will read all the products info from the file and return a String representing the data
    public final String loadAllProducts(String fileName, String filter, String flag) {

        StringBuilder productsData = new StringBuilder();
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

            switch (filter.toUpperCase()) {
                case "ALL":

                    while (true) {

                        try {

                            TechnicalDevice device = (TechnicalDevice) ois.readObject();

                            productsData.append(device.toString()).append("\n");
                            productsData.append("..............................\n");

                        } catch (EOFException ex) {

                            //normal termination 
                            break; //stop the loop
                        }
                    }//end while

                    break;//end of case #1

                case "BRAND":

                    while (true) {

                        try {

                            TechnicalDevice device = (TechnicalDevice) ois.readObject();

                            if (device.getBrand().equalsIgnoreCase(flag)) {
                                productsData.append(device.toString()).append("\n");
                                productsData.append("..............................\n");
                            }

                        } catch (EOFException ex) {

                            //normal termination 
                            break; //stop the loop
                        }
                    }//end while

                    break;//end of case #2

                case "TYPE":

                    while (true) {

                        try {

                            TechnicalDevice device = (TechnicalDevice) ois.readObject();
                            //you can use instanceof
                            flag = flag.equalsIgnoreCase("Desktop") ? "DesktopComputer" : flag;

                            if (device.getClass().getSimpleName().equalsIgnoreCase(flag)) {
                                productsData.append(device.toString()).append("\n");
                                productsData.append("..............................\n");
                            }
                        } catch (EOFException ex) {

                            //normal termination 
                            break; //stop the loop
                        }
                    }//end while
                    break;//end of case #3

            }

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(this, "Can't Read Products Data !", "Error", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(this, "Class Not Found !\nPlease Contact The Admin\nTo Fix That.", "Error", JOptionPane.ERROR_MESSAGE);

        }

        //return the string and use it in the textArea of the products
        return productsData.toString().equals("")
                ? "Sorry , no items to display now , Visit us soon :)"
                : productsData.toString();
    }

    private void initCurrentOrderPanel() {
        currentOrderInfoPanel.removeAll();//reset the panel
        JLabel currentOrderInfo = new JLabel("You don't not have any current order yet.", JLabel.LEFT);
        if (currentCustomer != null) {

            if (currentCustomer.currentOrder != null) {

                currentOrderInfo.setText(currentCustomer.currentOrder.toString());

            }
        }

        currentOrderInfoPanel.setLayout(new FlowLayout());
        currentOrderInfoPanel.add(currentOrderInfo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        welcomeLbl = new javax.swing.JLabel();
        contentTabbed = new javax.swing.JTabbedPane();
        viewProductsPanel = new javax.swing.JPanel();
        allRB = new javax.swing.JRadioButton();
        brandRB = new javax.swing.JRadioButton();
        typeRB = new javax.swing.JRadioButton();
        filterList = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTxtA = new javax.swing.JTextArea();
        viewBtn = new javax.swing.JButton();
        addOrderPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        numOfItemsTxtF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        shippingCountryList = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        itemIdTxtF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        quantityTxtF = new javax.swing.JTextField();
        submitOrderBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        notAvaTxtA = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        currentOrderPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        currentOrderInfoPanel = new javax.swing.JPanel();
        exportOrderPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        confirmCancelPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        notAvaTxtA1 = new javax.swing.JTextArea();
        confirmBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        orderHistoryPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dreams Electronics Store - Products & Orders");
        setMinimumSize(new java.awt.Dimension(500, 550));
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setBackground(new java.awt.Color(3, 169, 244));
        headerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Discover All Products and Manage Your Orders !");
        headerPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome To The Dreams Electronics Store");
        headerPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, -1));

        welcomeLbl.setForeground(new java.awt.Color(255, 255, 255));
        headerPanel.add(welcomeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 120, 20));

        getContentPane().add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 70));

        contentTabbed.setBackground(new java.awt.Color(255, 255, 255));
        contentTabbed.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        contentTabbed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                contentTabbedStateChanged(evt);
            }
        });

        viewProductsPanel.setBackground(new java.awt.Color(255, 255, 255));

        allRB.setSelected(true);
        allRB.setText("All");
        allRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allRBActionPerformed(evt);
            }
        });

        brandRB.setText("Brand");
        brandRB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                brandRBStateChanged(evt);
            }
        });
        brandRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandRBActionPerformed(evt);
            }
        });

        typeRB.setText("Type");
        typeRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeRBActionPerformed(evt);
            }
        });

        filterList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Apple", "Samsung" }));
        filterList.setEnabled(false);
        filterList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterListActionPerformed(evt);
            }
        });

        productsTxtA.setEditable(false);
        productsTxtA.setColumns(20);
        productsTxtA.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        productsTxtA.setLineWrap(true);
        productsTxtA.setRows(5);
        jScrollPane1.setViewportView(productsTxtA);

        viewBtn.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        viewBtn.setText("View");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewProductsPanelLayout = new javax.swing.GroupLayout(viewProductsPanel);
        viewProductsPanel.setLayout(viewProductsPanelLayout);
        viewProductsPanelLayout.setHorizontalGroup(
            viewProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProductsPanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(allRB)
                .addGap(85, 85, 85)
                .addGroup(viewProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewProductsPanelLayout.createSequentialGroup()
                        .addComponent(filterList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(viewProductsPanelLayout.createSequentialGroup()
                        .addComponent(brandRB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(typeRB)
                        .addGap(48, 48, 48))))
            .addGroup(viewProductsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewProductsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        viewProductsPanelLayout.setVerticalGroup(
            viewProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProductsPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(viewProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allRB)
                    .addComponent(brandRB)
                    .addComponent(typeRB))
                .addGap(18, 18, 18)
                .addComponent(filterList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        contentTabbed.addTab("View Products", new javax.swing.ImageIcon(getClass().getResource("/store/images/icons8-multiple-devices-filled-20 (1).png")), viewProductsPanel, "Discover All Products"); // NOI18N

        addOrderPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Number of Items:");

        numOfItemsTxtF.setToolTipText("Hom Many Items You'd To Order?");

        jLabel4.setText("Shipping Country:");

        shippingCountryList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Option", "Saudi Arabia", "Bahrain", "Kwait", "United Arab Emirates" }));

        jLabel5.setText("-------Add Items------");

        jLabel6.setText("Item ID:");

        jLabel7.setText("Quantity:");

        submitOrderBtn.setText("Submit Order");
        submitOrderBtn.setToolTipText("Submit Your Order Now");
        submitOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitOrderBtnActionPerformed(evt);
            }
        });

        notAvaTxtA.setEditable(false);
        notAvaTxtA.setColumns(20);
        notAvaTxtA.setLineWrap(true);
        notAvaTxtA.setRows(5);
        notAvaTxtA.setToolTipText("Sorry , These Items are not Avaialbe");
        jScrollPane2.setViewportView(notAvaTxtA);

        jLabel8.setText("Not Avaialbe Items:");

        addBtn.setText("Add");
        addBtn.setToolTipText("Add This Item to your order list");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addOrderPanelLayout = new javax.swing.GroupLayout(addOrderPanel);
        addOrderPanel.setLayout(addOrderPanelLayout);
        addOrderPanelLayout.setHorizontalGroup(
            addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addOrderPanelLayout.createSequentialGroup()
                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addOrderPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(addOrderPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(quantityTxtF, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(itemIdTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(addOrderPanelLayout.createSequentialGroup()
                                        .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(numOfItemsTxtF, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                            .addComponent(shippingCountryList, 0, 1, Short.MAX_VALUE)))))))
                    .addGroup(addOrderPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addOrderPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addBtn)
                .addGap(193, 193, 193))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addOrderPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(147, 147, 147))
        );
        addOrderPanelLayout.setVerticalGroup(
            addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOrderPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numOfItemsTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(shippingCountryList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemIdTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitOrderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        contentTabbed.addTab("Add Order", new javax.swing.ImageIcon(getClass().getResource("/store/images/icons8-add-shopping-cart-filled-20 (2).png")), addOrderPanel, "Make an Order"); // NOI18N

        currentOrderPanel.setBackground(new java.awt.Color(255, 255, 255));
        currentOrderPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                currentOrderPanelMouseClicked(evt);
                j(evt);
            }
        });

        jLabel9.setText("-----Current Order------");

        javax.swing.GroupLayout currentOrderInfoPanelLayout = new javax.swing.GroupLayout(currentOrderInfoPanel);
        currentOrderInfoPanel.setLayout(currentOrderInfoPanelLayout);
        currentOrderInfoPanelLayout.setHorizontalGroup(
            currentOrderInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        currentOrderInfoPanelLayout.setVerticalGroup(
            currentOrderInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout currentOrderPanelLayout = new javax.swing.GroupLayout(currentOrderPanel);
        currentOrderPanel.setLayout(currentOrderPanelLayout);
        currentOrderPanelLayout.setHorizontalGroup(
            currentOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currentOrderPanelLayout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(152, 152, 152))
            .addGroup(currentOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentOrderInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        currentOrderPanelLayout.setVerticalGroup(
            currentOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentOrderPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(currentOrderInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        contentTabbed.addTab("Current Order", new javax.swing.ImageIcon(getClass().getResource("/store/images/icons8-purchase-order-filled-20.png")), currentOrderPanel, "Your Current Order"); // NOI18N

        exportOrderPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel10.setText("-------[Export Current Order]------");

        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/store/images/icons8-approval-20.png"))); // NOI18N
        jButton1.setText("Save");

        javax.swing.GroupLayout exportOrderPanelLayout = new javax.swing.GroupLayout(exportOrderPanel);
        exportOrderPanel.setLayout(exportOrderPanelLayout);
        exportOrderPanelLayout.setHorizontalGroup(
            exportOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportOrderPanelLayout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(exportOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportOrderPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportOrderPanelLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))))
        );
        exportOrderPanelLayout.setVerticalGroup(
            exportOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportOrderPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addGap(43, 43, 43)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        contentTabbed.addTab("Export Order", new javax.swing.ImageIcon(getClass().getResource("/store/images/icons8-save-as-filled-20 (1).png")), exportOrderPanel, "Export Your Order Now"); // NOI18N

        confirmCancelPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel11.setText("Current Order:");

        notAvaTxtA1.setEditable(false);
        notAvaTxtA1.setColumns(20);
        notAvaTxtA1.setLineWrap(true);
        notAvaTxtA1.setRows(5);
        notAvaTxtA1.setToolTipText("Sorry , These Items are not Avaialbe");
        jScrollPane3.setViewportView(notAvaTxtA1);

        confirmBtn.setBackground(new java.awt.Color(51, 204, 0));
        confirmBtn.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        confirmBtn.setText("Confirm");
        confirmBtn.setToolTipText("Submit Your Order Now");

        cancelBtn.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.setToolTipText("Submit Your Order Now");

        javax.swing.GroupLayout confirmCancelPanelLayout = new javax.swing.GroupLayout(confirmCancelPanel);
        confirmCancelPanel.setLayout(confirmCancelPanelLayout);
        confirmCancelPanelLayout.setHorizontalGroup(
            confirmCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmCancelPanelLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(confirmCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(confirmCancelPanelLayout.createSequentialGroup()
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        confirmCancelPanelLayout.setVerticalGroup(
            confirmCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmCancelPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(confirmCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(confirmCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(245, Short.MAX_VALUE))
        );

        contentTabbed.addTab("Confirm/Cancel", new javax.swing.ImageIcon(getClass().getResource("/store/images/icons8-approval-20.png")), confirmCancelPanel, "Confirm or Cancel Your Order"); // NOI18N

        orderHistoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel12.setText("-------[ Order History ]------");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        javax.swing.GroupLayout orderHistoryPanelLayout = new javax.swing.GroupLayout(orderHistoryPanel);
        orderHistoryPanel.setLayout(orderHistoryPanelLayout);
        orderHistoryPanelLayout.setHorizontalGroup(
            orderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderHistoryPanelLayout.createSequentialGroup()
                .addGroup(orderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderHistoryPanelLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel12))
                    .addGroup(orderHistoryPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        orderHistoryPanelLayout.setVerticalGroup(
            orderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderHistoryPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        contentTabbed.addTab("Order History", new javax.swing.ImageIcon(getClass().getResource("/store/images/icons8-order-history-filled-20 (1).png")), orderHistoryPanel, "All Orders You Made"); // NOI18N

        getContentPane().add(contentTabbed, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 500, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void brandRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandRBActionPerformed

        String flag = filterList.getSelectedItem().toString();//get the  selected value in the comboxbox

        loadAllProducts("BRAND", flag);

    }//GEN-LAST:event_brandRBActionPerformed

    private void allRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRBActionPerformed

        filterList.setEnabled(false);
        loadAllProducts("ALL", "");

    }//GEN-LAST:event_allRBActionPerformed

    private void typeRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeRBActionPerformed

        String[] items = {"Desktop", "Laptop", "Tablet"};
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        filterList.setModel(model);
        filterList.setEnabled(true);

        String flag = filterList.getSelectedItem().toString();//get the  selected value in the comboxbox

        loadAllProducts("TYPE", flag);
    }//GEN-LAST:event_typeRBActionPerformed

    private void brandRBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_brandRBStateChanged

        String[] items = {"Apple", "Samsung", "Huawei", "Dell", "HP"};
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        filterList.setModel(model);
        filterList.setEnabled(true);

    }//GEN-LAST:event_brandRBStateChanged

    private void filterListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterListActionPerformed


    }//GEN-LAST:event_filterListActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed

        String flag = "";
        if (allRB.isSelected()) {

            loadAllProducts("ALL", flag);

        } else {

            flag = filterList.getSelectedItem().toString();//get the  selected value in the comboxbox

            if (brandRB.isSelected()) {

                loadAllProducts("BRAND", flag);

            } else if (typeRB.isSelected()) {

                loadAllProducts("TYPE", flag);

            }
        }

    }//GEN-LAST:event_viewBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        //clear the textarea of unavilable items for the next try when user place an order
        notAvaTxtA.setText("");

        //validate the number of items 
        if (!validateField(numOfItemsTxtF, "Number of items")) {
            return;//terminate the process
        }

        //icheck if it's a valid number or not 
        if (!validateNumber(numOfItemsTxtF, "Number of items")) {
            return;//terminate the process
        }

        //for now everything is fine , so get number of items 
        int numOfItems = getNumber(numOfItemsTxtF);

        //check if the number of items valid or not
        if (!isAllowedValue(numOfItems, 1, 50, "Number of items")) // for max : you can give any value you want
        {
            return;//terminate the process
        }        //------------end of vaidation for numebr of items field----------------

        //validating shipping country 
        // in the frame 0---> Option  ---> we should start from 1  for Saudi Arabia
        if (shippingCountryList.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Shipping country is required .", "Error", JOptionPane.ERROR_MESSAGE);
            return;//terminate the process
        }

        //------------end of validation for numebr of items field----------------
        //validate Item id field -- item id  not need to be a number since it's a string
        if (!validateField(itemIdTxtF, "Item Id")) {
            return;//terminate the process
        }

        //Validating quantity 
        if (!validateField(quantityTxtF, "Quantity")) {
            return;//terminate the process
        }

        //icheck if it's a valid number or not 
        if (!validateNumber(quantityTxtF, "Quantity")) {
            return;//terminate the process
        }

        //get number of items 
        int quantity = getNumber(quantityTxtF);

        //check if the number of items valid or not
        if (!isAllowedValue(quantity, 1, 10, "Quantity")) // for max : you can give any value you want
        {
            return;//terminate the process
        }
        //------------end of vaidation for quantity field----------------

        if (!isNumberOfITemsEntered) {

            isNumberOfITemsEntered = true;

            itemsIDs = new String[numOfItems];
            quantities = new int[numOfItems];

        }

        String itemId = itemIdTxtF.getText();

        if (addItem(itemId, quantity)) {

            JOptionPane.showMessageDialog(this, "Item with Id: '" + itemId + "' has been added successfully ! ", "Item Added", JOptionPane.INFORMATION_MESSAGE);

            //clear text
            itemIdTxtF.setText("");
            quantityTxtF.setText("");
            itemIdTxtF.requestFocus();

        } else {

            JOptionPane.showMessageDialog(this, "You  can't add more items\n Please update the number of items field\nand try again. ", "Error", JOptionPane.ERROR_MESSAGE);

        }

        //for testing purpose
//        notAvaTxtA.setText(Arrays.toString(itemsIDs));
//        notAvaTxtA.append(Arrays.toString(quantities));

    }//GEN-LAST:event_addBtnActionPerformed

    private void submitOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitOrderBtnActionPerformed

        if (!isNumberOfITemsEntered) {//flag to check if he entered at least one item or not 

            JOptionPane.showMessageDialog(this, "Order must have at lease one item to submit.\nPlease add some items", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to submit the order now ?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (answer == JOptionPane.YES_OPTION) { //or == 0 if you want 

                //user must be login first , or NPE will occurred
                boolean isPlacedSuccessfuly = currentStore.placeOrder(currentCustomer.getID(),
                        itemsIDs, quantities,
                        shippingCountryList.getSelectedItem().toString());

                if (isPlacedSuccessfuly) {
                    JOptionPane.showMessageDialog(this, "Your order has been placed successfully !", "Order",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {

                    JOptionPane.showMessageDialog(this, "Sorry , your order has not been placed successfully\nsome items are not available", "Order",
                            JOptionPane.ERROR_MESSAGE);

                    //display the unavailable items int the textarea [note: use append method not setText]
                    for (String itemID : itemsIDs) {

                        if (itemID != null) {
                            notAvaTxtA.append(itemID + "\n");
                        }
                    }

                }
            }
        }

        //reset all variables
        isNumberOfITemsEntered = false;
        itemsCounter = 0;
        itemsIDs = null;
        quantities = null;
        numOfItemsTxtF.setText("");
    }//GEN-LAST:event_submitOrderBtnActionPerformed

    private void currentOrderPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentOrderPanelMouseClicked


    }//GEN-LAST:event_currentOrderPanelMouseClicked

    private void j(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j

    }//GEN-LAST:event_j

    private void contentTabbedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_contentTabbedStateChanged

        if (contentTabbed.getSelectedIndex() == 2) {
            initCurrentOrderPanel();
        }

    }//GEN-LAST:event_contentTabbedStateChanged

    public boolean addItem(String id, int q) {

        if (itemsCounter == itemsIDs.length) {

            return false;
        }

        int index = isItemAlreadyAdded(id);//if added ,if already added
        if (index != -1) {

            quantities[index] += q;// then just update the quantity don't add it again.

        } else {

            itemsIDs[itemsCounter] = id;
            quantities[itemsCounter] = q;
            itemsCounter++;//update counter

        }
        return true;
    }

    public int isItemAlreadyAdded(String id) {

        for (int i = 0; i < itemsCounter; i++) {
            if (itemsIDs[i] != null) {
                if (itemsIDs[i].equalsIgnoreCase(id)) {

                    //item already added , then update the quantity 
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean validateField(JTextField field, String fieldName) {

        if (field.getText().equals("")) {

            //display an error message
            JOptionPane.showMessageDialog(this, fieldName + " field is required.", "Error",
                    JOptionPane.ERROR_MESSAGE);

            return false;
        }

        return true;

    }

    private boolean validateNumber(JTextField field, String fieldName) {

        String numOfItemsStr = field.getText();

        //check if it's a number or not 
        //we will parse it , if it's threw an exception that means it's invalid number
        try {// if it's a number

            Integer.parseInt(numOfItemsStr);//if it's not a valid number will throw en exception
            return true; // everything is ok 
        } catch (NumberFormatException e) {

            //display an error message
            JOptionPane.showMessageDialog(this, "Only Numbers are alowed in " + fieldName + " Field.", "Error", JOptionPane.ERROR_MESSAGE);

            return false;//terminate the process
        }

    }

    //Important : don't call this method unless you've validated the field  you passed
    private int getNumber(JTextField field) {

        return Integer.parseInt(field.getText());
    }

    private boolean isAllowedValue(int number, int min, int max, String fieldName) {

        if (number < min || number > max) {
            //display error msg
            JOptionPane.showMessageDialog(this, fieldName + " field can't be less than " + min
                    + " or greater than " + max, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true; // it's ok 

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("MAC OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderManager.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderManager.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderManager.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderManager.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel addOrderPanel;
    private javax.swing.JRadioButton allRB;
    private javax.swing.JRadioButton brandRB;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JPanel confirmCancelPanel;
    private javax.swing.JTabbedPane contentTabbed;
    private javax.swing.JPanel currentOrderInfoPanel;
    private javax.swing.JPanel currentOrderPanel;
    private javax.swing.JPanel exportOrderPanel;
    private javax.swing.JComboBox filterList;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField itemIdTxtF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea notAvaTxtA;
    private javax.swing.JTextArea notAvaTxtA1;
    private javax.swing.JTextField numOfItemsTxtF;
    private javax.swing.JPanel orderHistoryPanel;
    private javax.swing.JTextArea productsTxtA;
    private javax.swing.JTextField quantityTxtF;
    private javax.swing.JComboBox shippingCountryList;
    private javax.swing.JButton submitOrderBtn;
    private javax.swing.JRadioButton typeRB;
    private javax.swing.JButton viewBtn;
    private javax.swing.JPanel viewProductsPanel;
    private javax.swing.JLabel welcomeLbl;
    // End of variables declaration//GEN-END:variables
}
