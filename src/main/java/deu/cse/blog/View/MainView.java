/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.View;

import deu.cse.blog.Model.Post;
import deu.cse.blog.Presenter.PostPresenter;
import deu.cse.blog.Presenter.UserPresenter;
import deu.cse.blog.Presenter.ViewPresenter;
import deu.cse.blog.Utils.DataParser;
import deu.cse.blog.Utils.JTableSetting;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 * 블로그 홈페이지
 * @author 조은진
 */
public class MainView extends javax.swing.JFrame {

    private JScrollPane scrollPane = new JScrollPane();
    private ArrayList<Post> posts;
    private String userID = UserSession.getSession();
    private PostPresenter postPresenter = new PostPresenter();
    private UserPresenter userPresenter = new UserPresenter();
    private ViewPresenter viewPresenter = new ViewPresenter();

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        layoutInit();

        setLocationRelativeTo(null); // 중앙 정렬

        myblogButton.setVisible(false);
        myblogButton.setEnabled(false);
        
        setVisible(true);
    }

    public MainView(String userID) {
        initComponents();
        layoutInit();

        setLocationRelativeTo(null); // 중앙 정렬
        myblogButton.setVisible(true);
        myblogButton.setEnabled(true);
        useridLabel.setText(userID + "님");
        
        setVisible(true);
    }

    public void layoutInit() {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        useridLabel = new javax.swing.JLabel();
        logButton = new javax.swing.JButton();
        postpageButton = new javax.swing.JButton();
        myblogButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        searchBox = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        postScrollPane = new javax.swing.JScrollPane();
        postTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("블로그");
        setSize(new java.awt.Dimension(900, 900));

        menuPanel.setBackground(new java.awt.Color(255, 255, 255));
        menuPanel.setMaximumSize(new java.awt.Dimension(900, 150));
        menuPanel.setPreferredSize(new java.awt.Dimension(813, 643));
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        useridLabel.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        useridLabel.setText("    ");
        menuPanel.add(useridLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        logButton.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        String state;
        if (userID.equals("")) {
            state = "로그인";
        } else {
            state = "로그아웃";
        }
        logButton.setText(state);
        logButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logButtonActionPerformed(evt);
            }
        });
        menuPanel.add(logButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 150, 50));

        postpageButton.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        postpageButton.setText("글쓰기");
        postpageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postpageButtonMouseClicked(evt);
            }
        });
        menuPanel.add(postpageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 130, 50));

        myblogButton.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        myblogButton.setText("내 블로그");
        myblogButton.setEnabled(false);
        myblogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myblogButtonActionPerformed(evt);
            }
        });
        menuPanel.add(myblogButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 50));

        loginButton.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        loginButton.setText("로그인");
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });
        menuPanel.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 150, 50));

        searchBox.setPreferredSize(new java.awt.Dimension(7, 30));
        menuPanel.add(searchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 310, -1));

        searchButton.setText("🔍");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });
        menuPanel.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 50, 30));
        menuPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 120, 20));

        postScrollPane.setBackground(new java.awt.Color(255, 255, 255, 0));
        postScrollPane.setOpaque(false);

        postTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "순서", "제목", "작성자", "조회수"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableSetting.tableInit(postScrollPane, postTable);
        JTableSetting.tableHeaderInit(postTable, 900, 100);
        JTableSetting.postTableSetting(postTable);
        posts = postPresenter.findAll();
        JTableSetting.insertTableRow((DefaultTableModel) postTable.getModel(), DataParser.postsToObject(posts));
        postTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postTableMouseClicked(evt);
            }
        });
        postScrollPane.setViewportView(postTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addComponent(postScrollPane))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(postScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // 글쓰기 버튼 클릭 시
    private void postpageButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postpageButtonMouseClicked

        if (userID == null) {
            this.setVisible(false);
            dispose();
            viewPresenter.moveToLoginView();
        } else {
            this.setVisible(false);
            dispose();
            viewPresenter.moveToPostWriteView();
        }
    }//GEN-LAST:event_postpageButtonMouseClicked
    // 로그인 버튼 클릭 시
    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked

    }//GEN-LAST:event_loginButtonMouseClicked
    // 검색 버튼 클릭 시
    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        String text = searchBox.getText();
        this.setVisible(false);
        dispose();
        viewPresenter.moveToSearchView(text);
    }//GEN-LAST:event_searchButtonMouseClicked

    // 내블로그 버튼 클릭 시
    private void myblogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myblogButtonActionPerformed
        // TODO add your handling code here:
        if (userID != null) {
            this.setVisible(false);
            dispose();
            viewPresenter.moveToMyView();
        } else {
            this.setVisible(false);
            dispose();
            viewPresenter.moveToLoginView();
        }

    }//GEN-LAST:event_myblogButtonActionPerformed
    // 테이블에 있는 목록 클릭 시
    private void postTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postTableMouseClicked
        // TODO add your handling code here:
        int row = postTable.getSelectedRow();
        Post selectedPost = posts.get(row);

        this.setVisible(false);
        dispose();
        viewPresenter.moveToCheckPostView(selectedPost);
    }//GEN-LAST:event_postTableMouseClicked

    private void logButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButtonActionPerformed
        String state = evt.getActionCommand();
        if (state.equals("로그인")) {
            this.setVisible(false);
            dispose();
            viewPresenter.moveToLoginView();
        } else {
            boolean success = userPresenter.logOut();

            if (success) {
                UserSession.setSession("");
                String userID = UserSession.getSession();
                this.setVisible(false);
                dispose();
                viewPresenter.moveToMainView(userID);
            }
        }
    }//GEN-LAST:event_logButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton myblogButton;
    private javax.swing.JScrollPane postScrollPane;
    private javax.swing.JTable postTable;
    private javax.swing.JButton postpageButton;
    private javax.swing.JTextField searchBox;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel useridLabel;
    // End of variables declaration//GEN-END:variables
}
