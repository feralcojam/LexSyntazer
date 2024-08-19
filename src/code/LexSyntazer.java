package code;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

/**
 *
 * @author feralcojam
 */
public class LexSyntazer extends javax.swing.JFrame {

    /**
     * Creates new form LexSemanzer
     */
    public LexSyntazer() {
        initComponents();
    }

    private void analyzeLex() throws IOException {
        int count = 1;
        
        String exp = (String) txt_input.getText();
        Lexer lexer = new Lexer(new StringReader(exp));
        String result = "Line" + "\t\tSymbol\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txt_lex_output.setText(result);
                return;
            }
            switch (token) {
                case LineBreak:
                    count++;
                    result += "[LineBreak]" + count + "\n";
                    break;
                case STRING:
                    result += "[ReservedSTRING]\t" + lexer.lexeme + "\n";
                    break;
                case INT:
                    result += "[ReservedINT]\t" + lexer.lexeme + "\n";
                    break;
                case IF:
                    result += "[ReservedIF]\t" + lexer.lexeme + "\n";
                    break;
                case ELSE:
                    result += "[ReservedELSE]\t" + lexer.lexeme + "\n";
                    break;
                case WHILE:
                    result += "[ReservedWHILE]\t" + lexer.lexeme + "\n";
                    break;
                case FOR:
                    result += "[ReservedFOR]\t" + lexer.lexeme + "\n";
                    break;
                case DO:
                    result += "[ReservedDO]\t" + lexer.lexeme + "\n";
                    break;
                case Equal:
                    result += "[OperatorEqual]\t" + lexer.lexeme + "\n";
                    break;
                case Add:
                    result += "[OperatorAdd]\t" + lexer.lexeme + "\n";
                    break;
                case Subtract:
                    result += "[OperatorSubtract]\t" + lexer.lexeme + "\n";
                    break;
                case Multiplication:
                    result += "[OperatorMultiplication]\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    result += "[OperatorDivision]\t\t" + lexer.lexeme + "\n";
                    break;
                case Modulo:
                    result += "[OperatorModulo]\t\t" + lexer.lexeme + "\n";
                    break;
                case OpenParenthesis:
                    result += "[OpenParenthesis]\t" + lexer.lexeme + "\n";
                    break;
                case CloseParenthesis:
                    result += "[CloseParenthesis]\t" + lexer.lexeme + "\n";
                    break;
                case OpenBrace:
                    result += "[OpenBrace]\t" + lexer.lexeme + "\n";
                    break;
                case CloseBrace:
                    result += "[CloseBrace]\t" + lexer.lexeme + "\n";
                    break;
                case OpenBracket:
                    result += "[OpenBracket]\t" + lexer.lexeme + "\n";
                    break;
                case CloseBracket:
                    result += "[CloseBracket]\t" + lexer.lexeme + "\n";
                    break;
                case Public:
                    result += "[ReservedPublic]\t" + lexer.lexeme + "\n";
                    break;
                case Class:
                    result += "[ReservedClass]\t" + lexer.lexeme + "\n";
                    break;
                case Static:
                    result += "[ReservedStatic]\t" + lexer.lexeme + "\n";
                    break;
                case Void:
                    result += "[ReservedVoid]\t\t" + lexer.lexeme + "\n";
                    break;
                case Args:
                    result += "[ReservedArgs]\t\t" + lexer.lexeme + "\n";
                    break;
                case Main:
                    result += "[ReservedMain]\t\t" + lexer.lexeme + "\n";
                    break;
                case Semicolon:
                    result += "  [Semicolon]\t" + lexer.lexeme + "\n";
                    break;
                case Comma:
                    result += "  [Comma]\t" + lexer.lexeme + "\n";
                    break;
                case Identifier:
                    result += "  [Identifier]\t\t" + lexer.lexeme + "\n";
                    break;
                case Number:
                    result += "  [Number]\t\t" + lexer.lexeme + "\n";
                    break;
                case StringLiteral:
                    result += "  [StringLiteral]\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    result += "  [UndefinedSymbol]\t\t" + lexer.lexeme + "\n";
                    break;
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_panel = new javax.swing.JPanel();
        north_panel = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        open_file_btn = new javax.swing.JLabel();
        south_panel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_syn_output = new javax.swing.JTextArea();
        center_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_input = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_lex_output = new javax.swing.JTextArea();
        lex_label = new javax.swing.JLabel();
        scan_lex_btn = new javax.swing.JLabel();
        clear_text_btn1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lex_label1 = new javax.swing.JLabel();
        scan_syn_btn = new javax.swing.JLabel();
        clear_text_btn2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg_panel.setBackground(new java.awt.Color(240, 240, 240));
        bg_panel.setLayout(new java.awt.BorderLayout());

        north_panel.setBackground(new java.awt.Color(240, 240, 240));

        title_label.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        title_label.setForeground(new java.awt.Color(51, 51, 51));
        title_label.setText("LexSyntazer");

        open_file_btn.setText("open_file");
        open_file_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                open_file_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout north_panelLayout = new javax.swing.GroupLayout(north_panel);
        north_panel.setLayout(north_panelLayout);
        north_panelLayout.setHorizontalGroup(
            north_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(north_panelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(north_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(open_file_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title_label))
                .addContainerGap(491, Short.MAX_VALUE))
        );
        north_panelLayout.setVerticalGroup(
            north_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(north_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_label)
                .addGap(18, 18, 18)
                .addComponent(open_file_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        bg_panel.add(north_panel, java.awt.BorderLayout.PAGE_START);

        south_panel.setBackground(new java.awt.Color(240, 240, 240));

        txt_syn_output.setBackground(new java.awt.Color(239, 240, 240));
        txt_syn_output.setColumns(20);
        txt_syn_output.setRows(5);
        jScrollPane3.setViewportView(txt_syn_output);

        javax.swing.GroupLayout south_panelLayout = new javax.swing.GroupLayout(south_panel);
        south_panel.setLayout(south_panelLayout);
        south_panelLayout.setHorizontalGroup(
            south_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(south_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        south_panelLayout.setVerticalGroup(
            south_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(south_panelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        bg_panel.add(south_panel, java.awt.BorderLayout.PAGE_END);

        center_panel.setBackground(new java.awt.Color(240, 240, 240));

        txt_input.setBackground(new java.awt.Color(240, 240, 240));
        txt_input.setColumns(20);
        txt_input.setRows(5);
        jScrollPane1.setViewportView(txt_input);

        txt_lex_output.setBackground(new java.awt.Color(239, 240, 240));
        txt_lex_output.setColumns(20);
        txt_lex_output.setRows(5);
        jScrollPane2.setViewportView(txt_lex_output);

        lex_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lex_label.setForeground(new java.awt.Color(51, 51, 51));
        lex_label.setText("Syntax Analyzer");

        scan_lex_btn.setText("analyze");
        scan_lex_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scan_lex_btnMouseClicked(evt);
            }
        });

        clear_text_btn1.setText("clear_text");
        clear_text_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear_text_btn1MouseClicked(evt);
            }
        });

        lex_label1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lex_label1.setForeground(new java.awt.Color(51, 51, 51));
        lex_label1.setText("Lexical Analyzer");

        scan_syn_btn.setText("analyze");
        scan_syn_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scan_syn_btnMouseClicked(evt);
            }
        });

        clear_text_btn2.setText("clear_text");
        clear_text_btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear_text_btn2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout center_panelLayout = new javax.swing.GroupLayout(center_panel);
        center_panel.setLayout(center_panelLayout);
        center_panelLayout.setHorizontalGroup(
            center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(center_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(center_panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, center_panelLayout.createSequentialGroup()
                                .addComponent(scan_lex_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(clear_text_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, center_panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lex_label)
                        .addGap(148, 148, 148)
                        .addComponent(scan_syn_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clear_text_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, center_panelLayout.createSequentialGroup()
                    .addContainerGap(262, Short.MAX_VALUE)
                    .addComponent(lex_label1)
                    .addGap(247, 247, 247)))
        );
        center_panelLayout.setVerticalGroup(
            center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(center_panelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scan_lex_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear_text_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(scan_syn_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clear_text_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lex_label))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(center_panelLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(lex_label1)
                    .addContainerGap(249, Short.MAX_VALUE)))
        );

        bg_panel.add(center_panel, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void open_file_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_open_file_btnMouseClicked
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        File file = new File(jfc.getSelectedFile().getAbsolutePath());
        
        try {
            String st = new String(Files.readAllBytes(file.toPath()));
            txt_input.setText(st);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_open_file_btnMouseClicked

    private void scan_lex_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scan_lex_btnMouseClicked
        try {
            analyzeLex();
        } catch (IOException ex) {
            Logger.getLogger(LexSyntazer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_scan_lex_btnMouseClicked

    private void scan_syn_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scan_syn_btnMouseClicked
        String st = txt_input.getText();
        Syntax syn = new Syntax(new code.LexerCup(new StringReader(st)));
        
        try {
            syn.parse();
            txt_syn_output.setText("Analysis Successful!");
            txt_syn_output.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = syn.getS();
            txt_syn_output.setText("Syntax error in line " + (sym.right + 1) + " column " + (sym.left + 1) + ", message: \"" + sym.value + "\"");
            txt_syn_output.setForeground(Color.RED);
        }
    }//GEN-LAST:event_scan_syn_btnMouseClicked

    private void clear_text_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_text_btn1MouseClicked
        txt_lex_output.setText(null);
    }//GEN-LAST:event_clear_text_btn1MouseClicked

    private void clear_text_btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_text_btn2MouseClicked
        txt_syn_output.setText(null);
    }//GEN-LAST:event_clear_text_btn2MouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LexSyntazer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LexSyntazer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LexSyntazer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LexSyntazer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LexSyntazer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_panel;
    private javax.swing.JPanel center_panel;
    private javax.swing.JLabel clear_text_btn1;
    private javax.swing.JLabel clear_text_btn2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lex_label;
    private javax.swing.JLabel lex_label1;
    private javax.swing.JPanel north_panel;
    private javax.swing.JLabel open_file_btn;
    private javax.swing.JLabel scan_lex_btn;
    private javax.swing.JLabel scan_syn_btn;
    private javax.swing.JPanel south_panel;
    private javax.swing.JLabel title_label;
    private javax.swing.JTextArea txt_input;
    private javax.swing.JTextArea txt_lex_output;
    private javax.swing.JTextArea txt_syn_output;
    // End of variables declaration//GEN-END:variables
}
